package com.arcusys.learn.scorm.manifest.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import com.arcusys.learn.util.TreeNode

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ResourceUrlTest extends FlatSpec with ShouldMatchers {
  "Resource URL" can "be built" in {
    val url = ResourceUrl(
      base = Some("base/"),
      resourcesBase = Some("resourcesBase/"),
      resourceBase = Some("resourceBase/"),
      href = "href",
      parameters = Some("param=value"))
    url should equal("base/resourcesBase/resourceBase/href?param=value")
  }

  it can "be built from empty bases" in {
    val url = ResourceUrl(
      base = None,
      resourcesBase = None,
      resourceBase = None,
      href = "href",
      parameters = None)
    url should equal("href")
  }

  it can "be built with parameters starting with ?" in {
    val url = ResourceUrl(
      base = Some("base/"),
      resourcesBase = Some("resourcesBase/"),
      resourceBase = Some("resourceBase/"),
      href = "href",
      parameters = Some("?param=value"))
    url should equal("base/resourcesBase/resourceBase/href?param=value")
  }

  it can "be built with parameters starting with &" in {
    val url = ResourceUrl(
      base = Some("base/"),
      resourcesBase = Some("resourcesBase/"),
      resourceBase = Some("resourceBase/"),
      href = "href",
      parameters = Some("&param=value"))
    url should equal("base/resourcesBase/resourceBase/href?param=value")
  }

  it can "be built with parameters even if href already has parameters" in {
    val url = ResourceUrl(
      base = Some("base/"),
      resourcesBase = Some("resourcesBase/"),
      resourceBase = Some("resourceBase/"),
      href = "href?id=2",
      parameters = Some("param=value"))
    url should equal("base/resourcesBase/resourceBase/href?id=2&param=value")
  }

  it should "disregard #-parameters if href has #" in {
    val url = ResourceUrl(
      base = Some("base/"),
      resourcesBase = Some("resourcesBase/"),
      resourceBase = Some("resourceBase/"),
      href = "href#2",
      parameters = Some("#param"))
    url should equal("base/resourcesBase/resourceBase/href#2")
  }
}
