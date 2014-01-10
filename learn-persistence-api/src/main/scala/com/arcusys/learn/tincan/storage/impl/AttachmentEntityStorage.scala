package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.tincan.storage.AttachmentStorage
import com.arcusys.learn.tincan.model.Attachment
import com.arcusys.learn.storage.impl.EntityStorage

trait AttachmentEntityStorage extends AttachmentStorage with EntityStorage[Attachment] {
  def getByParent(id: Int): Seq[Attachment] = {
    getAll("parentID" -> id)
  }

  def deleteByParentID(id: Int) = {
    delete("parentID" -> id)
  }

  def create(entity: Attachment, parentID: Int) = {
    create(entity, "parentID" -> parentID)
  }
}
