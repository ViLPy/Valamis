package com.arcusys.scorm.lms

import scala.util.Random
import org.junit.runner.RunWith
import com.arcusys.scorm.lms.exceptions.AchievementNotFoundException
import com.arcusys.scorm.lms.models.{UserModel, AchievementRequiredActivityModel, AchievementModelBL}
import com.arcusys.learn.scorm.tracking.model.achivements.Achievement

/**
 * Created by iliya.tryapitsin on 20.01.14.
 */
@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class AchievementRepositoryTest extends BaseRepositoryTest  {

  "A achievement repository" should "create new achievement and return business model" in {

    val rnd = new Random
    val achievementId = rnd.nextInt()
    achievementStorage
      .expects('createAndGetID)
      .returns(achievementId)

    val achievementRepository = new AchievementRepository()(configuration)
    val result = achievementRepository.create()

    result.id should be(achievementId)
  }

  it should "return achievement by id" in {
    val rnd = new Random
    val achievementId = rnd.nextInt()
    achievementStorage
      .expects('getByID)
      .returns(Option(Achievement(
        achievementId,
        "Test title",
        "Test description",
        "Test logo")))

    val achievementRepository = new AchievementRepository()(configuration)
    val result = achievementRepository.get(achievementId)

    result.id should be{achievementId}
  }

  it should "throw exception when achievement not exist" in {

    val rnd = new Random
    val achievementId = rnd.nextInt()
    achievementStorage
      .expects('getByID)
      .returns(None)

    val achievementRepository = new AchievementRepository()(configuration)
    intercept[AchievementNotFoundException] {
      achievementRepository.get(achievementId)
    }
  }
}
