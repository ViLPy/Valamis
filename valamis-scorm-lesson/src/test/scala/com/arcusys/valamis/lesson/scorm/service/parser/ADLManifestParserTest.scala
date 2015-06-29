package com.arcusys.valamis.lesson.scorm.service.parser

import com.arcusys.valamis.lesson.scorm.model.manifest.{ AssetResource, Organization, PreConditionAction, RollupAction }
import org.junit.Assert._
import org.junit._

import scala.xml.XML

class ADLManifestParserTest {
  val root = XML.load(getClass.getResource("/test2.xml"))
  val doc = new ManifestParser(root, "title", "summary").parse
  val manifest = doc.manifest
  @Test
  def testManifest() {
    assertEquals(Some("1.0"), doc.manifest.version)
    assertEquals("2004 4th Edition", doc.manifest.scormVersion)
  }

  @Test
  def testManifestMetadata() {
    val metadata = manifest.metadata
    assertEquals(None, metadata)
  }

  @Test
  def testOrganizations() {
    assertEquals(1, doc.organizations.size)
    assertEquals("org1", manifest.defaultOrganizationID.get)
  }

  @Test
  def testOrganization() {
    val organization1 = doc.organizations(0).item.asInstanceOf[Organization]
    assertEquals("org1", organization1.id)
    assertEquals(true, organization1.objectivesGlobalToSystem)
    assertEquals(true, organization1.sharedDataGlobalToSystem)
  }

  @Test
  def testOrganizationMetadata() {
    val organization1 = doc.organizations(0).item.asInstanceOf[Organization]
    assertEquals(None, organization1.metadata)
  }

  @Test
  def testActivities() {
    val activities = doc.organizations(0).children
    assertEquals(8, activities.size)
    assertEquals("intro", activities(0).item.id)
    assertEquals("pretest", activities(1).item.id)
    assertEquals("module1", activities(2).item.id)
    assertEquals("module2", activities(3).item.id)
    assertEquals("module3", activities(4).item.id)
    assertEquals("assessment", activities(5).item.id)
    assertEquals("results", activities(6).item.id)
    assertEquals("conclude", activities(7).item.id)
    assertEquals("Introduction", activities(0).item.title)
    val sequencing = activities(5).children(0).item.sequencing
    assertEquals(1, sequencing.preConditionRules.size)
    assertEquals(PreConditionAction.Skip, sequencing.preConditionRules(0).action)
    val rollup = sequencing.rollupRules(0)
    assertEquals(RollupAction.Completed, rollup.action)
  }

  @Test
  def testResources() {
    val resources = doc.resourceMap
    assertEquals(53, resources.size)
    assertEquals("res-intro", resources("res-intro").id)
    assertTrue(resources("res-intro").isInstanceOf[AssetResource])
    assertEquals("Competency%20Based%20Strategy%20Introduction/introduction_competency.html", resources("res-intro").href.get)
    assertEquals(1, resources("res-intro").files.size)
    assertEquals("Competency%20Based%20Strategy%20Introduction/introduction_competency.html", resources("res-intro").files(0).href)
  }

}