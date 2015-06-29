package com.arcusys.valamis.util.mustache

case class ChangeDelimitersToken(
     newOTag: String, newCTag: String, otag: String, ctag: String) extends Token {
        private val source = otag + "=" + newOTag + " " + newCTag + "=" + ctag

        def render(context: Any, partials: Map[String, Mustache], callstack: List[Any]): TokenProduct = EmptyProduct

        def templateSource: String = source
      }
