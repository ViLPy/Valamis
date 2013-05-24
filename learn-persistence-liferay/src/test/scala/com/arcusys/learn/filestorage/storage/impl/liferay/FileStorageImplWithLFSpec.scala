package com.arcusys.learn.filestorage.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import com.arcusys.learn.filestorage.storage.impl.FileRecordEntityStorage
import com.arcusys.learn.filestorage.storage.FileStorage
import org.specs2.specification.Scope

/**
 * User: dkudinov
 * Date: 12.3.2013
 */
class FileStorageImplWithLFSpec extends SpecificationWithJUnit {

  "FileStorageImpl with Liferay as storage" should {
    "store empty file without exceptions" in new Context {
      fileStorageImpl store "someFile.1" must not(throwA[Exception])
    }

    "store file with content without errors" in new Context {
      val content: Array[Byte] = Array[Byte]('\12', '\54', '\12', '\51', '\0')
      fileStorageImpl store ("someFile.2", content) must not (throwA[Exception])
    }
  }

  trait Context extends Scope {
    // do initialize mock services
    val fileService = FileStorageEntityContainer.mockLocalService

    val fileStorageImpl: FileStorage = new FileRecordEntityStorage with LFFileRecordStorageImpl
  }

}
