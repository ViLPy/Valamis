package com.arcusys.learn.achievements

import com.arcusys.learn.scorm.tracking.model.achivements._
import com.arcusys.learn.web.ServletBase
import org.json4s.DefaultFormats
import com.arcusys.learn.ioc.Configuration
import com.arcusys.scorm.lms.RequiredActivityServiceBL
import com.arcusys.learn.view.i18nSupport
import com.arcusys.learn.service.util.SessionHandler
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.scorm.lms.models.{ActivityModelBL}


class RequiredActivityService(configuration: BindingModule) extends BaseWebService(configuration) with i18nSupport{
  def this() = this(Configuration)

  val requiredActivityServiceBL = new RequiredActivityServiceBL()

  //TODO uncomment requireTeacherPermissions.

  def convertToMap(translations: Map[String,String], activity: String) = {
    Map("activityClassName" -> translations.getOrElse(activity,activity))
  }

  get("/achievement/:id"){ //Get activities required to complete specified achievement
  val id = parameter("id").intRequired
    val activities = requiredActivityServiceBL.getRequiredAchievementActivities(id)

    val userId = getSessionUserID

    val translations = getTranslation

    request.getRemoteUser
    def requiredActivityToMap(requiredActivity: RequiredActivity) = {
      val activityClassName = requiredActivity.activityClassName

      Map("id" -> requiredActivity.id,
        "achievementId" -> requiredActivity.achievementId,
        "activityClassName" -> translations.getOrElse(activityClassName, activityClassName),
        "numberActivitiesCompleted" -> requiredActivityServiceBL.getQuantityCompletedRequiredActivities(userId, requiredActivity.activityClassName, id),
        "numberActivitiesRequired" -> requiredActivity.numberActivitiesRequired)
    }
    json(activities.map(requiredActivityToMap))
  }

  post("/"){
//    requireTeacherPermissions()

    val translations = getTranslation
    val invertedTranslations = translations.map(_.swap)

    val achievementId = parameter("achievementId").intRequired
    val activityClassName = parameter("activityClassName").required

    val activity:RequiredActivity = RequiredActivity(
      achievementId = achievementId,
      activityClassName = invertedTranslations.getOrElse(activityClassName, activityClassName)
    )



    val id = requiredActivityServiceBL.addRequiredActivity(activity)

    json(activity.copy(id = id, activityClassName = translations.getOrElse(activity.activityClassName,activity.activityClassName)))
  }

  post("/update/:activityId"){
//    requireTeacherPermissions()
    val activityId = parameter("activityId").intRequired
    val achievementId = parameter("achievementId").intRequired
    val activity = RequiredActivity(
      activityId,
      achievementId,
      requiredActivityServiceBL.getById(activityId, achievementId).activityClassName,
      parameter("numberActivitiesRequired").intRequired)

    requiredActivityServiceBL.updateRequiredActivity(activity)
  }

  post("/delete/:activityId"){
//    requireTeacherPermissions()
    val achievementId = parameter("activityId").intRequired
    requiredActivityServiceBL.deleteRequiredActivity(achievementId)
  }
}

