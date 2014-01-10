package com.arcusys.learn.tincan.model

import org.specs2.mutable.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

import java.util.Date


@RunWith(classOf[JUnitRunner])
class DocumentSpec extends Specification {

  "The Document's content" can {

    "be created from a sequence of bytes " in {
      val document = Document("id-111", new Date, Seq[Byte](1, 2, 3, 4, 5))
      document.contents === Array[Byte](1, 2, 3, 4, 5)
    }

    "be created from a string" in {
      val document = Document("id-111", new Date, "{x: 1}")
      new String(document.contents) mustEqual "{x: 1}"
    }

  }

}
