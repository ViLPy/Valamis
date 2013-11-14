package com.arcusys.learn.service.util

import org.owasp.validator.html._

object AntiSamyHelper {
  private val policy = Policy.getInstance(Thread.currentThread().getContextClassLoader.getResourceAsStream("antisamy-tinymce.xml"))
  private val as = new AntiSamy()

  def sanitize(text: String) = {
    val cr = as.scan(text, policy)
    cr.getCleanHTML.replaceAll("\n", "").replaceAll("\"", "\\\"") // strip newlines
  }
}
