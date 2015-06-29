package com.arcusys.learn.scorm.sequencing.storage.impl.liferay

import com.arcusys.learn.storage.impl.{ KeyedEntityStorage, EntityStorage }
import com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalServiceUtil
import com.arcusys.learn.storage.impl.liferay.LiferayCommon
import com.arcusys.learn.persistence.liferay.model.LFObjective
import com.arcusys.valamis.lesson.scorm.model.manifest.Objective
import scala.collection.JavaConverters._
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.ObjectiveFieldsMapper

/**
 * User: Yulia.Glushonkova
 * Date: 01.04.13
 */
trait LFObjectiveStorageImpl extends KeyedEntityStorage[Objective] {
  protected def doRenew() { LFObjectiveLocalServiceUtil.removeAll() }

  def getOne(parameters: (String, Any)*) = {
    val sequencingID = LiferayCommon.getParameter("sequencingID", parameters: _*)
    val isPrimary = LiferayCommon.getParameter("isPrimary", parameters: _*)
    val lf = LFObjectiveLocalServiceUtil.findBySequencingIDAndIsPrimary(sequencingID.get, isPrimary.get).asScala.headOption
    Option(extract(lf))
  }
  def extract(lfEntity: Option[LFObjective]): Objective = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

    lfEntity.map(lfEntity => {
      val mapper = new ObjectiveFieldsMapper {
        def identifier = lfEntity.getIdentifier.toOption
        def minNormalizedMeasure = BigDecimal(lfEntity.getMinNormalizedMeasure)
        def satisfiedByMeasure = lfEntity.getSatisfiedByMeasure
      }
      createObjective(lfEntity.getLfId.toInt, mapper)
    }).orNull
  }

  def createObjective(id: Int, mapper: ObjectiveFieldsMapper): Objective

  def getAll(parameters: (String, Any)*) = {
    val sequencingID = LiferayCommon.getParameter("sequencingID", parameters: _*)
    val isPrimary = LiferayCommon.getParameter("isPrimary", parameters: _*)
    LFObjectiveLocalServiceUtil.findBySequencingIDAndIsPrimary(sequencingID.get, isPrimary.get).asScala map (x => extract(Some(x)))
  }
  def create(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }

  def create(entity: Objective, parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def delete(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def modify(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def modify(entity: Objective, parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }

  def getByID(id: Int, parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")

  def createAndGetID(entity: Objective, parameters: (String, Any)*) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

    val sequencingID = LiferayCommon.getParameter("sequencingID", parameters: _*)
    val isPrimary = LiferayCommon.getParameter("isPrimary", parameters: _*)
    val newEntity = LFObjectiveLocalServiceUtil.createLFObjective()
    newEntity.setSequencingID(sequencingID.get)
    newEntity.setSatisfiedByMeasure(entity.satisfiedByMeasure)
    newEntity.setIdentifier(entity.id.getOrElse(null))
    newEntity.setMinNormalizedMeasure(entity.minNormalizedMeasure)
    newEntity.setIsPrimary(isPrimary.getOrElse(false))
    LFObjectiveLocalServiceUtil.addLFObjective(newEntity).getLfId.toInt
  }

  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
