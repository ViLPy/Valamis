package com.arcusys.learn.repositories

/**
 * Created by Iliya Tryapitsin on 28.04.2014.
 */
abstract trait MutableEntityRepository[E] extends BaseEntityRepository[E] {
  def modify(entity: E): E
}

abstract trait BaseEntityRepository[E] {
  def get(keys: (String, Any)*): E

  def create(entity: E): E

  def delete(keys: (String, Any)*)
}

abstract trait CreateSupport[E] {
  def create(entity: E): E
}

abstract trait DeleteSupport[E] {
  def delete(entity: E)
}

abstract trait ModifySupport[E] {
  def modify(entity: E): E
}

