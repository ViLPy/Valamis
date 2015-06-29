package com.arcusys.valamis.util.mustache

case class StaticTextToken(staticText: String) extends Token {
   private val product = StringProduct(staticText)

   def render(context: Any, partials: Map[String, Mustache], callstack: List[Any]): TokenProduct = product

   def templateSource: String = staticText

 }
