package com.arcusys.learn.liferay.service

import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.liferay.portal.service.UserLocalServiceUtil
import com.liferay.portal.kernel.dao.orm.QueryUtil
import com.arcusys.scorm.lms.CertificateService
import com.liferay.portal.model.User
import java.net.URLEncoder
import com.arcusys.learn.scorm.tracking.model.certificating.CertificateValidStatus

/**
 * User: Yulia.Glushonkova
 * Date: 20.06.13
 */
class LiferayUserService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  val jsonModel = new JsonModelBuilder[User](user => {
    Map(
      "userID" -> user.getUserId,
      "name" -> user.getFullName,
      "email" -> user.getEmailAddress,
      "portrait" -> getPortrait(user),
      "userPublicPageUrl" -> getPublicUrl(user)
    )
  })

  val userWihCertificatesJsonModel = new JsonModelBuilder[User](user => {
    val service = new CertificateService();
    val userID = user.getUserId.toInt
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
          "logo" -> (if (certificate.get.logo == "") "/learn-web/img/certificate-default.png"
                  else "/learn-web/services/openbadges?directory=" + certificate.get.id + "&fileName=" + certificate.get.logo),
          "isPermanent" -> certificate.get.isPermanent,
          "expireDate" -> (if (validStatus.expireDate.isDefined) validStatus.expireDate.get.toString("yyyy-MM-dd") else "")

        ) else null
    }).filter(i=> i != null)

    Map(
      "userID" -> user.getUserId,
      "name" -> user.getFullName,
      "email" -> user.getEmailAddress,
      "portrait" -> getPortrait(user),
      "userPublicPageUrl" -> getPublicUrl(user),
      "certificates" -> userCertificates
    )
  })


  def getPortrait(user: User) = {
    "/image/user_male_portrait?img_id=" + user.getPortraitId
  }

  def getPublicUrl(user: User) = {
    if (user.getGroup().getPublicLayoutsPageCount() > 0) "/web/" + user.getScreenName else ""
  }

  get("/") {
    jsonModel(getUsers())
  }

  get("/:userID") {
    val userID = parameter("userID").intRequired
    val lfUser = UserLocalServiceUtil.getUser(userID)
    userWihCertificatesJsonModel(lfUser)
  }

  private def getUsers() = {
    // only students?
    UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS).toArray
      .map(x => x.asInstanceOf[com.liferay.portal.model.User])
      .sortBy(x => x.getFullName).filter(x => x.getFullName != "")
  }
}


