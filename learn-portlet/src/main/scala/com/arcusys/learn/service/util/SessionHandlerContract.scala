package com.arcusys.learn.service.util

import javax.servlet.http.Cookie

trait SessionHandlerContract {
  def getSessionID(userID: String):String
  def setAttribute(sessionID: String, key: String, value: Any): Unit
  def getAttribute(cookies: Array[Cookie], key: String): Any
  def getAttribute(sessionID: String, key: String): Any
}
