package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object AdminActionType extends Enumeration {
  type AdminActionType = Value

  val RenewDatabase = Value("RENEWDATABASE")
  val UpdateIssuerSettings = Value("UPDATEISSUERSETTINGS")
  val UpdateEmailSettings = Value("UPDATEEMAILSETTINGS")
  val UpdateGoogleAPISettings = Value("UPDATEGOOGLEAPISETTINGS")

}