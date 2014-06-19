package com.arcusys.learn.tincan.lrs

import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith

import java.util.{ Date, UUID }

import com.arcusys.learn.tincan.model._
import com.arcusys.learn.tincan.lrs.state._
import com.arcusys.learn.tincan.storage.StateStorage
import com.arcusys.learn.tincan.model.State
import com.arcusys.learn.tincan.model.Agent
import com.arcusys.learn.tincan.lrs.state.StateLRSDocumentAlreadyExistsException
import com.arcusys.learn.tincan.lrs.state.StateLRSDocumentModificationException
import com.arcusys.learn.tincan.model.State
import com.arcusys.learn.tincan.lrs.state.StateLRSArgumentException
import com.arcusys.learn.tincan.model.Agent
import org.joda.time.DateTime

@RunWith(classOf[JUnitRunner])
class StateLRSSpec extends Specification {
  sequential

  private val service = new state.StateLRS {
    val stateStorage: StateStorage = InMemoryStateStorage
  }

  private val agent = Agent("Agent", None, None, None, None, None)

  "State LRS Specification".title

  "The 'addStateDocument' method" should {

    "add state document" in {
      val s = State("activityId-1000", "stateId-0001", agent, None, Document("dId-1", new DateTime(), "1", OtherContent))
      InMemoryStateStorage.all.find(d =>
        d.activityId == s.activityId &&
          d.stateId == s.stateId &&
          d.agent == s.agent &&
          d.registration == s.registration) must beNone

      service.addStateDocument(s)

      InMemoryStateStorage.all.filter(d =>
        d.activityId == s.activityId &&
          d.stateId == s.stateId &&
          d.agent == s.agent &&
          d.registration == s.registration) must have size 1
    }

    "throw 'StateLRSDocumentAlreadyExistsException' if given document already exists" in {
      val s = State("activityId-666", "stateId-999", agent, None, Document("dId-111", new DateTime, "1", OtherContent))
      service.addStateDocument(s) must throwA[StateLRSDocumentAlreadyExistsException]
      InMemoryStateStorage.all.filter(d =>
        d.activityId == s.activityId &&
          d.stateId == s.stateId &&
          d.agent == s.agent &&
          d.registration == s.registration) must have size 1
    }

    "throw 'StateLRSArgumentException' if given state document object is null" in {
      service.addStateDocument(null) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if given activityId is null" in {
      val state = State(null, "stateId-111", agent, None, Document("id-111", new DateTime, "", OtherContent))
      service.addStateDocument(state) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if given activityId is an empty string" in {
      val state = State("", "stateId-111", agent, None, Document("id-111", new DateTime, "", OtherContent))
      service.addStateDocument(state) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if given state id is null" in {
      val state = State("aId-111", null, agent, None, Document("id-111", new DateTime, "", OtherContent))
      service.addStateDocument(state) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if given state id is an empty string" in {
      val state = State("aId-11", "", agent, None, Document("id-111", new DateTime, "", OtherContent))
      service.addStateDocument(state) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if given agent is null" in {
      val state = State("aId-11", "stateId-111", null, None, Document("id-111", new DateTime, "", OtherContent))
      service.addStateDocument(state) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if there is no content " in {
      val state = State("aId-11", "stateId-111", agent, None, null)
      service.addStateDocument(state) must throwA[StateLRSArgumentException]
    }

  }

  "The 'modifyStateDocument' method" should {

    //"merge given document with existing one if they content's type is json" ! pending

    "modify existing document content if both the existing document and the given one have binary content type" in {
      val state = State("activityId-333", "stateId-777",
        agent, Some(UUID.fromString("e093cd74-f691-4cd6-9667-17480c7f0bfd")),
        Document("dId-111", new DateTime(), "10", OtherContent))
      service.modifyStateDocument(state)

      val updated = InMemoryStateStorage.all.find(s =>
        s.activityId == state.activityId &&
          s.stateId == state.stateId &&
          s.agent == state.agent &&
          s.registration == state.registration)
      updated must beSome
      updated.get.content.contents === "10"
    }

    "throw 'StateLRSDocumentModificationException' if given document content's type is not json but existing one's is" in {
      InMemoryStateStorage.reset()
      val s = State("activityId-666", "stateId-666", agent, None, Document("dId-11", new DateTime, "1", OtherContent))
      service.modifyStateDocument(s) must throwA[StateLRSDocumentModificationException]

    }

    "throw 'StateLRSDocumentModificationException' if existing one content's type is not json but given one's is" in {
      InMemoryStateStorage.reset()
      val s = State("activityId-666", "stateId-999", agent, None, Document("dId-11", new DateTime, "{x: 1}", JSONContent))
      service.modifyStateDocument(s) must throwA[StateLRSDocumentModificationException]
    }

    "throw 'StateLRSNotExistsException' if specified state document doesn't even exist" in {
      val s = State("activityId-111", "stateId-111", agent, None, Document("dId-11", new DateTime, "", OtherContent))
      service.modifyStateDocument(s) must throwA[StateLRSNotExistsException]
    }

    "throw 'StateLRSArgumentException' if given state document object is null" in {
      service.modifyStateDocument(null) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if given activityId is null" in {
      val state = State(null, "stateId-111", agent, None, Document("dId-11", new DateTime, "", OtherContent))
      service.modifyStateDocument(state) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if given activityId is an empty string" in {
      val state = State("", "stateId-111", agent, None, Document("dId-11", new DateTime, "", OtherContent))
      service.modifyStateDocument(state) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if given state id is null" in {
      val state = State("activityId-111", null, agent, None, Document("dId-11", new DateTime, "", OtherContent))
      service.modifyStateDocument(state) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if given state id is an empty string" in {
      val state = State("activityId-111", "", agent, None, Document("dId-11", new DateTime, "", OtherContent))
      service.modifyStateDocument(state) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if given agent is null" in {
      val state = State("activityId-111", "stateId-111", null, None, Document("dId-11", new DateTime, "", OtherContent))
      service.modifyStateDocument(state) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if there is no content " in {
      val state = State("activityId-111", "stateId-111", agent, None, null)
      service.modifyStateDocument(state) must throwA[StateLRSArgumentException]
    }

  }

  "The 'getStateDocument' method" should {

    "return requested document if exist" in {
      InMemoryStateStorage.reset()
      val agent = Agent("Agent", None, None, None, None, None)
      val result = service.getStateDocument("activityId-666", "stateId-999", agent, None)
      result must beSome
      result.get.id mustEqual "dId-111"
      result.get.contents mustEqual "a"
    }

    "return 'NoStateDocumentFound' if requested document doesn't exist" in {
      val result = service.getStateDocument("activityId-1", "stateId-1", agent, None)
      result must beNone
    }

    "throw 'StateArgumentException' if required activity id is null" in {
      service.getStateDocument(null, "stateId-1", agent, None) must throwA[StateLRSArgumentException]
    }

    "throw 'StateArgumentException' if required activity id is an empty string" in {
      service.getStateDocument("", "stateId-1", agent, None) must throwA[StateLRSArgumentException]
    }

    "throw 'StateArgumentException' if required state id is null" in {
      service.getStateDocument("activityId-1", null, agent, None) must throwA[StateLRSArgumentException]
    }

    "throw 'StateArgumentException' if required state id is an empty string" in {
      service.getStateDocument("activityId-1", "", agent, None) must throwA[StateLRSArgumentException]
    }

    "throw 'StateArgumentException' if required agent is not provided" in {
      service.getStateDocument("activityId-1", "stateId-1", null, None) must throwA[StateLRSArgumentException]
    }

  }

  "The 'getStateDocumentIds' method" should {

    "return state ids for given activity id, agent and specified registration" in {
      InMemoryStateStorage.reset()
      val since = System.currentTimeMillis - 12000l
      val result = service.getStateDocumentIds(
        "activityId-666", agent, Some(UUID.fromString("e093cd74-f691-4cd6-9667-17480c7f0bfd")), Some(new DateTime(since)))
      result must have size 1
    }

    "return ids of those states that have been stored or updated since the specified timestamp" in {
      InMemoryStateStorage.reset()
      val since = System.currentTimeMillis - 13000l
      val result = service.getStateDocumentIds("activityId-666", agent, None, Some(new DateTime(since)))
      result must have size 1
      result.contains("stateId-666") must beTrue
      //result.contains("stateId-888") must beTrue
    }

    "throw 'StateLRSArgumentException' if required activity id is null" in {
      service.getStateDocumentIds(null, agent, None, None) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if required activity id is an empty string" in {
      service.getStateDocumentIds("", agent, None, None) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if required agent is null" in {
      service.getStateDocumentIds("activityId-111", null, None, None) must throwA[StateLRSArgumentException]
    }

  }

  "The 'deleteStateDocument' method" should {

    "remove the specified document if exists" in {
      InMemoryStateStorage.reset()
      InMemoryStateStorage.all.find(d =>
        d.activityId == "activityId-333" &&
          d.stateId == "stateId-777" &&
          d.agent == agent &&
          d.registration == Some(UUID.fromString("e093cd74-f691-4cd6-9667-17480c7f0bfd"))) must beSome

      service.deleteStateDocument("activityId-333", "stateId-777", agent,
        Some(UUID.fromString("e093cd74-f691-4cd6-9667-17480c7f0bfd")))

      InMemoryStateStorage.all.find(d =>
        d.activityId == "activityId-333" &&
          d.stateId == "stateId-777" &&
          d.agent == agent &&
          d.registration == Some(UUID.fromString("e093cd74-f691-4cd6-9667-17480c7f0bfd"))) must beNone
    }

    "remove the specified document even though registration is not provided" in {
      InMemoryStateStorage.reset()
      InMemoryStateStorage.all.find(d =>
        d.activityId == "activityId-666" &&
          d.stateId == "stateId-999" &&
          d.agent == agent &&
          d.registration == None) must beSome

      service.deleteStateDocument("activityId-666", "stateId-999", agent, None)

      InMemoryStateStorage.all.find(d =>
        d.activityId == "activityId-666" &&
          d.stateId == "stateId-999" &&
          d.agent == agent &&
          d.registration == None) must beNone
    }

    "do nothing if the specified document doesn't even exist" in {
      service.deleteStateDocument("activityId-1", "stateId-1", agent, None)
      InMemoryStateStorage.all.find(s =>
        s.activityId == "activityId-1" &&
          s.stateId == "stateId-1" &&
          s.agent == agent &&
          s.registration == None) must beNone
    }

    "throw 'StateArgumentException' if required activity id is null" in {
      service.deleteStateDocument(null, "stateId-111", agent, None) must throwA[StateLRSArgumentException]
    }

    "throw 'StateArgumentException' if required activity id is an empty string" in {
      service.deleteStateDocument("", "stateId-111", agent, None) must throwA[StateLRSArgumentException]
    }

    "throw 'StateArgumentException' if required state id is null" in {
      service.deleteStateDocument("activityId-111", null, agent, None) must throwA[StateLRSArgumentException]
    }

    "throw 'StateArgumentException' if required state id is an empty string" in {
      service.deleteStateDocument("activityId-111", "", agent, None) must throwA[StateLRSArgumentException]
    }

    "throw 'StateArgumentException' if required agent is not provided" in {
      service.deleteStateDocument("activityId-111", "stateId-111", null, None) must throwA[StateLRSArgumentException]
    }

  }

  "The 'deleteStateDocuments' method" should {

    "remove all state documents which satisfy given activity id and agent" in {
      InMemoryStateStorage.reset()
      service.deleteStateDocuments("activityId-666", agent, None)
      InMemoryStateStorage.all.
        filter(d => d.activityId == "activityId-666" && d.agent == agent && !d.registration.isDefined) must have size 0
    }

    "remove all state documents which satisfy given activity id and agent as well as registration" in {
      InMemoryStateStorage.reset()
      service.deleteStateDocuments("activityId-666", agent, Some(UUID.fromString("e093cd74-f691-4cd6-9667-17480c7f0bfd")))
      InMemoryStateStorage.all.
        filter(d =>
          d.activityId == "activityId-666" &&
            d.agent == agent &&
            d.registration == Some(UUID.fromString("e093cd74-f691-4cd6-9667-17480c7f0bfd"))) must have size 0
    }

    "throw 'StateLRSArgumentException' if required activity id is null" in {
      service.deleteStateDocuments(null, agent, None) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if required activity id is an empty string" in {
      service.deleteStateDocuments("", agent, None) must throwA[StateLRSArgumentException]
    }

    "throw 'StateLRSArgumentException' if required agent is not provided" in {
      service.deleteStateDocuments("activityId-111", null, None) must throwA[StateLRSArgumentException]
    }

  }

}

object InMemoryStateStorage extends StateStorage {
  private val currentTime = System.currentTimeMillis()

  private val defaults = List(
    State("activityId-666", "stateId-999",
      Agent("Agent", None, None, None, None, None), None,
      Document("dId-111", new DateTime(currentTime - 20000l), "a", OtherContent)
    ),
    State("activityId-333", "stateId-777",
      Agent("Agent", None, None, None, None, None), Some(UUID.fromString("e093cd74-f691-4cd6-9667-17480c7f0bfd")),
      Document("dId-111", new DateTime(currentTime - 15000l), "5", OtherContent)
    ),
    State("activityId-666", "stateId-666",
      Agent("Agent", None, None, None, None, None), None,
      Document("dId-222", new DateTime(currentTime - 10000l), "{x: 1}", JSONContent)
    ),
    State("activityId-666", "stateId-888",
      Agent("Agent", None, None, None, None, None), Some(UUID.fromString("e093cd74-f691-4cd6-9667-17480c7f0bfd")),
      Document("dId-333", new DateTime(currentTime - 5000l), "c", OtherContent)
    )
  )

  @volatile
  private[this] var documents = defaults
  private[this] val lock = AnyRef

  def get(activityId: String, stateId: String, agent: Agent, registration: Option[UUID]): Option[State] =
    all.find(d =>
      d.activityId == activityId &&
        d.stateId == stateId &&
        d.agent == agent &&
        d.registration == registration)

  def getIds(activityId: String, agent: Agent, registration: Option[UUID], since: Option[DateTime]): Seq[String] = all.filter(d =>
    d.activityId == activityId &&
      d.agent == agent &&
      (d.registration == registration) &&
      (!since.isDefined || d.content.updated.getMillis >= since.get.getMillis)
  ).map(_.stateId)

  def create(state: State): Unit = lock.synchronized {
    documents = state :: all
  }

  def modify(state: State): Unit = lock.synchronized {
    val filtered = all.filter(s =>
      !(s.activityId == state.activityId &&
        s.stateId == state.stateId &&
        s.agent == state.agent &&
        s.registration == state.registration))
    documents = state :: filtered
  }

  def delete(activityId: String, stateId: String, agent: Agent, registration: Option[UUID]): Unit = lock.synchronized {
    documents = all.filter(d =>
      !(d.activityId == activityId &&
        d.stateId == stateId &&
        d.agent == agent &&
        d.registration == registration))
  }

  def delete(activityId: String, agent: Agent, registration: Option[UUID]): Unit = lock.synchronized {
    documents = all.filter(d =>
      !(d.activityId == activityId &&
        d.agent == agent &&
        (!d.registration.isDefined ||
          d.registration == registration)))
  }

  def all = documents

  def reset(): Unit = lock.synchronized {
    documents = defaults
  }

  def renew() { reset() }
}