package com.arcusys.learn.liferay.service

import asset.AssetHelper
import com.arcusys.learn.scorm.manifest.model._
import java.util.Locale
import javax.portlet.{RenderRequest, RenderResponse, PortletRequest}
import utils.PortletKeys
import com.arcusys.learn.liferay.util.{HtmlUtilHelper, PortalUtilHelper}
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.{WebKeysHelper, StringPoolHelper}


class SCORMPackageAssetRenderer(pkg: Manifest) extends LBaseAssetRenderer {
  lazy val assetHelper = new AssetHelper()

  def getAssetRendererFactoryClassName: String = SCORMPackageAssetRendererFactory.CLASS_NAME

  def getClassPK: Long = assetHelper.getAssetFromManifest(pkg).getPrimaryKey

  def getGroupId: Long = assetHelper.getAssetFromManifest(pkg).getGroupId

  def getSummary(locale: Locale): String = {
    HtmlUtilHelper.stripHtml(assetHelper.getAssetFromManifest(pkg).getSummary)
  }

  def getTitle(locale: Locale): String = assetHelper.getAssetFromManifest(pkg).getTitle

  override def getURLEdit(liferayPortletRequest: LLiferayPortletRequest, liferayPortletResponse: LLiferayPortletResponse) = {
    val portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest), PortletKeys.SCORM_PACKAGE, PortletRequest.RENDER_PHASE)
    portletURL.setParameter("action", "edit")
    portletURL
  }

  override def getURLViewInContext(liferayPortletRequest: LLiferayPortletRequest, liferayPortletResponse: LLiferayPortletResponse, noSuchEntryRedirect: String): String = {
    val themeDisplay = liferayPortletRequest.getAttribute(WebKeysHelper.THEME_DISPLAY).asInstanceOf[LThemeDisplay]
    getPackageURL(themeDisplay.getPlid, assetHelper.getAssetFromManifest(pkg).getPrimaryKey, themeDisplay.getPortalURL, maximized = false)
  }

  def getUserId: Long = assetHelper.getAssetFromManifest(pkg).getUserId

  def getUserName: String = assetHelper.getAssetFromManifest(pkg).getUserName

  def getUuid: String = ""

  override def hasEditPermission(permissionChecker: LPermissionChecker): Boolean = {
    false
  }

  override def hasViewPermission(permissionChecker: LPermissionChecker): Boolean = {
    true
  }

  override def isPrintable: Boolean = true

  def render(renderRequest: RenderRequest, renderResponse: RenderResponse, template: String): String = {
    // Also need hook for asset publisher
    System.out.println(">>>> Oops! Return NULL")
    null
  }

  private def getPackageURL(plid: Long, resourcePrimKey: Long, portalURL: String, maximized: Boolean) = {
    val sb: StringBuilder = new StringBuilder(11)
    sb.append(portalURL)
    sb.append(PortalUtilHelper.getPathMain)
    sb.append("/portal/learn-portlet/open_package")
    sb.append(StringPoolHelper.QUESTION)
    sb.append("plid")
    sb.append(StringPoolHelper.EQUAL)
    sb.append(String.valueOf(plid))
    sb.append(StringPoolHelper.AMPERSAND)
    sb.append("resourcePrimKey")
    sb.append(StringPoolHelper.EQUAL)
    sb.append(String.valueOf(resourcePrimKey))

    sb.toString() + (if (maximized) {
      "&maximized=true"
    } else "")
  }

  def getClassName = SCORMPackageAssetRendererFactory.CLASS_NAME

}
