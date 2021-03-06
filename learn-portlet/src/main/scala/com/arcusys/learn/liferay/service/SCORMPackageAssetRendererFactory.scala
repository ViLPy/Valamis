package com.arcusys.learn.liferay.service

import javax.portlet.PortletRequest
import com.arcusys.valamis.lesson.scorm.model.manifest.Manifest
import com.arcusys.valamis.lesson.scorm.storage.ScormPackagesStorage
import utils.PortletKeys
import com.arcusys.learn.ioc.InjectableFactory
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.WebKeysHelper
import com.arcusys.learn.liferay.util.PortletURLFactoryUtilHelper

object SCORMPackageAssetRendererFactory {
  final val CLASS_NAME: String = classOf[Manifest].getName
  final val TYPE: String = "package"
}

// TODO remove repositoy using
class SCORMPackageAssetRendererFactory extends LBaseAssetRendererFactory with InjectableFactory {
  def getAssetRenderer(classPK: Long, assetType: Int) = {
    val pkg = inject[ScormPackagesStorage].getByRefID(classPK).getOrElse(throw new Exception("Can't find package with refID " + classPK))
    new SCORMPackageAssetRenderer(pkg)
  }

  def getClassName: String = SCORMPackageAssetRendererFactory.CLASS_NAME

  def getType: String = SCORMPackageAssetRendererFactory.TYPE

  override def getURLAdd(liferayPortletRequest: LLiferayPortletRequest, liferayPortletResponse: LLiferayPortletResponse) = {
    val request = liferayPortletRequest.getHttpServletRequest
    val themeDisplay = request.getAttribute(WebKeysHelper.THEME_DISPLAY).asInstanceOf[LThemeDisplay]
    val portletURL = PortletURLFactoryUtilHelper.create(request, PortletKeys.SCORM_PACKAGE_ADMIN, getControlPanelPlid(themeDisplay), PortletRequest.RENDER_PHASE)
    portletURL.setParameter("action", "add-new")
    portletURL
  }

  override def hasPermission(permissionChecker: LPermissionChecker, classPK: Long, actionId: String): Boolean = true
}
