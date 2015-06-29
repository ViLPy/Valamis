package com.arcusys.valamis.certificate.service.util

import java.io.{ BufferedReader, InputStreamReader }
import java.util

import org.apache.http.NameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.{ HttpGet, HttpPost }
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.message.BasicNameValuePair

import scala.util.parsing.json.JSON

object OpenBadgesHelper {

  def getOpenBadges(email: String): List[Map[String, Any]] = {
    val userId = getOpenBadgesUserId(email)
    val group = if (userId != null) getOpenBadgesValamisGroup(userId) else null
    if (userId != null && group != null) return getOpenBadges(userId, group)
    Nil
  }

  private def getOpenBadgesUserId(email: String): String = {
    try {
      val url = "http://beta.openbadges.org/displayer/convert/email"
      val client = new DefaultHttpClient
      val post = new HttpPost(url)

      val nameValuePairs = new util.ArrayList[NameValuePair]()
      nameValuePairs.add(new BasicNameValuePair("email", email))
      post.setEntity(new UrlEncodedFormEntity(nameValuePairs))

      val resp = client.execute(post)
      if (resp.getStatusLine.getStatusCode != 200) return null

      val rd = new BufferedReader(new InputStreamReader(resp.getEntity.getContent))
      val userId = JSON.parseFull(rd.readLine()) match {
        case Some(x) => {
          val m = x.asInstanceOf[Map[String, Any]]
          m("userId").toString
        }
        case _ => null
      }
      rd.close()
      userId
    } catch {
      case e: Exception => {
        System.out.println("Problem on getting UserID from Mozzila Open Badges " + e.toString)
        null
      }
    }
  }

  private def getOpenBadgesValamisGroup(userId: String): String = {
    try {
      val url = "http://beta.openbadges.org/displayer/" + userId + "/groups.json"
      val client = new DefaultHttpClient
      val request = new HttpGet(url)
      val resp = client.execute(request)

      if (resp.getStatusLine.getStatusCode != 200) return null

      val rd = new BufferedReader(new InputStreamReader(resp.getEntity.getContent))
      JSON.parseFull(rd.readLine()) match {
        case Some(x) => {
          val m = x.asInstanceOf[Map[String, Any]]
          val groups = m("groups").asInstanceOf[List[Map[String, Any]]]
          groups.foreach(i => {
            if (i("name").toString.toLowerCase.contains("valamis")) return i("groupId").toString
          })
        }
        case _ => null
      }
      null
    } catch {
      case e: Exception => {
        System.out.println("Problem on getting valamis group from Mozzila Open Badges " + e.toString)
        null
      }
    }
  }

  private def getOpenBadges(userId: String, groupId: String): List[Map[String, Any]] = {
    try {
      val url = "http://beta.openbadges.org/displayer/" + userId + "/group/" + groupId + ".json"
      val client = new DefaultHttpClient
      val request = new HttpGet(url)
      val resp = client.execute(request)

      if (resp.getStatusLine.getStatusCode != 200) return Nil

      val rd = new BufferedReader(new InputStreamReader(resp.getEntity.getContent))
      JSON.parseFull(rd.readLine()) match {
        case Some(x) => {
          val m = x.asInstanceOf[Map[String, Any]]

          val badges = m("badges").asInstanceOf[List[Map[String, Any]]]
          return badges.map(i => {
            val badge = (i("assertion").asInstanceOf[Map[String, Any]])("badge").asInstanceOf[Map[String, Any]]
            Map(
              "title" -> badge("name"),
              "description" -> badge("description"),
              "logo" -> i("imageUrl"),
              "isPermanent" -> true
            )
          }).toList
        }
        case _ => Nil
      }
      Nil
    } catch {
      case e: Exception => {
        System.out.println("Problem on getting valamis certificates from Mozzila Open Badges " + e.toString)
        Nil
      }
    }
  }
}
