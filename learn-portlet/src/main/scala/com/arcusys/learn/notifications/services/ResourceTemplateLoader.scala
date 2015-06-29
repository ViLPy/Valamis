package com.arcusys.learn.notifications.services

import com.arcusys.learn.notifications.MessageTemplateLoader.MessageTemplate
import com.arcusys.learn.notifications.{ MessageTemplateLoader, MessageType }
import com.arcusys.valamis.util.mustache.Mustache

import scala.io.Source
import scala.util.Try

object ResourceTemplateLoader extends MessageTemplateLoader {
  import MessageType._

  def getFor(mtype: MessageType.Value): Option[MessageTemplate] = Try {
    val tpl = Source.fromInputStream(
      Thread.currentThread().getContextClassLoader.
        getResourceAsStream(s"emails/${mtype.toString}.html")).mkString
    val subject = mtype match {
      case EnrolledStudent             => "New students have been enrolled on your courses"
      case FinishedLearningModule      => "Students have completed packages"
      case CourseCertificateExpiration => "Certificates are going to expire"
      case CourseCertificateDeadline   => "Certificate' goals are approaching deadlines"
    }
    MessageTemplate(subject, mtype, tpl)
  }.toOption

  def render(tpl: MessageTemplate, data: Map[String, _]): String = {
    val mustached = new Mustache(tpl.body)
    mustached.render(data)
  }
}
