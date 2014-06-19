package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object CertificateActionType extends Enumeration {
  val ADD = Value("ADD")
  val ADD_COURSE = Value("ADDCOURSE")
  val ADD_COURSES = Value("ADDCOURSES")
  val ADD_USER = Value("ADDUSER")
  val ADD_USERS = Value("ADDUSERS")
  val ADD_ACTIVITY = Value("ADDACTIVITY")
  val ADD_ACTIVITIES = Value("ADDACTIVITIES")
  val ADD_TINCANSTMNT = Value("ADDTINCANSTMNT")
  val UPDATE = Value("UPDATE")
  val UPDATE_LOGO = Value("UPDATELOGO")
  val UPDATE_COURSE = Value("UPDATECOURSE")
  val UPDATE_ACTIVITY = Value("UPDATEACTIVITY")
  val UPDATE_STMNT = Value("UPDATESTMNT")
  val DELETE = Value("DELETE")
  val DELETE_USER = Value("DELETEUSER")
  val DELETE_USERS = Value("DELETEUSERS")
  val DELETE_COURSE = Value("DELETECOURSE")
  val DELETE_ACTIVITY = Value("DELETEACTIVITY")
  val DELETE_ACTIVITIES = Value("DELETEACTIVITIES")
  val DELETE_TINCANSTMNT = Value("DELETETINCANSTMNT")
  val CLONE = Value("CLONE")
  val PUBLISH = Value("PUBLISH")
  val UNPUBLISH = Value("UNPUBLISH")
  val GET_ALL = Value("GETALL")
  val GET_BY_ID = Value("GETBYID")
  val GET_BY_USER_ID = Value("GETBYUSERID")
  val GET_ISSUE_BADGE = Value("GETISSUEBADGE")
  val GET_STUDENTS = Value("GETSTUDENTS")
  val GET_NOT_CONTAINED_STUDENTS = Value("GETNOTCONTAINEDSTUDENTS")
  val SET_IMAGE = Value("SETIMAGE")

  type CertificateActionType = Value

  def apply(v: String) = CertificateActionType.withName(v.toUpperCase)
}
