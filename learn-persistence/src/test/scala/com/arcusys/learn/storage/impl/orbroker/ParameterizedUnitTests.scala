package com.arcusys.learn.storage.impl.orbroker

import org.junit.runners.Parameterized.Parameters
import com.arcusys.scorm.util.PropertyUtil

object ParameterizedUnitTests {
  val dbListForTestProperty = "db.config.names"

  @Parameters
  def parameters = {
    val list = new java.util.ArrayList[Array[String]]()
    // Seq("db", "dbH2", "dbMySQL").foreach(n => list.add(Array(n)))
    Option(System.getProperty(dbListForTestProperty)).getOrElse("dbH2").split(",").foreach(n => list.add(Array(n)))
    list
  }
}

class ParameterizedUnitTests(dbFileName: String) {
  BrokerFactory.init(PropertyUtil.load(dbFileName))
}
