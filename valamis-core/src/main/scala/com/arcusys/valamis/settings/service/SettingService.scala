package com.arcusys.valamis.settings.service

/**
 * Created by igorborisov on 17.10.14.
 */
trait SettingService {

  def setIssuerName(value: String): Unit

  def getIssuerName(): String

  def setIssuerOrganization(value: String): Unit

  def getIssuerOrganization(): String

  def setIssuerURL(value: String): Unit

  def getIssuerURL(): String

  def setIssuerEmail(value: String): Unit

  def getIssuerEmail(): String

  def setSendMessages(value: Boolean): Unit

  def getSendMessages(): Boolean

  def setGoogleClientId(value: String): Unit

  def getGoogleClientId(): String

  def setGoogleAppId(value: String): Unit

  def getGoogleAppId(): String

  def setGoogleApiKey(value: String): Unit

  def getGoogleApiKey(): String

  def setDBVersion(value: String): Unit
}
