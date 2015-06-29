package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalServiceUtil
import com.arcusys.valamis.lesson.scorm.model.manifest._
import org.specs2.matcher.ThrownExpectations
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.specification.Scope
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay.LFChildrenSelectionStorageImpl

/**
 * User: Yulia.Glushonkova
 * Date: 02.04.13
 */
class LFChildrenSelectionSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {

  "Mockito" should {
    "mock service method" in new Context {
      LFChildrenSelectionLocalServiceUtil.createLFChildrenSelection() must not(throwA[Exception])
      there was atLeastOne(childrenSelectionService).createLFChildrenSelection()
    }
  }
  "LFChildrenSelectionStorageImpl" should {

    "execute 'create' without errors" in new Context {
      childrenSelectionStorage.create(new ChildrenSelection(RandomizationTimingType.OnEachNewAttempt), "sequencingID" -> 100) must not(throwA[Exception])
      childrenSelectionStorage.create(new ChildrenSelection(10, RandomizationTimingType.OnEachNewAttempt), "sequencingID" -> 100) must not(throwA[Exception])
      childrenSelectionStorage.create(new ChildrenSelection(10, RandomizationTimingType.Once, RandomizationTimingType.OnEachNewAttempt), "sequencingID" -> 100) must not(throwA[Exception])
    }
    "execute 'get' without errors" in new Context {
      //childrenSelectionStorage.create(new ChildrenSelection(RandomizationTimingType.Never), "sequencingID"-> 200) must not(throwA[Exception])
      //val fetched = childrenSelectionStorage.getOne("sequencingID"-> 200)
      //fetched must beSome
      //fetched.get.take must beNone
      //fetched.get.reorder must beEqualTo(Some(RandomizationTimingType.Never))

      childrenSelectionStorage.create(new ChildrenSelection(10, RandomizationTimingType.OnEachNewAttempt), "sequencingID" -> 300) must not(throwA[Exception])
      val fetched2 = childrenSelectionStorage.getOne("sequencingID" -> 300)
      fetched2 must beSome
      fetched2.get.take.get.count must beEqualTo(10)
      fetched2.get.take.get.timing must beEqualTo(RandomizationTimingType.OnEachNewAttempt)
      fetched2.get.reorder must beNone

      childrenSelectionStorage.create(new ChildrenSelection(11, RandomizationTimingType.OnEachNewAttempt, RandomizationTimingType.Once), "sequencingID" -> 400) must not(throwA[Exception])
      val fetched3 = childrenSelectionStorage.getOne("sequencingID" -> 400)
      fetched3 must beSome
      fetched3.get.take.get.count must beEqualTo(11)
      fetched3.get.take.get.timing must beEqualTo(RandomizationTimingType.OnEachNewAttempt)
      fetched3.get.reorder must beEqualTo(Some(RandomizationTimingType.Once))

    }
    "execute 'delete' without errors" in new Context {
      childrenSelectionStorage.create(new ChildrenSelection(RandomizationTimingType.Once), "sequencingID" -> 500) must not(throwA[Exception])
      childrenSelectionStorage.delete("sequencingID" -> 500) must not(throwA[Exception])
      //val fetched = childrenSelectionStorage.getOne("sequencingID"-> 500)
      //fetched must beNone
    }
  }

  trait Context extends Scope {
    // do initialize mock services
    val childrenSelectionService = ChildrenSelectionEntityContainer.mockLocalService
    val childrenSelectionStorage: EntityStorage[ChildrenSelection] = new LFChildrenSelectionStorageImpl() {}
  }

}
