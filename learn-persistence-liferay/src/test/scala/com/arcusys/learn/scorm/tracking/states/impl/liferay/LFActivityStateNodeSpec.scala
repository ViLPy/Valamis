package com.arcusys.learn.scorm.tracking.states.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalServiceUtil
import org.specs2.specification.Scope

class LFActivityStateNodeSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {
  "Mockito" should {
    "mock service method" in new Context {
      LFActivityStateNodeLocalServiceUtil.createLFActivityStateNode() must not(throwA[Exception])

      there was atLeastOne(activityStateNodeService).createLFActivityStateNode()
    }
  }

  trait Context extends Scope {
    // do initialize mock services
    val activityStateNodeService = ActivityStateNodeEntityContainer.mockLocalService

    /*val activityStateNodeStorage: EntityStorage[ActivityStateNode] = new LFActivityStateNodeStorageImpl with ActivityStateNodeCreator {
      def activityStateStorage = LFStorages
    }*/

  }
}
