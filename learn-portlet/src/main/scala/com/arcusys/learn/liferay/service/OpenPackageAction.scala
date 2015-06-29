package com.arcusys.learn.liferay.service

import javax.servlet.http.{ HttpServletResponse, HttpServletRequest }
import javax.portlet.{ WindowState, PortletMode, PortletRequest, PortletURL }
import com.arcusys.valamis.lesson.scorm.model.manifest
import com.arcusys.valamis.lesson.scorm.model.manifest.Manifest
import com.arcusys.valamis.lesson.scorm.storage.ScormPackagesStorage
import utils.PortletKeys
import com.arcusys.learn.ioc.InjectableFactory
import com.arcusys.learn.liferay.services.{ AssetEntryLocalServiceHelper, LayoutLocalServiceHelper }
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.util._
import com.arcusys.learn.liferay.constants._

// TODO remove repository using
class OpenPackageAction extends LBaseStrutsAction with InjectableFactory {
  lazy val packageRepository = inject[ScormPackagesStorage]

  override def execute(originalStrutsAction: LStrutsAction, request: HttpServletRequest, response: HttpServletResponse): String = {
    val themeDisplay = request.getAttribute(WebKeysHelper.THEME_DISPLAY).asInstanceOf[LThemeDisplay]
    val resourcePrimKey: Long = ParamUtilHelper.getLong(request, "resourcePrimKey")
    val maximized: Boolean = ParamUtilHelper.getBoolean(request, "maximized")
    val plid = if (isValidPlid(ParamUtilHelper.getLong(request, "plid"))) {
      ParamUtilHelper.getLong(request, "plid")
    } else themeDisplay.getPlid

    var portletURL: PortletURL = null
    val pkg = getSCORMPackage(resourcePrimKey)
    if (pkg == null) {
      portletURL = getDynamicPortletURL(plid, request)
    }
    if (portletURL == null) {
      portletURL = getPackageURL(plid, false, pkg, request)
    }
    if (portletURL == null) {
      portletURL = getPackageURL(plid, true, pkg, request)
    }
    if (portletURL == null) {
      portletURL = getDynamicPortletURL(plid, request)
    }
    if (maximized) {
      portletURL.setWindowState(WindowState.MAXIMIZED)
      portletURL.setPortletMode(PortletMode.VIEW)
    }
    portletURL.setParameter("entryID",
      packageRepository.getByRefID(resourcePrimKey).getOrElse(throw new Exception("Can't find package with refID " + resourcePrimKey)).id.toString)
    response.sendRedirect(portletURL.toString)
    null
  }

  protected def getDynamicPortletURL(plid: Long, request: HttpServletRequest) = {
    val portletId = PortletKeys.SCORM_PACKAGE_DEFAULT_INSTANCE
    val portletURL = getPackageURL(plid, portletId, request)
    if (_PORTLET_ADD_DEFAULT_RESOURCE_CHECK_ENABLED) {
      val token: String = AuthTokenUtilHelper.getToken(request, plid, portletId)
      portletURL.setParameter("p_p_auth", token)
    }
    portletURL.setPortletMode(PortletMode.VIEW)
    portletURL.setWindowState(WindowState.MAXIMIZED)
    portletURL
  }

  protected def getSCORMPackage(resourcePrimKey: Long): manifest.Manifest = {
    try {
      packageRepository.getByRefID(resourcePrimKey).get
    } catch {
      case e: Exception => null
    }
  }

  protected def getPackageURL(plid: Long, privateLayout: Boolean, pkg: Manifest, request: HttpServletRequest): PortletURL = {
    if (!pkg.assetRefId.isDefined)
      return null
    val assetEntry = AssetEntryLocalServiceHelper.getAssetEntry(pkg.assetRefId.get)
    var layouts = LayoutLocalServiceHelper.getLayouts(assetEntry.getGroupId, privateLayout, LayoutConstantsHelper.TYPE_PORTLET)
    val selLayout = LayoutLocalServiceHelper.getLayout(plid)
    if ((selLayout.getGroupId == assetEntry.getGroupId) && selLayout.isTypePortlet) {
      layouts = ListUtilHelper.copy(layouts)
      layouts.remove(selLayout)
      layouts.add(0, selLayout)
    }
    import scala.collection.JavaConversions._
    for (layout <- layouts) {
      val layoutTypePortlet = layout.getLayoutType.asInstanceOf[LLayoutTypePortlet]
      val portlets = layoutTypePortlet.getAllPortlets
      val portlet = portlets.find(portlet => {
        val rootPortletId = PortletConstantsHelper.getRootPortletId(portlet.getPortletId)
        if (rootPortletId == PortletKeys.SCORM_PACKAGE) {
          val preferences = PortletPreferencesFactoryUtilHelper.getPortletSetup(layout, portlet.getPortletId, StringPoolHelper.BLANK)
          val resourcePrimKey: Long = GetterUtilHelper.getLong(preferences.getValue("resourcePrimKey", null))
          try {
            packageRepository.getByRefID(resourcePrimKey).get
            true
          } catch {
            case _: Exception => false
          }
        } else false
      })
      if (portlet.isDefined) {
        val preferences = PortletPreferencesFactoryUtilHelper.getPortletSetup(layout, portlet.get.getPortletId, StringPoolHelper.BLANK)
        val resourcePrimKey: Long = GetterUtilHelper.getLong(preferences.getValue("resourcePrimKey", null))
        val selPkg = packageRepository.getByRefID(resourcePrimKey).get
        val selAssetEntry = AssetEntryLocalServiceHelper.getAssetEntry(selPkg.assetRefId.get)
        val rootResourcePrimKey: Long = assetEntry.getPrimaryKey
        val selRootResourcePrimKey: Long = selAssetEntry.getPrimaryKey
        if (rootResourcePrimKey == selRootResourcePrimKey) {
          return getPackageURL(layout.getPlid, portlet.get.getPortletId, request)
        }
      }
    }
    null
  }

  protected def getPackageURL(plid: Long, portletId: String, request: HttpServletRequest): PortletURL = {
    val resourcePrimKey: Long = ParamUtilHelper.getLong(request, "resourcePrimKey")
    val portletURL = PortletURLFactoryUtilHelper.create(request, portletId, plid, PortletRequest.RENDER_PHASE)
    portletURL.setParameter("resourcePrimKey", String.valueOf(resourcePrimKey))
    portletURL.setPortletMode(PortletMode.VIEW)
    portletURL.setWindowState(WindowState.NORMAL)
    portletURL.setWindowState(WindowState.MAXIMIZED)
    portletURL
  }

  protected def isValidPlid(plid: Long): Boolean = {
    try {
      LayoutLocalServiceHelper.getLayout(plid)
    } catch {
      case e: LNoSuchLayoutException => false
    }
    true
  }

  private final val _PORTLET_ADD_DEFAULT_RESOURCE_CHECK_ENABLED: Boolean = GetterUtilHelper.getBoolean(PropsUtilHelper.get(PropsKeysHelper.PORTLET_ADD_DEFAULT_RESOURCE_CHECK_ENABLED))
}
