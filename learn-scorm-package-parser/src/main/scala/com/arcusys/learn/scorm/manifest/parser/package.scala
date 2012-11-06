package com.arcusys.learn.scorm.manifest

import model._
import xml.Elem

package object parser {
  def parseMetadata(elem: Elem): Metadata = new MetadataParser(elem).parse
  def parseResource(elem: Elem, scormVersion: String, adlcpNs: String) = new ResourceParser(elem, scormVersion, adlcpNs).parse
  def parseResourceFile(elem: Elem) = new ResourceFileParser(elem).parse
  def parseOrganization(elem: Elem, resourceMap: Map[String, Resource], adlcpNs: String, adlseqNs: String, scormVersion:String, sharedSequencing:Seq[Sequencing]) = new OrganizationParser(elem, resourceMap, adlcpNs, adlseqNs, scormVersion, sharedSequencing).parse
  def parseActivity(elem: Elem, resourcesMap: Map[String, Resource], organizationId: String, parentId: Option[String], scormVersion:String, sharedSequencing:Seq[Sequencing]) = new ActivityParser(elem, resourcesMap, organizationId, parentId, scormVersion, sharedSequencing).parse
  def parseActivitySequencing(elem: Elem, sharedSequencing:Seq[Sequencing]) = new SequencingParser(elem, shared=false, sharedSequencing=sharedSequencing).parse
  def parseSharedSequencing(elem: Elem) = new SequencingParser(elem, shared=true).parse
  def parsePrimaryObjective(elem: Elem, extendedMap: Map[String, Seq[Elem]]) = new ObjectiveParser(elem, extendedMap).parse(primary = true)
  def parseNonPrimaryObjective(elem: Elem, extendedMap: Map[String, Seq[Elem]]) = new ObjectiveParser(elem, extendedMap).parse(primary = false)
  def parsePreConditionRule(elem: Elem) = new SequencingRuleParser(elem).parsePreConditionRule
  def parsePostConditionRule(elem: Elem) = new SequencingRuleParser(elem).parsePostConditionRule
  def parseExitConditionRule(elem: Elem) = new SequencingRuleParser(elem).parseExitConditionRule
  def parseSequencingRuleCondition(elem: Elem) = new SequencingRuleConditionParser(elem).parse
  def parseRollupRule(elem: Elem) = new RollupRuleParser(elem).parse
  def parseRollupRuleCondition(elem: Elem) = new RollupRuleConditionParser(elem).parse
  def parseCompletionThreshold(elem: Elem) = new CompletionThresholdParser(elem).parse
}
