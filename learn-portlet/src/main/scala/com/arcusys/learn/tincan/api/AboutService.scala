package com.arcusys.learn.tincan.api

import com.arcusys.learn.tincan.api.utils.TincanMethodOverride
import com.arcusys.learn.tincan.lrs.statement.StatementLRS
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.test.tincan.{ActivityProfileTests, AgentProfileTests, StateProfileTests, StatementTests}
import com.escalatesoft.subcut.inject.BindingModule

// http://example.com/xAPI/about
class AboutService(configuration: BindingModule) extends ServletBase(configuration) with TincanMethodOverride {
  def this() = this(Configuration)

  val statementLRS = new StatementLRS() {
    val statementStorage = storageFactory.tincanLrsStatementStorage
  }

  /*initRotes()

  get("/init") {
    initRotes()
  }*/

  private def initRotes() {
    get("/") {
      halt(400, "Not implemented")
    }

    get("/test") {

      val writer = response.getWriter

      val statementTests = new StatementTests(writer, statementLRS)

      writer.write("*** The 'addStatement' method <br>")
      statementTests.testCreateAndRead()
      statementTests.testCreateAlreadyExist()
      statementTests.testCreateWithNullStatement()

      writer.write("*** The 'addStatements' method <br>")
      statementTests.testCreateStatements()
      statementTests.testCreateNotExistedStatements()
      statementTests.testCreateUniqueStatements()
      statementTests.testCreateWithNullList()

      writer.write("*** The 'getStatement' method <br>")
      statementTests.testGetExistStatement()
      statementTests.testGetNotExist()
      statementTests.testGetWithNullId()

      writer.write("*** The 'getStatements' method <br>")
      statementTests.testGetAll()
      statementTests.testGetById()
      statementTests.testGetOneByVerbId()
      statementTests.testGetSeveralByVerbId()
      statementTests.testGetByActivity()
      statementTests.testGetByAgent()
      statementTests.testGetBySinceDate()
      statementTests.testGetByUntilDate()
      statementTests.testGetByDateBoundary()

      statementTests.testGetByActivityAndAgent()
      statementTests.testGetByActivityAndVerb()
      statementTests.testGetByActivityAndSinceDate()
      statementTests.testGetByActivityAndUntilDate()

      statementTests.testGetByAgentAndVerb()
      statementTests.testGetByAgentAndSinceDate()
      statementTests.testGetByAgentAndUntilDate()

      statementTests.testGetByVerbAndSinceDate()
      statementTests.testGetByVerbAndUntilDate()

      statementTests.testGetBySeveralParameters()

      statementTests.testGetWithStatementAndVoidedId()
      statementTests.testGetWithStatementIdAndAgent()
      statementTests.testGetWithStatementIdAndVerbId()
      statementTests.testGetWithStatementIdAndActivityId()
      statementTests.testGetWithStatementIdAndRegistrationId()
      statementTests.testGetWithStatementIdAndDateSince()
      statementTests.testGetWithStatementIdAndDateUntil()
      statementTests.testGetWithVoidedIdAndAgent()
      statementTests.testGetWithVoidedIdAndVerbId()
      statementTests.testGetWithVoidedIdAndActivityId()
      statementTests.testGetWithVoidedIdAndRegistrationId()
      statementTests.testGetWithVoidedIdAndDateSince()
      statementTests.testGetWithVoidedIdAndDateUntil()

      writer.write("*** Renew base <br>")
      statementTests.testRenewBase()


      writer.write("*** STATE Tests <br>")
      val stateTests = new StateProfileTests(writer, storageFactory)

      stateTests.createAndReadTest()
      stateTests.createAndReadWithEmptyAgentTest()
      stateTests.createAndReadWithEmptyAgentTest2()
      stateTests.createAndReadWithEmptyAgentTestMultiple()


      writer.write("*** Agent profile Tests <br>")
      val agentTests = new AgentProfileTests(writer, storageFactory)
      agentTests.createAndReadTest()
      agentTests.createAndReadWithEmptyAgentTest()
      agentTests.createAndReadWithEmptyAgentTest2()
      agentTests.createMany()


      writer.write("*** Activity profile Tests <br>")
      val activityTests = new ActivityProfileTests(writer, storageFactory)
      activityTests.createAndReadTest()


      storageFactory.tincanLrsDocumentStorage.renew()
      storageFactory.tincanLrsStatementStorage.renew()
      storageFactory.tincanLrsStateStorage.renew()
      storageFactory.tincanLrsActorStorage.renew()
      storageFactory.tincanLrsActivityStorage.renew()
      storageFactory.tincanLrsActivityProfileStorage.renew()
    }
  }
}