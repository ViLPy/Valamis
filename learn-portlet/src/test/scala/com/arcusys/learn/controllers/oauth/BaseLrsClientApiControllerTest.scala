package com.arcusys.learn.controllers.oauth

import org.scalamock.scalatest.MockFactory
import org.junit.runner.RunWith
import org.scalatra.test.scalatest.{ ScalatraSuite }
import com.arcusys.learn.test.mocks.MockInjectableFactory
import javax.servlet.http.HttpServletResponse
import org.apache.oltu.oauth2.common.OAuth
import org.mockito.Mockito
import com.arcusys.scorm.lms.ClientApiStoreManagerContract
import com.arcusys.learn.service.util.SessionHandlerContract
import com.arcusys.learn.controllers.oauth.utils.HMACSHA1Generator
import com.arcusys.learn.tincan.model.LrsScope
import com.escalatesoft.subcut.inject.BindingModule
import java.net.URLEncoder
import com.arcusys.learn.tincan.model.lrsServer.ClientApiModel
import org.scalamock.proxy.ProxyMockFactory
import org.scalatest.FlatSpec

//
// Created by iliya.tryapitsin on 04.02.14.
//

class TestApiController(config: BindingModule) extends BaseLrsClientApiApiController(config) {
  get("/") {

  }
}

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class BaseLrsClientApiControllerTest extends FlatSpec with ScalatraSuite with MockFactory with ProxyMockFactory with MockInjectableFactory {

  val clientApiStoreManager = Mockito.mock(classOf[ClientApiStoreManagerContract])
  val sessionHandlerContract = Mockito.mock(classOf[SessionHandlerContract])

  bindingModule.modifyBindings(module => {
    module.bind[ClientApiStoreManagerContract] toSingle clientApiStoreManager
    module.bind[SessionHandlerContract] toSingle sessionHandlerContract

    addServlet(new TestApiController(module), "/*")
  })

  "BaseLrsClientApiController" should "check access token" in {
    val accessToken = "test token"
    val clientName = "Test client"
    val clientId: Long = 123
    val signatureMethodName = "HMAC-SHA1"
    val clientSecret = "CLIENT_SECRET"
    val clientIssuedAt = "ISSUED_AT"
    val expiredIn = 123456

    // Request params
    val params = Map[String, String](
      OAuth.OAUTH_CLIENT_ID -> clientId.toString,
      OAuth.OAUTH_VERSION_DIFFER -> signatureMethodName)

    val authHeader = "%s %s".format(
      OAuth.OAUTH_HEADER_NAME,
      accessToken)

    val headers = Map(OAuth.HeaderType.AUTHORIZATION -> authHeader)

    val generator = new HMACSHA1Generator()
    val p = params
      .map({
        case (key, value) => "%s=%s".format(key, value)
      })
      .toSeq
      .sortBy((k) => k)
      .mkString("", "&", "")

    val baseString = "%s&%s&%s".format(
      "get".toUpperCase(),
      URLEncoder.encode("/", "UTF-8"),
      URLEncoder.encode(p, "UTF-8"))

    val signature = generator.generateValue(baseString, clientSecret)

    Mockito
      .when(clientApiStoreManager.getClientById(clientId))
      .thenReturn(new ClientApiModel(
        clientId.toString,
        clientSecret,
        clientName,
        clientIssuedAt,
        expiredIn,
        LrsScope.All))

    Mockito
      .when(clientApiStoreManager.validate(accessToken))
      .thenReturn(true)

    // Request
    get("/", params = (params ++ Map("oauth_signature" -> signature)).toSeq.sortBy((k) => k), headers = headers) {

      // Check response
      status should not equal (HttpServletResponse.SC_UNAUTHORIZED)
    }
  }

  "BaseLrsClientApiController" should "redirect to the authorization page" in {
    // Request params
    val params = Map[String, String]()
    val headers = Map[String, String]()

    // Request
    get("/", params = params, headers = headers) {

      // Check response
      status should equal(HttpServletResponse.SC_UNAUTHORIZED)
    }
  }
}
