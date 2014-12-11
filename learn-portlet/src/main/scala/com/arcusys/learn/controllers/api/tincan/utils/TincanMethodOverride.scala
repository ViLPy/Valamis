package com.arcusys.learn.tincan.api.utils

import java.io.StringBufferInputStream
import java.net.URLDecoder
import javax.servlet.http.{ HttpServletRequest, HttpServletRequestWrapper, HttpServletResponse }

import com.liferay.portal.kernel.servlet.ServletInputStreamAdapter
import org.scalatra.Handler

import scala.collection.JavaConverters._

/**
 * Mixin for clients that only support a limited set of HTTP verbs.  If the
 * request is a POST and the `method` request parameter is set, the value of
 * the `method` parameter is treated as the request's method.
 */
trait TincanMethodOverride extends Handler {
  private val paramName = "method"

  abstract override def handle(req: HttpServletRequest, res: HttpServletResponse) {
    val req2 = req.getMethod match {
      case "POST" =>
        req.getParameter(paramName) match {
          case null => req
          case method => new HttpServletRequestWrapper(req) {
            private val encoding = req.getCharacterEncoding
            private val enc = if (encoding == null || encoding.trim.length == 0) {
              "ISO-8859-1"
            } else encoding
            private final val bodyContent = URLDecoder.decode(scala.io.Source.fromInputStream(req.getInputStream).mkString, enc)

            override def getMethod = method.toUpperCase

            override def getParameterMap: java.util.Map[_, _] = {
              bodyContent.split("&").map(param => {
                val paramSplit = param.split("=").toSeq
                (paramSplit.head, if (paramSplit.length == 2) Array[String](paramSplit.last) else Array[String]())
              }).filter(_._2 != null).toMap.asJava
            }

            override def getContentType = {
              bodyContent.split("&").find(param => {
                val paramSplit = param.split("=").toSeq
                paramSplit.head.equals("Content-Type")
              }).getOrElse("").split("=").last
            }

            override def getInputStream = {
              val c = bodyContent.split("&").find(param => {
                val paramSplit = param.split("=").toSeq
                paramSplit.head.equals("content")
              }).getOrElse("").split("=").last

              new ServletInputStreamAdapter(new StringBufferInputStream(c))
            }
          }
        }
      case _ =>
        req
    }
    super.handle(req2, res)
  }
}