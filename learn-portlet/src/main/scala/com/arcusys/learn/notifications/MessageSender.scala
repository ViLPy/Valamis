package com.arcusys.learn.notifications

import com.liferay.mail.service.MailServiceUtil
import com.liferay.portal.kernel.mail.MailMessage

import javax.mail.internet.InternetAddress

trait MessageSender {
  def from = "no-reply@valamis.fi"

  // to emulate dsl-like behaviour
  object send {
    def Message(subject: String, body: String, to: String) {
      val fromAddress = new InternetAddress(from)
      val toAddress = new InternetAddress(to)
      val mail = new MailMessage

      mail.setTo(toAddress)
      mail.setFrom(fromAddress)
      mail.setSubject(subject)
      mail.setBody(body)
      mail.setHTMLFormat(true)

      sendMessage(mail)
    }
  }

  protected def sendMessage(m: MailMessage) {
    MailServiceUtil.sendEmail(m)
  }
}

class MessageSenderException(msg: String) extends Exception(msg)