package com.arcusys.valamis.lesson.scorm.service.sequencing

import com.arcusys.valamis.lesson.scorm.model.sequencing.{ SequencingRequestType, SequencingResponse }
import com.arcusys.valamis.lesson.scorm.model.tracking.ActivityStateTree
import com.escalatesoft.subcut.inject.NewBindingModule

abstract class SequencingRequestServiceTestBase(val requestType: SequencingRequestType.Value) extends ActivityStateTreeTestBase {
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

  protected def createService(dependency: EndAttemptServiceContract): SequencingRequestServiceContract = {
    new SequencingRequestService()(new NewBindingModule({
      implicit module =>
        import module._
        bind[EndAttemptServiceContract] toSingle dependency
    }))
  }
}
