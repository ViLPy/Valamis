package com.arcusys.learn.liferay

import com.liferay.portlet.asset.model.BaseAssetRendererFactory
import com.arcusys.learn.scorm.manifest.model._
import com.liferay.portal.kernel.util.WebKeys
import com.liferay.portal.kernel.portlet.{LiferayPortletResponse, LiferayPortletRequest}
import com.liferay.portal.theme.ThemeDisplay
import com.liferay.portlet.PortletURLFactoryUtil
import javax.portlet.PortletRequest
import com.arcusys.learn.liferay.service.utils.PortletKeys
import com.liferay.portal.security.permission.PermissionChecker
import com.arcusys.learn.storage.impl.orbroker.StorageFactory
import service.SCORMPackageAssetRenderer

object SCORMPackageAssetRendererFactory {
  final val CLASS_NAME: String = classOf[Manifest].getName
  final val TYPE: String = "package"
}

class SCORMPackageAssetRendererFactory extends BaseAssetRendererFactory {
  def getAssetRenderer(classPK: Long, assetType: Int) = {
    val pkg = StorageFactory.packageStorage.getByRefID(classPK).getOrElse(throw new Exception("Can't find package with refID " + classPK))
    new SCORMPackageAssetRenderer(pkg)
  }

  def getClassName: String = SCORMPackageAssetRendererFactory.CLASS_NAME

  def getType: String = SCORMPackageAssetRendererFactory.TYPE

  override def getURLAdd(liferayPortletRequest: LiferayPortletRequest, liferayPortletResponse: LiferayPortletResponse) = {
    val request = liferayPortletRequest.getHttpServletRequest
    val themeDisplay = request.getAttribute(WebKeys.THEME_DISPLAY).asInstanceOf[ThemeDisplay]
    val portletURL = PortletURLFactoryUtil.create(request, PortletKeys.SCORM_PACKAGE_ADMIN, getControlPanelPlid(themeDisplay), PortletRequest.RENDER_PHASE)
    portletURL.setParameter("action", "add-new")
    portletURL
  }

  override def hasPermission(permissionChecker: PermissionChecker, classPK: Long, actionId: String): Boolean = true
}
