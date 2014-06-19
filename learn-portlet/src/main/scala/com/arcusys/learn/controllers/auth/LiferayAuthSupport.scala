package com.arcusys.learn.controllers.auth

import org.scalatra.auth.{ ScentryConfig, ScentrySupport }
import com.liferay.portal.model.User
import org.scalatra.ScalatraBase
import com.escalatesoft.subcut.inject.Injectable
import com.liferay.portal.service.UserLocalServiceUtil
import scala.util.Try

/**
 * Created by Iliya Tryapitsin on 04.04.2014.
 */
case class LiferayAuthUser(id: String)

trait LiferayAuthSupport extends ScentrySupport[LiferayAuthUser] with Injectable { self: ScalatraBase =>

  protected val LIFERAY_STRATEGY_NAME = "LiferayAuth"

  protected def fromSession = { case id: String => LiferayAuthUser(id) }
  protected def toSession = { case usr: LiferayAuthUser => usr.id }

  override protected def registerAuthStrategies = {
    scentry.register(LIFERAY_STRATEGY_NAME, app => injectOptional[LiferayAuthStrategy] getOrElse { new LiferayCheckerAuthStrategy(app) })
  }

  override protected val scentryConfig = new ScentryConfig {
    override val login = "/c/portal/login"
    override val returnTo = "/"
    override val returnToKey = "redirect"
    override val failureUrl = "/c/portal/logout"
  }.asInstanceOf[ScentryConfiguration]
}