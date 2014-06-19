package com.arcusys.learn.tincan.model.lrsServer

import com.arcusys.learn.tincan.model.LrsScope

/**
 * Created by Iliya on 14.02.14.
 */
case class ClientApi(
  id: Long,
  secret: String,
  name: String,
  description: String,
  url: String,
  redirectUrl: String,
  iconUrl: String,
  code: String,
  token: String,
  issuedAt: String,
  expiredIn: Long,
  scope: LrsScope.Value)
