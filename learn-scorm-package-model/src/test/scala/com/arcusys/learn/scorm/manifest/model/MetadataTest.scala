package com.arcusys.learn.scorm.manifest.model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class MetadataTest extends FlatSpec with ShouldMatchers {

  "Metadata" can "be constructed" in {
    val externalLocations = Seq("Loc1", "Loc2")
    val inline = Seq("<inlineM>MM</inlineM>")
    val metadata = new Metadata(externalLocations, inline)
    metadata.externalMetadataLocations should equal(externalLocations)
    metadata.inlineMetadata should equal(inline)
  }

  it can "be constructed with empty external locations" in {
    val inline = Seq("<inlineM>MM</inlineM>")
    val metadata = new Metadata(Nil, inline)
    metadata.externalMetadataLocations should equal(Nil)
    metadata.inlineMetadata should equal(inline)
  }

  it can "be constructed with empty inline" in {
    val externalLocations = Seq("Loc1", "Loc2")
    val metadata = new Metadata(externalLocations, Nil)
    metadata.externalMetadataLocations should equal(externalLocations)
    metadata.inlineMetadata should equal(Nil)
  }

  it can "be constructed with empty external locations and inline" in {
    val metadata = new Metadata(Nil, Nil)
    metadata.externalMetadataLocations should equal(Nil)
    metadata.inlineMetadata should equal(Nil)
  }
}
