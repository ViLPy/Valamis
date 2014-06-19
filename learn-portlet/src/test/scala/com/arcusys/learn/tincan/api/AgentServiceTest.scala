package com.arcusys.learn.tincan.api

import org.junit.runner.RunWith
import org.scalatra.test.scalatest.{ ScalatraSuite, ScalatraFlatSpec }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import com.arcusys.learn.tincan.model.Agent
import scala.Some
import org.junit.Ignore
import org.scalatest.FlatSpec

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class AgentServiceTest extends FlatSpec with ScalatraSuite {

  Configuration.modifyBindings {
    testModule =>
      testModule.bind[StorageFactoryContract] toSingle TestStorageFactory
      addServlet(new AgentService(testModule) { override def getSessionUserID = 0 }, "/*")
    // TODO delete getSessionUserID = 0, when basic or local auth appears
  }

  //  PUT requests -----------------------------------

  "Agent API PUT /" must
    "reject with an HTTP 405 error" in {
      put("/") {
        status should equal(405)
        val agent = InMemoryAgentProfileStorage.get("1",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(!agent.isDefined)
      }
    }

  "Agent API PUT /?profileId=" must
    "reject with an HTTP 405 error" in {
      put("/?profileId=1") {
        status should equal(405)
        val agent = InMemoryAgentProfileStorage.get("1",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(!agent.isDefined)
      }
    }

  "Agent API PUT /?profileId=&agent=" must
    "reject with an HTTP 405 error" in {
      put("/?profileId=1&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d") {
        status should equal(405)
        val agent = InMemoryAgentProfileStorage.get("1",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(!agent.isDefined)
      }
    }

  "Agent API PUT /profile" must
    "reject with an HTTP 400 error" in {
      put("/profile") {
        status should equal(400)
        val agent = InMemoryAgentProfileStorage.get("1",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(!agent.isDefined)
      }
    }

  "Agent API PUT /profile?profileId=" must
    "reject with an HTTP 400 error" in {
      put("/profile?profileId=1") {
        status should equal(400)
        val agent = InMemoryAgentProfileStorage.get("1",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(!agent.isDefined)
      }
    }

  "Agent API PUT /profile?profileId=&agent=" must
    "responds with an HTTP 204" in {
      //put("""/profile?profileId=1&agent={"objectType":"Agent","mbox":"mailto:test@beta.projecttincan.com","name":"Test User"}""") {
      put("/profile?profileId=1&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d") {
        status should equal(204)
        val agent = InMemoryAgentProfileStorage.get("1",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(agent.isDefined)
        agent.get.agent.name.get should equal("Test User")
      }
    }

  "Agent API PUT /profile?profileId=&agent= with body" must
    "responds with an HTTP 204" in {
      put("/profile?profileId=1&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d",
        """{"id":"e59"}""", Map("Content-Type" -> """application/json""")) {
          status should equal(204)
          val agent = InMemoryAgentProfileStorage.get("1",
            Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
          assert(agent.isDefined)
          agent.get.agent.name.get should equal("Test User")
          agent.get.content.contents should include("""{"id":"e59"}""")
        }
    }

  //  end PUT requests -----------------------------------

  //  POST requests -----------------------------------

  "Agent API POST /" must
    "reject with an HTTP 405 error" in {
      post("/") {
        status should equal(405)
        val agent = InMemoryAgentProfileStorage.get("2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(!agent.isDefined)
      }
    }

  "Agent API POST /?profileId=" must
    "reject with an HTTP 405 error" in {
      post("/?profileId=2") {
        status should equal(405)
        val agent = InMemoryAgentProfileStorage.get("2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(!agent.isDefined)
      }
    }

  "Agent API POST /?profileId=&agent=" must
    "reject with an HTTP 405 error" in {
      post("/?profileId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d") {
        status should equal(405)
        val agent = InMemoryAgentProfileStorage.get("2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(!agent.isDefined)
      }
    }

  "Agent API POST /profile" must
    "reject with an HTTP 400 error" in {
      post("/profile") {
        status should equal(400)
        val agent = InMemoryAgentProfileStorage.get("2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(!agent.isDefined)
      }
    }

  "Agent API POST /profile?profileId=" must
    "reject with an HTTP 400 error" in {
      post("/profile?profileId=2") {
        status should equal(400)
        val agent = InMemoryAgentProfileStorage.get("2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(!agent.isDefined)
      }
    }

  "Agent API POST /profile?profileId=&agent=" must
    "responds with an HTTP 204" in {
      post("/profile?profileId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d") {
        status should equal(204)
        val agent = InMemoryAgentProfileStorage.get("2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(agent.isDefined)
        agent.get.agent.name.get should equal("Test User")
      }
    }

  "Agent API POST /profile?profileId=&agent= with body" must
    "responds with an HTTP 204" in {
      post("/profile?profileId=3&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d",
        """{"x":"foo","y":"bar"}""", Map("Content-Type" -> """application/json""")) {
          status should equal(204)
          val agent = InMemoryAgentProfileStorage.get("3",
            Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
          assert(agent.isDefined)
          agent.get.agent.name.get should equal("Test User")
          agent.get.content.contents should include("""{"x":"foo","y":"bar"}""")
        }
    }

  "Agent API POST /profile?profileId=&agent= with body merge" must
    "responds with an HTTP 204" in {
      post("/profile?profileId=3&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d",
        """{"x":"bash","z":"faz"}""", Map("Content-Type" -> """application/json""")) {
          status should equal(204)
          val agent = InMemoryAgentProfileStorage.get("3",
            Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
          assert(agent.isDefined)
          agent.get.agent.name.get should equal("Test User")
          agent.get.content.contents should include("""{"y":"bar","x":"bash","z":"faz"}""")
        }
    }
  //  end POST requests -----------------------------------

  //  GET requests -----------------------------------
  "Activity API GET /" must
    "reject with an HTTP 400 error" in {
      get("/") {
        status should equal(400)
      }
    }

  "Activity API GET /?agent=" must
    "responds with an HTTP 200, Expanded Agent Object" in {
      get("/?agent=%7b%22objectType%22:%22Agent%22%2c%22name%22:%22Test%20User%22%7d") {
        status should equal(200)
        //response.body should include("""["mailto:test@beta.projecttincan.com"]""")

        val person = deserializePerson(response.body)
        person.names should contain("Test User")
        person.names should contain("Test User1")
        person.mboxes should contain("mailto:test@beta.projecttincan.com")
      }
    }

  "Activity API GET /profile" must
    "reject with an HTTP 400 error" in {
      get("/profile") {
        status should equal(400)
      }
    }

  "Activity API GET /profile?agent=" must
    "responds with an HTTP 200, List of ids" in {
      get("/profile?agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d") {
        status should equal(200)
        response.body should include(""""3","2","1""")
      }
    }

  "Activity API GET /profile?agent=&profileId=" must
    "responds with an HTTP 200, Profile Content" in {
      get("/profile?profileId=1&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d") {
        status should equal(200)
        response.body should include("""{"id":"e59"}""")
      }
    }

  //  end GET requests -----------------------------------

  //  DELETE requests -----------------------------------

  "Agent API DELETE /" must
    "reject with an HTTP 405 error" in {
      delete("/") {
        status should equal(405)
        val agent = InMemoryAgentProfileStorage.get("2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(agent.isDefined)
      }
    }

  "Agent API DELETE /?profileId=" must
    "reject with an HTTP 405 error" in {
      delete("/?profileId=2") {
        status should equal(405)
        val agent = InMemoryAgentProfileStorage.get("2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(agent.isDefined)
      }
    }

  "Agent API DELETE /?profileId=&agent=" must
    "reject with an HTTP 405 error" in {
      delete("/?profileId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d") {
        status should equal(405)
        val agent = InMemoryAgentProfileStorage.get("2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(agent.isDefined)
      }
    }

  "Agent API DELETE /profile" must
    "reject with an HTTP 400 error" in {
      delete("/profile") {
        status should equal(400)
        val agent = InMemoryAgentProfileStorage.get("2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(agent.isDefined)
      }
    }

  "Agent API DELETE /profile?profileId=" must
    "reject with an HTTP 400 error" in {
      delete("/profile?profileId=2") {
        status should equal(400)
        val agent = InMemoryAgentProfileStorage.get("2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(agent.isDefined)
      }
    }

  "Agent API DELETE /profile?profileId=&agent=" must
    "responds with an HTTP 204" in {
      delete("/profile?profileId=2&agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d") {
        status should equal(204)
        val agent = InMemoryAgentProfileStorage.get("2",
          Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
        assert(!agent.isDefined)
      }
    }

  "Agent API DELETE /profile?agent=" must
    "responds with an HTTP 204" in {
      delete("/profile?agent=%7b%22objectType%22:%22Agent%22%2c%22mbox%22:%22mailto:test%40beta.projecttincan.com%22%2c%22name%22:%22Test%20User%22%7d") {
        if (status.equals(204)) {
          val agent = InMemoryAgentProfileStorage.get("2",
            Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
          assert(!agent.isDefined)
          val agent1 = InMemoryAgentProfileStorage.get("1",
            Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None))
          assert(!agent1.isDefined)
        } else
          status should equal(400)
      }
    }

  //  end DELETE requests -----------------------------------
}
