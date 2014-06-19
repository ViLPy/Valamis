package com.arcusys.learn.controllers.oauth

import org.apache.oltu.oauth2.as.request.{ OAuthRequest }
import com.arcusys.learn.controllers.oauth.utils.{ RSASHA1Generator, HMACSHA1Generator, SignatureGenerator }
import org.apache.oltu.oauth2.common.OAuth
import com.arcusys.scorm.lms.ClientApiStoreManagerContract
import javax.servlet.http.HttpServletRequest
import com.arcusys.learn.web.ServletBase
import java.net.URLEncoder

//
// Created by iliya.tryapitsin on 14.02.14.
//
trait SignatureValidator extends ServletBase {
  val clientApiStoreManager = inject[ClientApiStoreManagerContract]

  def verifyRequest(oauthRequest: OAuthRequest)(implicit request: HttpServletRequest): Boolean = {
    val query = multiParams
      .filter({ case (key, value) => key != "oauth_signature" })
      .map({ case (key, value) => "%s=%s".format(key, value.head) })
      .toSeq
      .sortBy((k) => k)
      .mkString("", "&", "")

    val baseString = "%s&%s&%s".format(
      request.getMethod.toUpperCase(),
      URLEncoder.encode(request.getRequestURL()
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
    val oauthSignatureMethod = parameter(OAuth.OAUTH_VERSION_DIFFER)
      .required
      .toUpperCase()

    oauthSignatureMethod match {
      case "HMAC-SHA1" => new HMACSHA1Generator()
      case "RSA-SHA1"  => new RSASHA1Generator()
    }
  }
}
