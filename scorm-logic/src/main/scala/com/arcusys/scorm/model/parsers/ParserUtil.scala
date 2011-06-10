package com.arcusys.scorm.model.parsers

import scala.collection.JavaConversions._

object ParserUtil {
  def checkBaseAttributeValue(base: Option[String]) {
    base.foreach(baseValue=>{
        if (baseValue.startsWith("/")) {
          throw new SCORMParserException("Value of `base` attribute starts with `/`");
        }
        if (!baseValue.endsWith("/")) {
          throw new SCORMParserException("Value of `base` attribute does not end with `/`");
        }})
  }
}