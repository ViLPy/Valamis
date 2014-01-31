package com.arcusys.scorm.lms

import com.arcusys.learn.scorm.tracking.model.achivements.{ Achievement}
import com.arcusys.scorm.lms.models._
import java.util.Date

/**
 * Created with IntelliJ IDEA.
 * User: iliya.tryapitsin
 * Date: 09.01.14
 * Time: 17:19
 * To change this template use File | Settings | File Templates.
 */
trait AchievementRepositoryContract {
  def create(): AchievementModel
  def delete(id: Int): Boolean
  def get(page: Int, filter: Option[String], sortDirection: Boolean, countOnPage: Int, companyId: Int): List[AchievementModel]
  def get(id: Int): Achievement
  def getActivities(id: Int): List[AchievementRequiredActivityModel]
  def getCount: Int
  def getForUser(id: Int, companyId: Int): List[AchievementModel]
  def getUsers(id: Int, companyId: Int): List[UserModel]
  def modify(achievement: Achievement)
  def modify(
    id: Int,
    title: String,
    description: String,
    logo: String,
    startDate: Date): Boolean
}
