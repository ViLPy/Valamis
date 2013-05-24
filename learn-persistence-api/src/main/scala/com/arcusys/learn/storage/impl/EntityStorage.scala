package com.arcusys.learn.storage.impl

/**
 * User: dkudinov
 * Date: 14.3.2013
 */
trait EntityStorage[E] {
  def getOne(parameters: (String, Any)*): Option[E]

  def getAll(parameters: (String, Any)*): Seq[E]

  def create(parameters: (String, Any)*)

  def create(entity: E, parameters: (String, Any)*)

  def delete(parameters: (String, Any)*)

  def modify(parameters: (String, Any)*)

  def modify(entity: E, parameters: (String, Any)*)

  def execute(sqlKey: String, parameters: (String, Any)*)

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[E]

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[E]

  def modify(sqlKey: String, parameters: (String, Any)*)
}
