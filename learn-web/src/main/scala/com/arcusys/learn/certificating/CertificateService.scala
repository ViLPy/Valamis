package com.arcusys.learn.certificating

import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.scorm.tracking.model.Course
import com.liferay.portal.service.{LayoutLocalServiceUtil, GroupLocalServiceUtil}
import com.liferay.portal.util.{LayoutTypePortletFactoryUtil, PortalUtil}

class ExtendedCertificate(
                   val id: Int,
                   val description: String,
                   val title: String,
                   val userID: Int)

class CertificateService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  val jsonModel = new JsonModelBuilder[Certificate](certificate =>
    Map("id" -> certificate.id,
      "description" -> certificate.description,
      "title" -> certificate.title,
      "sitesCount"->certificateSiteStorage.getCount(certificate.id),
      "usersCount"->certificateUserStorage.getCount(certificate.id))
  )
  val jsonExtendedModel = new JsonModelBuilder[ExtendedCertificate](certificate =>
    Map("id" -> certificate.id,
      "description" -> certificate.description,
      "title" -> certificate.title,
      "sitesCount"->certificateSiteStorage.getCount(certificate.id),
      "usersCount"->certificateUserStorage.getCount(certificate.id),
      "isMemberOf"->certificateUserStorage.isUserMember(certificate.userID, certificate.id))
  )
  val jsonCertificateWithSitesInfoModel = new JsonModelBuilder[Certificate](certificate =>{
    val userID = parameter("userID").intRequired
    val rootUrl = parameter("rootUrl").required
    val sites = certificateSiteStorage.getByCertificate(certificate.id).map(item => {
      val course = courseStorage.get(item.siteID, userID)

      Map("course" -> (if (course.isDefined) course.get else new Course(item.siteID, userID, "","")),
          "arrangementIndex" -> item.arrangementIndex)
    }).map(item=> {
      val course = item("course").asInstanceOf[Course]
      val group = GroupLocalServiceUtil.getGroup(course.courseID)
      val groupID = group.getGroupId

      def getUrlHelper:String = {

      LayoutLocalServiceUtil.getLayouts(group.getGroupId, false).toArray.foreach(layout => {

        val layoutTypePortlet = LayoutTypePortletFactoryUtil.create(
          LayoutLocalServiceUtil.getFriendlyURLLayout(groupID, false, layout.asInstanceOf[com.liferay.portal.model.Layout].getFriendlyURL))
        val player = layoutTypePortlet.getPortletIds().toArray.find(portlet => portlet.asInstanceOf[String].startsWith("SCORMApplication"))

        if (player.isDefined)
        {
          val fullUrl = PortalUtil.getLayoutFullURL(groupID, player.get.toString)
          val parts = fullUrl.split("/")
          val result = if (parts.length > 2) fullUrl.replace(parts.tail.tail.head, rootUrl) else fullUrl
          return result
        }
      })
       return "http://" + rootUrl + "/web" + group.getFriendlyURL
      }

      Map ("siteID" -> course.courseID,
        "title" -> group.getName,
        "userID"-> userID,
        "comment"-> course.comment,
        "grade"-> course.grade,
        "url" -> getUrlHelper,
        "arrangementIndex" -> item.get("arrangementIndex"),
        "description" -> group.getDescription.replace("\n", " ")
      )}).toList

    Map("id" -> certificate.id,
        "description" -> certificate.description,
        "title" -> certificate.title,
        "sites" -> sites)}
  )

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  get("/") {
    jsonModel(certificateStorage.getAll)
  }

  get("/availableForStudent/:userID") {
    val userID = parameter("userID").intRequired
    jsonExtendedModel(certificateStorage.getAll.map(item => new ExtendedCertificate(item.id, item.description, item.title, userID)))
  }

  get("/:id") {
    val id = parameter("id").intRequired
    jsonModel(certificateStorage.getByID(id))
  }

  post("/") {
    val title = parameter("title").required
    val description = parameter("description").required
    val id = certificateStorage.createAndGetID(new Certificate(0, title, description))
    jsonModel(certificateStorage.getByID(id).get)
  }

  post("/update/:id") {
    val id = parameter("id").intRequired
    val title = parameter("title").required
    val description = parameter("description").required
    val certificate = new Certificate(id, title, description)
    certificateStorage.modify(certificate)
    jsonModel(certificate)
  }

  post("/delete/:id") {
    val id = parameter("id").intRequired
    certificateStorage.delete(id)
  }


  get("/getByUser/:userID"){
    val userID = parameter("userID").intRequired

    jsonCertificateWithSitesInfoModel(certificateUserStorage.getByUser(userID)
      .map(item => certificateStorage.getByID(item.certificateID))
      .filter(item => item.isDefined).map(item=>item.get))
  }
}