package com.arcusys.learn.scorm.manifest.parser

import com.arcusys.learn.scorm.manifest.model._
import scala.xml.Elem
import XMLImplicits._
import com.arcusys.learn.util.TreeNode

class ActivityParser(activityElement: Elem, resourceMap: Map[String, Resource], organizationId: String, parentId: Option[String], sharedSequencing: Seq[Sequencing]) {
  def parse: TreeNode[Activity] = {
    val identifier = activityElement attr "identifier" required string
    val resourceIdentifier = activityElement attr "identifierref" optional string
    val visible = activityElement attr "isvisible" withDefault true
    val resourceParameters = activityElement attr "parameters" optional string
    val title = activityElement childElem "title" required string

    val timeLimitAction = activityElement childElem("adlcp", "timeLimitAction") optionalEnum TimeLimitAction
    val dataElement = activityElement childElem("adlcp", "data") optional element
    val metadata = activityElement childElem "metadata" optional parseMetadata _
    val sequencing = activityElement childElem("imsss", "sequencing") optional (element => parseActivitySequencing(element, sharedSequencing)) getOrElse Sequencing.Default
    val completionThreshold = activityElement childElem("adlcp", "completionThreshold") optional parseCompletionThreshold _ getOrElse CompletionThreshold.Default
    val hiddenNavigationControls = activityElement childElem("adlnav", "presentation") optional element match {
      case None => Nil
      case Some(e) => e childElem("adlnav", "navigationInterface") optional element children("adlnav", "hideLMSUI") map (c => NavigationControlType.withName(c.text.trim))
    }

    val dataFromLMS = activityElement childElem("adlcp", "dataFromLMS") optional string
    if (resourceIdentifier.isDefined) {
      val data = dataElement children("adlcp", "map") map (mapElement => new ActivityDataMap(
        mapElement attr "targetID" required string,
        mapElement attr "readSharedData" withDefault true,
        mapElement attr "writeSharedData" withDefault true
      ))
      val activity = new LeafActivity(identifier, title, parentId.getOrElse(organizationId), organizationId, resourceIdentifier.get, resourceParameters, timeLimitAction, dataFromLMS, data, sequencing, completionThreshold, hiddenNavigationControls.toSet, visible, metadata)
      if (!resourceMap.contains(resourceIdentifier.get)) throw new SCORMParserException("<item> element's `identifierref` points to a non-existing resource: " + resourceIdentifier.get)
      val resource = resourceMap(resourceIdentifier.get)
      if (resource.href == None) throw new SCORMParserException("<resource> element referenced by an <item> element does not have the `href` attribute specified: " + resourceIdentifier.get)
      new TreeNode[Activity](activity, Nil)
    } else {
      val activity = new ContainerActivity(identifier, title, parentId.getOrElse(organizationId), organizationId, sequencing, completionThreshold, hiddenNavigationControls.toSet, visible, metadata)
      if (resourceParameters.isDefined) throw new SCORMParserException("Container <item> element contains a `parameters` attribute")
      if (timeLimitAction.isDefined) throw new SCORMParserException("Container <item> element contains a <timeLimitAction> element")
      if (dataFromLMS.isDefined) throw new SCORMParserException("Container <item> element contains a <dataFromLMS> element")
      if (dataElement.isDefined) throw new SCORMParserException("Container <item> element contains a <data> element")
      def parseThisActivity(elem: Elem) = parseActivity(elem, resourceMap, organizationId, Some(identifier), sharedSequencing)
      val childActivityElements = activityElement children "item"
      new TreeNode[Activity](activity, childActivityElements map parseThisActivity)
    }
  }
}