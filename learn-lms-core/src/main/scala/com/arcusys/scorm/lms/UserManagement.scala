package com.arcusys.scorm.lms

import com.liferay.portal.service.{RoleLocalServiceUtil, UserLocalServiceUtil}
import com.liferay.portal.model.{Role, User}
import org.scala_tools.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.scorm.tracking.model.PermissionType

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

    def getUsersByRole(roles: Seq[com.arcusys.learn.scorm.tracking.model.Role]): IndexedSeq[com.arcusys.learn.scorm.tracking.model.User] = {
      val scormUsers = storageFactory.userStorage.getUsersWithAttempts.filter(_ != null)
      for {
        user: User <- getAllRawUsers
        role: Role <- getAllUserRoles(user.getUserId, courseID)
        if (roles.find(_.liferayRoleID == role.getRoleId).isDefined && scormUsers.filter(scUser => scUser.id == user.getUserId).size > 0)
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
    roles.find(r=> studentRoles.find(_.liferayRoleID ==  r.getRoleId).isDefined).isDefined
  }

  def hasTeacherPermissions(userID: Long, courseID: Long) = {
    if (isAdmin(userID, courseID)) true
    else{
      val roles = getAllUserRoles(userID, courseID)
      val teacherRoles = storageFactory.roleStorage.getForPermission(PermissionType.Teacher)
      //val isTeacher = roles.find(_.getName.equalsIgnoreCase("teacher")).isDefined
      val isTeacher = roles.find(r =>  teacherRoles.find(_.liferayRoleID == r.getRoleId).isDefined).isDefined
      isTeacher
    }
  }

  def isAdmin(userID: Long, courseID: Long) = {
    val roles = getAllUserRoles(userID, courseID)
    roles.find(_.getName.equalsIgnoreCase("administrator")).isDefined
  }

}
