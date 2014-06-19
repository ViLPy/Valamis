package com.arcusys.learn.notifications

trait MessageTemplateLoader {
  type HTMLTemplate = String
  def getFor(mtype: MessageType.Value): Option[HTMLTemplate]
  def render(tpl: HTMLTemplate, data: Map[String, _]): String
}
