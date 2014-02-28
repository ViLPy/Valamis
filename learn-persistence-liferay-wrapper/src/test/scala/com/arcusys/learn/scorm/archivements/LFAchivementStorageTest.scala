package com.arcusys.learn.scorm.archivements

import org.specs2.mutable.SpecificationWithJUnit
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import com.arcusys.learn.scorm.tracking.model.achivements.{AchievementActivity, RequiredActivity, Achievement}
import com.arcusys.learn.scorm.Archivements.impl.AchievementEntityStorage

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class LFAchivementStorageTest extends FlatSpec with ShouldMatchers {
//  val achievementStorage = new AchievementEntityStorage{}
//
//  //TODO: add two entities
//
//  "LFAchivementStorageStub" should "retrieve all available achievements" in {
//    achievementStorage.getAll.length should be(4)
//
//    achievementStorage.getAll(0) should be (Achievement(
//      id = 1,
//      title = "Achievement1",
//      description = "Description1",
//      logo = "/learn-portlet/img/certificate-default.png",
//      activitiesRequired = List(RequiredActivity(1,"com.liferay.portlet.blogs.model.BlogsEntry", 2),RequiredActivity(2,"com.arcusys.learn.scorm.tracking.model.certificating.Certificate", 2))
//    ))
//
//    achievementStorage.getAll(1) should be(Achievement(
//      id = 2,
//      title = "Achievement2",
//      description = "Description2",
//      logo = "/learn-portlet/img/certificate-default.png",
//      activitiesRequired = List(RequiredActivity(3,"com.liferay.portlet.blogs.model.BlogsEntry", 3),RequiredActivity(4,"com.arcusys.learn.scorm.tracking.model.certificating.Certificate", 2))
//    ))
//  }
//
//  it should "retrieve by id" in {
//    achievementStorage.getByID(0) should be(None)
//    achievementStorage.getByID(1).get should be(Achievement(
//      id = 1,
//      title = "Achievement1",
//      description = "Description1",
//      logo = "/learn-portlet/img/certificate-default.png",
//      activitiesRequired = List(RequiredActivity(1,"com.liferay.portlet.blogs.model.BlogsEntry", 2),RequiredActivity(2,"com.arcusys.learn.scorm.tracking.model.certificating.Certificate", 2))
//    ))
//    achievementStorage.getByID(2).get should be(Achievement(
//      id = 2,
//      title = "Achievement2",
//      description = "Description2",
//      logo = "/learn-portlet/img/certificate-default.png",
//      activitiesRequired = List(RequiredActivity(3,"com.liferay.portlet.blogs.model.BlogsEntry", 3),RequiredActivity(4,"com.arcusys.learn.scorm.tracking.model.certificating.Certificate", 2))
//    ))
//    achievementStorage.getByID(5) should be(None)
//  }
//
//  it should "create new entity" in {
//    val id = achievementStorage.createAndGetID(Achievement(0,"newTitle","newDescription","logoSrc",List()))
//    id should be(5)
//    achievementStorage.getByID(5).get should be(Achievement(
//      id = 5,
//      title = "newTitle",
//      description = "newDescription",
//      logo = "logoSrc",
//      activitiesRequired = List()
//    ))
//  }
//
//  it should "delete new entity" in {
//    achievementStorage.deleteById(5)
//    achievementStorage.getAll.length should be(4)
//  }
//
//  it should "modify by Id" in {
//    val achievement = achievementStorage.getByID(2).get
//
//    val modified = achievement.copy(title = "newTitle",
//      description = "newDescription",
//      logo = "logoSrc",
//      activitiesRequired = List(RequiredActivity(99,"com.liferay.portlet.blogs.model.BlogsEntry", 2),RequiredActivity(99,"com.arcusys.learn.scorm.tracking.model.certificating.Certificate", 2))
//    )
//
//    achievementStorage.modify(modified)
//    achievementStorage.getByID(2).get should be(modified)
//
//    achievementStorage.modify(achievement)
//    achievementStorage.getByID(2).get should be(achievement)
//  }
//
//  it should "getEmptyAchievementActivities" in {
//    val achievementActivity = achievementStorage.getAchievementActivitiesByUserId(10180)
//    achievementActivity.length should be (0)
//  }
//
//  it should "add achievement activity" in {
//    achievementStorage.createAndGetIDAchievementActivity(AchievementActivity(100,10180,1))
//    val achievementActivities = achievementStorage.getAchievementActivitiesByUserId(10180)
//    achievementActivities.length should be(1)
//    achievementActivities.head should be(AchievementActivity(1,10180,1))
//  }
//
//  it should "delete achievement activity" in {
//    achievementStorage.deleteUserAchievementActivities(10180)
//    val achievementActivities = achievementStorage.getAchievementActivitiesByUserId(10180)
//    achievementActivities.length should be (0)
//  }
//
//  it should "add requiredActivity" in {
//    val achievement = achievementStorage.getByID(4).get
//    achievementStorage.addRequiredActivity(achievement, RequiredActivity(0,"com.liferay.portlet.blogs.model.BlogsEntry", 1))
//
//    achievementStorage.getByID(4).get should be(Achievement(4,"Achievement4","Description4","/learn-portlet/img/certificate-default.png",
//      List(
//        RequiredActivity(9,"com.liferay.portlet.blogs.model.BlogsEntry",1),
//        RequiredActivity(7,"com.liferay.portlet.blogs.model.BlogsEntry",5),
//        RequiredActivity(8,"com.arcusys.learn.scorm.tracking.model.certificating.Certificate",2)
//      )
//    ))
//  }
//
//  it should "modify required Activity" in {
//    achievementStorage.updateRequiredActivity(RequiredActivity(9,"Easy", 9))
//
//    achievementStorage.getByID(4).get should be(Achievement(4,"Achievement4","Description4","/learn-portlet/img/certificate-default.png",
//      List(
//        RequiredActivity(9,"Easy",9),
//        RequiredActivity(7,"com.liferay.portlet.blogs.model.BlogsEntry",5),
//        RequiredActivity(8,"com.arcusys.learn.scorm.tracking.model.certificating.Certificate",2)
//      )
//    ))
//  }
//
//  it should "delete required Activity" in {
//    achievementStorage.deleteRequiredActivity(9)
//
//    achievementStorage.getByID(4).get should be(Achievement(4,"Achievement4","Description4","/learn-portlet/img/certificate-default.png",
//      List(
//        RequiredActivity(7,"com.liferay.portlet.blogs.model.BlogsEntry",5),
//        RequiredActivity(8,"com.arcusys.learn.scorm.tracking.model.certificating.Certificate",2)
//      )
//    ))
//  }
}
