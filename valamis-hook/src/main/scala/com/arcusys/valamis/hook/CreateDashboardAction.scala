package com.arcusys.valamis.hook

import com.liferay.portal.DuplicateGroupException
import com.liferay.portal.kernel.dao.orm.{RestrictionsFactoryUtil, QueryUtil}
import com.liferay.portal.kernel.events.SimpleAction
import com.liferay.portal.kernel.log.{Log, LogFactoryUtil}
import com.liferay.portal.model._
import com.liferay.portal.service._
import com.liferay.portal.service.permission.PortletPermissionUtil
import com.liferay.portal.util.PortalUtil
import scala.collection.JavaConverters._
import scala.collection.JavaConversions._

class CreateDashboardAction extends SimpleAction {
  private val _log: Log = LogFactoryUtil.getLog(classOf[CreateDashboardAction])

  override def run(companyIds: Array[String]): Unit = {
    _log.info("CREATE VALAMIS SITE WITH DASHBOARD")

    val defaultCompanyId = PortalUtil.getDefaultCompanyId
    val defaultUserId = UserLocalServiceUtil.getDefaultUserId(defaultCompanyId)

    try {
      val siteGroup = addSite(defaultUserId)

      val siteGroupId = siteGroup.getGroupId

      setupTheme(siteGroupId)

      setupDashboardPage(siteGroupId, defaultUserId)


      val allUsers = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS).asScala

      val roles = RoleLocalServiceUtil.getTypeRoles(RoleConstants.TYPE_SITE).asScala
      val memberRole = roles.filter(role => role.getName.equals(RoleConstants.SITE_MEMBER)).head

      val userIds = allUsers.map(user => user.getUserId).toArray
      UserGroupRoleLocalServiceUtil.addUserGroupRoles(userIds, siteGroupId, memberRole.getRoleId)

    } catch {
      case ex: DuplicateGroupException => _log.info("Valamis site already exists")
      case ex: Exception => _log.error(ex.getStackTraceString)
    }
  }

  def setupTheme(siteGroupId: Long): LayoutSet = {
    val valamisThemeName = "Valamis Theme"
    val valamisThemeId = "valamistheme_WAR_valamistheme"

    val layoutSetPrototypes = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS).asScala
      .filter(c => c.getName(c.getDefaultLanguageId).contains(valamisThemeName))

    for (layoutSetPrototype <- layoutSetPrototypes) {
      LayoutSetLocalServiceUtil
        .updateLayoutSetPrototypeLinkEnabled(siteGroupId, false, true, layoutSetPrototype.getUuid)

//      /* DO NOT REMOVE. Is used to tell liferay to REALLY UPDATE Layouts */
//      val query = LayoutLocalServiceUtil.dynamicQuery()
//        .add(RestrictionsFactoryUtil.eq("groupId", siteGroupId))
//        .add(RestrictionsFactoryUtil.eq("privateLayout", false))
//        .add(RestrictionsFactoryUtil.eq("parentLayoutId", LayoutConstants.DEFAULT_PARENT_LAYOUT_ID))
//      LayoutLocalServiceUtil.dynamicQuery(query)

      val newLayouts = LayoutLocalServiceUtil
        .getLayouts(siteGroupId, false, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID)
    }

    LayoutSetLocalServiceUtil
      .updateLookAndFeel(siteGroupId, false, valamisThemeId, "", "", false)

    LayoutSetLocalServiceUtil
      .updateLookAndFeel(siteGroupId, true, valamisThemeId, "", "", false)
  }

  private def addSite(userId: Long): Group = {
    val groupType = GroupConstants.TYPE_SITE_OPEN
    val parentGroupId = GroupConstants.DEFAULT_PARENT_GROUP_ID
    val liveGroupId = GroupConstants.DEFAULT_LIVE_GROUP_ID
    val membershipRestriction = GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION
    val siteTitle = "Valamis"
    val description = ""
    val manualMembership = true
    val siteUrl = "/valamis"
    val isSite = true
    val isActive = true

    val serviceContext: ServiceContext = new ServiceContext
    serviceContext.setAddGuestPermissions(true)


    val group = GroupLocalServiceUtil.addGroup(
      userId,
      parentGroupId,
      classOf[Group].getName,
      0, //classPK
      liveGroupId,
      siteTitle,
      description,
      groupType,
      manualMembership,
      membershipRestriction,
      siteUrl,
      isSite,
      isActive,
      serviceContext)

    group
  }

  private def setupDashboardPage(groupId: Long, userId: Long) {
    _log.info("Create dashboard page")

    val dashboardLayout = addLayout(groupId, userId, "Dashboard")

    try{
      removeLayout(groupId, false, "/home")
    }catch {
      case e:Throwable =>
    }

    val layoutTypePortlet = dashboardLayout.getLayoutType.asInstanceOf[LayoutTypePortlet]
    layoutTypePortlet.setLayoutTemplateId(userId, "valamisStudentDashboard")

    updateLayout(dashboardLayout)

    addPortletId(dashboardLayout, "ValamisStudySummary_WAR_learnportlet", "valamisStudySummary")
    addPortletId(dashboardLayout, "LearningPaths_WAR_learnportlet", "learningPaths")
    addPortletId(dashboardLayout, "MyLessons_WAR_learnportlet", "lessons")
    addPortletId(dashboardLayout, "RecentLessons_WAR_learnportlet", "recent")
    addPortletId(dashboardLayout, "AchievedCertificates_WAR_learnportlet", "achievedCertificates")
    addPortletId(dashboardLayout, "ValamisActivities_WAR_learnportlet", "valamisActivities")
  }

  private def removeLayout(groupId: Long, isPrivate: Boolean, friendlyUrl: String) = {
    val homeLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(groupId, isPrivate, friendlyUrl)
    LayoutLocalServiceUtil.deleteLayout(homeLayout)
  }

  private def addLayout(groupId: Long, userId: Long, name: String): Layout = {

    val serviceContext: ServiceContext = new ServiceContext
    serviceContext.setAddGuestPermissions(true)

    val parentLayout = LayoutConstants.DEFAULT_PARENT_LAYOUT_ID
    val title = ""
    val description = ""
    val layoutType = LayoutConstants.TYPE_PORTLET
    val friendlyURL = "/dashboard"
    val isPrivate = false


    LayoutLocalServiceUtil.addLayout(
      userId,
      groupId,
      isPrivate,
      parentLayout,
      name,
      title,
      description,
      layoutType,
      false, //hidden
      friendlyURL,
      serviceContext
    )

  }

  protected def addPortletId(layout: Layout, portletId: String, columnId: String) = {
    val layoutTypePortlet = layout.getLayoutType.asInstanceOf[LayoutTypePortlet]

    val newPortletId = layoutTypePortlet.addPortletId(0, portletId, columnId, -1, false)

    addResources(layout, newPortletId)
    updateLayout(layout)
    newPortletId
  }

  protected def addResources(layout: Layout, portletId: String) {
    val rootPortletId = PortletConstants.getRootPortletId(portletId)
    val portletPrimaryKey = PortletPermissionUtil.getPrimaryKey(layout.getPlid, portletId)

    ResourceLocalServiceUtil.addResources(
      layout.getCompanyId,
      layout.getGroupId,
      0, //userId
      rootPortletId, portletPrimaryKey, true, true, true)
  }

  protected def updateLayout(layout: Layout) {
    LayoutLocalServiceUtil.updateLayout(layout.getGroupId, layout.isPrivateLayout, layout.getLayoutId, layout.getTypeSettings)
  }
}