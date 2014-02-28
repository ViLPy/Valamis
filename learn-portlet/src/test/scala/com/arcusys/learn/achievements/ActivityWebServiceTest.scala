package com.arcusys.learn.achievements

import org.junit.runner.RunWith
import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory
import com.arcusys.learn.ioc.Configuration
import org.scalatra.test.scalatest.ScalatraFlatSpec
import com.arcusys.learn.service.util.SessionHandlerContract
import org.junit.Ignore
import com.arcusys.learn.mocks.MockBaseWebService


@RunWith(classOf[org.scalatest.junit.JUnitRunner])
@Ignore
class ActivityWebServiceTest extends ScalatraFlatSpec with MockFactory with ProxyMockFactory{
  val sessionHandler = mock[SessionHandlerContract]

  Configuration.modifyBindings {
    testModule =>
      testModule.bind[SessionHandlerContract] toSingle sessionHandler
      val servlet = new ActivityWebService(testModule) with MockBaseWebService
      addServlet(servlet, "/*")
  }

  "ActivityWebService" should "getAllActivities" in {
    sessionHandler stubs 'getAttribute returning "en"

    get("/") {
      status should equal(200)
      body should equal("{\"isSuccess\": true} {\"message\": \"\"} {\"data\": en}")
    }
  }
}

