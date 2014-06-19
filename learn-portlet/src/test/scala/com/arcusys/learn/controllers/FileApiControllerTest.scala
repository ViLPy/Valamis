package com.arcusys.learn.controllers

import org.junit.runner.RunWith
import org.scalatra.test.scalatest.{ ScalatraSuite, ScalatraFlatSpec }
import org.scalamock.scalatest.MockFactory
import com.arcusys.learn.test.mocks.MockInjectableFactory
import com.arcusys.learn.models.request.{ FileRequest }
import javax.servlet.http.HttpServletResponse
import com.arcusys.learn.mocks.Mocks
import org.scalamock.proxy.ProxyMockFactory
import org.junit.Ignore
import org.scalatest.FlatSpec
import com.arcusys.learn.controllers.api.FileApiController

/**
 * Created by Iliya Tryapitsin on 05.03.14.
 */
@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class FileApiControllerTest extends FlatSpec with ScalatraSuite with MockFactory with ProxyMockFactory with MockInjectableFactory {
  bindingModule.modifyBindings(module => addServlet(new FileApiController(module), ""))

  "FileApiController" should "return image" in {

    Mocks.FileFacade.doFileContentStub()

    get("/images/" + Mocks.FileFacade.fileId.toString) {
      status should equal(HttpServletResponse.SC_OK)

      //  Mocks.FileFacade.doFileContentVerify(Mocks.FileFacade.fileId)
    }
  }

  "FileApiController" should "return 404 error fot not exist file" in {

    Mocks.FileFacade.doFileContentStub()

    get("/images/" + Mocks.FileFacade.unExistFileId.toString) {
      status should equal(HttpServletResponse.SC_NOT_FOUND)
      //   Mocks.FileFacade.doFileContentVerify(Mocks.FileFacade.unExistFileId)
    }
  }

  //  "FileApiController" should "upload package" in {
  //    val reqBody  = new String(IOUtils.toString(Thread.currentThread().getContextClassLoader.getResourceAsStream("file_mock.txt")).getBytes, "iso-8859-1")
  //    val boundary = "---------------------------3924013385056820061124200860"
  //    val headers = Map("Content-Type" -> "multipart/form-data; boundary=%s".format(boundary))
  //
  //    val queryString = "?%s=%s&%s=%s&%s=%s&%s=%s&%s=%s".format(
  //      FileRequest.ACTION, CrudActionType.ADD.toString,
  //      FileRequest.CONTENT_TYPE, UploadContentType.PACKAGE.toString,
  //      PackageRequest.COURSE_ID, Mocks.FileFacade.courseID.toString,
  //      PackageRequest.SCORM_USER_ID, Mocks.FileFacade.userID.toString,
  //      PackageRequest.LIFERAY_GROUP_ID, Mocks.FileFacade.groupID.toString)
  //
  //    Mocks.FileFacade.doFileContentStub()
  //    put("/files/10", Map("private" -> "false"), Map("kitten" -> new File("kitten.png"))) {
  //      status must_== 200
  //    }
  //    post("/" + queryString, headers = headers, body = reqBody) {
  //      status should equal(HttpServletResponse.SC_NOT_FOUND)
  //      Mocks.FileFacade.doFileContentVerify(Mocks.FileFacade.unExistFileId)
  //    }
  //  }
}

