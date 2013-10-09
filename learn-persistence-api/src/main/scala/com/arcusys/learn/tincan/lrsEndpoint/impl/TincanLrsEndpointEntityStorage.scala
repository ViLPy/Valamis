package com.arcusys.learn.tincan.lrsEndpoint.impl

import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage
import com.arcusys.learn.tincan.model.LrsEndpointSettings
import com.arcusys.learn.storage.impl.EntityStorage

trait TincanLrsEndpointEntityStorage extends TincanLrsEndpointStorage with EntityStorage[LrsEndpointSettings] {

  def get: Option[LrsEndpointSettings] = {
    getOne(Seq[(String, Any)]():_*)
  }

  def set(lrs: LrsEndpointSettings) {
    modify(lrs, Seq[(String, Any)]():_*)
  }
}
