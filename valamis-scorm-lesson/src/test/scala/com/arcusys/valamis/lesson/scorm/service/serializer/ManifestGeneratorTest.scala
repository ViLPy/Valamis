package com.arcusys.valamis.lesson.scorm.service.serializer

import com.arcusys.valamis.lesson.scorm.model.manifest.{ Activity, Manifest, ManifestDocument, Organization }
import com.arcusys.valamis.lesson.scorm.service.parser.ManifestParser
import com.arcusys.valamis.util.TreeNode
import org.junit.Assert._
import org.junit._

class ManifestGeneratorTest {
  @Test
  def testManifestGeneratorAndParser() {
    val doc = new ManifestDocument(
      new Manifest(12, Some("1.1"), Some("data/"), "1.0", Some("orgId1"), Some("base/"), "title", Some("summary"), courseId = Some(0), isDefault = false, beginDate = None, endDate = None),
      organizations = Seq(new TreeNode[Activity](new Organization("orgId1", "Test organization"), Nil)),
      resources = Nil, sequencingCollection = Nil
    )

    val generated = ManifestGenerator.toXML(doc)
    val parser = new ManifestParser(generated, "title", "summary")
    val parsedDoc = parser.parse

    assertEquals(doc.manifest.version, parsedDoc.manifest.version)
    assertEquals(doc.manifest.base, parsedDoc.manifest.base)
    assertEquals(doc.manifest.resourcesBase, parsedDoc.manifest.resourcesBase)
  }
}
