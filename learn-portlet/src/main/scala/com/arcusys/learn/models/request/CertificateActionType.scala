package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object CertificateActionType extends Enumeration {
  val Add = Value("ADD")
  val AddCourses = Value("ADDCOURSES")
  val AddUser = Value("ADDUSER")
  val AddUsers = Value("ADDUSERS")
  val AddActivity = Value("ADDACTIVITY")
  val AddActivities = Value("ADDACTIVITIES")
  val AddTincanStmnt = Value("ADDTINCANSTMNT")
  val AddTincanStmnts = Value("ADDTINCANSTMNTS")
  val AddPackage = Value("ADDPACKAGE")
  val AddPackages = Value("ADDPACKAGES")
  val Update = Value("UPDATE")
  val UpdateLogo = Value("UPDATELOGO")
  val UpdateCourse = Value("UPDATECOURSE")
  val UpdateActivity = Value("UPDATEACTIVITY")
  val UpdateStmnt = Value("UPDATESTMNT")
  val UpdatePackage = Value("UPDATEPACKAGE")
  val Delete = Value("DELETE")
  val DeleteUser = Value("DELETEUSER")
  val DeleteUsers = Value("DELETEUSERS")
  val DeleteCourse = Value("DELETECOURSE")
  val DeleteActivity = Value("DELETEACTIVITY")
  val DeleteActivities = Value("DELETEACTIVITIES")
  val DeleteTincanStmnt = Value("DELETETINCANSTMNT")
  val DeletePackage = Value("DELETEPACKAGE")
  val Clone = Value("CLONE")
  val Publish = Value("PUBLISH")
  val Unpublish = Value("UNPUBLISH")
  val GetAll = Value("GETALL")
  val GetById = Value("GETBYID")
  val GetByUserId = Value("GETBYUSERID")
  val GetIssuerBadge = Value("GETISSUEBADGE")
  val GetBadgeModel = Value("GETBADGEMODEL")
  val GetIssuerModel = Value("GETISSUERMODEL")
  val GetStudents = Value("GETSTUDENTS")
  val GetNotContainedStudents = Value("GETNOTCONTAINEDSTUDENTS")
  val SetImage = Value("SETIMAGE")
  val MoveCourse = Value("MOVECOURSE")
  val GetStatements = Value("GETSTATEMENTS")
  val GetCertificateStates = Value("GETCERTIFICATESTATES")

  type CertificateActionType = Value

  def apply(v: String) = CertificateActionType.withName(v.toUpperCase)
}
