package com.arcusys.learn.tincan.api

import org.junit.runner.RunWith
import com.arcusys.learn.ioc.Configuration
import org.scalamock.ProxyMockFactory
import org.scalamock.scalatest.MockFactory
import com.arcusys.learn.storage.StorageFactoryContract
import org.scalatra.test.scalatest.ScalatraFlatSpec
import org.junit.Ignore
import com.arcusys.learn.tincan.storage._
import com.arcusys.learn.tincan.model._
import java.util.{Date, UUID}
import com.arcusys.learn.setting.storage.SettingStorage
import com.arcusys.learn.scorm.tracking.storage.{AttemptStorage, DataModelStorage, UserStorage, RoleStorage}
import com.arcusys.learn.social.storage.{SocialPackageStorage, PackageCommentStorage, PackageVoteStorage}
import com.arcusys.learn.scorm.certificating.{CertificateStorage, CertificateSiteStorage, CertificateUserStorage}
import com.arcusys.learn.scorm.course.{CourseStorage, PlayerScopeRuleStorage}
import com.arcusys.learn.scorm.manifest.storage.{PackagesStorage, ActivitiesStorage, ResourcesStorage, PackageScopeRuleStorage}
import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.scorm.tracking.states.storage.{ActivityStateTreeStorage, ActivityStateStorage}
import com.arcusys.learn.quiz.storage.{QuizStorage, QuizQuestionCategoryStorage, QuizQuestionStorage}
import com.arcusys.learn.questionbank.storage.{QuestionCategoryStorage, QuestionStorage}
import scala.Some
import com.arcusys.learn.tincan.manifest.storage.{TincanPackageStorage, TincanManifestActivityStorage}
import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement
import scala.Some
import com.arcusys.learn.tincan.model.Statement
import com.arcusys.learn.tincan.model.Agent
import com.arcusys.learn.tincan.model.Verb
import org.joda.time.LocalDateTime

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class StatementServiceTest extends ScalatraFlatSpec with MockFactory with ProxyMockFactory {



  //val storageFactory = mock[StorageFactoryContract]

  //"Statement service" should "sets the mock" in {
   // storageFactory stubs 'tincanLrsStatementStorage returning InMemoryStatementStorage


    Configuration.modifyBindings {
      testModule =>
        testModule.bind[StorageFactoryContract] toSingle TestStorageFactory
        addServlet(new StatementService(testModule){override def getSessionUserID = 0}, "/*")
        // TODO delete getSessionUserID = 0, when basic or local auth appears
    }

  val statement1 = """{"id":"3f56f03f-7b6e-4552-877e-9cd0cc8a2f03","timestamp":"2013-09-30T07:19:27.454Z","actor":{"objectType":"Agent","mbox":"mailto:test@beta.projecttincan.com","name":"Test User"},"verb":{"id":"http://adlnet.gov/expapi/verbs/experienced","display":{"und":"experienced" }},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/Playing/Playing.html","objectType":"Activity","definition":{"name":{"en-US":"Playing Golf"},"description":{"en-US":"An overview of the game of golf."}}}}"""
  val statement2 = """{"id":"3f56f03f-7b6e-4552-877e-9cd0cc8a2f03","timestamp":"2013-09-30T07:19:27.454Z","actor":{"objectType":"Agent","mbox":"mailto:test@beta.projecttincan.com","name":"Test User1"},"verb":{"id":"http://adlnet.gov/expapi/verbs/attempted","display":{"und":"attempted" }},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/Playing/Playing.html","objectType":"Activity","definition":{"name":{"en-US":"Playing Golf"},"description":{"en-US":"An overview of the game of golf."}}}}"""
  val statement3 = """{
                   "id": "4d56f03f-7b6e-4552-877e-9cd0cc8a2f03",
                   "timestamp": "2013-09-30T07:19:27.454Z",
                   "actor": {
                       "objectType": "Agent",
                       "mbox": "mailto:test@beta.projecttincan.com",
                       "name": "Test User"
                   },
                   "verb": {
                       "id": "http://adlnet.gov/expapi/verbs/experienced",
                       "display": {
                           "und": "experienced"
                       }
                   },
                   "context": {
                       "contextActivities": {
                           "parent": [
                               {
                                   "id": "http://tincanapi.com/GolfExample_TCAPI",
                                   "objectType": "Activity"
                               }
                           ],
                           "grouping": [
                               {
                                   "id": "http://tincanapi.com/GolfExample_TCAPI",
                                   "objectType": "Activity"
                               }
                           ]
                       }
                   },
                   "object": {
                       "id": "http://tincanapi.com/GolfExample_TCAPI/Playing/Playing.html",
                       "objectType": "Activity",
                       "definition": {
                           "name": {
                               "en-US": "Playing Golf"
                           },
                           "description": {
                               "en-US": "An overview of the game of golf."
                           }
                       }
                   }
               }"""
  val statement4 = """{"id":"5f56f03f-7b6e-4552-877e-9cd0cc8a2f03","timestamp":"2013-09-30T07:19:27.454Z","actor":{"objectType":"Agent","mbox":"mailto:test@beta.projecttincan.com","name":"Test User"},"verb":{"id":"http://adlnet.gov/expapi/verbs/experienced","display":{"und":"experienced" }},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/Playing/Playing.html","objectType":"Activity","definition":{"name":{"en-US":"Playing Golf"},"description":{"en-US":"An overview of the game of golf."}}}}"""
  val statement5 = """{"id":"6f56f03f-7b6e-4552-877e-9cd0cc8a2f03","timestamp":"2013-09-30T07:19:27.454Z","actor":{"objectType":"Agent","mbox":"mailto:test@beta.projecttincan.com","name":"Test User"},"verb":{"id":"http://adlnet.gov/expapi/verbs/experienced","display":{"und":"experienced" }},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/Playing/Playing.html","objectType":"Activity","definition":{"name":{"en-US":"Playing Golf"},"description":{"en-US":"An overview of the game of golf."}}}}"""
  val statement6 = """{
                     |"id": "4d56f03f-aaaa-4552-877e-9cd0cc8a2f03",
                     |"actor": {
                     |  "objectType": "Agent",
                     |  "mbox":"mailto:test@example.com"
                     |},
                     |"verb" : {
                     |  "id":"http://example.com/planned",
                     |  "display":{
                     |    "en-US":"planned"
                     |  }
                     |},
                     |"object": {
                     |  "objectType": "Agent",
                     |  "mbox":"mailto:objtest@example.com"
                     |}
                     |}""".stripMargin

  val statement7 = """{
                     |    "id": "4d56f03f-bbbb-4552-877e-9cd0cc8a2f03",
                     |    "actor": {
                     |        "objectType": "Agent",
                     |        "mbox":"mailto:test@example.com"
                     |    },
                     |    "verb" : {
                     |        "id":"http://example.com/planned",
                     |        "display":{
                     |            "en-US":"planned"
                     |        }
                     |    },
                     |    "object": {
                     |        "objectType": "SubStatement",
                     |        "actor" : {
                     |            "objectType": "Agent",
                     |            "mbox":"mailto:subtest@example.com"
                     |        },
                     |        "verb" : {
                     |            "id":"http://example.com/visited",
                     |            "display":{
                     |                "en-US":"will visit"
                     |            }
                     |        },
                     |        "object": {
                     |            "id":"http://example.com/visited",
                     |            "objectType": "Activity"
                     |
                     |        }
                     |    }
                     |}""".stripMargin

  val statement8 = """{
    "actor": {
        "objectType": "Agent",
        "mbox":"mailto:test@example.com"
    },
    "verb" : {
        "id":"http://example.com/planned",
        "display":{
            "en-US":"planned"
        }
    },
    "object": {
        "objectType": "StatementRef",
        "id":"4f56f03f-7b6e-4552-877e-9cd0cc8a2f03"
    }
}""".stripMargin
  //  PUT requests -----------------------------------

  "Statement API PUT /" must "returns 400 Bad Request, Missing argument statementId" in {
    put("/",statement1) {
      status should equal(400)
    }
  }

  "Statement API PUT /?statementId=id is not uuid" must "returns 400" in {
    put("/?statementId=3",statement1) {
      status should equal(400)
    }
  }

  "Statement API PUT /?statementId= without statement" must "rejects with 400" in {
    put("/?statementId=3f56f03f-7b6e-4552-877e-9cd0cc8a2f03") {
      status should equal(400)
      val statement = InMemoryStatementStorage.getByUUID(UUID.fromString("3f56f03f-7b6e-4552-877e-9cd0cc8a2f03"))
      assert(!statement.isDefined)
    }
  }

  "Statement API PUT /?statementId=" must "returns 204 No Content" in {
    put("/?statementId=3f56f03f-7b6e-4552-877e-9cd0cc8a2f03",statement1) {
      status should equal(204)
      val statement = InMemoryStatementStorage.getByUUID(UUID.fromString("3f56f03f-7b6e-4552-877e-9cd0cc8a2f03"))
      assert(statement.isDefined)
      statement.get.actor.objectType should equal("Agent")
      statement.get.actor.asInstanceOf[Agent].name should equal(Some("Test User"))
      statement.get.verb.id should equal("http://adlnet.gov/expapi/verbs/experienced")
    }
  }

  "Statement API PUT /?statementId=existsId" must "returns 204 No Content,and MUST NOT modify the Statement or any other Object." in {
    put("/?statementId=3f56f03f-7b6e-4552-877e-9cd0cc8a2f03",statement1) {
      status should equal(409)
      val statement = InMemoryStatementStorage.getByUUID(UUID.fromString("3f56f03f-7b6e-4552-877e-9cd0cc8a2f03"))
      assert(statement.isDefined)
      statement.get.actor.objectType should equal("Agent")
      statement.get.actor.asInstanceOf[Agent].name should equal(Some("Test User"))
      statement.get.verb.id should equal("http://adlnet.gov/expapi/verbs/experienced")
    }
  }

  "Statement API PUT /?statementId=existsId_Conflicted" must "returns 409 Conflict, and MUST NOT modify the Statement or any other Object." in {
    put("/?statementId=3f56f03f-7b6e-4552-877e-9cd0cc8a2f03",statement2) {
      status should equal(409)
      val statement = InMemoryStatementStorage.getByUUID(UUID.fromString("3f56f03f-7b6e-4552-877e-9cd0cc8a2f03"))
      assert(statement.isDefined)
      statement.get.actor.objectType should equal("Agent")
      statement.get.actor.asInstanceOf[Agent].name should equal(Some("Test User"))
      statement.get.verb.id should equal("http://adlnet.gov/expapi/verbs/experienced")
    }
  }

  //  end PUT requests -----------------------------------

  //  POST requests -----------------------------------

  "Statement API POST / 0 statements - empty body" must "returns 400" in {
    post("/") {
      status should equal(400)
      val statement = InMemoryStatementStorage.getByUUID(UUID.fromString("4f56f03f-7b6e-4552-877e-9cd0cc8a2f03"))
      assert(!statement.isDefined)
    }
  }

  "Statement API POST / 1 statement" must "returns 200 and UUID" in {
    post("/",statement3) {
      status should equal(200)
      response.body should include("""["4d56f03f-7b6e-4552-877e-9cd0cc8a2f03"]""")
      val statement = InMemoryStatementStorage.getByUUID(UUID.fromString("4d56f03f-7b6e-4552-877e-9cd0cc8a2f03"))
      assert(statement.isDefined)
      statement.get.actor.objectType should equal("Agent")
      statement.get.actor.asInstanceOf[Agent].name should equal(Some("Test User"))
      statement.get.verb.id should equal("http://adlnet.gov/expapi/verbs/experienced")
    }
  }

  "Statement API POST / [1 statement]" must "returns 200 and UUID" in {
    //post("/","""{"id":"4f56f03f-7b6e-4552-877e-9cd0cc8a2f03","timestamp":"2013-09-30T07:19:27.454Z","actor":{"objectType":"Agent","mbox":"mailto:test@beta.projecttincan.com","name":"Test User"},"verb":{"id":"http://adlnet.gov/expapi/verbs/experienced","display":{"und":"experienced" }},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/Playing/Playing.html","objectType":"Activity","definition":{"name":{"en-US":"Playing Golf"},"description":{"en-US":"An overview of the game of golf."}}}}""") {
    post("/","""[{"id":"4f56f03f-7b6e-4552-877e-9cd0cc8a2f03","timestamp":"2013-09-30T07:19:27.454Z","actor":{"objectType":"Agent","mbox":"mailto:test@beta.projecttincan.com","name":"Test User"},"verb":{"id":"http://adlnet.gov/expapi/verbs/experienced","display":{"und":"experienced" }},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/Playing/Playing.html","objectType":"Activity","definition":{"name":{"en-US":"Playing Golf"},"description":{"en-US":"An overview of the game of golf."}}}}]""") {
      status should equal(200)
      response.body should include("""["4f56f03f-7b6e-4552-877e-9cd0cc8a2f03"]""")
      val statement = InMemoryStatementStorage.getByUUID(UUID.fromString("4f56f03f-7b6e-4552-877e-9cd0cc8a2f03"))
      assert(statement.isDefined)
      statement.get.actor.objectType should equal("Agent")
      statement.get.actor.asInstanceOf[Agent].name should equal(Some("Test User"))
      statement.get.verb.id should equal("http://adlnet.gov/expapi/verbs/experienced")
    }
  }

  "Statement API POST / 2 statements" must "returns 200 and UUIDs" in {
    post("/",
      ("["+statement4+","+statement5+"]")
     ) {
      status should equal(200)
      response.body should include("""["5f56f03f-7b6e-4552-877e-9cd0cc8a2f03","6f56f03f-7b6e-4552-877e-9cd0cc8a2f03"]""")
      val statement = InMemoryStatementStorage.getByUUID(UUID.fromString("5f56f03f-7b6e-4552-877e-9cd0cc8a2f03"))
      assert(statement.isDefined)
      statement.get.actor.objectType should equal("Agent")
      statement.get.actor.asInstanceOf[Agent].name should equal(Some("Test User"))
      statement.get.verb.id should equal("http://adlnet.gov/expapi/verbs/experienced")

      val statement1 = InMemoryStatementStorage.getByUUID(UUID.fromString("6f56f03f-7b6e-4552-877e-9cd0cc8a2f03"))
      assert(statement1.isDefined)
      statement1.get.actor.objectType should equal("Agent")
      statement1.get.actor.asInstanceOf[Agent].name should equal(Some("Test User"))
      statement1.get.verb.id should equal("http://adlnet.gov/expapi/verbs/experienced")
    }
  }

  "Statement API POST / 1 statement exists id" must "returns 204" in {
    post("/","""[{"id":"4f56f03f-7b6e-4552-877e-9cd0cc8a2f03","timestamp":"2013-09-30T07:19:27.454Z","actor":{"objectType":"Agent","mbox":"mailto:test@beta.projecttincan.com","name":"Test User"},"verb":{"id":"http://adlnet.gov/expapi/verbs/experienced","display":{"und":"experienced" }},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/Playing/Playing.html","objectType":"Activity","definition":{"name":{"en-US":"Playing Golf"},"description":{"en-US":"An overview of the game of golf."}}}}]""") {
      status should equal(409)
      //response.body should include("""["4f56f03f-7b6e-4552-877e-9cd0cc8a2f03"]""")
      val statement = InMemoryStatementStorage.getByUUID(UUID.fromString("4f56f03f-7b6e-4552-877e-9cd0cc8a2f03"))
      assert(statement.isDefined)
      statement.get.actor.objectType should equal("Agent")
      statement.get.actor.asInstanceOf[Agent].name should equal(Some("Test User"))
      statement.get.verb.id should equal("http://adlnet.gov/expapi/verbs/experienced")
    }
  }

  "Statement API POST / 1 statement exists id conflicted" must "returns 409" in {
    post("/","""[{"id":"4f56f03f-7b6e-4552-877e-9cd0cc8a2f03","timestamp":"2013-09-30T08:18:27.454Z","actor":{"objectType":"Agent","mbox":"mailto:test@beta.projecttincan1.com","name":"Test User1"},"verb":{"id":"http://adlnet.gov/expapi/verbs/attempted","display":{"und":"experienced" }},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/Playing/Playing.html","objectType":"Activity","definition":{"name":{"en-US":"Playing Golf"},"description":{"en-US":"An overview of the game of golf."}}}}]""") {
      status should equal(409)
      //response.body should include("""["4f56f03f-7b6e-4552-877e-9cd0cc8a2f03"]""")
      val statement = InMemoryStatementStorage.getByUUID(UUID.fromString("4f56f03f-7b6e-4552-877e-9cd0cc8a2f03"))
      assert(statement.isDefined)
      statement.get.actor.objectType should equal("Agent")
      statement.get.actor.asInstanceOf[Agent].name should equal(Some("Test User"))
      statement.get.verb.id should equal("http://adlnet.gov/expapi/verbs/experienced")
    }
  }

  "Statement API POST / 1 statement with Agent as object" must "returns 200 and ids" in {
    post("/",statement6) {
      status should equal(200)
      val ids = JsonDeserializer.deserializeIds(body)
      ids.size should equal(1)

      val statement = InMemoryStatementStorage.getByUUID(UUID.fromString(ids.head))
      assert(statement.isDefined)
      statement.get.actor.objectType should equal("Agent")
      assert(statement.get.obj.isInstanceOf[Agent])
      statement.get.obj.asInstanceOf[Agent].mbox.get should equal("mailto:objtest@example.com")
    }
  }

  "Statement API POST / 1 statement with SubStatement as object" must "returns 200 and ids" in {
    post("/",statement7) {
      status should equal(200)
      val ids = JsonDeserializer.deserializeIds(body)
      ids.size should equal(1)
      //response.body should include("""["4f56f03f-7b6e-4552-877e-9cd0cc8a2f03"]""")
      val statement = InMemoryStatementStorage.getByUUID(UUID.fromString(ids.head))
      assert(statement.isDefined)
      statement.get.actor.objectType should equal("Agent")
      assert(statement.get.obj.isInstanceOf[SubStatement])
      statement.get.obj.asInstanceOf[SubStatement].actor.asInstanceOf[Agent].mbox.get should equal("mailto:subtest@example.com")
      statement.get.obj.asInstanceOf[SubStatement].verb.id should equal("http://example.com/visited")
      statement.get.obj.asInstanceOf[SubStatement].obj.asInstanceOf[Activity].id should equal("http://example.com/visited")
    }
  }


  "Statement API POST / 1 statement with StatementRef as object" must "returns 200 and ids" in {
    post("/",statement8) {
      status should equal(200)
      val ids = JsonDeserializer.deserializeIds(body)
      ids.size should equal(1)
      //response.body should include("""["4f56f03f-7b6e-4552-877e-9cd0cc8a2f03"]""")
      val statement = InMemoryStatementStorage.getByUUID(UUID.fromString(ids.head))
      assert(statement.isDefined)
      statement.get.actor.objectType should equal("Agent")
      assert(statement.get.obj.isInstanceOf[StatementReference])
      statement.get.obj.asInstanceOf[StatementReference].id.toString should equal("4f56f03f-7b6e-4552-877e-9cd0cc8a2f03")
    }
  }
  //  end POST requests -----------------------------------

  //  GET requests -----------------------------------

  "Statement API GET /?statementId=4f56f03f-7b6e-4552-877e-9cd0cc8a2f03&voidedStatementId=" must
    "reject with an HTTP 400 error any requests to this resource which contain both statementId and voidedStatementId parameters" in {
    get("/?statementId=4f56f03f-7b6e-4552-877e-9cd0cc8a2f03&voidedStatementId=fdf01fb5-25c0-4c15-b481-74ba0fbc3584") {
      status should equal(400)
    }
  }

  "Statement API GET /?registration=id instead UUID" must
    "reject with an HTTP 400" in {
    get("/?registration=4") {
      status should equal(400)
    }
  }

  "Statement API GET /?statementId=1&ascending=false" must "reject with an HTTP 400 error any requests to this resource which contain statementId or voidedStatementId parameters, and also contain any other parameter besides \"attachments\" or \"format\"." in {

    val firstPar = List("statementId=4f56f03f-7b6e-4552-877e-9cd0cc8a2f03","voidedStatementId=4f56f03f-7b6e-4552-877e-9cd0cc8a2f03")
    val secondPar = List("ascending=false","limit=0","until="+new LocalDateTime().toString,"since="+new LocalDateTime().toString,"related_agents=false","related_activities=false",
      "registration=4f56f03f-7b6e-4552-877e-9cd0cc8a2f03","activity=iri","verb=iri","agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d")

    for( par1:String <- firstPar)
    {
      for( par2:String <- secondPar)
      {
        val req = "/?" + par1 + "&" + par2
        println(req)
        get(req)
        {
          status should equal(400)
        }
      }
    }
  }

  "Statement API GET /" must
    "A StatementResult Object, a list of Statements in reverse chronological order based on \"stored\" time is returned, HTTP 200." in {
    get("/") {
      status should equal(200)
      val result = response.getContent()
      val statementResult = JsonDeserializer.deserializeStatementResult(result)
      val statements = statementResult.statements
      //statements.size should equal(6)
      val statement = statements.find(s => s.id.toString == "fdf01fb5-25c0-4c15-b481-74ba0fbc3584")
      assert(statement.isDefined)
      statement.get.id.toString should equal("fdf01fb5-25c0-4c15-b481-74ba0fbc3584")
      statement.get.stored.toString should equal(InMemoryStatementStorage.statement.stored.toString)
    }
  }

  "Statement API GET" must "MUST include the header X-Experience-API-Consistent-Through" in {
    get("/") {
      var res = false
      println(response.getHeader("X-Experience-API-Consistent-Through"))
      val enum = response.getHeaderNames
      while(enum.hasMoreElements && !res)
      {
        var element = enum.nextElement()
        if(element.equals("X-Experience-API-Consistent-Through"))
        {
          res = true
        }
      }
      res should equal(true)
    }
  }

  "Statement API GET /?statementId=fdf01fb5-25c0-4c15-b481-74ba0fbc3584" must
    "if the statementId parameter is specified a single Statement is returned, HTTP 200." in {
    get("/?statementId=fdf01fb5-25c0-4c15-b481-74ba0fbc3584") {
      status should equal(200)
      val result = response.getContent()
      val statement = JsonDeserializer.deserializeStatement(result)
      statement.id.toString should equal("fdf01fb5-25c0-4c15-b481-74ba0fbc3584")
      statement.stored.toString should equal(InMemoryStatementStorage.statement.stored.toString)
    }
  }

  // TODO specification test
   "Statement API GET /?voidedStatementId=fdf01fb5-25c0-4c15-b481-74ba0fbc3584" must
     "if the voidedStatementId parameter is specified a single Statement is returned, HTTP 200." in {
    get("/?voidedStatementId=fdf01fb5-25c0-4c15-b481-74ba0fbc3584") {
      status should equal(200)
    }
  }

  //  end GET requests -----------------------------------
}

