package com.arcusys.learn.service.util

import scala.collection.mutable.{HashMap => MutableMap}
import javax.servlet.http.Cookie

/**
 * Because Liferay session management doesn't work properly
 */
object SessionHandler extends SessionHandlerContract{
  private val sessions = new MutableMap[String, MutableMap[String, Any]]()
  private val users = new MutableMap[String, String]()

  def getSessionID(userID: String):String = {
    if (users.contains(userID)) {
      users(userID)
    } else {
      val id = userID + java.util.UUID.randomUUID().toString
      users.put(userID,id)
      sessions.put(id, new MutableMap[String, Any]())
      id
    }
  }

  def setAttribute(sessionID: String, key: String, value: Any) {
    if (sessions.contains(sessionID)) {
      sessions(sessionID).put(key,value)
    }
  }

  def getAttribute(cookies: Array[Cookie], key: String):Any = {
    val sessionID = cookies.find(_.getName == "valamisSessionID").map(_.getValue).getOrElse("")
    getAttribute(sessionID, key)
  }

  def getAttribute(sessionID: String, key: String):Any = {
    if (sessions.contains(sessionID)) {
      sessions(sessionID)(key)
    } else null
  }
}
