package com.arcusys.valamis.lrsEndpoint.storage

import com.arcusys.valamis.lrsEndpoint.model.LrsEndpointSettings

trait LrsEndpointStorage {
  def get: Option[LrsEndpointSettings]
  def getDefault: Option[LrsEndpointSettings]
  def set(lrs: Option[LrsEndpointSettings])
  def renew()
}
