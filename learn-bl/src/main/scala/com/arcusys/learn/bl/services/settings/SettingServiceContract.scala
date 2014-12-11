package com.arcusys.learn.bl.services.settings

/**
 * Created by igorborisov on 17.10.14.
 */
trait SettingServiceContract {

  def setIssuerName(value: String): Unit

  def getIssuerName(): String

  def setIssuerOrganization(value: String): Unit

  def getIssuerOrganization(): String

  def setIssuerURL(value: String): Unit

  def getIssuerURL(): String

  def setSendMessages(value: Boolean): Unit

  def getSendMessages(): Boolean

  def setDBVersion(value: String): Unit
}
