package com.arcusys.learn.scorm.manifest.parser

object InverseOperatorParser {
  def parse(value: String) =
    Map("noOp" -> false, "not" -> true).getOrElse(value, throw new SCORMParserException("Invalid `operator` attribute value"))
}