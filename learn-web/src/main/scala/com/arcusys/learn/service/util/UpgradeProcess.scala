package com.arcusys.learn.service.util

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
import com.liferay.portal.security.auth.PrincipalThreadLocal
import com.liferay.portal.security.permission.{PermissionThreadLocal, PermissionCheckerFactoryUtil}
import com.liferay.portlet.messageboards.service.{MBThreadLocalServiceUtil, MBDiscussionLocalServiceUtil, MBMessageLocalServiceUtil, MBCategoryLocalServiceUtil}
import java.io.InputStream
import java.util
import com.liferay.portal.NoSuchOrganizationException
import com.arcusys.learn.admin.service.UploadService
import com.arcusys.learn.scorm.tracking.model.User
import scala.Array
import scala.util.Random
import com.arcusys.learn.storage.StorageFactoryContract

class UpgradeProcess(storageFactory: StorageFactoryContract) {
  final private val demoOrgName = "Project Learn Demo 1.4"

  def doUpgrade() {
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
      val orgToDelete = OrganizationLocalServiceUtil.getOrganizationId(companyId, demoOrgName)
      UserLocalServiceUtil.unsetOrganizationUsers(orgToDelete, UserLocalServiceUtil.getOrganizationUsers(orgToDelete).map(_.getUserId).toArray)
      OrganizationLocalServiceUtil.deleteOrganization(orgToDelete)
      setupOrganizations(companyId, defaultUserId)
    } catch {
      case e: NoSuchOrganizationException => {
        setupOrganizations(companyId, defaultUserId)
      }
    }
    //">>> Upgrade to version 1.4"
  }

  def setupOrganizations(companyId: Long, defaultUserId: Long) {
    val userId = defaultUserId
    val parentOrganizationId = OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID
    val name = demoOrgName
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
    GroupLocalServiceUtil.updateFriendlyURL(group.getGroupId, "/learn-demo-hook-1.4")
    serviceContext.setScopeGroupId(group.getGroupId)

    // Layout set theme
    try {
      LayoutSetLocalServiceUtil.updateLookAndFeel(group.getGroupId, false, "projectlearn61theme_WAR_projectlearn61theme", "", "", false)
    } catch {
      case e:Exception => {
        // well, looks like we don't have theme installed, skip then
      }
    }

    // Home layout
    val layoutTheory = addLayout(group, "Theory", false, "/home", "2_columns_ii")
    addPortletId(layoutTheory, "SCORMApplication_WAR_learnweb", "column-2")
    val portletTheory = addPortletId(layoutTheory, PortletKeys.JOURNAL_CONTENT, "column-1")
    removePortletBorder(layoutTheory, portletTheory)
    val journalArticle = addJournalArticle(defaultUserId, group.getGroupId, "Introduction", "/demo/articles/introduction.xml", serviceContext)
    configureJournalContent(layoutTheory, group, portletTheory, journalArticle.getArticleId)

    val layoutDiscussion = addLayout(group, "Discussion", false, "/discussion", "2_columns_ii")
    addPortletId(layoutDiscussion, PortletKeys.MESSAGE_BOARDS, "column-2")
    val portletIntroduction = addPortletId(layoutDiscussion, PortletKeys.JOURNAL_CONTENT, "column-1")
    removePortletBorder(layoutDiscussion, portletTheory)
    val journalArticleIntro = addJournalArticle(defaultUserId, group.getGroupId, "Instructions", "/demo/articles/instructions.xml", serviceContext)
    configureJournalContent(layoutDiscussion, group, portletIntroduction, journalArticleIntro.getArticleId)

    val layoutFiles = addLayout(group, "Files", false, "/files", "1_column")
    addPortletId(layoutFiles, PortletKeys.DOCUMENT_LIBRARY, "column-1")

    val layoutExams = addLayout(group, "Exams", false, "/exams", "2_columns_ii")
    addPortletId(layoutExams, "SCORMApplication_WAR_learnweb", "column-2")
    val portletExams = addPortletId(layoutExams, PortletKeys.JOURNAL_CONTENT, "column-1")
    removePortletBorder(layoutExams, portletExams)
    val journalArticleExams = addJournalArticle(defaultUserId, group.getGroupId, "Exams", "/demo/articles/exams.xml", serviceContext)
    configureJournalContent(layoutExams, group, portletExams, journalArticleExams.getArticleId)

    val layoutTools = addLayout(group, "Tools", false, "/tools", "2_columns_ii")
    val portletTools = addPortletId(layoutTools, PortletKeys.JOURNAL_CONTENT, "column-1")
    removePortletBorder(layoutTools, portletTools)
    addPortletId(layoutTools, "SCORMQuestionBank_WAR_learnweb", "column-2")
    addPortletId(layoutTools, "SCORMQuizes_WAR_learnweb", "column-2")
    addPortletId(layoutTools, "Gradebook_WAR_learnweb", "column-2")
    val journalArticleTools = addJournalArticle(defaultUserId, group.getGroupId, "Tools", "/demo/articles/tools.xml", serviceContext)
    configureJournalContent(layoutTools, group, portletTools, journalArticleTools.getArticleId)

    val teacherRoleIDs = Array(RoleLocalServiceUtil.getRole(companyId, "Teacher").getRoleId)
    val studentRoleIDs = Array(RoleLocalServiceUtil.getRole(companyId, "Student").getRoleId)

    val studentMillaUser = addUser(companyId, "milla.oppilas", "Milla", "Oppilas", false, "Student", studentRoleIDs)
    val studentOskuUser = addUser(companyId, "osku.opiskelija", "Osku", "Opiskelija", true, "Student", studentRoleIDs)
    val teacherUser = addUser(companyId, "olli.opettaja", "Olli", "Opettaja", true, "Teacher", teacherRoleIDs)


    UserGroupRoleLocalServiceUtil.addUserGroupRoles(studentMillaUser.getUserId, group.getGroupId, studentRoleIDs)
    UserGroupRoleLocalServiceUtil.addUserGroupRoles(studentOskuUser.getUserId, group.getGroupId, studentRoleIDs)
    UserGroupRoleLocalServiceUtil.addUserGroupRoles(teacherUser.getUserId, group.getGroupId, teacherRoleIDs)

    // Document library
    PrincipalThreadLocal.setName(teacherUser.getUserId)
    val permissionChecker = PermissionCheckerFactoryUtil.create(teacherUser)
    PermissionThreadLocal.setPermissionChecker(permissionChecker)

    val dlFolder = addDLFolder(teacherUser.getUserId, group.getGroupId,
      "Picures", "Picture related with the Learn Project")

    val entry = addDLFileEntry(teacherUser.getUserId, dlFolder.getGroupId, dlFolder.getFolderId, "/demo/documents/learn-grow-flow.jpg",
      "learn-grow-flow.jpg", "Learn", "Just a nice picture", serviceContext)

    addMBDiscussionMessage(studentMillaUser.getUserId, studentMillaUser.getFullName, group.getGroupId, entry.getModelClassName, entry.getPrimaryKey, 0, 0,
      "My comment", "/demo/files/comment.xml", serviceContext)

    val rootMsg = addMBMessage(teacherUser.getUserId, teacherUser.getFullName, group.getGroupId, 0, 0, 0,
      "What are your expectations from the course (answer within one week)", "/demo/messageboards/general.xml", serviceContext)
    addMBMessage(studentOskuUser.getUserId, studentOskuUser.getFullName, group.getGroupId, 0, rootMsg.getThreadId, rootMsg.getMessageId,
      "My thoughts", "/demo/messageboards/reply.xml", serviceContext)

    val packageId = addCourse(group.getGroupId, teacherUser.getUserId)

    val studentIds = List(studentMillaUser.getUserId, studentOskuUser.getUserId)

    addAttempts(packageId, studentIds)

    addActivities(packageId, studentIds)

  }

  private def addActivities(packageId: Int, studentIds: List[Long]) {
    studentIds.foreach(studentId => {
      val activities = storageFactory.activityStorage.getAllFlat(packageId)
      val currentAttempt = storageFactory.attemptStorage.getLast(studentId.toInt, packageId).get
      for (activity <- activities) {
        if (activity.id.startsWith("question")) {
          storageFactory.dataModelStorage.setValue(currentAttempt.id, activity.id, "cmi.completion_status", "completed")
          storageFactory.dataModelStorage.setValue(currentAttempt.id, activity.id, "cmi.score.scaled", getRandomScaled._1) //0.0
          storageFactory.dataModelStorage.setValue(currentAttempt.id, activity.id, "cmi.success_status", getRandomScaled._2) // failed
        }
      }
      storageFactory.attemptStorage.markAsComplete(currentAttempt.id)
    })
  }

  private def getRandomScaled() = {
    val scale = round(Random.nextFloat(), 1)
    val status = if (scale == 0) "failed" else "passed"
    (scale, status)
  }

  private def round(value: Float, places: Int) = {
    if (places < 0) throw new IllegalArgumentException()
    val factor = Math.pow(10, places).toFloat
    val tmp = Math.round(value * factor).toFloat
    (tmp / factor).toString
  }

  private def addAttempts(packageId: Int, studentIds: List[Long]) {
    val organizationId = storageFactory.activityStorage.getAllOrganizations(packageId).get(0).id
    studentIds.foreach(studentId => {
      storageFactory.attemptStorage.createAndGetID(studentId.toInt, packageId, organizationId)
    })
  }

  private def addCourse(courseId: Long, teacherUserId: Long) = {
    val title = "demo package"
    val summary = "demo package"
    val stream = getInputStream("/demo/packages/1.zip")
    val userID = teacherUserId
    val groupID = courseId
    val courseID = courseId
    new UploadService().storePackage(title, summary, Some(courseID.toInt), stream, userID, groupID)
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

    val sevenCogsOrganization = OrganizationLocalServiceUtil.getOrganization(companyId, demoOrgName)
    val defaultOrganization = OrganizationLocalServiceUtil.getOrganization(companyId, "Liferay, Inc.")

    val sendEmail = false

    val serviceContext = new ServiceContext()

    serviceContext.setScopeGroupId(guestGroup.getGroupId)

    val createdUser = UserLocalServiceUtil.getUsers(-1, -1).find(_.getScreenName == screenName)
    val user = if (createdUser != None) {
      val foundUser = createdUser.get
      if (storageFactory.userStorage.getByID(foundUser.getUserId.toInt).isDefined) {
        storageFactory.userStorage.delete(foundUser.getUserId.toInt)
      }
      foundUser
    } else {
      UserLocalServiceUtil.addUser(
        creatorUserId, companyId, autoPassword, password1, password2,
        autoScreenName, screenName, emailAddress, facebookId, openId,
        locale, firstName, middleName, lastName, prefixId, suffixId, male,
        birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
        Array(defaultOrganization.getOrganizationId), Array[Long](), Array[Long](), sendEmail, serviceContext)
    }

    UserLocalServiceUtil.addGroupUsers(sevenCogsOrganization.getGroupId, Array(user.getUserId))

    val portrait = getBytes("/demo/profile/" + screenName + ".jpg")

    UserLocalServiceUtil.updatePortrait(user.getUserId, portrait)

    val questions = StringUtil.split(PropsUtil.get("users.reminder.queries.questions"))

    val question = questions(0)
    val answer = "123"
    UserLocalServiceUtil.updateReminderQuery(user.getUserId, question, answer)
    val userUID = user.getUserId
    if (storageFactory.userStorage.getByID(userUID.toInt).isEmpty) {
      storageFactory.userStorage.createAndGetID(User(userUID.toInt, user.getFullName))
    }
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

  protected def addMBDiscussionMessage(userId: Long, userName: String, groupId: Long, className: String, classPK: Long,
                                       threadId: Long, parentMessageId: Long, subject: String, fileName: String,
                                       serviceContext: ServiceContext) = {

    val body = getString(fileName)
    val threadID = MBDiscussionLocalServiceUtil.getDiscussion(className, classPK).getThreadId
    MBMessageLocalServiceUtil.addDiscussionMessage(userId, userName, groupId, className, classPK, threadID,
      MBThreadLocalServiceUtil.getMBThread(threadID).getRootMessageId, subject, body, serviceContext)
  }
}
