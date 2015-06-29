package com.arcusys.valamis.util.mustache

case class StringProduct(str: String) extends TokenProduct {
   val maxLength = str.length
   def write(out: StringBuilder): Unit = out.append(str)
 }
