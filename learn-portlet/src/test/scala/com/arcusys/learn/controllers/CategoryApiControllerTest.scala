package com.arcusys.learn.controllers

import org.junit.runner.RunWith
import org.scalatest.{ BeforeAndAfterEach, FlatSpec }
import org.scalatra.test.scalatest.ScalatraSuite
import org.scalamock.scalatest.MockFactory
import org.scalamock.proxy.ProxyMockFactory
import com.arcusys.learn.test.mocks.MockInjectableFactory
import com.arcusys.learn.util.JsonSupport
import com.arcusys.learn.service.util.SessionHandlerContract
import com.arcusys.learn.mocks.Mocks
import com.arcusys.learn.facades.{ CategoryFacadeContract }
import com.arcusys.learn.controllers.api.{ CategoryApiController }
import com.arcusys.learn.models.request.{ CategoryActionType, CategoryRequest }
import org.mockito.Mockito
import javax.servlet.http.HttpServletResponse

/**
 * Created by Iliya Tryapitsin on 11.04.2014.
 */

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class CategoryApiControllerTest extends FlatSpec with ScalatraSuite with BeforeAndAfterEach with MockFactory with ProxyMockFactory with MockInjectableFactory with JsonSupport {

  override def beforeEach() {
    Mockito.reset(Mocks.categoryFacade, Mocks.sessionHandlerContract)
  }

  bindingModule.modifyBindings(module => {
    module.bind[SessionHandlerContract] toSingle Mocks.sessionHandlerContract
    module.bind[CategoryFacadeContract] toSingle Mocks.categoryFacade

    addServlet(new CategoryApiController(module), "")
  })

  "CategoryApiController" should "return 401 status" in {
    get("/") {
      status should equal(401)
      Mocks.SessionHandler.checkTeacherPermissionsVerify()
    }
  }

  /* "CategoryApiController" should "return categories" in {

    Mocks.CategoryFacade.getForCourseIdStub()

    get("/") {
      body should not equal ""
      status should equal(HttpServletResponse.SC_OK)

      Mocks.CategoryFacade.getForCourseIdVerify(None)
    }
  }

  "CategoryApiController" should "return categories for course" in {
    Mocks.CategoryFacade.getForCourseIdStub()

    get("/", params = Seq(CategoryRequest.COURSE_ID -> Mocks.CategoryFacade.courseId.toString)) {
      body should not equal ""
      status should equal(200)

      Mocks.CategoryFacade
        .getForCourseIdVerify(
          Option(Mocks.CategoryFacade.courseId))
    }
  }*/

  "CategoryApiController" should "return child categories" in {
    Mocks.CategoryFacade.getChildStub()

    val params = Seq(
      CategoryRequest.COURSE_ID -> Mocks.CategoryFacade.courseId.toString,
      CategoryRequest.PARENT_ID -> Mocks.CategoryFacade.parentId.toString)

    get("/", params = params) {
      body should not equal ""
      status should equal(HttpServletResponse.SC_OK)

      Mocks.CategoryFacade.getChildVerify()
    }
  }

  ignore should "return child categories with questions" in {
    Mocks.CategoryFacade.getChildWithQuestionsStub()

    val params = Seq(
      CategoryRequest.COURSE_ID -> Mocks.CategoryFacade.courseId.toString,
      CategoryRequest.ACTION -> CategoryActionType.WITH_QUESTIONS.toString,
      CategoryRequest.QUESTIONS -> "1",
      CategoryRequest.QUESTIONS -> "2",
      CategoryRequest.CATEGORIES -> "1",
      CategoryRequest.CATEGORIES -> "2")

    get("/child/" + Mocks.CategoryFacade.parentId, params = params) {
      status should equal(200)
      body should not equal ""

      Mocks.CategoryFacade.getChildWithQuestionsVerify()
    }
  }

  "CategoryApiController" should "create new category" in {
    Mocks.CategoryFacade.createStub()

    val params = Map[String, String](
      CategoryRequest.TITLE -> Mocks.CategoryFacade.title,
      CategoryRequest.DESCRIPTION -> Mocks.CategoryFacade.description,
      CategoryRequest.COURSE_ID -> Mocks.CategoryFacade.courseId.toString,
      CategoryRequest.ACTION -> CategoryActionType.ADD.toString,
      CategoryRequest.PARENT_ID -> Mocks.CategoryFacade.parentId.toString)

    val headers = Map[String, String]()

    post("/", params, headers) {
      status should equal(200)
      body should not equal ""

      Mocks.CategoryFacade.createVerify()
    }
  }

  "CategoryApiController" should "update exist category" in {
    Mocks.CategoryFacade.updateStub()

    val params = Map[String, String](
      CategoryRequest.TITLE -> Mocks.CategoryFacade.title,
      CategoryRequest.DESCRIPTION -> Mocks.CategoryFacade.description,
      CategoryRequest.ACTION -> CategoryActionType.UPDATE.toString,
      CategoryRequest.ID -> Mocks.CategoryFacade.parentId.toString)

    val headers = Map[String, String]()

    post("/", params, headers) {
      status should equal(200)
      body should not equal ""

      Mocks.CategoryFacade.updateVerify()
    }
  }

  "CategoryApiController" should "delete exist category" in {

    Mocks.SessionHandler.setTeacherPermissions()

    val params = Map[String, String](
      CategoryRequest.ACTION -> CategoryActionType.DELETE.toString,
      CategoryRequest.ID -> Mocks.CategoryFacade.parentId.toString)

    val headers = Map[String, String]()

    post("/", params, headers) {
      status should equal(200)
      body should not equal ""

      Mocks.CategoryFacade.deleteVerify()
    }
  }
}
