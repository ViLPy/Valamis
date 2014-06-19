package com.arcusys.learn.storage.impl

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
trait KeyedEntityStorageExt[E] extends KeyedEntityStorage[E] {
  def getByID(id: Int): Option[E] = getByID(id, Nil: _*)

  def delete(id: Int) { delete("id" -> id) }

  def createAndGetID(entity: E): Int = createAndGetID(entity, Seq(): _*)
}
