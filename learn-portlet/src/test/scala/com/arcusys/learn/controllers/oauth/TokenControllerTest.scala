//package com.arcusys.learn.controllers.oauth
//
//import org.junit.runner.RunWith
//import org.scalatra.test.scalatest.{ ScalatraSuite, ScalatraFlatSpec }
//import org.scalamock.scalatest.MockFactory
//import com.arcusys.learn.test.mocks.MockInjectableFactory
//import org.mockito.{ Matchers, Mockito }
//import com.arcusys.scorm.lms.ClientApiStoreManagerContract
//import com.arcusys.learn.service.util.SessionHandlerContract
//import org.apache.oltu.oauth2.common.OAuth
//import org.apache.oltu.oauth2.common.message.types.GrantType
//import javax.servlet.http.HttpServletResponse
//import com.arcusys.learn.tincan.model.LrsScope
//import com.arcusys.learn.controllers.oauth.utils.HMACSHA1Generator
//import java.net.{ InetAddress, URLEncoder }
//import com.arcusys.learn.tincan.model.lrsServer.ClientApiModel
//import org.scalamock.proxy.ProxyMockFactory
//import org.junit.Ignore
//import org.scalatest.FlatSpec
//
////
//// Created by iliya.tryapitsin on 14.02.14.
////
//@RunWith(classOf[org.scalatest.junit.JUnitRunner])
//class TokenControllerTest extends FlatSpec with ScalatraSuite with MockFactory with ProxyMockFactory with MockInjectableFactory {
//  val clientApiStoreManager = Mockito.mock(classOf[ClientApiStoreManagerContract])
//  val sessionHandlerContract = Mockito.mock(classOf[SessionHandlerContract])
//
//  bindingModule.modifyBindings(module => {
//    module.bind[ClientApiStoreManagerContract] toSingle clientApiStoreManager
//    module.bind[SessionHandlerContract] toSingle sessionHandlerContract
//
//    addServlet(new TokenApiController(module), "/*")
//  })
//
//  "TokenControllerTest" should "take access token" in {
//    val signatureMethodName = "HMAC-SHA1"
//    val clientId: Long = 123
//    val clientName = "test client"
//    val clientFetchToken = "CLIENT_FETCH_TOKEN"
//    val clientSecret = "CLIENT_SECRET"
//    val clientIssuedAt = "ISSUED_AT"
//    val expiredIn = 123456
//
//    Mockito
//      .when(clientApiStoreManager.checkClientFetchCode(clientId, clientFetchToken))
//      .thenReturn(true)
//
//    Mockito
//      .when(clientApiStoreManager.getClientById(clientId))
//      .thenReturn(new ClientApiModel(
//        clientId.toString,
//        clientSecret,
//        clientName,
//        clientIssuedAt,
//        expiredIn,
//        LrsScope.All))
//
//    val params = Map[String, String](
//      OAuth.OAUTH_CLIENT_ID -> clientId.toString,
//      OAuth.OAUTH_CODE -> clientFetchToken,
//      OAuth.OAUTH_GRANT_TYPE -> GrantType.AUTHORIZATION_CODE.toString(),
//      OAuth.OAUTH_VERSION_DIFFER -> signatureMethodName)
//
//    val generator = new HMACSHA1Generator()
//    val p = params
//      .map({
//        case (key, value) => "%s=%s".format(key, value)
//      })
//      .toSeq
//      .sortBy((k) => k)
//      .mkString("", "&", "")
//
//    val localhost = InetAddress.getLocalHost
//
//    val baseString = "%s&%s&%s".format(
//      "post".toUpperCase(),
//      URLEncoder.encode("http://" + localhost.getHostAddress + "/".toLowerCase(), "UTF-8"),
//      URLEncoder.encode(p, "UTF-8"))
//
//    val signature = generator.generateValue(baseString, clientSecret)
//
//    val headers = Map[String, String]()
//
//    post("/", params = (params ++ Map("oauth_signature" -> signature)).toSeq.sortBy((k) => k), headers = headers) {
//      Mockito
//        .verify(clientApiStoreManager)
//        .checkClientFetchCode(clientId, clientFetchToken)
//
//      status should equal(HttpServletResponse.SC_FOUND)
//
//      body should not be ""
//      Mockito
//        .verify(clientApiStoreManager)
//        .setAccessToken(
//          Matchers.eq(clientId),
//          Matchers.anyString(),
//          Matchers.anyString())
//    }
//  }
//}
