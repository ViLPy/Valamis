package com.arcusys.learn.settings.model

/**
* A site which is part of certificate
* @param key             Unique settings key
* @param value  setting value
*/
case class Setting (
  id: Int,
  key: SettingType.Value,
  value: String
)

object SettingType extends Enumeration {
  type SettingType = Value
  val IssuerName = Value("IssuerName")
  val IssuerURL = Value("IssuerURL")
  val IssuerOrganization = Value("IssuerOrganization")
  val DBVersion = Value("DBVersion")
}
