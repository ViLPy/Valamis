package com.arcusys.learn.models.response.users

/**
 * Created by Iliya Tryapitsin on 12.03.14.
 */
case class UserShortResponse(id: Long,
  name: String,
  picture: String = "",
  pageUrl: String = "",
  email: Option[String] = None)
