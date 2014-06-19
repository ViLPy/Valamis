package com.arcusys.learn.scorm.manifest.service

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.scorm.util.FileSystemUtil
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.util.TreeNode
import com.arcusys.learn.scorm.tracking.model.{ ActivityStateTree, ActivityStateNode }

class ActivitiesService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  val jsonModel = new JsonModelBuilder[Activity](activity =>
    Map(
      "id" -> activity.id,
      "title" -> activity.title,
      "visible" -> activity.visible,
      "childActivities" -> Nil,
      "leafData" -> (activity match {
        case leaf: LeafActivity => Map("resourceID" -> leaf.resourceIdentifier, "resourceParam" -> leaf.resourceParameters.getOrElse(""))
        case _                  => Map()
      })
    )
  )

  val jsonNodeModel = new JsonModelBuilder[TreeNode[Activity]](node => {

    def mapNode(node: TreeNode[Activity]): Map[String, Any] = Map(
      "id" -> node.item.id,
      "title" -> node.item.title,
      "visible" -> node.item.visible,
      "childActivities" -> node.children.map(mapNode),
      "leafData" -> (node.item match {
        case leaf: LeafActivity => Map("resourceID" -> leaf.resourceIdentifier, "resourceParam" -> leaf.resourceParameters.getOrElse(""))
        case _                  => Map()
      })
    )

    mapNode(node)
  })

  val jsonStateNodeModel = new JsonModelBuilder[ActivityStateNode](node => {

    def mapNode(node: ActivityStateNode): Map[String, Any] = Map(
      "id" -> node.item.activity.id,
      "title" -> node.item.activity.title,
      "visible" -> node.item.activity.visible,
      "childActivities" -> node.availableChildren.map(mapNode),
      "leafData" -> (node.item.activity match {
        case leaf: LeafActivity => Map("resourceID" -> leaf.resourceIdentifier, "resourceParam" -> leaf.resourceParameters.getOrElse(""))
        case _                  => Map()
      })
    )

    mapNode(node)
  })

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  get("/package/:packageID/organization/:organizationID") {
    val userID = try {
      request.getHeader("scormUserID").toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests
    val packageID = parameter("packageID").intRequired
    val organizationID = parameter("organizationID").required
    val currentAttempt = attemptStorage.getActive(userID, packageID) match {
      case Some(attempt) => attempt
      case None => {
        attemptStorage.createAndGetID(userID, packageID, organizationID)
        attemptStorage.getActive(userID, packageID).getOrElse(halt(404, "Okay. Check DB connection."))
      }
    }
    val tree = activityStateTreeStorage.get(currentAttempt.id).getOrElse({
      val stateTree = ActivityStateTree(activityStorage.getOrganizationTree(currentAttempt.packageID, currentAttempt.organizationID), None, true, None)
      activityStateTreeStorage.create(currentAttempt.id, stateTree)
      stateTree
    })

    jsonStateNodeModel(tree.availableChildren)
  }

  /*get("/package/:packageID/organization/:organizationID") {
    val packageID = parameter("packageID").intRequired
    val organizationID = parameter("organizationID").required
    jsonNodeModel(activityStorage.getOrganizationTree(packageID, organizationID).children)
  }*/

  get("/package/:packageID/organization/:organizationID/activity/:id") {
    val packageID = parameter("packageID").intRequired
    val id = parameter("id").required
    jsonModel(activityStorage.get(packageID, id))
  }
}