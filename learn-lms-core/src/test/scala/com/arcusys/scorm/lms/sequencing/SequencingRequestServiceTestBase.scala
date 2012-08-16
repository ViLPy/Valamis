package com.arcusys.scorm.lms.sequencing

import model.{SequencingRequestType, SequencingResponse}
import org.scala_tools.subcut.inject.NewBindingModule

abstract class SequencingRequestServiceTestBase(requestType: SequencingRequestType.Value) extends ActivityStateTreeTestBase {
  val endAttemptService = mock[EndAttemptServiceContract]
  val configuration = new NewBindingModule({
    implicit module =>
      import module._
      bind[EndAttemptServiceContract] toSingle endAttemptService
  })
  val sequencing = new SequencingRequestService()(configuration)

  protected def expectResult(result: SequencingResponse, testTrees: ActivityStateTree*) {
    testTrees.foreach(sequencing(_, requestType) should equal(result))
  }

  protected def expectResultWithTarget(result: SequencingResponse, testTreesAndTargets: (ActivityStateTree, ActivityStateTree => String)*) {
    testTreesAndTargets.foreach(treeAndTarget => {
      sequencing(treeAndTarget._1, requestType, treeAndTarget._2(treeAndTarget._1)) should equal(result)
    })
  }
}
