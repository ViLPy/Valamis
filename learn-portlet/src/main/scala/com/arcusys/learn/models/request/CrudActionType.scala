package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object CrudActionType extends Enumeration {
  val Add = Value("ADD")
  val Update = Value("UPDATE")
  val Delete = Value("DELETE")

  type CrudAction = Value
}
