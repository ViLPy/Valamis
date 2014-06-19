package com.arcusys.learn.controllers

import org.junit.runner.RunWith
import org.scalamock.scalatest.MockFactory
import org.scalatra.test.scalatest.{ ScalatraSuite, ScalatraFlatSpec }
import com.arcusys.learn.mocks.{ Mocks, MockBaseApiWebService }
import com.arcusys.learn.models.request.{ CertificateRequest, CertificateActionType }
import org.mockito.{ Mockito }
import com.arcusys.learn.test.mocks.MockInjectableFactory
import org.scalamock.proxy.ProxyMockFactory
import org.scalatest.FlatSpec
import com.arcusys.learn.controllers.api.CertificateApiController
import javax.servlet.http.HttpServletResponse

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class CertificateControllerTest extends FlatSpec with ScalatraSuite with MockFactory with ProxyMockFactory with MockInjectableFactory {

  bindingModule.modifyBindings(module => addServlet(new CertificateApiController(module) with MockBaseApiWebService, "/*"))

  "CertificateController" should "get all certificates" in {
    Mockito.reset(Mocks.sessionHandlerContract)
    Mockito.reset(Mocks.certificateFacadeContract)

    Mocks.SessionHandler.setTeacherPermissions()

    Mocks.CertificateFacade
      .allCountStub()
      .getAllStub()

    val params = Map[String, String](
      CertificateRequest.ACTION -> CertificateActionType.GET_ALL.toString,
      CertificateRequest.COMPANY_ID -> Mocks.CertificateFacade.companyId.toString,
      CertificateRequest.PAGE -> Mocks.CertificateFacade.page.toString,
      CertificateRequest.COUNT -> Mocks.CertificateFacade.count.toString,
      CertificateRequest.FILTER -> Mocks.CertificateFacade.filter,
      CertificateRequest.SORT_BY -> Mocks.CertificateFacade.sortBy.toString.toLowerCase,
      CertificateRequest.SORT_ASC_DIRECTION -> Mocks.CertificateFacade.isSortDirectionAsc.toString,
      CertificateRequest.RESULT_AS -> Mocks.CertificateFacade.isShortResult.toString)

    val headers = Map[String, String]()

    get("/", params, headers) {
      status should equal(200)
      body should not equal ("")

      Mocks.SessionHandler.checkTeacherPermissionsVerify()

      Mocks.CertificateFacade
        .allCountVerify()
        .getAllVerify()
    }
  }

  "CertificateController" should "get by id" in {
    Mockito.reset(Mocks.sessionHandlerContract)
    Mockito.reset(Mocks.certificateFacadeContract)

    Mocks.CertificateFacade.getByIdStub()

    val params = Map[String, String](
      CertificateRequest.ACTION -> CertificateActionType.GET_BY_ID.toString,
      CertificateRequest.ID -> Mocks.CertificateFacade.certificateId.toString,
      CertificateRequest.USER_ID -> Mocks.CertificateFacade.userId.toString)

    val headers = Map[String, String]()

    get("/" + Mocks.CertificateFacade.certificateId, params, headers) {
      status should equal(200)
      body should not equal ("")

      Mocks.CertificateFacade.getByIdVerify()
    }
  }

  //  "CertificateController" should "get for student" in {
  //    Mockito.reset(Mocks.sessionHandlerContract)
  //    Mockito.reset(Mocks.certificateFacadeContract)
  //
  //    Mocks.CertificateFacade
  //      .getForUserStub()
  //      .getForUserStub()
  //
  //    val params = Map[String, String](
  //      CertificateRequest.COMPANY_ID -> Mocks.CertificateFacade.companyId.toString,
  //      CertificateRequest.PAGE -> Mocks.CertificateFacade.page.toString,
  //      CertificateRequest.COUNT -> Mocks.CertificateFacade.count.toString,
  //      CertificateRequest.SORT_ASC_DIRECTION -> Mocks.CertificateFacade.isSortDirectionAsc.toString,
  //      CertificateRequest.USER_ID -> Mocks.CertificateFacade.userId.toString)
  //
  //    val headers = Map[String, String]()
  //
  //    get("/", params, headers) {
  //      status should equal(200)
  //      body should not equal ("")
  //
  //      Mocks.CertificateFacade
  //        .getForUserVerify()
  //        .forUserCountVerify()
  //    }
  //  }

  "CertificateController" should "get issue badge" in {
    Mockito.reset(Mocks.sessionHandlerContract)
    Mockito.reset(Mocks.certificateFacadeContract)

    Mocks.CertificateFacade.getIssuerBadgeStub()

    val params = Map[String, String](
      CertificateRequest.ACTION -> CertificateActionType.GET_ISSUE_BADGE.toString,
      CertificateRequest.ID -> Mocks.CertificateFacade.certificateId.toString,
      CertificateRequest.USER_ID -> Mocks.CertificateFacade.userId.toString,
      CertificateRequest.ROOT_URL -> Mocks.CertificateFacade.rootUrl)

    val headers = Map[String, String]()

    get("/" + Mocks.CertificateFacade.certificateId, params, headers) {
      status should equal(200)
      body should not equal ("")

      Mocks.CertificateFacade.getIssuerBadgeVerify()
    }
  }

  "CertificateController" should "create new certificate" in {
    Mockito.reset(Mocks.sessionHandlerContract)
    Mockito.reset(Mocks.certificateFacadeContract)

    Mocks.SessionHandler.setTeacherPermissions()
    Mocks.CertificateFacade.createStub()

    val params = Map[String, String](
      CertificateRequest.ACTION -> CertificateActionType.ADD.toString,
      CertificateRequest.COMPANY_ID -> Mocks.CertificateFacade.companyId.toString,
      CertificateRequest.USER_ID -> Mocks.CertificateFacade.userId.toString)

    val headers = Map[String, String]()

    post("/", params, headers) {
      status should equal(200)
      body should not equal ("")

      Mocks.CertificateFacade.createVerify()
      Mocks.SessionHandler.checkTeacherPermissionsVerify()
    }
  }

  "CertificateController" should "change certificate" in {
    Mockito.reset(Mocks.sessionHandlerContract)
    Mockito.reset(Mocks.certificateFacadeContract)

    Mocks.CertificateFacade.changeStub()
    Mocks.SessionHandler.setTeacherPermissions()

    val params = Map[String, String](
      CertificateRequest.ACTION -> CertificateActionType.UPDATE.toString,
      CertificateRequest.ID -> Mocks.CertificateFacade.id.toString,
      CertificateRequest.TITLE -> Mocks.CertificateFacade.title,
      CertificateRequest.DESCRIPTION -> Mocks.CertificateFacade.description,
      CertificateRequest.LOGO -> Mocks.CertificateFacade.logo.toString,
      CertificateRequest.PUBLISH_BADGE -> Mocks.CertificateFacade.publishBadge.toString,
      CertificateRequest.SHORT_DESCRIPTION -> Mocks.CertificateFacade.shortDescription,
      CertificateRequest.COMPANY_ID -> Mocks.CertificateFacade.companyId.toString,
      CertificateRequest.USER_ID -> Mocks.CertificateFacade.userId.toString)

    val headers = Map[String, String]()

    post("/" + Mocks.CertificateFacade.id, params, headers) {
      Mocks.CertificateFacade.changeVerify()
      Mocks.SessionHandler.checkTeacherPermissionsVerify()

      status should equal(200)
      body should not equal ("")
    }
  }

  "CertificateController" should "delete certificate" in {
    Mockito.reset(Mocks.sessionHandlerContract)
    Mockito.reset(Mocks.certificateFacadeContract)

    Mocks.SessionHandler.setTeacherPermissions()

    val params = Map[String, String](
      CertificateRequest.ACTION -> CertificateActionType.DELETE.toString,
      CertificateRequest.ID -> Mocks.CertificateFacade.id.toString)

    val headers = Map[String, String]()

    post("/" + Mocks.CertificateFacade.id, params, headers) {
      status should equal(HttpServletResponse.SC_NO_CONTENT)

      Mocks.CertificateFacade.deleteVerify()
      Mocks.SessionHandler.checkTeacherPermissionsVerify()
    }
  }
}

