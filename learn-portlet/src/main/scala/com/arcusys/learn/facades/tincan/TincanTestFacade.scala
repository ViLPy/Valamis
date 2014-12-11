package com.arcusys.learn.facades.tincan

import java.io.PrintWriter

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.test.tincan.{ ActivityProfileTests, AgentProfileTests, StateProfileTests, StatementTests }
import com.arcusys.learn.tincan.lrs.statement.StatementLRS
import com.arcusys.learn.tincan.storage.{ StatementStorage, TincanActivityStorage }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

/**
 * Created by ematyukhin on 09/10/14.
 */
class TincanTestFacade(configuration: BindingModule) extends TincanTestFacadeContract with Injectable {
  def this() = this(DomainConfiguration)

  implicit val bindingModule = configuration

  private lazy val tincanActivityStorage = inject[TincanActivityStorage]
  private lazy val statementLRS = new StatementLRS() {
    val statementStorage = inject[StatementStorage]
  }

  def runTests(writer: PrintWriter): Unit = {
    def resetDB {
      inject[StorageFactoryContract].renewWholeStorage
    }

    resetDB

    val statementTests = new StatementTests(writer, statementLRS)

    writer.write("*** The 'addStatement' method <br>")
    statementTests.testCreateAndRead()
    statementTests.testCreateAlreadyExist()
    statementTests.testCreateWithNullStatement()

    writer.write("*** The 'addStatements' method <br>")
    statementTests.testCreateStatements()
    statementTests.testFindActivity(tincanActivityStorage)
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

    writer.write("*** The 'getStatements' method with filters relative_activity, relative_agent")
    statementTests.addStatementWithSubStatement()
    statementTests.testGetWithRelativeActivity()
    statementTests.testGetWithRelativeAgent()
    statementTests.testGetWithRegistration()

    writer.write("*** Renew base <br>")
    statementTests.testRenewBase()

    writer.write("*** STATE Tests <br>")
    val stateTests = new StateProfileTests(writer)

    stateTests.createAndReadTest()
    stateTests.createAndReadWithEmptyAgentTest()
    stateTests.createAndReadWithEmptyAgentTest2()
    stateTests.createAndReadWithEmptyAgentTestMultiple()

    writer.write("*** Agent profile Tests <br>")
    val agentTests = new AgentProfileTests(writer)
    agentTests.createAndReadTest()
    agentTests.createAndReadWithEmptyAgentTest()
    agentTests.createAndReadWithEmptyAgentTest2()
    agentTests.createMany()

    writer.write("*** Activity profile Tests <br>")
    val activityTests = new ActivityProfileTests(writer)
    activityTests.createAndReadTest()

    resetDB
  }
}
