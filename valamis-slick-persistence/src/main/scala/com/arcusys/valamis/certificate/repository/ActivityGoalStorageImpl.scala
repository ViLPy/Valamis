package com.arcusys.valamis.certificate.repository

import com.arcusys.valamis.certificate.model.goal.ActivityGoal
import com.arcusys.valamis.certificate.schema.ActivityGoalTableComponent
import com.arcusys.valamis.certificate.storage.ActivityGoalStorage
import com.arcusys.valamis.core.SlickProfile
import com.arcusys.valamis.model.PeriodTypes.PeriodType
import scala.slick.driver.JdbcProfile
import scala.slick.jdbc.JdbcBackend

class ActivityGoalStorageImpl (val db:     JdbcBackend#DatabaseDef,
                               val driver: JdbcProfile)
  extends ActivityGoalStorage
  with ActivityGoalTableComponent
  with SlickProfile {

  import driver.simple._

  def create(activityGoal: ActivityGoal) = db.withSession { implicit session =>
    activityGoals.insert(activityGoal)
    get(activityGoal.certificateId, activityGoal.activityName).get
  }
  def getBy(activityName: Option[String] = None, certificateId: Option[Long] = None) = db.withSession(implicit session => composeQuery(activityName, certificateId).run)
  def getCountBy(activityName: Option[String] = None, certificateId: Option[Long] = None) = db.withSession(implicit session => composeQuery(activityName, certificateId).length.run)
  def update(activityGoal: ActivityGoal) = db.withSession{ implicit session =>
      activityGoals.filter(ag => ag.certificateId === activityGoal.certificateId.toLong && ag.activityName === activityGoal.activityName).update(activityGoal)
      get(activityGoal.certificateId, activityGoal.activityName).get
  }
  private def composeQuery(activityName: Option[String] = None, certificateId: Option[Long] = None)(implicit session: JdbcBackend#Session) = {
    val collection = activityGoals
    val activityNameFiltered = if(activityName.isDefined) collection.filter(_.activityName === activityName.get) else collection

    if(certificateId.isDefined) activityNameFiltered.filter(_.certificateId === certificateId.get) else activityNameFiltered
  }

  override def create(certificateId: Long, activityName: String, count: Int, periodValue: Int, periodType: PeriodType): ActivityGoal = create(ActivityGoal(certificateId.toInt, activityName, count, periodValue, periodType))
  override def modify(certificateId: Long, activityName: String, count: Int, periodValue: Int, periodType: PeriodType): ActivityGoal = update(ActivityGoal(certificateId.toInt, activityName, count, periodValue, periodType))
  override def getByActivityName(activityName: String): Seq[ActivityGoal] = getBy(activityName = Some(activityName))
  override def getByCertificateId(certificateId: Long): Seq[ActivityGoal] = getBy(certificateId = Some(certificateId))
  override def getByCertificateIdCount(certificateId: Long): Int = getCountBy(certificateId = Some(certificateId))
  override def get(certificateId: Long, activityName: String) = db.withSession(implicit session => activityGoals.filter(ag => ag.certificateId === certificateId && ag.activityName === activityName).firstOption)
  override def delete(certificateId: Long, activityName: String) = db.withSession(implicit session => activityGoals.filter(ag => ag.certificateId === certificateId && ag.activityName === activityName).delete)
}
