package com.arcusys.learn.models.request

/**
 * User: Yulia.Glushonkova
 * Date: 05.05.14
 */
object QuestionActionType extends Enumeration {
  val ADD = Value("ADD")
  val UPDATE = Value("UPDATE")
  val DELETE = Value("DELETE")
  val MOVE = Value("MOVE")
  val GET_BY_ID = Value("GETBYID")
  val GET_CHILDREN = Value("GETCHILDREN")
  val MOVE_TO_COURSE = Value("MOVETOCOURSE")

  type QuestionActionType = Value
}
