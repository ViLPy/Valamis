package com.arcusys.valamis.util.mustache

case class PartialToken(key: String, otag: String, ctag: String) extends Token {
   def render(context: Any, partials: Map[String, Mustache], callstack: List[Any]): TokenProduct =
     partials.get(key) match {
       case Some(template) => template.product(context, partials, template :: callstack)
       case _              => throw new IllegalArgumentException("Partial \"" + key + "\" is not defined.")
     }
   def templateSource: String = otag + ">" + key + ctag
 }
