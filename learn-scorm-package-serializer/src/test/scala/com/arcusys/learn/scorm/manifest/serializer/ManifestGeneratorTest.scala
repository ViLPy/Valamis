package com.arcusys.learn.scorm.manifest.serializer

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.parser._
import org.junit._
import Assert._
import com.arcusys.learn.util.TreeNode

class ManifestGeneratorTest {
  @Test
  def testManifestGeneratorAndParser() {
    val doc = new ManifestDocument(
      new Manifest(12, Some("1.1"), Some("data/"), "1.0", Some("orgId1"), Some("base/"), "title", Some("summary")),
      organizations = Seq(new TreeNode[Activity](new Organization("orgId1", "Test organization"), Nil)),
      resources = Nil, sequencingCollection = Nil
    )

    val generated = ManifestGenerator.toXML(doc)
    val parsedDoc = new ManifestParser(generated, "title", "summary").parse

    assertEquals(doc.manifest.version, parsedDoc.manifest.version)
    assertEquals(doc.manifest.base, parsedDoc.manifest.base)
    assertEquals(doc.manifest.resourcesBase, parsedDoc.manifest.resourcesBase)
  }
}
