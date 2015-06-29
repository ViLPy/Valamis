package com.arcusys.valamis.util.mustache

case class UnescapedToken(key: String, otag: String, ctag: String)
  extends Token
       with ContextHandler
       with ValuesFormatter {
     private val source = otag + "&" + key + ctag

     def render(context: Any, partials: Map[String, Mustache], callstack: List[Any]): TokenProduct = {
       val v = format(valueOf(key, context, partials, callstack, "", defaultRender(otag, ctag)))
       new TokenProduct {
         val maxLength = v.length
         def write(out: StringBuilder): Unit = { out.append(v) }
       }
     }

     def templateSource: String = source
   }
