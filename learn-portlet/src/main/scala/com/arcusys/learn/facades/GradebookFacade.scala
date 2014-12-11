package com.arcusys.learn.facades

import java.util.Date

import com.arcusys.learn.bl.services._
import com.arcusys.learn.exceptions.{ BadRequestException, AccessDeniedException }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.models.Gradebook.{ PackageGradeResponse, StudentResponse, TotalGradeResponse }
import com.arcusys.learn.models.response.users.UserResponseUtils
import com.arcusys.learn.scorm.tracking.model.CourseGrade
import com.arcusys.learn.tincan.api.serializer.JsonDeserializer
import com.arcusys.learn.tincan.model._
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.arcusys.learn.liferay.util.CountryUtilHelper
import scala.collection.JavaConverters._
import scala.util.Try
import org.joda.time.DateTime

/**
 * Created by Iliya Tryapitsin on 15.04.2014.
 */
class GradebookFacade(configuration: BindingModule) extends GradebookFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  val userService = inject[UserServiceContract]
  val packageService = inject[ValamisPackageServiceContract]
  val courseService = inject[CourseServiceContract]
  val userRoleService = inject[UserRoleServiceContract]
  val uriFacade = inject[URIFacadeContract]
  val gradeBookService = inject[GradeBookServiceContract]

  object SortType extends Enumeration {
    type SortType = Value
    val name_asc, name_desc, org_asc, org_desc, last_modified = Value
  }

  private[facades] def isStudent(liferayUser: LUser, courseID: Long): Boolean = {
    userRoleService.isStudent(liferayUser.getUserId, courseID)
  }

  override def getExtStudents(courseId: Int,
    page: Int,
    count: Int,
    nameFilter: String,
    orgNameFilter: String,
    packageIds: Seq[Int],
    sortBy: String): Seq[StudentResponse] = {
    val sort = try {
      SortType.withName(sortBy.toLowerCase)
    } catch {
      case _: Throwable => throw new BadRequestException
    } // value of sort is not valid
    val packagesCount = packageService.getPackagesCount(courseId)
    userService
      .all(courseId, page, count, nameFilter, true)
      .filter(user =>
        if (orgNameFilter != "")
          user.getOrganizations.asScala.exists(org => org.getName.toLowerCase.contains(orgNameFilter.toLowerCase))
        else true)
      .filter(user => isStudent(user, courseId))
      .map(student => StudentResponse(
        id = student.getUserId,
        fullname = student.getFullName,
        avatarUrl = UserResponseUtils.getPortraitUrl(student),
        address = student.getAddresses.asScala.map(adr => getLocation(adr)),
        organizationNames = student.getOrganizations.asScala.map(org => org.getName),
        lastModified = getLastModified(courseId, student.getUserId),
        gradeTotal = getTotalGrade(courseId, student.getUserId.toInt),
        commentTotal = getTotalComment(courseId, student.getUserId.toInt),
        packagesCount = packagesCount,
        packageGrades = getPacketGradeWithStatements(courseId, student.getUserId.toInt, Option(packageIds))))
      .sortWith((sr1, sr2) => sort match {
        case SortType.name_asc  => sr1.fullname <= sr2.fullname
        case SortType.name_desc => sr1.fullname > sr2.fullname
        case SortType.org_asc   => sr1.organizationNames.head <= sr2.organizationNames.head
        case SortType.org_desc  => sr1.organizationNames.head > sr2.organizationNames.head
      })
  }

  def getStudents(courseId: Int,
    page: Int,
    count: Int,
    nameFilter: String,
    orgNameFilter: String,
    sortBy: String): Seq[StudentResponse] = {
    val sort = try {
      SortType.withName(sortBy.toLowerCase)
    } catch {
      case _: Throwable => throw new BadRequestException
    } // value of sort is not valid
    userService
      .all(courseId, page, count, nameFilter, true)
      .filter(user =>
        if (orgNameFilter != "")
          user.getOrganizations.asScala.exists(org => org.getName.toLowerCase.contains(orgNameFilter.toLowerCase))
        else true)
      .filter(user => isStudent(user, courseId))
      .map(student => StudentResponse(
        id = student.getUserId,
        fullname = student.getFullName,
        avatarUrl = UserResponseUtils.getPortraitUrl(student),
        organizationNames = student.getOrganizations.asScala.map(org => org.getName),
        lastModified = getLastModified(courseId, student.getUserId),
        gradeTotal = getTotalGrade(courseId, student.getUserId.toInt),
        completedPackagesCount = packageService.getCompletedPackagesCount(courseId, student.getUserId.toInt),
        packagesCount = packageService.getPackagesCount(courseId)))
      .sortWith((sr1, sr2) => sort match {
        case SortType.name_asc      => sr1.fullname <= sr2.fullname
        case SortType.name_desc     => sr1.fullname > sr2.fullname
        case SortType.org_asc       => sr1.organizationNames.head <= sr2.organizationNames.head
        case SortType.org_desc      => sr1.organizationNames.head > sr2.organizationNames.head
        case SortType.last_modified => if (sr1.lastModified.isEmpty) false else if (sr2.lastModified.isEmpty) true else sr1.lastModified > sr2.lastModified
      })
  }

  def getGradesForStudent(studentId: Int,
    courseId: Int,
    page: Int,
    count: Int,
    sortAsc: Boolean = false): StudentResponse = {
    val student = userService.byId(studentId)
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
      completedPackagesCount = packageService.getCompletedPackagesCount(courseId, student.getUserId.toInt),
      packagesCount = packageService.getPackagesCount(courseId),
      packageGrades = getPacketGradeWithStatements(courseId, student.getUserId.toInt, None, sortAsc))
  }

  def getTotalGradeForStudent(studentId: Int,
    courseID: Int): TotalGradeResponse = TotalGradeResponse(
    getTotalGrade(courseID, studentId),
    getTotalComment(courseID, studentId), None, None)

  def changeTotalGrade(studentId: Int,
    courseID: Int,
    totalGrade: String,
    comment: Option[String]): Unit = {

    val course = courseService.get(courseID, studentId)
    if (course.isDefined) {
      val courseGrade = course.get.copy(grade = totalGrade.toString, comment = if (comment.isDefined) comment.get else "")
      courseService.modify(courseGrade)
    } else {
      val courseGrade = CourseGrade(courseID, studentId, totalGrade.toString, if (comment.isDefined) comment.get else "", None)
      courseService.create(courseGrade)
    }
  }

  private[facades] def getTotalGrade(courseId: Int, valamisUserId: Int): Float = courseService.get(courseId, valamisUserId) match {
    case Some(value) => Try(value.grade.toFloat).getOrElse(0)
    case None        => 0
  }

  private def getTotalComment(courseId: Int, valamisUserId: Int): String = courseService.get(courseId, valamisUserId) match {
    case Some(value) => value.comment
    case None        => ""
  }

  private[facades] def getPacketGradeWithStatements(courseId: Int, valamisUserId: Int, packageIds: Option[Seq[Int]], sortAsc: Boolean = false): Seq[PackageGradeResponse] = {
    val packages = packageService
      .getPackagesByCourse(courseId)
      .filter(p => !packageIds.isDefined || packageIds.get.contains(p.getId))

    packages.map(pack => {
      val result = packageService.getPackageGrade(valamisUserId, pack.getId)
      PackageGradeResponse(
        pack.getId,
        pack.getLogo,
        pack.getTitle,
        pack.getSummary.getOrElse(""),
        result.isDefined && result.get.grade != "",
        if (result.isDefined) result.get.grade else "",
        JsonDeserializer.serializeStatementResult(StatementResult(gradeBookService.getStatementGrades(pack.getId, valamisUserId, sortAsc), "")),
        if (result.isDefined) Try(result.get.comment).get else "")
    })
  }

  private def getLocation(adr: com.liferay.portal.model.Address): String =
    if (adr.getCity.isEmpty)
      adr.getCountry.getName
    else
      adr.getCity + ", " + CountryUtilHelper.getName(adr.getCountry)

  def changePackageGrade(studentId: Int,
    packageId: Int,
    grade: String,
    comment: Option[String]) =
    packageService.updatePackageGrade(studentId, packageId, grade, comment.getOrElse(""))

  override def getStudentsCount(courseId: Int,
    nameFilter: String,
    orgNameFilter: String): Int = {

    val users =
      UserLocalServiceHelper() //.getUsers(0, -1)
        .getGroupUsers(courseId)
        .asScala
        .filter(u => u.isActive && u.getFullName != "")
        .filter(user => isStudent(user, courseId))

    val nameFiltered = if (nameFilter != "")
      users.filter(u => u.getFullName.contains(nameFilter))
    else
      users

    val orgFiltered = if (orgNameFilter != "")
      nameFiltered.filter(u => u.getOrganizations.asScala.exists(org => org.getName.toLowerCase.contains(orgNameFilter.toLowerCase)))
    else
      nameFiltered

    orgFiltered.length
  }

  def getLastModified(courseId: Int, userId: Long): String = {
    val result = packageService
      .getPackagesByCourse(courseId)
      .map(p => packageService.getStatements(p, userId.toInt))
      .flatMap(s => s)
      .distinct
      .sortBy(s => s.stored)
      .lastOption
      .map(s => s.timestamp.getOrElse(new Date))

    if (result.isDefined)
      new DateTime(result.get).toString
    else
      ""

  }
}
