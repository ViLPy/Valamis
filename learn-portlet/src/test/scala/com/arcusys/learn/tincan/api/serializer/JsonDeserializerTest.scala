package com.arcusys.learn.tincan.api.serializer

import org.junit.Test
import org.junit.Assert._
import org.json4s.jackson.JsonMethods._
import org.json4s.{DefaultFormats, Formats}
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer
import com.arcusys.learn.tincan.model._
import org.joda.time.DateTime
import java.util.UUID

class JsonDeserializerTest {
  implicit val jsonFormats: Formats = DefaultFormats

  @Test
  def ActorDeserializerTest() {
    val raw = """{
      "objectType": "Agent",
      "account": {
        "homePage": "http://www.example.com",
        "name": "1625378"
      }
    }"""
    val actor = JsonDeserializer.deserializeActor(raw).asInstanceOf[Agent]

    assertEquals("Agent", actor.objectType)
    assertNotSame(None, actor.account)
    assertEquals("http://www.example.com", actor.account.get.homePage)
    assertEquals("1625378", actor.account.get.name)
  }

  @Test
  def ContextActivitiesTest() {
    val raw = """{"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}"""

    implicit val jsonFormats: Formats = DefaultFormats

    val result = parse(raw).extract[ContextActivities]
    assertFalse(result.grouping.isEmpty)
    assertEquals(Some("Activity"), result.grouping.head.objectType)
    assertEquals("http://tincanapi.com/GolfExample_TCAPI", result.grouping.head.id)
  }

  @Test
  def ContextActivitiesTest2() {
    val raw = """{
      "parent" : [{ "id" : "http://example.adlnet.gov/xapi/example/test 1"}],
      "grouping" : [{ "id" : "http://example.adlnet.gov/xapi/example/Algebra1"}]
    }"""

    val result = parse(raw).extract[ContextActivities]
    assertFalse(result.grouping.isEmpty)
    assertEquals(None, result.grouping.head.objectType)
    assertEquals("http://example.adlnet.gov/xapi/example/Algebra1", result.grouping.head.id)
    assertFalse(result.parent.isEmpty)
    assertEquals(None, result.parent.head.objectType)
    assertEquals("http://example.adlnet.gov/xapi/example/test 1", result.parent.head.id)
  }

  @Test
  def StatementTest() {
    val raw = """{
         "id":"a4996174-0908-4971-80c6-4e541d18ac3f",
         "timestamp":"2013-09-20T10:45:50.162Z",
         "actor":{"objectType":"Agent"},
         "verb":{"id":"http://adlnet.gov/expapi/verbs/attempted","display":{"und":"attempted"}},
         "context":{"contextActivities":{"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},
         "object":{
            "id":"http://tincanapi.com/GolfExample_TCAPI",
            "objectType":"Activity",
            "definition":{"type":"http://adlnet.gov/expapi/activities/course","name":{"en-US":"Golf Example - Tin Can Course"},"description":{"en-US":"An overview of how to play the great game of golf."}}}
         }"""

    val statement = JsonDeserializer.deserializeStatement(raw)
    assertEquals("a4996174-0908-4971-80c6-4e541d18ac3f", statement.id.toString)
    assertEquals(new DateTime("2013-09-20T10:45:50.162Z").toDate, statement.timestamp)

    assertTrue(statement.actor.isInstanceOf[Agent])
    assertEquals("Agent", statement.actor.asInstanceOf[Agent].objectType)
    assertEquals(None, statement.actor.asInstanceOf[Agent].name)

    assertEquals("http://adlnet.gov/expapi/verbs/attempted", statement.verb.id)
    assertEquals("attempted", statement.verb.display("und"))

    assertNotSame(None, statement.context)
    println(statement.context.get.contextActivities)
    assertEquals("http://tincanapi.com/GolfExample_TCAPI", statement.context.get.contextActivities.grouping.head.id)

    assertEquals("Activity", statement.obj.objectType)
    assertEquals("http://tincanapi.com/GolfExample_TCAPI", statement.obj.asInstanceOf[Activity].id)
    assertEquals("An overview of how to play the great game of golf.", statement.obj.asInstanceOf[Activity].description.get("en-US"))
    assertEquals(Some("http://adlnet.gov/expapi/activities/course"), statement.obj.asInstanceOf[Activity].theType)
    assertEquals("Golf Example - Tin Can Course", statement.obj.asInstanceOf[Activity].name.get("en-US"))

    assertEquals(None, statement.result)
    assertEquals(None, statement.stored)
    assertEquals(None, statement.version)
    assertTrue("attachments should be isEmpty", statement.attachments.isEmpty)
  }

  @Test
  def StatementTest2() {
    val raw =
      """ {"id":"e59a54c1-f66b-43b8-bf61-d9b511a9e869",
        "timestamp":"2013-10-18T10:07:42.035Z",
        "actor":{"objectType":"Agent","mbox":"mailto:","name":""},
        "verb":{"id":"http://adlnet.gov/expapi/verbs/attempted","display":{"und":"attempted"}},
        "object":{"id":"http://tincanapi.com/Course/NashvilleMuseumsTour","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/course","name":{"en-US":"Nashville Museums Tour"},"description":{"en-US":"An exploration of museums in the greater Nashville TN area."}}}}"""

    val statement = JsonDeserializer.deserializeStatement(raw)
    assertEquals(UUID.fromString("e59a54c1-f66b-43b8-bf61-d9b511a9e869"), statement.id)
    assertEquals("http://adlnet.gov/expapi/verbs/attempted", statement.verb.id)
    assertEquals("http://tincanapi.com/Course/NashvilleMuseumsTour", statement.obj.asInstanceOf[Activity].id)
  }

  @Test
  def StatementTest3() {
    val raw = """{"id":"3f56f03f-7b6e-4552-877e-9cd0cc8a2f03","timestamp":"2013-09-30T07:19:27.454Z","actor":{"objectType":"Agent","mbox":"mailto:test@beta.projecttincan.com","name":"Test User"},"verb":{"id":"http://adlnet.gov/expapi/verbs/experienced","display":{"und":"experienced" }},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/Playing/Playing.html","objectType":"Activity","definition":{"name":{"en-US":"Playing Golf"},"description":{"en-US":"An overview of the game of golf."}}}}"""

    val statement = JsonDeserializer.deserializeStatement(raw)
  }

  @Test
  def Test2() {
    val raw = """[{
                	"id":"57ae0335-a985-4482-8815-89168f8a5571",
                	"timestamp":"2013-09-20T13:30:02.954Z",
                	"actor":{"objectType":"Agent"},
                	"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},
                	"result":{"success":false,"response":""},
                	"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},
                	"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.fun_3",
                		"objectType":"Activity",
                		"definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction",
                		"description":{"en-US":"You should take your score very seriously if you want to have a lot of fun on the course."},
                		"interactionType":"true-false",
                		"correctResponsesPattern":["false"]}}
                },

                {"id":"eca50a8d-f734-4e1a-8357-893795163711","timestamp":"2013-09-20T13:30:02.954Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},"result":{"success":false,"response":""},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.fun_2","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction","description":{"en-US":"Knickers indicate a refined sense of style."},"interactionType":"true-false","correctResponsesPattern":["false"]}}}
                ]
              """

    val statements = JsonDeserializer.deserializeStatements(raw)
    println(statements)
  }

  @Test
  def Test3() {
    val raw = """[
    {
      "id":"57ae0335-a985-4482-8815-89168f8a5571",
      "timestamp":"2013-09-20T13:30:02.954Z",
      "actor":{"objectType":"Agent"},
      "verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},
      "result":{"success":false,"response":""},
      "context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},
      "object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.fun_3",
        "objectType":"Activity",
        "definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction",
        "description":{"en-US":"You should take your score very seriously if you want to have a lot of fun on the course."},
        "interactionType":"true-false",
        "correctResponsesPattern":["false"]}}
    },

    {"id":"eca50a8d-f734-4e1a-8357-893795163711","timestamp":"2013-09-20T13:30:02.954Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},"result":{"success":false,"response":""},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.fun_2","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction","description":{"en-US":"Knickers indicate a refined sense of style."},"interactionType":"true-false","correctResponsesPattern":["false"]}}},

    {"id":"f31d3f75-47f5-407f-ad14-eec9cf414240","timestamp":"2013-09-20T13:30:02.954Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},"result":{"success":false,"response":""},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.fun_1","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction","description":{"en-US":"To make friends on the golf course, you should play really slowly."},"interactionType":"true-false","correctResponsesPattern":["false"]}}},

    {"id":"edff18a2-5cb3-4b97-8b4a-e93228e4b7b4","timestamp":"2013-09-20T13:30:02.955Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},"result":{"success":false,"response":"23"},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.handicap_4","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction","description":{"en-US":"Golfer A has a course handicap of 3. Golfer B has a course handicap of 28. On the 6th handicap hole, how many strokes will Golfer A have to give Golfer B in match play?"},"interactionType":"numeric","correctResponsesPattern":["2"]}}},

    {"id":"dbc6a4a5-7cc5-4324-813c-10bdc803f74d","timestamp":"2013-09-20T13:30:02.955Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},"result":{"success":true,"response":""},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.handicap_3","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction","description":{"en-US":"A 'scratch golfer' has a handicap of ___"},"interactionType":"numeric","correctResponsesPattern":["0"]}}},

    {"id":"47168254-1040-43b7-9a49-b1d4f5b17ebe","timestamp":"2013-09-20T13:30:02.955Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},"result":{"success":false,"response":""},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.handicap_2","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction","description":{"en-US":"Golfer A has a course handicap of 6. Golfer B has a course handicap of 10. Golfer A shoots an 81. Golfer B shoots an 84. Golfer B wins the match be how many strokes?"},"interactionType":"numeric","correctResponsesPattern":["1"]}}},

    {"id":"e4bcacce-c5ab-4b1e-ad90-9c03e33781c4",
      "timestamp":"2013-09-20T13:30:02.955Z",
      "actor":{"objectType":"Agent"},
      "verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},
      "result":{"success":false,"response":""},
      "context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},
      "object":{
        "id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.handicap_1",
        "objectType":"Activity",
        "definition":{
        "type":"http://adlnet.gov/expapi/activities/cmi.interaction",
        "description":{"en-US":"Which formula is used to calculate the 'course handicap'?"},
        "interactionType":"choice",
        "correctResponsesPattern":["Course Handicap = Handicap index * Slope Rating / 113"],
        "choices":[
      {"id":"Course Handicap = Handicap index + number of holes * number of lost balls in last round",
        "description":{"en-US":"Course Handicap = Handicap index + number of holes * number of lost balls in last round"}},
      {"id":"Course Handicap = Number of years experience / annual equipment spending","description":{"en-US":"Course Handicap = Number of years experience / annual equipment spending"}},
      {"id":"Course Handicap = Handicap index * Slope Rating / 113","description":{"en-US":"Course Handicap = Handicap index * Slope Rating / 113"}}]}}},

    {"id":"98394e4d-6e18-4bd2-abba-6f1ecb96c43a","timestamp":"2013-09-20T13:30:02.955Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},"result":{"success":false,"response":"Last"},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.etiquette_3","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction","description":{"en-US":"The player with the best score on previous hole tees off:"},"interactionType":"choice","correctResponsesPattern":["First"],"choices":[{"id":"First","description":{"en-US":"First"}},{"id":"Last","description":{"en-US":"Last"}},{"id":"With a putter","description":{"en-US":"With a putter"}}]}}},

    {"id":"2ef26498-ed5c-46dc-8bfd-fbddef8ab92f","timestamp":"2013-09-20T13:30:02.955Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},"result":{"success":false,"response":""},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.etiquette_2","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction","description":{"en-US":"Generally sand trap rakes should be left outside of the hazard"},"interactionType":"true-false","correctResponsesPattern":["true"]}}},

    {"id":"f516faa3-dd6f-42ea-b370-0606c1b7a83b","timestamp":"2013-09-20T13:30:02.956Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},"result":{"success":false,"response":"On top of his ball"},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.etiquette_1","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction","description":{"en-US":"When another player is attempting a shot, it is best to stand:"},"interactionType":"choice","correctResponsesPattern":["Out of the player's line of sight"],"choices":[{"id":"On top of his ball","description":{"en-US":"On top of his ball"}},{"id":"Directly in his line of fire","description":{"en-US":"Directly in his line of fire"}},{"id":"Out of the player's line of sight","description":{"en-US":"Out of the player's line of sight"}}]}}},{"id":"053280d1-c3ad-4665-834b-b79595299785","timestamp":"2013-09-20T13:30:02.956Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},"result":{"success":false,"response":""},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.playing_5","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction","description":{"en-US":"Par for a 175 yard hole is typically:"},"interactionType":"numeric","correctResponsesPattern":["3"]}}},{"id":"78e1bc9a-d710-4cfb-ab6d-c385e4cb604c","timestamp":"2013-09-20T13:30:02.956Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},"result":{"success":false,"response":"false"},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.playing_4","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction","description":{"en-US":"In stableford scoring, the highest score wins."},"interactionType":"true-false","correctResponsesPattern":["true"]}}},{"id":"92aaa531-2142-4633-9afb-0f32e96ccaf9","timestamp":"2013-09-20T13:30:02.956Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},"result":{"success":false,"response":""},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.playing_3","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction","description":{"en-US":"A typical golf course has ____ holes"},"interactionType":"numeric","correctResponsesPattern":["18"]}}},{"id":"1b883432-ab76-4265-9246-caed7fafe0a8","timestamp":"2013-09-20T13:30:02.956Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},"result":{"success":false,"response":"double bogie"},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.playing_2","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction","description":{"en-US":"A score of two under par on a given hole is known as a(n):"},"interactionType":"choice","correctResponsesPattern":["eagle"],"choices":[{"id":"opportunity for improvement","description":{"en-US":"opportunity for improvement"}},{"id":"birdie","description":{"en-US":"birdie"}},{"id":"double bogie","description":{"en-US":"double bogie"}},{"id":"eagle","description":{"en-US":"eagle"}}]}}},{"id":"e5303f1d-d199-4194-8ac8-658b277f7c59","timestamp":"2013-09-20T13:30:02.956Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/answered","display":{"und":"http://adlnet.gov/expapi/verbs/answered"}},"result":{"success":false,"response":"The PGA"},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment/interactions.playing_1","objectType":"Activity","definition":{"type":"http://adlnet.gov/expapi/activities/cmi.interaction","description":{"en-US":"The rules of golf are maintained by:"},"interactionType":"choice","correctResponsesPattern":["USGA and Royal and Ancient"],"choices":[{"id":"The UN","description":{"en-US":"The UN"}},{"id":"USGA and Royal and Ancient","description":{"en-US":"USGA and Royal and Ancient"}},{"id":"The PGA","description":{"en-US":"The PGA"}},{"id":"Each course has it's own rules","description":{"en-US":"Each course has it's own rules"}}]}}},{"id":"03ce5ef6-f326-41ea-8a31-41b6fd1ff155","timestamp":"2013-09-20T13:30:02.956Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/completed","display":{"und":"http://adlnet.gov/expapi/verbs/completed"}},"result":{"success":false,"score":{"scaled":0.07,"raw":7,"min":0,"max":100}},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI/GolfAssessment.html","objectType":"Activity"}},

    {"id":"f5a8938d-9437-42df-b14c-48f6f03cf721","timestamp":"2013-09-20T13:30:02.957Z","actor":{"objectType":"Agent"},"verb":{"id":"http://adlnet.gov/expapi/verbs/completed","display":{"und":"http://adlnet.gov/expapi/verbs/completed"}},"result":{"success":false,"score":{"scaled":0.07,"raw":7,"min":0,"max":100}},"context":{"contextActivities":{"parent":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}],"grouping":[{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}]}},"object":{"id":"http://tincanapi.com/GolfExample_TCAPI","objectType":"Activity"}}]
              """

    val statements = JsonDeserializer.deserializeStatements(raw)
  }
}
