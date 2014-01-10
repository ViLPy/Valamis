package com.arcusys.learn.tincan.lrsEndpoint

import com.arcusys.learn.tincan.model.LrsEndpointSettings

trait TincanLrsEndpointStorage {
  def get: Option[LrsEndpointSettings]
  def set(lrs: Option[LrsEndpointSettings])
  def renew()
}
