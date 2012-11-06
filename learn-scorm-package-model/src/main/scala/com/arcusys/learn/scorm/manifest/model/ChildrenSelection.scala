package com.arcusys.learn.scorm.manifest.model

/**
 * Information about how child activities are picked up for this activity
 * @param count   How many child activities are taken
 * @param timing  When child activities are picked up
 */
class ChildrenSelectionTake(val count: Int, val timing: RandomizationTimingType.Value) {
  require(count > 0, "count cannot be negative")
}

/**
 * Information about how child activities are selected and ordered for this activity
 * @param take    Information about how child activities are picked up. If None, all child activities are picked up
 * @param reorder Information about how picked up child activities are randomized. If None, original order is kept
 */
class ChildrenSelection
(
  val take: Option[ChildrenSelectionTake] = None,
  val reorder: Option[RandomizationTimingType.Value] = None
  ) {
  /**
   * Construct for the case when child activities are picked up and randomized
   * @param takeCount   How many child activities are taken
   * @param takeTiming  When child activities are picked up
   * @param reorder     When picked up child activities are randomized
   */
  def this(takeCount: Int, takeTiming: RandomizationTimingType.Value, reorder: RandomizationTimingType.Value) =
    this(Some(new ChildrenSelectionTake(takeCount, takeTiming)), Some(reorder))

  /**
   * Construct for the case when child activities are picked up and kept in original order
   * @param takeCount   How many child activities are taken
   * @param takeTiming  When child activities are picked up
   */
  def this(takeCount: Int, takeTiming: RandomizationTimingType.Value) = this(Some(new ChildrenSelectionTake(takeCount, takeTiming)), None)

  /**
   * Construct for the case when ALL child activities are picked up and randomized
   * @param reorder     When child activities are randomized
   */
  def this(reorder: RandomizationTimingType.Value) = this(None, Some(reorder))
}
