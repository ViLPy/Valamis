/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.arcusys.scorm.util

import scala.util.parsing.json.JSON._

object JSON
{
  def toJSON(obj: Any): String =
  {
    def prepareMap(m: Map[Any,Any]) = for(item<-m) yield (toJSON(item._1) + ":" + toJSON(item._2))
    def prepareList(l: Seq[Any]) = for(item<-l) yield toJSON(item)

    obj match
    {
      case m: Map[Any,Any] => if (!m.isEmpty) "{" + prepareMap(m).reduceLeft[String]( (result, n) => result + "," + n) + "}" else "{}"
      case t: Tuple2[Any,Any] => "[" + toJSON(t._1) + ":" + toJSON(t._2) + "]"
      case l: Seq[Any] => if (!l.isEmpty) "[" + prepareList(l).reduceLeft[String]( (result, n) => result + "," + n) + "]" else "[]"
      case c: Char => "\"" + c + "\""
      case s: String => "\"" + s + "\""
      case b: Boolean => "\"" + b.toString + "\""
      case _ => obj.toString
    }
  }
  
  def toObject(json: String): Any = {
    parseFull(json).getOrElse(throw new Exception("Can't parse JSON: " + json))
  }
}
