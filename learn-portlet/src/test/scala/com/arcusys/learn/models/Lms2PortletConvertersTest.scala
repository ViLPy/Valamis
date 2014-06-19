//package com.arcusys.learn.models
//
//import org.junit.runner.RunWith
//import org.scalatest.FlatSpec
//import Lms2PortletConverters._
//import com.arcusys.learn.mocks.MockLms2PortletConverters
//
//@RunWith(classOf[org.scalatest.junit.JUnitRunner])
//class Lms2PortletConvertersTest extends FlatSpec with MockLms2PortletConverters {
//  behavior of "Lms2PortletConverters"
//
//  it should "convert from User to UserModel" in new data {
//    val userModel: UserModel = user1
//
//    assert(expectedUserModel1 === userModel)
//  }
//
//  it should "convert from List[User] to List[UserModel]" in new data {
//    val userModels: List[UserModel] = users
//
//    assert(userModels === expectedUserModels)
//  }
//
//  it should "convert from AchievementRequiredActivityModel to AchievementActivityModel" in new data {
//    val activityModel: AchievementActivityModel = requiredActivityModel
//
//    assert(activityModel === expectedActivityModel)
//  }
//
//  it should "convert from List[AchievementRequiredActivityModel] to List[AchievementActivityModel]" in new data {
//    val activityModelList: List[AchievementActivityModel] = requiredActivityList
//
//    assert(activityModelList === expectedActivityList)
//  }
//
//  it should "convert from AchievementModelBL(empty internal Lists) to AchievementModel" in new data {
//    val achievementModelEmptyLists: AchievementModel = achievementModelBLEmptyLists
//
//    assert(achievementModelEmptyLists === expectedAchievementModelEmptyLists)
//  }
//
//  it should "convert from AchievementModelBL to AchievementModel" in new data {
//    val achievementModel: AchievementModel = achievementModelBL
//
//    assert(achievementModel === expectedAchievementModel)
//  }
//
//  it should "convert from List[AchievementModelBL] to List[AchievementModel]" in new data {
//    val achievementModelList: List[AchievementModel] = achievementModelBLList
//
//    assert(achievementModelList === expectedAchievementModelList)
//  }
//}
