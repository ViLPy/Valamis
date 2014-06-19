package com.arcusys.learn.tincan.lrsEndpoint.impl

import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.tincan.model.lrsClient.LrsEndpointSettings

trait TincanLrsEndpointEntityStorage extends TincanLrsEndpointStorage with EntityStorage[LrsEndpointSettings] {

  def get: Option[LrsEndpointSettings] = {
    getOne(Seq[(String, Any)](): _*)
  }

  def set(lrs: Option[LrsEndpointSettings]) {
    lrs match {
      case Some(lrs: LrsEndpointSettings) => modify(lrs, Nil: _*)
      case _                              => delete(Nil: _*)
    }

  }
}
