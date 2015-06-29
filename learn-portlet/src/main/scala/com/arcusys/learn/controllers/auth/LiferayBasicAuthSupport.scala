package com.arcusys.learn.controllers.auth

import com.escalatesoft.subcut.inject.Injectable
import org.scalatra.ScalatraBase
import org.scalatra.auth.ScentryConfig
import org.scalatra.auth.strategy.BasicAuthSupport

/**
 * Created by igorborisov on 31.10.14.
 */
//case class AuthUser(id: Long, user: User = null)

trait LiferayBasicAuthSupport extends LiferayAuthSupport with BasicAuthSupport[AuthUser] with Injectable {
  self: ScalatraBase =>

  protected val LIFERAY_BASIC_STRATEGY_NAME = "LiferayBasicAuth"
  val realm = LIFERAY_BASIC_STRATEGY_NAME

  protected override val scentryConfig = new ScentryConfig {}.asInstanceOf[ScentryConfiguration]

  override protected def configureScentry = {
    scentry.unauthenticated {
      scentry.strategies("Basic").unauthenticated()
    }
  }

  override protected def registerAuthStrategies = {
    scentry.register(
      LIFERAY_BASIC_STRATEGY_NAME,
      app => injectOptional[LiferayBasicAuthStrategy[AuthUser]].getOrElse(new LiferayCheckerBasicAuthStrategy(app, realm)))
  }

  def getLiferayUser = {
    scentry.user.user
  }

  def getUserId = {
    try {
      scentry.user.id
    } catch {
      case e: Exception => -1.toLong
    }
  }

  def getCompanyId = {
    try {
      scentry.user.user.getCompanyId
    } catch {
      case e: Exception => -1.toLong
    }
  }
}
