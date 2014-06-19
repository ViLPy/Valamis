package com.arcusys.learn.scorm.manifest.serializer

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.util.TreeNode

object OrganizationsGenerator {

  import AttributeImplicits._

  def toXML(organizations: Seq[TreeNode[Activity]], defaultOrganization: Option[String]) = (
    <organizations>
      { for (organization <- organizations) yield serializeSingleOrganization(organization) }
    </organizations>
  ) % ("default" -> defaultOrganization)

  def serializeSingleOrganization(organization: TreeNode[Activity]) =
    <organization identifier={ organization.item.id } structure="hierarchical">
      <title>{ organization.item.title }</title>
      { ActivitiesGenerator.toXML(organization.children) }
      <imsss:sequencing>
        <imsss:controlMode flow="true"/>
      </imsss:sequencing>
    </organization>

}
