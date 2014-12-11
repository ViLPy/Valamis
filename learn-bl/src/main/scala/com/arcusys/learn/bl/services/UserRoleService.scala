package com.arcusys.learn.bl.services

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.services.{ UserLocalServiceHelper, RoleLocalServiceHelper }
import com.arcusys.learn.scorm.tracking.model.PermissionType
import com.arcusys.learn.scorm.tracking.storage.{ RoleStorage, UserStorage }
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import scala.collection.JavaConverters._

//TODO: refactor, copy -  com.arcusys.scorm.lms.UserManagement
class UserRoleService(configuration: BindingModule) extends UserRoleServiceContract with Injectable {
  def this() = this(DomainConfiguration)
  implicit val bindingModule = configuration

  val userStorage = inject[UserStorage]
  val roleStorage = inject[RoleStorage]

  private def getAllUserRoles(userID: Long, courseID: Long) = {
    val groupRoles = RoleLocalServiceHelper.getUserGroupRoles(userID, courseID).asScala.toList
    val roles = RoleLocalServiceHelper.getUserRoles(userID).asScala.toList
    groupRoles ++ roles
  }

  override def getStudentsWithAttemptsByCourseID(courseID: Long) = {
    def getAllRawUsers = {
      val users = UserLocalServiceHelper().getGroupUsers(courseID)
      for (i <- 0 to users.size - 1) yield users.get(i)
    }

    def getUsersByRole(roles: Seq[com.arcusys.learn.scorm.tracking.model.Role]): IndexedSeq[com.arcusys.learn.scorm.tracking.model.User] = {
      val scormUsers = userStorage.getUsersWithAttempts.filter(_ != null)
      for {
        user: LUser <- getAllRawUsers
        role: LRole <- getAllUserRoles(user.getUserId, courseID)
        if roles.exists(_.liferayRoleID == role.getRoleId) && scormUsers.count(scUser => scUser.id == user.getUserId) > 0
      } yield scormUsers.filter(scUser => scUser.id == user.getUserId).head
    }

    val studentRoles = roleStorage.getForPermission(PermissionType.STUDENT)
    getUsersByRole(studentRoles).distinct.map(user => Map("id" -> user.id, "name" -> user.name))
  }

  override def isLearnUser(userID: Long, courseID: Long) = {
    isStudent(userID, courseID) || hasTeacherPermissions(userID, courseID)
  }

  override def isStudent(userID: Long, courseID: Long) = {
    val roles = getAllUserRoles(userID, courseID)
    val studentRoles = roleStorage.getForPermission(PermissionType.STUDENT)
    //roles.find(_.getName.equalsIgnoreCase("student")).isDefined
    roles.exists(r => studentRoles.exists(_.liferayRoleID == r.getRoleId))
  }

  override def hasTeacherPermissions(userId: Long, courseId: Long) = {
    if (isAdmin(userId, courseId)) true
    else {
      val roles = getAllUserRoles(userId, courseId)
      val teacherRoles = roleStorage.getForPermission(PermissionType.TEACHER)
      val isTeacher = roles.exists(r => teacherRoles.exists(_.liferayRoleID == r.getRoleId))
      isTeacher
    }
  }

  override def isAdmin(userID: Long, courseID: Long) = {
    val roles = getAllUserRoles(userID, courseID)
    roles.exists(_.getName.equalsIgnoreCase("administrator"))
  }
}
