package com.arcusys.scorm.generator.util

object ResourceHelpers {
  def fetchResources(sourceText: String) = {
    // extract all images from question text
    ("""(?i)(?<=SCORMData/)(.+?)(?=")""".r findAllIn sourceText).toArray
  }
  
  def skipContextPathURL(source: String) = {
    // skip context-path
    """(?i)(?<=")([^"]*?)SCORMData/""".r replaceAllIn(source, "")
  }

  def getCommonResourceByName(fileName:String) = {
    Thread.currentThread.getContextClassLoader.getResourceAsStream("common/" + fileName)
  }
}
