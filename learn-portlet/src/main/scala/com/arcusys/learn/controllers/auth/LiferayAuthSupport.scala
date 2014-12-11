package com.arcusys.learn.controllers.auth

import com.arcusys.scorm.lms.UserManagement
import com.liferay.portal.service.RoleServiceUtil
import org.scalatra.auth.{ ScentryConfig, ScentrySupport }
import org.scalatra.{ RequestResponseScope, ScalatraBase }
import com.escalatesoft.subcut.inject.Injectable
import com.arcusys.learn.exceptions.{ NotAuthorizedException, AccessDeniedException }
import com.liferay.portal.model.User

/**
 * Created by Iliya Tryapitsin on 04.04.2014.
 */
case class LiferayAuthUser(id: Long, user: User = null)

trait LiferayAuthSupport extends ScentrySupport[LiferayAuthUser] with RequestResponseScope with Injectable { self: ScalatraBase =>

  protected val LIFERAY_STRATEGY_NAME = "LiferayAuth"

  protected def fromSession = { case id: String => LiferayAuthUser(id.toLong) }
  protected def toSession = { case usr: LiferayAuthUser => usr.id.toString }

  override protected def registerAuthStrategies = {
    scentry.register(
      LIFERAY_STRATEGY_NAME,
      app => injectOptional[LiferayAuthStrategy].getOrElse(new LiferayCheckerAuthStrategy(app)))
  }

  def requireLogin() = {
    if (!isAuthenticated)
      throw new NotAuthorizedException
  }

  def requireAdmin() = {
    if (!isAdmin)
      throw new AccessDeniedException
  }

  def isAdmin: Boolean = {
    (RoleServiceUtil.hasUserRole(getUserId, getCompanyId, "Administrator", true)
      || RoleServiceUtil.hasUserRole(getUserId, getCompanyId, "Organization Administrator", true)
      || RoleServiceUtil.hasUserRole(getUserId, getCompanyId, "Site Administrator", true))
  }

  def isTeacher: Boolean = {
    val userManagement = injectOptional[UserManagement].getOrElse(new UserManagement)
    userManagement.hasTeacherPermissions(getUserId, getCourseId)
  }

  def requireTeacherPermissions() = {
    if (!isTeacher)
      throw new AccessDeniedException
  }

  def requireCurrentLoggedInUser(userID: Int) = {
    if (getUserId != userID)
      throw new AccessDeniedException
  }

  def getUserId = {
    try {
      scentry.user.id
    } catch {
      case e: Exception => -1.toLong
    }
  }

  def getLiferayUser = {
    scentry.user.user
  }

  def getCompanyId = {
    try {
      scentry.user.user.getCompanyId
    } catch {
      case e: Exception => -1.toLong
    }
  }

  def getCourseId = {
    try {
      request.getParameter("courseID").toLong
      //      scentry.user.user.getGroupId
    } catch {
      case e: Exception => -1.toLong
    }
  }

  override protected val scentryConfig = new ScentryConfig {
    override val login = "/c/portal/login"
    override val returnTo = "/"
    override val returnToKey = "redirect"
    override val failureUrl = "/c/portal/logout"
  }.asInstanceOf[ScentryConfiguration]
}