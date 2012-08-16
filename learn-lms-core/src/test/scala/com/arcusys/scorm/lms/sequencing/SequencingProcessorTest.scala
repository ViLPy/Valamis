package com.arcusys.scorm.lms.sequencing

import model._
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scala_tools.subcut.inject.NewBindingModule
import com.arcusys.learn.scorm.tracking.model.{User, Attempt}
import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.scorm.manifest.storage.ActivitiesStorage
import com.arcusys.learn.scorm.manifest.model.{Organization, Activity}
import com.arcusys.learn.util.TreeNode
import com.arcusys.learn.scorm.tracking.states.storage.ActivityStateTreeStorage
import com.arcusys.learn.scorm.tracking.storage.AttemptStorage

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class SequencingProcessorTest extends FlatSpec with ShouldMatchers  with MockFactory with ProxyMockFactory {
  val navigationRequestService = mock[NavigationRequestServiceContract]
  val terminationRequestService = mock[TerminationRequestServiceContract]
  val sequencingRequestService = mock[SequencingRequestServiceContract]
  val deliveryRequestService = mock[DeliveryRequestServiceContract]
  private val storageFactory = mock[StorageFactoryContract]
  val activityStorage = mock[ActivitiesStorage]
  val activityStateTreeStorage = mock[ActivityStateTreeStorage]
  val attemptStorage = mock[AttemptStorage]
  val someAttempt = new Attempt(id = 1, user = new User(12, "Me"), packageID = 13, organizationID = "org1", isComplete = false)
  val configuration = new NewBindingModule({ implicit module =>
    import module._
    bind [NavigationRequestServiceContract] toSingle navigationRequestService
    bind [TerminationRequestServiceContract] toSingle terminationRequestService
    bind [SequencingRequestServiceContract] toSingle sequencingRequestService
    bind [DeliveryRequestServiceContract] toSingle deliveryRequestService
    bind [StorageFactoryContract] toSingle storageFactory
  })

  /*resetExpectations()
  storageFactory expects 'activityStorage returning activityStorage once()*/
  def processor = new SequencingProcessor(someAttempt)(configuration)
  //verifyExpectations()

  val someTree = new TreeNode[Activity](new Organization(someAttempt.organizationID, "Organization "+someAttempt.organizationID), Nil)

  private def expectGetStorage() {
    //storageFactory expects 'activityStorage returning activityStorage once()
    storageFactory expects 'activityStateTreeStorage returning activityStateTreeStorage once()
    storageFactory expects 'attemptStorage returning attemptStorage once()
  }

  private def expectGetOrganizationTree() {
    expectGetStorage()
    activityStateTreeStorage expects 'get returning Some(ActivityStateTree(someTree, None, false, None)) once()
    activityStateTreeStorage expects 'modify returning Unit once()
    //activityStorage expects 'getOrganizationTree withArgs (someAttempt.packageID, someAttempt.organizationID) returning someTree once()
  }

  import NavigationRequestType._

  "Sequencing processor" can "process 'start' request" in {
    expectGetOrganizationTree()
    navigationRequestService expects 'apply withArgs(*, Start, "") returning NavigationResponseInvalid once()
    processor.process("start")
  }

  it can "process 'resumeAll' request" in {
    expectGetOrganizationTree()
    navigationRequestService expects 'apply withArgs(*, ResumeAll, "") returning NavigationResponseInvalid once()
    processor.process("resumeAll")
  }

  it can "process 'continue' request" in {
    expectGetOrganizationTree()
    navigationRequestService expects 'apply withArgs(*, Continue, "") returning NavigationResponseInvalid once()
    processor.process("continue")
  }

  it can "process 'previous' request" in {
    expectGetOrganizationTree()
    navigationRequestService expects 'apply withArgs(*, Previous, "") returning NavigationResponseInvalid once()
    processor.process("previous")
  }

  it can "not process 'forward' request" in {
    expectGetOrganizationTree()
    processor.process("forward")
  }

  it can "not process 'backward' request" in {
    expectGetOrganizationTree()
    processor.process("backward")
  }

  it can "process 'choice' request" in {
    expectGetOrganizationTree()
    navigationRequestService expects 'apply withArgs(*, Choice, "ACT11") returning NavigationResponseInvalid once()
    processor.process("choice{ACT11}")
  }

  it can "process 'exit' request" in {
    expectGetOrganizationTree()
    navigationRequestService expects 'apply withArgs(*, Exit, "") returning NavigationResponseInvalid once()
    processor.process("exit")
  }

  it can "process 'exitAll' request" in {
    expectGetOrganizationTree()
    navigationRequestService expects 'apply withArgs(*, ExitAll, "") returning NavigationResponseInvalid once()
    processor.process("exitAll")
  }

  it can "process 'abandon' request" in {
    expectGetOrganizationTree()
    navigationRequestService expects 'apply withArgs(*, Abandon, "") returning NavigationResponseInvalid once()
    processor.process("abandon")
  }

  it can "process 'abandonAll' request" in {
    expectGetOrganizationTree()
    navigationRequestService expects 'apply withArgs(*, AbandonAll, "") returning NavigationResponseInvalid once()
    processor.process("abandonAll")
  }

  it can "process 'jump' request" in {
    expectGetOrganizationTree()
    navigationRequestService expects 'apply withArgs(*, Jump, "A6") returning NavigationResponseInvalid once()
    processor.process("jump{A6}")
  }

  it can "not process 'DANCE' request" in {
    expectGetOrganizationTree()
    processor.process("DANCE")
  }
}
