package com.arcusys.learn.storage.impl

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
trait EntityStorageExt[E] extends EntityStorage[E] {
  def getAll: Seq[E] = getAll()

  def modify(entity: E) {
    modify(entity, Nil: _*)
  }

  def create(entity: E) {
    create(entity, Nil: _*)
  }

  def renew() {
    doRenew()
  }

  protected def doRenew()
}
