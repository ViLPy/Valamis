package com.arcusys.valamis.lesson.scorm.model

import com.arcusys.valamis.lesson.scorm.model.manifest.{ ChildrenSelection, ChildrenSelectionTake, RandomizationTimingType }
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class ChildrenSelectionTest extends FlatSpec with ShouldMatchers {

  "Children selection take" can "be constructed" in {
    val take = new ChildrenSelectionTake(10, RandomizationTimingType.Once)
    take.count should equal(10)
    take.timing should equal(RandomizationTimingType.Once)
  }

  it can "not be constructed with zero count" in {
    intercept[IllegalArgumentException] {
      new ChildrenSelectionTake(0, RandomizationTimingType.Once)
    }
  }

  it can "not be constructed with negative count" in {
    intercept[IllegalArgumentException] {
      new ChildrenSelectionTake(-1, RandomizationTimingType.Once)
    }
  }

  "Children selection" can "be constructed" in {
    val selection = new ChildrenSelection(Some(new ChildrenSelectionTake(10, RandomizationTimingType.Once)), Some(RandomizationTimingType.OnEachNewAttempt))
    selection.take.get.count should equal(10)
    selection.take.get.timing should equal(RandomizationTimingType.Once)
    selection.reorder.get should equal(RandomizationTimingType.OnEachNewAttempt)
  }

  it can "be constructed without take" in {
    val selection = new ChildrenSelection(reorder = Some(RandomizationTimingType.OnEachNewAttempt))
    selection.take should equal(None)
    selection.reorder.get should equal(RandomizationTimingType.OnEachNewAttempt)
  }

  it can "be constructed without reorder timing" in {
    val selection = new ChildrenSelection(take = Some(new ChildrenSelectionTake(10, RandomizationTimingType.Once)))
    selection.take.get.count should equal(10)
    selection.take.get.timing should equal(RandomizationTimingType.Once)
    selection.reorder should equal(None)
  }

  it can "be constructed without take and reorder timing" in {
    val selection = new ChildrenSelection()
    selection.take should equal(None)
    selection.reorder should equal(None)
  }

  it can "be constructed with secondary constructor" in {
    val selection = new ChildrenSelection(takeCount = 10, takeTiming = RandomizationTimingType.Once, reorder = RandomizationTimingType.OnEachNewAttempt)
    selection.take.get.count should equal(10)
    selection.take.get.timing should equal(RandomizationTimingType.Once)
    selection.reorder.get should equal(RandomizationTimingType.OnEachNewAttempt)
  }

  it can "be constructed with secondary constructor without reorder timing" in {
    val selection = new ChildrenSelection(takeCount = 10, takeTiming = RandomizationTimingType.Once)
    selection.take.get.count should equal(10)
    selection.take.get.timing should equal(RandomizationTimingType.Once)
    selection.reorder should equal(None)
  }

  it can "be constructed with secondary constructor without take" in {
    val selection = new ChildrenSelection(reorder = RandomizationTimingType.OnEachNewAttempt)
    selection.take should equal(None)
    selection.reorder.get should equal(RandomizationTimingType.OnEachNewAttempt)
  }
}
