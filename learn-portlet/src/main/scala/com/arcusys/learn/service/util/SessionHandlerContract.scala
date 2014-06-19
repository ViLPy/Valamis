package com.arcusys.learn.service.util

import javax.servlet.http.{ HttpServletRequest, Cookie }
import org.scalatra.servlet.RichRequest
import com.arcusys.learn.exceptions.AccessDeniedException

trait SessionHandlerContract {
  def getSessionID(userID: String): String
  def setAttribute(sessionID: String, key: String, value: Any): Unit
  def getAttribute(cookies: Array[Cookie], key: String): Any
  def getAttribute(sessionID: String, key: String): Any

  def isAdmin(implicit request: HttpServletRequest) = try {
    getAttribute(request.getCookies, "isAdmin").asInstanceOf[Boolean]
  } catch {
    case e: Exception => false
  }

  def hasTeacherPermissions()(implicit request: HttpServletRequest) = try {
    getAttribute(request.getCookies, "hasTeacherPermissions").asInstanceOf[Boolean]
  } catch {
    case e: Exception => false
  }

  def getCompanyId()(implicit request: RichRequest) = {
    val company = request.cookies.get("COMPANY_ID")
    company.getOrElse("-1").toInt
  }

  def getSessionUserID()(implicit request: HttpServletRequest) = try {
    getAttribute(request.getCookies, "userID").asInstanceOf[String].toInt
  } catch {
    case e: Exception => -1 // guest
  }

  def requireAdmin()(implicit request: HttpServletRequest) {
    if (!isAdmin) throw new AccessDeniedException
  }

  def requireTeacherPermissions()(implicit request: HttpServletRequest) {
    if (!hasTeacherPermissions) throw new AccessDeniedException
  }
}
