package com.arcusys.valamis.certificate.storage

import com.arcusys.valamis.certificate.model.goal.StatementGoal
import com.arcusys.valamis.model.PeriodTypes
import com.arcusys.valamis.model.PeriodTypes.PeriodType

/**
 * Created by mminin on 02.03.15.
 */
trait StatementGoalStorage {

  def create(certificateId: Long, verb: String, obj: String, periodValue: Int, periodType: PeriodType): StatementGoal

  def delete(certificateId: Long, verb: String, obj: String): Unit

  def modify(certificateId: Long, verb: String, obj: String, periodValue: Int, periodType: PeriodType): StatementGoal

  def get(certificateId: Long, verb: String, obj: String): Option[StatementGoal]

  def getByVerbAndObj(verb: String, obj: String): Seq[StatementGoal]

  def getByCertificateId(certificateId: Long): Seq[StatementGoal]

  def getByCertificateIdCount(certificateId: Long): Int

}
