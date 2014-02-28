package com.arcusys.learn.liferay.service

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.constants.QueryUtilHelper
import com.arcusys.scorm.lms.{AchievementRepositoryContract, CertificateService}
import com.arcusys.learn.scorm.tracking.model.certificating.CertificateValidStatus
import com.arcusys.learn.service.util.OpenBadgesHelper
import scala.collection.JavaConverters._
import com.arcusys.learn.models.AchievementModel
import com.arcusys.learn.models.Lms2PortletConverters._
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.liferay.services.OrganizationLocalServiceHelper
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.learn.liferay.LiferayClasses.LUser

/**
 * User: Yulia.Glushonkova
 * Date: 20.06.13
 */
class LiferayUserService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  val achievementRepository = inject[AchievementRepositoryContract]

  import storageFactory._

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  val userWihCertificatesJsonModel = new JsonModelBuilder[LUser](user => {
    val service = new CertificateService()
    val userID = user.getUserId.toInt
    val companyId = PortalUtilHelper.getCompanyId(request)
    val userCertificates = certificateUserStorage.getByUser(userID)
      .map(item => certificateStorage.getByID(item.certificateID))
      .filter(certificate => certificate.isDefined)
      .map(certificate => {
      val validStatus = service.passedCertificateHelper(certificate.get, userID)
      if (validStatus.status == CertificateValidStatus.Valid)
        Map(
          "id" -> certificate.get.id,
          "title" -> certificate.get.title,
          "description" -> certificate.get.description,
          "logo" -> (if (certificate.get.logo == "") "/learn-portlet/img/certificate-default.png"
          else "/learn-portlet/services/openbadges?directory=" + certificate.get.id + "&fileName=" + certificate.get.logo),
          "isPermanent" -> certificate.get.isPermanent,
          "expireDate" -> (if (validStatus.expireDate.isDefined) validStatus.expireDate.get.toString("yyyy-MM-dd") else "")
        )
      else null
    }).filter(i => i != null)

    // get open badges certificates
    val badges = OpenBadgesHelper.getOpenBadges(user.getEmailAddress).filterNot(i => {
      userCertificates.exists(c => c("title") == i("title"))
    })

    val completedAchievements: List[AchievementModel] = achievementRepository.getForUser(userID, companyId.toInt).filter(_.completed)

    Map(
      "userID" -> user.getUserId,
      "name" -> user.getFullName,
      "email" -> user.getEmailAddress,
      "portrait" -> getPortrait(user),
      "userPublicPageUrl" -> getPublicUrl(user),
      "certificates" -> (if (!badges.isEmpty) userCertificates.++(badges) else userCertificates),
      "achievements" -> completedAchievements
    )
  })


  def getPortrait(user: LUser) = {
    "/image/user_male_portrait?img_id=" + user.getPortraitId
  }

  def getPublicUrl(user: LUser) = {
    if (user.getGroup().getPublicLayoutsPageCount() > 0) "/web/" + user.getScreenName else ""
  }

  get("/") {
    val name = parameter("name").required
    val sort = parameter("sort").required
    val companyID = parameter("companyID").intRequired
    val skip = parameter("page").intRequired
    val take = parameter("count").intRequired
    val org = parameter("orgID").intRequired
    val module = parameter("module").required
    val moduleID = parameter("moduleID").intRequired

    val allUsers = getFilteredUsers(companyID, name, sort, org)

    val attachedUsersID = module match {
      case "ach" => achievementRepository.getUsers(moduleID, companyID).map(_.getUserId)
      case "cert" => certificateUserStorage.getByCertificate(moduleID).map(_.userID)
      case _ => List()
    }

    val notAttachedUsers = allUsers.filter(u => {
      !attachedUsersID.contains(u.getUserId)
    })

    val shownUsers = notAttachedUsers.drop((skip - 1) * take).take(take)

    json(Map(
      "total" -> notAttachedUsers.length,
      "currentPage" -> skip,
      "records" -> shownUsers.map(user =>
        Map(
          "userID" -> user.getUserId,
          "name" -> user.getFullName,
          "email" -> user.getEmailAddress,
          "portrait" -> getPortrait(user),
          "userPublicPageUrl" -> getPublicUrl(user)
        )
      )
    ))
  }

  get("/filters") {
    val orgs = OrganizationLocalServiceHelper.getOrganizations(QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS).asScala
    json(Map(
      "organizations" -> orgs.map(org =>
        Map(
          "orgID" -> org.getOrganizationId,
          "name" -> org.getName
        )
      )
    ))
  }

  get("/account/:userID") {
    val userID = parameter("userID").intRequired
    val lfUser = UserLocalServiceHelper.getUser(userID)


    userWihCertificatesJsonModel(lfUser)
  }


  private def getFilteredUsers(companyID: Int, name: String, sort: String, orgID: Int) = {
      val allUsers = UserLocalServiceHelper.getCompanyUsers(companyID, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS).asScala
        .filter(u => u.isActive && u.getFullName != "").sortBy(x => x.getFullName)
      val nameFiltered = allUsers.filter(x => x.getFullName.toLowerCase.contains(name.toLowerCase))
      val orgFiltered = if (orgID != -1) nameFiltered.filter(u => {
        u.getOrganizations.asScala.map(_.getOrganizationId).contains(orgID)
      })
      else nameFiltered
      val sorted = if (sort.equals("desc")) orgFiltered.reverse else orgFiltered

      sorted
  }
}


