package com.arcusys.scorm.lms

import org.scalatest.{ Matchers, FlatSpec }
import org.scalamock.scalatest.MockFactory
import com.arcusys.learn.scorm.Archivements._
import com.escalatesoft.subcut.inject.NewBindingModule

/**
 * Created by iliya.tryapitsin on 20.01.14.
 */
abstract class BaseRepositoryTest extends FlatSpec with Matchers with MockFactory {
  protected lazy val achievementStorage = mock[AchievementStorage]
  protected lazy val achievementRequiredStorage = mock[AchievementRequiredStorage]
  protected lazy val achievementActivityStorage = mock[AchievementActivityStorage]
  protected lazy val achievementUserStorage = mock[AchievementUserStorage]

  def configuration(
    achievement: AchievementStorage = achievementStorage,
    achievementRequired: AchievementRequiredStorage = achievementRequiredStorage,
    achievementActivity: AchievementActivityStorage = achievementActivityStorage,
    achievementUser: AchievementUserStorage = achievementUserStorage) = new NewBindingModule({
    implicit module =>
      import module._
      bind[AchievementStorage] toSingle achievement
      bind[AchievementRequiredStorage] toSingle achievementRequired
      bind[AchievementActivityStorage] toSingle achievementActivity
      bind[AchievementUserStorage] toSingle achievementUser
  })

}

