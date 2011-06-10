package com.arcusys.scorm.model.parsers

import org.junit._
import Assert._
import java.io.File
import com.arcusys.scorm.model._
import scala.xml.XML

class ManifestParserTest {
  val root = XML.loadFile(new File("src/test/resources/test1.xml"))
  val manifest = new ManifestParser(root).parse
  @Test
  def testManifest = {
    assertEquals("SAMPLE1", manifest.identifier)
    assertEquals(Some("1.3"), manifest.version)
    assertEquals(Some("mycontent/"), manifest.base)
  }

  @Test
  def testManifestMetadata = {
    val metadata = manifest.metadata
    assertEquals("ADL SCORM", metadata.schema)
    assertEquals("2004 4th Edition", metadata.schemaversion)
    assertEquals(2, metadata.externalMetadataLocations.size)
    assertEquals("course/metadata/course.xml", metadata.externalMetadataLocations(0))
    assertEquals("course/metadata/course_extra.xml", metadata.externalMetadataLocations(1))
    assertEquals(1, metadata.inlineMetadata.size)
  }

  @Test
  def testOrganizations = {
    assertEquals(2, manifest.organizations.size)
    assertEquals("TOC1", manifest.defaultOrganizationIdentifier.get)
  }

  @Test
  def testOrganization = {
    val organization1 = manifest.organizations("TOC1");
    assertEquals("TOC1", organization1.identifier);
    assertEquals(true, organization1.objectivesGlobalToSystem);
    assertEquals(true, organization1.sharedDataGlobalToSystem);
    val organization2 = manifest.organizations("TOC2");
    assertEquals("TOC2", organization2.identifier);
    assertEquals(false, organization2.objectivesGlobalToSystem);
    assertEquals(false, organization2.sharedDataGlobalToSystem);
  }

  @Test
  def testOrganizationMetadata = {
    val metadata = manifest.organizations("TOC1").metadata.get
    assertEquals(1, metadata.externalMetadataLocations.size)
    assertEquals("activities/activity1MD.xml", metadata.externalMetadataLocations(0))
  }

  @Test
  def testActivities = {
    val organization = manifest.organizations("TOC1")
    val activities = organization.activities
    assertEquals(3, activities.size)
    assertEquals("ITEM1", activities(0).identifier)
    assertEquals("ITEM2", activities(1).identifier)
    assertEquals("ITEM3", activities(2).identifier)
    assertEquals("Item 1", activities(0).title)
    assertEquals(1, activities(0).metadata.get.externalMetadataLocations.size)
    val containerActivity = activities(0).asInstanceOf[ContainerActivity]
    assertEquals(2, containerActivity.childActivities.size)
    val leafActivity = containerActivity.childActivities(0).asInstanceOf[LeafActivity]
    assertEquals("ITEM11", leafActivity.identifier)
    assertEquals("Item 1.1", leafActivity.title)
    assertEquals("RES11", leafActivity.resourceIdentifier)
    assertEquals("?Topic=1", leafActivity.resourceParameters.get)
    assertEquals(TimeLimitAction.ExitNoMessage, leafActivity.timeLimitAction)
    assertEquals("Some SCO information", leafActivity.dataFromLMS.get)
    assertEquals(true, leafActivity.completionThreshold.get.completedByMeasure)
    assertEquals(BigDecimal.apply("0.75"), leafActivity.completionThreshold.get.minProgressMeasure)
    assertEquals(BigDecimal.apply(1), leafActivity.completionThreshold.get.progressWeight)
    assertEquals(2, leafActivity.data.size)
    assertEquals("dataMap1", leafActivity.data(0).targetId)
    assertEquals(false, leafActivity.data(0).readSharedData)
    assertEquals(false, leafActivity.data(0).writeSharedData)
    assertEquals("dataMap2", leafActivity.data(1).targetId)
    assertEquals(true, leafActivity.data(1).readSharedData)
    assertEquals(true, leafActivity.data(1).writeSharedData)
  }

  @Test
  def testResources = {
    val resources = manifest.resources
    assertEquals(5, resources.size)
    assertEquals(Some("myresources/"), manifest.resourcesBase)
    assertEquals("RES12", resources("RES12").identifier)
    assertEquals("webcontent", resources("RES12").resourceType)
    assertEquals(ResourceScormType.Sco, resources("RES12").scormType)
    assertEquals("res12/", resources("RES12").base.get)
    assertEquals("sco12.html", resources("RES12").href.get)
    assertEquals(1, resources("RES12").metadata.get.externalMetadataLocations.size)
    assertEquals(3, resources("RES12").files.size)
    assertEquals("assets/image1.gif", resources("RES12").files(0).href)
    assertEquals("sco1.html", resources("RES12").files(1).href)
    assertEquals("assets/common/APIWrapper.js", resources("RES12").files(2).href)
    assertEquals(1, resources("RES12").files(0).metadata.get.externalMetadataLocations.size)
    assertEquals(1, resources("RES12").dependencyIdentifiers.size)
    assertEquals("RES11", resources("RES12").dependencyIdentifiers(0))
    assertEquals("RES2", resources("RES2").identifier)
    assertEquals("RES3", resources("RES3").identifier)
    assertEquals("RES11", resources("RES11").identifier)
    assertEquals("RES_", resources("RES_").identifier)
  }

  @Test
  def testSequencingCollection = {
    val sequencing = manifest.sequencingCollection("pretest")
    assertEquals("pretest", sequencing.sharedId.get)
    assertEquals(false, sequencing.choicePermittedForChildren)
    assertEquals(false, sequencing.choicePermittedForNonDescendants)
    assertEquals(true, sequencing.continuePreviousFlowPermittedForChildren)
    assertEquals(true, sequencing.forwardOnlyForChildren)
    assertEquals(1, sequencing.preConditionRules.size)

    val rule = sequencing.preConditionRules(0)
    assertEquals(ConditionCombination.All, rule.conditionCombination)
    assertEquals(1, rule.conditions.size)
    assertEquals(ConditionType.ObjectiveSatisfied, rule.conditions(0).conditionType)
    assertEquals(None, rule.conditions(0).objectiveId)
    assertEquals(None, rule.conditions(0).measureThreshold)
    assertEquals(PreConditionAction.Skip, rule.action)
  }

  @Test
  def testFullResourceUrl = {
    val resource = manifest.resources("RES12");
    assertEquals("mycontent/myresources/res12/sco12.html", manifest.getFullResourceUrl(resource));
  }

  @Test
  def testFullResourceUrlById = {
    assertEquals("mycontent/myresources/res12/sco12.html", manifest.getFullResourceUrl("RES12"));
  }

  @Test
  def testFullFileUrl = {
    val resource = manifest.resources("RES12");
    val resourceFile = resource.files(0);
    assertEquals("mycontent/myresources/res12/assets/image1.gif", manifest.getFullFileUrl(resource, resourceFile));
  }

  @Test
  def testFullFileUrlById = {
    val resourceFile = manifest.resources("RES12").files(0);
    assertEquals("mycontent/myresources/res12/assets/image1.gif", manifest.getFullFileUrl("RES12", resourceFile));
  }

  @Test
  def testFullActivityUrl = {
    val activity = manifest.allActivities("ITEM12").asInstanceOf[LeafActivity];
    assertEquals("mycontent/myresources/res12/sco12.html?Topic=1", manifest.getFullActivityUrl(activity));
  }

  @Test
  def testFullActivityUrlById = {
    assertEquals("mycontent/myresources/res12/sco12.html?Topic=1", manifest.getFullActivityUrl("ITEM12"));
  }
}