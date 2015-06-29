package com.arcusys.valamis.lrsEndpoint.model

import com.arcusys.valamis.lrsEndpoint.model.AuthorizationType.AuthorizationType

/**
 * Created by Iliya Tryapitsin on 24.02.14.
 */
object AuthorizationType extends Enumeration {
  val BASIC = Value("BASIC")
  val OAUTH = Value("OAUTH")

  type AuthorizationType = Value
}

object AuthorizationTypeConverters {
  implicit def fromString(authType: String): AuthorizationType = {
    return AuthorizationType.withName(authType.toUpperCase)
  }
}
