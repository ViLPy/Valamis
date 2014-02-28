package com.arcusys.learn.achievements

import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory
import org.junit.runner.RunWith
import com.arcusys.learn.test.mocks._
import org.scalatra.test.scalatest.ScalatraFlatSpec
import org.junit.Ignore
import com.arcusys.scorm.lms.AchievementRepositoryContract
import com.arcusys.scorm.lms.models.AchievementModelBL
import com.arcusys.scala.json.Json
import com.arcusys.learn.service.util.{SessionHandlerContract}
import com.arcusys.scorm.lms.models.AchievementRequiredActivityModel
import com.arcusys.learn.liferay.LiferayClasses.LUser

//import org.eclipse.jetty.server.session.SessionHandler

//
// Created by iliya.tryapitsin on 04.02.14.
//
@RunWith(classOf[org.scalatest.junit.JUnitRunner])
@Ignore
class AchievementWebServiceTest extends ScalatraFlatSpec with MockFactory with ProxyMockFactory with MockInjectableFactory {

  // Init variable partial
  val achievementRepositoryContract = mock[AchievementRepositoryContract]
  val sessionHandler = mock[SessionHandlerContract]
  val achievements = List[AchievementModelBL]()
  val json = Json.toJson(achievements)
  val sessionHandler1 = mock[SessionHandlerContract]
  val sessionHandler2 = mock[SessionHandlerContract]

  // Injection partial
  bindingModule.modifyBindings(module => {
    module.bind[AchievementRepositoryContract] toSingle achievementRepositoryContract
    module.bind[SessionHandlerContract] toSingle sessionHandler1
    module.bind[SessionHandlerContract] toSingle sessionHandler2
    addServlet(new AchievementWebService(module), "/*")
  })

  // 1
  "AchievementWebService" should  "get all achievements as JSON" in {
    // Init mocks and stubs for this test
    achievementRepositoryContract
      .stubs('getCount)
      .returning(10)

    achievementRepositoryContract
      .stubs('get)
      .returning(achievements)

    // Request params
    val params = Map[String, String]("action" -> "all", "page" -> "10", "sortAZ" -> "true", "count" -> "5", "filter" -> "")
    val headers = Map[String, String]("COOKIE" -> "COMPANY_ID=111")

    // Request
    get("/", params = params, headers = headers) {

      // Check response
      status should equal(200)
      //body should equal("{\"isSuccess\":true,\"message\":\"\",\"data\":%s}".format(json))
      body should not be ""
    }
  }

  // 2
  it should "get achievement as JSON for currentUser" in {

    achievementRepositoryContract
      .stubs('getForUser)
      .returning(achievements)

    sessionHandler
      .stubs('getAttribute)
      .returning("22")

    val params = Map[String, String]("action" -> "currentUser")
    val headers = Map[String, String]("COOKIE" -> "COMPANY_ID=111")

    get("/", params = params, headers = headers) {
      status should equal(200)
      body should equal("{\"isSuccess\":true,\"message\":\"\",\"data\":%s}".format(json))
      //body should not be ""
    }
  }

  // 3
  it should "get achievement as JSON for user" in {

    achievementRepositoryContract
      .stubs('getForUser)
      .returning(achievements)

    val params = Map[String, String]("action" -> "user", "userId" -> "22")
    val headers = Map[String, String]("COOKIE" -> "COMPANY_ID=111")

    get("/", params = params, headers = headers) {
      status should equal(200)
      //body should equal("{\"isSuccess\":true,\"message\":\"\",\"data\":%s}".format(json))
      body should not be ""
    }
  }

  // 4
  it should "add achievement as JSON" in {
    val achievementModelBL = AchievementModelBL(1, "Test", "Test", "Test", 111, true, List[AchievementRequiredActivityModel](), List[LUser]())
    val myJson = Json.toJson(achievementModelBL)

    sessionHandler
      .stubs('getAttribute)
      .returning(true)

    achievementRepositoryContract
      .stubs('create)
      .returning(achievementModelBL)

    val params = Map[String, String]("action" -> "add")
    val headers = Map[String, String]()

    post("/", params = params) {
      status should equal(200)
      body should equal("{\"isSuccess\":true,\"message\":\"\",\"data\":%s}".format(myJson))
    }
  }

  // 5
  it should "update exist achievement as JSON" in {

    sessionHandler
      .stubs('getAttribute)
      .returning(true)

    achievementRepositoryContract
      .stubs('modify)
      .returning(true)

    val params = Map[String, String]("action" -> "update", "title" -> "aaa", "description" -> "bbb", "logo" -> "ccc", "startDate" -> "11223333")

    post("/123", params = params) {
      status should equal(200)
      //body should equal("{\"isSuccess\":true,\"message\":\"\",\"data\":%s}".format(json))
      body should not be ""
    }
  }

  // 6
  it should "delete exist achievement as JSON" in {

    sessionHandler
      .stubs('getAttribute)
      .returning(true)

    achievementRepositoryContract
      .stubs('delete)
      .returning(true)

    val params = Map[String, String]("action" -> "delete")

    post("/123", params = params) {
      status should equal(200)
      //body should equal("{\"isSuccess\":true,\"message\":\"\",\"data\":%s}".format(json))
      body should not be ""
    }
  }

  // 7 !
  it should "add activity as JSON" in {

  sessionHandler
    .stubs('getAttribute)
    .returning(true)

    val achievementRequiredActivityModel = AchievementRequiredActivityModel(9, "z", 5)
    val myJson = Json.toJson(achievementRequiredActivityModel)

    val params = Map[String, String]("action" -> "add", "achievementId" -> "22", "activityClassName" -> "bla")

    achievementRepositoryContract
      .stubs('addActivity)
      .returning(achievementRequiredActivityModel)

    post("/activity/", params = params) {
      status should equal(200)
      body should equal("{\"isSuccess\":true,\"message\":\"\",\"data\":%s}".format(myJson))
    }

  }

  // 8
  it should "update activity as JSON" in {

    sessionHandler
      .stubs('getAttribute)
      .returning(true)

    val params = Map[String, String]("action" -> "update", "achievementId" -> "22", "numberActivitiesRequired" -> "11")

    achievementRepositoryContract
      .stubs('updateActivity)
      .returning()

    post("/activity/123", params = params) {
      status should equal(200)
      //body should equal("{\"isSuccess\":true,\"message\":\"\",\"data\":%s}".format(json))
      body should not be ""
    }

  }

  // 9
  it should "delete activity as JSON" in {

    sessionHandler
      .stubs('getAttribute)
      .returning(true)

    val params = Map[String, String]("action" -> "delete")
    //val headers = Map[String, String]("COOKIE" -> "hasTeacherPermissions=true")

    achievementRepositoryContract
      .stubs('removeActivity)
      .returning()

    post("/activity/123", params = params) {
      status should equal(200)
      //body should equal("{\"isSuccess\":true,\"message\":\"\",\"data\":%s}".format(json))
      body should not be ""
    }
  }

  // 10
  it should "apply activity as JSON" in {

    val params = Map[String, String]("action" -> "apply", "userId" -> "10", "isAdmin" -> "true")
    //val headers = Map[String, String]("COOKIE" -> "userId=10")

    sessionHandler
      .stubs('getAttribute)
      .returning(true)

    sessionHandler
      .stubs('getAttribute)
      .returning(5)

    achievementRepositoryContract
      .stubs('applyAchievementForUser)
      .returning()

    post("/user/", params = params) {
      status should equal(200)
      //body should equal("{\"isSuccess\":true,\"message\":\"\",\"data\":%s}".format(json))
      body should not be ""
    }
  }

  // 11
  it should "remove activity as JSON" in {

    val params = Map[String, String]("action" -> "remove")
    val headers = Map[String, String]("COOKIE" -> "userId=10, isAdmin=true")

    //val isAdmin : Boolean = true
    //sessionHandler1.stubs('getAttribute).returning(isAdmin)

    //val userID : Int = 2
    //sessionHandler2.stubs('getAttribute).returning(userID)

    sessionHandler
      .stubs('getAttribute)
      .returning(5)

    achievementRepositoryContract
      .stubs('removeAchievementForUser)
      .returning()

    post("/5/user/1", params = params) {
      status should equal(200)
      body should equal("{\"isSuccess\": true, \"message\": \"\", \"data\": Nil}")
    }
  }

}
