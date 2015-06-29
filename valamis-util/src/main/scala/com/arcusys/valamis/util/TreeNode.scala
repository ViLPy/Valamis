package com.arcusys.valamis.util

import scala.collection.mutable

abstract class TreeNodeBase[TItem, TSelf <: TreeNodeBase[TItem, TSelf]](val item: TItem, val children: Seq[TSelf]) {
  children.foreach(_._parent = Some(this.asInstanceOf[TSelf]))
  private var _parent: Option[TSelf] = None

  def parent = _parent

  def isRoot = parent.isEmpty

  def isLeaf = children.isEmpty

  def isSiblingTo(other: TSelf): Boolean = parent == other.parent

  def pathToRoot: Seq[TSelf] = {
    val result = mutable.Buffer[TSelf]()
    var activityBubble: Option[TSelf] = Some(this.asInstanceOf[TSelf])
    while (activityBubble.isDefined) {
      result += activityBubble.get
      activityBubble = activityBubble.get.parent
    }
    result.toSeq
  }

  def commonAncestor(other: TSelf): Option[TSelf] = {
    if (this isSiblingTo other) parent
    else {
      //Hard case - find the path to exit from current activity up to but not including common ancestor with target
      val currentActivityPath = pathToRoot
      //Find the common ancestor of the Current Activity and the activity specified by the Choice navigation request
      var targetBubble = other
      var commonAncestorIndex = currentActivityPath indexOf targetBubble
      //Find a common ancestor between the current activity and target activity
      //Current activity is included in search, so is the target one
      while (commonAncestorIndex == -1 && targetBubble.parent != None) {
        targetBubble = targetBubble.parent.get
        commonAncestorIndex = currentActivityPath indexOf targetBubble
      }
      //This must not happen. If they are in one organization, they must have a common ancestor
      if (commonAncestorIndex == -1) throw new Exception("Problem in Activity Tree")
      Some(currentActivityPath(commonAncestorIndex))
    }
  }

  def pathTo(ancestor: TSelf, includeAncestor: Boolean = true, includeThis: Boolean = true): Seq[TSelf] = {
    //if (this == ancestor && !includeAncestor) return Nil
    val result = mutable.Buffer[TSelf]()
    var activityBubble: Option[TSelf] = Some(this.asInstanceOf[TSelf])
    while (activityBubble.isDefined && activityBubble != Some(ancestor)) {
      result += activityBubble.get
      activityBubble = activityBubble.get.parent
    }
    require(activityBubble.isDefined)
    if (includeAncestor) result += activityBubble.get
    if (!includeThis && result.size > 0) result.tail.toSeq else result.toSeq
  }

  def pathToCommonAncestorWith(other: TSelf, includeCommonAncestor: Boolean = false): Seq[TSelf] = {
    if (this isSiblingTo other)
      if (includeCommonAncestor && parent.isDefined) Seq(this.asInstanceOf[TSelf], parent.get)
      else Seq(this.asInstanceOf[TSelf])
    else {
      //Hard case - find the path to exit from current activity up to but not including common ancestor with target
      val currentActivityPath = pathToRoot
      other.parent match {
        // If we target the root, include all activities from current up to the root
        case None =>
          if (includeCommonAncestor) currentActivityPath else (currentActivityPath.dropRight(1))
        case Some(parent) => {
          //Otherwise all activities from the current one up to, but not including the common root must be terminated
          val ancestor = commonAncestor(other).get
          //We're selecting an activity below the current one. No need to exit anything
          if (ancestor == this) Nil
          //We're selecting an activity above the current one. Exit it, too
          //else if (ancestor == other) currentActivityPath.slice(0, currentActivityPath.indexOf(ancestor)+(if(includeCommonAncestor) 2 else 1))
          //Exit everything from current activity up to but not including the common ancestor
          else currentActivityPath.slice(0, currentActivityPath.indexOf(ancestor) + (if (includeCommonAncestor) 1 else 0))
        }
      }
    }
  }
}

class TreeNode[TItem](item: TItem, children: Seq[TreeNode[TItem]]) extends TreeNodeBase[TItem, TreeNode[TItem]](item, children)

object TreeNode {
  def parseNodes[TItem, TID](items: Seq[TItem], idExtractor: TItem => TID, parentIdExtractor: TItem => TID, parentId: Option[TID]): Seq[TreeNode[TItem]] = {
    def getNodes(parentId: Option[TID]): Seq[TreeNode[TItem]] =
      items.filter(parentIdExtractor(_) == parentId) map {
        item => new TreeNode[TItem](item, getNodes(Some(idExtractor(item))))
      }
    getNodes(parentId)
  }
}
