package com.arcusys.learn.storage.impl.orbroker

import org.junit.runners.Parameterized.Parameters
import com.arcusys.scorm.util.PropertyUtil

object ParameterizedUnitTests {
  @Parameters
  def parameters = {
    val list = new java.util.ArrayList[Array[String]]()
    Seq("db", "dbH2").foreach(n => list.add(Array(n)))
    list
  }
}

class ParameterizedUnitTests(dbFileName: String) {
  BrokerFactory.init(PropertyUtil.load(dbFileName))
}
