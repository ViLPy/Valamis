package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.tincan.storage.DocumentStorage
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.tincan.model.Document

trait DocumentEntityStorage extends DocumentStorage with EntityStorage[Document] {
  def get(documentID: String): Option[Document] =
    getOne("documentID" -> documentID)

  def delete(documentID: String) {
    delete("documentID" -> documentID)
  }

  def create(entity: Document) {
    create(entity, Nil: _*)
  }

  def modify(entity: Document) {
    modify(entity, Nil: _*)
  }
}
