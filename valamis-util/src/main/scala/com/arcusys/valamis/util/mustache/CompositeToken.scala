package com.arcusys.valamis.util.mustache

trait CompositeToken {
   def composite(
     tokens: List[Token], context: Any, partials: Map[String, Mustache], callstack: List[Any]): TokenProduct =
     composite(tokens.map { (_, context) }, partials, callstack)

   def composite(
     tasks: Seq[Tuple2[Token, Any]], partials: Map[String, Mustache], callstack: List[Any]): TokenProduct = {
     val result = tasks.map(t => { t._1.render(t._2, partials, callstack) })
     val len = result.foldLeft(0)({ _ + _.maxLength })
     new TokenProduct {
       val maxLength = len
       def write(out: StringBuilder) = result.map { _.write(out) }
     }
   }
 }
