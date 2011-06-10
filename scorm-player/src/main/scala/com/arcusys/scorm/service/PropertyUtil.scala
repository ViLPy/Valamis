package com.arcusys.scorm.service

import java.io.FileReader
import java.io.FileWriter
import java.net.URLDecoder
import java.util.Properties

object PropertyUtil {

  def getResourcePath(name: String) = URLDecoder.decode(Thread.currentThread.getContextClassLoader.getResource(name).getPath,"utf8")

  def load(name: String) = {
    val properties = new Properties
    val resourceStream = new FileReader(getResourcePath(name+".properties"))
    properties.load(resourceStream)
    resourceStream.close
    properties
  }

  def store(name: String, properties: Properties) {
    val resourceStream = new FileWriter(getResourcePath(name+".properties"))
    properties.store(resourceStream, "Written by config application")
    resourceStream.close
  }
}