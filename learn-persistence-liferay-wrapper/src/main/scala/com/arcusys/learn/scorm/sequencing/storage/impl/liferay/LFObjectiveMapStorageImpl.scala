package com.arcusys.learn.scorm.sequencing.storage.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalServiceUtil
import com.arcusys.valamis.lesson.scorm.model.manifest.ObjectiveMap
import scala.collection.JavaConverters._
import com.arcusys.learn.persistence.liferay.model.LFObjectiveMap

/**
 * User: Yulia.Glushonkova
 * Date: 29.03.13
 */
trait LFObjectiveMapStorageImpl extends EntityStorage[ObjectiveMap] {
  protected def doRenew() { LFObjectiveMapLocalServiceUtil.removeAll() }

  def getOne(parameters: (String, Any)*) = {
    parameters match {
      case Seq(("objectiveID", value: Int)) => {
        val lf = LFObjectiveMapLocalServiceUtil.findByObjectiveID(value).asScala.headOption
        Option(extract(lf))
      }
    }
  }

  def extract(lfEntity: Option[LFObjectiveMap]) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._
    lfEntity.map(lfEntity => new ObjectiveMap(
      lfEntity.getReadSatisfiedStatusFrom.toOption,
      lfEntity.getReadNormalizedMeasureFrom.toOption,
      lfEntity.getWriteSatisfiedStatusTo.toOption,
      lfEntity.getWriteNormalizedMeasureTo.toOption,
      lfEntity.getReadRawScoreFrom.toOption,
      lfEntity.getReadMinScoreFrom.toOption,
      lfEntity.getReadMaxScoreFrom.toOption,
      lfEntity.getReadCompletionStatusFrom.toOption,
      lfEntity.getReadProgressMeasureFrom.toOption,
      lfEntity.getWriteRawScoreTo.toOption,
      lfEntity.getWriteMinScoreTo.toOption,
      lfEntity.getWriteMaxScoreTo.toOption,
      lfEntity.getWriteCompletionStatusTo.toOption,
      lfEntity.getWriteProgressMeasureTo.toOption
    )).orNull
  }

  def getAll(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def create(entity: ObjectiveMap, parameters: (String, Any)*) {
    val objectiveID = if (parameters.isEmpty) None
    else parameters match {
      case Seq(("objectiveID", value: Int)) => Some(value)
    }
    val newEntity = LFObjectiveMapLocalServiceUtil.createLFObjectiveMap()
    if (!objectiveID.isEmpty) newEntity.setObjectiveID(objectiveID.get)
    newEntity.setReadSatisfiedStatusFrom(entity.readSatisfiedStatusFrom.getOrElse(""))
    newEntity.setReadNormalizedMeasureFrom(entity.readNormalizedMeasureFrom.getOrElse(""))
    newEntity.setWriteSatisfiedStatusTo(entity.writeSatisfiedStatusTo.getOrElse(""))
    newEntity.setWriteNormalizedMeasureTo(entity.writeNormalizedMeasureTo.getOrElse(""))
    newEntity.setReadRawScoreFrom(entity.readRawScoreFrom.getOrElse(""))
    newEntity.setReadMinScoreFrom(entity.readMinScoreFrom.getOrElse(""))
    newEntity.setReadMaxScoreFrom(entity.readMaxScoreFrom.getOrElse(""))
    newEntity.setReadCompletionStatusFrom(entity.readCompletionStatusFrom.getOrElse(""))
    newEntity.setReadProgressMeasureFrom(entity.readProgressMeasureFrom.getOrElse(""))
    newEntity.setWriteRawScoreTo(entity.writeRawScoreTo.getOrElse(""))
    newEntity.setWriteMinScoreTo(entity.writeMinScoreTo.getOrElse(""))
    newEntity.setWriteMaxScoreTo(entity.writeMaxScoreTo.getOrElse(""))
    newEntity.setWriteCompletionStatusTo(entity.writeCompletionStatusTo.getOrElse(""))
    newEntity.setWriteProgressMeasureTo(entity.writeProgressMeasureTo.getOrElse(""))
    LFObjectiveMapLocalServiceUtil.addLFObjectiveMap(newEntity)
  }

  def delete(parameters: (String, Any)*) {
    parameters match {
      case Seq(("objectiveID", value: Int)) => {
        LFObjectiveMapLocalServiceUtil.removeByObjectiveID(value)
      }
    }
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def modify(entity: ObjectiveMap, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
