package com.arcusys.learn.controllers.auth

import com.escalatesoft.subcut.inject.Injectable
import org.scalatra.auth.ScentrySupport
import org.scalatra.{ RequestResponseScope, ScalatraBase }

trait MobileAuthSupport extends ScentrySupport[AuthUser]
    with RequestResponseScope
    with Injectable
    with AuthSupport[AuthUser] { self: ScalatraBase =>

  protected val MOBILE_STRATEGY_NAME = "MobileAuth"

  protected def fromSession = { case id: String => AuthUser(id.toLong) }
  protected def toSession = { case usr: AuthUser => usr.id.toString }

  //TODO: make proper scentry strategy registration
  override protected def registerAuthStrategies = {
    scentry.register(
      MOBILE_STRATEGY_NAME,
      app => injectOptional[MobileAuthStrategy].getOrElse(new MobileCheckerAuthStrategy(app)))
  }
}
