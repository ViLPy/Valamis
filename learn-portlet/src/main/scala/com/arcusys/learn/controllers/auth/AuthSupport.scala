package com.arcusys.learn.controllers.auth

import com.escalatesoft.subcut.inject.Injectable
import org.scalatra.auth.{ ScentryConfig, ScentrySupport }
import org.scalatra.{ RequestResponseScope, ScalatraBase }

trait AuthSupport[T <: AuthUser] extends ScentrySupport[T]
    with RequestResponseScope
    with Injectable { self: ScalatraBase =>

  override protected val scentryConfig = new ScentryConfig {
    override val login = "/c/portal/login"
    override val returnTo = "/"
    override val returnToKey = "redirect"
    override val failureUrl = "/c/portal/logout"
  }.asInstanceOf[ScentryConfiguration]

}
