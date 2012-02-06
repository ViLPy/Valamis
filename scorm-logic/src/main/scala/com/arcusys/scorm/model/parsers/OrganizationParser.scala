package com.arcusys.scorm.model.parsers

import com.arcusys.scorm.model._
import XMLImplicits._
import scala.xml.Elem

class OrganizationParser(val organizationElement: Elem, val manifest: Manifest, adlcpNs: String, adlseqNs: String) {
  def parse = {
    val identifier = organizationElement %! "identifier"
    val structure = (organizationElement %? "structure").getOrElse("hierarchical")
    val objectivesGlobalToSystem = (organizationElement %? (adlseqNs,"objectivesGlobalToSystem")).getOrElse("true")
    val sharedDataGlobalToSystem = (organizationElement %? (adlcpNs,"sharedDataGlobalToSystem")).getOrElse("true")
    val titleElement = organizationElement \! "title"
    val itemElements = organizationElement \ "item"
    val metadata = (organizationElement \? "metadata").map(e=>new MetadataParser(e.asInstanceOf[Elem]).parse)
    val sequencing = (organizationElement \? ("imsss","sequencing")).map(e=>new SequencingParser(e.asInstanceOf[Elem], false).parse)
    val completionThreshold = (organizationElement \? ("adlcp","completionThreshold")).map(e=>new CompletionThresholdParser(e.asInstanceOf[Elem]).parse)

    val organization = new Organization(
      identifier,
      structure,
      objectivesGlobalToSystem.toBoolean,
      sharedDataGlobalToSystem.toBoolean,
      titleElement.text,
      metadata, completionThreshold, sequencing)
    itemElements.foreach(itemElement => {
      val activity = new ActivityParser(itemElement.asInstanceOf[Elem], manifest).parse
      if (manifest.allActivities.contains(activity.id)) throw new SCORMParserException("<item> elements with non-unique `identifier` attributes found")
      manifest.allActivities(activity.id) = activity
      organization.activities += activity
    })
    organization
  }
}