package com.arcusys.scorm.lms.sequencing

import model.{NavigationRequestType, NavigationResponse}

abstract class NavigationRequestServiceTestBase(requestType: NavigationRequestType.Value) extends ActivityStateTreeTestBase {
  val navigation = new NavigationRequestService

  protected def expectResult(result: NavigationResponse, testTrees: ActivityStateTree*) {
    testTrees.foreach(navigation(_, requestType) should equal(result))
  }

  protected def expectResultWithTarget(result: NavigationResponse, testTreesAndTargets: (ActivityStateTree, ActivityStateTree=>String)*) {
    testTreesAndTargets.foreach(treeAndTarget=>{navigation(treeAndTarget._1, requestType, treeAndTarget._2(treeAndTarget._1)) should equal(result)})
  }
}
