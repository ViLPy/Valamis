package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.manifest.model._

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ChoiceNavigationRequestTest extends NavigationRequestServiceTestBase(NavigationRequestType.Choice) {
  val packageId = 13
  "Choice navigation request" should "succeed (with no termination) for a root target and no current acvitity (7.1.1.1.1)" in {
    expectResultWithTarget(NavigationResponseWithoutTermination, (twoLevelTree(), _.item.activity.id))
  }

  it should "succeed (with no termination) for a target with choice enabled on parent and no current acvitity (7.1.1.1.1)" in {
    val parentPermissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = false, flowForChildren = false, forwardOnlyForChildren = true)
    expectResultWithTarget(NavigationResponseWithoutTermination,
      (twoLevelTree(currentLevel = None, rootPermissions = parentPermissions), _.item.activity.id),
      (threeLevelTree(currentLevel = None, rootPermissions = parentPermissions), _.children(1).item.activity.id),
      (threeLevelTree(currentLevel = None, rightPermissions = parentPermissions), _.children(1).children(1).item.activity.id)
    )
  }

  it should "fail for a target not in one tree with current activity (7.1.1.2.4.1) / for non-existent target (7.2.1)" in {
    expectResultWithTarget(NavigationResponseInvalid,
      (twoLevelTree(currentLevel = Some(1)), _ => "DUM"),
      (threeLevelTree(currentLevel = Some(1)), _ => "DUM"),
      (threeLevelTree(currentLevel = Some(2)), _ => "DUM")
    )
  }

  it should "fail if target is accessible via exit, but exit path contains activities that can't terminate (7.1.1.2.3.1.1.1, 7.1.1.3.1)" in {
    val canExit = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = false)
    val cannotExit = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = false)
    expectResultWithTarget(NavigationResponseInvalid,
      // Exit via path with 2 nodes; parent can't exit (current activity is not active, but parent is)
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = canExit, leftPermissions = cannotExit, currentActive = false), _.children(1).item.activity.id),
      //Exit via path with 2 nodes; current can't exit
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = cannotExit, leftPermissions = canExit, currentActive = true), _.children(1).item.activity.id),
      //Exit to sibling
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = cannotExit, leftPermissions = canExit, currentActive = true), _.children(0).children(1).item.activity.id),
      //Exit to self
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = cannotExit, leftPermissions = canExit, currentActive = true), _.children(0).children(0).item.activity.id),
      //Exit to parent; current cannot exit
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = cannotExit, leftPermissions = canExit, currentActive = true), _.children(0).item.activity.id),
      //Exit to parent; parent cannot exit  (current activity is not active, but parent is)
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = canExit, leftPermissions = cannotExit, currentActive = false), _.children(0).item.activity.id)
    )
  }

  it should "succeed (with termination = exit) if target is accessible via exit and current activity is active (7.1.1.4.1)" in {
    val canExit = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = false)
    val cannotExit = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = false)

    expectResultWithTarget(NavigationResponseWithTermination,
      //Exit via path with 2 nodes
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = canExit, leftPermissions = canExit, currentActive = true), _.children(1).item.activity.id),
      //Exit to sibling
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = canExit, leftPermissions = canExit, currentActive = true), _.children(0).children(1).item.activity.id),
      //Exit to self
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = canExit, leftPermissions = canExit, currentActive = true), _.children(0).children(0).item.activity.id),
      //Exit to parent
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = canExit, leftPermissions = canExit, currentActive = true), _.children(0).item.activity.id),
      //Exit to child; exit path is empty so not caring about permissions
      (threeLevelTree(currentLevel = Some(1), leftLeftPermissions = cannotExit, leftPermissions = cannotExit, currentActive = true), _.children(0).children(0).item.activity.id)
    )
  }

  it should "succeed (with empty termination) if target is accessible via exit and current activity is not active (7.1.1.5.1)" in {
    val canExit = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = false)
    val cannotExit = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = false)

    expectResultWithTarget(NavigationResponseWithoutTermination,
      //Exit via path with 2 nodes; current has exit permissions
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = canExit, leftPermissions = canExit, currentActive = false), _.children(1).item.activity.id),
      //Exit via path with 2 nodes; current doesn't have exit permissions
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = cannotExit, leftPermissions = canExit, currentActive = false), _.children(1).item.activity.id),
      //Exit to sibling; current has exit permissions
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = canExit, leftPermissions = canExit, currentActive = false), _.children(0).children(1).item.activity.id),
      //Exit to sibling; current doesn't have exit permissions
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = cannotExit, leftPermissions = cannotExit, currentActive = false), _.children(0).children(1).item.activity.id),
      //Exit to self; current has exit permissions
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = canExit, leftPermissions = cannotExit, currentActive = false), _.children(0).children(0).item.activity.id),
      //Exit to self; current doesn't have exit permissions
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = cannotExit, leftPermissions = cannotExit, currentActive = false), _.children(0).children(0).item.activity.id),
      //Exit to parent; current has exit permissions
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = canExit, leftPermissions = canExit, currentActive = false), _.children(0).item.activity.id),
      //Exit to parent; current doesn't have exit permissions
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = cannotExit, leftPermissions = canExit, currentActive = false), _.children(0).item.activity.id),
      //Exit to child; exit path is empty so not caring about permissions
      (threeLevelTree(currentLevel = Some(1), leftLeftPermissions = cannotExit, leftPermissions = cannotExit, currentActive = false), _.children(0).children(0).item.activity.id)
    )
  }

  it should "fail for target with choice disabled on parent (7.1.2.1)" in {
    val canExit = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = false)
    val parentPermissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = false)
    expectResultWithTarget(NavigationResponseInvalid,
      (threeLevelTree(currentLevel = Some(2), leftLeftPermissions = canExit, leftPermissions = canExit, rightPermissions = parentPermissions, currentActive = false), _.children(1).children(1).item.activity.id),
      (threeLevelTree(currentLevel = Some(1), leftLeftPermissions = canExit, leftPermissions = canExit, rightPermissions = parentPermissions, currentActive = false), _.children(1).children(1).item.activity.id)
    )
  }
}