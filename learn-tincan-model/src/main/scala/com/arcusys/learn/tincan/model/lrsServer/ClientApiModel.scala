package com.arcusys.learn.tincan.model.lrsServer

import com.arcusys.learn.tincan.model.LrsScope.LrsScope

//
// Created by iliya.tryapitsin on 12.02.14.
//
case class ClientApiModel(
  clientId: String,
  clientSecret: String,
  clientName: String,
  issuedAt: String,
  expiredIn: Long,
  scope: LrsScope)
