package com.arcusys.scorm.lms

import scala.util.Random
import org.junit.runner.RunWith
import com.arcusys.scorm.lms.exceptions.AchievementNotFoundException
import com.arcusys.learn.scorm.tracking.model.achivements.Achievement
import com.arcusys.learn.scorm.Archivements.AchievementStorage

/**
 * Created by iliya.tryapitsin on 20.01.14.
 */
@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class AchievementRepositoryTest extends BaseRepositoryTest {

  "A achievement repository" should "create new achievement and return business model" in {
    val rnd = new Random
    val achievementId = rnd.nextInt()

    val mockAchievement = mock[AchievementStorage]
    (mockAchievement.createAndGetID _) expects * returns achievementId

    val achievementRepository = new AchievementRepository()(configuration(achievement = mockAchievement))
    val result = achievementRepository.create()

    result.id should be(achievementId)
  }

  it should "return achievement by id" in {
    val rnd = new Random
    val achievementId = rnd.nextInt()

    val mockAchievement = mock[AchievementStorage]
    (mockAchievement.getByID _) expects achievementId returns Some(Achievement(
      id = achievementId,
      title = "Test title",
      description = "Test description",
      logo = "Test logo"
    ))

    val achievementRepository = new AchievementRepository()(configuration(achievement = mockAchievement))
    val result = achievementRepository.get(achievementId)

    result.id should be { achievementId }
  }

  it should "throw exception when achievement not exist" in {
    val rnd = new Random
    val achievementId = rnd.nextInt()

    val mockAchievement = mock[AchievementStorage]
    (mockAchievement.getByID _) expects achievementId returning None

    val achievementRepository = new AchievementRepository()(configuration(achievement = mockAchievement))
    intercept[AchievementNotFoundException] {
      achievementRepository.get(achievementId)
    }
  }
}
