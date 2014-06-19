package com.arcusys.learn.filestorage.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import com.arcusys.learn.persistence.liferay.service.LFFileStorageLocalServiceUtil
import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import org.specs2.specification.Scope
import com.arcusys.learn.scorm.tracking.model.FileRecord
import com.arcusys.learn.storage.impl.EntityStorage

/**
 * User: dkudinov
 * Date: 8.3.2013
 */
class LFFileStorageSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {

  "Mockito" should {
    "mock service method" in new Context {
      LFFileStorageLocalServiceUtil.createLFFileStorage() must not(throwA[Exception])

      there was atLeastOne(fileService).createLFFileStorage()
    }
  }

  "LFFileRecordStorageImpl" should {

    "execute 'create' without errors" in new Context {
      fileStorage.create("filename" -> "somefile.txt") must not(throwA[Exception])
    }

    "execute 'getFile' without errors" in new Context {
      fileStorage.getOne("filename" -> "somefile.txt") must not(throwA[Exception])
    }
  }

  "storeAndGet" should {

    "return same object" in new Context {
      fileStorage create ("filename" -> "someNewFile.txt")
      fileStorage create ("filename" -> "someOtherFile.txt")

      val fileStorageEntity: Option[FileRecord] = fileStorage getOne ("filename" -> "someNewFile.txt")
      val fileStoragesAll: Seq[FileRecord] = fileStorage getAll ("filename" -> "someNewFile.txt")

      ((fileStorageEntity must beSome) and
        (fileStorageEntity.get.filename must beEqualTo("someNewFile.txt"))) and
        (fileStoragesAll must beEqualTo(Seq(fileStorageEntity.get)))
    }
  }

  "delete" should {

    "return None on getAfterDelete" in new Context {
      val filename: (String, String) = "filename" -> "forDelete.txt"
      fileStorage create filename

      val createdFile: Option[FileRecord] = fileStorage getOne filename

      fileStorage delete filename

      (createdFile must beSome) and (
        createdFile.get.filename must beEqualTo(filename._2)
        and (
          fileStorage getOne filename must beNone
        ))

    }
  }

  trait Context extends Scope {
    // do initialize mock services
    val fileService = FileStorageEntityContainer.mockLocalService

    val fileStorage: EntityStorage[FileRecord] = new LFFileRecordStorageImpl() {}

  }

}
