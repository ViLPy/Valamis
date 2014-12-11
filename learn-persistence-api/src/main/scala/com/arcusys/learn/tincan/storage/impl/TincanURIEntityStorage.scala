package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.tincan.model.TincanURI
import com.arcusys.learn.tincan.model.TincanURIType.TincanURIType
import com.arcusys.learn.tincan.storage.TincanURIStorage

trait TincanURIEntityStorage extends TincanURIStorage with EntityStorage[TincanURI] {

  def get(uri: String): Option[TincanURI] = {
    getOne("uri" -> uri)
  }

  def getURI(objId: String, objType: TincanURIType): Option[TincanURI] = {
    getOne("id" -> objId, "type" -> objType.toString)
  }

  def create(uri: String, objId: String, objType: TincanURIType, content: String): Unit = {
    create("uri" -> uri, "id" -> objId, "type" -> objType.toString, "content" -> content)
  }

  def delete(uri: String): Unit = {
    delete("uri" -> uri)
  }

}
