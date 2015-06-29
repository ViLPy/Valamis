package com.arcusys.valamis.util.mustache

case class RootToken(children: List[Token]) extends Token with CompositeToken {
   private val childrenSource = children.map(_.templateSource).mkString

   def render(context: Any, partials: Map[String, Mustache], callstack: List[Any]): TokenProduct =
     composite(children, context, partials, callstack)

   def templateSource: String = childrenSource
 }
