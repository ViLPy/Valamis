package com.arcusys.learn.tincan.storage.impl.liferay

import java.util

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException
import com.arcusys.learn.persistence.liferay.model.LFTincanActivity
import com.arcusys.learn.persistence.liferay.service.LFTincanActivityLocalServiceUtil
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.tincan.model.{ Activity, InteractionType }
import com.arcusys.util.JsonSerializer
import com.liferay.portal.kernel.dao.orm.{ DynamicQuery, DynamicQueryFactoryUtil, PropertyFactoryUtil }

import scala.collection.JavaConverters._

trait LFTincanActivityStorageImpl extends KeyedEntityStorage[Activity] {

  import com.arcusys.util.JsonSerializer._

  def renew() {
    LFTincanActivityLocalServiceUtil.removeAll()
  }

  def mapper(entity: LFTincanActivity) = {
    // will use JSON for storing some fields with Seq, because this way is less painful
    Activity(
      entity.getObjectType,
      entity.getTincanID,
      Option(entity.getName).map(deserializeLanguageMap),
      Option(entity.getDescription).map(deserializeLanguageMap),
      Option(entity.getTheType),
      Option(entity.getMoreInfo),
      Option(entity.getInteractionType).map(t => InteractionType.withName(t)),
      deserializeStringSet(entity.getCorrectResponsesPattern),
      deserializeInteractionComponents(entity.getChoices),
      deserializeInteractionComponents(entity.getScale),
      deserializeInteractionComponents(entity.getSource),
      deserializeInteractionComponents(entity.getTarget),
      deserializeInteractionComponents(entity.getSteps),
      deserializeExtensions(entity.getExtensions),
      Option(entity.getId.toInt)
    )
  }

  def createAndGetID(entity: Activity, parameters: (String, Any)*): Int = {
    val lfEntity = LFTincanActivityLocalServiceUtil.createLFTincanActivity()
    lfEntity.setObjectType(entity.objectType)
    lfEntity.setTincanID(entity.id)
    entity.name.foreach(name => lfEntity.setName(serializeLanguageMap(name)))
    entity.description.foreach(description => lfEntity.setDescription(serializeLanguageMap(description)))
    entity.theType.foreach(lfEntity.setTheType)
    entity.moreInfo.foreach(lfEntity.setMoreInfo)
    entity.interactionType.foreach(iType => lfEntity.setInteractionType(iType.toString))
    lfEntity.setCorrectResponsesPattern(serializeStringSet(entity.correctResponsesPattern))
    lfEntity.setChoices(serializeInteractionComponents(entity.choices))
    lfEntity.setScale(serializeInteractionComponents(entity.scale))
    lfEntity.setSource(serializeInteractionComponents(entity.source))
    lfEntity.setTarget(serializeInteractionComponents(entity.target))
    lfEntity.setSteps(serializeInteractionComponents(entity.steps))
    lfEntity.setExtensions(serializeExtensions(entity.extensions))
    LFTincanActivityLocalServiceUtil.addLFTincanActivity(lfEntity).getId.toInt
  }

  def getOne(parameters: (String, Any)*): Option[Activity] = parameters match {
    case Seq(("id", intID: Int)) => {
      Option(LFTincanActivityLocalServiceUtil.getLFTincanActivity(intID)).map(mapper)
    }
    case Seq(("id", stringID: String)) => {
      try {
        Option(LFTincanActivityLocalServiceUtil.findByTincanID(stringID)).map(mapper)
      } catch {
        case e: NoSuchLFTincanActivityException => None
      }
    }
    case _ => None
  }

  def getAll(parameters: (String, Any)*): Seq[Activity] = (parameters match {
    case Seq(("filterName", filterName: String)) => findBy(filterName)
    case _                                       => LFTincanActivityLocalServiceUtil.getLFTincanActivities(-1, -1)
  }).asScala.map(act => mapper(act.asInstanceOf[LFTincanActivity])).toSeq

  def create(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def create(entity: Activity, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def delete(parameters: (String, Any)*): Unit = parameters match {
    case Seq(("id", activityID: Int)) => {
      Option(LFTincanActivityLocalServiceUtil.getLFTincanActivity(activityID))
        .map(LFTincanActivityLocalServiceUtil.deleteLFTincanActivity)
    }
    case _ => None
  }

  def modify(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(entity: Activity, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def execute(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[Activity] = throw new UnsupportedOperationException()

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[Activity] = throw new UnsupportedOperationException()

  def modify(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def getByID(id: Int, parameters: (String, Any)*): Option[Activity] = null

  def createAndGetID(parameters: (String, Any)*): Int = 0

  private def findBy(filterName: String): util.List[_] = {
    val query: DynamicQuery = DynamicQueryFactoryUtil.forClass(classOf[LFTincanActivity], "activity")
      .add(PropertyFactoryUtil.forName("activity.name").like(":\"" + filterName + "%"))

    val requestList = LFTincanActivityLocalServiceUtil.dynamicQuery(query)
    return requestList
  }
}