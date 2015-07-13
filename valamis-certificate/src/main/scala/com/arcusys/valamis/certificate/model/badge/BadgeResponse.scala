package com.arcusys.valamis.certificate.model.badge

//Specs: https://github.com/mozilla/openbadges-specification/blob/master/Assertion/latest.md
case class BadgeResponse(
  uid: String,
  recipient: IdentityModel,
  badge: String,    //URL
  verify: VerificationModel,
  issuedOn: String)

case class IdentityModel(
  identity: String,
  `type`: String = "email",
  hashed: Boolean = true
)

case class VerificationModel(
  `type`: String = "hosted",
  url: String //To self
)

case class BadgeModel(
  name: String,
  description: String,
  image: String,
  criteria: String,
  issuer: String) //URL

case class IssuerModel(
  name: String,
  url: String,
  email: String = "issuer@valamis.com")
