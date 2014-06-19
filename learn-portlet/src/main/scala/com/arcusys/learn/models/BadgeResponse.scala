package com.arcusys.learn.models

/**
 * Created by Iliya Tryapitsin on 13.03.14.
 */
case class BadgeResponse(recipient: String,
  issued_on: String,
  badge: BadgeModel)

case class BadgeModel(name: String,
  image: String,
  description: String,
  criteria: String,
  issuer: IssuerModel,
  version: String = "1.0.0")

case class IssuerModel(origin: String,
  name: String,
  org: String,
  contact: String = "test@valamis.fi")
