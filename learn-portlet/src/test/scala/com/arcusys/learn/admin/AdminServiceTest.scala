package com.arcusys.learn.admin

/**
 * Created by Iliya Tryapitsin on 24.02.14.
 */

import org.junit.runner.RunWith
import org.scalatra.test.scalatest.ScalatraFlatSpec
import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory
import org.mockito.{Matchers, Mockito}
import com.arcusys.learn.test.mocks.MockInjectableFactory
import com.arcusys.learn.service.util.SessionHandlerContract
import com.arcusys.learn.admin.service.AdminService
import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage
import com.arcusys.learn.models.LrsSettingsRequest
import com.arcusys.learn.tincan.model.lrsClient.{LrsEndpointSettings, AuthorizationType}
import org.apache.oltu.oauth2.common.OAuth
import javax.servlet.http.{HttpServletResponse, HttpServletRequest, Cookie}

//
// Created by iliya.tryapitsin on 13.02.14.
//
@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class AdminServiceTest extends ScalatraFlatSpec with MockFactory with ProxyMockFactory with MockInjectableFactory {
  val tincanLrsEndpointStorage = Mockito.mock(classOf[TincanLrsEndpointStorage])
  val sessionHandlerContract = Mockito.mock(classOf[SessionHandlerContract])

  bindingModule.modifyBindings(module => {
    module.bind[SessionHandlerContract] toSingle sessionHandlerContract
    module.bind[TincanLrsEndpointStorage] toSingle tincanLrsEndpointStorage

    addServlet(new AdminService(module), "/*")
  })

  val endPointPath = "test path"
  val clientId = "Test login"
  val clientSecret = "Test password"
  val testLogin = "Test login"
  val testPswd = "Test password"

  Mockito
    .stub(sessionHandlerContract.getAttribute(
      Matchers.any[Array[Cookie]],
      Matchers.eq("isAdmin")))
    .toReturn(true)

  /*Mockito
    .stub(tincanLrsEndpointStorage.set(Matchers.any[Option[LrsEndpointSettings]]))
    .toReturn(Unit)*/

  "AdminService" should "save Basic LRS settings" in {

    val params = Map[String, String](
      LrsSettingsRequest.IS_EXTERNAL_LRS -> true.toString,
      LrsSettingsRequest.AUTH_TYPE -> AuthorizationType.BASIC.toString,
      LrsSettingsRequest.END_POINT -> endPointPath,
      LrsSettingsRequest.COMMON_CREDENTIALS -> true.toString,
      LrsSettingsRequest.COMMON_CREDENTIALS_LOGIN -> testLogin,
      LrsSettingsRequest.COMMON_CREDENTIALS_PASSWORD -> testPswd)

    val headers = Map[String, String]()

    post("/TincanLrsSettings", params = params, headers = headers){
      Mockito
        .verify(tincanLrsEndpointStorage)
        .set(Matchers.any[Option[LrsEndpointSettings]]())
    }
  }

  "AdminService" should "save OAuth LRS settings" in {

    val params = Map[String, String](
      LrsSettingsRequest.IS_EXTERNAL_LRS -> true.toString,
      LrsSettingsRequest.AUTH_TYPE -> AuthorizationType.OAUTH.toString,
      LrsSettingsRequest.END_POINT -> endPointPath,
      LrsSettingsRequest.COMMON_CREDENTIALS -> false.toString,
      OAuth.OAUTH_CLIENT_ID -> clientId,
      OAuth.OAUTH_CLIENT_SECRET -> clientSecret)

    val headers = Map[String, String]("COOKIE" -> "isAdmin=true")

    post("/TincanLrsSettings", params = params, headers = headers) {
     /* Mockito
        .verify(tincanLrsEndpointStorage)
        .set(Matchers.any[Option[LrsEndpointSettings]]())*/
    }
  }

  "AdminService" should "turn off settings" in {

    val params = Map[String, String](LrsSettingsRequest.IS_EXTERNAL_LRS -> false.toString)

    val headers = Map[String, String]()

    post("/TincanLrsSettings", params = params, headers = headers) {
      Mockito
        .verify(tincanLrsEndpointStorage)
        .set(Matchers.eq(None))
    }
  }
}