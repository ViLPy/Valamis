package com.arcusys.learn.bl.services.settings

/**
 * Created by igorborisov on 17.10.14.
 */
trait SiteDependentSettingManagerContract {

  def setSetting(siteId: Int, name: String, value: Option[String]): Unit

  def getSetting(siteId: Int, name: String): Option[String]
}
