//
//package com.arcusys.learn.questionbank.service
//
//import org.junit.runner.RunWith
//import com.arcusys.learn.ioc.Configuration
//import org.scalamock.scalatest.MockFactory
//import com.arcusys.learn.questionbank.storage._
//import com.arcusys.learn.questionbank.model.QuestionCategory
//import com.arcusys.learn.storage.StorageFactoryContract
//import org.scalatra.test.scalatest.{ScalatraSuite, ScalatraFlatSpec}
//import org.junit.Ignore
//import org.scalamock.proxy.ProxyMockFactory
//import org.scalatest.FlatSpec
//
//@RunWith(classOf[org.scalatest.junit.JUnitRunner])
//@Ignore
//class CategoryServiceTest extends FlatSpec with ScalatraSuite with MockFactory with ProxyMockFactory {
//
//  val questionCategoryStorage = mock[QuestionCategoryStorage]
//  val questionStorage = mock[QuestionStorage]
//  val storageFactory = mock[StorageFactoryContract]
//
//  Configuration.modifyBindings {
//    testModule =>
//      testModule.bind[StorageFactoryContract] toSingle storageFactory
//      addServlet(new CategoryService(testModule) {
//        override def hasTeacherPermissions = true
//      }, "/*")
//  }
//
//  "Category service" can "get all categories as JSON" in {
//    val dummyCategories = Seq(new QuestionCategory(1, "tit", "desc", None, Some(0)), new QuestionCategory(12, "ti", "des", Some(1), Some(0)))
//    storageFactory stubs 'questionCategoryStorage returning questionCategoryStorage
//    //questionCategoryStorage expects 'getAll returning dummyCategories once()
//    questionCategoryStorage expects 'getAllByCourseID returning dummyCategories once ()
//
//    get("/") {
//      status should equal(200)
//    }
//  }
//
//}
//
