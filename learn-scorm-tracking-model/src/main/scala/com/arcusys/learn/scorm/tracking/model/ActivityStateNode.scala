package com.arcusys.learn.scorm.tracking.model

import com.arcusys.learn.util.TreeNodeBase
import com.arcusys.learn.scorm.manifest.model.RandomizationTimingType

class ActivityStateNode(item: ActivityState, children: Seq[ActivityStateNode]) extends TreeNodeBase[ActivityState, ActivityStateNode](item, children) {
  val availableChildrenCollection = new collection.mutable.ArrayBuffer[ActivityStateNode]()

  if (availableChildrenCollection.isEmpty) selectChildren(isFirstSelect = true)

  /**
   * Select Children Process [SR.1]
   */
  def selectChildren(isFirstSelect: Boolean) {
    // TODO: use synchronized?
    availableChildrenCollection.clear()
    val selection = item.activity.sequencing.childrenSelection.take match {
      case Some(rules) => {
        def selectSubprocess = {
          // Randomly select (without replacement) an activity from the children of the activity
          // Add the selected activity to the child list, retaining the original (from the activity) relative order of activities
          val selectedIndices = scala.util.Random.shuffle((0 until children.size).toList).take(rules.count).sorted
          selectedIndices.map(index => children(index))
        }

        rules.timing match {
          case RandomizationTimingType.Once if isFirstSelect => selectSubprocess
          case RandomizationTimingType.OnEachNewAttempt => selectSubprocess
          case _ => Nil
        }
      }
      case _ => children
    }

    val reorderedSelection = item.activity.sequencing.childrenSelection.reorder match {
      case Some(rules) => {
        rules match {
          case RandomizationTimingType.Once if isFirstSelect => scala.util.Random.shuffle(selection)
          case RandomizationTimingType.OnEachNewAttempt => scala.util.Random.shuffle(selection)
          case _ => selection
        }
      }
      case _ => selection
    }

    reorderedSelection.foreach(children => availableChildrenCollection += children)
  }

  def availableChildren: Seq[ActivityStateNode] = availableChildrenCollection

  def isAvailableChild: Boolean = parent match {
    case None => true
    case Some(parent) => parent.availableChildren.exists(_ == this)
  }

  def hasAvailableDescendent(node: ActivityStateNode): Boolean = {
    def subprocess(childrenData: Seq[ActivityStateNode]): Boolean = {
      childrenData.foreach(child => {
        if (child == node) true
        else subprocess(child.availableChildren)
      })
      false
    }
    subprocess(availableChildren)
  }

  def isFirstAvailableChild: Boolean = parent match {
    case None => true
    case Some(parent) => parent.availableChildren.headOption == Some(this)
  }

  def isLastAvailableChild: Boolean = parent match {
    case None => true
    case Some(parent) => parent.availableChildren.lastOption == Some(this)
  }

  def averageChildWeightedMeasure: Option[Option[BigDecimal]] = {
    val (totalWeight, totalMeasure) = children.filter(_.item.activity.isTracked).foldLeft((BigDecimal(0), None.asInstanceOf[Option[BigDecimal]])) {
      case ((runningTotalWeight, runningTotalMeasure), childActivity) => {
        if (childActivity.item.activity.sequencing.primaryObjective.isEmpty) return None
        (runningTotalWeight + childActivity.item.activity.sequencing.rollupContribution.objectiveMeasureWeight,
          (runningTotalMeasure, childActivity.item.primaryObjectiveWeightedMeasure) match {
            case (None, None) => None
            case (None, Some(current)) => Some(current)
            case (Some(total), None) => Some(total)
            case (Some(total), Some(current)) => Some(total + current)
          }
          )
      }
    }
    (totalWeight, totalMeasure) match {
      case (_, None) => Some(None)
      case (weight, Some(measure)) => if (weight == BigDecimal(0)) Some(None) else Some(Some(measure / weight))
    }
  }

  def averageChildWeightedProgress: Option[BigDecimal] = {
    val (totalWeight, totalProgress) = children.filter(_.item.activity.isTracked).foldLeft((BigDecimal(0), None.asInstanceOf[Option[BigDecimal]])) {
      case ((runningTotalWeight, runningTotalMeasure), childActivity) => {
        (
          runningTotalWeight + childActivity.item.activity.completionThreshold.progressWeight,
          (runningTotalMeasure, childActivity.item.weightedProgress) match {
            case (None, None) => None
            case (None, Some(current)) => Some(current)
            case (Some(total), None) => Some(total)
            case (Some(total), Some(current)) => Some(total + current)
          }
          )
      }
    }
    (totalWeight, totalProgress) match {
      case (_, None) => None
      case (weight, Some(progress)) => if (weight == BigDecimal(0)) None else Some(progress / weight)
    }
  }

  /**
   * Delivery Request Process [DB.1.1]
   * @return validity of the delivery request
   */
  def canBeDelivered: Boolean =
    isLeaf && pathToRoot.forall(_.item.deliveryEnabled)

}
