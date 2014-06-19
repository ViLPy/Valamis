package com.arcusys.learn.tincan.api

import org.junit.runner.RunWith
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.storage.StorageFactoryContract
import org.scalatra.test.scalatest.{ ScalatraSuite, ScalatraFlatSpec }
import scala.Some
import com.arcusys.learn.tincan.model.Agent
import java.util.{ Date, UUID }
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer
import org.joda.time.LocalDateTime
import org.junit.Ignore
import org.scalatest.FlatSpec

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class StateServiceTest extends FlatSpec with ScalatraSuite {

  Configuration.modifyBindings {
    testModule =>
      testModule.bind[StorageFactoryContract] toSingle TestStorageFactory
      addServlet(new StateService(testModule) { override def getSessionUserID = 0 }, "/*")
    // TODO delete getSessionUserID = 0, when basic or local auth appears
  }

  //  PUT requests -----------------------------------

  "State API PUT /" must
    "reject with an HTTP 400 error" in {
      put("/") {
        status should equal(400)
        val state = InMemoryStateStorage.get("2", "2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
        assert(!state.isDefined)
      }
    }

  "State API PUT /?activityId=" must
    "reject with an HTTP 400 error" in {
      put("/?activityId=2") {
        status should equal(400)
        val state = InMemoryStateStorage.get("2", "2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
        assert(!state.isDefined)
      }
    }

  "State API PUT /?activityId=&agent=" must
    "reject with an HTTP 400" in {
      put("/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d") {
        status should equal(400)
        val state = InMemoryStateStorage.get("2", "2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
        assert(!state.isDefined)
      }
    }

  "State API PUT /?activityId=&agent=&stateId=" must
    "responds with an HTTP 204" in {
      put("/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d&stateId=2") {
        status should equal(204)
        val state = InMemoryStateStorage.get("2", "2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
        assert(state.isDefined)
        assert(state.get.content.contents.isEmpty)
      }
    }

  "State API PUT /?activityId=&agent=&stateId= and body" must
    "responds with an HTTP 204" in {
      put("""/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d&stateId=2""",
        """{"id":"e59"}""", Map("Content-Type" -> """application/json""")) {
          status should equal(204)
          val state = InMemoryStateStorage.get("2", "2",
            Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
          assert(state.isDefined)
          state.get.content.contents should equal("""{"id":"e59"}""")
        }
    }

  // end PUT requests -----------------------------------

  //  POST requests -----------------------------------

  "State API POST /" must
    "reject with an HTTP 400 error" in {
      post("/") {
        status should equal(400)
        val state = InMemoryStateStorage.get("2", "3",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
        assert(!state.isDefined)
      }
    }

  "State API POST /?activityId=" must
    "reject with an HTTP 400 error" in {
      post("/?activityId=2") {
        status should equal(400)
        val state = InMemoryStateStorage.get("2", "3",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
        assert(!state.isDefined)
      }
    }

  "State API POST /?activityId=&agent=" must
    "reject with an HTTP 400" in {
      post("""/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d""") {
        status should equal(400)
        val state = InMemoryStateStorage.get("2", "3",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
        assert(!state.isDefined)
      }
    }

  "State API POST /?activityId=&agent=&stateId=" must
    "responds with an HTTP 204" in {
      post("""/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d&stateId=3""") {
        status should equal(204)
        val state = InMemoryStateStorage.get("2", "3",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
        assert(state.isDefined)
        assert(state.get.content.contents.isEmpty)
      }
    }

  "State API POST /?activityId=&agent=&stateId=&registration=id instead UUID and body" must
    "rejects with an HTTP 400" in {
      post("""/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d&stateId=4&registration=1""",
        """{"x":"foo","y":"bar"}""", Map("Content-Type" -> """application/json""")) {
          status should equal(400)
        }
    }

  val registration: UUID = UUID.randomUUID()

  "State API POST /?activityId=&agent=&stateId=&registration= and body" must
    "responds with an HTTP 204" in {
      post("""/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d&stateId=4&registration=""" + registration.toString,
        """{"x":"foo","y":"bar"}""", Map("Content-Type" -> """application/json""")) {
          status should equal(204)
          val state = InMemoryStateStorage.get("2", "4",
            Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), Some(registration))
          assert(state.isDefined)
          state.get.content.contents should equal("""{"x":"foo","y":"bar"}""")
        }
    }

  var dateS: Option[Date] = None
  "State API POST /?activityId=&agent=&stateId=&registration= and body merge" must
    "responds with an HTTP 204" in {
      post("""/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d&stateId=4&registration=""" + registration.toString,
        """{"x":"bash","z":"faz"}""", Map("Content-Type" -> """application/json""")) {
          status should equal(204)
          val state = InMemoryStateStorage.get("2", "4",
            Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), Some(registration))
          assert(state.isDefined)
          state.get.content.contents should equal("""{"y":"bar","x":"bash","z":"faz"}""")
          dateS = Some(state.get.content.updated.toDate)
        }
    }

  // end POST requests -----------------------------------

  //  GET requests -----------------------------------

  "State API GET /" must
    "reject with an HTTP 400 error" in {
      get("/") {
        status should equal(400)
      }
    }

  "State API GET /?activityId=" must
    "reject with an HTTP 400 error" in {
      get("/?activityId=2") {
        status should equal(400)
      }
    }

  "State API GET /?activityId=&agent=&stateId=" must
    "responds with an HTTP 200 and content" in {
      get("""/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d&stateId=2""") {
        status should equal(200)
        val state = InMemoryStateStorage.get("2", "2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
        assert(state.isDefined)
        state.get.content.contents should equal(body)
      }
    }

  "State API GET /?activityId=&agent= multiple" must
    "responds with an HTTP 200 and list of state ids" in {
      get("""/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d""") {
        status should equal(200)
        val ids = JsonDeserializer.deserializeIds(response.body)
        ids.size should equal(2)
        ids should contain("2")
        ids should contain("3")
        //ids should contain("4")
      }
    }

  "State API GET /?activityId=&agent=&registration= multiple" must
    "responds with an HTTP 200 and list of state ids" in {
      get("""/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d&registration=""" + registration.toString) {
        status should equal(200)
        val ids = JsonDeserializer.deserializeIds(response.body)
        ids.size should equal(1)
        ids should contain("4")
      }
    }

  "State API GET /?activityId=&agent=&since= multiple" must
    "responds with an HTTP 200 and list of state ids" in {
      get("""/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d&since="""
        + new LocalDateTime().toString) {
        status should equal(200)
        val ids = JsonDeserializer.deserializeIds(response.body)
        ids.size should equal(0)
      }
    }

  "State API GET /?activityId=&agent=&registration=&since= multiple2" must
    "responds with an HTTP 200 and list of state ids" in {
      get("""/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d&since="""
        + new LocalDateTime(dateS.get).toString + "&registration=" + registration.toString) {
        status should equal(200)
        val ids = JsonDeserializer.deserializeIds(response.body)
        ids.size should equal(1)
        ids should contain("4")
      }
    }

  // end GET requests -----------------------------------

  //  DELETE requests -----------------------------------

  "State API DELETE /" must
    "reject with an HTTP 400 error" in {
      delete("/") {
        status should equal(400)
        val state = InMemoryStateStorage.get("2", "2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
        assert(state.isDefined)
        state.get.content.contents should equal("""{"id":"e59"}""")
      }
    }

  "State API DELETE /?activityId=" must
    "reject with an HTTP 400 error" in {
      delete("/?activityId=2") {
        status should equal(400)
        val state = InMemoryStateStorage.get("2", "2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
        assert(state.isDefined)
        state.get.content.contents should equal("""{"id":"e59"}""")
      }
    }

  "State API DELETE /?activityId=&agent=&stateId=" must
    "responds with an HTTP 204" in {
      delete("""/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d&stateId=2""") {
        status should equal(204)
        val state = InMemoryStateStorage.get("2", "2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
        assert(!state.isDefined)
      }
    }

  "State API DELETE /?activityId=&agent=" must
    "reject with an HTTP 400" in {
      delete("""/?activityId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d""") {
        status should equal(204)
        val state = InMemoryStateStorage.get("2", "2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
        assert(!state.isDefined)

        val state2 = InMemoryStateStorage.get("2", "3",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None), None)
        assert(!state2.isDefined)
      }
    }
  // end DELETE requests -----------------------------------
}
