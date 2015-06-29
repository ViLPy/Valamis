package com.arcusys.valamis.certificate.schema

import com.arcusys.valamis.certificate.model.goal.ActivityGoal
import com.arcusys.valamis.core.DbNameUtils._
import com.arcusys.valamis.core.SlickProfile
import com.arcusys.valamis.model.PeriodTypes

trait ActivityGoalTableComponent extends CertificateTableComponent { self: SlickProfile =>
  import driver.simple._

  class ActivityGoalTable(tag: Tag) extends Table[ActivityGoal](tag, tblName("CERT_ACTIVITY_GOAL")) {
    implicit val ValidPeriodTypeMapper = MappedColumnType.base[PeriodTypes.PeriodType, String](
      s => s.toString,
      s => PeriodTypes.withName(s)
    )
    def certificateId = column[Long]("CERTIFICATE_ID")
    def activityName = column[String]("ACTIVITY_NAME")
    def count = column[Int]("COUNT")
    def periodValue = column[Int]("PERIOD_VALUE")
    def periodType = column[PeriodTypes.PeriodType]("PERIOD_TYPE")


    private def customTupled(tuple: (Long, String, Int, Int, PeriodTypes.Value)) = tuple match {
      case (certificateId: Long, activityName: String, count: Int, value: Int, periodType: PeriodTypes.Value) => ActivityGoal(certificateId.toInt, activityName, count, value, periodType)
    }
    private def customUnapply(activityGoal: ActivityGoal) = activityGoal match {
      case ActivityGoal(certificateId, activityName, count, value, periodType) => Some(certificateId.toLong, activityName, count, value, periodType)
    }

    def * = (certificateId, activityName, count, periodValue, periodType) <> (customTupled, customUnapply)

    def PK = primaryKey(pkName("CERT_ACTIVITY_GOAL"), (certificateId, activityName))

    def certificateFK = foreignKey(fkName("CERT_ACTIVITY_TO_CERT"), certificateId, TableQuery[CertificateTable])(x => x.id, onDelete = ForeignKeyAction.Cascade)
  }

  val activityGoals = TableQuery[ActivityGoalTable]
}
