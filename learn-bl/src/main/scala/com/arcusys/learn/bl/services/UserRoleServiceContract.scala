package com.arcusys.learn.bl.services

/**
 * Created by igorborisov on 17.10.14.
 */
trait UserRoleServiceContract {

  def getStudentsWithAttemptsByCourseID(courseID: Long)

  def isLearnUser(userID: Long, courseID: Long): Boolean

  def isStudent(userID: Long, courseID: Long): Boolean

  def hasTeacherPermissions(userId: Long, courseId: Long): Boolean

  def isAdmin(userID: Long, courseID: Long): Boolean
}
