package com.arcusys.valamis.lrsEndpoint.service

import com.arcusys.valamis.lrsEndpoint.model.LrsEndpointSettings

/**
 * Created by igorborisov on 17.10.14.
 */
trait LrsEndpointService {

  def setTincanEndpoint(endpointSettings: LrsEndpointSettings): Unit

  def removeTincanEndpoint(): Unit

  def getTincanEndpoint(): Option[LrsEndpointSettings]

  def getInternalTincanEndpoint(): Option[LrsEndpointSettings]
}
