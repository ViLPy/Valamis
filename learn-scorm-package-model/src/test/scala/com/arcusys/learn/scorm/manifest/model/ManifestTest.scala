package com.arcusys.learn.scorm.manifest.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ManifestTest extends FlatSpec with ShouldMatchers {
  val someMetadata = new Metadata(Seq("meta.xml"), Seq("<info>data</info>"))
  "Manifest" can "be constructed" in {
    val manifest = new Manifest(12, version = Some("13"), base = Some("data/"), scormVersion = "2004",
      defaultOrganizationID = Some("O"), resourcesBase = Some("files/"), title = "package1", summary = Some("desc"),
      visibility = false, metadata = Some(someMetadata))
    manifest.id should equal(12)
    manifest.version should equal(Some("13"))
    manifest.base should equal(Some("data/"))
    manifest.scormVersion should equal("2004")
    manifest.defaultOrganizationID should equal(Some("O"))
    manifest.resourcesBase should equal(Some("files/"))
    manifest.title should equal("package1")
    manifest.summary should equal(Some("desc"))
    manifest.visibility should equal(false)
    manifest.metadata should equal(Some(someMetadata))
  }

  it can "be constructed with defaults" in {
    val manifest = new Manifest(12, version = Some("13"), base = Some("data/"), scormVersion = "2004",
      defaultOrganizationID = Some("O"), resourcesBase = Some("files/"), title = "package1")
    manifest.id should equal(12)
    manifest.version should equal(Some("13"))
    manifest.base should equal(Some("data/"))
    manifest.scormVersion should equal("2004")
    manifest.defaultOrganizationID should equal(Some("O"))
    manifest.resourcesBase should equal(Some("files/"))
    manifest.title should equal("package1")
    manifest.summary should equal(None)
    manifest.visibility should equal(true)
    manifest.metadata should equal(None)
  }

  it can "not be constructed if base start with /" in {
    intercept[IllegalArgumentException] {
      new Manifest(12, version = Some("13"), base = Some("/data/"), scormVersion = "2004",
        defaultOrganizationID = Some("O"), resourcesBase = Some("files/"), title = "package1")
    }
  }

  it can "not be constructed if base does not end with /" in {
    intercept[IllegalArgumentException] {
      new Manifest(12, version = Some("13"), base = Some("data"), scormVersion = "2004",
        defaultOrganizationID = Some("O"), resourcesBase = Some("files/"), title = "package1")
    }
  }

  it can "not be constructed if resource base start with /" in {
    intercept[IllegalArgumentException] {
      new Manifest(12, version = Some("13"), base = Some("data/"), scormVersion = "2004",
        defaultOrganizationID = Some("O"), resourcesBase = Some("/files/"), title = "package1")
    }
  }

  it can "not be constructed if resource base does not end with /" in {
    intercept[IllegalArgumentException] {
      new Manifest(12, version = Some("13"), base = Some("data/"), scormVersion = "2004",
        defaultOrganizationID = Some("O"), resourcesBase = Some("files"), title = "package1")
    }
  }
}
