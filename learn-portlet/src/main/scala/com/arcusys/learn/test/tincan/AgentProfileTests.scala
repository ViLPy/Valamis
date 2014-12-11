package com.arcusys.learn.test.tincan

import java.io.PrintWriter

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import com.arcusys.learn.tincan.lrs.agentprofile.AgentProfileLRS
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.tincan.storage.{ DocumentStorage, ActorStorage, AgentProfileStorage }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class AgentProfileTests(writer: PrintWriter) extends Injectable {
  override implicit def bindingModule: BindingModule = Configuration
  private val agentProfileLrs = new AgentProfileLRS {
    val agentProfileStorage: AgentProfileStorage = inject[AgentProfileStorage]
    val actorStorage: ActorStorage = inject[ActorStorage]
  }
  private val tincanLrsDocumentStorage = inject[DocumentStorage]

  def renew() {
    agentProfileLrs.agentProfileStorage.renew()
    agentProfileLrs.actorStorage.renew()
    tincanLrsDocumentStorage.renew()
  }

  def createAndReadTest() {
    renew()
    val profileId = "zdxfaf"
    val agent = Agent("Agent", Some("agent name"), Some("q@q.q"), Some("12345"), None, Some(Account("hp", "name")))
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
    val agent = Agent("Agent", Some("Test"), Some("p@p.com"), None, None, None)
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

    documents.foreach(p => agentProfileLrs.addAgentDocument(p._1, agent, p._2))

    writer.write("agent profile document, create many SUCCESS <br>")
  }
}
