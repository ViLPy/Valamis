package com.arcusys.learn.test.tincan

import java.io.PrintWriter
import com.arcusys.learn.tincan.lrs.state.StateLRS
import com.arcusys.learn.tincan.lrs.agentprofile.AgentProfileLRS
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.tincan.model.Account
import com.arcusys.learn.tincan.model.State
import com.arcusys.learn.tincan.model.Agent
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.tincan.storage.StateStorage
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer._
import com.arcusys.learn.tincan.model.State
import com.arcusys.learn.tincan.model.Agent
import com.arcusys.learn.tincan.model.Account
import scala.Some
import java.util.Date

class StateProfileTests(writer: PrintWriter, storageFactory: StorageFactoryContract) {

  private val stateLrs = new StateLRS {
    val stateStorage: StateStorage = storageFactory.tincanLrsStateStorage
  }

  def renew() {
    storageFactory.tincanLrsActorStorage.renew()
    storageFactory.tincanLrsStateStorage.renew()
    storageFactory.tincanLrsDocumentStorage.renew()
  }

  def createAndReadTest() {
    renew()
    val agent = Agent("Agent", Some("agent name"), Some("q@q.q"), Some("12345"), None, Some(Account("hp","name")))
    val state = State("activId", "stateId", agent, None, Document("the content", JSONContent) )

    stateLrs.addStateDocument( state )
    val actualDocument = stateLrs.getStateDocument(state.activityId, state.stateId, state.agent, None )

    if (state.content != actualDocument.getOrElse(throw new IllegalArgumentException("Document not found"))) {
      throw new Exception("Different document")
    }
    writer.write("state profile document, createAndRead SUCCESS <br>")
  }

  def createAndReadWithEmptyAgentTest() {
    renew()
    val agent = Agent("Agent", Some(""), None, None, None, None)
    val state = State("activId", "stateId", agent, None, Document("the content", JSONContent) )

    stateLrs.addStateDocument( state )
    val actualDocument = stateLrs.getStateDocument(state.activityId, state.stateId, state.agent, None )

    if (state.content != actualDocument.getOrElse(throw new IllegalArgumentException("Document not found"))) {
      throw new Exception("Different document")
    }
    writer.write("state profile document, createAndRead with empty Agent SUCCESS <br>")
  }

  def createAndReadWithEmptyAgentTest2() {
    renew()
    val agent = deserializeAgent("""{"objectType":"Agent","mbox":"mailto:","name":""}""")
    println( agent + "<br>")
    val state = State("activId", "stateId", agent, None, Document("the content", JSONContent) )

    stateLrs.addStateDocument( state )
    val actualDocument = stateLrs.getStateDocument(state.activityId, state.stateId, state.agent, None )

    if (state.content != actualDocument.getOrElse(throw new IllegalArgumentException("Document not found"))) {
      throw new Exception("Different document")
    }
    writer.write("state profile document, createAndRead with empty Agent 2 SUCCESS <br>")
  }

  def createAndReadWithEmptyAgentTestMultiple() {
    renew()
    val agent = deserializeAgent("""{"objectType":"Agent","mbox":"mailto:","name":""}""")
    println( agent + "<br>")
    val dateFrom = new Date()
    val state = State("activId", "stateId", agent, None, Document("the content", JSONContent) )
    val state2 = State("activId", "stateId2", agent, None, Document("the content2", JSONContent) )

    stateLrs.addStateDocument( state )
    stateLrs.addStateDocument( state2 )
    val actualDocuments = stateLrs.getStateDocumentIds(state.activityId, state.agent, None, dateFrom )

    if (actualDocuments.size != 2) throw new Exception("Not enough documents in " + actualDocuments)

    writer.write("state profile document, Multiple Document GET SUCCESS <br>")
  }
}
