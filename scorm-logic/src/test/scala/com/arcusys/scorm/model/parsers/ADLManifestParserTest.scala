package com.arcusys.scorm.model.parsers

import org.junit._
import Assert._
import java.io.File
import com.arcusys.scorm.model._
import scala.xml.XML

class ADLManifestParserTest {
  val root = XML.loadFile(new File("src/test/resources/test2.xml"))
  val manifest = new ManifestParser(root).parse
  @Test
  def testManifest = {
    assertEquals("LMSTestPackage_RU-12b", manifest.identifier)
    assertEquals(Some("1.0"), manifest.version)
  }

  @Test
  def testManifestMetadata = {
    val metadata = manifest.metadata
    assertEquals("ADL SCORM", metadata.schema)
    assertEquals("2004 4th Edition", metadata.schemaversion)
    assertEquals(0, metadata.externalMetadataLocations.size)
    assertEquals(0, metadata.inlineMetadata.size)
  }

  @Test
  def testOrganizations = {
    assertEquals(1, manifest.organizations.size)
    assertEquals("org1", manifest.defaultOrganizationIdentifier.get)
  }

  @Test
  def testOrganization = {
    val organization1 = manifest.organizations("org1");
    assertEquals("org1", organization1.identifier);
    assertEquals(true, organization1.objectivesGlobalToSystem);
    assertEquals(true, organization1.sharedDataGlobalToSystem);
  }

  @Test
  def testOrganizationMetadata = {
    assertEquals(None, manifest.organizations("org1").metadata)
  }

  @Test
  def testActivities = {
    val organization = manifest.organizations("org1")
    val activities = organization.activities
    assertEquals(8, activities.size)
    assertEquals("intro", activities(0).identifier)
    assertEquals("pretest", activities(1).identifier)
    assertEquals("module1", activities(2).identifier)
    assertEquals("module2", activities(3).identifier)
    assertEquals("module3", activities(4).identifier)
    assertEquals("assessment", activities(5).identifier)
    assertEquals("results", activities(6).identifier)
    assertEquals("conclude", activities(7).identifier)
    assertEquals("Introduction", activities(0).title)
    val containerActivity = activities(5).asInstanceOf[ContainerActivity]
    val sequencing = containerActivity.childActivities(0).sequencing.get
    assertEquals(1, sequencing.preConditionRules.size)
    assertEquals(PreConditionAction.Skip, sequencing.preConditionRules(0).action)
    val rollup = sequencing.rollupRules(0)
    assertEquals(RollupAction.Completed, rollup.action)
  }

  @Test
  def testResources = {
    val resources = manifest.resources
    assertEquals(53, resources.size)
    assertEquals("res-intro", resources("res-intro").identifier)
    assertEquals("webcontent", resources("res-intro").resourceType)
    assertEquals(ResourceScormType.Asset, resources("res-intro").scormType)
    assertEquals("Competency%20Based%20Strategy%20Introduction/introduction_competency.html", resources("res-intro").href.get)
    assertEquals(1, resources("res-intro").files.size)
    assertEquals("Competency%20Based%20Strategy%20Introduction/introduction_competency.html", resources("res-intro").files(0).href)
  }

}