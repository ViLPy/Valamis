package com.arcusys.learn.controllers

import org.junit.runner.RunWith
import org.scalamock.scalatest.MockFactory
import com.arcusys.learn.ioc.Configuration
import org.scalatra.test.scalatest.{ ScalatraSuite }
import com.arcusys.learn.service.util.SessionHandlerContract
import com.arcusys.learn.mocks.MockBaseApiWebService
import org.scalamock.proxy.ProxyMockFactory
import org.mockito.{ Matchers, Mockito }
import javax.servlet.http.Cookie
import org.scalatest.FlatSpec
import com.arcusys.learn.controllers.api.ActivityApiController

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ActivityControllerTest extends FlatSpec with ScalatraSuite with MockFactory with ProxyMockFactory {
  val sessionHandler = Mockito.mock(classOf[SessionHandlerContract])

  Configuration.modifyBindings {
    testModule =>
      testModule.bind[SessionHandlerContract] toSingle sessionHandler
      val servlet = new ActivityApiController(testModule) with MockBaseApiWebService
      addServlet(servlet, "/*")
  }

  "ActivityWebService" should "getAllActivities" in {
    Mockito.stub(sessionHandler.getAttribute(Matchers.any(classOf[Array[Cookie]]), Matchers.any(classOf[String]))).toReturn("en")

    get("/") {
      status should equal(200)
      //        //body should equal("{\"isSuccess\": true} {\"message\": \"\"} {\"data\": en}")
      body should not equal ("")
    }
  }
}

