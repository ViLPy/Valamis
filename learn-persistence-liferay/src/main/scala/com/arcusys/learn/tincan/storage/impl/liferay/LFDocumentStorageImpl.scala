package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsDocumentLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument
import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException
import com.arcusys.learn.tincan.storage.impl.liferay.mapper.DocumentMapper

trait LFDocumentStorageImpl extends EntityStorage[Document] {
  def getOne(parameters: (String, Any)*): Option[Document] = parameters match {
    case Seq(("documentID", documentId: String)) => {
      try {
        Option(LFTincanLrsDocumentLocalServiceUtil.findByDocumentId(documentId)).map(DocumentMapper.map)
      } catch {
        case e:NoSuchLFTincanLrsDocumentException => None
      }
    }
    case _ => None
  }

  def renew() = {
    LFTincanLrsDocumentLocalServiceUtil.removeAll()
  }

  def create(entity: Document, parameters: (String, Any)*): Unit = {
    createAndGetID(entity, parameters :_*)
  }
  def createAndGetID(entity: Document, parameters: (String, Any)*): Int = {
    val lfEntity = LFTincanLrsDocumentLocalServiceUtil.createLFTincanLrsDocument()
    lfEntity.setDocumentId(entity.id)
    lfEntity.setUpdate(entity.updated)
    lfEntity.setContent(entity.contents)
    lfEntity.setContentType(entity.cType match {
      case JSONContent => JSONContent.name
      case OtherContent => OtherContent.name
      case _ => ""
    })

    LFTincanLrsDocumentLocalServiceUtil.addLFTincanLrsDocument(lfEntity).getId.toInt
  }

  def delete(parameters: (String, Any)*): Unit = parameters match {
    case Seq(("documentID", documentId: String)) => {
      LFTincanLrsDocumentLocalServiceUtil.deleteLFTincanLrsDocument(documentId)
    }
  }

  def getAll(parameters: (String, Any)*): Seq[Document] = throw new UnsupportedOperationException()

  def create(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(entity: Document, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def execute(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[Document] = throw new UnsupportedOperationException()

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[Document] = throw new UnsupportedOperationException()

  def modify(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()
}
