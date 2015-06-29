package com.arcusys.valamis.certificate.repository

import javax.inject.Inject

import com.arcusys.valamis.certificate.model.goal.PackageGoal
import com.arcusys.valamis.certificate.schema.PackageGoalTableComponent
import com.arcusys.valamis.certificate.storage.PackageGoalStorage
import com.arcusys.valamis.core.{SlickDBInfo, SlickProfile}
import com.arcusys.valamis.model.PeriodTypes._
import com.escalatesoft.subcut.inject.{Injectable, BindingModule}

import scala.slick.driver.JdbcProfile
import scala.slick.jdbc.JdbcBackend

class PackageGoalStorageImpl @Inject() (val db: JdbcBackend#DatabaseDef,
                                        val driver: JdbcProfile)
  extends PackageGoalStorage
  with PackageGoalTableComponent
  with SlickProfile {

  import driver.simple._

  def create(packageGoal: PackageGoal) = db.withSession { implicit session =>
    packageGoals.insert(packageGoal)
    get(packageGoal.certificateId, packageGoal.packageId).get
  }
  override def get(certificateId: Long, packageId: Long) = db.withSession(implicit session => packageGoals.filter(ag => ag.certificateId === certificateId && ag.packageId === packageId).firstOption)
  def getBy(packageId: Option[Long] = None, certificateId: Option[Long] = None) = db.withSession(implicit session => composeQuery(packageId, certificateId).run)
  def getCountBy(packageId: Option[Long] = None, certificateId: Option[Long] = None) = db.withSession(implicit session => composeQuery(packageId, certificateId).length.run)
  def update(packageGoal: PackageGoal) = db.withSession{ implicit session =>
    packageGoals.filter(ag => ag.certificateId === packageGoal.certificateId && ag.packageId === packageGoal.packageId).update(packageGoal)
    get(packageGoal.certificateId, packageGoal.packageId).get
  }
  override def delete(certificateId: Long, packageId: Long) = db.withSession(implicit session => packageGoals.filter(ag => ag.certificateId === certificateId && ag.packageId === packageId).delete)

  def composeQuery(packageId: Option[Long] = None, certificateId: Option[Long] = None)(implicit session: JdbcBackend#Session) = {
    val collection = packageGoals
    val courseIdFiltered = if(packageId.isDefined) collection.filter(_.packageId === packageId.get) else collection

    if(certificateId.isDefined) courseIdFiltered.filter(_.certificateId === certificateId.get) else courseIdFiltered
  }

  override def create(certificateId: Long, packageId: Long, periodValue: Int, periodType: PeriodType): PackageGoal = create(PackageGoal(certificateId, packageId, periodValue, periodType))

  override def modify(certificateId: Long, packageId: Long, periodValue: Int, periodType: PeriodType): PackageGoal = update(PackageGoal(certificateId, packageId, periodValue, periodType))

  override def getByPackageId(packageId: Long): Seq[PackageGoal] = getBy(packageId = Some(packageId))

  override def getByCertificateId(certificateId: Long): Seq[PackageGoal] = getBy(certificateId = Some(certificateId))

  override def getByCertificateIdCount(certificateId: Long): Int = getCountBy(certificateId = Some(certificateId))
}
