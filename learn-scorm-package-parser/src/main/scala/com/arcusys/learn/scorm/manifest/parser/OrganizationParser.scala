package com.arcusys.learn.scorm.manifest.parser

import com.arcusys.learn.scorm.manifest.model._
import XMLImplicits._
import scala.xml.Elem
import com.arcusys.learn.util.TreeNode

class OrganizationParser(organizationElement: Elem, resourceMap: Map[String, Resource], adlcpNs: String, adlseqNs: String, sharedSequencing:Seq[Sequencing]) {
  def parse: TreeNode[Activity] = {
    val id = organizationElement attr "identifier" required string
    //TODO: warning if organizationElement attr "structure" optional string is present and is not "hierarchical"
    val objectivesGlobalToSystem = organizationElement attr(adlseqNs, "objectivesGlobalToSystem") withDefault true
    val sharedDataGlobalToSystem = organizationElement attr(adlcpNs, "sharedDataGlobalToSystem") withDefault true
    val title = organizationElement childElem "title" required string
    val itemElements = organizationElement children "item"
    val metadata = organizationElement childElem "metadata" optional parseMetadata _
    val sequencing = organizationElement childElem("imsss", "sequencing") optional(element=>parseActivitySequencing(element, sharedSequencing)) getOrElse Sequencing.Default
    val completionThreshold = organizationElement childElem("adlcp", "completionThreshold") optional parseCompletionThreshold _ getOrElse CompletionThreshold.Default

    val organization = new Organization(id, title, objectivesGlobalToSystem, sharedDataGlobalToSystem, sequencing, completionThreshold, metadata)
    def parseThisActivity(elem: Elem) = parseActivity(elem, resourceMap, id, None, sharedSequencing)
    val activities = itemElements map parseThisActivity
    new TreeNode[Activity](organization, activities)
  }
}