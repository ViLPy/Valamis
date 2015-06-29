package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.valamis.uri.model.{ ValamisURIType, ValamisURI }
import ValamisURIType.ValamisURIType
import com.arcusys.valamis.uri.storage.TincanURIStorage

trait TincanURIEntityStorage extends TincanURIStorage with EntityStorage[ValamisURI] {

  def get(uri: String): Option[ValamisURI] = {
    getOne("uri" -> uri)
  }

  def getById(objId: String, objType: ValamisURIType): Option[ValamisURI] = {
    getOne("id" -> objId, "type" -> objType.toString)
  }

  def getById(start: Int, end: Int, filter: String): Seq[ValamisURI] = {
    getAll("start" -> start, "end" -> end, "filter" -> filter)
  }

  def create(uri: String, objId: String, objType: ValamisURIType, content: String): Unit = {
    create("uri" -> uri, "id" -> objId, "type" -> objType.toString, "content" -> content)
  }

  def delete(uri: String): Unit = {
    delete("uri" -> uri)
  }

}
