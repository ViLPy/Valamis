package com.arcusys.learn.test.tincan

import java.io.PrintWriter
import com.arcusys.learn.tincan.lrs.state.StateLRS
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.tincan.storage.{AgentProfileStorage, StateStorage}
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import scala.Some
import com.arcusys.learn.tincan.lrs.agentprofile.AgentProfileLRS
import java.util.Date
import scala.Some
import com.arcusys.learn.tincan.model.Agent
import com.arcusys.learn.tincan.model.Account
import scala.Some

class AgentProfileTests(writer: PrintWriter, storageFactory: StorageFactoryContract) {

  private val agentProfileLrs = new AgentProfileLRS {
    val agentProfileStorage: AgentProfileStorage = storageFactory.tincanLrsAgentProfileStorage
  }

  def renew() {
    storageFactory.tincanLrsActorStorage.renew()
    storageFactory.tincanLrsAgentProfileStorage.renew()
    storageFactory.tincanLrsDocumentStorage.renew()
  }

  def createAndReadTest() {
    renew()
    val profileId = "zdxfaf"
    val agent = Agent("Agent", Some("agent name"), Some("q@q.q"), Some("12345"), None, Some(Account("hp","name")))
    val document = Document("the content", JSONContent)

    agentProfileLrs.addAgentDocument(profileId, agent, document)
    val actualDocument = agentProfileLrs.getAgentDocument(profileId, agent)

    if (document != actualDocument.getOrElse(throw new IllegalArgumentException("Document not found"))) {
      throw new Exception("Different document")
    }
    writer.write("agent profile document, createAndRead SUCCESS <br>")
  }

  def createAndReadWithEmptyAgentTest() {
    renew()
    val profileId = "zdxfaf"
    val agent = Agent("Agent", Some(""), None, None, None, None)
    val document = Document("the content", JSONContent)

    agentProfileLrs.addAgentDocument(profileId, agent, document)
    val actualDocument = agentProfileLrs.getAgentDocument(profileId, agent)

    if (document != actualDocument.getOrElse(throw new IllegalArgumentException("Document not found"))) {
      throw new Exception("Different document")
    }
    writer.write("agent profile document, createAndRead with empty Agent SUCCESS <br>")
  }

  def createAndReadWithEmptyAgentTest2() {
    renew()
    val profileId = "zdxfaf"
    val agent = deserializeAgent("""{"objectType":"Agent","mbox":"mailto:","name":""}""")
    val document = Document("the content", JSONContent)

    agentProfileLrs.addAgentDocument(profileId, agent, document)
    val actualDocument = agentProfileLrs.getAgentDocument(profileId, agent)

    if (document != actualDocument.getOrElse(throw new IllegalArgumentException("Document not found"))) {
      throw new Exception("Different document")
    }
    writer.write("agent profile document, createAndRead with empty Agent 2 SUCCESS <br>")
  }

  def createMany() {
    renew()
    val agent = deserializeAgent("""{"objectType":"Agent","mbox":"mailto:","name":""}""")
    val documents = Set(
      "qwe" -> Document("the content", JSONContent),
      "asd" -> Document("the content 2", JSONContent),
      "xcv" -> Document("the content 3", OtherContent)
    )

    documents.foreach(p=> agentProfileLrs.addAgentDocument(p._1, agent, p._2))

    writer.write("agent profile document, create many SUCCESS <br>")
  }
}
