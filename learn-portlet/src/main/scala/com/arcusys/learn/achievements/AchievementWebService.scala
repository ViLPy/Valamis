package com.arcusys.learn.achievements

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.web.{ServletBase,Translation}
import com.arcusys.scorm.lms._
import org.json4s._
import com.arcusys.scala.json.Json
import com.arcusys.learn.models.{GeneralResponse, GetAchievementResponseModel}
import com.arcusys.learn.service.util.{SessionHandler, AntiSamyHelper}
import java.util.Date
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.view.i18nSupport

class AchievementWebService(configuration: BindingModule) extends ServletBase(configuration) with i18nSupport with Translation{
  implicit val formats = DefaultFormats

  def this() = this(Configuration)

  val dataSource = inject[AchievementRepositoryContract]

  //TODO uncomment requireTeacherPermissions

  //TODO: remove, written by Artyom

  private def getAdminAchievements = {
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

    GetAchievementResponseModel(
      page,
      items.map(achievementModel => achievementModel.copy(
        description = achievementModel.description.replaceAll("\n"," "),
        activities = achievementModel.activities.map(activity => activity.copy(name = getTranslation.getOrElse(activity.name, activity.name))) //TODO: remove, written by Artyom
      )),
      dataSource.getCount)
  }

  private def getUserAchievements = {
    val companyId = getCompanyId
    val userId = getSessionUserID

    if (userId == -1 || companyId == -1)
      throw new UnsupportedOperationException

    val response = dataSource.getForUser(userId, companyId)
    GeneralResponse(data = response)
  }

  get("/")(action {
    val result = if (isAdmin)
      getAdminAchievements
    else
      getUserAchievements

    result
  })

  get("/all")(action{
    getAdminAchievements
  })

  get("/user")(action{
    getUserAchievements
  })

  post("/")(action {
    //requireTeacherPermissions()
    val response = dataSource.create()
    GeneralResponse(data = response)
  })

  post("/update/:achievementId")(action {
    //    requireTeacherPermissions()

    val result = dataSource.modify(
      parameter("achievementId").intRequired,
      AntiSamyHelper.sanitize(parameter("title").required),
      AntiSamyHelper.sanitize(parameter("description").required),
      parameter("logo").required,
      new Date(parameter("startDate").longRequired)
    )
    if (result)
      GeneralResponse()
    else throw new UnsupportedOperationException
  })

  post("/delete/:achievementId")(action {
    //    requireTeacherPermissions()
    val achievementId = parameter("achievementId").intRequired

    val result = dataSource.delete(achievementId)

    if (result == true)
      GeneralResponse()
    else throw new UnsupportedOperationException
  })

//  get("/user/:userId") {
//    //Get Achievements chosen by specified user.
//    val userId = parameter("userId").intRequired
//    getUserAchievements
//  }

  def action(a: => scala.Any): scala.Any = {
    try {
      val result = a

      if (result != null)
        Json.toJson(result)
    } catch {
      case e => {
        log(e.getMessage, e)
        halt(500)
      }
    }
  }
}
