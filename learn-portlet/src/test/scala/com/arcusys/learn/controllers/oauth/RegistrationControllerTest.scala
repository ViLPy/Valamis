package com.arcusys.learn.controllers.oauth

import org.junit.runner.RunWith
import org.scalatra.test.scalatest.{ ScalatraSuite, ScalatraFlatSpec }
import org.scalamock.scalatest.MockFactory
import org.mockito._
import com.arcusys.learn.test.mocks.MockInjectableFactory
import org.apache.oltu.oauth2.ext.dynamicreg.common.OAuthRegistration
import javax.servlet.http.HttpServletResponse
import com.arcusys.learn.service.util.SessionHandlerContract
import org.apache.oltu.oauth2.ext.dynamicreg.server.response.OAuthServerRegistrationResponse
import com.arcusys.learn.tincan.model.{ LrsScope }
import com.arcusys.scorm.lms.ClientApiStoreManagerContract
import com.arcusys.learn.tincan.model.lrsServer.ClientApiModel
import org.scalamock.proxy.ProxyMockFactory
import org.junit.Ignore
import org.scalatest.FlatSpec

//
// Created by iliya.tryapitsin on 12.02.14.
//
@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class RegistrationControllerTest extends FlatSpec with ScalatraSuite with MockFactory with ProxyMockFactory with MockInjectableFactory {
  val clientApiStoreManager = Mockito.mock(classOf[ClientApiStoreManagerContract])
  val sessionHandlerContract = Mockito.mock(classOf[SessionHandlerContract])

  bindingModule.modifyBindings(module => {
    module.bind[ClientApiStoreManagerContract] toSingle clientApiStoreManager
    module.bind[SessionHandlerContract] toSingle sessionHandlerContract

    addServlet(new RegistrationApiController(module), "/*")
  })

  "RegistrationController" should "make registration" in {
    val clientAppName = "ClientContent.APP_NAME"
    val clientAppRedirectUrl = "ClientContent.APP_REDIRECT_URI"
    val clientAppIcon = "ClientContent.APP_ICON"
    val clientAppDescription = "ClientContent.APP_DESCRIPTION"
    val clientAppUrl = "ClientContent.APP_URL"
    val clientId: Long = 123
    val clientSharedSecret = "SHARED_SECRET"
    val clientIssuedAt = "ISSUED_AT"
    val clientExpiredIn = 123456

    // Request params
    val params = Map[String, String](
      OAuthRegistration.Request.REDIRECT_URL -> clientAppRedirectUrl,
      OAuthRegistration.Request.CLIENT_ICON -> clientAppIcon,
      OAuthRegistration.Request.CLIENT_DESCRIPTION -> clientAppDescription,
      OAuthRegistration.Request.TYPE -> OAuthRegistration.Type.PUSH,
      OAuthRegistration.Request.CLIENT_NAME -> clientAppName,
      OAuthRegistration.Request.CLIENT_URL -> clientAppUrl,
      LrsScope.OAuth.NAME -> LrsScope.All.toString())
    val headers = Map[String, String]()

    Mockito
      .when(clientApiStoreManager.registration(
        clientAppName,
        Option(clientAppDescription),
        Option(clientAppUrl),
        Option(clientAppRedirectUrl),
        LrsScope.All,
        Option(clientAppIcon)))
      .thenReturn(new ClientApiModel(
        clientId.toString,
        clientSharedSecret,
        clientAppName,
        clientIssuedAt,
        clientExpiredIn,
        LrsScope.All))

    // Request
    post("/", params = params, headers = headers) {

      Mockito
        .verify(clientApiStoreManager)
        .registration(
          clientAppName,
          Option(clientAppDescription),
          Option(clientAppUrl),
          Option(clientAppRedirectUrl),
          LrsScope.All,
          Option(clientAppIcon))

      val expectedResponse = OAuthServerRegistrationResponse
        .status(HttpServletResponse.SC_OK)
        .setParam("clientId", clientId.toString)
        .setParam("clientSecret", clientSharedSecret)
        .setParam("clientName", clientAppName)
        .buildJSONMessage()

      body should equal(expectedResponse.getBody())

      status should equal(HttpServletResponse.SC_OK)
    }
  }
}
