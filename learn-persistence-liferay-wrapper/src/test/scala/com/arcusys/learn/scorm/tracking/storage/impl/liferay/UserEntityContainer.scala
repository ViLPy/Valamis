package com.arcusys.learn.scorm.tracking.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFUserLocalService
import com.arcusys.learn.persistence.liferay.model.LFUser
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer
import java.lang.{Integer => JavaInt}
import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 28.03.13
 */

object UserEntityContainer extends MockEntityContainer[LFUserLocalService, LFUser] {
  lazy val mockServiceBeanName = classOf[LFUserLocalService].getName
  lazy val mockLocalService = mock[LFUserLocalService]

  // service related mocks
  def createFunction = _.createLFUser()

  def addFunction = _.addLFUser(_)

  def deleteFunction = _.deleteLFUser(_)

  def updateFunction = _.updateLFUser(_)

  def orNull = _.orNull

  def getAllFunction = _.getLFUsers(_, _)

  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFUser]

  def mockEntityProperties(mockEntity: LFUser) {
    mockIntegerProperty(mockEntity.setId(_), _.getId)
    mockStringProperty(mockEntity.setName(_), _.getName)
    mockDoubleProperty(mockEntity.setPreferredAudioLevel(_), _.getPreferredAudioLevel)
    mockStringProperty(mockEntity.setPreferredLanguage(_), _.getPreferredLanguage)
    mockDoubleProperty(mockEntity.setPreferredDeliverySpeed(_), _.getPreferredDeliverySpeed)
    mockIntegerProperty(mockEntity.setPreferredAudioCaptioning(_), _.getPreferredAudioCaptioning)
  }

  def getIdFunction = _.getLfid

  mockLocalService.findByUserId(any) answers {
    id => {
      val entity = internalStorage.values.filter(entity => entity.getId == id).headOption
      if (entity.isEmpty) null
      else entity.get
    }
  }

  mockLocalService.findByUserIds(any) answers { ids => {
      val id: Array[JavaInt] = ids match {
        case x: Array[JavaInt] => x
      }
      internalStorage.values.filter(entity => id.contains(entity.getId)).toList.asJava
    }
  }

  mockLocalService.removeByUserId(any) answers {
    id =>
      internalStorage --= filterByUserId(id).map(_.getLfid)
      ()
  }

  private def filterByUserId(idRaw: Any): Seq[LFUser] = internalStorage.values.filter(user => user.getId == unwrapId(idRaw)).toSeq

  private def unwrapId(idRaw: Any) = idRaw match {
    case x: Int => x
    case Array(x: Int, Int, Int) => x
  }
}
