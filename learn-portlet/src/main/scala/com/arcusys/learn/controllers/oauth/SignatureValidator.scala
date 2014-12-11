package com.arcusys.learn.controllers.oauth

import java.net.URLEncoder
import javax.servlet.http.HttpServletRequest

import com.arcusys.learn.controllers.oauth.utils.{ HMACSHA1Generator, RSASHA1Generator, SignatureGenerator }
import com.arcusys.learn.service.util.Parameter
import com.arcusys.scorm.lms.ClientApiStoreManagerContract
import com.escalatesoft.subcut.inject.Injectable
import org.apache.oltu.oauth2.as.request.OAuthRequest
import org.apache.oltu.oauth2.common.OAuth
import org.scalatra.ScalatraServlet

//
// Created by iliya.tryapitsin on 14.02.14.
//
trait SignatureValidator extends ScalatraServlet with Injectable {
  val clientApiStoreManager = inject[ClientApiStoreManagerContract]
  implicit val _scalatra = this

  def verifyRequest(oauthRequest: OAuthRequest)(implicit request: HttpServletRequest): Boolean = {
    val query = multiParams
      .filter({ case (key, value) => key != "oauth_signature" })
      .map({ case (key, value) => "%s=%s".format(key, value.head) })
      .toSeq
      .sortBy((k) => k)
      .mkString("", "&", "")

    val baseString = "%s&%s&%s".format(
      request.getMethod.toUpperCase(),
      URLEncoder
        .encode(request.getRequestURL()
          .toString()
          .toLowerCase(), "UTF-8"),
      URLEncoder.encode(query, "UTF-8"))

    val signature = oauthRequest.getParam("oauth_signature")
    val clientId = oauthRequest.getClientId().toLong
    val client = clientApiStoreManager.getClientById(clientId)

    val generator = getSignatureGenerator()
    val generatedSignature = generator.generateValue(baseString, client.clientSecret)
    return signature == generatedSignature
  }

  def getSignatureGenerator(): SignatureGenerator = {
    val oauthSignatureMethod = Parameter(OAuth.OAUTH_VERSION_DIFFER)
      .required
      .toUpperCase()

    oauthSignatureMethod match {
      case "HMAC-SHA1" => new HMACSHA1Generator()
      case "RSA-SHA1"  => new RSASHA1Generator()
    }
  }
}
