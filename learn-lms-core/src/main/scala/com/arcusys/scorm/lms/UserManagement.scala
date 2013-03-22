package com.arcusys.scorm.lms

import com.liferay.portal.service.{RoleServiceUtil, RoleLocalServiceUtil, UserLocalServiceUtil}
import com.liferay.portal.model.{Role, User}
import org.scala_tools.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.storage.StorageFactoryContract

class UserManagement(implicit val bindingModule: BindingModule) extends Injectable {

  val storageFactory = inject[StorageFactoryContract]

  private def getAllUserRoles(userID: Long, courseID: Long) = {
    val groupRoles = RoleLocalServiceUtil.getUserGroupRoles(userID, courseID)
    val roles = RoleLocalServiceUtil.getUserRoles(userID)
    (for (i <- 0 to roles.size - 1) yield roles.get(i)) ++ (for (i <- 0 to groupRoles.size - 1) yield groupRoles.get(i))
  }

  def getStudentsWithAttemptsByCourseID(courseID: Long) = {
    def getAllRawUsers = {
      val users = UserLocalServiceUtil.getGroupUsers(courseID)
      (for (i <- 0 to users.size - 1) yield users.get(i))
    }

    def getUsersByRole(roleName: String): IndexedSeq[com.arcusys.learn.scorm.tracking.model.User] = {
      val scormUsers = storageFactory.attemptStorage.getUsersWithAttempts
      for {
        user: User <- getAllRawUsers
        role: Role <- getAllUserRoles(user.getUserId, courseID)
        if (role.getName.equals(roleName) && scormUsers.filter(scUser => scUser.id == user.getUserId).size > 0)
      } yield scormUsers.filter(scUser => scUser.id == user.getUserId).head
    }

    getUsersByRole("Student").map(user => Map("id" -> user.id, "name" -> user.name))
  }

  def isLearnUser(userID: Long, courseID: Long) = {
    isStudent(userID, courseID) || hasTeacherPermissions(userID, courseID)
  }

  def isStudent(userID: Long, courseID: Long) = {
    val roles = getAllUserRoles(userID, courseID)
    roles.find(_.getName.equalsIgnoreCase("student")).isDefined
  }

  def hasTeacherPermissions(userID: Long, courseID: Long) = {
    val roles = getAllUserRoles(userID, courseID)
    val isTeacher = roles.find(_.getName.equalsIgnoreCase("teacher")).isDefined
    if (isTeacher) true
    else isAdmin(userID, courseID)
  }

  def isAdmin(userID: Long, courseID: Long) = {
    val roles = getAllUserRoles(userID, courseID)
    roles.find(_.getName.equalsIgnoreCase("administrator")).isDefined
  }

}
