package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.{ LFTincanURI, LFTincanActor }
import com.arcusys.learn.persistence.liferay.service
import com.arcusys.learn.persistence.liferay.service.{ LFTincanURILocalServiceUtil, LFTincanActorLocalServiceUtil }
import com.arcusys.learn.storage.impl.{ EntityStorage, KeyedEntityStorage }
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.tincan.storage.impl.liferay.mapper.ActorMapper
import com.arcusys.util.JsonSerializer
import com.arcusys.util.JsonSerializer._
import com.liferay.portal.NoSuchModelException

import scala.collection.JavaConverters._

trait LFTincanURIStorageImpl extends EntityStorage[TincanURI] {

  def mapper(entity: LFTincanURI): TincanURI = {
    return TincanURI(
      entity.getUri(),
      entity.getObjID(),
      TincanURIType.withName(entity.getObjType()),
      entity.getContent())
  }

  def renew() = {
    LFTincanURILocalServiceUtil.removeAll()
  }

  def getOne(parameters: (String, Any)*): Option[TincanURI] = parameters match {
    case Seq(("uri", uri: String)) =>
      try {
        val storage = LFTincanURILocalServiceUtil.getLFTincanURI(uri)
        Option(mapper(storage))
      } catch {
        case e: NoSuchModelException => {
          return None
        }
      }

    case Seq(("id", objId: String), ("type", objType: String)) => {
      try {
        val storage = LFTincanURILocalServiceUtil.findURI(objId, objType)
        Option(mapper(storage))
      } catch {
        case e: NoSuchModelException => {
          return None
        }
      }
    }

  }

  def create(parameters: (String, Any)*) = parameters match {
    case Seq(("uri", uri: String), ("id", objId: String), ("type", objType: String), ("content", content: String)) => {
      val tincanURI = LFTincanURILocalServiceUtil.createLFTincanURI(uri)
      tincanURI.setObjID(objId)
      tincanURI.setObjType(objType)
      tincanURI.setContent(content)
      LFTincanURILocalServiceUtil.addLFTincanURI(tincanURI)
    }
  }

  def delete(parameters: (String, Any)*): Unit = parameters match {
    case Seq(("uri", uri: String)) => {
      Option(LFTincanURILocalServiceUtil.getLFTincanURI(uri)).foreach(LFTincanURILocalServiceUtil.deleteLFTincanURI)
    }
  }

  def getAll(parameters: (String, Any)*): Seq[TincanURI] = ???

  def modify(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(entity: TincanURI, parameters: (String, Any)*): Unit = { throw new UnsupportedOperationException() }

  def execute(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[TincanURI] = throw new UnsupportedOperationException()

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[TincanURI] = throw new UnsupportedOperationException()

  def modify(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException()

  def create(entity: TincanURI, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()
}
