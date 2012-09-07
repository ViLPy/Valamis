package com.arcusys.learn.scorm.manifest.serializer

import com.arcusys.learn.scorm.manifest.model._
import scala.xml._
import com.arcusys.learn.util.TreeNode

object ActivitiesGenerator {

  def toXML(activityNodes: Seq[TreeNode[Activity]]) = for (node <- activityNodes) yield serializeSingleActivity(node)

  def serializeSingleActivity(node: TreeNode[Activity]): Elem = node.item match {
    case leaf:LeafActivity =>
      <item identifier={leaf.id} identifierref={leaf.resourceIdentifier}>
        <title>{leaf.title}</title>
        {getADLNavPresentation(leaf)}
        <imsss:sequencing>
          <imsss:deliveryControls tracked = {leaf.sequencing.tracking.isDefined.toString}/>
          <imsss:controlMode flow="true"/>
        </imsss:sequencing>
      </item>
    case container: ContainerActivity =>
      <item identifier={container.id}>
        <title>{container.title}</title>
        {for (childNode <- node.children) yield serializeSingleActivity(childNode)}
        <imsss:sequencing>
          <imsss:controlMode flow="true"/>
        </imsss:sequencing>
      </item>
  }

  private def getADLNavPresentation(activity: Activity) =
    <adlnav:presentation>
      <adlnav:navigationInterface>
        {for (navUIControl <- activity.hiddenNavigationControls) yield serializeNavigationControl(navUIControl)}
      </adlnav:navigationInterface>
    </adlnav:presentation>

  private def serializeNavigationControl(control: NavigationControlType.Value) =
    <adlnav:hideLMSUI>{control.toString}</adlnav:hideLMSUI>
}
