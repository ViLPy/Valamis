package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import org.specs2.specification.Scope
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.LFResourceLocalServiceUtil
import com.arcusys.learn.scorm.manifest.model.{ ScoResource, Resource }

class LFResourceSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {
  "Mockito" should {
    "mock service method" in new Context {
      LFResourceLocalServiceUtil.createLFResource() must not(throwA[Exception])

      there was atLeastOne(resourceService).createLFResource()
    }
  }

  "ResourceEntityContainer" should {
    "create and get id" in new Context {
      val res = new ScoResource("test1", "test.xml", None, Nil, Nil)
      resourceStorage.createAndGetID(res, "packageID" -> 1) must not(throwA[Exception])
      resourceStorage.getOne("packageID" -> 1, "identifierRef" -> "test1") should beSome
      resourceStorage.getOne("packageID" -> 1, "identifierRef" -> "test1").get.isInstanceOf[ScoResource] should beTrue

      resourceStorage.getAll().size should beEqualTo(1)
      resourceStorage.getAll("packageID" -> 1).size should beEqualTo(1)
    }
  }

  trait Context extends Scope {
    // do initialize mock services
    val resourceService = ResourceEntityContainer.mockLocalService
    val resourceStorage: KeyedEntityStorage[Resource] = new LFResourceStorageImpl() {}
  }

}
