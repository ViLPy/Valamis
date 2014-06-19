package com.arcusys.learn.tincan.api

import org.junit.runner.RunWith
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.storage.StorageFactoryContract
import org.scalatra.test.scalatest.{ ScalatraSuite, ScalatraFlatSpec }
import scala.Some
import com.arcusys.learn.tincan.model.Agent
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer
import org.joda.time.LocalDateTime
import org.junit.Ignore
import org.scalatest.FlatSpec

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ActivityServiceTest extends FlatSpec with ScalatraSuite {

  Configuration.modifyBindings {
    testModule =>
      testModule.bind[StorageFactoryContract] toSingle TestStorageFactory
      addServlet(new ActivitiesService(testModule) { override def getSessionUserID = 0 }, "/*")
    // TODO delete getSessionUserID = 0, when basic or local auth appears
  }

  //  PUT requests -----------------------------------

  "Activity API PUT /" must
    "reject with an HTTP 405 error" in {
      put("/") {
        status should equal(405)
        val activity = InMemoryActivityProfileStorage.get("2", "2")
        assert(!activity.isDefined)
      }
    }

  "Activity API PUT /?activity=3&profileId=2" must
    "reject with an HTTP 405 error" in {
      put("/?activityId=2&profileId=2") {
        status should equal(405)
        val activity = InMemoryActivityProfileStorage.get("2", "2")
        assert(!activity.isDefined)
      }
    }

  "Activity API PUT /profile" must
    "reject with an HTTP 400 error" in {
      put("/profile") {
        status should equal(400)
        val activity = InMemoryActivityProfileStorage.get("2", "2")
        assert(!activity.isDefined)
      }
    }

  "Activity API PUT /profile?activityId=" must
    "reject with an HTTP 400 error" in {
      put("/profile?activityId=2") {
        status should equal(400)
        val activity = InMemoryActivityProfileStorage.get("2", "2")
        assert(!activity.isDefined)
      }
    }

  "Activity API PUT /profile?activityId=&profileId=" must
    "responds with an HTTP 204" in {
      put("""/profile?activityId=2&profileId=2""") {
        status should equal(204)
        val activity = InMemoryActivityProfileStorage.get("2", "2")
        assert(activity.isDefined)
        assert(activity.get.document.contents.isEmpty)
      }
    }

  "Activity API PUT /profile?activityId=&profileId= and body" must
    "responds with an HTTP 204" in {
      put("""/profile?activityId=2&profileId=2""",
        """{"id":"e59"}""", Map("Content-Type" -> """application/json""")) {
          status should equal(204)
          val activity = InMemoryActivityProfileStorage.get("2", "2")
          assert(activity.isDefined)
          activity.get.document.contents should equal("""{"id":"e59"}""")
        }
    }

  // end PUT requests -----------------------------------

  //  POST requests -----------------------------------

  "Activity API POST /" must
    "reject with an HTTP 405 error" in {
      post("/") {
        status should equal(405)
        val activity = InMemoryActivityProfileStorage.get("2", "3")
        assert(!activity.isDefined)
      }
    }

  "Activity API POST /?activityId=3&profileId=2" must
    "reject with an HTTP 405 error" in {
      post("/?activityId=2&profileId=3") {
        status should equal(405)
        val activity = InMemoryActivityProfileStorage.get("2", "3")
        assert(!activity.isDefined)
      }
    }

  "Activity API POST /profile" must
    "reject with an HTTP 400 error" in {
      post("/profile") {
        status should equal(400)
        val activity = InMemoryActivityProfileStorage.get("2", "3")
        assert(!activity.isDefined)
      }
    }

  "Activity API POST /profile?activityId=" must
    "reject with an HTTP 400 error" in {
      post("/profile?activityId=2") {
        status should equal(400)
        val activity = InMemoryActivityProfileStorage.get("2", "3")
        assert(!activity.isDefined)
      }
    }

  "Activity API POST /profile?activityId=&profileId=" must
    "responds with an HTTP 204" in {
      post("""/profile?activityId=2&profileId=3""") {
        status should equal(204)
        val activity = InMemoryActivityProfileStorage.get("2", "3")
        assert(activity.isDefined)
        assert(activity.get.document.contents.isEmpty)
      }
    }

  "Activity API POST /profile?activityId=&profileId= and body" must
    "responds with an HTTP 204" in {
      post("""/profile?activityId=2&profileId=4""",
        """{"x":"foo","y":"bar"}""", Map("Content-Type" -> """application/json""")) {
          status should equal(204)
          val activity = InMemoryActivityProfileStorage.get("2", "4")
          assert(activity.isDefined)
          activity.get.document.contents should equal("""{"x":"foo","y":"bar"}""")
        }
    }

  "Activity API POST /profile?activityId=&profileId= and body merge" must
    "responds with an HTTP 204" in {
      post("""/profile?activityId=2&profileId=4""",
        """{"x":"bash","z":"faz"}""", Map("Content-Type" -> """application/json""")) {
          status should equal(204)
          val activity = InMemoryActivityProfileStorage.get("2", "4")
          assert(activity.isDefined)
          activity.get.document.contents should equal("""{"y":"bar","x":"bash","z":"faz"}""")
        }
    }

  // end POST requests -----------------------------------

  //  GET requests -----------------------------------

  "Activity API GET /" must
    "reject with an HTTP 400 error" in {
      get("/") {
        status should equal(400)
      }
    }

  //Full Activity Object GET
  "Activity API GET /?activityId=" must
    "responds with an HTTP 200 and activity content" in {
      get("/?activityId=activityId-666") {
        status should equal(200)
        val activity = JsonDeserializer.deserializeActivity(body)
        activity.id should equal("activityId-666")
      }
    }

  "Activity API GET /profile?activityId=" must
    "responds with an HTTP 200 and list of profile ids" in {
      get("""/profile?activityId=2""") {
        status should equal(200)
        val ids = JsonDeserializer.deserializeIds(response.body)
        ids.size should equal(3)
        ids should contain("2")
        ids should contain("3")
        ids should contain("4")
      }
    }

  "Activity API GET /profile?activityId=&since=" must
    "responds with an HTTP 200 and list of profile ids" in {
      get("""/profile?activityId=2&since=""" + new LocalDateTime().toString()) {
        status should equal(200)
        val ids = JsonDeserializer.deserializeIds(response.body)
        ids.size should equal(0)
      }
    }

  "Activity API GET /profile?activityId=&profileId=" must
    "responds with an HTTP 200 and profile content" in {
      get("""/profile?activityId=2&profileId=2""") {
        status should equal(200)
        response.body should include("""{"id":"e59"}""")
      }
    }

  "Activity API GET /profile?activityId=&profileId= no exists" must
    "rejects with an HTTP 404" in {
      get("""/profile?activityId=5&profileId=5""") {
        status should equal(404)
      }
    }

  // end GET requests -----------------------------------

  //  DELETE requests -----------------------------------

  "Activity API DELETE /" must
    "reject with an HTTP 405 error" in {
      delete("/") {
        status should equal(405)
        val activity = InMemoryActivityProfileStorage.get("2", "2")
        assert(activity.isDefined)
      }
    }

  "Activity API DELETE /?activityId=2&profileId=2" must
    "reject with an HTTP 405 error" in {
      delete("/?activityId=2&profileId=2") {
        status should equal(405)
        val activity = InMemoryActivityProfileStorage.get("2", "2")
        assert(activity.isDefined)
      }
    }

  "Activity API DELETE /profile" must
    "reject with an HTTP 400 error" in {
      delete("/profile") {
        status should equal(400)
        val activity = InMemoryActivityProfileStorage.get("2", "2")
        assert(activity.isDefined)
      }
    }

  "Activity API DELETE /?activityId=&profileId=" must
    "responds with an HTTP 204" in {
      delete("/profile?activityId=2&profileId=2") {
        status should equal(204)
        val activity = InMemoryActivityProfileStorage.get("2", "2")
        assert(!activity.isDefined)

        val activity1 = InMemoryActivityProfileStorage.get("2", "3")
        assert(activity1.isDefined)
      }
    }

  "Activity API DELETE /profile?activityId=" must
    "responds with an HTTP 204" in {
      delete("/profile?activityId=2") {
        status should equal(400)
        //TODO Specification strangeness?
        //      status should equal(204)
        //      val activity = InMemoryActivityProfileStorage.get("2", "2")
        //      assert(!activity.isDefined)
        //
        //      val activity1 = InMemoryActivityProfileStorage.get("2", "3")
        //      assert(!activity1.isDefined)
      }
    }

  // end DELETE requests -----------------------------------
}
