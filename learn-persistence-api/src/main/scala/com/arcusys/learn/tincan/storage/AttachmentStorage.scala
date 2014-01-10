package com.arcusys.learn.tincan.storage

import com.arcusys.learn.tincan.model.Attachment

trait AttachmentStorage {
  def create(entity: Attachment, parentID: Int)
  def getByParent(id: Int): Seq[Attachment]
  def deleteByParentID(id: Int)
  def renew()
}
