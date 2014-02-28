package com.arcusys.learn.achievements

import com.arcusys.learn.web.ServletBase
import org.json4s.DefaultFormats
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.scorm.tracking.model.achivements.AchievementUser
import com.arcusys.scorm.lms.AchievementUserServiceBL
import com.escalatesoft.subcut.inject.BindingModule

class AchievementUserService(configuration: BindingModule) extends ServletBase(configuration){
  implicit val formats = DefaultFormats
  def this() = this(Configuration)

  val achievementUserServiceBL = new AchievementUserServiceBL

  // TODO uncomment requireTeacherPermissions.
  // TODO: Remove. Use // service/achievement/.../user/.../?action=apply
  post("/"){
    //    requireTeacherPermissions()
    val createdUser = AchievementUser(userId = parameter("userId").intRequired, achievementId = parameter("achievementId").intRequired)
    val createdAchievement = achievementUserServiceBL.createAchievementUser(createdUser)

    json(createdAchievement)
  }

  // TODO: Remove. Use // service/achievement/.../user/.../?action=remove
  post("/delete/:achievementUserId"){
    //    requireTeacherPermissions()
    val achievementUserId = parameter("achievementUserId").intRequired

    achievementUserServiceBL.deleteById(achievementUserId)
  }

  // TODO: Remove. Use // service/achievement/.../user/.../?action=remove
  post("/delete/"){
    achievementUserServiceBL.delete(userId = parameter("userId").intRequired, achievementId = parameter("achievementId").intRequired)
  }

  // TODO
  get("/achievement/:achievementId"){
    val achievementId = parameter("achievementId").intRequired
    val users = achievementUserServiceBL.getSubscribedUsersByAchievementId(achievementId)

    json(users)
  }

  get("/userId/:userId") { //Get Achievements chosen by specified user
    val userId = parameter("userId").intRequired
    val users = achievementUserServiceBL.getSubscribedUsersByUserId(userId)

    json(users)
  }
}
