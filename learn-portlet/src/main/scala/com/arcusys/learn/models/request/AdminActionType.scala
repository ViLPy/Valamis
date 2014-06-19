package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object AdminActionType extends Enumeration {
  type AdminActionType = Value

  val RENEW_DATABASE = Value("RENEWDATABASE")
  val UPDATE_ISSUER_SETTINGS = Value("UPDATEISSUERSETTINGS")
}