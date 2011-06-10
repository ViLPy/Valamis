package com.arcusys.scorm.model.parsers
import org.junit.Test
import org.junit._
import Assert._
import java.io.File
import com.arcusys.scorm.model._
import scala.xml.XML

class Customer1Test {
  val root = XML.loadFile(new File("src/test/resources/test1/imsmanifest.xml"))
  val manifest = new ManifestParser(root).parse


  @Test
  def testManifest = {
    assertEquals("eXenewPackage44f81a2d1e045bb4fa7", manifest.identifier)
    assertEquals(None, manifest.version)
    assertEquals(None, manifest.base)
  }

  @Test
  def testManifestMetadata = {
    val metadata = manifest.metadata
    assertEquals("ADL SCORM", metadata.schema);
    assertEquals("1.2", metadata.schemaversion);
    assertEquals(1, metadata.externalMetadataLocations.size);
    assertEquals("imslrm.xml", metadata.externalMetadataLocations(0));
    assertEquals(0, metadata.inlineMetadata.size);
  }

  @Test
  def testOrganizations = {
    val organizations = manifest.organizations;
    assertEquals(1, organizations.size);
    assertEquals("eXenewPackage44f81a2d1e045bb4fa8", manifest.defaultOrganizationIdentifier.get)
  }

  @Test
  def testOrganization = {
    val organization = manifest.organizations("eXenewPackage44f81a2d1e045bb4fa8");
    assertEquals("eXenewPackage44f81a2d1e045bb4fa8", organization.identifier);
    assertEquals(true, organization.objectivesGlobalToSystem);
    assertEquals(true, organization.sharedDataGlobalToSystem);
    assertEquals(None, organization.metadata);
    assertEquals("Home", organization.title);
  }

  @Test
  def testActivities = {
    val organization = manifest.organizations("eXenewPackage44f81a2d1e045bb4fa8");
    val activities = organization.activities;
    assertEquals(1, activities.size);
    assertEquals("ITEM-eXenewPackage44f81a2d1e045bb4fa9", activities(0).identifier);
    assertEquals("Home", activities(0).title);
    val containerActivity = activities(0).asInstanceOf[ContainerActivity];
    assertEquals(1, containerActivity.childActivities.size);
    val leafActivity = containerActivity.childActivities(0).asInstanceOf[LeafActivity];
    assertEquals("ITEM-eXenewPackage44f81a2d1e045bb4fab", leafActivity.identifier);
    assertEquals("page 2", leafActivity.title);
    assertEquals("RES-eXenewPackage44f81a2d1e045bb4fac", leafActivity.resourceIdentifier);
    assertEquals(None, leafActivity.resourceParameters);
    //assertEquals(TimeLimitAction.ExitNoMessage, leafActivity.getTimeLimitAction());
    assertEquals(None, leafActivity.dataFromLMS);
    assertEquals(None, leafActivity.completionThreshold);
    assertEquals(0, leafActivity.data.size);
  }

  @Test
  def testResources = {
    val resources = manifest.resources
    assertEquals(2, resources.size)
    assertEquals(None, manifest.resourcesBase)

    assertEquals("RES-eXenewPackage44f81a2d1e045bb4faa", resources("RES-eXenewPackage44f81a2d1e045bb4faa").identifier)
    assertEquals("webcontent", resources("RES-eXenewPackage44f81a2d1e045bb4faa").resourceType)
    assertEquals(ResourceScormType.Sco, resources("RES-eXenewPackage44f81a2d1e045bb4faa").scormType)
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

    assertEquals("RES-eXenewPackage44f81a2d1e045bb4fac", resources("RES-eXenewPackage44f81a2d1e045bb4fac").identifier)
    assertEquals("webcontent", resources("RES-eXenewPackage44f81a2d1e045bb4fac").resourceType)
    assertEquals(ResourceScormType.Sco, resources("RES-eXenewPackage44f81a2d1e045bb4fac").scormType)
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

  @Test
  def testFullResourceUrl = {
    val resource = manifest.resources("RES-eXenewPackage44f81a2d1e045bb4faa");
    assertEquals("index.html", manifest.getFullResourceUrl(resource));
  }

  @Test
  def testFullResourceUrlById = {
    assertEquals("index.html", manifest.getFullResourceUrl("RES-eXenewPackage44f81a2d1e045bb4faa"));
  }

  @Test
  def testFullFileUrl = {
    val resource = manifest.resources("RES-eXenewPackage44f81a2d1e045bb4faa");
    val resourceFile = resource.files(0);
    assertEquals("index.html", manifest.getFullFileUrl(resource, resourceFile));
  }

  @Test
  def testFullFileUrlById = {
    val resourceFile = manifest.resources("RES-eXenewPackage44f81a2d1e045bb4faa").files(0);
    val url = manifest.getFullFileUrl("RES-eXenewPackage44f81a2d1e045bb4faa", resourceFile);
    assertEquals("index.html", url);
  }

  @Test
  def testFullActivityUrl = {
    val activity = manifest.allActivities("ITEM-eXenewPackage44f81a2d1e045bb4fab").asInstanceOf[LeafActivity];
    assertEquals("page_2.html?", manifest.getFullActivityUrl(activity));
  }

  @Test
  def testFullActivityUrlById = {
    assertEquals("page_2.html?", manifest.getFullActivityUrl("ITEM-eXenewPackage44f81a2d1e045bb4fab"));
  }
}