package com.arcusys.learn.scorm.manifest.storage

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.util.TreeNode

trait ActivitiesStorage {
  def getAllFlat(packageID: Int): Seq[Activity]

  def getAllOrganizations(packageID: Int): Seq[Organization]

  def getOrganizationTree(packageID: Int, organizationID: String): TreeNode[Activity]

  def getParent(packageID: Int, activityID: String): Option[Activity]

  def getChildren(packageID: Int, activityID: Option[String]): Seq[Activity]

  /**
   * Forms the activity path as the ordered series of activities from the Current Activity to the common ancestor
   * @param packageID given package ID
   * @param activityID given activity ID
   * @return activity path
   */
  def getActivityPath(packageID: Int, activityID: String): Seq[Activity]

  def get(packageID: Int, id: String): Option[Activity]

  def create(packageID: Int, entity: Activity)
}
