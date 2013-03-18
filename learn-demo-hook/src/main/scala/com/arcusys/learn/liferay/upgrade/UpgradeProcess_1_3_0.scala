package com.arcusys.learn.liferay.upgrade

import com.liferay.portal.kernel.upgrade.UpgradeProcess
import com.liferay.portal.service._
import permission.PortletPermissionUtil
import scala.collection.JavaConversions._
import com.liferay.portal.model._
import com.liferay.portal.kernel.util._
import com.liferay.portal.util.{PortletKeys, PortalUtil}
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil
import com.liferay.portal.kernel.workflow.WorkflowConstants
import com.liferay.portlet.journal.model.{JournalArticle, JournalArticleConstants}
import java.util.{Calendar, Locale}
import com.liferay.portlet.PortletPreferencesFactoryUtil
import com.liferay.portlet.documentlibrary.service.{DLAppServiceUtil, DLFolderLocalServiceUtil}
import com.liferay.portlet.messageboards.service.{MBMessageLocalServiceUtil, MBCategoryLocalServiceUtil}
import java.io.InputStream
import java.util
import com.liferay.portal.NoSuchOrganizationException


class UpgradeProcess_1_3_0 extends UpgradeProcess {
  override def getThreshold = 130

  override def doUpgrade() {
    val companyId = PortalUtil.getDefaultCompanyId
    val defaultUserId = UserLocalServiceUtil.getDefaultUserId(companyId)

    val companies = CompanyLocalServiceUtil.getCompanies
    for (company <- companies) {
      val companyID = company.getCompanyId
      val userID = UserLocalServiceUtil.getDefaultUserId(companyID)
      if (!RoleLocalServiceUtil.getRoles(companyID).exists(_.getName.equalsIgnoreCase("teacher"))) RoleLocalServiceUtil.addRole(userID, companyID, "Teacher", null, null, RoleConstants.TYPE_SITE)
      if (!RoleLocalServiceUtil.getRoles(companyID).exists(_.getName.equalsIgnoreCase("student"))) RoleLocalServiceUtil.addRole(userID, companyID, "Student", null, null, RoleConstants.TYPE_SITE)
    }

    try {
      OrganizationLocalServiceUtil.getOrganization(companyId, "Project Learn")
    } catch {
      case e: NoSuchOrganizationException => {
        System.out.println(">>> Upgrading to version 1.3.0")
        setupOrganizations(companyId, defaultUserId)
      }
      case _ => System.out.println(">>> Hook already installed")
    }
  }

  def setupOrganizations(companyId: Long, defaultUserId: Long) {
    val userId = defaultUserId
    val parentOrganizationId = OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID
    val name = "Project Learn"
    val organizationType = OrganizationConstants.TYPE_REGULAR_ORGANIZATION
    val recursable = true
    val regionId = 0
    val countryId = 0
    val statusId = GetterUtil.getInteger(PropsUtil.get("sql.data.com.liferay.portal.model.ListType.organization.status"))
    val comments = null

    val serviceContext: ServiceContext = new ServiceContext

    serviceContext.setAddGroupPermissions(true)
    serviceContext.setAddGuestPermissions(true)

    val organization = OrganizationLocalServiceUtil.addOrganization(userId, parentOrganizationId, name, organizationType, recursable, regionId, countryId, statusId, comments, true, serviceContext)

    // Group
    val group = organization.getGroup
    GroupLocalServiceUtil.updateFriendlyURL(group.getGroupId, "/learn-demo-hook")
    serviceContext.setScopeGroupId(group.getGroupId)

    // Layout set theme
    LayoutSetLocalServiceUtil.updateLookAndFeel(group.getGroupId, false, "projectlearn61theme_WAR_projectlearn61theme", "", "", false)

    // Home layout
    val layoutTheory = addLayout(group, "Theory", false, "/home", "2_columns_ii")
    addPortletId(layoutTheory, "SCORMApplication_WAR_learnweb", "column-2")
    val portletTheory = addPortletId(layoutTheory, PortletKeys.JOURNAL_CONTENT, "column-1")
    removePortletBorder(layoutTheory, portletTheory)
    val journalArticle = addJournalArticle(defaultUserId, group.getGroupId, "Introduction", "/articles/introduction.xml", serviceContext)
    configureJournalContent(layoutTheory, group, portletTheory, journalArticle.getArticleId)

    val layoutExams = addLayout(group, "Exams", false, "/exams", "2_columns_ii")
    addPortletId(layoutExams, "SCORMApplication_WAR_learnweb", "column-2")
    val portletExams = addPortletId(layoutExams, PortletKeys.JOURNAL_CONTENT, "column-1")
    removePortletBorder(layoutExams, portletExams)
    val journalArticleExams = addJournalArticle(defaultUserId, group.getGroupId, "Exams", "/articles/exams.xml", serviceContext)
    configureJournalContent(layoutExams, group, portletExams, journalArticleExams.getArticleId)

    val layoutTools = addLayout(group, "Tools", false, "/tools", "2_columns_ii")
    val portletTools = addPortletId(layoutTools, PortletKeys.JOURNAL_CONTENT, "column-1")
    removePortletBorder(layoutTools, portletTools)
    addPortletId(layoutTools, "SCORMQuestionBank_WAR_learnweb", "column-2")
    addPortletId(layoutTools, "SCORMQuizes_WAR_learnweb", "column-2")
    addPortletId(layoutTools, "Gradebook_WAR_learnweb", "column-2")
    val journalArticleTools = addJournalArticle(defaultUserId, group.getGroupId, "Tools", "/articles/tools.xml", serviceContext)
    configureJournalContent(layoutTools, group, portletTools, journalArticleTools.getArticleId)
  }

  private def addUser(companyId: Long, screenName: String, firstName: String, lastName: String, male: Boolean,
                      jobTitle: String, roleIds: Array[Long]) = {

    val creatorUserId = 0
    val autoPassword = false
    val password1 = screenName
    val password2 = password1
    val autoScreenName = false
    val emailAddress = screenName + "@learn.fi"
    val facebookId = 0
    val openId = StringPool.BLANK
    val locale = Locale.US
    val middleName = StringPool.BLANK
    val prefixId = 0
    val suffixId = 0
    val birthdayMonth = Calendar.JANUARY
    val birthdayDay = 1
    val birthdayYear = 1970

    val guestGroup = GroupLocalServiceUtil.getGroup(companyId, GroupConstants.GUEST)

    val groupIds = Array(guestGroup.getGroupId)

    val sevenCogsOrganization = OrganizationLocalServiceUtil.getOrganization(companyId, "Project Learn")

    val organizationIds = Array(sevenCogsOrganization.getOrganizationId)

    val userGroupIds = null
    val sendEmail = false

    val serviceContext = new ServiceContext()

    serviceContext.setScopeGroupId(guestGroup.getGroupId)

    val user = UserLocalServiceUtil.addUser(
      creatorUserId, companyId, autoPassword, password1, password2,
      autoScreenName, screenName, emailAddress, facebookId, openId,
      locale, firstName, middleName, lastName, prefixId, suffixId, male,
      birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
      organizationIds, roleIds, userGroupIds, sendEmail, serviceContext)

    val portrait = getBytes("/pictures/profile/" + screenName + ".jpg")

    UserLocalServiceUtil.updatePortrait(user.getUserId, portrait)

    val questions = StringUtil.split(PropsUtil.get("users.reminder.queries.questions"))

    val question = questions(0)
    val answer = "123"
    UserLocalServiceUtil.updateReminderQuery(user.getUserId, question, answer)

    user
  }

  protected def configureJournalContent(layout: Layout, group: Group, portletId: String, articleId: String) {

    val portletSetup = PortletPreferencesFactoryUtil.getLayoutPortletSetup(layout, portletId)

    if (group == null) {
      portletSetup.setValue("groupId", String.valueOf(layout.getGroupId))
    } else {
      portletSetup.setValue("groupId", String.valueOf(group.getGroupId))
    }
    portletSetup.setValue("articleId", articleId)

    portletSetup.store()
  }

  protected def removePortletBorder(layout: Layout, portletId: String) {
    val portletSetup = PortletPreferencesFactoryUtil.getLayoutPortletSetup(layout, portletId)
    portletSetup.setValue("portlet-setup-show-borders", "false")
    portletSetup.store()
  }

  protected def addLayout(group: Group, name: String, privateLayout: Boolean, friendlyURL: String, layoutTemplateId: String) = {
    val serviceContext: ServiceContext = new ServiceContext
    val layout = LayoutLocalServiceUtil.addLayout(group.getCreatorUserId, group.getGroupId,
      privateLayout, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID,
      name, StringPool.BLANK, StringPool.BLANK, LayoutConstants.TYPE_PORTLET,
      false, friendlyURL, serviceContext)
    val layoutTypePortlet = layout.getLayoutType.asInstanceOf[LayoutTypePortlet]
    layoutTypePortlet.setLayoutTemplateId(0, layoutTemplateId, false)
    addResources(layout, PortletKeys.DOCKBAR)
    layout
  }

  protected def addResources(layout: Layout, portletId: String) {
    val rootPortletId = PortletConstants.getRootPortletId(portletId)
    //PortletLocalServiceUtil.getPortletById(portletId)
    val portletPrimaryKey = PortletPermissionUtil.getPrimaryKey(layout.getPlid, portletId)
    ResourceLocalServiceUtil.addResources(layout.getCompanyId, layout.getGroupId, 0, rootPortletId, portletPrimaryKey, true, true, true)
  }

  protected def addPortletId(layout: Layout, portletId: String, columnId: String) = {
    val layoutTypePortlet: LayoutTypePortlet = layout.getLayoutType.asInstanceOf[LayoutTypePortlet]
    val newPortletID = layoutTypePortlet.addPortletId(0, portletId, columnId, -1, false)
    addResources(layout, newPortletID)
    updateLayout(layout)
    newPortletID
  }

  protected def updateLayout(layout: Layout) {
    LayoutLocalServiceUtil.updateLayout(layout.getGroupId, layout.isPrivateLayout, layout.getLayoutId, layout.getTypeSettings)
  }

  protected def addJournalArticle(userId: Long, groupId: Long, title: String, fileName: String, serviceContext: ServiceContext): JournalArticle = {
    addJournalArticle(userId, groupId, title, fileName, StringPool.BLANK, StringPool.BLANK, serviceContext)
  }

  protected def addJournalArticle(userId: Long, groupId: Long,
                                  title: String, filename: String,
                                  structureId: String, templateId: String, serviceContext: ServiceContext): JournalArticle = {

    val content = getString(filename)

    serviceContext.setAddGroupPermissions(true)
    serviceContext.setAddGuestPermissions(true)
    serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH)

    val journalArticle = JournalArticleLocalServiceUtil.addArticle(userId, groupId,
      0, 0, //classNameId, classPK,
      title, //articleId,
      false, //autoArticleId,
      JournalArticleConstants.VERSION_DEFAULT,
      Map(Locale.US -> title),
      null, //descriptionMap,
      content,
      "general", // type,
      structureId,
      templateId, // templateId,
      StringPool.BLANK, //layoutUuid,
      1, 1, 2013, 0, 0, // displayDateMonth, displayDateDay, displayDateYear,
      // displayDateHour, displayDateMinute,
      0, 0, 0, 0, 0, true, // expirationDateMonth, expirationDateDay,
      // expirationDateYear, expirationDateHour,
      //expirationDateMinute, neverExpire,
      0, 0, 0, 0, 0, true, // reviewDateMonth, reviewDateDay, reviewDateYear,
      //reviewDateHour, reviewDateMinute, neverReview,
      true, // indexable
      false, StringPool.BLANK, null, // smallImage, smallImageURL, smallImageFile,
      null, StringPool.BLANK, // images, articleURL,
      serviceContext)

    JournalArticleLocalServiceUtil.updateStatus(
      userId, groupId, journalArticle.getArticleId,
      journalArticle.getVersion, WorkflowConstants.STATUS_APPROVED,
      StringPool.BLANK, serviceContext)

    journalArticle
  }

  protected def getString(path: String) = {
    new String(getBytes(path))
  }

  protected def getBytes(path: String) = {
    FileUtil.getBytes(getInputStream(path))
  }

  protected def getInputStream(path: String) = {
    Thread.currentThread().getContextClassLoader.getResourceAsStream(path)
  }

  protected def addDLFileEntry(userId: Long, groupId: Long, folderId: Long, fileName: String,
                               name: String, title: String, description: String, serviceContext: ServiceContext) = {

    val bytes = getBytes(fileName)

    serviceContext.setAddGroupPermissions(true)
    serviceContext.setAddGuestPermissions(true)

    DLAppServiceUtil.addFileEntry(groupId, folderId, fileName, MimeTypesUtil.getContentType(fileName), title,
      description, StringPool.BLANK, bytes, serviceContext)
  }

  protected def addDLFolder(userId: Long, groupId: Long, name: String, description: String) = {
    val serviceContext = new ServiceContext

    serviceContext.setAddGroupPermissions(true)
    serviceContext.setAddGuestPermissions(true)

    DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, 0, name, description, serviceContext)
  }

  protected def addMBCategory(userId: Long, name: String, description: String, serviceContext: ServiceContext) = {
    MBCategoryLocalServiceUtil.addCategory(
      userId, 0, name, description, StringPool.BLANK, StringPool.BLANK,
      StringPool.BLANK, StringPool.BLANK, 0, false, StringPool.BLANK,
      StringPool.BLANK, 1, StringPool.BLANK, false, StringPool.BLANK, 0, false,
      StringPool.BLANK, StringPool.BLANK, false, false, serviceContext)
  }

  protected def addMBMessage(userId: Long, userName: String, groupId: Long, categoryId: Long,
                             threadId: Long, parentMessageId: Long, subject: String, fileName: String, serviceContext: ServiceContext) = {

    val body = getString(fileName)

    MBMessageLocalServiceUtil.addMessage(
      userId, userName, groupId, categoryId, threadId, parentMessageId,
      subject, body, "bbcode", new util.ArrayList[ObjectValuePair[String, InputStream]](),
      false, -1.0, false, serviceContext)
  }
}
