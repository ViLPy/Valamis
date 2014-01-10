package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.tincan.model.ContextActivities
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities
import com.arcusys.learn.util.JsonSerializer
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextActivitiesLocalServiceUtil

trait LFTincanLrsContextActivitiesStorageImpl extends KeyedEntityStorage[ContextActivities] {
  def mapper(entity:LFTincanLrsContextActivities): ContextActivities = {
    ContextActivities(
      JsonSerializer.deserializeActivityReference(entity.getParent).toSet,
      JsonSerializer.deserializeActivityReference(entity.getGrouping).toSet,
      JsonSerializer.deserializeActivityReference(entity.getCategory).toSet,
      JsonSerializer.deserializeActivityReference(entity.getOther).toSet,
      id = Option(entity.getId.toInt))
  }

  def createAndGetID(entity: ContextActivities, parameters: (String, Any)*): Int = {
    val lfEntity = LFTincanLrsContextActivitiesLocalServiceUtil.createLFTincanLrsContextActivities()

    lfEntity.setParent(JsonSerializer.serializeActivityReference(entity.parent.toSeq))
    lfEntity.setGrouping(JsonSerializer.serializeActivityReference(entity.grouping.toSeq))
    lfEntity.setCategory(JsonSerializer.serializeActivityReference(entity.category.toSeq))
    lfEntity.setOther(JsonSerializer.serializeActivityReference(entity.other.toSeq))

    LFTincanLrsContextActivitiesLocalServiceUtil.addLFTincanLrsContextActivities(lfEntity).getId.toInt
  }

  def renew() = {
    LFTincanLrsContextActivitiesLocalServiceUtil.removeAll()
  }

  def getByID(id: Int, parameters: (String, Any)*): Option[ContextActivities] = {
    Option(LFTincanLrsContextActivitiesLocalServiceUtil.getLFTincanLrsContextActivities(id)).map(mapper)
  }

  def delete(parameters: (String, Any)*): Unit = parameters match {
    case Seq(("id", id: Int)) => {
      Option(LFTincanLrsContextActivitiesLocalServiceUtil.getLFTincanLrsContextActivities(id))
        .foreach(LFTincanLrsContextActivitiesLocalServiceUtil.deleteLFTincanLrsContextActivities)
    }
  }

  def getOne(parameters: (String, Any)*): Option[ContextActivities] = throw new UnsupportedOperationException()

  def getAll(parameters: (String, Any)*): Seq[ContextActivities] = throw new UnsupportedOperationException()

  def create(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def create(entity: ContextActivities, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(entity: ContextActivities, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def execute(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[ContextActivities] = throw new UnsupportedOperationException()

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[ContextActivities] = throw new UnsupportedOperationException()

  def modify(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException()
}
