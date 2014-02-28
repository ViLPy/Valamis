package com.arcusys.learn.scorm.rte.service

import com.arcusys.learn.scorm.tracking.model.ActivityStateTree
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import java.net.{HttpURLConnection, URL, URLEncoder, URLDecoder}
import com.arcusys.learn.scorm.manifest.model.{ResourceUrl, LeafActivity}
import com.arcusys.scorm.util.FileSystemUtil
import com.arcusys.learn.scorm.tracking.model.sequencing._
import javax.xml.bind.DatatypeConverter
import com.arcusys.learn.tincan.model.lrsClient.{OAuthAuthorization, LrsEndpointSettings, CommonBasicAuthorization, UserBasicAuthorization}
import org.apache.oltu.oauth2.common.{OAuth}
import org.apache.oltu.oauth2.client.{URLConnectionClient, OAuthClient}
import org.apache.oltu.oauth2.client.request.OAuthClientRequest
import org.apache.oltu.oauth2.common.message.types.{GrantType, ResponseType}
import com.arcusys.learn.oauth.utils.HMACSHA1Generator
import org.apache.oltu.oauth2.client.response.{OAuthClientResponse, OAuthJSONAccessTokenResponse}
import scala.collection.JavaConverters._
import com.arcusys.learn.models.TincanOAuthResponse
import org.apache.oltu.oauth2.common.utils.OAuthUtils
import java.io.{IOException, InputStream, PrintWriter, OutputStream}
import org.apache.oltu.oauth2.common.exception.OAuthSystemException
import com.arcusys.scala.json.Json

class SequencingService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  // get possible navigation types, check which navigation controls should be hidden
  get("/NavigationRules/:packageID/:currentScormActivityID") {
    val packageID = parameter("packageID").intRequired
    val activityID = parameter("currentScormActivityID").required
    val activity = activityStorage.get(packageID, activityID)
    json("hiddenUI" -> activity.getOrElse(throw new Exception("Activity not found!")).hiddenNavigationControls.map(_.toString))
  }

  post("/Tincan/:packageID") {
    val userID = try {
      parameter("scormUserID").required.toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests
    val packageID = parameter("packageID").intRequired

    val tincanPackage = tincanPackageStorage.getByID(packageID)
    if(!tincanPackage.isDefined)
      throw new UnsupportedOperationException()
    val activities = tincanActivityStorage.getByPackageID(packageID)
    val firstActivity = activities.find(a => a.launch != null && !a.launch.isEmpty).getOrElse(throw new UnsupportedOperationException("tincan package without launch not supported"))

    val mainFileName = "data/" + tincanPackage.get.id + "/" + firstActivity.launch.get

    tincanLrsEndpointStorage.get match {
      case Some(LrsEndpointSettings(null, _ )) => {
        json(Map("" +
          "internal" -> true,
          "launchURL" -> mainFileName,
          "authType" -> "Basic",
          "auth" -> ("Basic " + DatatypeConverter.printBase64Binary(("loginName" + ":" + "password").toCharArray.map(_.toByte)))
        ))
      }
      case Some(LrsEndpointSettings(endpoint, OAuthAuthorization(clientId, clientSecret))) => {

        val requestToken = getRequestToken(endpoint + "oauth/", clientId, clientSecret)
        val token = getAccessToke(endpoint + "oauth/", clientId, clientSecret, requestToken)

        json(Map(
          "launchURL" -> mainFileName,
          "authType" -> "OAuth",
          "clientSecret" -> clientSecret,
          "endpoint" -> (if(endpoint==null) "" else endpoint.trim),
          "auth" -> ("%s %s".format(OAuth.OAUTH_HEADER_NAME, token))
        ))
      }
      case Some(LrsEndpointSettings(endpoint, CommonBasicAuthorization(loginName, password))) => {
        json(Map(
          "launchURL" -> mainFileName,
          "endpoint" -> (if(endpoint==null) "" else endpoint.trim),
          "authType" -> "Basic",
          "auth" -> ("Basic " + DatatypeConverter.printBase64Binary((loginName + ":" + password).toCharArray.map(_.toByte)))
        ))
      }
      case Some(LrsEndpointSettings(endpoint, UserBasicAuthorization)) => {
        json(Map(
          "launchURL" -> mainFileName,
          "endpoint" -> (if(endpoint==null) "" else endpoint.trim),
          "authType" -> "Basic"
        ))
      }
      case None =>{
        json(Map("" +
          "internal" -> true,
          "launchURL" -> mainFileName,
          "authType" -> "Basic",
          "auth" -> ("Basic " + DatatypeConverter.printBase64Binary(("loginName" + ":" + "password").toCharArray.map(_.toByte)))
        ))
      }
      case _ => throw new UnsupportedOperationException()
    }
  }

  get("/NavigationRequest/:currentScormPackageID/:currentOrganizationID/:sequencingRequest") {
    val userID = try {
      parameter("scormUserID").required.toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests

    if (userID > 0 && getSessionUserID != userID) halt(401, userID + " not found")

    val packageID = parameter("currentScormPackageID").intRequired
    val organizationID = parameter("currentOrganizationID").required

    val currentAttempt = attemptStorage.getActive(userID, packageID) match {
      case Some(attempt) => attempt
      case None => {
        attemptStorage.createAndGetID(userID, packageID, organizationID)
        attemptStorage.getActive(userID, packageID).getOrElse(halt(404, "Okay. Check DB connection."))
      }
    }
    if (activityStateTreeStorage.get(currentAttempt.id).isEmpty) {
      val stateTree = ActivityStateTree(activityStorage.getOrganizationTree(currentAttempt.packageID, currentAttempt.organizationID), None, true, None)
      activityStateTreeStorage.create(currentAttempt.id, stateTree)
    }
    val treeOption = activityStateTreeStorage.get(currentAttempt.id)
    require(treeOption.isDefined, "Tree should exist!")
    //val currentAttempt = attemptStorage.getActive(userID, packageID).getOrElse(halt(404, "Attempt not found for this SCO and user"))
    val processor = new SequencingProcessor(currentAttempt, treeOption.get)

    val sequencingRequest = URLDecoder.decode(parameter("sequencingRequest").required, "UTF-8")

    val jsonData = json(processor.process(sequencingRequest) match {
      case ProcessorResponseDelivery(tree) => {
        activityStateTreeStorage.modify(currentAttempt.id, tree)
        val currentActivityID = tree.currentActivity.map(_.item.activity.id).getOrElse("")
        Map("currentActivity" -> currentActivityID, "endSession" -> false) ++ getActivityData(packageID, currentActivityID)
      }
      case ProcessorResponseEndSession(tree) => {
        activityStateTreeStorage.modify(currentAttempt.id, tree)
        attemptStorage.markAsComplete(currentAttempt.id)
        val currentActivityID = tree.currentActivity.map(_.item.activity.id).getOrElse("")
        Map("currentActivity" -> currentActivityID, "endSession" -> true) ++ getActivityData(packageID, currentActivityID)
      }
    })

    contentType = "text/html"
    val headScriptData = scala.xml.Unparsed(
      """
        function findPlayerView(win) {
          var findPlayerTries = 0;
          while ((win.scormPlayerView == null) && (win.parent != null) && (win.parent != win)) {
            findPlayerTries++;
            if (findPlayerTries > 20) return null;
            win = win.parent;
          }
          return win.scormPlayerView;
        }

        function getPlayerView() {
          var thePlayer = findPlayerView(window);
          if ((thePlayer == null)) {
            if ((window.opener != null) && (typeof(window.opener) != "undefined"))
              thePlayer = thePlayer(window.opener);
            }
          return thePlayer;
        }
        function init(){
          getPlayerView().loadView(""" + jsonData + """);
        }""")
    <html>
      <head>
        <script language="javascript">
          {headScriptData}
        </script>
      </head>
      <body onload="init()"></body>
    </html>
  }

  private def getActivityData(packageID: Int, id: String): Map[String, Any] = {
    val activityOption = activityStorage.get(packageID, id)
    if (activityOption.isDefined) {
      val activity = activityOption.get
      if (activity.isInstanceOf[LeafActivity]) {
        val leafActivity = activity.asInstanceOf[LeafActivity]
        val resource = resourceStorage.getByID(packageID, leafActivity.resourceIdentifier).get
        val manifest = packageStorage.getByID(packageID).get

        val resultedURL = if (resource.href.get.startsWith("http://") || resource.href.get.startsWith("https://")) {
          resource.href.get
        } else {
          val manifestRelativeResourceUrl = ResourceUrl(manifest.base, manifest.resourcesBase, resource.base, resource.href.get, leafActivity.resourceParameters)
          servletContext.getContextPath + "/" + FileSystemUtil.contextRelativeResourceURL(packageID, manifestRelativeResourceUrl)
        }
        Map("activityURL" -> resultedURL,
          "hiddenUI" -> leafActivity.hiddenNavigationControls.map(_.toString))
      } else Map()
    } else Map()
  }

  post("/setSession") {
    request.getSession.setAttribute("packageId", params("id"))
    request.getSession.setAttribute("packageType", params("type"))
    request.getSession.setAttribute("packageTitle", params("title"))
    request.getSession.setAttribute("playerID", params("playerID"))
  }
  post("/clearSession") {
    request.getSession.removeAttribute("packageId")
    request.getSession.removeAttribute("packageType")
    request.getSession.removeAttribute("packageTitle")
    request.getSession.removeAttribute("playerID")
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
        }
        else {
          httpURLConnection.setRequestMethod(OAuth.HttpMethod.GET)
        }
        httpURLConnection.connect
        var inputStream: InputStream = null
        val responseCode = httpURLConnection.getResponseCode
        if (responseCode == 400 || responseCode == 401) {
          inputStream = httpURLConnection.getErrorStream
        }
        else {
          inputStream = httpURLConnection.getInputStream
        }
        OAuthUtils.saveStreamAsString(inputStream)
      } else {
        ""
      }
    }
    catch {
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
      case (key, value) => "%s=%s".format (key, value)
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

    val resp = Json.toObject(result)

    val token: String = if(resp.isInstanceOf[Map[String, Any]])
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
      case (key, value) => "%s=%s".format (key, value)
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

    val resp = Json.toObject(result)

    val token: String = if(resp.isInstanceOf[Map[String, Any]])
      resp.asInstanceOf[Map[String, Any]](OAuth.OAUTH_ACCESS_TOKEN).toString
    else ""

    return token
  }
}
