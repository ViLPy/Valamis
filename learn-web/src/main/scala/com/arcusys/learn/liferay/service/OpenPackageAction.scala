package com.arcusys.learn.liferay.service

import asset.AssetHelper
import com.liferay.portal.kernel.struts.{StrutsAction, BaseStrutsAction}
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import com.liferay.portal.theme.ThemeDisplay
import com.liferay.portal.kernel.util._
import javax.portlet.{WindowState, PortletMode, PortletRequest, PortletURL}
import com.liferay.portal.service.LayoutLocalServiceUtil
import com.liferay.portal.NoSuchLayoutException
import com.liferay.portal.model.{LayoutTypePortlet, LayoutConstants, PortletConstants}
import com.liferay.portlet.{PortletPreferencesFactoryUtil, PortletURLFactoryUtil}
import com.arcusys.learn.scorm.manifest.model._
import utils.PortletKeys
import com.liferay.portal.security.auth.AuthTokenUtil
import com.arcusys.learn.storage.impl.orbroker.StorageFactory

class OpenPackageAction extends BaseStrutsAction {
  lazy val packageStorage = StorageFactory.packageStorage

  override def execute(originalStrutsAction: StrutsAction, request: HttpServletRequest, response: HttpServletResponse): String = {
    val themeDisplay = request.getAttribute(WebKeys.THEME_DISPLAY).asInstanceOf[ThemeDisplay]
    val resourcePrimKey: Long = ParamUtil.getLong(request, "resourcePrimKey")
    val maximized: Boolean = ParamUtil.getBoolean(request, "maximized")
    val plid = if (isValidPlid(ParamUtil.getLong(request, "plid"))) {
      ParamUtil.getLong(request, "plid")
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
      packageStorage.getByRefID(resourcePrimKey).getOrElse(throw new Exception("Can't find package with refID " + resourcePrimKey)).id.toString)
    response.sendRedirect(portletURL.toString)
    null
  }

  protected def getDynamicPortletURL(plid: Long, request: HttpServletRequest) = {
    val portletId = PortletKeys.SCORM_PACKAGE_DEFAULT_INSTANCE
    val portletURL = getPackageURL(plid, portletId, request)
    if (_PORTLET_ADD_DEFAULT_RESOURCE_CHECK_ENABLED) {
      val token: String = AuthTokenUtil.getToken(request, plid, portletId)
      portletURL.setParameter("p_p_auth", token)
    }
    portletURL.setPortletMode(PortletMode.VIEW)
    portletURL.setWindowState(WindowState.MAXIMIZED)
    portletURL
  }

  protected def getSCORMPackage(resourcePrimKey: Long): Manifest = {
    try {
      packageStorage.getByRefID(resourcePrimKey).get
    } catch {
      case e => null
    }
  }

  protected def getPackageURL(plid: Long, privateLayout: Boolean, pkg: Manifest, request: HttpServletRequest): PortletURL = {
    var layouts = LayoutLocalServiceUtil.getLayouts(AssetHelper.getAssetFromManifest(pkg).getGroupId, privateLayout, LayoutConstants.TYPE_PORTLET)
    val selLayout = LayoutLocalServiceUtil.getLayout(plid)
    if ((selLayout.getGroupId == AssetHelper.getAssetFromManifest(pkg).getGroupId) && selLayout.isTypePortlet) {
      layouts = ListUtil.copy(layouts)
      layouts.remove(selLayout)
      layouts.add(0, selLayout)
    }
    import scala.collection.JavaConversions._
    for (layout <- layouts) {
      val layoutTypePortlet = layout.getLayoutType.asInstanceOf[LayoutTypePortlet]
      val portlets = layoutTypePortlet.getAllPortlets
      val portlet = portlets.find(portlet => {
        val rootPortletId = PortletConstants.getRootPortletId(portlet.getPortletId)
        if (rootPortletId == PortletKeys.SCORM_PACKAGE) {
          val preferences = PortletPreferencesFactoryUtil.getPortletSetup(layout, portlet.getPortletId, StringPool.BLANK)
          val resourcePrimKey: Long = GetterUtil.getLong(preferences.getValue("resourcePrimKey", null))
          try {
            packageStorage.getByRefID(resourcePrimKey).get
            true
          } catch {
            case e => {
              false
            }
          }
        } else false
      })
      if (portlet.isDefined) {
        val preferences = PortletPreferencesFactoryUtil.getPortletSetup(layout, portlet.get.getPortletId, StringPool.BLANK)
        val resourcePrimKey: Long = GetterUtil.getLong(preferences.getValue("resourcePrimKey", null))
        val selPkg = packageStorage.getByRefID(resourcePrimKey).get
        val rootResourcePrimKey: Long = AssetHelper.getAssetFromManifest(pkg).getPrimaryKey
        val selRootResourcePrimKey: Long = AssetHelper.getAssetFromManifest(selPkg).getPrimaryKey
        if (rootResourcePrimKey == selRootResourcePrimKey) {
          return getPackageURL(layout.getPlid, portlet.get.getPortletId, request)
        }
      }
    }
    null
  }

  protected def getPackageURL(plid: Long, portletId: String, request: HttpServletRequest): PortletURL = {
    val resourcePrimKey: Long = ParamUtil.getLong(request, "resourcePrimKey")
    val portletURL = PortletURLFactoryUtil.create(request, portletId, plid, PortletRequest.RENDER_PHASE)
    portletURL.setParameter("resourcePrimKey", String.valueOf(resourcePrimKey))
    portletURL.setPortletMode(PortletMode.VIEW)
    portletURL.setWindowState(WindowState.NORMAL)
    portletURL.setWindowState(WindowState.MAXIMIZED)
    portletURL
  }

  protected def isValidPlid(plid: Long): Boolean = {
    try {
      LayoutLocalServiceUtil.getLayout(plid)
    } catch {
      case e: NoSuchLayoutException => false
    }
    true
  }

  private final val _PORTLET_ADD_DEFAULT_RESOURCE_CHECK_ENABLED: Boolean = GetterUtil.getBoolean(PropsUtil.get(PropsKeys.PORTLET_ADD_DEFAULT_RESOURCE_CHECK_ENABLED))
}
