package com.arcusys.learn.certificating

import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.liferay.portal.service._
import com.arcusys.scorm.lms._
import com.arcusys.learn.scorm.tracking.model.certificating.CertificateUser
import com.arcusys.learn.scorm.tracking.model.Course
import scala.Array
import com.arcusys.learn.scorm.tracking.model.Course
import com.arcusys.learn.scorm.tracking.model.certificating.CertificateUser

/**
 * User: Yulia.Glushonkova
 * Date: 19.06.13
 */

class LiferayUser(
  val id: Int,
  val certificateID: Int,
  val userID: Int,
  val name: String)


class CertificateUserService (configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._



  val jsonModel = new JsonModelBuilder[LiferayUser](user =>
    Map("id" -> user.id,
      "certificateID" -> user.certificateID,
      "userID" -> user.userID,
      "name" -> user.name)
  )


  val jsonCourseModel = new JsonModelBuilder[Course](node =>{
    val group = GroupLocalServiceUtil.getGroup(node.courseID)

    Map("siteID" -> node.courseID,
    "title" -> group.getName,
    "userID"-> node.userID,
    "comment"-> node.comment,
    "grade"-> node.grade,
    "url" -> group.getFriendlyURL
  )})

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }


  get("/:certificateID") {
    val certificateID = parameter("certificateID").intRequired
    jsonModel(
      certificateUserStorage.getByCertificate(certificateID).
        map(user => {
          val lfUser = UserLocalServiceUtil.getUser(user.userID)
          new LiferayUser(user.id, certificateID, user.userID, lfUser.getFullName)}).
        sortBy(user => user.name))
  }

  post("/addUser/:certificateID"){
    val certificateID = parameter("certificateID").intRequired
    val userID = parameter("userID").intRequired
    val companyID = parameter(("companyID")).intRequired
    val id = certificateUserStorage.createAndGetID(new CertificateUser(0, certificateID, userID))

    val studentRoleIDs = Array(RoleLocalServiceUtil.getRole(companyID, "Student").getRoleId)
    certificateSiteStorage.getByCertificate(certificateID).foreach(site =>
      {
        UserLocalServiceUtil.addGroupUsers(site.siteID, Array(userID.toLong))
        UserGroupRoleLocalServiceUtil.addUserGroupRoles(userID, site.siteID, studentRoleIDs)
      }
    )
    id
  }

  post("/removeUser/:certificateID"){
    val certificateID = parameter("certificateID").intRequired
    val userID = parameter("userID").intRequired
    certificateUserStorage.deleteUser(userID, certificateID)
  }

  post("/delete/:id"){
    val id = parameter("id").intRequired
    certificateUserStorage.delete(id)
  }

  private val packageService = new PackageService()

  get("/GetCertificateProgress/user/:userID/:certificateID"){
    val certificateID = parameter("certificateID").intRequired
    val userID = parameter("userID").intRequired
    val sites = certificateSiteStorage.getByCertificate(certificateID)
    jsonCourseModel(sites.map(item => {
      val course = courseStorage.get(item.siteID, userID)
      if (course.isDefined) course.get else new Course(item.siteID, userID, "","")
    }))

    /*val report =
      val reports = packageService.getPackagesWithAttemptsByCourseIDNoMap(courseID, userID).map(
        pack =>
          (new GradeReportGenerator).getForCurrentAttempt(userID, pack.id)
      ).filter(report => report != None).map(report => report.get)
      jsonModel(reports)

\

    report*/
  }

  get("/GetCourseGrade/user/:userID/:courseID"){
    val courseID = parameter("courseID").intRequired
    val userID = parameter("userID").intRequired
    val course = courseStorage.get(courseID, userID)

    jsonCourseModel(if (course.isDefined) course.get else new Course(courseID, userID, "",""))
  }
/*
  get("/GetDetailCertificateProgress/user/:userID/:certificateID"){
    val certificateID = parameter("certificateID").intRequired
    val userID = parameter("userID").intRequired
    val sites = certificateSiteStorage.getByCertificate(certificateID)

    //val packages = sites.map(item => packageService.getPackagesWithAttemptsByCourseIDNoMap(item.siteID, userID))
    jsonCourseModel(sites.map(item => {
      val course = courseStorage.get(item.siteID, userID)
      if (course.isDefined) course.get else new Course(item.siteID, userID, "","")
    }))

  }*/
}
