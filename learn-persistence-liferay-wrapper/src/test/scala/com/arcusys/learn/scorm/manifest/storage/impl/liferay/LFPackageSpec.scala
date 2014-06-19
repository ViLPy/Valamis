package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.specification.Scope
import org.specs2.matcher.ThrownExpectations
import com.arcusys.learn.persistence.liferay.service.LFPackageLocalServiceUtil
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.scorm.manifest.model.Manifest

/**
 * User: Yulia.Glushonkova
 * Date: 12.04.13
 */
class LFPackageSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {
  "Mockito" should {
    "mock service method" in new Context {
      LFPackageLocalServiceUtil.createLFPackage() must not(throwA[Exception])
      there was atLeastOne(packageService).createLFPackage()
    }
  }

  "LFPackageStorageImpl" should {

    "execute 'create' without errors" in new Context {
      val newEntity = Manifest(0, Option("version"), None, "scormVersion", Option("defaultOrganizationID"),
        None, "title", Option("summary"), None, Option(1), Option(1), isDefault = false)
      packageStorage.createAndGetID(newEntity) must not(throwA[Exception])
    }

    "execute 'get' without errors" in new Context {
      val newEntity = Manifest(0, Option("version"), None, "scormVersion", Option("defaultOrganizationID"),
        None, "title", Option("summary"), None, Option(12), Option(10), isDefault = false)
      packageStorage.createAndGetID(newEntity) must not(throwA[Exception])
      val result = packageStorage.getOne("refID" -> 12)
      result must beSome
      result.get.defaultOrganizationID must beEqualTo(Option("defaultOrganizationID"))
      result.get.title must beEqualTo("title")

      val newEntity1 = Manifest(0, Option("version"), None, "scormVersion", Option("defaultOrganizationID1"),
        None, "title1", Option("summary1"), None, Option(100), Option(50), isDefault = false)
      val id1 = packageStorage.createAndGetID(newEntity1)
      val fetched1 = packageStorage.getOne("packageId" -> id1)
      fetched1 must beSome
      fetched1.get.courseID must beEqualTo(Option(50))
      fetched1.get.assetRefID must beEqualTo(Option(100))

      val newEntity2 = Manifest(0, Option("version"), None, "scormVersion", Option("defaultOrganizationID2"),
        None, "title2", Option("summary2"), None, Option(200), Option(250), isDefault = false)
      val id2 = packageStorage.createAndGetID(newEntity2)
      val fetched2 = packageStorage.getOne("packageId" -> id2) //, "courseID"->  250)
      fetched2 must beSome
      fetched2.get.courseID must beEqualTo(Option(250))
      fetched2.get.assetRefID must beEqualTo(Option(200))
      //fetched2.get.visibility
    }

    "execute 'get All' without errors" in new Context {
      val newEntity = Manifest(0, Option("version"), None, "scormVersion", Option("defaultOrganizationID"),
        None, "title", Option("summary"), None, Option(12), Option(10), isDefault = false)
      val newEntity2 = Manifest(0, Option("version"), None, "scormVersion", Option("defaultOrganizationID"),
        None, "title", Option("summary"), None, Option(12), Option(20), isDefault = false)
      val newEntity3 = Manifest(0, Option("version"), None, "scormVersion", Option("defaultOrganizationID"),
        None, "title", Option("summary"), None, Option(12), Option(30), isDefault = false)
      val newEntity4 = Manifest(0, Option("version"), None, "scormVersion", Option("defaultOrganizationID"),
        None, "title", Option("summary"), None, Option(12), Option(30), isDefault = false)
      packageStorage.createAndGetID(newEntity) must not(throwA[Exception])
      packageStorage.createAndGetID(newEntity2) must not(throwA[Exception])
      packageStorage.createAndGetID(newEntity3) must not(throwA[Exception])
      packageStorage.createAndGetID(newEntity4) must not(throwA[Exception])

      // val items = packageStorage.getAll("ids" -> List(10,20,30))
      // items.length must beEqualTo(4)

      val items2 = packageStorage.getAll("courseID" -> 30)
      items2.length must beEqualTo(2)

    }

    "execute 'modify' without errors" in new Context {
      val newEntity = Manifest(0, Option("version"), None, "scormVersion", Option("defaultOrganizationID"),
        None, "title", Option("summary"), None, Option(12), Option(10), isDefault = false)
      val id = packageStorage.createAndGetID(newEntity)
      packageStorage.modify("id" -> id, "assetRefID" -> 1000) must not(throwA[Exception])
      val fetched = packageStorage.getOne("packageId" -> id)
      fetched.get.assetRefID must beEqualTo(Option(1000))
    }

  }

  trait Context extends Scope {
    // do initialize mock services
    val packageService = PackageEntityContainer.mockLocalService
    val packageStorage: KeyedEntityStorage[Manifest] = new LFPackageStorageImpl() {}
  }

}
