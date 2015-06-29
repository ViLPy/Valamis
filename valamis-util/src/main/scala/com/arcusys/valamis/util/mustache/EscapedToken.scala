package com.arcusys.valamis.util.mustache

case class EscapedToken(key: String, otag: String, ctag: String)
  extends Token
       with ContextHandler
       with ValuesFormatter {
     private val source = otag + key + ctag

     def render(context: Any, partials: Map[String, Mustache], callstack: List[Any]): TokenProduct = {
       val v = format(valueOf(key, context, partials, callstack, "", defaultRender(otag, ctag)))
       new TokenProduct {
         val maxLength = (v.length * 1.2).toInt
         def write(out: StringBuilder): Unit =
           v.foreach {
             case '<' => out.append("&lt;")
             case '>' => out.append("&gt;")
             case '&' => out.append("&amp;")
             case '"' => out.append("&quot;")
             case c   => out.append(c)
           }
       }
     }

     def templateSource: String = source
   }
