package com.arcusys.valamis.version240.certificate

import com.arcusys.valamis.core.DbNameUtils._
import com.arcusys.valamis.core.SlickProfile
import com.arcusys.valamis.model.PeriodTypes

trait ActivityGoalTableComponent extends CertificateTableComponent { self: SlickProfile =>
  import driver.simple._

  type ActivityGoal = (Long, String, Int, Int, PeriodTypes.Value)
  class ActivityGoalTable(tag: Tag) extends Table[ActivityGoal](tag, tblName("CERT_ACTIVITY_GOAL")) {
    implicit val ValidPeriodTypeMapper = MappedColumnType.base[PeriodTypes.PeriodType, String](
      s => s.toString,
      s => PeriodTypes.withName(s)
    )
    def certificateId = column[Long]("CERTIFICATE_ID")
    def activityName = column[String]("ACTIVITY_NAME")
    def count = column[Int]("COUNT")
    def periodValue = column[Int]("PERIOD_VALUE")
    def periodType = column[PeriodTypes.Value]("PERIOD_TYPE")

    def * = (certificateId, activityName, count, periodValue, periodType)

    def PK = primaryKey(pkName("CERT_ACTIVITY_GOAL"), (certificateId, activityName))

    def certificateFK = foreignKey(fkName("CERT_ACTIVITY_TO_CERT"), certificateId, TableQuery[CertificateTable])(x => x.id, onDelete = ForeignKeyAction.Cascade)
  }

  val activityGoals = TableQuery[ActivityGoalTable]
}
