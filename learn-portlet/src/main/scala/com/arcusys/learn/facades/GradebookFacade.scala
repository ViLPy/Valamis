package com.arcusys.learn.facades

import java.util.Locale

import com.arcusys.learn.exceptions.AccessDeniedException
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.models.Gradebook.{ PackageGradeResponse, StudentResponse, TotalGradeResponse }
import com.arcusys.learn.models.response.users.UserResponseUtils
import com.arcusys.learn.scorm.course.CourseStorage
import com.arcusys.learn.scorm.manifest.model.PackageType
import com.arcusys.learn.scorm.tracking.model.{ Course, PermissionType }
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer
import com.arcusys.learn.tincan.lrs.statement.{ StatementFilter, StatementLRS }
import com.arcusys.learn.tincan.model.{ Agent, Statement, StatementResult }
import com.arcusys.learn.tincan.storage.StatementStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

import scala.collection.JavaConverters._
import scala.util.Try

/**
 * Created by Iliya Tryapitsin on 15.04.2014.
 */
class GradebookFacade(configuration: BindingModule) extends GradebookFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  val userFacade = inject[UserFacadeContract]
  val roleFacade = inject[RoleFacadeContract]
  val packageFacade = inject[PackageFacadeContract]
  val courseStorage = inject[CourseStorage]

  private[facades] def isStudent(liferayUser: LUser, courseID: Long): Boolean = {
    val studentRoles = roleFacade.getForPermission(PermissionType.STUDENT)
    studentRoles.exists(studentRole =>
      liferayUser.getRoleIds.exists(liferayRoleId =>
        liferayRoleId == studentRole.liferayRoleId))
  }

  override def getExtStudents(courseId: Int,
    page: Int,
    count: Int,
    nameFilter: String,
    orgNameFilter: String,
    packageIds: Seq[Int],
    sortAscDirection: Boolean): Seq[StudentResponse] = {
    val packagesCount = packageFacade.getPackagesCount(courseId)
    userFacade
      .all(courseId, page, count, nameFilter, sortAscDirection)
      .filter(user => if (orgNameFilter != "") user.getOrganizations.asScala.map(org => org.getName).contains(orgNameFilter) else true)
      .filter(user => isStudent(user, courseId))
      .map(student => StudentResponse(
        id = student.getUserId,
        fullname = student.getFullName,
        avatarUrl = UserResponseUtils.getPortraitUrl(student),
        address = student.getAddresses.asScala.map(adr => getLocation(adr)),
        organizationNames = student.getOrganizations.asScala.map(org => org.getName),
        lastModified = "last modified",
        gradeTotal = getTotalGrade(courseId, student.getUserId.toInt),
        commentTotal = getTotalComment(courseId, student.getUserId.toInt),
        packagesCount = packagesCount,
        packageGrades = getPacketGradeWithStatements(courseId, student.getUserId.toInt, Option(packageIds))))
  }

  def getStudents(courseId: Int,
    page: Int,
    count: Int,
    nameFilter: String,
    orgNameFilter: String,
    sortAscDirection: Boolean): Seq[StudentResponse] = userFacade
    .all(courseId, page, count, nameFilter, sortAscDirection)
    .filter(user => if (orgNameFilter != "") user.getOrganizations.asScala.map(org => org.getName).contains(orgNameFilter) else true)
    .filter(user => isStudent(user, courseId))
    .map(student => StudentResponse(
      id = student.getUserId,
      fullname = student.getFullName,
      avatarUrl = UserResponseUtils.getPortraitUrl(student),
      organizationNames = student.getOrganizations.asScala.map(org => org.getName),
      lastModified = "last modified",
      gradeTotal = getTotalGrade(courseId, student.getUserId.toInt),
      completedPackagesCount = packageFacade.getCompletedPackagesCount(courseId, student.getUserId.toInt),
      packagesCount = packageFacade.getPackagesCount(courseId)))

  def getGradesForStudent(studentId: Int,
    courseId: Int,
    page: Int,
    count: Int,
    sortAscDirection: Boolean): StudentResponse = {
    val student = userFacade.byId(studentId)
    if (!isStudent(student, courseId))
      throw new AccessDeniedException

    StudentResponse(
      id = student.getUserId,
      fullname = student.getFullName,
      avatarUrl = UserResponseUtils.getPortraitUrl(student),
      address = student.getAddresses.asScala.map(adr => getLocation(adr)),
      organizationNames = student.getOrganizations.asScala.map(org => org.getName),
      lastModified = "last modified",
      gradeTotal = getTotalGrade(courseId, student.getUserId.toInt),
      commentTotal = getTotalComment(courseId, student.getUserId.toInt),
      completedPackagesCount = packageFacade.getCompletedPackagesCount(courseId, student.getUserId.toInt),
      packagesCount = packageFacade.getPackagesCount(courseId),
      packageGrades = getPacketGradeWithStatements(courseId, student.getUserId.toInt, None))
  }

  def getTotalGradeForStudent(studentId: Int,
    courseID: Int): TotalGradeResponse = TotalGradeResponse(
    getTotalGrade(courseID, studentId),
    getTotalComment(courseID, studentId))

  def changeTotalGrade(studentId: Int,
    courseID: Int,
    totalGrade: String,
    comment: Option[String]): Unit = {

    val course = getUserCourse(courseID, studentId)
    if (course.isDefined) {
      val courseGrade = course.get.copy(grade = totalGrade.toString, comment = if (comment.isDefined) comment.get else "")
      courseStorage.modify(courseGrade)
    } else {
      val courseGrade = Course(courseID, studentId, totalGrade.toString, if (comment.isDefined) comment.get else "", None)
      courseStorage.create(courseGrade)
    }
  }

  private def getUserCourse(courseId: Int, valamisUserId: Int) = courseStorage.get(courseId, valamisUserId)

  private[facades] def getTotalGrade(courseId: Int, valamisUserId: Int): Float = courseStorage.get(courseId, valamisUserId) match {
    case Some(value) => Try(value.grade.toFloat).getOrElse(0)
    case None        => 0
  }

  private def getTotalComment(courseId: Int, valamisUserId: Int): String = courseStorage.get(courseId, valamisUserId) match {
    case Some(value) => value.comment
    case None        => ""
  }

  //  private def getPacketGrade(packetId: Int, valamisUserId: Int): Seq[PackageGradeResponse] = {
  //    val packages = packageFacade
  //      .getPackages(valamisUserId)
  //
  //    packages.map(pack => {
  //      val result = packageFacade
  //        .getPackageGrades(valamisUserId, pack.id)
  //
  //      PackageGradeResponse(
  //        result.packageId.toInt,
  //        pack.title,
  //        pack.summary.getOrElse(""),
  //        result.grade != "",
  //        Try(result.grade.toInt).get,
  //        Seq())
  //    })
  //  }

  private[facades] def getPacketGradeWithStatements(courseId: Int, valamisUserId: Int, packageIds: Option[Seq[Int]]): Seq[PackageGradeResponse] = {
    val packages = packageFacade
      .getPackagesByCourse(courseId)
      .filter(p => !packageIds.isDefined || packageIds.get.contains(p.getId))

    packages.map(pack => {
      val result = packageFacade.getPackageGrade(valamisUserId, pack.getId)
      PackageGradeResponse(
        pack.getId,
        pack.getLogo,
        pack.getTitle,
        pack.getSummary.getOrElse(""),
        result.isDefined && result.get.grade != "",
        if (result.isDefined) result.get.grade else "",
        JsonDeserializer.serializeStatementResult(StatementResult(getStatementGrades(pack.getId, valamisUserId), "")),
        if (result.isDefined) Try(result.get.comment).get else "")
    })
  }

  private def getStatementGrades(packageId: Int, valamisUserId: Int): Seq[Statement] = {
    val statementLRS = new StatementLRS() {
      val statementStorage = inject[StatementStorage]
    }

    val email = "mailto:" + UserLocalServiceHelper()
      .getUser(valamisUserId)
      .getEmailAddress

    packageFacade.getPackageType(packageId) match {
      case PackageType.SCORM => {
        val filter = StatementFilter(
          agent = Option(Agent(objectType = "Agent", name = None, mbox = Option(email), mbox_sha1sum = None, openid = None, account = None, storedId = None)),
          activity = Option(packageId.toString),
          relatedActivities = Option(true))

        statementLRS
          .getStatements(filter)
          .statements

      }

      case PackageType.TINCAN => {
        packageFacade
          .getManifestActivities(packageId)
          .map(manifestActivity => {
            val filter = StatementFilter(
              agent = Option(Agent(objectType = "Agent", name = None, mbox = Option(email), mbox_sha1sum = None, openid = None, account = None, storedId = None)),
              activity = Option(manifestActivity.tincanId.toString),
              relatedActivities = Option(true))

            statementLRS
              .getStatements(filter)
              .statements
          })
          .flatMap(seq => seq)
      }
    }
  }

  private def getLocation(adr: com.liferay.portal.model.Address): String =
    if (adr.getCity.isEmpty)
      adr.getCountry.getName
    else
      adr.getCity + ", " + adr.getCountry.getName(Locale.getDefault)

  def changePackageGrade(studentId: Int,
    packageId: Int,
    grade: String,
    comment: Option[String]) =
    packageFacade.updatePackageGrade(studentId, packageId, grade, comment.getOrElse(""))

  override def getStudentsCount(courseId: Int,
    nameFilter: String,
    orgNameFilter: String): Int = {

    val users = UserLocalServiceHelper() //.getUsers(0, -1)
      .getGroupUsers(courseId)
      .asScala
      .filter(u => u.isActive && u.getFullName != "")

    val nameFiltered = if (nameFilter != "")
      users.filter(u => u.getFullName.contains(nameFilter))
    else
      users

    val orgFiltered = if (orgNameFilter != "")
      nameFiltered.filter(u => u.getOrganizations.asScala.map(_.getName).contains(orgNameFilter))
    else
      nameFiltered

    orgFiltered.length
  }
}
