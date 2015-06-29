package com.arcusys.valamis.settings.service

/**
 * Created by igorborisov on 17.10.14.
 */
trait SiteDependentSettingService {

  def setSetting(siteId: Int, name: String, value: Option[String]): Unit

  def getSetting(siteId: Int, name: String): Option[String]
}
