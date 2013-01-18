package com.arcusys.scorm.lms

import com.arcusys.learn.storage.impl.orbroker.StorageFactory
import com.liferay.portal.service.{RoleServiceUtil, RoleLocalServiceUtil, UserLocalServiceUtil}
import com.liferay.portal.model.{Role, User}

object UserManagement {

  private def getAllUserRoles(userID:Long, courseID:Long)={
    val roles = RoleLocalServiceUtil.getUserGroupRoles(userID,courseID)
    (for (i <- 0 to roles.size-1) yield roles.get(i))
  }
  def getStudentsWithAttemptsByCourseID(courseID:Long)={
    def getAllRawUsers={
      val users = UserLocalServiceUtil.getGroupUsers(courseID)
      (for (i <- 0 to users.size-1) yield users.get(i))}

    def getUsersByRole(roleName: String):IndexedSeq[com.arcusys.learn.scorm.tracking.model.User] = {
      val scormUsers = StorageFactory.attemptStorage.getUsersWithAttempts
      for {
        user:User <- getAllRawUsers
        role:Role <- getAllUserRoles(user.getUserId, courseID)
        if (role.getName.equals(roleName) && scormUsers.filter(scUser=> scUser.id ==user.getUserId).size>0)
      } yield scormUsers.filter(scUser=> scUser.id ==user.getUserId).head
    }

    getUsersByRole("Student").map(user => Map("id" -> user.id, "name" -> user.name))
  }

  def isStudent(userID: Long, courseID: Long) = {
    val roles = getAllUserRoles(userID, courseID)
    roles.filter(role => role.getName.equals("Student")).size > 0
  }
  def hasTeacherPermissions(userID: Long, courseID: Long) = {
    val roles = getAllUserRoles(userID, courseID)
    val isTeacher = roles.filter(role => role.getName.equals("Teacher")).size > 0
    if (isTeacher) true
    else isAdmin(userID, courseID)
  }
  def isAdmin(userID: Long, courseID: Long) = {
    val lfRoles = RoleServiceUtil.getUserRoles(userID)
    val roles = (for (i <- 0 to lfRoles.size-1) yield lfRoles.get(i))
    roles.filter(role => role.getName.equals("Administrator")).size > 0
  }

}
