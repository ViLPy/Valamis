package com.arcusys.learn.certificating

import com.arcusys.learn.scorm.tracking.model.certificating.{CertificateValidStatus, Certificate}
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.scorm.tracking.model.Course
import com.liferay.portal.service.{UserLocalServiceUtil, LayoutLocalServiceUtil, GroupLocalServiceUtil}
import com.liferay.portal.util.{LayoutTypePortletFactoryUtil, PortalUtil}
import com.arcusys.learn.service.util.SessionHandler
import org.scalatra.fileupload.FileUploadSupport
import org.joda.time.DateTime
import com.liferay.portal.NoSuchGroupException
import java.security.MessageDigest
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil
import com.arcusys.learn.settings.model.SettingType

class ExtendedCertificate(
                           val userID: Int,
                           val certificate: Certificate
                           )

class CertificateService(configuration: BindingModule) extends ServletBase(configuration) with FileUploadSupport {
  def this() = this(Configuration)

  import storageFactory._

  val jsonModel = new JsonModelBuilder[Certificate](certificate => {
    mapCertificate(certificate)
  })

  def mapCertificate(certificate: Certificate) = {
    Map("id" -> certificate.id,
      "description" -> certificate.description,
      "title" -> certificate.title,
      "sitesCount" -> certificateSiteStorage.getCount(certificate.id),
      "usersCount" -> certificateUserStorage.getCount(certificate.id),
      "isPermanent" -> certificate.isPermanent,
      "publishBadge" -> certificate.publishBadge,
      "logo" -> getLogo(certificate),
      "shortDescription"->certificate.shortDescription)
  }

  def getLogo(certificate: Certificate) = {
    (if (certificate.logo == "") "/learn-web/img/certificate-default.png"
    else "/learn-web/services/openbadges?directory=" + certificate.id + "&fileName=" + certificate.logo)
  }

  def jsonExtendedModel(i: ExtendedCertificate)={
    Map("id" -> i.certificate.id,
      "description" -> i.certificate.description,
      "title" -> i.certificate.title,
      "sitesCount" -> certificateSiteStorage.getCount(i.certificate.id),
      "usersCount" -> certificateUserStorage.getCount(i.certificate.id),
      "isMemberOf" -> certificateUserStorage.isUserMember(i.userID, i.certificate.id),
      "logo" -> getLogo(i.certificate))
  }


  def jsonCertificateWithSitesInfoModel(certificate: Certificate)={
    val userID = parameter("userID").intRequired
    val rootUrl = parameter("rootUrl").required
    val sites = certificateSiteStorage.getByCertificate(certificate.id).map(item => {
      val course = courseStorage.get(item.siteID, userID)

      Map("course" -> (if (course.isDefined) course.get else new Course(item.siteID, userID, "", "")),
        "arrangementIndex" -> item.arrangementIndex)
    }).map(item => {
      val course = item("course").asInstanceOf[Course]
      val result =
        try {
          val group = GroupLocalServiceUtil.getGroup(course.courseID)
          val groupID = group.getGroupId

          def getUrlHelper: String = {

            LayoutLocalServiceUtil.getLayouts(group.getGroupId, false).toArray.foreach(layout => {

              val layoutTypePortlet = LayoutTypePortletFactoryUtil.create(
                LayoutLocalServiceUtil.getFriendlyURLLayout(groupID, false, layout.asInstanceOf[com.liferay.portal.model.Layout].getFriendlyURL))
              val player = layoutTypePortlet.getPortletIds().toArray.find(portlet => portlet.asInstanceOf[String].startsWith("SCORMApplication"))

              if (player.isDefined) {
                val fullUrl = PortalUtil.getLayoutFullURL(groupID, player.get.toString)
                val parts = fullUrl.split("/")
                val result = if (parts.length > 2) fullUrl.replace(parts.tail.tail.head, rootUrl) else fullUrl
                return result
              }
            })
            return "http://" + rootUrl + "/web" + group.getFriendlyURL
          }

          Map("siteID" -> course.courseID,
            "title" -> group.getDescriptiveName,
            "userID" -> userID,
            "comment" -> course.comment,
            "grade" -> course.grade,
            "url" -> getUrlHelper,
            "arrangementIndex" -> item.get("arrangementIndex"),
            "description" -> group.getDescription.replace("\n", " ")
          )
        }
        catch {
          case e: NoSuchGroupException => {
            System.out.println("Liferay site " + course.courseID + " does not exists")
            null
          }
        }
      result
    }).filter(i => i != null).toList

    val validation = new com.arcusys.scorm.lms.CertificateService().passedCertificateHelper(certificate, userID)

    Map("id" -> certificate.id,
      "description" -> certificate.description,
      "title" -> certificate.title,
      "sites" -> sites,
      "logo" -> getLogo(certificate),
      "isTemporaryAndComplete" -> (!certificate.isPermanent && validation.status != CertificateValidStatus.Invalid),
      "isCompleteAndBadgeAvailable" -> (certificate.publishBadge && validation.status == CertificateValidStatus.Valid),
      "isExpired" -> (validation.status == CertificateValidStatus.Expired),
      "expireDate" -> (if (validation.expireDate.isDefined) validation.expireDate.get.toString("yyyy-MM-dd") else ""))
  }


  val jsonBadgeModel = new JsonModelBuilder[ExtendedCertificate](i => {
    val recipient = hashEmail(UserLocalServiceUtil.getUser(i.userID).getEmailAddress)
    val issuerName = settingStorage.getByKey(SettingType.IssuerName)
    val issuerOrganization = settingStorage.getByKey(SettingType.IssuerOrganization)
    val issuerUrl = settingStorage.getByKey(SettingType.IssuerURL)
    val rootUrl = parameter("rootUrl").required

    Map(
      "recipient" -> ("sha256$" + recipient),
      "issued_on" -> DateTime.now.toString("yyyy-MM-dd"),
      "badge" -> Map(
        "version" -> "1.0.0",
        "name" -> i.certificate.title,
        "image" ->
          (if (i.certificate.logo == "") "http://" + rootUrl + "/learn-web/img/certificate-default.png"
          else ("http://" + rootUrl + "/learn-web/services/openbadges?directory=" + i.certificate.id + "&fileName=" + i.certificate.logo)),
        "description" -> i.certificate.shortDescription.replaceAll("%20", " "),
        "criteria" -> ("http://" + rootUrl),
        "issuer" -> Map(
          "origin" -> (if (issuerUrl.isDefined) issuerUrl.get.value else ("http://" + rootUrl) ),
          "name" -> (if (issuerName.isDefined) issuerName.get.value else "" ),
          "org" -> (if (issuerOrganization.isDefined) issuerOrganization.get.value else "" ),
          "contact" -> "test@valamis.fi"
          )))
  })

  def hashEmail(email: String) = {
    val md = MessageDigest.getInstance("SHA-256")
    md.update(email.getBytes())
    bytesToHex(md.digest())
  }

  def bytesToHex(bytes: Array[Byte]) = {
    val result = new StringBuffer()
    bytes.foreach(byte => result.append(Integer.toString((byte & 0xff) + 0x100, 16).substring(1)))
    result.toString()
  }

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  get("/") {
    requireTeacherPermissions()
    val skip = parameter("page").intRequired
    val take = parameter("count").intRequired
    val filter = parameter("filter").withDefault("")
    val sortAZ = parameter("sortAZ").booleanRequired

    val page = certificateStorage.getPage((skip-1)*take, take, filter, sortAZ)
    val result = json(Map(
      "total" -> page.total,
      "currentPage"-> skip,
      "records" -> page.certificates.map(i => mapCertificate(i)).toList) )
    result
  }

  get("/availableForStudent/:userID") {
    val userID = parameter("userID").intRequired
    val skip = parameter("page").intRequired
    val take = parameter("count").intRequired
    val filter = parameter("filter").withDefault("")
    val sortAZ = parameter("sortAZ").booleanRequired

    val page = certificateStorage.getPage((skip-1)*take, take, filter, sortAZ)

    json(Map(
      "total" -> page.total,
      "currentPage"-> skip,
      "records" -> page.certificates.map(i => jsonExtendedModel(new ExtendedCertificate(userID, i))).toList) )
  }

  get("/:id") {
    requireTeacherPermissions()
    val id = parameter("id").intRequired
    jsonModel(certificateStorage.getByID(id))
  }

  post("/") {
    requireTeacherPermissions()

    val title = parameter("title").required
    val description = parameter("description").required
    val id = certificateStorage.createAndGetID(new Certificate(0, title, description))
    jsonModel(certificateStorage.getByID(id).get)
  }

  post("/update/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    val title = parameter("title").required
    val description = parameter("description").required
    val isPermanent = parameter("isPermanent").booleanRequired
    val publishBadge = parameter("publishBadge").booleanRequired
    val shortDescription = parameter("shortDescription").required
    val certificate = new Certificate(id, title, description, "", isPermanent, publishBadge, shortDescription)
    certificateStorage.modify(certificate)
  }

  post("/delete/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    certificateStorage.delete(id)

    SocialActivityLocalServiceUtil.deleteActivities(classOf[Certificate].getName, id)
  }


  get("/getByUser/:userID") {
    val userID = parameter("userID").intRequired

    if (!hasTeacherPermissions && userID != getSessionUserID) halt(401) // only teachers and admins can see result of other people

    //TODO: move skip-take logic to certificateUserStorage
    val skip = parameter("page").intRequired
    val take = parameter("count").intRequired
   // val filter = parameter("filter").withDefault("")
    //val sortAZ = parameter("sortAZ").booleanRequired

    val certificates = certificateUserStorage.getByUser(userID)
       .map(item => certificateStorage.getByID(item.certificateID))
       .filter(item => item.isDefined).map(item => item.get).sortBy(item => item.title.toLowerCase)

    val result = json(Map(
      "total" -> certificates.length,
      "currentPage"-> skip,
      "records" -> certificates.drop((skip-1) * take).take(take).reverse.map(i=>jsonCertificateWithSitesInfoModel(i) ).toList))
    result
  }

  get("/issueBadge/:userID/:certificateID") {
    val userID = parameter("userID").intRequired
    val certificateID = parameter("certificateID").intRequired
    jsonBadgeModel(new ExtendedCertificate(userID, certificateStorage.getByID(certificateID).get))
  }
}