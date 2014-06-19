package com.arcusys.learn.controllers

/**
 * Created by Iliya Tryapitsin on 24.02.14.
 */

import org.junit.runner.RunWith
import org.scalatra.test.scalatest.{ ScalatraSuite, ScalatraFlatSpec }
import org.scalamock.scalatest.MockFactory
import org.mockito.{ Matchers, Mockito }
import com.arcusys.learn.test.mocks.MockInjectableFactory
import com.arcusys.learn.service.util.SessionHandlerContract
import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage
import com.arcusys.learn.tincan.model.lrsClient.{ AuthorizationType }
import org.apache.oltu.oauth2.common.OAuth
import javax.servlet.http.Cookie
import com.arcusys.learn.models.request.AdminRequest
import com.arcusys.learn.setting.storage.SettingStorage
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.tincan.model.lrsClient.LrsEndpointSettings
import org.scalamock.proxy.ProxyMockFactory
import org.scalatest.FlatSpec
import com.arcusys.learn.controllers.api.AdminApiController

//
// Created by iliya.tryapitsin on 13.02.14.
//
@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class AdminControllerTest extends FlatSpec with ScalatraSuite with MockFactory with ProxyMockFactory with MockInjectableFactory {
  val tincanLrsEndpointStorage = Mockito.mock(classOf[TincanLrsEndpointStorage])
  val sessionHandlerContract = Mockito.mock(classOf[SessionHandlerContract])
  val settingStorage = Mockito.mock(classOf[SettingStorage])
  val storageFactory = Mockito.mock(classOf[StorageFactoryContract])
  //val socialActivityLocalServiceHelper = new org.scalamock.annotation.mockObject(SocialActivityLocalServiceHelper)

  bindingModule.modifyBindings(module => {
    module.bind[SessionHandlerContract] toSingle sessionHandlerContract
    module.bind[TincanLrsEndpointStorage] toSingle tincanLrsEndpointStorage
    module.bind[SettingStorage] toSingle settingStorage
    module.bind[StorageFactoryContract] toSingle storageFactory

    addServlet(new AdminApiController(module), "")
  })

  val endPointPath = "test path"
  val clientId = "Test login"
  val clientSecret = "Test password"
  val testLogin = "Test login"
  val testPswd = "Test password"

  "AdminController" should "save Basic LRS settings" in {
    Mockito.reset(sessionHandlerContract)
    Mockito.reset(tincanLrsEndpointStorage)

    Mockito
      .stub(sessionHandlerContract.getAttribute(
        Matchers.any[Array[Cookie]],
        Matchers.eq("isAdmin")))
      .toReturn(true)

    val params = Map[String, String](
      AdminRequest.IS_EXTERNAL_LRS -> true.toString,
      AdminRequest.AUTH_TYPE -> AuthorizationType.BASIC.toString,
      AdminRequest.END_POINT -> endPointPath,
      AdminRequest.COMMON_CREDENTIALS -> true.toString,
      AdminRequest.COMMON_CREDENTIALS_LOGIN -> testLogin,
      AdminRequest.COMMON_CREDENTIALS_PASSWORD -> testPswd)

    val headers = Map[String, String]()

    post("/TincanLrsSettings", params = params, headers = headers) {
      Mockito
        .verify(tincanLrsEndpointStorage)
        .set(Matchers.any[Option[LrsEndpointSettings]]())
    }
  }

  "AdminController" should "save OAuth LRS settings" in {

    Mockito.reset(sessionHandlerContract)
    Mockito.reset(tincanLrsEndpointStorage)

    Mockito
      .stub(sessionHandlerContract.getAttribute(
        Matchers.any[Array[Cookie]],
        Matchers.eq("isAdmin")))
      .toReturn(true)

    val params = Map[String, String](
      AdminRequest.IS_EXTERNAL_LRS -> true.toString,
      AdminRequest.AUTH_TYPE -> AuthorizationType.OAUTH.toString,
      AdminRequest.END_POINT -> endPointPath,
      AdminRequest.COMMON_CREDENTIALS -> false.toString,
      OAuth.OAUTH_CLIENT_ID -> clientId,
      OAuth.OAUTH_CLIENT_SECRET -> clientSecret)

    val headers = Map[String, String]("COOKIE" -> "isAdmin=true")

    post("/TincanLrsSettings", params = params, headers = headers) {
      Mockito
        .verify(tincanLrsEndpointStorage)
        .set(Matchers.any[Option[LrsEndpointSettings]]())
    }
  }

  "AdminController" should "turn off settings" in {
    Mockito.reset(sessionHandlerContract)
    Mockito.reset(tincanLrsEndpointStorage)

    Mockito
      .stub(sessionHandlerContract.getAttribute(
        Matchers.any[Array[Cookie]],
        Matchers.eq("isAdmin")))
      .toReturn(true)

    val params = Map[String, String](AdminRequest.IS_EXTERNAL_LRS -> false.toString)

    val headers = Map[String, String]()

    post("/TincanLrsSettings", params = params, headers = headers) {
      Mockito
        .verify(tincanLrsEndpointStorage)
        .set(Matchers.eq(None))
    }
  }

  //  "AdminController" should "renew database" in {
  //    val params = Map[String, String](AdminRequest.ACTION -> AdminActionType.RENEW_DATABASE.toString)
  //
  //    val headers = Map[String, String]()
  //
  //    post("/", params = params, headers = headers){
  //      Mockito
  //        .verify(storageFactory)
  //        .
  //    }
  //  }
  //
  //  "AdminController" should "update issuer settings" in {
  //    Mockito.reset(sessionHandlerContract)
  //    Mockito.reset(tincanLrsEndpointStorage)
  //    Mockito.reset(settingStorage)
  //
  //    Mockito
  //      .stub(sessionHandlerContract.getAttribute(
  //        Matchers.any[Array[Cookie]],
  //        Matchers.eq("isAdmin")))
  //      .toReturn(true)
  //
  //    val issueName = "issueName"
  //    val issuerOrganization = "issuerOrganization"
  //    val issuerUrl = "issuerUrl"
  //
  //    val params = Map[String, String](
  //      AdminRequest.ACTION -> AdminActionType.UPDATE_ISSUER_SETTINGS.toString,
  //      AdminRequest.ISSUER_NAME -> issueName,
  //      AdminRequest.ISSUER_ORGANIZATION -> issuerOrganization,
  //      AdminRequest.ISSUER_URL -> issuerUrl)
  //
  //    val headers = Map[String, String]()
  //
  //    post("/", params = params, headers = headers) {
  //      Mockito
  //        .verify(settingStorage)
  //        .modify(
  //          Matchers.eq(SettingType.IssuerName),
  //          Matchers.eq(issueName))
  //
  //      Mockito
  //        .verify(settingStorage)
  //        .modify(
  //          Matchers.eq(SettingType.IssuerOrganization),
  //          Matchers.eq(issuerOrganization))
  //
  //      Mockito
  //        .verify(settingStorage)
  //        .modify(
  //          Matchers.eq(SettingType.IssuerURL),
  //          Matchers.eq(issuerUrl))
  //    }
  //  }
}
