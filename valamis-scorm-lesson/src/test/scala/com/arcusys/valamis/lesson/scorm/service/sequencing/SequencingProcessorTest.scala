package com.arcusys.valamis.lesson.scorm.service.sequencing

import com.arcusys.valamis.lesson.scorm.model.manifest.{ Activity, Organization }
import com.arcusys.valamis.lesson.scorm.model.sequencing.{ NavigationRequestType, NavigationResponseInvalid }
import com.arcusys.valamis.lesson.scorm.model.tracking.{ ActivityStateTree, Attempt }
import com.arcusys.valamis.user.model.User
import com.arcusys.valamis.util.TreeNode
import com.escalatesoft.subcut.inject.NewBindingModule
import org.scalamock.scalatest.MockFactory
import org.scalatest.{ FlatSpec, Matchers }

class SequencingProcessorTest extends FlatSpec with Matchers with MockFactory {
  val navigationRequestService = mock[NavigationRequestServiceContract]
  val terminationRequestService = mock[TerminationRequestServiceContract]
  val sequencingRequestService = mock[SequencingRequestServiceContract]
  val deliveryRequestService = mock[DeliveryRequestServiceContract]

  val someAttempt = new Attempt(
    id = 1,
    user = new User(12, "Me"),
    packageID = 13,
    organizationID = "org1",
    isComplete = false
  )
  val someTree = new TreeNode[Activity](
    item = new Organization(someAttempt.organizationID, "Organization " + someAttempt.organizationID),
    children = Nil
  )

  def processor(dependency: NavigationRequestServiceContract) = new SequencingProcessor(
    attempt = someAttempt,
    tree = ActivityStateTree(someTree, None, currentActive = false, suspendedActivityID = None)
  )(new NewBindingModule({
    implicit module =>
      import module._
      bind[NavigationRequestServiceContract] toSingle dependency
      bind[TerminationRequestServiceContract] toSingle terminationRequestService
      bind[SequencingRequestServiceContract] toSingle sequencingRequestService
      bind[DeliveryRequestServiceContract] toSingle deliveryRequestService
  })

  )

  import NavigationRequestType._

  "Sequencing processor" can "process 'start' request" in {
    val mockNavigation = mock[NavigationRequestServiceContract]
    (mockNavigation.apply _).expects(*, Start, "") returning NavigationResponseInvalid once ()

    val p = processor(mockNavigation)
    p.process("start")
  }

  it can "process 'resumeAll' request" in {
    val mockNavigation = mock[NavigationRequestServiceContract]
    (mockNavigation.apply _).expects(*, ResumeAll, "") returning NavigationResponseInvalid once ()

    val p = processor(mockNavigation)
    p.process("resumeAll")
  }

  it can "process 'continue' request" in {
    val mockNavigation = mock[NavigationRequestServiceContract]
    (mockNavigation.apply _).expects(*, Continue, "") returning NavigationResponseInvalid once ()

    val p = processor(mockNavigation)
    p.process("continue")
  }

  it can "process 'previous' request" in {
    val mockNavigation = mock[NavigationRequestServiceContract]
    (mockNavigation.apply _).expects(*, Previous, "") returning NavigationResponseInvalid once ()

    val p = processor(mockNavigation)
    p.process("previous")
  }

  it can "not process 'forward' request" in {
    val mockNavigation = mock[NavigationRequestServiceContract]

    val p = processor(mockNavigation)
    p.process("forward")
  }

  it can "not process 'backward' request" in {
    val mockNavigation = mock[NavigationRequestServiceContract]

    val p = processor(mockNavigation)
    p.process("backward")
  }

  it can "process 'choice' request" in {
    val mockNavigation = mock[NavigationRequestServiceContract]
    (mockNavigation.apply _).expects(*, Choice, "ACT11") returning NavigationResponseInvalid once ()

    val p = processor(mockNavigation)
    p.process("choice{ACT11}")
  }

  it can "process 'exit' request" in {
    val mockNavigation = mock[NavigationRequestServiceContract]
    (mockNavigation.apply _).expects(*, Exit, "") returning NavigationResponseInvalid once ()

    val p = processor(mockNavigation)
    p.process("exit")
  }

  it can "process 'exitAll' request" in {
    val mockNavigation = mock[NavigationRequestServiceContract]
    (mockNavigation.apply _).expects(*, ExitAll, "") returning NavigationResponseInvalid once ()

    val p = processor(mockNavigation)
    p.process("exitAll")
  }

  it can "process 'abandon' request" in {
    val mockNavigation = mock[NavigationRequestServiceContract]
    (mockNavigation.apply _).expects(*, Abandon, "") returning NavigationResponseInvalid once ()

    val p = processor(mockNavigation)
    p.process("abandon")
  }

  it can "process 'abandonAll' request" in {
    val mockNavigation = mock[NavigationRequestServiceContract]
    (mockNavigation.apply _).expects(*, AbandonAll, "") returning NavigationResponseInvalid once ()

    val p = processor(mockNavigation)
    p.process("abandonAll")
  }

  it can "process 'jump' request" in {
    val mockNavigation = mock[NavigationRequestServiceContract]
    (mockNavigation.apply _).expects(*, Jump, "A6") returning NavigationResponseInvalid once ()

    val p = processor(mockNavigation)
    p.process("jump{A6}")
  }

  it can "not process 'DANCE' request" in {
    val mockNavigation = mock[NavigationRequestServiceContract]

    val p = processor(mockNavigation)
    p.process("DANCE")
  }
}
