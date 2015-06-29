package com.arcusys.valamis.certificate.schema

import com.arcusys.valamis.certificate.model.goal.CourseGoal
import com.arcusys.valamis.core.DbNameUtils._
import com.arcusys.valamis.core.SlickProfile
import com.arcusys.valamis.model.PeriodTypes

trait CourseGoalTableComponent extends CertificateTableComponent{ self: SlickProfile =>
  import driver.simple._

  class CourseGoalTable(tag: Tag) extends Table[CourseGoal](tag, tblName("CERT_COURSE_GOAL")) {
    implicit val ValidPeriodTypeMapper = MappedColumnType.base[PeriodTypes.PeriodType, String](
      s => s.toString,
      s => PeriodTypes.withName(s)
    )

    def certificateId = column[Long]("CERTIFICATE_ID")
    def courseId = column[Long]("COURSE_ID")
    def periodValue = column[Int]("PERIOD_VALUE")
    def periodType = column[PeriodTypes.PeriodType]("PERIOD_TPE")
    def arrangementIndex = column[Int]("ARRANGEMENT_INDEX")

    def * = (certificateId, courseId, periodValue, periodType, arrangementIndex) <> (CourseGoal.tupled, CourseGoal.unapply)

    def PK = primaryKey(pkName("CERT_COURSE_GOAL"), (certificateId, courseId))
    def certificateFK = foreignKey(fkName("CERT_COURSE_GOAL_TO_CERT"), certificateId, certificates)(x => x.id, onDelete = ForeignKeyAction.Cascade)
  }

  val courseGoals = TableQuery[CourseGoalTable]
}