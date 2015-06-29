package com.arcusys.valamis.util.mustache

case class MustacheParseException(line: Int, msg: String)
  extends Exception("Line " + line + ": " + msg)
