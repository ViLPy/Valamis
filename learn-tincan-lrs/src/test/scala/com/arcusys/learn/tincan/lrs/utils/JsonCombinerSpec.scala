package com.arcusys.learn.tincan.lrs.utils

import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith

import org.json4s.DefaultFormats
import com.fasterxml.jackson.core.JsonParseException
import org.json4s.jackson.JsonMethods._

@RunWith(classOf[JUnitRunner])
class JsonCombinerSpec extends Specification {
  implicit val format = DefaultFormats

  "The JsonCombiner Specification".title

  "The JsonCombiner" should {

    "merge posted document with the existing one with only top-level properties" in {
      val targetJson = """{"x":"foo","y":"bar"}"""
      val postedJSON = """{"x":"bash"}"""

      val merged = JsonCombiner.combine(targetJson, postedJSON)
      val parsed = parse(merged)

      (parsed \ "x").extract[String] mustEqual "bash"
      (parsed \ "y").extract[String] mustEqual "bar"
    }

    "merge posted document with the existing one with only top-level properties " +
      "even if top-level property is an Object" in {
        val targetJson = """{"x":"foo","y":"bar","z":{"a":1,"b":2}}"""
        val postedJSON = """{"x":"bash","z":"faz"}"""

        val merged = JsonCombiner.combine(targetJson, postedJSON)
        val parsed = parse(merged)

        (parsed \ "x").extract[String] mustEqual "bash"
        (parsed \ "y").extract[String] mustEqual "bar"
        (parsed \ "z").extract[String] mustEqual "faz"
      }

    "merge posted document with existing one while adding new property" in {
      val targetJson = """{"x":"foo"}"""
      val postedJSON = """{"x":"bash","y":"faz"}"""

      val merged = JsonCombiner.combine(targetJson, postedJSON)
      val parsed = parse(merged)

      (parsed \ "x").extract[String] mustEqual "bash"
      (parsed \ "y").extract[String] mustEqual "faz"
    }

    "merge posted document with existing one while adding new Object as top-level property" in {
      val targetJson = """{"x":"foo","y":"faz"}"""
      val postedJSON = """{"x":"bash","z":{"a":1,"b":2}}"""

      val merged = JsonCombiner.combine(targetJson, postedJSON)
      val parsed = parse(merged)

      (parsed \ "x").extract[String] mustEqual "bash"
      (parsed \ "y").extract[String] mustEqual "faz"
      (parsed \ "z" \ "a").extract[String] mustEqual "1"
      (parsed \ "z" \ "b").extract[String] mustEqual "2"
    }

    "treat the numbers as the valid json while merging posted document with existing one" in {
      val targetJson = "0"
      val postedJSON = "1"

      val merged = JsonCombiner.combine(targetJson, postedJSON)

      merged mustEqual "1"
    }

    "be able to work with byte sequences as document content" in {
      val target = """{"x":"foo"}""".toCharArray.map(_.toByte)
      val toBeMerged = """{"x":"bash","y":"faz"}""".toCharArray.map(_.toByte)

      val merged = JsonCombiner.combine(target, toBeMerged)
      val parsed = parse(new String(merged))

      (parsed \ "x").extract[String] mustEqual "bash"
      (parsed \ "y").extract[String] mustEqual "faz"
    }

    "throw 'com.fasterxml.jackson.core.JsonParseException' if posted document has malformed json content" in {
      val targetJson = """{"x":"foo","y":"faz"}"""
      val postedJSON = "malformed json..."
      JsonCombiner.combine(targetJson, postedJSON) must throwA[JsonParseException]
    }

    "throw 'com.fasterxml.jackson.core.JsonParseException' if the existing document has malformed json content" in {
      val targetJson = "malformed json..."
      val postedJSON = """{"x":"foo","y":"faz"}"""
      JsonCombiner.combine(targetJson, postedJSON) must throwA[JsonParseException]
    }
  }

}
