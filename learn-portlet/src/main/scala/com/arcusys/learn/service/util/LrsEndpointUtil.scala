package com.arcusys.learn.service.util

import com.arcusys.learn.tincan.model.lrsClient.{ UserBasicAuthorization, CommonBasicAuthorization, OAuthAuthorization, LrsEndpointSettings }
import javax.xml.bind.DatatypeConverter
import org.apache.oltu.oauth2.common.OAuth
import org.apache.oltu.oauth2.client.request.OAuthClientRequest
import java.net.{ URLEncoder, HttpURLConnection, URL }
import org.apache.oltu.oauth2.common.utils.OAuthUtils
import java.io.{ IOException, InputStream, PrintWriter, OutputStream }
import org.apache.oltu.oauth2.common.exception.OAuthSystemException
import org.apache.oltu.oauth2.common.message.types.{ GrantType, ResponseType }
import com.arcusys.learn.controllers.oauth.utils.HMACSHA1Generator
import com.arcusys.learn.util.JsonSupport

class LrsEndpointUtil extends JsonSupport {
  def getEnpointData(settings: Option[LrsEndpointSettings]) = {
    settings match {
      case Some(LrsEndpointSettings(null, _)) => {
        Map(
          "internal" -> true,
          "authType" -> "Basic",
          "auth" -> ("Basic " + DatatypeConverter.printBase64Binary(("loginName" + ":" + "password").toCharArray.map(_.toByte)))
        )
      }
      case Some(LrsEndpointSettings(endpoint, OAuthAuthorization(clientId, clientSecret))) => {

        val requestToken = getRequestToken(endpoint + "oauth/", clientId, clientSecret)
        val token = getAccessToke(endpoint + "oauth/", clientId, clientSecret, requestToken)

        Map(
          "authType" -> "OAuth",
          "clientSecret" -> clientSecret,
          "endpoint" -> (if (endpoint == null) "" else endpoint.trim),
          "auth" -> ("%s %s".format(OAuth.OAUTH_HEADER_NAME, token))
        )
      }
      case Some(LrsEndpointSettings(endpoint, CommonBasicAuthorization(loginName, password))) => {
        Map(
          "endpoint" -> (if (endpoint == null) "" else endpoint.trim),
          "authType" -> "Basic",
          "auth" -> ("Basic " + DatatypeConverter.printBase64Binary((loginName + ":" + password).toCharArray.map(_.toByte)))
        )
      }
      case Some(LrsEndpointSettings(endpoint, UserBasicAuthorization)) => {
        Map(
          "endpoint" -> (if (endpoint == null) "" else endpoint.trim),
          "authType" -> "Basic"
        )
      }
      case None => {
        Map(
          "internal" -> true,
          "authType" -> "Basic",
          "auth" -> ("Basic " + DatatypeConverter.printBase64Binary(("loginName" + ":" + "password").toCharArray.map(_.toByte)))
        )
      }
      case _ => throw new UnsupportedOperationException()
    }
  }

  private def connectTo(request: OAuthClientRequest,
    headers: Map[String, String],
    requestMethod: String): String = {
    try {
      val url: URL = new URL(request.getLocationUri)
      val c = url.openConnection

      if (c.isInstanceOf[HttpURLConnection]) {
        val httpURLConnection: HttpURLConnection = c.asInstanceOf[HttpURLConnection]
        if (headers != null && !headers.isEmpty) {
          import scala.collection.JavaConversions._
          for (header <- headers.entrySet) {
            httpURLConnection.addRequestProperty(header.getKey, header.getValue)
          }
        }
        if (request.getHeaders != null) {
          import scala.collection.JavaConversions._
          for (header <- request.getHeaders.entrySet) {
            httpURLConnection.addRequestProperty(header.getKey, header.getValue)
          }
        }
        if (!OAuthUtils.isEmpty(requestMethod)) {
          httpURLConnection.setRequestMethod(requestMethod)
          if (requestMethod == OAuth.HttpMethod.POST) {
            httpURLConnection.setDoOutput(true)
            val ost: OutputStream = httpURLConnection.getOutputStream
            val pw: PrintWriter = new PrintWriter(ost)
            pw.print(request.getBody)
            pw.flush
            pw.close
          }
        } else {
          httpURLConnection.setRequestMethod(OAuth.HttpMethod.GET)
        }
        httpURLConnection.connect
        var inputStream: InputStream = null
        val responseCode = httpURLConnection.getResponseCode
        if (responseCode == 400 || responseCode == 401) {
          inputStream = httpURLConnection.getErrorStream
        } else {
          inputStream = httpURLConnection.getInputStream
        }
        OAuthUtils.saveStreamAsString(inputStream)
      } else {
        ""
      }
    } catch {
      case e: IOException => {
        throw new OAuthSystemException(e)
      }
    }
  }

  private def getRequestToken(endpoint: String,
    clientId: String,
    clientSecret: String): String = {

    val initiateEndpoint = endpoint + "initiate"
    val oAuthRequest = OAuthClientRequest
      .authorizationLocation(initiateEndpoint)
      .setClientId(clientId)
      .setResponseType(ResponseType.CODE.toString)
      .setParameter(OAuth.OAUTH_VERSION_DIFFER, "HMAC-SHA1")

    val params = Map[String, String](
      OAuth.OAUTH_CLIENT_ID -> clientId.toString,
      OAuth.OAUTH_RESPONSE_TYPE -> ResponseType.CODE.toString(),
      OAuth.OAUTH_VERSION_DIFFER -> "HMAC-SHA1")

    val p = params
      .map({
        case (key, value) => "%s=%s".format(key, value)
      })
      .toSeq
      .sortBy((k) => k)
      .mkString("", "&", "")

    val baseString = "%s&%s&%s".format(
      "POST".toUpperCase(),
      URLEncoder.encode(initiateEndpoint.toLowerCase(), "UTF-8"),
      URLEncoder.encode(p, "UTF-8"))

    val generator = new HMACSHA1Generator()
    val signature = generator.generateValue(baseString, clientSecret)

    oAuthRequest.setParameter("oauth_signature", signature)

    val result = connectTo(oAuthRequest.buildBodyMessage(), Map[String, String](), "POST")

    val resp = parseJson[Any](result)

    val token: String = if (resp.isInstanceOf[Map[String, Any]])
      resp.asInstanceOf[Map[String, Any]]("code").toString
    else ""

    return token
  }

  private def getAccessToke(endpoint: String,
    clientId: String,
    clientSecret: String,
    requestToken: String): String = {

    val tokenEndpoint = endpoint + "token"
    val oAuthRequest = OAuthClientRequest
      .authorizationLocation(tokenEndpoint)
      .setClientId(clientId)
      .setParameter(OAuth.OAUTH_VERSION_DIFFER, "HMAC-SHA1")
      .setParameter(OAuth.OAUTH_GRANT_TYPE, GrantType.AUTHORIZATION_CODE.toString())
      .setParameter(OAuth.OAUTH_CODE, requestToken)

    val params = Map[String, String](
      OAuth.OAUTH_CLIENT_ID -> clientId.toString,
      OAuth.OAUTH_CODE -> requestToken,
      OAuth.OAUTH_GRANT_TYPE -> GrantType.AUTHORIZATION_CODE.toString(),
      OAuth.OAUTH_VERSION_DIFFER -> "HMAC-SHA1")

    val p = params
      .map({
        case (key, value) => "%s=%s".format(key, value)
      })
      .toSeq
      .sortBy((k) => k)
      .mkString("", "&", "")

    val baseString = "%s&%s&%s".format(
      "POST".toUpperCase(),
      URLEncoder.encode(tokenEndpoint.toLowerCase(), "UTF-8"),
      URLEncoder.encode(p, "UTF-8"))

    val generator = new HMACSHA1Generator()
    val signature = generator.generateValue(baseString, clientSecret)

    oAuthRequest.setParameter("oauth_signature", signature)

    val result = connectTo(oAuthRequest.buildBodyMessage(), Map[String, String](), "POST")

    val resp = parseJson[Any](result)

    val token: String = if (resp.isInstanceOf[Map[String, Any]])
      resp.asInstanceOf[Map[String, Any]](OAuth.OAUTH_ACCESS_TOKEN).toString
    else ""

    return token
  }
}
