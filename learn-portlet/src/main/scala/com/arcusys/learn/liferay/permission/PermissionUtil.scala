package com.arcusys.learn.liferay.permission

import com.arcusys.learn.exceptions.{ NotAuthorizedException, AccessDeniedException }
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.services.{ResourceActionLocalServiceHelper, PermissionHelper}
import com.liferay.portal.NoSuchResourceActionException
import com.liferay.portal.kernel.portlet.LiferayPortletSession
import com.liferay.portal.model.Layout
import com.liferay.portal.security.permission.PermissionChecker
import com.liferay.portal.service.{ LayoutLocalServiceUtil, ServiceContextThreadLocal, UserLocalServiceUtil }
import com.liferay.portal.util.LayoutTypePortletFactoryUtil
import org.slf4j.LoggerFactory

import scala.collection.JavaConverters._

case class PermissionCredentials(groupId: Long, portletId: String, primaryKey: String)

sealed abstract class PermissionBase(val name: String)

object ViewPermission extends PermissionBase("VIEW")

object ExportPermission extends PermissionBase("EXPORT")

object UploadPermission extends PermissionBase("UPLOAD")

object ModifyPermission extends PermissionBase("MODIFY_ACTION")

object SharePermission extends PermissionBase("SHARE_ACTION")

object PublishPermission extends PermissionBase("PUBLISH")

object SetVisiblePermission extends PermissionBase("SET_VISIBLE")

object SetDefaultPermission extends PermissionBase("SET_DEFAULT")

object ViewAllPermission extends PermissionBase("VIEW_ALL")

case class Permission(permission: PermissionBase, portlets: Seq[PortletName])

object PermissionUtil {

  val logger = LoggerFactory.getLogger(PermissionUtil.getClass)

  def requireCurrentLoggedInUser(userID: Int) = {
    if (getUserId != userID)
      throw AccessDeniedException()
  }

  def getUserId: Long = ServiceContextThreadLocal.getServiceContext.getUserId

  def getCompanyId: Long = PermissionHelper.getPermissionChecker().getCompanyId

  def requireLogin() = {
    if (!isAuthenticated)
      throw new NotAuthorizedException
  }

  def getLiferayUser = UserLocalServiceUtil.fetchUser(PermissionHelper.getPermissionChecker().getUserId)

  def isAuthenticated: Boolean = PermissionHelper.getPermissionChecker().isSignedIn

  def hasPermissionApi(permission: PermissionBase, portlets: PortletName*): Boolean = {
    hasPermissionApiSeq(PermissionHelper.getPermissionChecker(), permission, portlets)
  }

  def hasPermissionApi(user: LUser, permission: PermissionBase, portlets: PortletName*): Boolean = {
    hasPermissionApiSeq(PermissionHelper.getPermissionChecker(user), permission, portlets)
  }

  def requirePermissionApi(permission: PermissionBase, portlets: PortletName*) = {
    if (!hasPermissionApiSeq(PermissionHelper.getPermissionChecker(), permission, portlets)) {
      throw AccessDeniedException(permission.name + " required on " + portlets)
    }
  }

  def requirePermissionApi(permissions: Permission*): Unit = {
    if (!permissions.foldLeft(false) { (acc, permission) =>
      acc || hasPermissionApiSeq(PermissionHelper.getPermissionChecker(), permission.permission, permission.portlets)
    }) throw AccessDeniedException("You don't have required permissions")
  }

  def requirePermissionApi(user: LUser, permission: PermissionBase, portlets: PortletName*) = {
    if (!hasPermissionApiSeq(PermissionHelper.getPermissionChecker(user), permission, portlets)) {
      throw AccessDeniedException(permission.name + " required on " + portlets)
    }
  }

  private def hasPermissionApiSeq(checker: PermissionChecker, permission: PermissionBase, portlets: Seq[PortletName]): Boolean = {
    val keys = portlets.map(_.key)
    val courseId = getCourseId

    lazy val privateLayouts = LayoutLocalServiceUtil.getLayouts(courseId, true).asScala
    lazy val publicLayouts = LayoutLocalServiceUtil.getLayouts(courseId, false).asScala

    checker.isGroupAdmin(courseId) ||
      check(checker, permission, keys, privateLayouts) ||
      check(checker, permission, keys, publicLayouts)
  }

  private def check(checker: PermissionChecker, permission: PermissionBase, keys: Seq[String], allLayouts: Seq[Layout]): Boolean = {
    for (
      l <- allLayouts;
      plid = l.getPlid;
      portletId <- LayoutTypePortletFactoryUtil.create(l).getPortletIds.asScala
    ) {
      if (keys.contains(portletId)) {
        val primaryKey = plid + LiferayPortletSession.LAYOUT_SEPARATOR + portletId
        if (hasPermission(checker, l.getGroupId, portletId, primaryKey, permission)) {
          return true
        }
      }
    }
    false
  }

  def hasPermission(groupId: Long, portletId: String, primaryKey: String, action: PermissionBase): Boolean = {
    hasPermission(PermissionHelper.getPermissionChecker(), groupId, portletId, primaryKey, action)
  }

  def hasPermission(checker: PermissionChecker, groupId: Long, portletId: String, primaryKey: String, action: PermissionBase): Boolean = {
    try {
      ResourceActionLocalServiceHelper.getResourceAction(portletId, action.name)
    } catch {
      case _: NoSuchResourceActionException => return false
    }
    checker.hasPermission(groupId, portletId, primaryKey, action.name)
  }

  def getCourseId = {
    val context = ServiceContextThreadLocal.getServiceContext
    val request = context.getRequest
    val courseId = request.getParameter("courseId")
    Option(courseId).getOrElse(throw AccessDeniedException("courseId empty")).toLong
  }

}

