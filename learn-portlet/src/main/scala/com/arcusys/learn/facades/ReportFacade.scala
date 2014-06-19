package com.arcusys.learn.facades

import java.util.{ Calendar, Date }

import com.arcusys.learn.exceptions.BadRequestException
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.services.{ GroupLocalServiceHelper, UserLocalServiceHelper }
import com.arcusys.learn.models.report._
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.learn.models.response.users.UserResponseUtils
import com.arcusys.learn.scorm.course.CourseStorage
import com.arcusys.learn.scorm.manifest.model.{ BaseManifest, PackageType }
import com.arcusys.learn.scorm.tracking.model.{ Course, PermissionType }
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.tincan.lrs.statement.{ StatementFilter, StatementLRS }
import com.arcusys.learn.tincan.model.{ Agent, Statement }
import com.arcusys.learn.tincan.storage.StatementStorage
import com.arcusys.scorm.lms.UserManagement
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portal.NoSuchUserException
import com.liferay.portal.model.User
import com.liferay.portal.service.CompanyLocalServiceUtil
import org.joda.time.{ DateTime, Period }

import scala.collection.JavaConverters._
import scala.collection.parallel.mutable
import scala.collection.parallel.mutable.ParMap
import scala.util.Try

class ReportFacade(configuration: BindingModule) extends ReportFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  // TODO: TO Refactor this
  val roleFacade = inject[RoleFacadeContract]
  val packageFacade = inject[PackageFacadeContract]
  val courseFacade = inject[CourseFacadeContract]
  val courseStorage = inject[CourseStorage]
  val storageFactory = inject[StorageFactoryContract]
  val userManagement = new UserManagement()

  object ReportingPeriods extends Enumeration {
    type ReportingPeriods = Value
    val hour, day, week, month, year, interval = Value
  }

  val statementLRS = new StatementLRS() {
    val statementStorage = inject[StatementStorage]
  }

  // overrides
  override def getStudentsLeaderboard(period: String, offset: Int, amount: Int): CollectionResponse[StudentMostActiveResponse] = {
    val ALL_TIME = "all_time"

    val dateSince: Option[Date] =
      try {
        period match {
          case ALL_TIME  => None
          case s: String => Option(getStartOf(DateTime.now().toDate, ReportingPeriods.withName(s.toLowerCase)))
          case _         => throw new BadRequestException // value of period is not valid
        }
      } catch {
        case _: Throwable => throw new BadRequestException // value of period is not valid
      }

    val companies = CompanyLocalServiceUtil.getCompanies(-1, -1)

    val courseIds = companies.asScala.map(company => courseFacade.getAllCourses(company.getCompanyId).map(_.getGroupId)).flatMap(c => c).toList

    val students = courseIds.map(cId => getStudentsInCourse(cId))
      .flatMap(s => s)
      .distinct
      .sortBy(x => x.getFullName)

    val packages = courseIds.map(cID => getPackages(cID)).flatMap(p => p)

    val result = students.map(st => {
      val packagesStatements = getStatements(packages, st.getUserId, dateSince)

      StudentMostActiveResponse(st.getUserId,
        st.getFullName,
        UserResponseUtils.getPortraitUrl(st),
        packagesStatements.size)
    }).sortBy(s => s.stmtCount).reverse

    if (amount <= 0) throw new BadRequestException //(400, "Amount should be greater than zero")
    if (offset < 0) throw new BadRequestException //(400, "Offset cannot be less than zero")

    CollectionResponse(math.ceil((offset + 0.1) / amount.toFloat).toInt, result.slice(offset, offset + amount), result.length)
  }

  override def getMostActive(currentUserID: Int, offset: Int, amount: Int): CollectionResponse[StudentMostActiveResponse] = {
    val companies = CompanyLocalServiceUtil.getCompanies(-1, -1)
    val userID = currentUserID

    val courseIds = companies.asScala.map(company => courseFacade.getAllCourses(company.getCompanyId).map(_.getGroupId).filter(c => userManagement.hasTeacherPermissions(userID, c))).flatMap(c => c).toList

    val students = courseIds.map(cId => getStudentsInCourse(cId))
      .flatMap(s => s)
      .distinct
      .sortBy(x => x.getFullName)

    val packages = courseIds.map(cID => getPackages(cID)).flatMap(p => p)

    val result = students.map(st => {
      val packagesStatements = getStatements(packages, st.getUserId)

      StudentMostActiveResponse(st.getUserId,
        st.getFullName,
        UserResponseUtils.getPortraitUrl(st),
        packagesStatements.size)
    }).sortBy(s => s.stmtCount).reverse

    if (amount <= 0) throw new BadRequestException //(400, "Amount should be greater than zero")
    if (offset < 0) throw new BadRequestException //(400, "Offset cannot be less than zero")

    CollectionResponse(math.ceil((offset + 0.1) / amount.toFloat).toInt, result.slice(offset, offset + amount), result.length)
  }

  override def getUserLatestStatements(currentUserID: Int, offset: Int, amount: Int): CollectionResponse[Statement] = {
    val email = try {
      UserLocalServiceHelper().getUser(currentUserID).getEmailAddress
    } catch {
      case _: Throwable => throw new NoSuchUserException("Cannot find user for current session") //(500, "Cannot find user for current session")
    }

    if (amount <= 0) throw new BadRequestException //(400, "Amount should be greater than zero")
    if (offset < 0) throw new BadRequestException //(400, "Offset cannot be less than zero")

    val filter = StatementFilter(
      agent = Option(Agent(objectType = "Agent", name = None, mbox = Option("mailto:" + email), mbox_sha1sum = None, openid = None, account = None, storedId = None))
    )

    val statements = statementLRS.getStatements(filter).statements.sortBy(st => st.timestamp).reverse

    CollectionResponse(math.ceil((offset + 0.1) / amount.toFloat).toInt, statements.slice(offset, offset + amount), statements.length)
  }

  override def getStudentsLatestStatements(currentUserID: Int, offset: Int, amount: Int): CollectionResponse[Statement] = {
    val companies = CompanyLocalServiceUtil.getCompanies(-1, -1)
    val userID = currentUserID

    val courseIds = companies.asScala.map(company => courseFacade.getAllCourses(company.getCompanyId).map(_.getGroupId).filter(c => userManagement.hasTeacherPermissions(userID, c))).flatMap(c => c).toList
    //val roles = RoleLocalServiceHelper.getUserRoles(userID).asScala.toList
    //    val teacherRoles = storageFactory.roleStorage
    //      .getForPermission(PermissionType.TEACHER)
    //      .filter(tr => roles.find(r => r.getRoleId.toInt == tr.liferayRoleID).isDefined)
    //    val courseIds = teacherRoles
    //      .map(r => GroupLocalServiceHelper.searchByRoleExceptPrivateSites(r.liferayRoleID, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS))
    //      .flatMap(r => r)
    //      .map(_.getGroupId.toInt).toList

    //    val courseIds = courseFacade.getAllCourses(company.getCompanyId).map(_.getGroupId)
    //      .filter(c => userManagement.hasTeacherPermissions(userID, c))

    val packages = courseIds.map(cID => getPackages(cID)).flatMap(p => p)
    val packagesStatements = getStatements(packages, -1)

    val result = packagesStatements.sortBy(stm => stm.timestamp).reverse

    if (amount <= 0) throw new BadRequestException //(400, "Amount should be greater than zero")
    if (offset < 0) throw new BadRequestException //(400, "Offset cannot be less than zero")

    CollectionResponse(math.ceil((offset + 0.1) / amount.toFloat).toInt, result.slice(offset, offset + amount), result.length)
  }

  override def getStatementVerbs(): VerbResponse = {
    val statements = statementLRS.getStatements().statements
    val statementVerbs = statements
      .map(_.verb.id.split("/").last) // http://adlnet.gov/expapi/verbs/answered -> answered
      .groupBy(verb => verb)
      .mapValues(_.size)

    VerbResponse(statementVerbs)
  }

  override def getOverallByPeriod(period: String, from: Long, to: Long): OverallByPeriodResponse = {
    try {
      val periodVal = ReportingPeriods.withName(period.toLowerCase)
      val fromDate = getStartOf(new Date(from), periodVal)
      val toDate = getEndOf(new Date(to), periodVal)
      val data = statementLRS.getStatements().statements
        .filter(d => d.timestamp.isDefined && d.timestamp.get.compareTo(fromDate) >= 0 && d.timestamp.get.compareTo(toDate) <= 0)
        .map(s => getStartOf(s.timestamp.get, periodVal))
        .sortBy(d => d.getTime)
        .groupBy(date => date)
        .map(k => Map("date" -> k._1.getTime, "amount" -> k._2.size))
      OverallByPeriodResponse(data, periodVal.toString)
    } catch {
      case _: Throwable => throw new BadRequestException
    }
  }

  override def getCourseEvent(group: String, groupPeriod: Option[String], period: String, from: Long, to: Long): Seq[CourseEventResponse] = {
    object ReportingGroup extends Enumeration {
      type ReportingGroup = Value
      val duration, teacher, organization, group = Value
    }

    def isInDateRange(date: Date, fromDate: Date, toDate: Date) =
      date.compareTo(fromDate) < 0 || (date.compareTo(fromDate) >= 0 && date.compareTo(toDate) <= 0)

    def getMapElement(mapList: mutable.ParMap[String, CourseEventResponse], key: String) = {
      var res = mapList.get(key)
      if (!res.isDefined) {
        mapList.put(key, CourseEventResponse(0, 0, key))
        res = mapList.get(key)
      }
      res.get
    }

    val groupBy = try {
      ReportingGroup.withName(group.toLowerCase)
    } catch {
      case _: Throwable => throw new BadRequestException
    }

    val groupByPeriod = if (groupBy == ReportingGroup.duration)
      try {
        ReportingPeriods.withName(groupPeriod.get.toLowerCase)
      } catch {
        case _: Throwable => throw new BadRequestException
      }
    else null

    //    try {
    val periodVal = try {
      ReportingPeriods.withName(period.toLowerCase)
    } catch {
      case _: Throwable => throw new BadRequestException
    }

    val fromDate = try {
      if (periodVal == ReportingPeriods.interval) new Date(from) else getStartOf(new Date(), periodVal)
    } catch {
      case _: Throwable => throw new BadRequestException
    }
    val toDate = try {
      if (periodVal == ReportingPeriods.interval) new Date(to) else getEndOf(new Date(), periodVal)
    } catch {
      case _: Throwable => throw new BadRequestException
    }
    val companies = CompanyLocalServiceUtil.getCompanies(-1, -1)
    val courseIds = companies.asScala.map(company => courseFacade.getAllCourses(company.getCompanyId).map(_.getGroupId)).flatMap(c => c).toList

    var result: mutable.ParMap[String, CourseEventResponse] = ParMap()

    groupBy match {
      case ReportingGroup.duration => {
        def dateRange(from: DateTime, to: DateTime, step: Period): List[DateTime] =
          Iterator.iterate(from)(_.plus(step)).takeWhile(!_.isAfter(to)).toList

        groupByPeriod match {
          case ReportingPeriods.year => {
            dateRange(
              new DateTime(fromDate),
              new DateTime(toDate),
              Period.years(1))
              .map(d => {
                getMapElement(result, d.toString("YYYY"))
              })
          }
          case ReportingPeriods.month => {
            dateRange(
              new DateTime(fromDate),
              new DateTime(toDate),
              Period.months(1))
              .map(d => {
                getMapElement(result, d.toString("YYYY/MM"))
              })
          }
          case ReportingPeriods.week => {
            dateRange(
              new DateTime(fromDate),
              new DateTime(toDate),
              Period.weeks(1))
              .map(d => {
                getMapElement(result, d.toString("YYYY/ww"))
              })
          }
          case ReportingPeriods.day => {
            dateRange(
              new DateTime(fromDate),
              new DateTime(toDate),
              Period.days(1))
              .map(d => {
                getMapElement(result, d.toString("YYYY/MM/dd"))
              })
          }
        }

        var allStudents: Seq[User] = Seq()
        courseIds.foreach(cID => {
          val students = getStudentsInCourse(cID)
          allStudents = allStudents ++ students

          students.foreach(st => {
            val grade = getCourseGrade(cID, st.getUserId.toInt)
            if (grade.isDefined && grade.get.date.isDefined && isInDateRange(grade.get.date.get.toDate, fromDate, toDate)) {
              groupByPeriod match {
                case ReportingPeriods.year => {
                  dateRange(
                    new DateTime(fromDate),
                    new DateTime(toDate),
                    Period.years(1))
                    .map(d => {
                      var res = getMapElement(result, d.toString("YYYY"))
                      if (d.compareTo(grade.get.date.get) > 0)
                        res.completionsCount += 1
                    })
                }
                case ReportingPeriods.month => {
                  dateRange(
                    new DateTime(fromDate),
                    new DateTime(toDate),
                    Period.months(1))
                    .map(d => {
                      var res = getMapElement(result, d.toString("YYYY/MM"))
                      if (d.compareTo(grade.get.date.get) > 0)
                        res.completionsCount += 1
                    })
                }
                case ReportingPeriods.week => {
                  dateRange(
                    new DateTime(fromDate),
                    new DateTime(toDate),
                    Period.weeks(1))
                    .map(d => {
                      var res = getMapElement(result, d.toString("YYYY/ww"))
                      if (d.compareTo(grade.get.date.get) > 0)
                        res.completionsCount += 1
                    })
                }
                case ReportingPeriods.day => {
                  dateRange(
                    new DateTime(fromDate),
                    new DateTime(toDate),
                    Period.days(1))
                    .map(d => {
                      var res = getMapElement(result, d.toString("YYYY/MM/dd"))
                      if (d.compareTo(grade.get.date.get) > 0)
                        res.completionsCount += 1
                    })
                }
              }
            }
          })
        })
        result.foreach(r => r._2.enrollmentsCount = allStudents.size - r._2.completionsCount)

      }
      case ReportingGroup.teacher => {
        courseIds.foreach(cID => {
          val students = getStudentsInCourse(cID)

          val teachers = getTeachersInCourse(cID)
          teachers.foreach(t => {
            var res = getMapElement(result, t.getFullName)

            students.foreach(st => {
              val grade = getCourseGrade(cID, st.getUserId.toInt)
              if (grade.isDefined && grade.get.date.isDefined && isInDateRange(grade.get.date.get.toDate, fromDate, toDate)) {
                res.completionsCount += 1
              } else
                res.enrollmentsCount += 1

            })
          })
        })
      }
      case ReportingGroup.organization => {
        courseIds.foreach(cID => {
          val students = getStudentsInCourse(cID)

          students.foreach(st => {
            st.getOrganizations.asScala.foreach(org => {
              var res = getMapElement(result, org.getName)
              val grade = getCourseGrade(cID, st.getUserId.toInt)
              if (grade.isDefined && grade.get.date.isDefined && isInDateRange(grade.get.date.get.toDate, fromDate, toDate)) {
                res.completionsCount += 1
              } else
                res.enrollmentsCount += 1

            })
          })
        })
      }
      case ReportingGroup.group => {
        courseIds.foreach(cID => {
          val students = getStudentsInCourse(cID)

          students.foreach(st => {
            st.getUserGroups.asScala.foreach(group => {
              var res = getMapElement(result, group.getName)
              val grade = getCourseGrade(cID, st.getUserId.toInt)
              if (grade.isDefined && grade.get.date.isDefined && isInDateRange(grade.get.date.get.toDate, fromDate, toDate)) {
                res.completionsCount += 1
              } else
                res.enrollmentsCount += 1

            })
          })
        })
      }
    }

    result.map(_._2).toSeq.seq.sortBy(s => s.groupName)
  }

  override def getParticipantReport(group: String): Seq[ParticipantResponse] = {
    object ReportingGroup extends Enumeration {
      type ReportingGroup = Value
      val course, teacher, organization, group = Value
    }

    def getMapElement(mapList: mutable.ParMap[String, ParticipantResponse], key: String) = {
      var res = mapList.get(key)
      if (!res.isDefined) {
        mapList.put(key, ParticipantResponse(0, key))
        res = mapList.get(key)
      }
      res.get
    }

    val groupBy = try {
      ReportingGroup.withName(group.toLowerCase)
    } catch {
      case _: Throwable => throw new BadRequestException
    }

    val companies = CompanyLocalServiceUtil.getCompanies(-1, -1)
    val courseIds = companies.asScala
      .map(company => courseFacade.getAllCourses(company.getCompanyId))
      .flatMap(c => c).toList

    var result: mutable.ParMap[String, ParticipantResponse] = ParMap()

    groupBy match {
      case ReportingGroup.course => {
        courseIds.foreach(course => {
          val students = getStudentsInCourse(course.getGroupId)

          if (students.size > 0) {
            var res = getMapElement(result, course.getDescriptiveName)
            res.amount = students.size
          }
        })

      }
      case ReportingGroup.teacher => {
        courseIds.foreach(course => {
          val students = getStudentsInCourse(course.getGroupId)

          val teachers = getTeachersInCourse(course.getGroupId)
          teachers.foreach(t => {
            var res = getMapElement(result, t.getFullName)
            res.amount += students.size
          })
        })
      }
      case ReportingGroup.organization => {
        courseIds.foreach(course => {
          val students = getStudentsInCourse(course.getGroupId)

          students.foreach(st => {
            st.getOrganizations.asScala.foreach(org => {
              var res = getMapElement(result, org.getName)
              res.amount += 1
            })
          })
        })
      }
      case ReportingGroup.group => {
        courseIds.foreach(course => {
          val students = getStudentsInCourse(course.getGroupId)

          students.foreach(st => {
            st.getUserGroups.asScala.foreach(group => {
              var res = getMapElement(result, group.getName)
              res.amount += 1

            })
          })
        })
      }
    }

    result.map(_._2).toSeq.seq.sortBy(s => s.groupName)

  }

  override def getOverallByTime(): OverallByTimeResponse = {
    val startedData = statementLRS.getStatements(StatementFilter(verb = Some("http://adlnet.gov/expapi/verbs/attempted")))
      .statements.map(s => getStartOf(s.timestamp.getOrElse(new Date(0)), ReportingPeriods.day))
      .groupBy(date => date)
      .map(k => Map("date" -> k._1.getTime, "amount" -> k._2.size))

    val completedData = statementLRS.getStatements(StatementFilter(verb = Some("http://adlnet.gov/expapi/verbs/completed")))
      .statements.map(s => getStartOf(s.timestamp.getOrElse(new Date(0)), ReportingPeriods.day))
      .groupBy(date => date)
      .map(k => Map("date" -> k._1.getTime, "amount" -> k._2.size))

    val passed = statementLRS.getStatements(StatementFilter(verb = Some("http://adlnet.gov/expapi/verbs/completed")))

    val passedScores = passed.statements
      .filter(s => s.result.isDefined && s.result.get.success.getOrElse(false) && s.result.get.score.isDefined)
      .map(_.result.get.score.get.scaled)

    val average = if (passedScores.nonEmpty) (passedScores.sum / passedScores.size).toDouble else 0

    val passedData =
      passed.statements.filter(s => s.result.isDefined && s.result.get.success.isDefined)
        .map(s => getStartOf(s.timestamp.getOrElse(new Date(0)), ReportingPeriods.day))
        .groupBy(date => date)
        .map(k => Map("date" -> k._1.getTime, "amount" -> k._2.size))

    OverallByTimeResponse(average, startedData, completedData, passedData)
  }

  override def getCourseReport(isInstanceScope: Boolean, courseID: Option[Int]): CourseReportResponse = {

    val courseIds = {
      if (isInstanceScope) {
        val companies = CompanyLocalServiceUtil.getCompanies(-1, -1)
        companies.asScala.map(company => courseFacade.getAllCourses(company.getCompanyId).map(_.getGroupId)).flatMap(c => c).toList
      } else {
        if (!courseID.isDefined) throw new BadRequestException
        else List(courseID.get.toLong)
      }
    }

    val result =
      if (isInstanceScope)
        CourseReportResponse(0, "Instance", courseIds.size, 0, 0, 0, 0, 0, 0, 0)
      else
        CourseReportResponse(courseIds.head, GroupLocalServiceHelper.getGroup(courseIds.head).getDescriptiveName, 1, 0, 0, 0, 0, 0, 0, 0)

    var allStudents: Seq[User] = Seq()
    courseIds.foreach(cID => {
      val students = getStudentsInCourse(cID)

      allStudents = allStudents ++ students

      val packages = getPackages(cID)

      students.foreach(st => {

        val started = getStatements(packages, st.getUserId).size > 0

        if (started)
          result.studentsStartedCount += 1

        val grade = getTotalGrade(cID, st.getUserId.toInt)
        if (grade.isDefined) {
          result.studentsCompletedCount += 1
          if (grade.get > 0)
            result.studentsPassedCount += 1
          else
            result.studentsFailedCount += 1
        } else if (started)
          result.studentsIncompletedCount += 1
        else
          result.studentsUnknownCount += 1
      })
    })

    result.studentsCount = allStudents.size
    result
  }

  // private
  private[facades] def isStudent(liferayUser: LUser, courseID: Long): Boolean = {
    val studentRoles = roleFacade.getForPermission(PermissionType.STUDENT)
    studentRoles.exists(studentRole =>
      liferayUser.getRoleIds.exists(liferayRoleId =>
        liferayRoleId == studentRole.liferayRoleId))
  }

  private[facades] def isTeacher(liferayUser: LUser, courseID: Long): Boolean = {
    val studentRoles = roleFacade.getForPermission(PermissionType.TEACHER)
    studentRoles.exists(studentRole =>
      liferayUser.getRoleIds.exists(liferayRoleId =>
        liferayRoleId == studentRole.liferayRoleId))
  }

  private def getStudentsInCourse(courseId: Long): Seq[User] = {
    UserLocalServiceHelper()
      .getGroupUsers(courseId)
      .asScala
      .filter(u => u.isActive && u.getFullName != "")
      .filter(user => isStudent(user, courseId))
      .sortBy(x => x.getFullName)
      .toSeq
  }

  private def getTeachersInCourse(courseId: Long): Seq[User] = {
    UserLocalServiceHelper()
      .getGroupUsers(courseId)
      .asScala
      .filter(u => u.isActive && u.getFullName != "")
      .filter(user => isTeacher(user, courseId))
      .sortBy(x => x.getFullName)
      .toSeq
  }

  private[facades] def getPackages(courseId: Long) = {
    storageFactory.packageStorage.getByCourseID(Option(courseId.toInt)) ++ storageFactory.tincanPackageStorage.getByCourseID(Option(courseId.toInt))
  }

  private[facades] def getStatements(packages: Seq[BaseManifest], userId: Long, dateSince: Option[Date] = None) = {
    packages.map(p => {
      p.getType match {
        case PackageType.SCORM => {
          val email = if (userId == -1) "" else ("mailto:" + UserLocalServiceHelper().getUser(userId).getEmailAddress)
          val filter = StatementFilter(
            agent = if (userId == -1) None else Option(Agent(objectType = "Agent", name = None, mbox = Option(email), mbox_sha1sum = None, openid = None, account = None, storedId = None)),
            activity = Option(p.getId.toString),
            relatedActivities = Option(true),
            since = if (dateSince.isDefined) Option(dateSince.get) else None
          )

          statementLRS
            .getStatements(filter)
            .statements
        }
        case PackageType.TINCAN => {
          packageFacade
            .getManifestActivities(p.getId)
            .map(manifestActivity => {
              val email = if (userId == -1) "" else ("mailto:" + UserLocalServiceHelper().getUser(userId).getEmailAddress)
              val filter = StatementFilter(
                agent = if (userId == -1) None else Option(Agent(objectType = "Agent", name = None, mbox = Option(email), mbox_sha1sum = None, openid = None, account = None, storedId = None)),
                activity = Option(manifestActivity.tincanId.toString),
                relatedActivities = Option(true),
                since = if (dateSince.isDefined) Option(dateSince.get) else None
              )

              statementLRS
                .getStatements(filter)
                .statements
            })
            .flatMap(seq => seq)
        }
      }
    })
      .flatMap(s => s)
      .distinct

  }

  private def getTotalGrade(courseId: Long, valamisUserId: Long): Option[Int] = getCourseGrade(courseId.toInt, valamisUserId.toInt) match {
    case Some(value) => Option(Try(value.grade.toInt).getOrElse(0))
    case None        => None
  }

  private def getCourseGrade(courseId: Long, valamisUserId: Long): Option[Course] = courseStorage.get(courseId.toInt, valamisUserId.toInt)

  private def getStartOf(date: Date, period: ReportingPeriods.Value) = {
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    if (period == ReportingPeriods.day) {
      calendar.set(Calendar.HOUR_OF_DAY, 0)
    }
    if (period == ReportingPeriods.week) {
      calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
      calendar.set(Calendar.HOUR_OF_DAY, 0)
    }
    if (period == ReportingPeriods.month) {
      calendar.set(Calendar.DAY_OF_MONTH, 1)
      calendar.set(Calendar.HOUR_OF_DAY, 0)
    }
    if (period == ReportingPeriods.year) {
      calendar.set(Calendar.MONTH, 0)
      calendar.set(Calendar.DAY_OF_MONTH, 1)
      calendar.set(Calendar.HOUR_OF_DAY, 0)
    }
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    calendar.getTime
  }

  private def getEndOf(date: Date, period: ReportingPeriods.Value) = {
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    if (period == ReportingPeriods.day) {
      calendar.set(Calendar.HOUR_OF_DAY, 23)
    }
    if (period == ReportingPeriods.week) {
      calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
      //calendar.add(Calendar.DATE, 7)
      calendar.set(Calendar.HOUR_OF_DAY, 23)
    }
    if (period == ReportingPeriods.month) {
      calendar.add(Calendar.MONTH, 1)
      calendar.set(Calendar.DAY_OF_MONTH, 1)
      calendar.add(Calendar.DATE, -1)
      calendar.set(Calendar.HOUR_OF_DAY, 23)
    }
    if (period == ReportingPeriods.year) {
      calendar.set(Calendar.MONTH, 0)
      calendar.set(Calendar.DAY_OF_MONTH, 1)
      calendar.add(Calendar.YEAR, 1)
      calendar.add(Calendar.DATE, -1)
      calendar.set(Calendar.HOUR_OF_DAY, 23)
    }
    calendar.set(Calendar.MINUTE, 59)
    calendar.set(Calendar.SECOND, 59)
    calendar.set(Calendar.MILLISECOND, 999)
    calendar.getTime
  }

}
