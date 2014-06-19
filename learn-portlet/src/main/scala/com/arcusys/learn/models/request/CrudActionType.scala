package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object CrudActionType extends Enumeration {
  val ADD = Value("ADD")
  val UPDATE = Value("UPDATE")
  val DELETE = Value("DELETE")

  type CrudAction = Value
}
