package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalServiceUtil
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.valamis.lesson.model.{ LessonLimit, LessonType }
import com.arcusys.valamis.model.PeriodTypes

import scala.util.Try

/**
 * User: Yulia.Glushonkova
 * Date: 12.04.13
 */
trait LFLessonLimitStorageImpl extends EntityStorage[LessonLimit] {
  protected def doRenew() {}

  def getOne(parameters: (String, Any)*): Option[LessonLimit] = {
    parameters match {
      case Seq(("itemID", itemID: Int), ("itemType", lessonType: String)) => {
        return Try({
          val limit = LFLessonLimitLocalServiceUtil.findByID(itemID.toLong, lessonType)
          Some(new LessonLimit(itemID,
            LessonType.withName(lessonType),
            limit.getPassingLimit.toInt,
            limit.getRerunInterval.toInt,
            PeriodTypes(limit.getRerunIntervalType)))
        }
        ).getOrElse(Some(new LessonLimit(itemID, LessonType.withName(lessonType), 0, 0, PeriodTypes.UNLIMITED)))
      }
    }
    None
  }

  def getAll(parameters: (String, Any)*) = {
    throw new UnsupportedOperationException
  }
  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def create(entity: LessonLimit, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def delete(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(entity: LessonLimit, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getByID(id: Int, parameters: (String, Any)*) = {
    throw new UnsupportedOperationException
  }

  def createAndGetID(entity: LessonLimit, parameters: (String, Any)*) = {
    throw new UnsupportedOperationException
  }

  override def getAll(sql: String, parameters: (String, Any)*) = {
    throw new UnsupportedOperationException
  }

  def createAndGetID(parameters: (String, Any)*) = {
    throw new UnsupportedOperationException
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[LessonLimit] = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
