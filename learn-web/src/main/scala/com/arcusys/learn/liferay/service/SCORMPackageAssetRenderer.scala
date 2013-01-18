package com.arcusys.learn.liferay.service

import asset.AssetHelper
import com.liferay.portlet.asset.model.BaseAssetRenderer
import com.arcusys.learn.scorm.manifest.model._
import java.util.Locale
import com.liferay.portal.kernel.util.{StringPool, WebKeys, HtmlUtil}
import com.liferay.portal.kernel.portlet.{LiferayPortletResponse, LiferayPortletRequest}
import com.liferay.portal.util.PortalUtil
import javax.portlet.{RenderRequest, RenderResponse, PortletRequest}
import com.liferay.portal.theme.ThemeDisplay
import com.liferay.portal.security.permission.PermissionChecker
import utils.PortletKeys
import com.arcusys.learn.liferay.SCORMPackageAssetRendererFactory


class SCORMPackageAssetRenderer(pkg: Manifest) extends BaseAssetRenderer {
  def getAssetRendererFactoryClassName: String = SCORMPackageAssetRendererFactory.CLASS_NAME

  def getClassPK: Long = AssetHelper.getAssetFromManifest(pkg).getPrimaryKey

  def getGroupId: Long = AssetHelper.getAssetFromManifest(pkg).getGroupId

  def getSummary(locale: Locale): String = {
    HtmlUtil.stripHtml(AssetHelper.getAssetFromManifest(pkg).getSummary)
  }

  def getTitle(locale: Locale): String = AssetHelper.getAssetFromManifest(pkg).getTitle

  override def getURLEdit(liferayPortletRequest: LiferayPortletRequest, liferayPortletResponse: LiferayPortletResponse) = {
    val portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest), PortletKeys.SCORM_PACKAGE, PortletRequest.RENDER_PHASE)
    portletURL.setParameter("action", "edit")
    portletURL
  }

  override def getURLViewInContext(liferayPortletRequest: LiferayPortletRequest, liferayPortletResponse: LiferayPortletResponse, noSuchEntryRedirect: String): String = {
    val themeDisplay = liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY).asInstanceOf[ThemeDisplay]
    getPackageURL(themeDisplay.getPlid, AssetHelper.getAssetFromManifest(pkg).getPrimaryKey, themeDisplay.getPortalURL, maximized = false)
  }

  def getUserId: Long = AssetHelper.getAssetFromManifest(pkg).getUserId

  def getUserName: String = AssetHelper.getAssetFromManifest(pkg).getUserName

  def getUuid: String = ""

  override def hasEditPermission(permissionChecker: PermissionChecker): Boolean = {
    false
  }

  override def hasViewPermission(permissionChecker: PermissionChecker): Boolean = {
    true
  }

  override def isPrintable: Boolean = true

  def render(renderRequest: RenderRequest, renderResponse: RenderResponse, template: String): String = {
    // Also need hook for asset publisher
    null
  }

  private def getPackageURL(plid: Long, resourcePrimKey: Long, portalURL: String, maximized: Boolean) = {
    val sb: StringBuilder = new StringBuilder(11)
    sb.append(portalURL)
    sb.append(PortalUtil.getPathMain)
    sb.append("/portal/learn-web/open_package")
    sb.append(StringPool.QUESTION)
    sb.append("plid")
    sb.append(StringPool.EQUAL)
    sb.append(String.valueOf(plid))
    sb.append(StringPool.AMPERSAND)
    sb.append("resourcePrimKey")
    sb.append(StringPool.EQUAL)
    sb.append(String.valueOf(resourcePrimKey))

    sb.toString() + (if (maximized) {
      "&maximized=true"
    } else "")
  }
}
