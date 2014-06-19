package com.arcusys.learn.controllers

import org.junit.runner.RunWith
import org.scalatra.test.scalatest.ScalatraSuite
import org.scalamock.scalatest.MockFactory
import org.scalamock.proxy.ProxyMockFactory
import com.arcusys.learn.test.mocks.MockInjectableFactory
import com.escalatesoft.subcut.inject.BindingModule
import org.mockito._
import com.arcusys.learn.service.util.SessionHandlerContract
import com.liferay.portal.model.User
import com.arcusys.learn.controllers.auth.{ LiferayAuthUser, LiferayCheckerAuthStrategy, LiferayAuthStrategy }
import javax.servlet.http.{ HttpServletResponse, HttpServletRequest }
import org.scalatest.FlatSpec
import com.arcusys.learn.controllers.api.BaseApiController

/**
 * Created by Iliya Tryapitsin on 04.04.2014.
 */

class TestAuthController(config: BindingModule) extends BaseApiController(config) {
  get("/") {
  }
}

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class AuthStrategyTest extends FlatSpec with ScalatraSuite with MockFactory with ProxyMockFactory with MockInjectableFactory {
  val user = Mockito.mock(classOf[LiferayAuthUser])
  val sessionHandlerContract = Mockito.mock(classOf[SessionHandlerContract])
  val liferayAuthStrategy = Mockito.mock(classOf[LiferayAuthStrategy])
  implicit val request = Mockito.mock(classOf[HttpServletRequest])
  implicit val resp = Mockito.mock(classOf[HttpServletResponse])

  //val t = implicitly[HttpServletRequest]

  bindingModule.modifyBindings(module => {
    module.bind[SessionHandlerContract] toSingle sessionHandlerContract
    module.bind[LiferayAuthStrategy] toSingle liferayAuthStrategy

    addServlet(new TestAuthController(module), "/*")
  })
  Mockito
    .stub(liferayAuthStrategy.authenticate()(Matchers.any[HttpServletRequest], Matchers.any[HttpServletResponse]))
    .toReturn(Option(user))

  val t = liferayAuthStrategy.authenticate()

  "AuthStrategyTest" should "work" in {
    get("/") {
    }
  }
}
