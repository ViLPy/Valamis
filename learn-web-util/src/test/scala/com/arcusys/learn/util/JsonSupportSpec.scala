package com.arcusys.learn.util

import org.scalatest.{ Matchers, WordSpec }
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.json4s.{ DefaultFormats, Formats }
import java.util.UUID

@RunWith(classOf[JUnitRunner])
class JsonSupportSpec extends WordSpec with Matchers {

  val integerNumber = 1
  val longNumber = 1L
  val doubleNumber = 23.23D
  val bigDecimalNumber = BigDecimal("12.12")
  val booleanValue = true
  val simpleString = "testing string"

  "JsonSupport serializer" should {
    "serialize primitives" in {
      JsonSupport.json(integerNumber).get should equal("1")
      JsonSupport.json(simpleString).get should equal(""""testing string"""")
      JsonSupport.json(booleanValue).get should equal("true")
      JsonSupport.json(doubleNumber).get should equal("23.23")
      JsonSupport.json(longNumber).get should equal("1")
    }
    "serialize null" in {
      JsonSupport.json(null).get should equal("null")
    }
    "serialize a sequence of primitives" in {
      val listOfNumbers = integerNumber to 10
      val listOfLongNumbers = longNumber to 10L
      val listOfBooleanValues = Seq(true, false, true, false)

      JsonSupport.json(listOfNumbers).get should equal("[1,2,3,4,5,6,7,8,9,10]")
      JsonSupport.json(Seq("a", "b", "c")).get should equal("""["a","b","c"]""")
      JsonSupport.json(listOfBooleanValues).get should equal("[true,false,true,false]")
      JsonSupport.json(listOfLongNumbers).get should equal("[1,2,3,4,5,6,7,8,9,10]")
    }
    "serialize type aliases" in {
      type LanguageMap = Map[String, String]
      val data: LanguageMap = Map("ru" -> "ru_RU", "en" -> "en_EN")
      JsonSupport.json(data).get should equal("""{"ru":"ru_RU","en":"en_EN"}""")
    }
    "serialize Option" in {
      val someString: Option[String] = Some("str")
      val noneString: Option[String] = None

      JsonSupport.json(someString).get should equal("\"str\"")
      JsonSupport.json(noneString).get should equal("")
    }
    "serialize simple case classes" in {
      JsonSupport.json(User("user1", 25, employed = false)).get should equal("""{"name":"user1","age":25,"employed":false}""")
    }
    "serialize case classes which have complex structure" in {
      val score = Score(12.12, None, None, Some(50.50), Threshold(5.5))
      JsonSupport.json(score).get should equal("""{"scaled":12.12,"max":50.5,"init":{"init":5.5}}""")
    }
    "serialize with custom format" in {
      implicit val fs: Formats = DefaultFormats + JsonSupport.extFormats.uuid
      val uuid = UUID.fromString("fae02596-d4a2-40d4-bf7c-6c3c1a7592ac")

      JsonSupport.json(uuid).get should equal("\"fae02596-d4a2-40d4-bf7c-6c3c1a7592ac\"")
    }
  }

  "JsonSupport parser" should {
    "parse to primitives" in {
      JsonSupport.parseJson[Int]("1").get should equal(integerNumber)
      JsonSupport.parseJson[String](""" "testing string" """).get should equal(simpleString)
      JsonSupport.parseJson[Boolean]("true").get shouldBe booleanValue
      JsonSupport.parseJson[Long]("1").get should equal(longNumber)
      JsonSupport.parseJson[Double]("23.23").get should equal(doubleNumber)
    }
    "parse to BigDecimal" in {
      JsonSupport.parseJson[BigDecimal]("12.12").get should equal(bigDecimalNumber)
    }
    "parse json sequences" in {
      JsonSupport.parseJson[Seq[Int]]("[1,2,3,4,5]").get should equal(Seq(1, 2, 3, 4, 5))
      JsonSupport.parseJson[Seq[String]]("""["a","b","c"]""").get should equal(Seq("a", "b", "c"))
      JsonSupport.parseJson[Seq[Boolean]]("[true,false,true]").get should equal(Seq(true, false, true))
      JsonSupport.parseJson[Seq[Long]]("[111,222,333,444]").get should equal(Seq(111L, 222L, 333L, 444L))
      JsonSupport.parseJson[Seq[Double]]("[12.12,13.13,14.14]").get should equal(Seq(12.12, 13.13, 14.14))
    }
    "parse to simple case classes" in {
      val user = JsonSupport.parseJson[User]("""{"name":"user1","age":25,"employed":false}""")
      user.get.name should equal("user1")
      user.get.age should equal(25)
      user.get.employed shouldBe false
    }
    "parse to complex case classes" in {
      val score = JsonSupport.parseJson[Score]("""{"scaled":12.12,"max":50.5,"init":{"init":5.5}}""")
      score.get.scaled should equal(bigDecimalNumber)
      score.get.min shouldBe None
      score.get.max shouldBe Some(BigDecimal("50.50"))
      score.get.init should equal(Threshold(BigDecimal(5.5)))
    }
    "parse to UUID" in {
      implicit val fs: Formats = DefaultFormats + JsonSupport.extFormats.uuid
      val json = "\"fae02596-d4a2-40d4-bf7c-6c3c1a7592ac\""
      JsonSupport.parseJson[UUID](json).get should equal(UUID.fromString("fae02596-d4a2-40d4-bf7c-6c3c1a7592ac"))
    }
  }

}

case class User(name: String, age: Int, employed: Boolean)
case class Threshold(init: BigDecimal)

case class Score(
  scaled: BigDecimal,
  raw: Option[BigDecimal],
  min: Option[BigDecimal],
  max: Option[BigDecimal],
  init: Threshold)

