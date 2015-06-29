package com.arcusys.valamis.certificate.storage

import com.arcusys.valamis.certificate.model.goal.ActivityGoal
import com.arcusys.valamis.model.PeriodTypes
import com.arcusys.valamis.model.PeriodTypes.PeriodType

/**
 * Created by mminin on 04.03.15.
 */
trait ActivityGoalStorage {
  def create(certificateId: Long, activityName: String, count: Int, periodValue: Int, periodType: PeriodType): ActivityGoal
  def modify(certificateId: Long, activityName: String, count: Int, periodValue: Int, periodType: PeriodType): ActivityGoal
  def delete(certificateId: Long, activityName: String): Unit

  def get(certificateId: Long, activityName: String): Option[ActivityGoal]

  def getByActivityName(activityName: String): Seq[ActivityGoal]

  def getByCertificateId(certificateId: Long): Seq[ActivityGoal]
  def getByCertificateIdCount(certificateId: Long): Int
}
