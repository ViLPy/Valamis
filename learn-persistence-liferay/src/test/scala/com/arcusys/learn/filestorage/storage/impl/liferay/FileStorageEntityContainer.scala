package com.arcusys.learn.filestorage.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFFileStorageLocalService
import com.arcusys.learn.persistence.liferay.model.LFFileStorage
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import org.mockito.Matchers.{eq => eqMatcher}

import java.util.{List => JList}
import scala.collection.JavaConverters._


object FileStorageEntityContainer extends MockEntityContainer[LFFileStorageLocalService, LFFileStorage] {
  lazy val mockServiceBeanName = classOf[LFFileStorageLocalService].getName
  lazy val mockLocalService = mock[LFFileStorageLocalService]

  // service related mocks
  def createFunction = _.createLFFileStorage()
  def addFunction =_.addLFFileStorage(_)
  def deleteFunction = _.deleteLFFileStorage(_)
  def updateFunction = _.updateLFFileStorage(_)
  def getAllFunction = _.getLFFileStorages(_, _)
  def removeAllFunction = _.removeAll()
  def orNull = _.orNull

  def createMockEntity() = mock[LFFileStorage]

  // entity related mocks
  def mockEntityProperties(mockEntity: LFFileStorage) {
    mockStringProperty(mockEntity.setFilename(_), _.getFilename)
    mockStringProperty(mockEntity.setContent(_), _.getContent)
  }

  def getIdFunction = _.getId


  // mock persistence service
  mockLocalService.findByFilename(anyString) answers {
    filterByFilenameAsList(_)
  }
  mockLocalService.findByFilename(anyString, eqMatcher(0), eqMatcher(1)) answers {
    filterByFilenameAsList(_)
  }

  mockLocalService.removeByFilename(anyString) answers { filenameRaw =>
      internalStorage --= filterByFilename(filenameRaw).map(_.getId)
      ()
  }

  mockLocalService.findByDirectory(anyString) answers {
    filterByDirectory(_).asJava
  }

  mockLocalService.removeByDirectory(anyString) answers { filenameRaw =>
      internalStorage --= filterByDirectory(filenameRaw).map(_.getId)
      ()
  }

  private def unwrapFilename(filenameRaw: Any) = filenameRaw match {
    case x: String => x
    case Array(x: String, Int, Int) => x
  }

  private def filterByFilenameAsList(filenameRaw: Any): JList[LFFileStorage] = filterByFilename(filenameRaw).asJava

  def filenameMatch(filename: String)(file: LFFileStorage): Boolean = file.getFilename == filename

  def filenameLike(filename: String)(file: LFFileStorage): Boolean = file.getFilename.startsWith(filename.replace("%", ""))

  private def filterByFilename(filenameRaw: Any): Seq[LFFileStorage] = filterStorage (filenameMatch(unwrapFilename(filenameRaw)))
  private def filterByDirectory(filenameRaw: Any): Seq[LFFileStorage] = filterStorage (filenameLike(unwrapFilename(filenameRaw)))

  private def filterStorage(check: (LFFileStorage) => Boolean): Seq[LFFileStorage] = {
    internalStorage.values.filter(check).toSeq
  }
}
