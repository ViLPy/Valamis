package com.arcusys.learn.achievements

import com.arcusys.learn.ioc.Configuration
import com.arcusys.scorm.lms._
import com.arcusys.learn.models.{AchievementActivityModel, AchievementModel, GeneralResponse, GetAchievementResponseModel}
import com.arcusys.learn.service.util.AntiSamyHelper
import java.util.Date
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.models.Lms2PortletConverters._
import com.arcusys.learn.exceptions.{AccessDeniedException, BadRequestException}

class AchievementWebService(configuration: BindingModule) extends BaseWebService(configuration){
  def this() = this(Configuration)

  val dataSource = inject[AchievementRepositoryContract]

  get("/") (action {
    val action = parameter("action").required

    action match {
      case "all" => getAllAchievements()                // service/achievement?action=all
      case "currentUser" => getUserAchievements()       // service/achievement?action=currentUser
      case "user" => {                                  // service/achievement?action=user&userId=...
        val userId = parameter("userId").intRequired
        getUserAchievements(userId)
      }
      case _ => throw new BadRequestException()
    }
  })

  post("""/(\d*)""".r)(action {
    requireTeacherPermissions()

    val action = parameter("action").required
    val result = action match {
      case "add" => addAchievement()
      case "update" => updateAchievement()
      case "delete" => deleteAchievement()
      case _ => throw new BadRequestException()
    }

    GeneralResponse(data = result)
  })

  post("""/activity/(\d*)""".r) (action {
    requireTeacherPermissions()

    val action = parameter("action").required
    val result = action match {
      case "add" => addActivity()
      case "update" => updateActivity()
      case "delete" => deleteActivity()
      case _ => throw new BadRequestException()
    }

    GeneralResponse(data = result)
  })

  post("/:achievementId/user/:userId")(action {

    val action = parameter("action").required
    val result = action match {
      case "apply" => applyAchievement()             // service/achievement/.../user/.../?action=apply
      case "remove" => removeAchievement()           // service/achievement/.../user/.../?action=remove
      case _ => throw new BadRequestException()
    }

    GeneralResponse(data = result)
  })

  private def getAllAchievements(): GetAchievementResponseModel = {
    val page = parameter("page").intRequired
    val sortDirection = parameter("sortAZ").booleanRequired
    val count = parameter("count").intRequired
    val filter = parameter("filter").option
    val items = dataSource.get(
      page,
      filter,
      sortDirection,
      count,
      getCompanyId)

    // TODO Remove translation
    val records: List[AchievementModel] = items
    val translatedRecords = records.map(
      record => record.copy(activities = record.activities.map(
        activity => {
          val a = activity:AchievementActivityModel
          a.copy(translate = getTranslation().getOrElse(a.name, a.name))
        })))

    GetAchievementResponseModel(
      page,
      translatedRecords,
      dataSource.getCount)
  }

  private def getUserAchievements(): GeneralResponse = {
    getUserAchievements(getSessionUserID)
  }

  private def getUserAchievements(userId: Int): GeneralResponse = {
    val companyId = getCompanyId

    if (userId == -1 || companyId == -1)
      throw new UnsupportedOperationException

    val response = dataSource.getForUser(userId, getCompanyId)
    GeneralResponse(data = response)
  }

  private def addAchievement(): AchievementModel = {
    dataSource.create()
  }

  private def updateAchievement() {
    val achievementId = multiParams("captures").head.toInt

    dataSource.modify(
      achievementId,
      AntiSamyHelper.sanitize(parameter("title").required),
      AntiSamyHelper.sanitize(parameter("description").required),
      parameter("logo").required,
      new Date(parameter("startDate").longRequired))
  }

  private def deleteAchievement() {
    val achievementId = multiParams("captures").head.toInt
    dataSource.delete(achievementId)
  }

  private def addActivity(): AchievementActivityModel = {
    val achievementId = parameter("achievementId").intRequired
    val activityClassName = parameter("activityClassName").required
    val activity = dataSource.addActivity(achievementId, activityClassName)
    val achievementActivityModel = activity:AchievementActivityModel
    achievementActivityModel.copy(translate = getTranslation()
      .getOrElse(achievementActivityModel.name, achievementActivityModel.name))
  }

  private def updateActivity() {
    val activityId = multiParams("captures").head.toInt
    val achievementId = parameter("achievementId").intRequired
    val count = parameter("numberActivitiesRequired").intRequired
    dataSource.updateActivity(activityId, achievementId, count)
  }

  private def deleteActivity() {
    val activityId = multiParams("captures").head.toInt
    dataSource.removeActivity(activityId)
  }

  private def applyAchievement() = {
    val userId = parameter("userId").intRequired
    val achievementId = parameter("achievementId").intRequired

    if(!isAdmin && userId != getSessionUserID)
      throw new AccessDeniedException()

    dataSource.applyAchievementForUser(userId, achievementId)
  }

  private def removeAchievement() = {
    val userId = parameter("userId").intRequired
    val achievementId = parameter("achievementId").intRequired

    if(!isAdmin && userId != getSessionUserID)
      throw new AccessDeniedException()

    dataSource.removeAchievementForUser(userId, achievementId)
  }
}
