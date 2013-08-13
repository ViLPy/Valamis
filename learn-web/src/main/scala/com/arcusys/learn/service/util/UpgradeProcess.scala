package com.arcusys.learn.service.util

import com.liferay.portal.service._
import permission.PortletPermissionUtil
import scala.collection.JavaConversions._
import com.liferay.portal.model._
import com.liferay.portal.kernel.util._
import com.liferay.portal.util.{PortletKeys, PortalUtil}
import com.liferay.portlet.journal.service.{JournalTemplateLocalServiceUtil, JournalStructureLocalServiceUtil, JournalArticleLocalServiceUtil}
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
import com.arcusys.learn.admin.service.UploadService
import com.arcusys.learn.scorm.tracking.model.User
import scala.Array
import scala.util.Random
import com.arcusys.learn.storage.StorageFactoryContract
import com.liferay.portal.kernel.lar.PortletDataHandlerKeys
import scala.xml.XML
import scala.collection.JavaConverters._
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil
import com.liferay.portlet.polls.service.{PollsChoiceLocalServiceUtil, PollsQuestionLocalServiceUtil}
import com.arcusys.learn.questionbank.model.{ChoiceAnswer, ChoiceQuestion}
import com.arcusys.learn.quiz.model.Quiz

object UpgradeProcess {
  val isPublic = false
}

object HookHelpers {
  def getString(path: String) = {
    new String(getBytes(path))
  }

  def getBytes(path: String) = {
    FileUtil.getBytes(getInputStream(path))
  }

  def getInputStream(path: String) = {
    Thread.currentThread().getContextClassLoader.getResourceAsStream(path)
  }
}

trait BlogHelpers {
  def addBlogsEntry(userId: Long, title: String, fileName: String,
                    serviceContext: ServiceContext, replacement: Map[String, String] = Map()) = {
    val content = if (replacement.isEmpty) {
      HookHelpers.getString(fileName)
    } else {
      replacement.foldLeft(HookHelpers.getString(fileName)) {
        (src, param) => src.replaceAll(param._1, param._2)
      }
    }

    BlogsEntryLocalServiceUtil.addEntry(
      userId, title, StringPool.BLANK, content, 1, 1, 2013, 0, 0, false, false,
      Array[String](), false, StringPool.BLANK, StringPool.BLANK, null, serviceContext)
  }
}

trait MessageBoardSupport {
  def addMBCategory(userId: Long, name: String, description: String, serviceContext: ServiceContext) = {
    MBCategoryLocalServiceUtil.addCategory(
      userId, 0, name, description, StringPool.BLANK, StringPool.BLANK,
      StringPool.BLANK, StringPool.BLANK, 0, false, StringPool.BLANK,
      StringPool.BLANK, 1, StringPool.BLANK, false, StringPool.BLANK, 0, false,
      StringPool.BLANK, StringPool.BLANK, false, false, serviceContext)
  }

  def addMBMessage(userId: Long, userName: String, groupId: Long, categoryId: Long,
                   threadId: Long, parentMessageId: Long, subject: String, fileName: String, serviceContext: ServiceContext) = {

    val body = HookHelpers.getString(fileName)

    MBMessageLocalServiceUtil.addMessage(
      userId, userName, groupId, categoryId, threadId, parentMessageId,
      subject, body, "bbcode", new util.ArrayList[ObjectValuePair[String, InputStream]](),
      false, -1.0, false, serviceContext)
  }

  def addMBDiscussionMessage(userId: Long, userName: String, groupId: Long, className: String, classPK: Long,
                             threadId: Long, parentMessageId: Long, subject: String, fileName: String,
                             serviceContext: ServiceContext) = {

    val body = HookHelpers.getString(fileName)
    val threadID = MBDiscussionLocalServiceUtil.getDiscussion(className, classPK).getThreadId
    MBMessageLocalServiceUtil.addDiscussionMessage(userId, userName, groupId, className, classPK, threadID,
      MBThreadLocalServiceUtil.getMBThread(threadID).getRootMessageId, subject, body, serviceContext)
  }
}

trait DocumentLibrarySupport {
  protected def addDLFileEntry(userId: Long, groupId: Long, folderId: Long, fileName: String,
                               name: String, title: String, description: String, serviceContext: ServiceContext) = {

    val bytes = HookHelpers.getBytes(fileName)

    serviceContext.setAddGroupPermissions(true)
    serviceContext.setAddGuestPermissions(UpgradeProcess.isPublic)

    DLAppServiceUtil.addFileEntry(groupId, folderId, fileName, MimeTypesUtil.getContentType(fileName), title,
      description, StringPool.BLANK, bytes, serviceContext)
  }

  protected def addDLFolder(userId: Long, groupId: Long, name: String, description: String) = {
    val serviceContext = new ServiceContext

    serviceContext.setAddGroupPermissions(true)
    serviceContext.setAddGuestPermissions(UpgradeProcess.isPublic)

    DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, 0, name, description, serviceContext)
  }
}

trait UserHelpers {

  implicit val storageFactory: StorageFactoryContract

  def addUser(organizationID: Long, companyId: Long, screenName: String, firstName: String, lastName: String, male: Boolean,
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

    val sevenCogsOrganization = OrganizationLocalServiceUtil.getOrganization(organizationID)

    val sendEmail = false

    val serviceContext = new ServiceContext()

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
        birthdayMonth, birthdayDay, birthdayYear, jobTitle, Array[Long](),
        Array[Long](), Array[Long](), Array[Long](), sendEmail, serviceContext)
    }

    UserLocalServiceUtil.addGroupUsers(sevenCogsOrganization.getGroupId, Array(user.getUserId))

    val portrait = HookHelpers.getBytes("demo/profile/" + screenName + ".jpg")

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
}

class UpgradeProcess(val storageFactory: StorageFactoryContract) extends UserHelpers with BlogHelpers
with MessageBoardSupport with DocumentLibrarySupport
{
  final private val demoOrgName = "Project Learn Demo 1.4.5"

  def doUpgrade() {
    System.out.println("Deploying private demo site")
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
      val orgToDelete = OrganizationLocalServiceUtil.getOrganizations(-1, -1).asScala.filter(_.getName.equalsIgnoreCase(demoOrgName)) //.getOrganizationId(companyId, demoOrgName)
      orgToDelete.foreach(organization => {
        UserLocalServiceUtil.unsetOrganizationUsers(organization.getOrganizationId, UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId).map(_.getUserId).toArray)
        OrganizationLocalServiceUtil.deleteOrganization(organization)
      })
    } catch {
      case e: Exception => {
        //setupOrganizations(companyId, defaultUserId)
      }
    }
    setupOrganizations(companyId, defaultUserId)
  }

  def setupOrganizations(companyId: Long, defaultUserId: Long) {
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
    serviceContext.setAddGuestPermissions(UpgradeProcess.isPublic)

    val organization = OrganizationLocalServiceUtil.addOrganization(defaultUserId, parentOrganizationId, name, organizationType, recursable, regionId, countryId, statusId, comments, true, serviceContext)

    // Group
    val group = organization.getGroup
    group.setTypeSettings("customJspServletContextName=valamis-learn-hook")
    GroupLocalServiceUtil.updateGroup(group)
    GroupLocalServiceUtil.updateFriendlyURL(group.getGroupId, "/learn-demo-hook-1.4.5")
    serviceContext.setScopeGroupId(group.getGroupId)

    // Layout set theme
    try {
      LayoutSetLocalServiceUtil.updateLookAndFeel(group.getGroupId, false, "valamislearntheme_WAR_valamislearntheme", "", "", false)
      LayoutSetLocalServiceUtil.updateLookAndFeel(group.getGroupId, true, "valamislearntheme_WAR_valamislearntheme", "", "", false)
    } catch {
      case e: Exception => {
        // well, looks like we don't have theme installed, skip then
      }
    }

    // Home layout
    val welcomeBoxStructure = addJournalStructure(defaultUserId, group.getGroupId, "Welcome box", "demo/structures/welcome.box.xml", serviceContext)
    val welcomeBoxTemplate = addJournalTemplate(defaultUserId, group.getGroupId, "Welcome box", "demo/templates/welcome.box.xml", welcomeBoxStructure.getStructureId, "vm", serviceContext)
    val infoBoxTemplate = addJournalTemplate(defaultUserId, group.getGroupId, "Info box", "demo/templates/info.box.xml", welcomeBoxStructure.getStructureId, "vm", serviceContext)

    val linkBoxStructure = addJournalStructure(defaultUserId, group.getGroupId, "Link box", "demo/structures/link.box.xml", serviceContext)
    val linkBoxTemplate = addJournalTemplate(defaultUserId, group.getGroupId, "Link box", "demo/templates/link.box.xml", linkBoxStructure.getStructureId, "vm", serviceContext)

    val pictureBoxStructure = addJournalStructure(defaultUserId, group.getGroupId, "Picturebox", "demo/structures/picturebox.xml", serviceContext)
    val pictureBoxTemplate = addJournalTemplate(defaultUserId, group.getGroupId, "Picturebox", "demo/templates/picturebox.xml", pictureBoxStructure.getStructureId, "vm", serviceContext)

    val layoutTheory = addLayout(group, "Home", UpgradeProcess.isPublic, "/home", "frontpage")

    val portletLanding1 = addPortletId(layoutTheory, PortletKeys.JOURNAL_CONTENT, "column-1")
    val journalArticle1 = addJournalArticle(defaultUserId, group.getGroupId,
      "WELCOME INFO", "demo/articles/landing1.xml",
      welcomeBoxStructure.getStructureId, welcomeBoxTemplate.getTemplateId,
      serviceContext)
    configureJournalContent(layoutTheory, group, portletLanding1, journalArticle1.getArticleId)
    removePortletBorder(layoutTheory, portletLanding1)

    // ------------
    val portletLanding3 = addPortletId(layoutTheory, PortletKeys.JOURNAL_CONTENT, "column-3")

    val journalArticle3 = addJournalArticle(defaultUserId, group.getGroupId,
      "E-LEARNING TOOLS LINK", "demo/articles/landing3.xml",
      linkBoxStructure.getStructureId, linkBoxTemplate.getTemplateId,
      serviceContext)
    configureJournalContent(layoutTheory, group, portletLanding3, journalArticle3.getArticleId)
    removePortletBorder(layoutTheory, portletLanding3)

    val playerPortlet = addPortletId(layoutTheory, "SCORMApplication_WAR_learnweb", "column-4")
    setCustomTitle(layoutTheory, playerPortlet, "Check out your latest material")

    val assetPublisher = addPortletId(layoutTheory, PortletKeys.ASSET_PUBLISHER, "column-5")
    setPortletPreferences(layoutTheory, assetPublisher, "demo/settings/latest.topics.xml")

    val activities = addPortletId(layoutTheory, PortletKeys.ACTIVITIES, "column-6")
    setPortletPreferences(layoutTheory, activities, "demo/settings/activities.xml")


    val teacherRoleIDs = Array(RoleLocalServiceUtil.getRole(companyId, "Teacher").getRoleId)
    val studentRoleIDs = Array(RoleLocalServiceUtil.getRole(companyId, "Student").getRoleId)

    val studentMillaUser = addUser(organization.getOrganizationId, organization.getCompanyId, "milla.oppilas", "Milla", "Oppilas", false, "Student", studentRoleIDs)
    val studentOskuUser = addUser(organization.getOrganizationId, organization.getCompanyId, "osku.opiskelija", "Osku", "Opiskelija", true, "Student", studentRoleIDs)
    val teacherUser = addUser(organization.getOrganizationId, organization.getCompanyId, "olli.opettaja", "Olli", "Opettaja", true, "Teacher", teacherRoleIDs)

    UserGroupRoleLocalServiceUtil.addUserGroupRoles(studentMillaUser.getUserId, group.getGroupId, studentRoleIDs)
    UserGroupRoleLocalServiceUtil.addUserGroupRoles(studentOskuUser.getUserId, group.getGroupId, studentRoleIDs)
    UserGroupRoleLocalServiceUtil.addUserGroupRoles(teacherUser.getUserId, group.getGroupId, teacherRoleIDs)


    PrincipalThreadLocal.setName(teacherUser.getUserId)
    val permissionChecker = PermissionCheckerFactoryUtil.create(teacherUser)
    PermissionThreadLocal.setPermissionChecker(permissionChecker)

    val dlFolder = addDLFolder(teacherUser.getUserId, group.getGroupId,
      "Picures", "Picture related with the Learn Project")

    val discussion = addDLFileEntry(teacherUser.getUserId, dlFolder.getGroupId, dlFolder.getFolderId, "demo/documents/guys-discussion.1.jpg",
      "guys-discussion.1.jpg", "Discussion", "", serviceContext)

    val portletLanding2 = addPortletId(layoutTheory, PortletKeys.JOURNAL_CONTENT, "column-2")

    val journalArticle2 = addJournalArticle(defaultUserId, group.getGroupId,
      "Discussion", "demo/articles/landing3.xml",
      pictureBoxStructure.getStructureId, pictureBoxTemplate.getTemplateId,
      serviceContext)

    val url = "/documents/" + discussion.getGroupId + "/" + discussion.getFolderId + "/" + discussion.getTitle

    val pictureContent = <root available-locales="en_US" default-locale="en_US">
      <dynamic-element instance-id="a71Lks8V" name="Picture" type="document_library" index-type=" ">
        <dynamic-content>
          {url}
        </dynamic-content>
      </dynamic-element>
    </root>

    journalArticle2.setContent(pictureContent.toString())
    JournalArticleLocalServiceUtil.updateJournalArticle(journalArticle2)
    configureJournalContent(layoutTheory, group, portletLanding2, journalArticle2.getArticleId)
    removePortletBorder(layoutTheory, portletLanding2)


    val question = PollsQuestionLocalServiceUtil.addQuestion(teacherUser.getUserId,
      Map(Locale.US -> "Poll"), Map(Locale.US -> "Do you think we might be on to something?"), 1, 1, 2020, 1, 1, true, null, serviceContext)
    PollsChoiceLocalServiceUtil.addChoice(question.getQuestionId, "a", "Yes definitely.", serviceContext)
    PollsChoiceLocalServiceUtil.addChoice(question.getQuestionId, "b", "Maybe.", serviceContext)
    PollsChoiceLocalServiceUtil.addChoice(question.getQuestionId, "c", "I think you have things to learn still.", serviceContext)
    val portletPolls = addPortletId(layoutTheory, PortletKeys.POLLS_DISPLAY, "column-7")
    setupPortlet(layoutTheory, portletPolls, "questionId", question.getQuestionId.toString)

    // collaboration =================================
    val layoutCollaboration = addLayout(group, "Collaboration", UpgradeProcess.isPublic, "/collaboration", "2_columns_ii")

    val portletCollaborationAbout = addPortletId(layoutCollaboration, PortletKeys.JOURNAL_CONTENT, "column-1")

    val articleCollaborationAbout = addJournalArticle(defaultUserId, group.getGroupId,
      "BLOG INFO", "demo/articles/blog.info.xml",
      welcomeBoxStructure.getStructureId, infoBoxTemplate.getTemplateId,
      serviceContext)
    configureJournalContent(layoutCollaboration, group, portletCollaborationAbout, articleCollaborationAbout.getArticleId)
    removePortletBorder(layoutCollaboration, portletCollaborationAbout)

    val blogs = addPortletId(layoutCollaboration, PortletKeys.BLOGS, "column-2")
    removePortletBorder(layoutCollaboration, blogs)

    addBlogsEntry(teacherUser.getUserId, "Finland and PISA (The Programme for International Student Assessment) survey.",
      "demo/blog/pisa.xml", serviceContext)

    val coffee = addDLFileEntry(teacherUser.getUserId, dlFolder.getGroupId, dlFolder.getFolderId, "demo/documents/coffee-tablet.jpg",
      "coffee-tablet.jpg", "Coffee tablet", "", serviceContext)
    val coffeeUrl = "/documents/" + coffee.getGroupId + "/" + coffee.getFolderId + "/" + coffee.getTitle
    addBlogsEntry(teacherUser.getUserId, "Lifelong learning",
      "demo/blog/lifelong.xml", serviceContext, Map("__coffee__" -> coffeeUrl))

    // discuss =================================
    val layoutDiscussion = addLayout(group, "Discuss", UpgradeProcess.isPublic, "/discuss", "2_columns_ii")

    val portletDiscussAbout = addPortletId(layoutDiscussion, PortletKeys.JOURNAL_CONTENT, "column-1")

    val articleDiscussAbout = addJournalArticle(defaultUserId, group.getGroupId,
      "DISCUSS INFO", "demo/articles/discuss.info.xml",
      welcomeBoxStructure.getStructureId, infoBoxTemplate.getTemplateId,
      serviceContext)
    configureJournalContent(layoutDiscussion, group, portletDiscussAbout, articleDiscussAbout.getArticleId)
    removePortletBorder(layoutDiscussion, portletDiscussAbout)

    val mBoards = addPortletId(layoutDiscussion, PortletKeys.MESSAGE_BOARDS, "column-2")
    removePortletBorder(layoutDiscussion, mBoards)

    val rootMsg = addMBMessage(teacherUser.getUserId, teacherUser.getFullName, group.getGroupId, 0, 0, 0,
      "Common questions", "demo/messageboards/common.xml", serviceContext)
    addMBMessage(studentOskuUser.getUserId, studentOskuUser.getFullName, group.getGroupId, 0, rootMsg.getThreadId, rootMsg.getMessageId,
      "RE: Common questions", "demo/messageboards/common.reply.xml", serviceContext)

    val rootMsg2 = addMBMessage(teacherUser.getUserId, teacherUser.getFullName, group.getGroupId, 0, 0, 0,
      "How to support learners?", "demo/messageboards/support.xml", serviceContext)
    addMBMessage(studentMillaUser.getUserId, studentMillaUser.getFullName, group.getGroupId, 0, rootMsg2.getThreadId, rootMsg2.getMessageId,
      "RE: How to support learners?", "demo/messageboards/support.reply.xml", serviceContext)
    addMBMessage(studentOskuUser.getUserId, studentOskuUser.getFullName, group.getGroupId, 0, rootMsg2.getThreadId, rootMsg2.getMessageId,
      "RE: How to support learners?", "demo/messageboards/support.reply.2.xml", serviceContext)

    // tools =================================
    val layoutTools = addLayout(group, "Tools", UpgradeProcess.isPublic, "/tools", "2_columns_ii")
    addToolsNavigationPortlet(layoutTools)
    addSimpleJournalArticle(defaultUserId, group, layoutTools, "Tools", "demo/articles/tools.xml", "column-2", serviceContext)

    val layoutToolsQuestionbank = addLayout(group, "Question editor", UpgradeProcess.isPublic, "/tools/question-bank", "2_columns_ii", layoutTools.getLayoutId)
    addToolsNavigationPortlet(layoutToolsQuestionbank)
    addSimpleJournalArticle(defaultUserId, group, layoutToolsQuestionbank, "Question editor", "demo/articles/questionedit.xml", "column-1", serviceContext)
    addPortletId(layoutToolsQuestionbank, "SCORMQuestionBank_WAR_learnweb", "column-2")

    val layoutToolsQuizEditor = addLayout(group, "Quiz editor", UpgradeProcess.isPublic, "/tools/quiz-editor", "2_columns_ii", layoutTools.getLayoutId)
    addToolsNavigationPortlet(layoutToolsQuizEditor)
    addSimpleJournalArticle(defaultUserId, group, layoutToolsQuizEditor, "Quiz editor", "demo/articles/quizedit.xml", "column-1", serviceContext)
    addPortletId(layoutToolsQuizEditor, "SCORMQuizes_WAR_learnweb", "column-2")

    val layoutToolsAdmin = addLayout(group, "Admin tools", UpgradeProcess.isPublic, "/tools/admin-tools", "2_columns_ii", layoutTools.getLayoutId)
    addToolsNavigationPortlet(layoutToolsAdmin)
    addSimpleJournalArticle(defaultUserId, group, layoutToolsAdmin, "Admin tools", "demo/articles/admin.xml", "column-1", serviceContext)
    addPortletId(layoutToolsAdmin, "SCORMApplicationAdmin_WAR_learnweb", "column-2")

    val layoutToolsGradebook = addLayout(group, "Gradebook", UpgradeProcess.isPublic, "/tools/gradebook", "2_columns_ii", layoutTools.getLayoutId)
    addToolsNavigationPortlet(layoutToolsGradebook)
    addSimpleJournalArticle(defaultUserId, group, layoutToolsGradebook, "Gradebook", "demo/articles/gradebook.xml", "column-1", serviceContext)
    addPortletId(layoutToolsGradebook, "Gradebook_WAR_learnweb", "column-2")

    val layoutToolsCurriculum = addLayout(group, "Curriculum", UpgradeProcess.isPublic, "/tools/curriculum", "2_columns_ii", layoutTools.getLayoutId)
    addToolsNavigationPortlet(layoutToolsCurriculum)
    addSimpleJournalArticle(defaultUserId, group, layoutToolsCurriculum, "Curriculum", "demo/articles/curriculum.xml", "column-1", serviceContext)
    addPortletId(layoutToolsCurriculum, "Curriculum_WAR_learnweb", "column-2")

    /*
    val entry = addDLFileEntry(teacherUser.getUserId, dlFolder.getGroupId, dlFolder.getFolderId, "/demo/documents/learn-grow-flow.jpg",
      "learn-grow-flow.jpg", "Learn", "Just a nice picture", serviceContext)

    addMBDiscussionMessage(studentMillaUser.getUserId, studentMillaUser.getFullName, group.getGroupId, entry.getModelClassName, entry.getPrimaryKey, 0, 0,
      "My comment", "/demo/files/comment.xml", serviceContext)
    */

    addCourse("E-learning Benefits",
      "In this material you will learn what are the benefits of e-learning and how to avoid the most common pitfalls.",
      "demo/packages/valamis-demo.zip",
      group.getGroupId, teacherUser.getUserId, group.getGroupId)
    addCourse("E-learning test", "",
      "demo/packages/quiz-demo.zip",
      group.getGroupId, teacherUser.getUserId, group.getGroupId)
    addQuestionsAndQuiz(group.getGroupId.toInt)
    //val studentIds = List(studentMillaUser.getUserId, studentOskuUser.getUserId)
    //addAttempts(packageId, studentIds)
    //addActivities(packageId, studentIds)

  }

  def addToolsNavigationPortlet(layout: Layout) {
    val portlet = addPortletId(layout, "71", "column-1") // 71 - navigation portlet
    setPortletPreferences(layout, portlet, "demo/settings/navigation.xml")
  }

  def addSimpleJournalArticle(userID: Long, group: Group,
                              layout: Layout, title: String, file: String, destination: String,
                              serviceContext: ServiceContext) {
    val portlet = addPortletId(layout, PortletKeys.JOURNAL_CONTENT, destination)
    val article = addJournalArticle(userID, group.getGroupId, title, file, serviceContext)
    configureJournalContent(layout, group, portlet, article.getArticleId)
  }

  def addDefaultLayoutsByLAR(userId: Long, groupId: Long, privateLayout: Boolean, larFile: java.io.File) {
    val parameterMap = new util.HashMap[String, Array[String]]()

    parameterMap.put(PortletDataHandlerKeys.PERMISSIONS, Array[String](true.toString))
    parameterMap.put(PortletDataHandlerKeys.PORTLET_DATA, Array[String](true.toString))
    parameterMap.put(PortletDataHandlerKeys.PORTLET_DATA_CONTROL_DEFAULT, Array[String](true.toString))
    parameterMap.put(PortletDataHandlerKeys.PORTLET_SETUP, Array[String](true.toString))
    parameterMap.put(PortletDataHandlerKeys.USER_PERMISSIONS, Array[String](true.toString))

    LayoutLocalServiceUtil.importLayouts(userId, groupId, privateLayout, parameterMap, larFile)
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

  private def addCourse(title: String, summary: String, file: String, courseId: Long, userID: Long, groupID: Long) = {
    val stream = HookHelpers.getInputStream(file)
    val courseID = courseId
    new UploadService().storePackage(title, summary, Some(courseID.toInt), stream, userID, groupID)
  }

  private def addQuestionsAndQuiz(courseId: Int) {
    val choice1Answer1 = ChoiceAnswer(0, "tied closely to the time and place.", false)
    val choice1Answer2 = ChoiceAnswer(0, "tied only to mobile devices.", false)
    val choice1Answer3 = ChoiceAnswer(0, "the way that offers You a change to learn at Your own pace.", true)
    val choice1 = ChoiceQuestion(0, None, "e-learning is...", "E-learning is...", "", Seq(choice1Answer1, choice1Answer2, choice1Answer3), false, Some(courseId), 1)
    val choice1ID = storageFactory.questionStorage.createAndGetID(choice1)

    val choice2Answer1 = ChoiceAnswer(0, "Correct.", false)
    val choice2Answer2 = ChoiceAnswer(0, "Incorrect.", true)
    val choice2 = ChoiceQuestion(0, None, "Word \"E-learning\"", "Word \"E-learning\" comes from \"Endless learning\".", "", Seq(choice2Answer1, choice2Answer2), false, Some(courseId), 2)
    val choice2ID = storageFactory.questionStorage.createAndGetID(choice2)

    val choice3Answer1 = ChoiceAnswer(0, "No. It is just gives You a different way to study.", true)
    val choice3Answer2 = ChoiceAnswer(0, "Yes. With E-learning it is easier to copy Your classmates answers.", false)
    val choice3 = ChoiceQuestion(0, None, "E-learning is easier", "E-learning is easier than traditional learning.", "", Seq(choice3Answer1, choice3Answer2), false, Some(courseId), 3)
    val choice3ID = storageFactory.questionStorage.createAndGetID(choice3)

    val quiz = Quiz(0, "E-learning test", "Demo quiz", "<p>Test yourself.</p>", "<p>Thank You.</p>", Some(courseId))
    val quizID = storageFactory.quizStorage.createAndGetID(quiz)
    storageFactory.quizQuestionStorage.createFromQuestionBankAndGetID(quizID, None, choice1ID)
    storageFactory.quizQuestionStorage.createFromQuestionBankAndGetID(quizID, None, choice2ID)
    storageFactory.quizQuestionStorage.createFromQuestionBankAndGetID(quizID, None, choice3ID)
  }

  protected def setupPortlet(layout: Layout, portletId: String, key: String, value: String) {
    val portletSetup = PortletPreferencesFactoryUtil.getLayoutPortletSetup(layout, portletId)
    portletSetup.setValue(key, value)
    portletSetup.store()
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
    setupPortlet(layout, portletId, "portletSetupShowBorders", "false")
  }

  protected def setCustomTitle(layout: Layout, portletId: String, title: String) {
    val portletSetup = PortletPreferencesFactoryUtil.getLayoutPortletSetup(layout, portletId)
    portletSetup.setValue("portletSetupUseCustomTitle", "true")
    portletSetup.setValue("portletSetupTitle_en_US", title)
    portletSetup.store()
  }

  def setPortletPreferences(layout: Layout, portletId: String, filename: String) {
    val portletSetup = PortletPreferencesFactoryUtil.getLayoutPortletSetup(layout, portletId)
    val definitions = XML.loadString(HookHelpers.getString(filename))
    (definitions \ "preference").foreach(defNode => {
      val word = (defNode \ "name").text.toString
      val description = (defNode \ "value").map(_.text.toString)
      if (description.size == 1) {
        portletSetup.setValue(word, description.headOption.getOrElse(""))
      } else {
        portletSetup.setValues(word, description.toArray)
      }
    })
    portletSetup.store()

  }

  protected def addLayout(group: Group, name: String,
                          isPublic: Boolean, friendlyURL: String, layoutTemplateId: String,
                          parent: Long = LayoutConstants.DEFAULT_PARENT_LAYOUT_ID) = {
    val serviceContext: ServiceContext = new ServiceContext
    val layout = LayoutLocalServiceUtil.addLayout(group.getCreatorUserId, group.getGroupId,
      !isPublic, parent,
      name, StringPool.BLANK, StringPool.BLANK, LayoutConstants.TYPE_PORTLET,
      false, friendlyURL, serviceContext)
    val layoutTypePortlet = layout.getLayoutType.asInstanceOf[LayoutTypePortlet]
    layoutTypePortlet.setLayoutTemplateId(0, layoutTemplateId, false)
    addResources(layout, PortletKeys.DOCKBAR)
    layout
  }

  protected def addResources(layout: Layout, portletId: String) {
    val rootPortletId = PortletConstants.getRootPortletId(portletId)
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

  protected def addJournalStructure(userId: Long, groupId: Long,
                                    title: String, filename: String, serviceContext: ServiceContext) = {
    val xsd = HookHelpers.getString(filename)

    JournalStructureLocalServiceUtil.addStructure(userId, groupId,
      title, true, StringPool.BLANK, Map(Locale.US -> title), null,
      xsd,
      serviceContext)
  }

  protected def addJournalTemplate(userId: Long, groupId: Long,
                                   title: String, filename: String, structureID: String,
                                   langType: String,
                                   serviceContext: ServiceContext) = {
    val xsl = HookHelpers.getString(filename)

    JournalTemplateLocalServiceUtil.addTemplate(userId, groupId,
      title, true, structureID, Map(Locale.US -> title), null,
      xsl, false, langType, true, false, StringPool.BLANK, null, serviceContext)
  }

  protected def addJournalArticle(userId: Long, groupId: Long,
                                  title: String, filename: String,
                                  structureId: String, templateId: String, serviceContext: ServiceContext): JournalArticle = {

    val content = HookHelpers.getString(filename)

    serviceContext.setAddGroupPermissions(true)
    serviceContext.setAddGuestPermissions(UpgradeProcess.isPublic)
    serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH)

    val journalArticle = JournalArticleLocalServiceUtil.addArticle(userId, groupId,
      0, 0, //classNameId, classPK,
      title.replaceAll(" ", "_"), //articleId,
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
}