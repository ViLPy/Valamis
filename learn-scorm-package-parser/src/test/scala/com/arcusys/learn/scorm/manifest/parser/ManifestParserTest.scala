package com.arcusys.learn.scorm.manifest.parser

import org.junit._
import Assert._
import com.arcusys.learn.scorm.manifest.model._
import scala.xml.XML

class ManifestParserTest {
  val root = XML.load(getClass.getResource("/test1.xml"))
  val doc = new ManifestParser(root, "title", "summary").parse
  val manifest = doc.manifest

  @Test
  def testManifest() {
    assertEquals(Some("1.3"), manifest.version)
    assertEquals(Some("mycontent/"), manifest.base)
    assertEquals(Some("myresources/"), manifest.resourcesBase)
    assertEquals("2004 4th Edition", manifest.scormVersion)
  }

  @Test
  def testManifestMetadata() {
    val metadata = manifest.metadata.get
    assertEquals(2, metadata.externalMetadataLocations.size)
    assertEquals("course/metadata/course.xml", metadata.externalMetadataLocations(0))
    assertEquals("course/metadata/course_extra.xml", metadata.externalMetadataLocations(1))
    assertEquals(1, metadata.inlineMetadata.size)
  }

  @Test
  def testOrganizations() {
    assertEquals(2, doc.organizations.size)
    assertEquals("TOC1", manifest.defaultOrganizationID.get)
  }

  @Test
  def testOrganization() {
    val organization1 = doc.organizations.find(o => o.item.id == "TOC1").get.item.asInstanceOf[Organization]
    assertEquals("TOC1", organization1.id)
    assertEquals(true, organization1.objectivesGlobalToSystem)
    assertEquals(true, organization1.sharedDataGlobalToSystem)
    val organization2 = doc.organizations.find(o => o.item.id == "TOC2").get.item.asInstanceOf[Organization]
    assertEquals("TOC2", organization2.id)
    assertEquals(false, organization2.objectivesGlobalToSystem)
    assertEquals(false, organization2.sharedDataGlobalToSystem)
  }

  @Test
  def testOrganizationMetadata() {
    val organization1 = doc.organizations.find(o => o.item.id == "TOC1").get.item.asInstanceOf[Organization]
    val metadata = organization1.metadata.get
    assertEquals(1, metadata.externalMetadataLocations.size)
    assertEquals("activities/activity1MD.xml", metadata.externalMetadataLocations(0))
  }

  @Test
  def testActivities() {
    val activities = doc.organizations.find(o => o.item.id == "TOC1").get.children
    assertEquals(3, activities.size)
    assertEquals("ITEM1", activities(0).item.id)
    assertEquals("ITEM2", activities(1).item.id)
    assertEquals("ITEM3", activities(2).item.id)
    assertEquals("Item 1", activities(0).item.title)
    assertEquals(1, activities(0).item.metadata.get.externalMetadataLocations.size)
    assertEquals(2, activities(0).children.size)
    val leafActivity = activities(0).children(0).item.asInstanceOf[LeafActivity]
    assertEquals("ITEM11", leafActivity.id)
    assertEquals("Item 1.1", leafActivity.title)
    assertEquals("RES11", leafActivity.resourceIdentifier)
    assertEquals("?Topic=1", leafActivity.resourceParameters.get)
    assertEquals(Some(TimeLimitAction.ExitNoMessage), leafActivity.timeLimitAction)
    assertEquals("Some SCO information", leafActivity.dataFromLMS.get)
    assertEquals(true, leafActivity.completionThreshold.completedByMeasure)
    assertEquals(BigDecimal.apply("0.75"), leafActivity.completionThreshold.minProgressMeasure)
    assertEquals(BigDecimal.apply(1), leafActivity.completionThreshold.progressWeight)
    assertEquals(2, leafActivity.data.size)
    assertEquals("dataMap1", leafActivity.data(0).targetId)
    assertEquals(false, leafActivity.data(0).readSharedData)
    assertEquals(false, leafActivity.data(0).writeSharedData)
    assertEquals("dataMap2", leafActivity.data(1).targetId)
    assertEquals(true, leafActivity.data(1).readSharedData)
    assertEquals(true, leafActivity.data(1).writeSharedData)
  }

  @Test
  def testResources() {
    val resources = doc.resourceMap
    assertEquals(5, resources.size)
    assertEquals(Some("myresources/"), manifest.resourcesBase)
    assertEquals("RES12", resources("RES12").id)
    assertTrue(resources("RES12").isInstanceOf[ScoResource])
    assertEquals("res12/", resources("RES12").base.get)
    assertEquals("sco12.html", resources("RES12").href.get)
    assertEquals(1, resources("RES12").metadata.get.externalMetadataLocations.size)
    assertEquals(3, resources("RES12").files.size)
    assertEquals("assets/image1.gif", resources("RES12").files(0).href)
    assertEquals("sco1.html", resources("RES12").files(1).href)
    assertEquals("assets/common/APIWrapper.js", resources("RES12").files(2).href)
    assertEquals(1, resources("RES12").files(0).metadata.get.externalMetadataLocations.size)
    assertEquals(1, resources("RES12").dependencyIds.size)
    assertEquals("RES11", resources("RES12").dependencyIds(0))
    assertEquals("RES2", resources("RES2").id)
    assertEquals("RES3", resources("RES3").id)
    assertEquals("RES11", resources("RES11").id)
    assertEquals("RES_", resources("RES_").id)
  }

  @Test
  def testSequencingCollection() {
    val sequencing = doc.sequencingCollection(0)
    assertEquals("pretest", sequencing.sharedId.get)
    assertEquals(false, sequencing.permissions.choiceForChildren)
    assertEquals(false, sequencing.permissions.choiceForNonDescendants)
    assertEquals(true, sequencing.permissions.flowForChildren)
    assertEquals(true, sequencing.permissions.forwardOnlyForChildren)
    assertEquals(1, sequencing.preConditionRules.size)

    val rule = sequencing.preConditionRules(0)
    assertEquals(ConditionCombination.All, rule.conditions.combination)
    assertEquals(1, rule.conditions.conditions.size)
    assertEquals(ConditionType.ObjectiveSatisfied, rule.conditions.conditions(0).conditionType)
    assertEquals(None, rule.conditions.conditions(0).objectiveId)
    assertEquals(None, rule.conditions.conditions(0).measureThreshold)
    assertEquals(PreConditionAction.Skip, rule.action)
  }
}