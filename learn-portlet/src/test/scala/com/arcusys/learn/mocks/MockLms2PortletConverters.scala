//package com.arcusys.learn.mocks
//
//import com.arcusys.learn.models.{ AchievementActivityModel, AchievementModel, UserModel }
//import com.arcusys.scorm.lms.models.{ AchievementRequiredActivityModel, AchievementModelBL }
//import org.scalamock.scalatest.MockFactory
//import org.scalatest.Suite
//import com.arcusys.learn.liferay.LiferayClasses._
//import org.scalamock.proxy.ProxyMockFactory
//
//trait MockLms2PortletConverters extends Suite with MockFactory with ProxyMockFactory {
//  trait data {
//    val user1 = mock[LUser]
//    user1 stubs 'getUserId returning 1.toLong
//    user1 stubs 'getFullName returning "John Watson"
//    user1 stubs 'getEmailAddress returning "jwatson@liferay.com"
//
//    val user2 = mock[LUser]
//    user2 stubs 'getUserId returning 2.toLong
//    user2 stubs 'getFullName returning "2John Watson"
//    user2 stubs 'getEmailAddress returning "2jwatson@liferay.com"
//
//    val users = List(user1, user2)
//
//    val expectedUserModel1 = UserModel(1, "John Watson", "/image/user_male_portrait?img_id=1", "jwatson@liferay.com")
//    val expectedUserModel2 = UserModel(2, "2John Watson", "/image/user_male_portrait?img_id=2", "2jwatson@liferay.com")
//
//    val expectedUserModels = List(expectedUserModel1, expectedUserModel2)
//
//    val achievementModelBLEmptyLists = AchievementModelBL(
//      1,
//      "Achievement1",
//      "Description",
//      "logo",
//      123456789,
//      false,
//      List[AchievementRequiredActivityModel](),
//      Nil
//    )
//
//    val expectedAchievementModelEmptyLists = AchievementModel(
//      1,
//      "Achievement1",
//      "Description",
//      "logo",
//      123456789,
//      false,
//      List[AchievementActivityModel](),
//      List[UserModel]()
//    )
//
//    val requiredActivityModel = AchievementRequiredActivityModel(1, "ActivityName", 1)
//
//    val requiredActivityList = List(
//      requiredActivityModel,
//      AchievementRequiredActivityModel(2, "ActivityName2", 2)
//    )
//
//    val expectedActivityModel = AchievementActivityModel(1, "ActivityName", "", 1)
//    val expectedActivityList = List(
//      expectedActivityModel,
//      AchievementActivityModel(2, "ActivityName2", "", 2)
//    )
//
//    val achievementModelBL = achievementModelBLEmptyLists.copy(
//      activities = requiredActivityList,
//      users = users
//    )
//
//    val expectedAchievementModel = expectedAchievementModelEmptyLists.copy(
//      activities = expectedActivityList,
//      users = expectedUserModels
//    )
//
//    val achievementModelBL2 = AchievementModelBL(
//      2,
//      "Achievement2",
//      "Description2",
//      "logo2",
//      1234567892,
//      true,
//      requiredActivityList,
//      users
//    )
//
//    val expectedAchievementModel2 = AchievementModel(
//      2,
//      "Achievement2",
//      "Description2",
//      "logo2",
//      1234567892,
//      true,
//      expectedActivityList,
//      expectedUserModels
//    )
//
//    val achievementModelBLList = List(achievementModelBL, achievementModelBL2)
//    val expectedAchievementModelList = List(expectedAchievementModel, expectedAchievementModel2)
//  }
//}
