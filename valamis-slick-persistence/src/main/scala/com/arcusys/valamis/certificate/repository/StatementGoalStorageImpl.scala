package com.arcusys.valamis.certificate.repository

import javax.inject.Inject

import com.arcusys.valamis.certificate.model.goal.StatementGoal
import com.arcusys.valamis.certificate.schema.StatementGoalTableComponent
import com.arcusys.valamis.certificate.storage.StatementGoalStorage
import com.arcusys.valamis.core.{SlickDBInfo, SlickProfile}
import com.arcusys.valamis.model.PeriodTypes._
import com.escalatesoft.subcut.inject.{Injectable, BindingModule}

import scala.slick.driver.JdbcProfile
import scala.slick.jdbc.JdbcBackend

class StatementGoalStorageImpl @Inject() (val db: JdbcBackend#DatabaseDef,
                                          val driver: JdbcProfile)
  extends StatementGoalStorage
  with StatementGoalTableComponent
  with SlickProfile {

  import driver.simple._

  def create(statementGoal: StatementGoal) = db.withSession { implicit session =>
    statementGoals.insert(statementGoal)
    get(statementGoal.certificateId, statementGoal.verb, statementGoal.obj).get
  }
  override def get(certificateId: Long, verb: String, obj: String) = db.withSession(implicit session => statementGoals.filter(ag => ag.certificateId === certificateId && ag.verb === verb && ag.obj === obj).firstOption)
  def getBy(verb: Option[String] = None, obj: Option[String] = None, certificateId: Option[Long] = None) = db.withSession(implicit session => composeQuery(verb, obj, certificateId).run)
  def getCountBy(verb: Option[String] = None, obj: Option[String] = None, certificateId: Option[Long] = None) = db.withSession(implicit session => composeQuery(verb, obj, certificateId).length.run)
  def update(statementGoal: StatementGoal) = db.withSession{ implicit session =>
    statementGoals.filter(ag => ag.certificateId === statementGoal.certificateId && ag.verb === statementGoal.verb && ag.obj === statementGoal.obj).update(statementGoal)
    get(statementGoal.certificateId, statementGoal.verb, statementGoal.obj).get
  }
  override def delete(certificateId: Long, verb: String, obj: String) = db.withSession(implicit session => statementGoals.filter(ag => ag.certificateId === certificateId && ag.verb === verb && ag.obj === obj).delete)

  private def composeQuery(verb: Option[String] = None, obj: Option[String] = None, certificateId: Option[Long] = None)(implicit session: JdbcBackend#Session) = {
    val collection = statementGoals
    val verbFiltered = if(verb.isDefined) collection.filter(_.verb === verb.get) else collection
    val objFiltered = if(obj.isDefined) verbFiltered.filter(_.obj === obj.get) else verbFiltered

    if(certificateId.isDefined) objFiltered.filter(_.certificateId === certificateId.get) else objFiltered
  }

  override def create(certificateId: Long, verb: String, obj: String, periodValue: Int, periodType: PeriodType): StatementGoal = create(StatementGoal(certificateId, verb,obj, periodValue, periodType))

  override def modify(certificateId: Long, verb: String, obj: String, periodValue: Int, periodType: PeriodType): StatementGoal = update(StatementGoal(certificateId, verb,obj, periodValue, periodType))

  override def getByVerbAndObj(verb: String, obj: String): Seq[StatementGoal] = getBy(verb = Some(verb), obj = Some(obj))

  override def getByCertificateId(certificateId: Long): Seq[StatementGoal] = getBy(certificateId = Some(certificateId))

  override def getByCertificateIdCount(certificateId: Long): Int = getCountBy(certificateId = Some(certificateId))
}
