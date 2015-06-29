package com.arcusys.valamis.certificate.storage

import com.arcusys.valamis.certificate.model.goal.PackageGoal
import com.arcusys.valamis.model.PeriodTypes
import com.arcusys.valamis.model.PeriodTypes.PeriodType

/**
 * Created by mminin on 02.03.15.
 */
trait PackageGoalStorage {

  def create(certificateId: Long, packageId: Long, periodValue: Int, periodType: PeriodType): PackageGoal

  def delete(certificateId: Long, packageId: Long): Unit

  def modify(certificateId: Long, packageId: Long, periodValue: Int, periodType: PeriodType): PackageGoal

  def get(certificateId: Long, packageId: Long): Option[PackageGoal]

  def getByPackageId(packageId: Long): Seq[PackageGoal]

  def getByCertificateId(certificateId: Long): Seq[PackageGoal]

  def getByCertificateIdCount(certificateId: Long): Int
}
