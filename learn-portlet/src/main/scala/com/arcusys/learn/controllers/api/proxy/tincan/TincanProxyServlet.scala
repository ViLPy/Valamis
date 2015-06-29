package com.arcusys.learn.controllers.api.proxy.tincan

import java.io.{BufferedInputStream, InputStream}
import java.net.URL
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

import com.arcusys.learn.controllers.views.ConfigurableView
import com.arcusys.learn.exceptions.NotAuthorizedException
import com.arcusys.learn.liferay.activity.StatementActivityCreator
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.valamis.certificate.service.CertificateCompletionChecker
import com.arcusys.valamis.lrs.model.{AuthConstants, BasicAuthInfo, OAuthAuthInfo}
import com.arcusys.valamis.lrs.service.{ProxyLrsInfo, LrsClientManager}
import com.arcusys.valamis.lrsEndpoint.model.{InternalAuthorization, OAuthAuthorization}
import com.liferay.portal.kernel.servlet.HttpMethods._
import com.liferay.portal.service.ServiceContextThreadLocal
import net.oauth.OAuth.Parameter
import net.oauth._
import net.oauth.client.httpclient4._
import net.oauth.client.{OAuthClient, OAuthResponseMessage}
import net.oauth.http.HttpMessage
import org.apache.commons.io.IOUtils
import org.apache.http.HttpHeaders._

import scala.collection.JavaConverters._

class TincanProxyServlet extends HttpServlet with ConfigurableView {
  private lazy val defaultClient: OAuthClient = new OAuthClient(new HttpClient4)
  private lazy val lrsClientManager = inject[LrsClientManager]
  private lazy val statementActivityCreator = inject[StatementActivityCreator]
  private lazy val certificateCompletionChecker = inject[CertificateCompletionChecker]

  private val XApiVersion = "X-Experience-API-Version"
  private val AllowMethods = "Access-Control-Allow-Methods"
  private val AllowHeaders = "Access-Control-Allow-Headers"
  private val AllowOrigin = "Access-Control-Allow-Origin"
  private val OriginAll = "*"

  override def service(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    try {
      request.getMethod match {
        case OPTIONS => doOptions(request, response)
        case _ => doProxy(request, response)
      }
    } catch {
      case e: NotAuthorizedException => response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage)
      case e: Throwable => response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage)
    }
  }

  override def doOptions(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    resp.setHeader(AllowMethods, s"$HEAD,$GET,$POST,$PUT,$DELETE,$OPTIONS")
    resp.setHeader(AllowHeaders, s"$CONTENT_TYPE,$CONTENT_LENGTH,$AUTHORIZATION,$XApiVersion")
    resp.setHeader(AllowOrigin, OriginAll)
  }

  private def doProxy(request: HttpServletRequest, response: HttpServletResponse) {
    val authHeader = request.getHeader(AUTHORIZATION) match {
      case null => throw new NotAuthorizedException(s"$AUTHORIZATION header not found")
      case a => a.replace(AuthConstants.Basic, "").trim
    }

    val lrsAuthInfo = lrsClientManager.getToken(authHeader)

    val companyId = PortalUtilHelper.getCompanyId(request)
    val settings = lrsClientManager.getLrsSettings

    val context = request.getPathInfo.replace(ProxyLrsInfo.Prefix, "")
    val endpoint = settings.auth match {
      case InternalAuthorization(_, _) =>
        PortalUtilHelper.getLocalHostUrl(companyId) + settings.endpoint.stripSuffix("/")
      case _ =>
        settings.endpoint.stripSuffix("/")
    }

    val url = endpoint + context + "?" + request.getQueryString

    val inputStream = new BufferedInputStream(request.getInputStream)
    val statementString = peekAsString(inputStream)

    val authRequest = new OAuthMessage(request.getMethod, url, null, if (isGetMethod(request.getMethod)) null else inputStream)

    val headersList = authRequest.getHeaders.asScala

    request.getHeaderNames.asScala.toList
      .map(_.toString)
      .filterNot(_.equalsIgnoreCase(AUTHORIZATION))
      .filterNot(h => headersList.exists(_.getKey.equalsIgnoreCase(h)))
      .foreach(name =>
        if (name.equalsIgnoreCase(HOST)) {
          val uri = new URL(url)
          authRequest.getHeaders.add(new Parameter(name, uri.getHost + ':' + uri.getPort))
        } else {
          authRequest.getHeaders.add(new Parameter(name, request.getHeader(name)))
        }
      )

    val style = lrsAuthInfo match {
      case auth: BasicAuthInfo =>
        authRequest.getHeaders.add(new Parameter(AUTHORIZATION, s"${AuthConstants.Basic} ${auth.auth}"))
        ParameterStyle.QUERY_STRING
      case auth: OAuthAuthInfo =>
        settings.auth match {
          case a: OAuthAuthorization =>
            prepareOAuth(authRequest, a.consumerKey, a.consumerSecret, auth.token, auth.tokenSecret, auth.verifier)
          case a: InternalAuthorization =>
            prepareOAuth(authRequest, a.consumerKey, a.consumerSecret, auth.token, auth.tokenSecret, auth.verifier)
          case _: Throwable => throw new IllegalArgumentException
        }
    }

    val authResponse = try {
      defaultClient.access(authRequest, style)
    }
    catch {
      case p: OAuthProblemException => onAuthException(p)
    }

    for {
      authHeader <- authResponse.getHeaders.asScala
      if !response.containsHeader(authHeader.getKey)
    } {
      response.addHeader(authHeader.getKey, authHeader.getValue)
    }
    response.addHeader(AllowOrigin, OriginAll)

    val responseCode = authResponse.getHttpResponse.getStatusCode
    response.setStatus(responseCode)

    val userId = ServiceContextThreadLocal.getServiceContext.getUserId
    statementActivityCreator.create(companyId, statementString, userId)
    certificateCompletionChecker.toggleRequestedCertificatesStatus(userId = Some(userId))

    if (responseCode != HttpServletResponse.SC_NO_CONTENT) {
      copyContent(authResponse, response)
    }
  }

  private def onAuthException(exception: OAuthProblemException): Nothing = {
    val message = new StringBuilder
    
    for(problem <- Option(exception.getProblem))
      message.append(problem)

    val response = exception.getParameters.get(HttpMessage.RESPONSE)
    if (response != null) {
      val separator = System.getProperty("line.separator", "\n")
      message.append(separator).append(response)
    }
    throw new OAuthException(message.toString(), exception)
  }

  private def isGetMethod(method: String) = method.equalsIgnoreCase("GET")

  private def peekAsString(inputStream: InputStream): String = {
    inputStream.mark(0)
    val string = IOUtils.toString(inputStream)
    inputStream.reset()
    string
  }

  private def copyContent(authResponse: OAuthResponseMessage, response: HttpServletResponse): Unit = {
    val writer = response.getWriter
    try {
      // TODO: replace literal to endpoint from database, it can be not related (full)
      val responseBody = authResponse.readBodyAsString().replaceAll("valamis-lrs-portlet/xapi", "delegate/proxy")
      writer.write(responseBody)
      writer.flush()
    } catch {
      case e: Throwable => e.printStackTrace()
    } finally {
      writer.close()
    }
  }

  private def prepareOAuth(authRequest: OAuthMessage, clientId: String, secret: String, accessToken: String,
                           tokenSecret: String, verifier: String) = {
    val consumer = new OAuthConsumer(null, clientId, secret, null)
    val accessor = new OAuthAccessor(consumer)
    accessor.accessToken = accessToken
    accessor.tokenSecret = tokenSecret
    authRequest.addParameter(OAuth.OAUTH_VERIFIER, verifier)
    authRequest.addRequiredParameters(accessor)
    ParameterStyle.AUTHORIZATION_HEADER
  }

  override def destroy(): Unit = {}
}
