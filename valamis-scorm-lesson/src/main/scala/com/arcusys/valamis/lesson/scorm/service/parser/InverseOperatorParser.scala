package com.arcusys.valamis.lesson.scorm.service.parser

object InverseOperatorParser {
  def parse(value: String) =
    Map("noOp" -> false, "not" -> true).getOrElse(value, throw new SCORMParserException("Invalid `operator` attribute value"))
}