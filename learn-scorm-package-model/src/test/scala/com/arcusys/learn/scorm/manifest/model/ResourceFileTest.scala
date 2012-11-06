package com.arcusys.learn.scorm.manifest.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ResourceFileTest extends FlatSpec with ShouldMatchers {
  val someMetadata = new Metadata(Seq("meta.xml"), Seq("<info>data</info>"))
  "Resource file entity" can "be constructed" in {
    val resourceFile = new ResourceFile("file1.html", Some(someMetadata))
    resourceFile.href should equal("file1.html")
    resourceFile.metadata should equal(Some(someMetadata))
  }
  it can "be constructed without metadata" in {
    val resourceFile = new ResourceFile("file1.html")
    resourceFile.href should equal("file1.html")
    resourceFile.metadata should equal(None)
  }
  it should "not accept url with leading slash" in {
    intercept[IllegalArgumentException] {
      new ResourceFile("/file1.html", Some(someMetadata))
    }
  }
  it should "not accept url with parameters" in {
    intercept[IllegalArgumentException] {
      new ResourceFile("file1.html?goto=1", Some(someMetadata))
    }
  }
  it should "not accept external urls" in {
    intercept[IllegalArgumentException] {
      new ResourceFile("http://google.com", Some(someMetadata))
    }
    intercept[IllegalArgumentException] {
      new ResourceFile("ftp://google.com", Some(someMetadata))
    }
  }
}
