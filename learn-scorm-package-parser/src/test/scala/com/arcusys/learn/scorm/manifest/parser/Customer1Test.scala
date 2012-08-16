package com.arcusys.learn.scorm.manifest.parser

import org.junit._
import Assert._
import com.arcusys.learn.scorm.manifest.model._
import scala.xml.XML

class Customer1Test {
  val root = XML.load(getClass.getResource("/test1/imsmanifest.xml"))
  val doc = new ManifestParser(root, "title", "summary").parse
   val manifest = doc.manifest

  @Test
  def testManifest() {
    assertEquals(None, manifest.version)
    assertEquals(None, manifest.base)
    assertEquals("1.2", manifest.scormVersion)
  }

  @Test
  def testManifestMetadata() {
    val metadata = manifest.metadata.get
    assertEquals(1, metadata.externalMetadataLocations.size)
    assertEquals("imslrm.xml", metadata.externalMetadataLocations(0))
    assertEquals(0, metadata.inlineMetadata.size)
  }

  @Test
  def testOrganizations() {
    val organizations = doc.organizations
    assertEquals(1, organizations.size)
    assertEquals("eXenewPackage44f81a2d1e045bb4fa8", manifest.defaultOrganizationID.get)
  }

  @Test
  def testOrganization() {
    val organization = doc.organizations(0).item.asInstanceOf[Organization]
    assertEquals("eXenewPackage44f81a2d1e045bb4fa8", organization.id)
    assertEquals(true, organization.objectivesGlobalToSystem)
    assertEquals(true, organization.sharedDataGlobalToSystem)
    assertEquals(None, organization.metadata)
    assertEquals("Home", organization.title)
  }

  @Test
  def testActivities() {
    val activities = doc.organizations(0).children
    assertEquals(1, activities.size)
    assertEquals("ITEM-eXenewPackage44f81a2d1e045bb4fa9", activities(0).item.id)
    assertEquals("Home", activities(0).item.title)
    assertEquals(1, activities(0).children.size)
    val leafActivity = activities(0).children(0).item.asInstanceOf[LeafActivity]
    assertEquals("ITEM-eXenewPackage44f81a2d1e045bb4fab", leafActivity.id)
    assertEquals("page 2", leafActivity.title)
    assertEquals("RES-eXenewPackage44f81a2d1e045bb4fac", leafActivity.resourceIdentifier)
    assertEquals(None, leafActivity.resourceParameters)
    //assertEquals(TimeLimitAction.ExitNoMessage, leafActivity.getTimeLimitAction());
    assertEquals(None, leafActivity.dataFromLMS)
    assertEquals(CompletionThreshold.Default.completedByMeasure, leafActivity.completionThreshold.completedByMeasure)
    assertEquals(CompletionThreshold.Default.minProgressMeasure, leafActivity.completionThreshold.minProgressMeasure)
    assertEquals(CompletionThreshold.Default.progressWeight, leafActivity.completionThreshold.progressWeight)
    assertEquals(0, leafActivity.data.size)
  }

  @Test
  def testResources() {
    val resources = doc.resourceMap
    assertEquals(2, resources.size)
    assertEquals(None, manifest.resourcesBase)

    assertEquals("RES-eXenewPackage44f81a2d1e045bb4faa", resources("RES-eXenewPackage44f81a2d1e045bb4faa").id)
    assertTrue(resources("RES-eXenewPackage44f81a2d1e045bb4faa").isInstanceOf[ScoResource])
    assertEquals(None, resources("RES-eXenewPackage44f81a2d1e045bb4faa").base)
    assertEquals("index.html", resources("RES-eXenewPackage44f81a2d1e045bb4faa").href.get)
    assertEquals(None, resources("RES-eXenewPackage44f81a2d1e045bb4faa").metadata)
    assertEquals(11, resources("RES-eXenewPackage44f81a2d1e045bb4faa").files.size)
    assertEquals("index.html", resources("RES-eXenewPackage44f81a2d1e045bb4faa").files(0).href)
    assertEquals("base.css", resources("RES-eXenewPackage44f81a2d1e045bb4faa").files(1).href)
    assertEquals("content.css", resources("RES-eXenewPackage44f81a2d1e045bb4faa").files(2).href)
    assertEquals("popup_bg.gif", resources("RES-eXenewPackage44f81a2d1e045bb4faa").files(3).href)
    assertEquals("APIWrapper.js", resources("RES-eXenewPackage44f81a2d1e045bb4faa").files(4).href)
    assertEquals("SCOFunctions.js", resources("RES-eXenewPackage44f81a2d1e045bb4faa").files(5).href)
    assertEquals("stock-stop.png", resources("RES-eXenewPackage44f81a2d1e045bb4faa").files(6).href)
    assertEquals("common.js", resources("RES-eXenewPackage44f81a2d1e045bb4faa").files(7).href)
    assertEquals("libot_drag.js", resources("RES-eXenewPackage44f81a2d1e045bb4faa").files(8).href)
    assertEquals("panel-amusements.png", resources("RES-eXenewPackage44f81a2d1e045bb4faa").files(9).href)
    assertEquals("icon_question.gif", resources("RES-eXenewPackage44f81a2d1e045bb4faa").files(10).href)

    assertEquals("RES-eXenewPackage44f81a2d1e045bb4fac", resources("RES-eXenewPackage44f81a2d1e045bb4fac").id)
    assertTrue(resources("RES-eXenewPackage44f81a2d1e045bb4fac").isInstanceOf[ScoResource])
    assertEquals(None, resources("RES-eXenewPackage44f81a2d1e045bb4fac").base)
    assertEquals("page_2.html", resources("RES-eXenewPackage44f81a2d1e045bb4fac").href.get)
    assertEquals(None, resources("RES-eXenewPackage44f81a2d1e045bb4fac").metadata)
    assertEquals(6, resources("RES-eXenewPackage44f81a2d1e045bb4fac").files.size)
    assertEquals("page_2.html", resources("RES-eXenewPackage44f81a2d1e045bb4fac").files(0).href)
    assertEquals("base.css", resources("RES-eXenewPackage44f81a2d1e045bb4fac").files(1).href)
    assertEquals("content.css", resources("RES-eXenewPackage44f81a2d1e045bb4fac").files(2).href)
    assertEquals("popup_bg.gif", resources("RES-eXenewPackage44f81a2d1e045bb4fac").files(3).href)
    assertEquals("APIWrapper.js", resources("RES-eXenewPackage44f81a2d1e045bb4fac").files(4).href)
    assertEquals("SCOFunctions.js", resources("RES-eXenewPackage44f81a2d1e045bb4fac").files(5).href)
  }
}