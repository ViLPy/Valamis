package com.arcusys.scorm.generator.util

object ResourceHelpers {
  def fetchImageResources(sourceText: String) = {
    // extract all images from question text
    ("""(?i)SCORMData/(.+?)(png|jpg|gif|bmp)""".r findAllIn sourceText).toArray
  }
  
  def skipContextPathURL(source: String) = {
    // skip context-path
    """(?i)/(.[^/]+?)/SCORMData/""".r replaceAllIn(source, "SCORMData/")
  }
}
