package com.arcusys.learn.tincan.storage

import com.arcusys.learn.tincan.model._

trait DocumentStorage {
  def get(documentID: String): Option[Document]
  def create(entity: Document)
  def modify(entity: Document)
  def delete(documentID: String)
  def renew()
}
