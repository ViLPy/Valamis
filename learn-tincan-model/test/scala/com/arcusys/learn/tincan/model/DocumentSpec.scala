package com.arcusys.learn.tincan.model

import org.specs2.mutable.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DocumentSpec extends Specification {

  "The Document's content" can {
    "be created from a string" in {
      val document = Document("my content", JSONContent)
      new String(document.contents) mustEqual "my content"
    }
  }
}
