package com.arcusys.learn.facades

import com.arcusys.learn.exceptions.AccessDeniedException
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses.LUser
import com.arcusys.learn.liferay.permission.PermissionUtil._
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.liferay.util.CountryUtilHelper
import com.arcusys.learn.models.CourseResponse
import com.arcusys.learn.models.Gradebook._
import com.arcusys.learn.models.response.PieData
import com.arcusys.learn.models.response.users.UserResponseUtils
import com.arcusys.valamis.gradebook.model.GradebookUserSortBy.GradebookUserSortBy
import com.arcusys.valamis.gradebook.model._
import com.arcusys.valamis.gradebook.service.{CourseGradeService, GradeBookService, PackageGradeService}
import com.arcusys.valamis.lesson.model.{ValamisTag, BaseManifest}
import com.arcusys.valamis.lesson.service.{TagServiceContract, ValamisPackageService}
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.lrs.serializer.StatementSerializer
import com.arcusys.valamis.lrs.tincan.StatementResult
import com.arcusys.valamis.lrs.util.{TinCanVerbs, TincanHelper}
import com.arcusys.valamis.user.service.UserService
import com.arcusys.valamis.util.Joda._
import com.arcusys.valamis.utils.serialization.JsonHelper
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import org.joda.time.DateTime

import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.util.Try

/**
 * Gradebook Facade class
 */
class GradebookFacade(configuration: BindingModule) extends GradebookFacadeContract with Injectable {
  implicit val bindingModule = configuration
  private lazy val userService = inject[UserService]
  private lazy val packageService = inject[ValamisPackageService]
  private lazy val gradeService = new PackageGradeService()
  private lazy val courseService = inject[CourseGradeService]
  private lazy val gradeBookService = inject[GradeBookService]
  private lazy val userFacade = inject[UserFacadeContract]
  private lazy val userLocalService = UserLocalServiceHelper()
  private lazy val tagService = inject[TagServiceContract]


  def this() = this(Configuration)

  private[facades] def getTotalGrade(courseId: Int, valamisUserId: Int): Float = courseService.get(courseId, valamisUserId) match {
    case Some(value) => Try(value.grade.toFloat).getOrElse(0)
    case None => 0
  }

  private def getTotalComment(courseId: Int, valamisUserId: Int): String = courseService.get(courseId, valamisUserId) match {
    case Some(value) => value.comment
    case None => ""
  }

  private[facades] def getPackageGrades(statementApi: StatementApi, courseId: Int,
                                        valamisUserId: Int,
                                        packageIds: Option[Seq[Int]],
                                        skip: Int,
                                        count: Int,
                                        sortAsc: Boolean = false,
                                        withStatements: Boolean = true): Seq[PackageGradeResponse] = {
    var packages = packageService
      .getPackagesByCourse(courseId)
      .filter(p => !packageIds.isDefined || packageIds.get.contains(p.id))
      .sortBy(_.title)

    if (!sortAsc)
      packages = packages.reverse

    if (skip != -1 && count != -1)
      packages = packages.drop(skip).take(count)

    packages.map(pack => {
      if (withStatements)
        getPackageGradeWithStatements(statementApi, valamisUserId, pack.id)
      else {
        val result = gradeService.getPackageGrade(valamisUserId, pack.id)

        PackageGradeResponse(
          id = pack.id,
          packageLogo = pack.logo.getOrElse(""),
          packageName = pack.title,
          description = pack.summary.getOrElse(""),
          finished = result.isDefined && result.get.grade != "",
          grade = result.map(_.grade).getOrElse(""),
          gradeAuto = "",
          activityIds = packageService.getRootActivityIds(pack.id),
          statements = "",
          comment = if (result.isDefined) Try(result.get.comment).get else ""
        )
      }
    })
  }

  def getPackageGradeWithStatements(statementApi: StatementApi, valamisUserId: Int,
                                    packageId: Long): PackageGradeResponse = {
    val pack = packageService
      .getPackage(packageId)



    val result = gradeService.getPackageGrade(valamisUserId, pack.id)

    val statements = gradeBookService.getStatementGrades(statementApi, pack.id, valamisUserId, sortAsc = false, shortMode = true)
    val gradeAuto = statements
      .filter(st => TincanHelper.isVerbType(st.verb, TinCanVerbs.Completed))
      .map(TincanHelper.getScoreScaled)
      .filter(_.isDefined)
      .map(grade => if (grade.get <= 1) grade.get * 100 else grade.get)
      .headOption

    PackageGradeResponse(
      id = pack.id,
      packageLogo = pack.logo.getOrElse(""),
      packageName = pack.title,
      description = pack.summary.getOrElse(""),
      finished = result.isDefined && result.get.grade != "",
      grade = result.map(_.grade).getOrElse(""),
      gradeAuto = gradeAuto.map(_.toInt.toString).getOrElse(""),
      activityIds = packageService.getRootActivityIds(pack.id),
      statements = JsonHelper.toJson(StatementResult(statements, ""), new StatementSerializer),
      comment = if (result.isDefined) Try(result.get.comment).get else ""
    )
  }


  private def getLocation(adr: com.liferay.portal.model.Address): String =
    if (adr.getCity.isEmpty)
      adr.getCountry.getName
    else
      adr.getCity + ", " + CountryUtilHelper.getName(adr.getCountry)

  def getLastModified(statementApi: StatementApi, courseId: Int, userId: Long): String = {

    val result = packageService
      .getPackagesByCourse(courseId)
      .map(p => packageService.getStatements(p.id, userId.toInt, statementApi))
      .flatMap(s => s)
      .distinct
      .sortBy(s => s.stored)
      .lastOption
      .map(s => s.timestamp.getOrElse(new DateTime()))

    if (result.isDefined)
      new DateTime(result.get).toString
    else
      ""

  }

  def getStudents(statementApi: StatementApi, courseId: Int,
                  skip: Int,
                  count: Int,
                  nameFilter: String,
                  orgNameFilter: String,
                  sortBy: GradebookUserSortBy,
                  sortAZ: Boolean,
                  detailed: Boolean = false,
                  packageIds: Seq[Int] = Seq()): Seq[StudentResponse] = {
    val lastModifiedCache = mutable.HashMap[Long, String]()

    def getOrganizationNames(user: LUser): String = user.getOrganizations.asScala.map(_.getName).mkString(", ")
    def getLastModifiedField(user: LUser): DateTime = {
      val date = getLastModified(statementApi, courseId, user.getUserId)
      lastModifiedCache.put(user.getUserId, date)
      if (date.nonEmpty) DateTime.parse(date) else new DateTime(0)
    }
    val sorting = sortBy match {
      case GradebookUserSortBy.org => Ordering.by[LUser, String](getOrganizationNames)
      case GradebookUserSortBy.last_modified => Ordering.by[LUser, DateTime](getLastModifiedField)
      case _ => Ordering.by[LUser, String](_.getFullName)
    }

    var students = userService
      .all(courseId, -1, -1, nameFilter, sortAZ = true)
      .filter(user =>
      if (orgNameFilter != "")
        user.getOrganizations.asScala.exists(org => org.getName.toLowerCase.contains(orgNameFilter.toLowerCase))
      else true)
      .filter(user => userFacade.canView(user, viewAll = false))
      .sorted(sorting)

    if (!sortAZ)
      students = students.reverse

    if (skip != -1 && count != -1)
      students.drop(skip).take(count)

    students
      .map(student => StudentResponse(
      id = student.getUserId,
      fullname = student.getFullName,
      avatarUrl = UserResponseUtils.getPortraitUrl(student),
      address = student.getAddresses.asScala.map(adr => getLocation(adr)),
      organizationNames = student.getOrganizations.asScala.map(org => org.getName),
      lastModified = lastModifiedCache.getOrElse(student.getUserId, ""), //getLastModified(courseId, student.getUserId),
      gradeTotal = getTotalGrade(courseId, student.getUserId.toInt),
      commentTotal = getTotalComment(courseId, student.getUserId.toInt),
      completedPackagesCount = if (detailed) 0 else gradeService.getCompletedPackagesCount(courseId, student.getUserId.toInt),
      packagesCount = packageService.getPackagesCount(courseId),
      packageGrades = if (detailed) getPackageGrades(statementApi, courseId, student.getUserId.toInt, Option(packageIds), -1, -1, sortAsc = true, withStatements = false) else null)
      )

  }

  def getGradesForStudent(statementApi: StatementApi,
                          studentId: Int,
                          courseId: Int,
                          skip: Int,
                          count: Int,
                          sortAsc: Boolean = false,
                          withStatements: Boolean = true): StudentResponse = {
    val student = userService.byId(studentId)
    if (!userFacade.canView(getUserId, viewAll = false))
      throw AccessDeniedException()

    StudentResponse(
      id = student.getUserId,
      fullname = student.getFullName,
      avatarUrl = UserResponseUtils.getPortraitUrl(student),
      address = student.getAddresses.asScala.map(adr => getLocation(adr)),
      organizationNames = student.getOrganizations.asScala.map(org => org.getName),
      lastModified = "last modified",
      gradeTotal = getTotalGrade(courseId, student.getUserId.toInt),
      commentTotal = getTotalComment(courseId, student.getUserId.toInt),
      completedPackagesCount = gradeService.getCompletedPackagesCount(courseId, student.getUserId.toInt),
      packagesCount = packageService.getPackagesCount(courseId),
      packageGrades = getPackageGrades(statementApi, courseId, student.getUserId.toInt, None, skip, count, sortAsc, withStatements))
  }

  private def lastCompleted(statementApi: StatementApi, pack: BaseManifest, userId: Long) = {
    val statements = gradeBookService.getStatementGrades(statementApi, pack.id, userId.toInt, true)
    statements
      .filter(st => TincanHelper.isVerbType(st.verb, TinCanVerbs.Completed))
      .lastOption
  }

  def getUnfinishedPackages(statementApi: StatementApi, userId: Long): Seq[GradedPackageResponse] = {
    val lUser = userLocalService.getUser(userId)
    courseService.getByUserId(userId).flatMap { lGroup =>
      val unfinishedPackages =
        packageService
          .getPackagesByCourse(lGroup.getGroupId.toInt)
          .filter { pack =>
          val isAutograded =
            lastCompleted(statementApi, pack, userId)
              .flatMap(_.result)
              .flatMap(_.success)
              .getOrElse(false)

          val isGradedByTeacher = gradeService.isCompleted(userId, pack.id)

          !(isAutograded || isGradedByTeacher)
        }

      unfinishedPackages.map { pack =>
        val course =
          CourseResponse(
            lGroup.getGroupId,
            lGroup.getDescriptiveName,
            lGroup.getFriendlyURL,
            lGroup.getDescription.replace("\n", " "))
        val grade =
          gradeService
            .getPackageGrade(lUser.getUserId.toInt, pack.id)
            .map(_.grade.toFloat)
        val autoGrade =
          lastCompleted(statementApi, pack, userId)
            .flatMap(_.result)
            .flatMap(_.score)
            .flatMap(_.scaled)
            .map(_ * 100)

        GradedPackageResponse(
          id = pack.id,
          title = pack.title,
          description = pack.summary,
          course = course,
          grade = grade,
          autoGrade = autoGrade
        )
      }
    }
  }

  def getCompletedPackagesCount(statementApi: StatementApi, userId: Long): Int = {
    courseService.getByUserId(userId).map { lGroup =>
      val packages =
        packageService.getPackagesByCourse(lGroup.getGroupId.toInt)
          .filter { pack =>
          val isAutograded =
            lastCompleted(statementApi, pack, userId)
              .flatMap(_.result)
              .flatMap(_.success)
              .getOrElse(false)

          val isGradedByTeacher = gradeService.isCompleted(userId, pack.id)

          isAutograded || isGradedByTeacher
        }

      packages.length

    }.sum
  }

  def getCompletedPackages(statementApi: StatementApi, userId: Long): Seq[PieData] = {
    val completedPackages = courseService.getByUserId(userId).flatMap { lGroup =>
      val packages = packageService.getPackagesByCourse(lGroup.getGroupId.toInt)
        .filter { pack =>
        val isAutograded =
          lastCompleted(statementApi, pack, userId)
            .flatMap(_.result)
            .flatMap(_.success)
            .getOrElse(false)

        val isGradedByTeacher = gradeService.isCompleted(userId, pack.id)

        isAutograded || isGradedByTeacher
      }

      packages
    }

    val tags  = completedPackages.flatMap(pack => {
      val packTags = pack.assetRefId.map(tagService.getEntryTags)

      packTags match {
        case None | Some(Seq()) => Seq(ValamisTag(id= 0, text = ""))
        case Some(seq) => seq
      }
    })

    val total = tags.size
    val all = tags.groupBy(t => t.text).map {
      case (name, amounts) => PieData(name, amounts.size * 100 / total)
    } .toSeq

    if(total < 6) all
    else {
      val orderedWithoutOther = all.filter(x => !x.label.isEmpty).sortBy(x => x.value).reverse
      val showed = orderedWithoutOther.take(5)
      val toOther = all.filter(p => !showed.contains(p))
      val other = PieData("", toOther.map(p => p.value).sum )

      showed :+ other
    }
  }


  def getTotalGradeForStudent(studentId: Int,
                              courseId: Int): TotalGradeResponse = TotalGradeResponse(
    getTotalGrade(courseId, studentId),
    getTotalComment(courseId, studentId), None, None)

  def changeTotalGrade(studentId: Int,
                       courseId: Int,
                       totalGrade: String,
                       comment: Option[String]): Unit = {

    val course = courseService.get(courseId, studentId)
    if (course.isDefined) {
      val courseGrade = course.get.copy(grade = totalGrade.toString, comment = if (comment.isDefined) comment.get else "")
      courseService.modify(courseGrade)
    } else {
      val courseGrade = CourseGrade(courseId, studentId, totalGrade.toString, if (comment.isDefined) comment.get else "", None)
      courseService.create(courseGrade)
    }
  }

  def changePackageGrade(studentId: Int,
                         packageId: Int,
                         grade: String,
                         comment: Option[String]) =
    gradeService.updatePackageGrade(studentId, packageId, grade, comment.getOrElse(""))

  override def getStudentsCount(courseId: Int,
                                nameFilter: String,
                                orgNameFilter: String): Int = {

    val users =
      UserLocalServiceHelper() //.getUsers(0, -1)
        .getGroupUsers(courseId)
        .asScala
        .filter(u => u.isActive && u.getFullName != "")
        .filter(user => userFacade.canView(user, viewAll = false))

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

}