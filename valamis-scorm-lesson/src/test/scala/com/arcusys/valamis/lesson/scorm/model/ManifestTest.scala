package com.arcusys.valamis.lesson.scorm.model

import com.arcusys.valamis.lesson.scorm.model.manifest.{ Manifest, Metadata }
import org.joda.time.DateTime
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class ManifestTest extends FlatSpec with ShouldMatchers {
  val someMetadata = new Metadata(Seq("meta.xml"), Seq("<info>data</info>"))
  "Manifest" can "be constructed" in {
    val manifest = new Manifest(12, version = Some("13"), base = Some("data/"), scormVersion = "2004",
      defaultOrganizationID = Some("O"), resourcesBase = Some("files/"), title = "package1", summary = Some("desc"),
      metadata = Some(someMetadata), courseId = Some(0), isDefault = false, beginDate = Some(new DateTime(1)), endDate = Some(new DateTime(2)))
    manifest.id should equal(12)
    manifest.version should equal(Some("13"))
    manifest.base should equal(Some("data/"))
    manifest.scormVersion should equal("2004")
    manifest.defaultOrganizationID should equal(Some("O"))
    manifest.resourcesBase should equal(Some("files/"))
    manifest.title should equal("package1")
    manifest.summary should equal(Some("desc"))
    manifest.metadata should equal(Some(someMetadata))
    manifest.beginDate.map(_.getMillis) should equal(Some(1))
    manifest.endDate.map(_.getMillis) should equal(Some(2))
  }

  it can "be constructed with defaults" in {
    val manifest = new Manifest(12, version = Some("13"), base = Some("data/"), scormVersion = "2004",
      defaultOrganizationID = Some("O"), resourcesBase = Some("files/"), title = "package1", courseId = Some(0), isDefault = false, beginDate = None, endDate = None)
    manifest.id should equal(12)
    manifest.version should equal(Some("13"))
    manifest.base should equal(Some("data/"))
    manifest.scormVersion should equal("2004")
    manifest.defaultOrganizationID should equal(Some("O"))
    manifest.resourcesBase should equal(Some("files/"))
    manifest.title should equal("package1")
    manifest.summary should equal(None)
    manifest.metadata should equal(None)
    manifest.endDate should equal(None)
    manifest.beginDate should equal(None)
  }

  it can "not be constructed if base start with /" in {
    intercept[IllegalArgumentException] {
      new manifest.Manifest(12, version = Some("13"), base = Some("/data/"), scormVersion = "2004",
        defaultOrganizationID = Some("O"), resourcesBase = Some("files/"), title = "package1", courseId = Some(0), isDefault = false, beginDate = None, endDate = None)
    }
  }

  it can "not be constructed if base does not end with /" in {
    intercept[IllegalArgumentException] {
      new manifest.Manifest(12, version = Some("13"), base = Some("data"), scormVersion = "2004",
        defaultOrganizationID = Some("O"), resourcesBase = Some("files/"), title = "package1", courseId = Some(0), isDefault = false, beginDate = None, endDate = None)
    }
  }

  it can "not be constructed if resource base start with /" in {
    intercept[IllegalArgumentException] {
      new manifest.Manifest(12, version = Some("13"), base = Some("data/"), scormVersion = "2004",
        defaultOrganizationID = Some("O"), resourcesBase = Some("/files/"), title = "package1", courseId = Some(0), isDefault = false, beginDate = None, endDate = None)
    }
  }

  it can "not be constructed if resource base does not end with /" in {
    intercept[IllegalArgumentException] {
      new Manifest(12, version = Some("13"), base = Some("data/"), scormVersion = "2004",
        defaultOrganizationID = Some("O"), resourcesBase = Some("files"), title = "package1", courseId = Some(0), isDefault = false, beginDate = None, endDate = None)
    }
  }
}
