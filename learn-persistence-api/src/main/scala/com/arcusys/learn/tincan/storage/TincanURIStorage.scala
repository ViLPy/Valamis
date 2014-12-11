package com.arcusys.learn.tincan.storage

import com.arcusys.learn.tincan.model.TincanURI
import com.arcusys.learn.tincan.model.TincanURIType._

trait TincanURIStorage {
  def get(uri: String): Option[TincanURI]
  def getURI(objId: String, objType: TincanURIType): Option[TincanURI]
  def create(uri: String, objId: String, objType: TincanURIType, content: String): Unit
  def delete(uri: String)
  def renew()
}
