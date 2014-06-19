package com.arcusys.learn.tincan.lrs

import org.specs2.mutable.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

import com.arcusys.learn.tincan.model._
import com.arcusys.learn.tincan.lrs.agentprofile._
import com.arcusys.learn.tincan.storage.{ ActorStorage, AgentProfileStorage }
import com.arcusys.learn.tincan.lrs.agentprofile.AgentProfileLRSModificationException
import com.arcusys.learn.tincan.lrs.agentprofile.AgentProfileLRSArgumentException
import com.arcusys.learn.tincan.model.Agent
import com.arcusys.learn.tincan.model.AgentProfile
import sun.reflect.generics.reflectiveObjects.NotImplementedException
import org.joda.time.DateTime

@RunWith(classOf[JUnitRunner])
class AgentProfileLRSSpec extends Specification {
  sequential

  private val agent = Agent("Agent", None, None, None, None, None)
  private val document = Document("dId-111", new DateTime(), "", OtherContent)

  private val service = new agentprofile.AgentProfileLRS {
    val agentProfileStorage = InMemoryAgentProfileStorage
    val actorStorage = InMemoryActorStorage
  }

  "Agent Profile LRS Specification".title

  "The 'getPerson' method" should {

    "throw 'AgentProfileLRSArgumentException' if agent is not provided" in {
      service.getPerson(null) must throwA[AgentProfileLRSArgumentException]
    }
  }

  "The 'getAgentDocument' method" should {

    "return the document specified by profile id and agent" in {
      val result = service.getAgentDocument("profileId-666", agent)
      result must beSome
      result.get.id mustEqual "Id-111"
      result.get.cType mustEqual OtherContent
      result.get.contents === ""
    }

    "return nothing if the document is not found for specified profile id and agent" in {
      val result = service.getAgentDocument("profileId-1000", agent)
      result must beNone
    }

    "throw 'AgentProfileLRSArgumentException' if no agent is provided" in {
      service.getAgentDocument("profileId-111", null) must throwA[AgentProfileLRSArgumentException]
    }

    "throw 'AgentProfileLRSArgumentException' if given profile id is an empty string" in {
      service.getAgentDocument("", agent) must throwA[AgentProfileLRSArgumentException]
    }

    "throw 'AgentProfileLRSArgumentException' if given profile id is null" in {
      service.getAgentDocument(null, agent) must throwA[AgentProfileLRSArgumentException]
    }

  }

  "The 'getAgentDocumentIds' method" should {

    "return ids of those profiles that have been stored or updated since the specified timestamp" in {
      InMemoryAgentProfileStorage.reset()
      val since = System.currentTimeMillis() - 17000l
      val result = service.getAgentDocumentIds(agent, Some(new DateTime(since)))
      result must have size 2
      result.contains("profileId-999") must beTrue
      result.contains("profileId-333") must beTrue
    }

    "throw 'AgentProfileLRSArgumentException' if agent is not provided" in {
      service.getAgentDocumentIds(null, Some(new DateTime())) must throwA[AgentProfileLRSArgumentException]
    }

  }

  "The 'addAgentDocument' method" should {

    "add given agent document" in {
      InMemoryAgentProfileStorage.reset()
      InMemoryAgentProfileStorage.all.
        find(d => d.profileId == "profileId-444" && d.agent == agent && d.content == document) must beNone

      service.addAgentDocument("profileId-444", agent, document)

      InMemoryAgentProfileStorage.all.
        find(d => d.profileId == "profileId-444" && d.agent == agent && d.content == document) must beSome
    }

    "throw 'AgentProfileLRSAlreadyExistsException' if the document already exists for given agent and profile id" in {
      service.addAgentDocument("profileId-666", agent, document) must throwA[AgentProfileLRSAlreadyExistsException]
    }

    "throw 'AgentProfileLRSArgumentException' if no agent is provided" in {
      service.addAgentDocument("profileId-111", null, document) must throwA[AgentProfileLRSArgumentException]
    }

    "throw 'AgentProfileLRSArgumentException' if no contents passed in" in {
      service.addAgentDocument("profileId-111", agent, null) must throwA[AgentProfileLRSArgumentException]
    }

    "throw 'AgentProfileLRSArgumentException' if given profile id is an empty string" in {
      service.addAgentDocument("", agent, document) must throwA[AgentProfileLRSArgumentException]
    }

    "throw 'AgentProfileLRSArgumentException' if given profile id is null" in {
      service.addAgentDocument(null, agent, document) must throwA[AgentProfileLRSArgumentException]
    }

  }

  "The 'modifyAgentDocument' method" should {

    //"modify (merge) contents of given document and the existing one if they content's type is json" ! pending

    "modify content of the existing document by given one if they content's type is binary" in {
      service.modifyAgentDocument("profileId-666", agent, document.copy(contents = "testing"))
      val updated = InMemoryAgentProfileStorage.all.find(d => d.profileId == "profileId-666" && d.agent == agent)
      updated must beSome
      updated.get.content.contents === "testing"
    }

    "throw 'AgentProfileLRSModificationException' if content of given document is binary" +
      "whereas content of the stored one is json" in {
        InMemoryAgentProfileStorage.reset()
        service.modifyAgentDocument("profileId-999", agent, document) must
          throwA[AgentProfileLRSModificationException]
      }

    "throw 'AgentProfileLRSModificationException' if content of given document is json" +
      "whereas content of the stored one is binary" in {
        InMemoryAgentProfileStorage.reset()
        service.modifyAgentDocument("profileId-666", agent, document.copy(cType = JSONContent)) must
          throwA[AgentProfileLRSModificationException]
      }

    "throw 'AgentProfileLRSNotExistsException' if requested document for modification doesn't even exists" in {
      service.modifyAgentDocument("profileId-1000", agent, document) must throwA[AgentProfileLRSNotExistsException]
    }

    "throw 'AgentProfileLRSArgumentException' if no agent is provided" in {
      service.modifyAgentDocument("profileId-111", null, document) must throwA[AgentProfileLRSArgumentException]
    }

    "throw 'AgentProfileLRSArgumentException' if no contents passed in" in {
      service.modifyAgentDocument("profileId-111", agent, null) must throwA[AgentProfileLRSArgumentException]
    }

    "throw 'AgentProfileLRSArgumentException' if given profile id is an empty string" in {
      service.modifyAgentDocument("", agent, document) must throwA[AgentProfileLRSArgumentException]
    }

    "throw 'AgentProfileLRSArgumentException' if given profile id is null" in {
      service.modifyAgentDocument(null, agent, document) must throwA[AgentProfileLRSArgumentException]
    }

  }

  "The deleteAgentDocument" should {

    "remove document for specified profile and agent" in {
      InMemoryAgentProfileStorage.reset()
      InMemoryAgentProfileStorage.all.find(d => d.profileId == "profileId-666" && d.agent == agent) must beSome
      service.deleteAgentDocument("profileId-666", agent)
      InMemoryAgentProfileStorage.all.find(d => d.profileId == "profileId-666" && d.agent == agent) must beNone
    }

    //"do nothing if document doesn't exist for given agent and profile id" ! pending

    "throw 'AgentProfileLRSArgumentException' if no agent is provided" in {
      service.deleteAgentDocument("profileId-111", null) must throwA[AgentProfileLRSArgumentException]
    }

    "throw 'AgentProfileLRSArgumentException' if given profile id is an empty string" in {
      service.deleteAgentDocument("", agent) must throwA[AgentProfileLRSArgumentException]
    }

    "throw 'AgentProfileLRSArgumentException' if given profile id is null" in {
      service.deleteAgentDocument(null, agent) must throwA[AgentProfileLRSArgumentException]
    }

  }

}

object InMemoryActorStorage extends ActorStorage {

  private val defaults =
    List[Actor](Agent("Agent", Some("Test User"), Some("mailto:test@beta.projecttincan.com"), None, None, None),
      Agent("Agent", Some("Test User1"), Some("mailto:test1@beta.projecttincan.com"), None, None, None))

  @volatile
  private[this] var actors = defaults

  private val lock = new AnyRef

  def all = actors

  def getPerson(agent: Agent): Person = {
    val person = new Person(Seq("Test User"), Seq("mailto:test@beta.projecttincan.com"), Seq(), Seq(), Seq())
    all.foreach((a: Actor) => {
      if (a.isInstanceOf[Agent] && a.asInstanceOf[Agent].FilterCompare(agent))
        person.AddAgent(a.asInstanceOf[Agent])
    })
    person
  }

  //def get(actorID: Int): Option[Actor]
  def create(entity: Actor): Unit = lock.synchronized {
    actors = entity :: all
  }

  //def createAndGetID(entity: Actor): Int
  def renew(): Unit = ()

  override def getByIFI(objectType: String, mbox: Option[String], mbox_sha1sum: Option[String], openid: Option[String], account: Option[Account]): Option[Actor] = None

  override def createAndGetID(entity: Actor): Int = 0

  override def getByID(actorID: Int): Option[Actor] = None
}

object InMemoryAgentProfileStorage extends AgentProfileStorage {
  private val currentTime = System.currentTimeMillis()

  private val defaults = List(
    AgentProfile("profileId-666",
      Agent("Agent", None, None, None, None, None),
      Document("Id-111", new DateTime(currentTime - 20000l), "", OtherContent)),
    AgentProfile("profileId-999",
      Agent("Agent", None, None, None, None, None),
      Document("Id-222", new DateTime(currentTime - 15000l), "{x: \"1\"}", JSONContent)),
    AgentProfile("profileId-333",
      Agent("Agent", None, None, None, None, None),
      Document("Id-222", new DateTime(currentTime - 10000l), "{x: \"2\"}", JSONContent))

  )

  @volatile
  private[this] var documents = defaults

  private val lock = new AnyRef

  def all = documents

  //  def getPerson(agent: Agent): Person ={
  //    val person = new Person(Seq(),Seq(),Seq(),Seq(),Seq())
  //    all.foreach((ap: AgentProfile) => {if(ap.agent.FilterCompare(agent)) person.AddAgent(ap.agent)})
  //    person
  //  }

  def get(profileId: String, agent: Agent): Option[AgentProfile] =
    all.find(d => d.profileId == profileId && d.agent == agent)

  def getIds(agent: Agent, since: Option[DateTime]): Seq[String] =
    all.filter(p => p.agent == agent &&
      (!since.isDefined || p.content.updated.getMillis >= since.get.getMillis))
      .map(_.profileId)

  def create(entity: AgentProfile): Unit = lock.synchronized {
    documents = entity :: all
  }

  def modify(entity: AgentProfile): Unit = lock.synchronized {
    documents = entity :: all.filter(d => !(d.profileId == entity.profileId && d.agent == entity.agent))
  }

  def delete(profileId: String, agent: Agent): Unit = lock.synchronized {
    documents = all.filter(d => !(d.profileId == profileId && d.agent == agent))
  }

  def reset(): Unit = lock.synchronized {
    documents = defaults
  }

  def renew(): Unit = throw new NotImplementedException
}
