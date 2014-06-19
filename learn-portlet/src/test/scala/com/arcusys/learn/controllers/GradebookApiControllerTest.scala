package com.arcusys.learn.controllers

import org.junit.runner.RunWith
import org.scalatest.{ BeforeAndAfterEach, FlatSpec }
import org.scalatra.test.scalatest.ScalatraSuite
import org.scalamock.scalatest.MockFactory
import org.scalamock.proxy.ProxyMockFactory
import com.arcusys.learn.test.mocks.MockInjectableFactory
import com.arcusys.learn.util.JsonSupport
import org.mockito.Mockito
import com.arcusys.learn.mocks.Mocks
import com.arcusys.learn.service.util.SessionHandlerContract
import com.arcusys.learn.facades.GradebookFacadeContract
import com.arcusys.learn.controllers.api.GradebookApiController
import com.arcusys.learn.models.request.{ GradebookActionType, GradebookRequest }
import javax.servlet.http.HttpServletResponse

/**
 * Created by guestAdmin on 22.04.14.
 */

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class GradebookApiControllerTest extends FlatSpec with ScalatraSuite with MockFactory with BeforeAndAfterEach with ProxyMockFactory with MockInjectableFactory with JsonSupport {

  override def beforeEach() {
    Mockito.reset(Mocks.gradebookFacade, Mocks.sessionHandlerContract)
  }

  bindingModule.modifyBindings(module => {
    module.bind[SessionHandlerContract] toSingle Mocks.sessionHandlerContract
    module.bind[GradebookFacadeContract] toSingle Mocks.gradebookFacade

    addServlet(new GradebookApiController(module), "")
  })

  "GradebookApiController" should "return students as a short result" in {
    val params = Map(
      GradebookRequest.ACTION -> GradebookActionType.ALL.toString,
      GradebookRequest.COURSE_ID -> Mocks.GradebookFacade.courseId.toString,
      GradebookRequest.PAGE -> Mocks.General.page.toString,
      GradebookRequest.COUNT -> Mocks.General.count.toString,
      GradebookRequest.SORT_ASC_DIRECTION -> true.toString)

    Mocks.GradebookFacade.getStudentsStub()

    get("/", params = params) {

      status should equal(HttpServletResponse.SC_OK)
      body should not equal ""
      Mocks.GradebookFacade.getStudentsVerify()
    }
  }

  "GradebookApiController" should "return students as a detailed" in {
    val params = Iterable(
      GradebookRequest.ACTION -> GradebookActionType.ALL.toString,
      GradebookRequest.COURSE_ID -> Mocks.GradebookFacade.courseId.toString,
      GradebookRequest.PAGE -> Mocks.General.page.toString,
      GradebookRequest.COUNT -> Mocks.General.count.toString,
      GradebookRequest.RESULT_AS -> "detailed",
      GradebookRequest.SORT_ASC_DIRECTION -> true.toString,
      GradebookRequest.SELECTED_PACKAGES -> "1",
      GradebookRequest.SELECTED_PACKAGES -> "2")

    Mocks.GradebookFacade.getExtStudentsStub(packageIds = Seq(1, 2))

    get("/", params = params) {

      status should equal(HttpServletResponse.SC_OK)
      body should not equal ""
      Mocks.GradebookFacade.getExtStudentsVerify(packageIds = Seq(1, 2))
    }
  }

  "GradebookApiController" should "return student's grades" in {
    val params = Iterable(
      GradebookRequest.ACTION -> GradebookActionType.GRADES.toString,
      GradebookRequest.COURSE_ID -> Mocks.GradebookFacade.courseId.toString,
      GradebookRequest.STUDENT_ID -> Mocks.GradebookFacade.studentId.toString,
      GradebookRequest.PAGE -> Mocks.General.page.toString,
      GradebookRequest.COUNT -> Mocks.General.count.toString,
      GradebookRequest.SORT_ASC_DIRECTION -> true.toString,
      GradebookRequest.SELECTED_PACKAGES -> "1",
      GradebookRequest.SELECTED_PACKAGES -> "2")

    Mocks.GradebookFacade.getGradesForStudentStub(packageIds = Seq(1, 2))

    get("/", params = params) {

      status should equal(HttpServletResponse.SC_OK)
      body should not equal ""
      Mocks.GradebookFacade.getGradesForStudentVerify(packageIds = Seq(1, 2))
    }
  }
}

