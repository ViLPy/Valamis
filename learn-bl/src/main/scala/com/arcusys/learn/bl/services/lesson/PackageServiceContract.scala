package com.arcusys.learn.bl.services.lesson

import com.arcusys.learn.scorm.manifest.model.Manifest
import com.arcusys.learn.tincan.model.lrsClient.LrsEndpointSettings
import com.liferay.portal.model.User

/**
 * Created by igorborisov on 17.10.14.
 */
trait PackageServiceContract {

  def getTincanLaunchWithLimitTest(packageId: Int, user: User): String

  def getScormManifest(packageId: Int): Manifest

  def setTincanEndpoint(endpointSettings: LrsEndpointSettings): Unit

  def removeTincanEndpoint(): Unit

  def getTincanEndpoint(): Option[LrsEndpointSettings]
}
