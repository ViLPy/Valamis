package com.arcusys.scorm.lms

import com.arcusys.learn.scorm.Archivements.{ AchievementUserStorage, AchievementStorage, AchievementRequiredStorage, AchievementActivityStorage }
import com.arcusys.learn.scorm.tracking.model.achivements._
import scala.collection.JavaConverters._
import com.arcusys.learn.scorm.tracking.model.achivements.AchievementUser
import com.arcusys.learn.scorm.tracking.model.achivements.RequiredActivity
import com.arcusys.learn.scorm.tracking.model.achivements.Achievement
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.arcusys.learn.liferay.services.SocialActivityLocalServiceHelper
import com.arcusys.learn.liferay.constants.QueryUtilHelper._

class AchievementServiceBL(implicit val bindingModule: BindingModule) extends Injectable {
  val achievementStorage = inject[AchievementStorage]
  val achievementRequiredStorage = inject[AchievementRequiredStorage]
  val achievementActivityStorage = inject[AchievementActivityStorage]
  val achievementUserStorage = inject[AchievementUserStorage]

  val achievementsOnPage = 3 //TODO 10? For test reasons this value.

  def createEmptyAchievement = {
    val achievement = Achievement()
    val id = achievementStorage.createAndGetID(achievement)
    achievement.copy(id = id)
  }

  def getPage(pageNum: Int, sortAZ: Boolean, filterString: String): Seq[Achievement] = {
    val achievements = achievementStorage.getAllAchievements
    val sortedAchievements = if (sortAZ) achievements.sortBy(_.title.toLowerCase) else achievements.sortBy(_.title.toLowerCase).reverse
    val filteredAchievements = sortedAchievements.filter(_.title.toLowerCase.contains(filterString.toLowerCase))
    if (pageNum == -1) filteredAchievements
    else filteredAchievements.drop((pageNum - 1) * achievementsOnPage).take(achievementsOnPage)
  }

  def getAchievementsTotalCount = achievementStorage.getAllAchievements.size

  def getTotalPageNumber = {
    val achievementCount = getAchievementsTotalCount
    if (achievementCount % achievementsOnPage > 0) achievementCount / achievementsOnPage + 1 else achievementCount / achievementsOnPage
  }

  def modify(achievement: Achievement) { achievementStorage.modify(achievement) }

  def deleteById(achievementId: Int) {
    achievementStorage.deleteById(achievementId)
    achievementRequiredStorage.deleteRequiredActivitiesByAchievementId(achievementId)
    achievementUserStorage.deleteByAchievementId(achievementId)
    val t = achievementActivityStorage.getByAchievementId(achievementId)
    t.foreach(achievementActivity => {
      val activities = SocialActivityLocalServiceHelper.getActivities(classOf[AchievementActivity].toString, ALL_POS, ALL_POS).asScala.filter(_.getClassPK == achievementActivity.id)
      activities.foreach(activity => SocialActivityLocalServiceHelper.deleteActivity(activity.getActivityId))
    })
  }

  def getRequiredAchievementActivities(id: Int) = achievementRequiredStorage.getRequiredAchievementActivities(id)

  def getUserSubscribedAchievements(userId: Int) = achievementUserStorage.getUserSubscribedAchievements(userId).map(achievementUser => achievementStorage.getByID(achievementUser.achievementId).getOrElse(throw new IllegalStateException("InconsistentDB")))

  def getSubscribedUsersByAchievementId(achievementId: Int) = achievementUserStorage.getByAchievementId(achievementId)

  def getCompletedByUserId(userId: Int) = achievementActivityStorage.getByUserId(userId)
}

class AchievementUserServiceBL(implicit val bindingModule: BindingModule) extends Injectable {
  val achievementUserStorage = inject[AchievementUserStorage]

  def createAchievementUser(achievementUser: AchievementUser): AchievementUser = {
    val id = achievementUserStorage.createAndGetIDAchievementUser(achievementUser)
    achievementUser.copy(id = id)
  }

  def deleteById(achievementUserId: Int) = {
    achievementUserStorage.deleteById(achievementUserId)
  }

  def getSubscribedUsersByAchievementId(achievementId: Int) = achievementUserStorage.getByAchievementId(achievementId)

  def getQuantitySubscribedUsersByAchievementId(achievementId: Int) = getSubscribedUsersByAchievementId(achievementId).size

  def getSubscribedUsersByUserId(userId: Int) = achievementUserStorage.getUserSubscribedAchievements(userId)

  def delete(userId: Int, achievementId: Int) {
    achievementUserStorage.getUserSubscribedAchievements(userId).foreach(achievementUser => if (achievementUser.achievementId == achievementId) deleteById(achievementUser.id))
  }
}

class RequiredActivityServiceBL(implicit val bindingModule: BindingModule) extends Injectable {
  val achievementStorage = inject[AchievementStorage]
  val achievementRequiredStorage = inject[AchievementRequiredStorage]
  val achievementActivityStorage = inject[AchievementActivityStorage]

  def getById(requiredActivityId: Int, achievementId: Int) = {
    achievementRequiredStorage.getRequiredAchievementActivities(achievementId).filter(_.id == requiredActivityId).apply(0)
  }

  def addRequiredActivity(requiredActivity: RequiredActivity) = {
    achievementRequiredStorage.addRequiredActivity(requiredActivity)
  }

  def updateRequiredActivity(requiredActivity: RequiredActivity) {
    achievementRequiredStorage.updateRequiredActivity(requiredActivity)
  }

  def deleteRequiredActivity(achievementId: Int) {
    achievementRequiredStorage.deleteRequiredActivity(achievementId)
  }

  def getRequiredAchievementActivities(id: Int) = achievementRequiredStorage.getRequiredAchievementActivities(id)

  def getQuantityRequiredActivities(id: Int) = getRequiredAchievementActivities(id).size

  def getQuantityCompletedRequiredActivities(userId: Int, activityClassName: String, id: Int) = {
    val userActivities = SocialActivityLocalServiceHelper.getUserActivities(userId, ALL_POS, ALL_POS).asScala
    val achievementStartDate = achievementStorage.getByID(id).get.startDate
    val userActivitiesAfterStartOfAchievement = userActivities.filter(_.getCreateDate > achievementStartDate.getMillis)
    userActivitiesAfterStartOfAchievement.count(_.getClassName == activityClassName)
  }

  //Get all activity names. Remove duplicates
  def getAvailableActivites = {
    var set = Set[String]()
    SocialActivityLocalServiceHelper.getSocialActivities(ALL_POS, ALL_POS).asScala.map(_.getClassName).filterNot { obj => val b = set(obj); set += obj; b }
  }
}

class AchievementActivityServiceBL(implicit val bindingModule: BindingModule) extends Injectable {
  val achievementStorage = inject[AchievementStorage]
  val achievementRequiredStorage = inject[AchievementRequiredStorage]
  val achievementActivityStorage = inject[AchievementActivityStorage]

  def ifUserCompletedAchievement(achievementId: Int, userId: Int) = {
    !achievementActivityStorage.getByAchievementAndUserIds(achievementId, userId).isEmpty
  }

  def createAndGetId(achievementActivity: AchievementActivity) = achievementActivityStorage.createAndGetID(achievementActivity)
}

class TestAchievementServiceBL(implicit val bindingModule: BindingModule) extends Injectable {
  val achievementServiceBL = new AchievementServiceBL()
  val achievementUserServiceBL = new AchievementUserServiceBL()

  val success = "Success: "
  val failure = "Failure: "

  def testAll: String = {
    testAchievementServiceBL + testAchievementUserServiceBL
  }

  def clean {
    while (!achievementServiceBL.getPage(1, true, "").isEmpty) {
      achievementServiceBL.getPage(1, true, "").foreach(achievement => achievementServiceBL.deleteById(achievement.id))
    }
  }

  def testAchievementServiceBL: String = {
    clean
    val stringBuilder = new StringBuilder
    stringBuilder ++=
      """
        |AchievementBLService
        |====================
      """.stripMargin

    val emptyAchievement = Achievement(
      id = -1,
      title = "New achievement",
      description = "Achievement info",
      logo = "/learn-portlet/img/certificate-default.jpg"
    )

    //Depends on each other
    {
      //Check create
      {
        var result = success
        if (achievementServiceBL.createEmptyAchievement.copy(id = -1) != emptyAchievement) result = failure
        stringBuilder ++= result
        stringBuilder ++= "create new empty Achievement\n"
      }

      //Check read
      {
        var result = success
        if (achievementServiceBL.getPage(1, true, "").size != 1) result = failure
        if (achievementServiceBL.getPage(2, true, "").size != 0) result = failure
        if (achievementServiceBL.getPage(1, true, "")(0).copy(id = -1) != emptyAchievement) result = failure
        stringBuilder ++= result
        stringBuilder ++= "read\n"
      }

      //Check delete
      {
        var result = success
        val id = achievementServiceBL.getPage(1, true, "")(0).id
        achievementServiceBL.deleteById(id)
        if (achievementServiceBL.getPage(1, true, "").size != 0) result = failure
        stringBuilder ++= result
        stringBuilder ++= "delete achievements\n"
      }
    }
    //Check update
    {
      var result = success
      achievementServiceBL.createEmptyAchievement
      val existing = achievementServiceBL.getPage(1, true, "")(0)
      val modified = existing.copy(title = "Test title", description = "Test description", logo = "Test logo")
      achievementServiceBL.modify(modified)
      if (achievementServiceBL.getPage(1, true, "")(0) != modified) result = failure
      achievementServiceBL.deleteById(modified.id)
      stringBuilder ++= result
      stringBuilder ++= "update Achievement\n"
    }

    //Check Empty required activities and users registered to compete
    {
      var result = success
      achievementServiceBL.createEmptyAchievement
      val existing = achievementServiceBL.getPage(1, true, "")(0)
      if (achievementServiceBL.getRequiredAchievementActivities(existing.id).size != 0) result = failure
      if (achievementServiceBL.getSubscribedUsersByAchievementId(existing.id).size != 0) result = failure
      achievementServiceBL.deleteById(existing.id)
      stringBuilder ++= result
      stringBuilder ++= "Required activities and users registered to compete are empty\n"
    }

    //Check pagination
    {
      var result = success
      achievementServiceBL.createEmptyAchievement
      achievementServiceBL.createEmptyAchievement
      achievementServiceBL.createEmptyAchievement
      achievementServiceBL.createEmptyAchievement

      if (achievementServiceBL.getPage(1, true, "").size != 3) result = failure
      if (achievementServiceBL.getPage(2, true, "").size != 1) result = failure

      stringBuilder ++= result
      stringBuilder ++= "Pagination\n"
    }

    stringBuilder.toString
  }

  def testAchievementUserServiceBL: String = {
    clean
    val userId = 1
    val stringBuilder = new StringBuilder
    stringBuilder ++=
      """
      |AchievementUserServiceBL+AchievementServiceBL
      |=============================================
      |""".stripMargin

    // Subscribe user to achievement
    {
      var result = success
      val createdAchievementId = achievementServiceBL.createEmptyAchievement.id

      val achievementUser = AchievementUser(
        id = -1,
        userId,
        createdAchievementId
      )
      val createdAchievementUser = achievementUserServiceBL.createAchievementUser(achievementUser)
      if (createdAchievementUser.id == -1) result = failure
      if (createdAchievementUser.copy(id = -1) != achievementUser) result = failure

      stringBuilder ++= result
      stringBuilder ++= "Create achievementUser(user subscribed to achievement)\n"
    }

    // Read achievement by userId
    {
      var result = success

      val achievementId = achievementUserServiceBL.getSubscribedUsersByUserId(userId).apply(0).achievementId
      val achievementIdByPage = achievementServiceBL.getPage(1, true, "").apply(0).id

      if (achievementId != achievementIdByPage) result = failure

      stringBuilder ++= result
      stringBuilder ++= "Method get by userId finds achievements\n"
    }

    // Unsubscribe user to Achievement
    {
      var result = success

      val achievementUser = achievementUserServiceBL.getSubscribedUsersByUserId(userId).apply(0)

      achievementUserServiceBL.deleteById(achievementUser.id)

      if (achievementUserServiceBL.getSubscribedUsersByUserId(userId).size != 0) result = failure

      stringBuilder ++= result
      stringBuilder ++= "Delete achievementUser(user unsubscribed to achievement)\n"
    }
    stringBuilder.toString
  }
}
