package com.arcusys.learn.certificating

import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.liferay.portal.service._
import com.arcusys.scorm.lms._
import com.arcusys.learn.scorm.tracking.model.{PermissionType, Course}
import com.arcusys.learn.scorm.tracking.model.certificating.CertificateUser
import com.arcusys.learn.service.util.SessionHandler
import com.liferay.portal.model.Group
import com.liferay.portal.NoSuchGroupException

/**
 * User: Yulia.Glushonkova
 * Date: 19.06.13
 */

class LiferayUser(
                   val id: Int,
                   val certificateID: Int,
                   val userID: Int,
                   val name: String,
                   val portrait: Long)


class CertificateUserService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._


  val jsonModel = new JsonModelBuilder[LiferayUser](user =>
    Map("id" -> user.id,
      "certificateID" -> user.certificateID,
      "userID" -> user.userID,
      "name" -> user.name,
      "portrait" -> ("/image/user_male_portrait?img_id=" + user.portrait))
  )

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }


  get("/:certificateID") {
    requireTeacherPermissions()

    val certificateID = parameter("certificateID").intRequired
    jsonModel(
      certificateUserStorage.getByCertificate(certificateID).
        map(user => {
        val lfUser = UserLocalServiceUtil.getUser(user.userID)
        new LiferayUser(user.id, certificateID, user.userID, lfUser.getFullName, lfUser.getPortraitId)
      }).
        sortBy(user => user.name))
  }

  post("/addUser") {
    val certificateID = parameter("certificateID").intRequired
    val userID = parameter("userID").intRequired
    if (!hasTeacherPermissions && userID != getSessionUserID) halt(401) // only teachers and admins can see result of other people

    val id = certificateUserStorage.createAndGetID(new CertificateUser(0, certificateID, userID))
    new com.arcusys.scorm.lms.CertificateService().addNewCertificateActivity(userID, certificateID)

    val studentRole = roleStorage.getDefault(PermissionType.Student)
    val studentRoleIDs = if (studentRole.isDefined) Array(studentRole.get.liferayRoleID.toLong) else Array[Long]()

    certificateSiteStorage.getByCertificate(certificateID).foreach(site => {
      try {
        UserLocalServiceUtil.addGroupUsers(site.siteID, Array(userID.toLong))
        UserGroupRoleLocalServiceUtil.addUserGroupRoles(userID, site.siteID, studentRoleIDs)
      }
      catch {
        case e: NoSuchGroupException => {
          System.out.println("Liferay site " + site.siteID + " does not exists")
        }
      }
    })

    val lfUser = UserLocalServiceUtil.getUser(userID)
    jsonModel(new LiferayUser(id, certificateID, userID, lfUser.getFullName, lfUser.getPortraitId))
  }

  post("/removeUser/:certificateID") {
    val certificateID = parameter("certificateID").intRequired
    val userID = parameter("userID").intRequired

    if (!hasTeacherPermissions && userID != getSessionUserID) halt(401) // only teachers and admins can see result of other people

    certificateUserStorage.deleteUser(userID, certificateID)
  }

  post("/delete/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    certificateUserStorage.delete(id)
  }


  get("/GetCertificateProgress/:userID/:certificateID") {
    requireTeacherPermissions()

    val certificateID = parameter("certificateID").intRequired
    val userID = parameter("userID").intRequired
    val sites = certificateSiteStorage.getByCertificate(certificateID)
    val rootUrl = parameter("rootUrl").withDefault("")


    val result = sites.map(item => {
      val course = courseStorage.get(item.siteID, userID)
      val data =
        try {
          Map("course" -> (if (course.isDefined) course.get else new Course(item.siteID, userID, "", "", None)),
            "lfGroup" -> GroupLocalServiceUtil.getGroup(item.siteID))
        }
        catch {
          case e: NoSuchGroupException => {
            System.out.println("Liferay site " + item.siteID + " does not exists")
            null
          }
        }
      data
    }).filter(i => i != null).map(i => {
      val course = i("course").asInstanceOf[Course]
      val group = i("lfGroup").asInstanceOf[Group]
      val publCount = LayoutLocalServiceUtil.getLayoutsCount(group,false)
      Map("siteID" -> course.courseID,
        "title" -> group.getDescriptiveName,
        "userID" -> course.userID,
        "comment" -> course.comment,
        "grade" -> course.grade,
        //"url" -> ("http://" + rootUrl + "/web" + group.getFriendlyURL)
        "url" -> (if(publCount == 0) "http://" + rootUrl + "/group" + group.getFriendlyURL else "http://" + rootUrl + "/web" + group.getFriendlyURL)
      )
    })
    json(result)
  }

  get("/GetCourseGrade/:userID/:courseID") {
    requireTeacherPermissions()

    val courseID = parameter("courseID").intRequired
    val userID = parameter("userID").intRequired
    val course = courseStorage.get(courseID, userID)

    json(Map("siteID" -> courseID,
      "userID" -> userID,
      "comment" -> (if (course.isDefined) course.get.comment else ""),
      "grade" -> (if (course.isDefined) course.get.grade else "")
    ))
  }
}
