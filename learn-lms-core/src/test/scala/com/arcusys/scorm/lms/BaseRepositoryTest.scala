package com.arcusys.scorm.lms

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory
import com.arcusys.learn.scorm.Archivements._
import com.escalatesoft.subcut.inject.NewBindingModule


/**
 * Created by iliya.tryapitsin on 20.01.14.
 */
abstract class BaseRepositoryTest extends FlatSpec with ShouldMatchers with MockFactory with ProxyMockFactory {
  protected val achievementStorage = mock[AchievementStorage]
  protected val achievementRequiredStorage = mock[AchievementRequiredStorage]
  protected val achievementActivityStorage = mock[AchievementActivityStorage]
  protected val achievementUserStorage = mock[AchievementUserStorage]

  val configuration = new NewBindingModule({
    implicit module =>
      import module._
      bind[AchievementStorage] toSingle achievementStorage
      bind[AchievementRequiredStorage] toSingle achievementRequiredStorage
      bind[AchievementActivityStorage] toSingle achievementActivityStorage
      bind[AchievementUserStorage] toSingle achievementUserStorage
  })


}

