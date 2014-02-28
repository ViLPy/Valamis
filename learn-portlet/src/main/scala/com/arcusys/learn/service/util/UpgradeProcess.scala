package com.arcusys.learn.service.util

import scala.collection.JavaConversions._
import java.util.{Calendar, Locale}
import java.util
import com.arcusys.learn.admin.service.UploadService
import com.arcusys.learn.scorm.tracking.model.PermissionType
import scala.util.Random
import com.arcusys.learn.storage.StorageFactoryContract
import scala.xml.XML
import scala.collection.JavaConverters._
import com.arcusys.learn.liferay.services._
import com.arcusys.learn.liferay.helpers.{HookHelpers, MessageBoardSupport, DocumentLibrarySupport, BlogHelpers}
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.util._
import com.arcusys.learn.liferay.constants._
import com.arcusys.learn.questionbank.model.ChoiceQuestion
import com.arcusys.learn.quiz.model.Quiz
import com.arcusys.learn.questionbank.model.ChoiceAnswer
import com.arcusys.learn.scorm.tracking.model.User
import com.arcusys.learn.scorm.tracking.model.Role

object UpgradeProcess {
  val isPublic = false
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
    val openId = StringPoolHelper.BLANK
    val locale = Locale.US
    val middleName = StringPoolHelper.BLANK
    val prefixId = 0
    val suffixId = 0
    val birthdayMonth = Calendar.JANUARY
    val birthdayDay = 1
    val birthdayYear = 1970

    val sevenCogsOrganization = OrganizationLocalServiceHelper.getOrganization(organizationID)

    val sendEmail = false

    val serviceContext = new LServiceContext()

    val createdUser = UserLocalServiceHelper.getUsers(-1, -1).find(_.getScreenName == screenName)
    val user = if (createdUser != None) {
      val foundUser = createdUser.get
      if (storageFactory.userStorage.getByID(foundUser.getUserId.toInt).isDefined) {
        storageFactory.userStorage.delete(foundUser.getUserId.toInt)
      }
      foundUser
    } else {
      UserLocalServiceHelper.addUser(
        creatorUserId, companyId, autoPassword, password1, password2,
        autoScreenName, screenName, emailAddress, facebookId, openId,
        locale, firstName, middleName, lastName, prefixId, suffixId, male,
        birthdayMonth, birthdayDay, birthdayYear, jobTitle, Array[Long](),
        Array[Long](), Array[Long](), Array[Long](), sendEmail, serviceContext)
    }

    UserLocalServiceHelper.addGroupUsers(sevenCogsOrganization.getGroupId, Array(user.getUserId))

    val portrait = HookHelpers.getBytes("demo/profile/" + screenName + ".jpg")

    UserLocalServiceHelper.updatePortrait(user.getUserId, portrait)

    val questions = StringUtilHelper.split(PropsUtilHelper.get("users.reminder.queries.questions"))

    val question = questions(0)
    val answer = "123"
    UserLocalServiceHelper.updateReminderQuery(user.getUserId, question, answer)
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
  final private val demoOrgName = "Valamis eLearning demo site"

  def doUpgrade() {
    System.out.println("Deploying private demo site")
    val companyId = PortalUtilHelper.getDefaultCompanyId
    val defaultUserId = UserLocalServiceHelper.getDefaultUserId(companyId)

    val companies = CompanyLocalServiceHelper.getCompanies
    for (company <- companies) {
      val companyID = company.getCompanyId
      val userID = UserLocalServiceHelper.getDefaultUserId(companyID)
      if (!RoleLocalServiceHelper.getRoles(companyID).exists(_.getName.equalsIgnoreCase("teacher"))) RoleLocalServiceHelper.addRole(userID, companyID, "Teacher", null, null, RoleConstantsHelper.TYPE_SITE)
      if (!RoleLocalServiceHelper.getRoles(companyID).exists(_.getName.equalsIgnoreCase("student"))) RoleLocalServiceHelper.addRole(userID, companyID, "Student", null, null, RoleConstantsHelper.TYPE_SITE)
    }

    try {
      val orgToDelete = OrganizationLocalServiceHelper.getOrganizations(-1, -1).asScala.filter(_.getName.equalsIgnoreCase(demoOrgName)) //.getOrganizationId(companyId, demoOrgName)
      orgToDelete.foreach(organization => {
        UserLocalServiceHelper.unsetOrganizationUsers(organization.getOrganizationId, UserLocalServiceHelper.getOrganizationUsers(organization.getOrganizationId).map(_.getUserId).toArray)
        OrganizationLocalServiceHelper.deleteOrganization(organization)
      })
    } catch {
      case e: Exception => {
        //setupOrganizations(companyId, defaultUserId)
      }
    }
    setupOrganizations(companyId, defaultUserId)
  }

  def setupOrganizations(companyId: Long, defaultUserId: Long) {
    val parentOrganizationId = OrganizationConstantsHelper.DEFAULT_PARENT_ORGANIZATION_ID
    val name = demoOrgName
    val organizationType = OrganizationConstantsHelper.TYPE_REGULAR_ORGANIZATION
    val recursable = true
    val regionId = 0
    val countryId = 0
    val statusId = GetterUtilHelper.getInteger(PropsUtilHelper.get("sql.data.com.liferay.portal.model.ListType.organization.status"))
    val comments = null

    val serviceContext: LServiceContext = new LServiceContext

    serviceContext.setAddGroupPermissions(true)
    serviceContext.setAddGuestPermissions(UpgradeProcess.isPublic)

    val organization = OrganizationLocalServiceHelper.addOrganization(defaultUserId, parentOrganizationId, name, organizationType, recursable, regionId, countryId, statusId, comments, true, serviceContext)

    // Group
    val group = organization.getGroup
    group.setTypeSettings("customJspServletContextName=valamis-learn-hook")
    GroupLocalServiceHelper.updateGroup(group)
    GroupLocalServiceHelper.updateFriendlyURL(group.getGroupId, "/learn-demo-hook-1.7")
    serviceContext.setScopeGroupId(group.getGroupId)

    // Layout set theme
    try {
      LayoutSetLocalServiceHelper.updateLookAndFeel(group.getGroupId, false, "valamislearntheme_WAR_valamislearntheme", "", "", false)
      LayoutSetLocalServiceHelper.updateLookAndFeel(group.getGroupId, true, "valamislearntheme_WAR_valamislearntheme", "", "", false)
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

    val portletLanding1 = addPortletId(layoutTheory, PortletKeysHelper.JOURNAL_CONTENT, "column-1")
    val journalArticle1 = addJournalArticle(defaultUserId, group.getGroupId,
      "WELCOME INFO", "demo/articles/landing1.xml",
      welcomeBoxStructure.getStructureId, welcomeBoxTemplate.getTemplateId,
      serviceContext)
    configureJournalContent(layoutTheory, group, portletLanding1, journalArticle1.getArticleId)
    removePortletBorder(layoutTheory, portletLanding1)

    // ------------
    val portletLanding3 = addPortletId(layoutTheory, PortletKeysHelper.JOURNAL_CONTENT, "column-3")

    val journalArticle3 = addJournalArticle(defaultUserId, group.getGroupId,
      "E-LEARNING TOOLS LINK", "demo/articles/landing3.xml",
      linkBoxStructure.getStructureId, linkBoxTemplate.getTemplateId,
      serviceContext)
    configureJournalContent(layoutTheory, group, portletLanding3, journalArticle3.getArticleId)
    removePortletBorder(layoutTheory, portletLanding3)

    val playerPortlet = addPortletId(layoutTheory, "SCORMApplication_WAR_learnportlet", "column-4")
    setCustomTitle(layoutTheory, playerPortlet, "Check out your latest material")

    val assetPublisher = addPortletId(layoutTheory, PortletKeysHelper.ASSET_PUBLISHER, "column-5")
    //LayoutLocalServiceHelper.importPortletInfo(defaultUserId, layoutTheory.getPrimaryKey, group.getGroupId, assetPublisher, Map[String, Array[String]](), Thread.currentThread().getContextClassLoader.getResourceAsStream("demo/settings/AssetPublisher.lar"))

    /*val topicsData = Map("mbMessage" -> ClassNameLocalServiceUtil.getClassNameId("com.liferay.portlet.messageboards.model.MBMessage").toString,
      "blogsEntry" -> ClassNameLocalServiceUtil.getClassNameId("com.liferay.portlet.blogs.model.BlogsEntry").toString)
    setPortletPreferences(layoutTheory,
      assetPublisher,
      "demo/settings/latest.topics.xml",
      topicsData)*/

    val activities = addPortletId(layoutTheory, PortletKeysHelper.ACTIVITIES, "column-6")
    setPortletPreferences(layoutTheory, activities, "demo/settings/activities.xml")


    val teacherID = RoleLocalServiceHelper.getRole(companyId, "Teacher").getRoleId
    val studentID = RoleLocalServiceHelper.getRole(companyId, "Student").getRoleId
    val teacherRoleIDs = Array(teacherID)
    val studentRoleIDs = Array(studentID)

    val studentMillaUser = addUser(organization.getOrganizationId, organization.getCompanyId, "milla.oppilas", "Milla", "Oppilas", false, "Student", studentRoleIDs)
    val studentOskuUser = addUser(organization.getOrganizationId, organization.getCompanyId, "osku.opiskelija", "Osku", "Opiskelija", true, "Student", studentRoleIDs)
    val teacherUser = addUser(organization.getOrganizationId, organization.getCompanyId, "olli.opettaja", "Olli", "Opettaja", true, "Teacher", teacherRoleIDs)

    UserGroupRoleLocalServiceHelper.addUserGroupRoles(studentMillaUser.getUserId, group.getGroupId, studentRoleIDs)
    UserGroupRoleLocalServiceHelper.addUserGroupRoles(studentOskuUser.getUserId, group.getGroupId, studentRoleIDs)
    UserGroupRoleLocalServiceHelper.addUserGroupRoles(teacherUser.getUserId, group.getGroupId, teacherRoleIDs)


    if (storageFactory.roleStorage.getForPermission(PermissionType.Student).find(_.liferayRoleID == studentID.toInt).isEmpty) {
      storageFactory.roleStorage.createAndGetID(new Role(0, RoleLocalServiceHelper.getRole(companyId, "Student").getRoleId.toInt, PermissionType.Student, false))
    }
    if (storageFactory.roleStorage.getForPermission(PermissionType.Teacher).find(_.liferayRoleID == teacherID.toInt).isEmpty) {
      storageFactory.roleStorage.createAndGetID(new Role(0, RoleLocalServiceHelper.getRole(companyId, "Teacher").getRoleId.toInt, PermissionType.Teacher, false))
    }

    PrincipalThreadLocalHelper.setName(teacherUser.getUserId)
    val permissionChecker = PermissionCheckerFactoryUtilHelper.create(teacherUser)
    PermissionThreadLocalHelper.setPermissionChecker(permissionChecker)

    val dlFolder = addDLFolder(teacherUser.getUserId, group.getGroupId,
      "Picures", "Picture related with the Learn Project", UpgradeProcess.isPublic)

    val discussion = addDLFileEntry(teacherUser.getUserId, dlFolder.getGroupId, dlFolder.getFolderId, "demo/documents/guys-discussion.1.jpg",
      "guys-discussion.1.jpg", "Discussion", "", serviceContext, UpgradeProcess.isPublic)

    val portletLanding2 = addPortletId(layoutTheory, PortletKeysHelper.JOURNAL_CONTENT, "column-2")

    val url = "/documents/" + discussion.getGroupId + "/" + discussion.getFolderId + "/" + discussion.getTitle

    val pictureContent = <root available-locales="en_US" default-locale="en_US">
      <dynamic-element instance-id="a71Lks8V" name="Picture" type="document_library" index-type=" ">
        <dynamic-content>
          {url}
        </dynamic-content>
      </dynamic-element>
    </root>

    val journalArticle2 = addJournalArticleWithContent(defaultUserId, group.getGroupId,
      "Discussion", pictureContent.toString(), pictureBoxStructure.getStructureId, pictureBoxTemplate.getTemplateId,
      serviceContext)

    //JournalArticleLocalServiceUtil.updateJournalArticle(journalArticle2)
    configureJournalContent(layoutTheory, group, portletLanding2, journalArticle2.getArticleId)
    removePortletBorder(layoutTheory, portletLanding2)


    val question = PollsQuestionLocalServiceHelper.addQuestion(teacherUser.getUserId,
      Map(Locale.US -> "Poll"), Map(Locale.US -> "Do you think we might be on to something?"), 1, 1, 2020, 1, 1, true, null, serviceContext)
    PollsChoiceLocalServiceHelper.addChoice(teacherUser.getUserId, question.getQuestionId, "a", "Yes definitely.", serviceContext)
    PollsChoiceLocalServiceHelper.addChoice(teacherUser.getUserId, question.getQuestionId, "b", "Maybe.", serviceContext)
    PollsChoiceLocalServiceHelper.addChoice(teacherUser.getUserId, question.getQuestionId, "c", "I think you have things to learn still.", serviceContext)
    val portletPolls = addPortletId(layoutTheory, PortletKeysHelper.POLLS_DISPLAY, "column-7")
    setupPortlet(layoutTheory, portletPolls, "questionId", question.getQuestionId.toString)

    // collaboration =================================
    val layoutCollaboration = addLayout(group, "Collaboration", UpgradeProcess.isPublic, "/collaboration", "2_columns_ii")

    val portletCollaborationAbout = addPortletId(layoutCollaboration, PortletKeysHelper.JOURNAL_CONTENT, "column-1")

    val articleCollaborationAbout = addJournalArticle(defaultUserId, group.getGroupId,
      "BLOG INFO", "demo/articles/blog.info.xml",
      welcomeBoxStructure.getStructureId, infoBoxTemplate.getTemplateId,
      serviceContext)
    configureJournalContent(layoutCollaboration, group, portletCollaborationAbout, articleCollaborationAbout.getArticleId)
    removePortletBorder(layoutCollaboration, portletCollaborationAbout)

    val blogs = addPortletId(layoutCollaboration, PortletKeysHelper.BLOGS, "column-2")
    //removePortletBorder(layoutCollaboration, blogs)

    addBlogsEntry(teacherUser.getUserId, "Finland and PISA (The Programme for International Student Assessment) survey.",
      "demo/blog/pisa.xml", serviceContext)

    val coffee = addDLFileEntry(teacherUser.getUserId, dlFolder.getGroupId, dlFolder.getFolderId, "demo/documents/coffee-tablet.jpg",
      "coffee-tablet.jpg", "Coffee tablet", "", serviceContext, UpgradeProcess.isPublic)
    val coffeeUrl = "/documents/" + coffee.getGroupId + "/" + coffee.getFolderId + "/" + coffee.getTitle
    addBlogsEntry(teacherUser.getUserId, "Lifelong learning",
      "demo/blog/lifelong.xml", serviceContext, Map("__coffee__" -> coffeeUrl))

    // discuss =================================
    val layoutDiscussion = addLayout(group, "Discuss", UpgradeProcess.isPublic, "/discuss", "2_columns_ii")

    val portletDiscussAbout = addPortletId(layoutDiscussion, PortletKeysHelper.JOURNAL_CONTENT, "column-1")

    val articleDiscussAbout = addJournalArticle(defaultUserId, group.getGroupId,
      "DISCUSS INFO", "demo/articles/discuss.info.xml",
      welcomeBoxStructure.getStructureId, infoBoxTemplate.getTemplateId,
      serviceContext)
    configureJournalContent(layoutDiscussion, group, portletDiscussAbout, articleDiscussAbout.getArticleId)
    removePortletBorder(layoutDiscussion, portletDiscussAbout)

    val mBoards = addPortletId(layoutDiscussion, PortletKeysHelper.MESSAGE_BOARDS, "column-2")
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
    addPortletId(layoutToolsQuestionbank, "SCORMQuestionBank_WAR_learnportlet", "column-2")

    val layoutToolsQuizEditor = addLayout(group, "Course designer", UpgradeProcess.isPublic, "/tools/quiz-editor", "2_columns_ii", layoutTools.getLayoutId)
    addToolsNavigationPortlet(layoutToolsQuizEditor)
    addSimpleJournalArticle(defaultUserId, group, layoutToolsQuizEditor, "Course designer", "demo/articles/quizedit.xml", "column-1", serviceContext)
    addPortletId(layoutToolsQuizEditor, "SCORMQuizes_WAR_learnportlet", "column-2")

    val layoutToolsAdmin = addLayout(group, "Admin tools", UpgradeProcess.isPublic, "/tools/admin-tools", "2_columns_ii", layoutTools.getLayoutId)
    addToolsNavigationPortlet(layoutToolsAdmin)
    addSimpleJournalArticle(defaultUserId, group, layoutToolsAdmin, "Admin tools", "demo/articles/admin.xml", "column-1", serviceContext)
    addPortletId(layoutToolsAdmin, "PackageManager_WAR_learnportlet", "column-2")

    val layoutToolsGradebook = addLayout(group, "Gradebook", UpgradeProcess.isPublic, "/tools/gradebook", "2_columns_ii", layoutTools.getLayoutId)
    addToolsNavigationPortlet(layoutToolsGradebook)
    addSimpleJournalArticle(defaultUserId, group, layoutToolsGradebook, "Gradebook", "demo/articles/gradebook.xml", "column-1", serviceContext)
    addPortletId(layoutToolsGradebook, "Gradebook_WAR_learnportlet", "column-2")

    val layoutToolsCurriculum = addLayout(group, "Curriculum", UpgradeProcess.isPublic, "/tools/curriculum", "2_columns_ii", layoutTools.getLayoutId)
    addToolsNavigationPortlet(layoutToolsCurriculum)
    addSimpleJournalArticle(defaultUserId, group, layoutToolsCurriculum, "Curriculum", "demo/articles/curriculum.xml", "column-1", serviceContext)
    addPortletId(layoutToolsCurriculum, "Curriculum_WAR_learnportlet", "column-2")

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

    /*val mbMessageIDs = MBMessageLocalServiceUtil.getMBMessages(-1, -1).asScala.map(_.getMessageId).asJava
    val blogIDs = BlogsEntryLocalServiceUtil.getBlogsEntries(-1, -1).asScala.map(_.getEntryId).asJava

    IndexerRegistryUtil.getIndexer(classOf[com.liferay.portlet.messageboards.model.MBMessage]).reindex(mbMessageIDs)
    IndexerRegistryUtil.getIndexer(classOf[com.liferay.portlet.blogs.model.BlogsEntry]).reindex(blogIDs)*/

    /*val luceneIndexer = new LuceneIndexer(companyId)
    luceneIndexer.reindex()*/
  }

  def addToolsNavigationPortlet(layout: LLayout) {
    val portlet = addPortletId(layout, "71", "column-1") // 71 - navigation portlet
    setPortletPreferences(layout, portlet, "demo/settings/navigation.xml")
  }

  def addSimpleJournalArticle(userID: Long, group: LGroup,
                              layout: LLayout, title: String, file: String, destination: String,
                              serviceContext: LServiceContext) {
    val portlet = addPortletId(layout, PortletKeysHelper.JOURNAL_CONTENT, destination)
    val article = addJournalArticle(userID, group.getGroupId, title, file, serviceContext)
    configureJournalContent(layout, group, portlet, article.getArticleId)
  }

  def addDefaultLayoutsByLAR(userId: Long, groupId: Long, privateLayout: Boolean, larFile: java.io.File) {
    val parameterMap = new util.HashMap[String, Array[String]]()

    parameterMap.put(PortletDataHandlerKeysHelper.PERMISSIONS, Array[String](true.toString))
    parameterMap.put(PortletDataHandlerKeysHelper.PORTLET_DATA, Array[String](true.toString))
    parameterMap.put(PortletDataHandlerKeysHelper.PORTLET_DATA_CONTROL_DEFAULT, Array[String](true.toString))
    parameterMap.put(PortletDataHandlerKeysHelper.PORTLET_SETUP, Array[String](true.toString))
    parameterMap.put(PortletDataHandlerKeysHelper.PERMISSIONS, Array[String](true.toString))

    LayoutLocalServiceHelper.importLayouts(userId, groupId, privateLayout, parameterMap, larFile)
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

  protected def setupPortlet(layout: LLayout, portletId: String, key: String, value: String) {
    val portletSetup = PortletPreferencesFactoryUtilHelper.getLayoutPortletSetup(layout, portletId)
    portletSetup.setValue(key, value)
    portletSetup.store()
  }

  protected def configureJournalContent(layout: LLayout, group: LGroup, portletId: String, articleId: String) {

    val portletSetup = PortletPreferencesFactoryUtilHelper.getLayoutPortletSetup(layout, portletId)

    if (group == null) {
      portletSetup.setValue("groupId", String.valueOf(layout.getGroupId))
    } else {
      portletSetup.setValue("groupId", String.valueOf(group.getGroupId))
    }
    portletSetup.setValue("articleId", articleId)

    portletSetup.store()
  }

  protected def removePortletBorder(layout: LLayout, portletId: String) {
    setupPortlet(layout, portletId, "portletSetupShowBorders", "false")
  }

  protected def setCustomTitle(layout: LLayout, portletId: String, title: String) {
    val portletSetup = PortletPreferencesFactoryUtilHelper.getLayoutPortletSetup(layout, portletId)
    portletSetup.setValue("portletSetupUseCustomTitle", "true")
    portletSetup.setValue("portletSetupTitle_en_US", title)
    portletSetup.store()
  }

  def setPortletPreferences(layout: LLayout, portletId: String, filename: String, data: Map[String, String] = Map()) {
    val portletSetup = PortletPreferencesFactoryUtilHelper.getLayoutPortletSetup(layout, portletId)
    val definitions = XML.loadString(HookHelpers.getString(filename))
    (definitions \ "preference").foreach(defNode => {
      val word = (defNode \ "name").text.toString
      val description = (defNode \ "value").map(_.text.toString)
      if (description.size == 1) {
        val value = description.headOption.getOrElse("")
        // replace #key# substring with value from data if needed
        portletSetup.setValue(word, data.foldLeft(value)((result, dataItem) => {
          result.replaceAll("#" + dataItem._1 + "#", dataItem._2)
        }))
      } else {
        // replace #key# substring with value from data if needed
        portletSetup.setValues(word, description.toArray.map(value => {
          data.foldLeft(value)((result, dataItem) => {
            result.replaceAll("#" + dataItem._1 + "#", dataItem._2)
          })
        }))
      }
    })
    portletSetup.store()

  }

  protected def addLayout(group: LGroup, name: String,
                          isPublic: Boolean, friendlyURL: String, layoutTemplateId: String,
                          parent: Long = LayoutConstantsHelper.DEFAULT_PARENT_LAYOUT_ID) = {
    val serviceContext: LServiceContext = new LServiceContext
    val layout = LayoutLocalServiceHelper.addLayout(group.getCreatorUserId, group.getGroupId,
      !isPublic, parent,
      name, StringPoolHelper.BLANK, StringPoolHelper.BLANK, LayoutConstantsHelper.TYPE_PORTLET,
      false, friendlyURL, serviceContext)
    val layoutTypePortlet = layout.getLayoutType.asInstanceOf[LLayoutTypePortlet]
    layoutTypePortlet.setLayoutTemplateId(0, layoutTemplateId, false)
    addResources(layout, PortletKeysHelper.DOCKBAR)
    layout
  }

  protected def addResources(layout: LLayout, portletId: String) {
    val rootPortletId = PortletConstantsHelper.getRootPortletId(portletId)
    val portletPrimaryKey = PortletPermissionUtilHelper.getPrimaryKey(layout.getPlid, portletId)
    ResourceLocalServiceHelper.addResources(layout.getCompanyId, layout.getGroupId, 0, rootPortletId, portletPrimaryKey, true, true, true)
  }

  protected def addPortletId(layout: LLayout, portletId: String, columnId: String) = {
    val layoutTypePortlet: LLayoutTypePortlet = layout.getLayoutType.asInstanceOf[LLayoutTypePortlet]
    val newPortletID = layoutTypePortlet.addPortletId(0, portletId, columnId, -1, false)
    addResources(layout, newPortletID)
    updateLayout(layout)
    newPortletID
  }

  protected def updateLayout(layout: LLayout) {
    LayoutLocalServiceHelper.updateLayout(layout.getGroupId, layout.isPrivateLayout, layout.getLayoutId, layout.getTypeSettings)
  }

  protected def addJournalArticle(userId: Long, groupId: Long, title: String, fileName: String, serviceContext: LServiceContext): LJournalArticle = {
    addJournalArticle(userId, groupId, title, fileName, StringPoolHelper.BLANK, StringPoolHelper.BLANK, serviceContext)
  }

  protected def addJournalStructure(userId: Long, groupId: Long,
                                    title: String, filename: String, serviceContext: LServiceContext) = {
    val xsd = HookHelpers.getString(filename)

    JournalStructureLocalServiceHelper.addStructure(userId, groupId,
      title, true, StringPoolHelper.BLANK, Map(Locale.US -> title), null,
      xsd,
      serviceContext)
  }

  protected def addJournalTemplate(userId: Long, groupId: Long,
                                   title: String, filename: String, structureID: String,
                                   langType: String,
                                   serviceContext: LServiceContext) = {
    val xsl = HookHelpers.getString(filename)

    JournalTemplateLocalServiceHelper.addTemplate(userId, groupId,
      title, true, structureID, Map(Locale.US -> title), null,
      xsl, false, langType, true, false, StringPoolHelper.BLANK, null, serviceContext)
  }

  protected def addJournalArticle(userId: Long, groupId: Long,
                                  title: String, filename: String,
                                  structureId: String, templateId: String, serviceContext: LServiceContext): LJournalArticle = {

    val content = HookHelpers.getString(filename)

    addJournalArticleWithContent(userId, groupId, title, content, structureId, templateId, serviceContext)
  }

  protected def addJournalArticleWithContent(userId: Long, groupId: Long,
                                             title: String, content: String,
                                             structureId: String, templateId: String, serviceContext: LServiceContext): LJournalArticle = {

    serviceContext.setAddGroupPermissions(true)
    serviceContext.setAddGuestPermissions(UpgradeProcess.isPublic)
    serviceContext.setWorkflowAction(WorkflowConstantsHelper.ACTION_PUBLISH)

    val journalArticle = JournalArticleLocalServiceHelper.addArticle(userId, groupId,
      0, 0, 0, //folderId, classNameId, classPK,
      title.replaceAll(" ", "_"), //articleId,
      false, //autoArticleId,
      JournalArticleConstantsHelper.VERSION_DEFAULT,
      Map(Locale.US -> title),
      null, //descriptionMap,
      content,
      "general", // type,
      structureId,
      templateId, // templateId,
      StringPoolHelper.BLANK, //layoutUuid,
      1, 1, 2013, 0, 0, // displayDateMonth, displayDateDay, displayDateYear,
      // displayDateHour, displayDateMinute,
      0, 0, 0, 0, 0, true, // expirationDateMonth, expirationDateDay,
      // expirationDateYear, expirationDateHour,
      //expirationDateMinute, neverExpire,
      0, 0, 0, 0, 0, true, // reviewDateMonth, reviewDateDay, reviewDateYear,
      //reviewDateHour, reviewDateMinute, neverReview,
      true, // indexable
      false, StringPoolHelper.BLANK, null, // smallImage, smallImageURL, smallImageFile,
      null, StringPoolHelper.BLANK, // images, articleURL,
      serviceContext)

    JournalArticleLocalServiceHelper.updateStatus(
      userId, groupId, journalArticle.getArticleId,
      journalArticle.getVersion, WorkflowConstantsHelper.STATUS_APPROVED,
      StringPoolHelper.BLANK, null, serviceContext)

    journalArticle
  }
}