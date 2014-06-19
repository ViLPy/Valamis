package com.arcusys.learn.notifications.services

import com.arcusys.learn.notifications.{ MessageType, MessageTemplateLoader }
import com.arcusys.learn.util.mustache.Mustache

import scala.util.Try
import scala.io.Source

object ResourceTemplateLoader extends MessageTemplateLoader {

  def getFor(mtype: MessageType.Value): Option[this.HTMLTemplate] = Try {
    Source.fromInputStream(
      Thread.currentThread().getContextClassLoader.
        getResourceAsStream(s"emails/${mtype.toString}.html")).mkString
  }.toOption

  def render(tpl: this.HTMLTemplate, data: Map[String, _]): String = {
    val mustached = new Mustache(tpl)
    mustached.render(data)
  }

}
