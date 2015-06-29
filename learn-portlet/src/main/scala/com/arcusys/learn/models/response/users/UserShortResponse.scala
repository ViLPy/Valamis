package com.arcusys.learn.models.response.users

import com.arcusys.valamis.lrs.model.EndpointInfo

case class UserShortResponse(id: Long,
  name: String,
  picture: String = "",
  pageUrl: String = "",
  email: Option[String] = None,
  endpointInfo: Option[EndpointInfo] = None)