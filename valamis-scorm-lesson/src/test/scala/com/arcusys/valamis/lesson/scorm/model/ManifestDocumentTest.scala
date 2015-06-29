package com.arcusys.valamis.lesson.scorm.model

import com.arcusys.valamis.lesson.scorm.model.manifest._
import com.arcusys.valamis.util.TreeNode
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class ManifestDocumentTest extends FlatSpec with ShouldMatchers {
  val someMetadata = new Metadata(Seq("meta.xml"), Seq("<info>data</info>"))
  val manifest = new Manifest(12, version = Some("13"), base = Some("data/"), scormVersion = "2004",
    defaultOrganizationID = Some("O"), resourcesBase = Some("files/"), title = "package1", summary = Some("desc"),
    metadata = Some(someMetadata), courseId = Some(0), isDefault = false, beginDate = None, endDate = None)
  val resource = new ScoResource("RES1", "file1.html", Some("RES1/files/"), Seq(new ResourceFile("file1.html"), new ResourceFile("file2.js")), Nil)
  val organization = new Organization("O1", "org")
  "Manifest document" can "be constructed" in {
    val doc = new ManifestDocument(manifest,
      Seq(new TreeNode[Activity](organization, Nil)),
      Seq(resource),
      Seq(Sequencing.Default)
    )
    doc.manifest should equal(manifest)
    doc.organizations(0).item should equal(organization)
    doc.resources(0) should equal(resource)
    doc.sequencingCollection(0) should equal(Sequencing.Default)
  }

  it can "not be constructed if resource dependency not found" in {
    intercept[IllegalArgumentException] {
      new ManifestDocument(manifest,
        Seq(new TreeNode[Activity](new Organization("O1", "org"), Nil)),
        Seq(new ScoResource("RES1", "file1.html", Some("RES1/files/"), Seq(new ResourceFile("file1.html"), new ResourceFile("file2.js")), Seq("RES2"))),
        Seq(Sequencing.Default)
      )
    }
  }
}
