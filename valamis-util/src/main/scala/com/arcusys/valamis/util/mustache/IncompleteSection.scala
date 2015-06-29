package com.arcusys.valamis.util.mustache

case class IncompleteSection(key: String, inverted: Boolean, otag: String, ctag: String) extends Token {
   def render(context: Any, partials: Map[String, Mustache], callstack: List[Any]): TokenProduct = fail
   def templateSource: String = fail

   private def fail =
     throw new Exception("Weird thing happened. There is incomplete section in compiled template.")

 }
