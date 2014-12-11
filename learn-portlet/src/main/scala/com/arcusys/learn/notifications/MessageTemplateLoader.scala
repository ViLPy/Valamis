package com.arcusys.learn.notifications

trait MessageTemplateLoader {
  import MessageTemplateLoader._
  def getFor(mtype: MessageType.Value): Option[MessageTemplate]
  def render(tpl: MessageTemplate, data: Map[String, _]): String
}

object MessageTemplateLoader {
  case class MessageTemplate(subject: String, typ: MessageType.Value, body: String)
}
