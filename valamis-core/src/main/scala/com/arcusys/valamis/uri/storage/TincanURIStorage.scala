package com.arcusys.valamis.uri.storage

import com.arcusys.valamis.uri.model.ValamisURI
import com.arcusys.valamis.uri.model.ValamisURIType._

trait TincanURIStorage {
  def get(uri: String): Option[ValamisURI]
  def getById(objId: String, objType: ValamisURIType): Option[ValamisURI]
  def getById(start: Int, end: Int, filter: String): Seq[ValamisURI]
  def create(uri: String, objId: String, objType: ValamisURIType, content: String): Unit
  def delete(uri: String)
  def renew()
}
