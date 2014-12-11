package com.arcusys.learn.bl.utils

import java.util
import java.util.{ Calendar, Locale }

import com.arcusys.learn.bl.services.FileServiceContract
import com.arcusys.learn.bl.services.lesson.PackageUploadManager
import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants._
import com.arcusys.learn.liferay.helpers.{ BlogHelpers, DocumentLibrarySupport, HookHelpers, MessageBoardSupport }
import com.arcusys.learn.liferay.services._
import com.arcusys.learn.liferay.util._
import com.arcusys.learn.questionbank.model.{ CategorizationAnswer, ChoiceAnswer, ChoiceQuestion, EssayQuestion, _ }
import com.arcusys.learn.questionbank.storage.{ QuestionStorage, QuestionCategoryStorage }
import com.arcusys.learn.quiz.model.{ Quiz, QuizQuestionCategory }
import com.arcusys.learn.quiz.storage.{ QuizQuestionCategoryStorage, QuizQuestionStorage, QuizStorage }
import com.arcusys.learn.scorm.manifest.model.PeriodType
import com.arcusys.learn.scorm.tracking.model.certificating.models.CertificateActivitySettings
import com.arcusys.learn.scorm.certificating.{ CertificateActivitySettingsRepositoryContract, CertificateRepositoryContract }
import com.arcusys.learn.scorm.manifest.storage.ActivityStorage
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.arcusys.learn.scorm.tracking.model.{ PermissionType, Role, User }
import com.arcusys.learn.scorm.tracking.storage.{ AttemptStorage, DataModelStorage, RoleStorage, UserStorage }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil
import org.joda.time.DateTime

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import scala.util.Random
import scala.xml.XML

object UpgradeProcess {
  val isPublic = false
}

trait UserHelpers extends Injectable {

  implicit val bindingModule = DomainConfiguration
  private val userStorage = inject[UserStorage]
  private val roleStorage = inject[RoleStorage]

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

    val createdUser = UserLocalServiceHelper().getUsers(-1, -1).find(_.getScreenName == screenName)
    val user = if (createdUser != None) {
      val foundUser = createdUser.get
      if (userStorage.getByID(foundUser.getUserId.toInt).isDefined) {
        userStorage.delete(foundUser.getUserId.toInt)
      }
      foundUser
    } else {
      UserLocalServiceHelper().addUser(
        creatorUserId, companyId, autoPassword, password1, password2,
        autoScreenName, screenName, emailAddress, facebookId, openId,
        locale, firstName, middleName, lastName, prefixId, suffixId, male,
        birthdayMonth, birthdayDay, birthdayYear, jobTitle, Array[Long](),
        Array[Long](), Array[Long](), Array[Long](), sendEmail, serviceContext)
    }

    UserLocalServiceHelper().addGroupUsers(sevenCogsOrganization.getGroupId, Array(user.getUserId))

    val portrait = HookHelpers.getBytes("demo/profile/" + screenName + ".jpg")

    UserLocalServiceHelper().updatePortrait(user.getUserId, portrait)

    val questions = StringUtilHelper.split(PropsUtilHelper.get("users.reminder.queries.questions"))

    val question = questions(0)
    val answer = "123"
    UserLocalServiceHelper().updateReminderQuery(user.getUserId, question, answer)
    val userUID = user.getUserId
    if (userStorage.getByID(userUID.toInt).isEmpty) {
      userStorage.createAndGetID(User(userUID.toInt, user.getFullName))
    }
    user
  }
}

class UpgradeProcess(val fileFacade: FileServiceContract, packageUploadManager: PackageUploadManager, val configuration: BindingModule) extends UserHelpers with BlogHelpers
    with MessageBoardSupport with DocumentLibrarySupport with Injectable {
  final private val demoOrgName = "Valamis eLearning demo site"

  //implicit val bindingModule: BindingModule = configuration

  private lazy val certificateRepository = inject[CertificateRepositoryContract]
  private lazy val certificateToActivityRepository = inject[CertificateActivitySettingsRepositoryContract]
  private val roleStorage = inject[RoleStorage]
  private val activityRepository = inject[ActivityStorage]
  private val attemptStorage = inject[AttemptStorage]
  private val dataModelStorage = inject[DataModelStorage]
  private val questionStorage = inject[QuestionStorage]
  private val questionCategoryStorage = inject[QuestionCategoryStorage]
  private val quizQuestionCategoryStorage = inject[QuizQuestionCategoryStorage]
  private val quizQuestionStorage = inject[QuizQuestionStorage]
  private val quizStorage = inject[QuizStorage]

  def doUpgrade() {
    System.out.println("Deploying private demo site")
    val companyId = PortalUtilHelper.getDefaultCompanyId
    val defaultUserId = UserLocalServiceHelper().getDefaultUserId(companyId)

    val companies = CompanyLocalServiceHelper.getCompanies
    for (company <- companies) {
      val companyID = company.getCompanyId
      val userID = UserLocalServiceHelper().getDefaultUserId(companyID)
      if (!RoleLocalServiceHelper.getRoles(companyID).exists(_.getName.equalsIgnoreCase("teacher"))) RoleLocalServiceHelper.addRole(userID, companyID, "Teacher", null, null, RoleConstantsHelper.TYPE_SITE)
      if (!RoleLocalServiceHelper.getRoles(companyID).exists(_.getName.equalsIgnoreCase("student"))) RoleLocalServiceHelper.addRole(userID, companyID, "Student", null, null, RoleConstantsHelper.TYPE_SITE)
    }

    try {
      val orgToDelete = OrganizationLocalServiceHelper.getOrganizations(-1, -1).asScala.filter(_.getName.equalsIgnoreCase(demoOrgName)) //.getOrganizationId(companyId, demoOrgName)
      orgToDelete.foreach(organization => {
        UserLocalServiceHelper().unsetOrganizationUsers(organization.getOrganizationId, UserLocalServiceHelper().getOrganizationUsers(organization.getOrganizationId).map(_.getUserId).toArray)
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
      LayoutSetLocalServiceHelper.updateLookAndFeel(group.getGroupId, false, "valamistheme_WAR_valamistheme", "", "", false)
      LayoutSetLocalServiceHelper.updateLookAndFeel(group.getGroupId, true, "valamistheme_WAR_valamistheme", "", "", false)
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

    if (roleStorage.getForPermission(PermissionType.STUDENT).find(_.liferayRoleID == studentID.toInt).isEmpty) {
      roleStorage.createAndGetID(new Role(0, RoleLocalServiceHelper.getRole(companyId, "Student").getRoleId.toInt, PermissionType.STUDENT, false))
    }
    if (roleStorage.getForPermission(PermissionType.TEACHER).find(_.liferayRoleID == teacherID.toInt).isEmpty) {
      roleStorage.createAndGetID(new Role(0, RoleLocalServiceHelper.getRole(companyId, "Teacher").getRoleId.toInt, PermissionType.TEACHER, false))
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
                               { url }
                             </dynamic-content>
                           </dynamic-element>
                         </root>

    val journalArticle2 = addJournalArticleWithContent(defaultUserId, group.getGroupId,
      "Discussion", pictureContent.toString(), pictureBoxStructure.getStructureId, pictureBoxTemplate.getTemplateId,
      serviceContext)

    JournalArticleLocalServiceUtil.updateJournalArticle(journalArticle2)
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
    //removePortletBorder(layoutDiscussion, mBoards)

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
    val layoutTools = addLayout(group, "Tools", UpgradeProcess.isPublic, "/tools", "1_column")
    //addToolsNavigationPortlet(layoutTools)
    addSimpleJournalArticle(defaultUserId, group, layoutTools, "Tools", "demo/articles/tools.xml", "column-1", serviceContext)

    val layoutToolsQuestionbank = addLayout(group, "Question editor", UpgradeProcess.isPublic, "/tools/question-bank", "1_column", layoutTools.getLayoutId)
    //addToolsNavigationPortlet(layoutToolsQuestionbank)
    addPortletId(layoutToolsQuestionbank, "SCORMQuestionBank_WAR_learnportlet", "column-1")

    val layoutToolsQuizEditor = addLayout(group, "Course designer", UpgradeProcess.isPublic, "/tools/quiz-editor", "1_column", layoutTools.getLayoutId)
    //addToolsNavigationPortlet(layoutToolsQuizEditor)
    addPortletId(layoutToolsQuizEditor, "SCORMQuizes_WAR_learnportlet", "column-1")

    val layoutToolsAdmin = addLayout(group, "Admin tools", UpgradeProcess.isPublic, "/tools/admin-tools", "1_column", layoutTools.getLayoutId)
    //addToolsNavigationPortlet(layoutToolsAdmin)
    addPortletId(layoutToolsAdmin, "PackageManager_WAR_learnportlet", "column-1")

    val layoutToolsGradebook = addLayout(group, "Gradebook", UpgradeProcess.isPublic, "/tools/gradebook", "1_column", layoutTools.getLayoutId)
    //addToolsNavigationPortlet(layoutToolsGradebook)
    addPortletId(layoutToolsGradebook, "Gradebook_WAR_learnportlet", "column-1")

    val layoutToolsCurriculum = addLayout(group, "Curriculum", UpgradeProcess.isPublic, "/tools/curriculum", "1_column", layoutTools.getLayoutId)
    //addToolsNavigationPortlet(layoutToolsCurriculum)
    addPortletId(layoutToolsCurriculum, "Curriculum_WAR_learnportlet", "column-1")

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

    addCertificates(group.getGroupId.toInt, companyId.toInt)
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
      val activities = activityRepository.getAllFlat(packageId)
      val currentAttempt = attemptStorage.getLast(studentId.toInt, packageId).get
      for (activity <- activities) {
        if (activity.id.startsWith("question")) {
          dataModelStorage.setValue(currentAttempt.id, activity.id, "cmi.completion_status", "completed")
          dataModelStorage.setValue(currentAttempt.id, activity.id, "cmi.score.scaled", getRandomScaled._1) //0.0
          dataModelStorage.setValue(currentAttempt.id, activity.id, "cmi.success_status", getRandomScaled._2) // failed
        }
      }
      attemptStorage.markAsComplete(currentAttempt.id)
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
    val organizationId = activityRepository.getAllOrganizations(packageId).get(0).id
    studentIds.foreach(studentId => {
      attemptStorage.createAndGetID(studentId.toInt, packageId, organizationId)
    })
  }

  private def addCourse(title: String, summary: String, file: String, courseId: Long, userID: Long, groupID: Long) = {
    val stream = HookHelpers.getInputStream(file)
    val courseID = courseId
    //throw new NotImplementedException
    packageUploadManager.uploadPackage(title, summary, Some(courseID.toInt), userID, groupID, stream)
  }

  private def addCertificates(courseId: Int, companyId: Int) {
    val certificate1 = new Certificate(0, "Advanced Blogger", "User has written 6 blog posts.", companyId = companyId,
      createdAt = new DateTime, isPermanent = true, logo = "valamis-general-certi3.jpg", isPublished = true)
    val cert1ID = certificateRepository.create(certificate1).id
    certificateToActivityRepository.create(CertificateActivitySettings(cert1ID, "com.liferay.portlet.blogs.model.BlogsEntry", 6, Some(1), PeriodType.YEAR))

    //cert 2
    val certificate2 = new Certificate(0, "Advanced learner", "", companyId = companyId,
      createdAt = new DateTime, isPermanent = true, logo = "valamis-general-homppa2.jpg", isPublished = true)
    val cert2ID = certificateRepository.create(certificate2).id
    certificateToActivityRepository.create(CertificateActivitySettings(cert2ID, "com.liferay.portlet.blogs.model.BlogsEntry", 1, Some(1), PeriodType.MONTH))
    certificateToActivityRepository.create(CertificateActivitySettings(cert2ID, "com.liferay.portlet.documentlibrary.model.DLFileEntry", 1, Some(1), PeriodType.MONTH))
    certificateToActivityRepository.create(CertificateActivitySettings(cert2ID, "com.liferay.portlet.messageboards.model.MBMessage", 1, Some(1), PeriodType.MONTH))

    //cert 3
    val certificate3 = new Certificate(0, "Beginner Blogger", "User has written 3 blog posts.", companyId = companyId,
      createdAt = new DateTime, isPermanent = true, logo = "valamis-general-certi2.jpg", isPublished = true)
    val cert3ID = certificateRepository.create(certificate3).id
    certificateToActivityRepository.create(CertificateActivitySettings(cert3ID, "com.liferay.portlet.blogs.model.BlogsEntry", 3, Some(1), PeriodType.YEAR))

    //cert 4
    val certificate4 = new Certificate(0, "Collaboration ", "User can use collaboration tools.", companyId = companyId,
      createdAt = new DateTime, isPermanent = true, logo = "valamis-general-social3.jpg", isPublished = true)
    val cert4ID = certificateRepository.create(certificate4).id

    //cert 5
    val certificate5 = new Certificate(0, "Crisis Communication", "User has accomplished training.", companyId = companyId,
      createdAt = new DateTime, isPermanent = false, logo = "valamis-general-social1.jpg", validPeriodType = PeriodType.YEAR, validPeriod = 2, isPublished = true)
    val cert5ID = certificateRepository.create(certificate5).id
    certificateToActivityRepository.create(CertificateActivitySettings(cert5ID, "com.liferay.portlet.blogs.model.BlogsEntry", 5, Some(2), PeriodType.DAYS))

    //cert 6
    val certificate6 = new Certificate(0, "Customer Communication", "Description info", companyId = companyId,
      createdAt = new DateTime, isPermanent = true, logo = "valamis-general-social2.jpg", isPublished = true)
    val cert6ID = certificateRepository.create(certificate6).id
    certificateToActivityRepository.create(CertificateActivitySettings(cert6ID, "com.liferay.portlet.blogs.model.BlogsEntry", 3, Some(6), PeriodType.MONTH))
    certificateToActivityRepository.create(CertificateActivitySettings(cert6ID, "com.liferay.portlet.wiki.model.WikiPage", 1, Some(1), PeriodType.MONTH))

    //cert 7
    val certificate7 = new Certificate(0, "Employee of the Month", "Description info", companyId = companyId,
      createdAt = new DateTime, isPermanent = false, logo = "valamis-general-homppa1.jpg", validPeriodType = PeriodType.MONTH, validPeriod = 1)
    val cert7ID = certificateRepository.create(certificate7).id

    //cert 8
    val certificate8 = new Certificate(0, "Guru Blogger", "User has written 10 blog posts and has accomplished Writing for the Web lessons.", companyId = companyId,
      createdAt = new DateTime, isPermanent = true, logo = "valamis-general-certi1.jpg", isPublished = true)
    val cert8ID = certificateRepository.create(certificate8).id
    certificateToActivityRepository.create(CertificateActivitySettings(cert8ID, "com.liferay.portlet.blogs.model.BlogsEntry", 10, Some(1), PeriodType.YEAR))

    //cert 9
    val certificate9 = new Certificate(0, "Member of the Team", "User has accomplished orientation. ", companyId = companyId,
      createdAt = new DateTime, isPermanent = true, logo = "valamis-general-homppa3.jpg", isPublished = true)
    val cert9ID = certificateRepository.create(certificate9).id
    certificateToActivityRepository.create(CertificateActivitySettings(cert9ID, "com.liferay.portlet.blogs.model.BlogsEntry", 1, Some(1), PeriodType.DAYS))
    certificateToActivityRepository.create(CertificateActivitySettings(cert9ID, "com.liferay.calendar.model.CalendarBooking", 1, Some(0), PeriodType.DAYS))

    fileFacade.setFileContent(cert1ID.toString, "valamis-general-certi3.jpg", HookHelpers.getBytes("demo/documents/valamis-general-certi3.jpg"))
    fileFacade.setFileContent(cert2ID.toString, "valamis-general-homppa2.jpg", HookHelpers.getBytes("demo/documents/valamis-general-homppa2.jpg"))
    fileFacade.setFileContent(cert3ID.toString, "valamis-general-certi2.jpg", HookHelpers.getBytes("demo/documents/valamis-general-certi2.jpg"))
    fileFacade.setFileContent(cert4ID.toString, "valamis-general-social3.jpg", HookHelpers.getBytes("demo/documents/valamis-general-social3.jpg"))
    fileFacade.setFileContent(cert5ID.toString, "valamis-general-social1.jpg", HookHelpers.getBytes("demo/documents/valamis-general-social1.jpg"))
    fileFacade.setFileContent(cert6ID.toString, "valamis-general-social2.jpg", HookHelpers.getBytes("demo/documents/valamis-general-social2.jpg"))
    fileFacade.setFileContent(cert7ID.toString, "valamis-general-homppa1.jpg", HookHelpers.getBytes("demo/documents/valamis-general-homppa1.jpg"))
    fileFacade.setFileContent(cert8ID.toString, "valamis-general-certi1.jpg", HookHelpers.getBytes("demo/documents/valamis-general-certi1.jpg"))
    fileFacade.setFileContent(cert9ID.toString, "valamis-general-homppa3.jpg", HookHelpers.getBytes("demo/documents/valamis-general-homppa3.jpg"))
  }

  private def addQuestionsAndQuiz(courseId: Int) {
    val category1 = QuestionCategory(0, "Writing for the Web", "", None, Some(courseId), 1)
    val categoryID = questionCategoryStorage.createAndGetID(category1)

    val choice1Answer1 = ChoiceAnswer(0, "Easily scannable.", true)
    val choice1Answer2 = ChoiceAnswer(0, "Be relatable.", true)
    val choice1Answer3 = ChoiceAnswer(0, "Bureaucratic language.", false)
    val choice1 = ChoiceQuestion(0, Some(categoryID), "Good web content", "Good web content is:", "", Seq(choice1Answer1, choice1Answer2, choice1Answer3), false, Some(courseId), 1)
    val choice1ID = questionStorage.createAndGetID(choice1)

    val choice2Answer1 = ChoiceAnswer(0, "Correct.", true)
    val choice2Answer2 = ChoiceAnswer(0, "Incorrect.", false)
    val choice2 = ChoiceQuestion(0, Some(categoryID), "Active or Passive", "It is better to use Active Voice instead of Passive Voice.", "", Seq(choice2Answer1, choice2Answer2), false, Some(courseId), 2)
    val choice2ID = questionStorage.createAndGetID(choice2)

    //category 2
    val category2 = QuestionCategory(0, "Writing blogs", "", None, Some(courseId), 2)
    val category2ID = questionCategoryStorage.createAndGetID(category2)

    val essay = EssayQuestion(0, Some(category2ID), "Comments or not ", "Allow commenting on blogs, risks and benefits.", "", Some(courseId), 1)
    val essayID = questionStorage.createAndGetID(essay)

    val categorizationAnswer1 = CategorizationAnswer(0, "Show your personality", Some("Blog"))
    val categorizationAnswer2 = CategorizationAnswer(0, "Opinnions", Some("Blog"))
    val categorizationAnswer3 = CategorizationAnswer(0, "Don't show your personality", Some("Official text"))
    val categorizationAnswer4 = CategorizationAnswer(0, "Factual", Some("Official text"))
    val categorization = CategorizationQuestion(0, Some(category2ID), "Blog or Official text", "Place terms to correct boxes", "", Seq(categorizationAnswer1, categorizationAnswer2, categorizationAnswer3, categorizationAnswer4), Some(courseId), 2)
    val categorizationID = questionStorage.createAndGetID(categorization)

    val quiz = Quiz(0, "Finance Management", "A World of Numbers, short introduction. ", "", "", Some(courseId), "lesson_logo2.jpg", None)
    val quizID = quizStorage.createAndGetID(quiz)
    val quizCategory1 = QuizQuestionCategory(0, "Introduction", "", quizID, None, 1)
    val quizCategory2 = QuizQuestionCategory(0, "Chapter 1", "", quizID, None, 2)
    val quizCategory3 = QuizQuestionCategory(0, "Chapter 2", "", quizID, None, 3)
    quizQuestionCategoryStorage.createAndGetID(quizCategory1)
    quizQuestionCategoryStorage.createAndGetID(quizCategory2)
    quizQuestionCategoryStorage.createAndGetID(quizCategory3)

    val quiz2 = Quiz(0, "Welcome to our team", "Orientation.", "", "", Some(courseId), "lesson_logo4.jpg", None)
    val quiz2ID = quizStorage.createAndGetID(quiz2)
    val quiz2Category1 = QuizQuestionCategory(0, "Collaboration", "", quiz2ID, None, 1)
    val quiz2CategoryID = quizQuestionCategoryStorage.createAndGetID(quiz2Category1)
    quizQuestionStorage.createPlainAndGetID(quiz2ID, Option(quiz2CategoryID), "Orientation", "\n        Open and live communication are significant to us. That's why we have several communication tools. Take a look of those and participate.<ul>\t<li>Skype, for quick messages or meetings</li>\t<li>Valamis, for learning and collaboration</li>\t<li>Yammer, when you want to say something to everyone</li>\t<li>Google Hangouts, for live meetings</li></ul><script src=\"/learn-portlet/js2.0/vendor/tincan-min.js\"> </script><script type=\"text/javascript\">    (function() {        var hostUrl = document.location.protocol   \"//\"   document.location.host;        var contentId = '11667';        var contentTitle = 'Orientation';        var userId = 10201;        var userName = 'Joe Bloggs';        var userEmail = 'test@liferay.com';        var verbId = 'http://adlnet.gov/expapi/verbs/'   'attempted';        var verbName = 'attempted';        var createLrsClient = function(endpointSettings){            if(endpointSettings.internal) {                var localEndpoint = hostUrl   '/learn-portlet/TincanApi/';                return new TinCan.LRS({                    endpoint: localEndpoint,                    version: '1.0'                });            } else if (endpointSettings.authType == \"Basic\") {                if (endpointSettings.auth) {                    return new TinCan.LRS({                        endpoint: endpointSettings.endpoint,                        version: \"1.0\",                        auth: endpointSettings.auth                    });                }            } else if (endpointSettings.authType === \"OAuth\") {                if (endpointSettings.auth) {                    return new TinCan.LRS({                        endpoint: endpointSettings.endpoint,                        version: \"1.0\",                        auth: endpointSettings.auth,                        clientSecret: endpointSettings.clientSecret                    });                }            }        }        var createStatement = function(){            return new TinCan.Statement({                actor: new TinCan.Agent({id: userId, name: userName, mbox: userEmail}),                verb: new TinCan.Verb({                    id: verbId,                    display : { \"en-US\" : verbName}                }),                target: new TinCan.Activity({                    id: hostUrl   '/'   contentId,                    definition:new TinCan.ActivityDefinition({                        type: 'http://example.com/liferay_webcontent',                        name: {'en-US': contentTitle}  //need to all or current lang                    })}),                result: new TinCan.Result({completion: true}),                context: new TinCan.Context()            }, true);        };        var readTincanLrsSettings = function(callback){            var request = new XMLHttpRequest();            request.open('GET', '/learn-portlet/services/administering/TincanLrsSettings', true);            request.onreadystatechange = function() {                if (this.readyState === 4){                    if (this.status >= 200 && this.status < 400){                        var data = this.responseText;                        if (data) data = JSON.parse(data);                        else data = {internal:true}                        callback(data);                    } else {                        console.log(\"ERROR\");                    }                }            };            request.send();            request = null;        }        readTincanLrsSettings(function(endpointSettings){            var lrsClient = createLrsClient(endpointSettings);            if (!lrsClient) return;            var tinCanClient = new TinCan();            tinCanClient.recordStores[0] = lrsClient;            var statement = createStatement();            tinCanClient.sendStatement(createStatement(), function() {});        });    })();</script>")

    val quiz3 = Quiz(0, "Writing for the Web", "Learn how to write web texts.", "", "", Some(courseId), "lesson_logo3.jpg", None)
    val quiz3ID = quizStorage.createAndGetID(quiz3)
    val quiz3Category1 = QuizQuestionCategory(0, "Introduction", "", quiz3ID, None, 1)
    val quiz3Category2 = QuizQuestionCategory(0, "HTML5 Presentation", "", quiz3ID, None, 2)
    val quiz3Category3 = QuizQuestionCategory(0, "Test Yourself", "", quiz3ID, None, 3)
    val quiz3Category4 = QuizQuestionCategory(0, "HTML5 Presentation", "", quiz3ID, None, 4)
    val quiz3Category5 = QuizQuestionCategory(0, "Test Yourself, blogs", "", quiz3ID, None, 5)

    val quiz3Category1ID = quizQuestionCategoryStorage.createAndGetID(quiz3Category1)
    val quiz3Category2ID = quizQuestionCategoryStorage.createAndGetID(quiz3Category2)
    val quiz3Category3ID = quizQuestionCategoryStorage.createAndGetID(quiz3Category3)
    val quiz3Category4ID = quizQuestionCategoryStorage.createAndGetID(quiz3Category4)
    val quiz3Category5ID = quizQuestionCategoryStorage.createAndGetID(quiz3Category5)

    // add question to quiz 3
    quizQuestionStorage.createPlainAndGetID(quiz3ID, Option(quiz3Category1ID), "Introduction", "\n        Writing for the web is different than writing paper text. In this lesson you will find out how to write good web content.<script src=\"/learn-portlet/js2.0/vendor/tincan-min.js\"> </script><script type=\"text/javascript\">    (function() {        var hostUrl = document.location.protocol   \"//\"   document.location.host;        var contentId = '11803';        var contentTitle = 'Introduction';        var userId = 10201;        var userName = 'Joe Bloggs';        var userEmail = 'test@liferay.com';        var verbId = 'http://adlnet.gov/expapi/verbs/'   'attempted';        var verbName = 'attempted';        var createLrsClient = function(endpointSettings){            if(endpointSettings.internal) {                var localEndpoint = hostUrl   '/learn-portlet/TincanApi/';                return new TinCan.LRS({                    endpoint: localEndpoint,                    version: '1.0'                });            } else if (endpointSettings.authType == \"Basic\") {                if (endpointSettings.auth) {                    return new TinCan.LRS({                        endpoint: endpointSettings.endpoint,                        version: \"1.0\",                        auth: endpointSettings.auth                    });                }            } else if (endpointSettings.authType === \"OAuth\") {                if (endpointSettings.auth) {                    return new TinCan.LRS({                        endpoint: endpointSettings.endpoint,                        version: \"1.0\",                        auth: endpointSettings.auth,                        clientSecret: endpointSettings.clientSecret                    });                }            }        }        var createStatement = function(){            return new TinCan.Statement({                actor: new TinCan.Agent({id: userId, name: userName, mbox: userEmail}),                verb: new TinCan.Verb({                    id: verbId,                    display : { \"en-US\" : verbName}                }),                target: new TinCan.Activity({                    id: hostUrl   '/'   contentId,                    definition:new TinCan.ActivityDefinition({                        type: 'http://example.com/liferay_webcontent',                        name: {'en-US': contentTitle}  //need to all or current lang                    })}),                result: new TinCan.Result({completion: true}),                context: new TinCan.Context()            }, true);        };        var readTincanLrsSettings = function(callback){            var request = new XMLHttpRequest();            request.open('GET', '/learn-portlet/services/administering/TincanLrsSettings', true);            request.onreadystatechange = function() {                if (this.readyState === 4){                    if (this.status >= 200 && this.status < 400){                        var data = this.responseText;                        if (data) data = JSON.parse(data);                        else data = {internal:true}                        callback(data);                    } else {                        console.log(\"ERROR\");                    }                }            };            request.send();            request = null;        }        readTincanLrsSettings(function(endpointSettings){            var lrsClient = createLrsClient(endpointSettings);            if (!lrsClient) return;            var tinCanClient = new TinCan();            tinCanClient.recordStores[0] = lrsClient;            var statement = createStatement();            tinCanClient.sendStatement(createStatement(), function() {});        });    })();</script>")
    quizQuestionStorage.createRevealAndGetID(quiz3ID, Option(quiz3Category2ID), "Writing for the Web", "<div class=\"slides\">\n    <section class=\"stack\" data-id=\"855f55ef863cdc250551eeb54caa573c\">\n        <section class=\"\" data-id=\"59707413d492a622c9603f81935bcba3\" data-background-color=\"rgba( 22, 213, 75, 0.6 )\">\n            <h1>Writing for the Web</h1>\n            <img src=\"https://s3.amazonaws.com/media-p.slid.es/uploads/maura/images/487627/writing2.png\">\n        </section>\n        <section class=\"\" data-id=\"5af268d153e8794950345f7505ebeceb\">\n            <h2>Paper text</h2>\n            <div>\n                <br>\n            </div>\n            <div>\n                <br>\n            </div>\n            <div>Read thoroughly.</div>\n            <div>Wordy.</div>\n            <div>&nbsp;Visuality doesn't matter so much.</div>\n            <div>Lack of communication.</div>\n        </section>\n    </section>\n    <section class=\"\" data-id=\"17761c9ad3e3a8de0ec7cc1fff535497\">\n        <h2>Web text</h2>\n        <div>\n            <br>\n        </div>\n        <div>\n            <br>\n        </div>\n        <div>Skim and Scan.</div>\n        <div>Summarized.</div>\n        <div>Visuality really important.</div>\n        <div>Possibility of communication.</div>\n    </section>\n    <section class=\"\" data-id=\"4cf0fd590a1a63784928e329fcb46fbc\">\n        <h2>Rule # 1</h2>\n        <div>\n            <br>\n        </div>\n        <div>\n            <br>\n        </div>\n        <div>Summarize.</div>\n        <div>Get to the point and</div>\n        <div>review.&nbsp;</div>\n    </section>\n    <section class=\"\" data-id=\"716df3c3a49429aeaef4e7e496a624d8\">\n        <h2>Rule # 2</h2>\n        <div>\n            <br>\n        </div>\n        <div>\n            <br>\n        </div>\n        <div>Read what you wrote.</div>\n        <div>Simple words helps all.</div>\n        <div>\n            <br>\n        </div>\n    </section>\n</div>")
    quizQuestionStorage.createFromQuestionBankAndGetID(quiz3ID, Option(quiz3Category3ID), choice2ID)
    quizQuestionStorage.createFromQuestionBankAndGetID(quiz3ID, Option(quiz3Category3ID), choice1ID)
    quizQuestionStorage.createRevealAndGetID(quiz3ID, Option(quiz3Category4ID), "Writing for the Web", "<div class=\"slides\">\n    <section class=\"stack\" data-id=\"4a2c1b11fe888a9945bc638e30660a91\">\n        <section class=\"\" data-id=\"3dfa3b21a609456322d2d68f647d6258\">\n            <h1>It's a Blog time</h1>\n            <div>\n                <br>\n            </div>\n            <div>\n                <br>\n            </div>\n            <img src=\"https://s3.amazonaws.com/media-p.slid.es/uploads/maura/images/488072/blog.jpg\" class=\"absolute-element\" style=\"position: absolute; max-height: none; max-width: none; width: 508px; height: 314px; z-index: 4; left: 211px; top: 281px;\">\n        </section>\n        <section class=\"\" data-id=\"ccdb0f9581c7aca2f1ec187b814d9e96\">\n            <h2>Blog&nbsp;</h2>\n            <div>\n                <br>\n            </div>\n            <div>\n                <br>\n            </div>\n            <div>\n                <div style=\"font-size: 28px; font-style: normal; font-variant: normal;\">Use personal touch and style.</div>\n                <div style=\"font-size: 28px; font-style: normal; font-variant: normal;\">Tell your ideas and opinions.</div>\n            </div>\n        </section>\n        <section class=\"\" data-id=\"56f1ff0d8bc756462578ac5514e17158\">\n            <h2>\n                <span style=\"font-size: 32px; font-style: normal; font-variant: normal; font-weight: bold;\">\n                    <br>\n                </span>\n            </h2>\n            <h2>\n                <span style=\"font-size: 32px; font-style: normal; font-variant: normal; font-weight: bold;\">\n                    <br>\n                </span>\n            </h2>\n            <h2>\n                <span style=\"font-size: 32px; font-style: normal; font-variant: normal; font-weight: bold;\">\n                    <br>\n                </span>\n            </h2>\n            <h2>\n                <span style=\"font-size: 32px; font-style: normal; font-variant: normal; font-weight: bold;\">\n                    <br>\n                </span>\n            </h2>\n            <h2>\n                <span style=\"font-size: 32px; font-style: normal; font-variant: normal; font-weight: bold;\">\n                    <br>\n                </span>\n            </h2>\n            <h2>\n                <span style=\"font-size: 32px; font-style: normal; font-variant: normal; font-weight: bold;\">SHOW YOUR PASSION.</span>\n                <br>\n            </h2>\n        </section>\n        <section class=\"\" data-id=\"178f58f72eb1aed031703bf59e89307f\">\n            <h2>Activity</h2>\n            <div>\n                <br>\n            </div>\n            <div>\n                <br>\n            </div>\n            <div>Write regularly.</div>\n            <div>Courage readers to take a part.</div>\n            <div>Respect every comment.</div>\n            <div>Read and comment other blogs.</div>\n            <div>\n                <br>\n            </div>\n            <div>\n                <br>\n            </div>\n            <div>\n                <br>\n            </div>\n            <div>\n                <br>\n            </div>\n            <div>\n                <br>\n            </div>\n        </section>\n    </section>\n    <section class=\"\" data-id=\"78f022a89b793d981ad0488faa9cb89d\">\n        <h2>\n            <br>\n        </h2>\n        <div>\n            <span style=\"font-size: 32px; font-style: normal; font-variant: normal; font-weight: bold; text-transform: uppercase;\">\n                <br>\n            </span>\n        </div>\n        <div>\n            <span style=\"font-size: 32px; font-style: normal; font-variant: normal; font-weight: bold; text-transform: uppercase;\">\n                <br>\n            </span>\n        </div>\n        <div>\n            <span style=\"font-size: 32px; font-style: normal; font-variant: normal; font-weight: bold; text-transform: uppercase;\">\n                <br>\n            </span>\n        </div>\n        <div>\n            <span style=\"font-size: 32px; font-style: normal; font-variant: normal; font-weight: bold; text-transform: uppercase;\">\n                <br>\n            </span>\n        </div>\n        <div>\n            <span style=\"font-size: 32px; font-style: normal; font-variant: normal; font-weight: bold; text-transform: uppercase;\">\n                <br>\n            </span>\n        </div>\n        <h2 style=\"font-style: normal; font-variant: normal;\">BE A PART OF BLOGOSPHERE.</h2>\n        <div>\n            <br>\n        </div>\n    </section>\n</div>")
    quizQuestionStorage.createFromQuestionBankAndGetID(quiz3ID, Option(quiz3Category5ID), categorizationID)
    quizQuestionStorage.createFromQuestionBankAndGetID(quiz3ID, Option(quiz3Category5ID), essayID)

    // quiz 4
    val quiz4 = Quiz(0, "Your own lesson", "Create your own lessons", "", "", Some(courseId), "lesson_logo1.jpg", None)
    val quiz4ID = quizStorage.createAndGetID(quiz4)

    // set pictures
    fileFacade.setFileContent("quiz_logo_" + quizID, "lesson_logo2.jpg", HookHelpers.getBytes("demo/documents/lesson_logo2.jpg"))
    fileFacade.setFileContent("quiz_logo_" + quiz2ID, "lesson_logo4.jpg", HookHelpers.getBytes("demo/documents/lesson_logo4.jpg"))
    fileFacade.setFileContent("quiz_logo_" + quiz3ID, "lesson_logo3.jpg", HookHelpers.getBytes("demo/documents/lesson_logo3.jpg"))
    fileFacade.setFileContent("quiz_logo_" + quiz4ID, "lesson_logo1.jpg", HookHelpers.getBytes("demo/documents/lesson_logo1.jpg"))
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