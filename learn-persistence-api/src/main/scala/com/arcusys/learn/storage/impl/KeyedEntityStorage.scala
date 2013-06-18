package com.arcusys.learn.storage.impl

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
trait KeyedEntityStorage[E] extends EntityStorage[E] {
  def getByID(id: Int, parameters: (String, Any)*): Option[E]

  def createAndGetID(entity: E, parameters: (String, Any)*): Int
  def createAndGetID(parameters: (String, Any)*): Int
}
