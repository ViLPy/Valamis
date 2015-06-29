package com.arcusys.valamis.version240.certificate

import com.arcusys.valamis.core.DbNameUtils._
import com.arcusys.valamis.core.SlickProfile
import com.arcusys.valamis.model.PeriodTypes

trait PackageGoalTableComponent extends CertificateTableComponent { self: SlickProfile =>
  import driver.simple._

  type PackageGoal = (Long, Long, Int, PeriodTypes.Value)
  class PackageGoalTable(tag: Tag) extends Table[PackageGoal](tag, tblName("CERT_PACKAGE_GOAL")) {
    implicit val ValidPeriodTypeMapper = MappedColumnType.base[PeriodTypes.PeriodType, String](
      s => s.toString,
      s => PeriodTypes.withName(s)
    )

    def certificateId = column[Long]("CERTIFICATE_ID")
    def packageId = column[Long]("PACKAGE_ID")
    def periodValue = column[Int]("PERIOD_VALUE")
    def periodType = column[PeriodTypes.PeriodType]("PERIOD_TPE")

    def * = (certificateId, packageId, periodValue, periodType)

    def PK = primaryKey(pkName("CERT_PACKAGE_GOAL"), (certificateId, packageId))
    def certificateFK = foreignKey(fkName("CERT_PACKAGE_GOAL_TO_CERT"), certificateId, certificates)(x => x.id, onDelete = ForeignKeyAction.Cascade)
  }

  val packageGoals = TableQuery[PackageGoalTable]
}
