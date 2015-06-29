package com.arcusys.valamis.util.mustache

object EmptyProduct extends TokenProduct {
   val maxLength = 0
   def write(out: StringBuilder): Unit = {}
 }
