package com.arcusys.learn.test.tincan

import java.io.PrintWriter

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import com.arcusys.learn.tincan.lrs.state.StateLRS
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.tincan.storage.{ DocumentStorage, ActorStorage, AgentProfileStorage, StateStorage }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.joda.time.DateTime

class StateProfileTests(writer: PrintWriter) extends Injectable {
  override implicit def bindingModule: BindingModule = Configuration
  private val stateLrs = new StateLRS {
    val stateStorage: StateStorage = inject[StateStorage]
  }

  private val tincanLrsActorStorage = inject[ActorStorage]
  private val tincanLrsDocumentStorage = inject[DocumentStorage]

  def renew() {
    tincanLrsActorStorage.renew()
    stateLrs.stateStorage.renew()
    tincanLrsDocumentStorage.renew()
  }

  def createAndReadTest() {
    renew()
    val agent = Agent("Agent", Some("agent name"), Some("q@q.q"), Some("12345"), None, Some(Account("hp", "name")))
    val state = State("activId", "stateId", agent, None, Document("the content", JSONContent))

    stateLrs.addStateDocument(state)
    val actualDocument = stateLrs.getStateDocument(state.activityId, state.stateId, state.agent, None)

    if (state.content != actualDocument.getOrElse(throw new IllegalArgumentException("Document not found"))) {
      throw new Exception("Different document")
    }
    writer.write("state profile document, createAndRead SUCCESS <br>")
  }

  def createAndReadWithEmptyAgentTest() {
    renew()
    val agent = Agent("Agent", Some(""), Some("q@q.q"), None, None, None)
    val state = State("activId", "stateId", agent, None, Document("the content", JSONContent))

    stateLrs.addStateDocument(state)
    val actualDocument = stateLrs.getStateDocument(state.activityId, state.stateId, state.agent, None)

    if (state.content != actualDocument.getOrElse(throw new IllegalArgumentException("Document not found"))) {
      throw new Exception("Different document")
    }
    writer.write("state profile document, createAndRead with empty Agent SUCCESS <br>")
  }

  def createAndReadWithEmptyAgentTest2() {
    renew()
    val agent = deserializeAgent("""{"objectType":"Agent","mbox":"mailto:","name":""}""")
    println(agent + "<br>")
    val state = State("activId", "stateId", agent, None, Document("the content", JSONContent))

    stateLrs.addStateDocument(state)
    val actualDocument = stateLrs.getStateDocument(state.activityId, state.stateId, state.agent, None)

    if (state.content != actualDocument.getOrElse(throw new IllegalArgumentException("Document not found"))) {
      throw new Exception("Different document")
    }
    writer.write("state profile document, createAndRead with empty Agent 2 SUCCESS <br>")
  }

  def createAndReadWithEmptyAgentTestMultiple() {
    renew()
    val agent = deserializeAgent("""{"objectType":"Agent","mbox":"mailto:","name":""}""")
    println(agent + "<br>")
    val dateFrom = new DateTime()
    val state = State("activId", "stateId", agent, None, Document("the content", JSONContent))
    val state2 = State("activId", "stateId2", agent, None, Document("the content2", JSONContent))

    stateLrs.addStateDocument(state)
    stateLrs.addStateDocument(state2)
    val actualDocuments = stateLrs.getStateDocumentIds(state.activityId, state.agent, None, Some(dateFrom))

    if (actualDocuments.size != 2) throw new Exception("Not enough documents in " + actualDocuments)

    writer.write("state profile document, Multiple Document GET SUCCESS <br>")
  }
}
