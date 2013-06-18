package com.arcusys.learn.questionbank.service

import org.junit.runner.RunWith
import com.arcusys.learn.ioc.Configuration
import org.scalamock.ProxyMockFactory
import org.scalamock.scalatest.MockFactory
import com.arcusys.learn.questionbank.storage._
import com.arcusys.learn.questionbank.model.QuestionCategory
import com.arcusys.learn.storage.StorageFactoryContract
import org.scalatra.test.scalatest.ScalatraFlatSpec
import org.junit.Ignore

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
@Ignore
class CategoryServiceTest extends ScalatraFlatSpec with MockFactory with ProxyMockFactory {

  val questionCategoryStorage = mock[QuestionCategoryStorage]
  val questionStorage = mock[QuestionStorage]
  val storageFactory = mock[StorageFactoryContract]

  Configuration.modifyBindings {
    testModule =>
      testModule.bind[StorageFactoryContract] toSingle storageFactory
      addServlet(new CategoryService(testModule), "/*")
  }

  "Category service" can "get all categories as JSON" in {
    val dummyCategories = Seq(new QuestionCategory(1, "tit", "desc", None, Some(0)), new QuestionCategory(12, "ti", "des", Some(1),Some(0)))
    storageFactory stubs 'questionCategoryStorage returning questionCategoryStorage
    questionCategoryStorage expects 'getAll returning dummyCategories once()

    get("/") {
      status should equal(200)
    }
  }

}
