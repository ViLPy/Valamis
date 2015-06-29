package com.arcusys.valamis.util.mustache

trait TokenProduct {
   val maxLength: Int
   def write(out: StringBuilder): Unit

   override def toString = {
     val b = new StringBuilder(maxLength)
     write(b)
     b.toString
   }
 }
