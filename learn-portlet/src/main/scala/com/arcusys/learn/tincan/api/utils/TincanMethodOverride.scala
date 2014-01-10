package com.arcusys.learn.tincan.api.utils

import javax.servlet.http.{HttpServletRequestWrapper, HttpServletRequest, HttpServletResponse}
import org.scalatra.Handler
import scala.collection.JavaConverters._

/**
 * Mixin for clients that only support a limited set of HTTP verbs.  If the
 * request is a POST and the `method` request parameter is set, the value of
 * the `method` parameter is treated as the request's method.
 */
trait TincanMethodOverride extends Handler {
  abstract override def handle(req: HttpServletRequest, res: HttpServletResponse) {
    val req2 = req.getMethod match {
      case "POST" =>
        req.getParameter(paramName) match {
          case null => req
          case method => new HttpServletRequestWrapper(req) {
            override def getMethod = method.toUpperCase
            override def getParameterMap: java.util.Map[_, _] = {
              val body = scala.io.Source.fromInputStream(req.getInputStream).mkString
              body.split("&").map(param => {
                val paramSplit = param.split("=").toSeq
                (paramSplit.head, if (paramSplit.length == 2) Array[String](paramSplit.last) else Array[String]())
              }).filter(_._2 != null).toMap.asJava
            }
          }
        }
      case _ =>
        req
    }
    super.handle(req2, res)
  }

  private val paramName = "method"
}