package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFTincanURI
import com.arcusys.learn.persistence.liferay.service.LFTincanURILocalServiceUtil
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.valamis.uri.model.{ ValamisURIType, ValamisURI }
import com.liferay.portal.NoSuchModelException
import scala.collection.JavaConverters._

trait LFTincanURIStorageImpl extends EntityStorage[ValamisURI] {

  def mapper(entity: LFTincanURI): ValamisURI = ValamisURI(
    entity.getUri(),
    entity.getObjID(),
    ValamisURIType.withName(entity.getObjType()),
    entity.getContent()
  )

  def renew() = {
    LFTincanURILocalServiceUtil.removeAll()
  }

  def getOne(parameters: (String, Any)*): Option[ValamisURI] = parameters match {
    case Seq(("uri", uri: String)) =>
      try {
        val storage = LFTincanURILocalServiceUtil.fetchLFTincanURI(uri)
        Option(mapper(storage))
      } catch {
        case e: NoSuchModelException => {
          None
        }
      }

    case Seq(("id", objId: String), ("type", objType: String)) => {
      try {
        val storage = LFTincanURILocalServiceUtil.findURI(objId, objType)
        Option(mapper(storage))
      } catch {
        case e: NoSuchModelException => {
          None
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
      Option(LFTincanURILocalServiceUtil.fetchLFTincanURI(uri)).foreach(LFTincanURILocalServiceUtil.deleteLFTincanURI)
    }
  }

  def getAll(parameters: (String, Any)*): Seq[ValamisURI] = parameters match {
    case Seq(("start", start: Int), ("end", end: Int), ("filter", filter: String)) => {
      val uriCount = if(start == -1 && end == -1) LFTincanURILocalServiceUtil.getLFTincanURIsCount else end
      var uriList: Seq[ValamisURI] = Nil
      LFTincanURILocalServiceUtil
        .getLFTincanURIs(start, uriCount)
        .asScala
        .map(x => uriList = uriList :+ mapper(x))

      uriList.filter(x => x.uri.contains(filter))
    }
  }

  def modify(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(entity: ValamisURI, parameters: (String, Any)*): Unit = { throw new UnsupportedOperationException() }

  def execute(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[ValamisURI] = throw new UnsupportedOperationException()

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[ValamisURI] = throw new UnsupportedOperationException()

  def modify(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException()

  def create(entity: ValamisURI, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()
}
