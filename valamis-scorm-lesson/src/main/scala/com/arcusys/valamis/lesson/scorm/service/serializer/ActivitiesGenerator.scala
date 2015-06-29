package com.arcusys.valamis.lesson.scorm.service.serializer

import com.arcusys.valamis.lesson.scorm.model.manifest._
import com.arcusys.valamis.util.TreeNode

import scala.xml._

object ActivitiesGenerator {

  def toXML(activityNodes: Seq[TreeNode[Activity]]) = for (node <- activityNodes) yield serializeSingleActivity(node)

  def serializeSingleActivity(node: TreeNode[Activity]): Elem = node.item match {
    case leaf: LeafActivity =>
      <item identifier={ leaf.id } identifierref={ leaf.resourceIdentifier }>
        <title>{ leaf.title }</title>
        { getADLNavPresentation(leaf) }
        <imsss:sequencing>
          <imsss:deliveryControls tracked={ leaf.sequencing.tracking.isDefined.toString }/>
          <imsss:controlMode flow="true"/>
        </imsss:sequencing>
      </item>
    case container: ContainerActivity =>
      <item identifier={ container.id }>
        <title>{ container.title }</title>
        { for (childNode <- node.children) yield serializeSingleActivity(childNode) }
        <imsss:sequencing>
          <imsss:controlMode flow="true"/>
        </imsss:sequencing>
      </item>
    case _ => throw new Exception("unsupported activity type")
  }

  private def getADLNavPresentation(activity: Activity) =
    <adlnav:presentation>
      <adlnav:navigationInterface>
        { for (navUIControl <- activity.hiddenNavigationControls) yield serializeNavigationControl(navUIControl) }
      </adlnav:navigationInterface>
    </adlnav:presentation>

  private def serializeNavigationControl(control: NavigationControlType.Value) =
    <adlnav:hideLMSUI>{ control.toString }</adlnav:hideLMSUI>
}
