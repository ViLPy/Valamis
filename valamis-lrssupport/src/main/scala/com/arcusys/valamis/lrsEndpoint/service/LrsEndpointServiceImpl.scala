package com.arcusys.valamis.lrsEndpoint.service

import com.arcusys.valamis.lrsEndpoint.model.LrsEndpointSettings
import com.arcusys.valamis.lrsEndpoint.storage.LrsEndpointStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

// TODO refactor with lesson package
class LrsEndpointServiceImpl(implicit val bindingModule: BindingModule) extends LrsEndpointService with Injectable {
  private val tincanLrsEndpointRepository = inject[LrsEndpointStorage]

  override def setTincanEndpoint(endpointSettings: LrsEndpointSettings): Unit = {
    tincanLrsEndpointRepository.set(Some(endpointSettings))
  }

  override def removeTincanEndpoint(): Unit = {
    tincanLrsEndpointRepository.set(None)
  }

  override def getTincanEndpoint(): Option[LrsEndpointSettings] = {
    tincanLrsEndpointRepository.get
  }

  override def getInternalTincanEndpoint(): Option[LrsEndpointSettings] = {
    tincanLrsEndpointRepository.getDefault
  }
}
