package com.arcusys.valamis.util.mustache

trait Token {
   def render(context: Any, partials: Map[String, Mustache], callstack: List[Any]): TokenProduct
   def templateSource: String
 }
