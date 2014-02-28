package com.arcusys.scorm.lms

import com.escalatesoft.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.scorm.tracking.model.PermissionType
import scala.collection.JavaConverters._
import com.arcusys.learn.liferay.services.{UserLocalServiceHelper, RoleLocalServiceHelper}
import com.arcusys.learn.liferay.LiferayClasses._

class UserManagement(implicit val bindingModule: BindingModule) extends Injectable {

  val storageFactory = inject[StorageFactoryContract]

  private def getAllUserRoles(userID: Long, courseID: Long) = {
    val groupRoles = RoleLocalServiceHelper.getUserGroupRoles(userID, courseID).asScala.toList
    val roles = RoleLocalServiceHelper.getUserRoles(userID).asScala.toList
    groupRoles ++ roles
  }

  def getStudentsWithAttemptsByCourseID(courseID: Long) = {
    def getAllRawUsers = {
      val users = UserLocalServiceHelper.getGroupUsers(courseID)
      for (i <- 0 to users.size - 1) yield users.get(i)
    }

    def getUsersByRole(roles: Seq[com.arcusys.learn.scorm.tracking.model.Role]): IndexedSeq[com.arcusys.learn.scorm.tracking.model.User] = {
      val scormUsers = storageFactory.userStorage.getUsersWithAttempts.filter(_ != null)
      for {
        user: LUser <- getAllRawUsers
        role: LRole <- getAllUserRoles(user.getUserId, courseID)
        if roles.exists(_.liferayRoleID == role.getRoleId) && scormUsers.count(scUser => scUser.id == user.getUserId) > 0
      } yield scormUsers.filter(scUser => scUser.id == user.getUserId).head
    }

    val studentRoles = storageFactory.roleStorage.getForPermission(PermissionType.Student)
    getUsersByRole(studentRoles).distinct.map(user => Map("id" -> user.id, "name" -> user.name))
  }

  def isLearnUser(userID: Long, courseID: Long) = {
    isStudent(userID, courseID) || hasTeacherPermissions(userID, courseID)
  }

  def isStudent(userID: Long, courseID: Long) = {
    val roles = getAllUserRoles(userID, courseID)
    val studentRoles = storageFactory.roleStorage.getForPermission(PermissionType.Student)
    //roles.find(_.getName.equalsIgnoreCase("student")).isDefined
    roles.exists(r => studentRoles.exists(_.liferayRoleID == r.getRoleId))
  }

  def hasTeacherPermissions(userId: Long, courseId: Long) = {
    if (isAdmin(userId, courseId)) true
    else{
      val roles = getAllUserRoles(userId, courseId)
      val teacherRoles = storageFactory.roleStorage.getForPermission(PermissionType.Teacher)
      val isTeacher = roles.exists(r => teacherRoles.exists(_.liferayRoleID == r.getRoleId))
      isTeacher
    }
  }

  def isAdmin(userID: Long, courseID: Long) = {
    val roles = getAllUserRoles(userID, courseID)
    roles.exists(_.getName.equalsIgnoreCase("administrator"))
  }

}
