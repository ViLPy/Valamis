package com.arcusys.learn.controllers.auth

import com.escalatesoft.subcut.inject.Injectable
import org.scalatra.ScalatraBase
import org.scalatra.auth.{ ScentryConfig, ScentrySupport }
import org.scalatra.auth.strategy.BasicAuthSupport
import com.liferay.portal.model.User

/**
 * Created by igorborisov on 31.10.14.
 */
//case class LiferayAuthUser(id: Long, user: User = null)

trait LiferayBasicAuthSupport extends ScentrySupport[LiferayAuthUser] with BasicAuthSupport[LiferayAuthUser] with Injectable {
  self: ScalatraBase =>

  protected val LIFERAY_BASIC_STRATEGY_NAME = "LiferayBasicAuth"
  val realm = LIFERAY_BASIC_STRATEGY_NAME

  protected override def fromSession = { case id: String => LiferayAuthUser(id.toLong) }
  protected override def toSession = { case usr: LiferayAuthUser => usr.id.toString }

  protected val scentryConfig = (new ScentryConfig {}).asInstanceOf[ScentryConfiguration]

  override protected def configureScentry = {
    scentry.unauthenticated {
      scentry.strategies("Basic").unauthenticated()
    }
  }

  override protected def registerAuthStrategies = {
    scentry.register(
      LIFERAY_BASIC_STRATEGY_NAME,
      app => injectOptional[LiferayBasicAuthStrategy[LiferayAuthUser]].getOrElse(new LiferayCheckerBasicAuthStrategy(app, realm)))
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
