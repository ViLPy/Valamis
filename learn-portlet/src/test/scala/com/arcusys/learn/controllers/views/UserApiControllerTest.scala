package com.arcusys.learn.controllers.views

import org.junit.runner.RunWith
import org.scalatra.test.scalatest.ScalatraSuite
import org.scalamock.scalatest.MockFactory
import com.arcusys.learn.test.mocks.MockInjectableFactory
import com.arcusys.learn.service.util.SessionHandlerContract
import org.mockito.Mockito
import javax.servlet.http.HttpServletResponse
import org.scalamock.proxy.ProxyMockFactory
import org.scalatest.{ Ignore, BeforeAndAfterEach, FlatSpec }
import com.arcusys.learn.facades.{ UserFacadeContract, CertificateFacadeContract }
import com.arcusys.learn.mocks.Mocks
import com.arcusys.learn.util.JsonSupport
import com.arcusys.learn.controllers.api.UserApiController
import com.portletguru.portlettester.PortletTester
import javax.portlet.PortletException

/**
 * Created by Iliya Tryapitsin on 05.03.14.
 */
@RunWith(classOf[org.scalatest.junit.JUnitRunner])
@Ignore
class UserApiControllerTest extends FlatSpec with ScalatraSuite with MockFactory with BeforeAndAfterEach with ProxyMockFactory with MockInjectableFactory with JsonSupport {

  //  override def beforeEach() {
  //    Mockito.reset(Mocks.certificateFacadeContract, Mocks.sessionHandlerContract, Mocks.userFacade)
  //  }

  //  bindingModule.modifyBindings(module => {
  //    module.bind[SessionHandlerContract] toSingle Mocks.sessionHandlerContract
  //    module.bind[CertificateFacadeContract] toSingle Mocks.certificateFacadeContract
  //    module.bind[UserFacadeContract] toSingle Mocks.userFacade
  //
  //    addServlet(new UserApiController(module), "")
  //  })

  "UserApiController" should "return orgs" in {
    val portletTester = new PortletTester()
    val generator = portletTester.getPortletConfigGenerator
    generator.setPortletName("testPortlet");
    generator.setBundleBaseName("com.test");
    generator.setDefaultNamespace("testNameSpace");
    generator.addProcessingEvent("testProcessingEvent");
    generator.addPublicRenderParameter("p1", "v1");
    generator.addProcessingEvent("testPublishingEvent");
    generator.addSupportedLocale("en");
    //generator.addContainerRuntimeOption("ro1", new String[]{"v1", "v2"});

    val portlet = new GradebookViewController
    val portletConfig = generator.generatePortletConfig();
    try {
      portletTester.initPortlet(portlet, portletConfig);
    } catch {
      case e: Exception => {

      }
    }

    portlet.doView(
      portletTester.getRenderRequestGenerator.generateRequest(),
      portletTester.getRenderResponseGenerator.generateResponse())

    //    get("/orgs") {
    //      status should equal(HttpServletResponse.SC_OK)
    //    }
  }
}