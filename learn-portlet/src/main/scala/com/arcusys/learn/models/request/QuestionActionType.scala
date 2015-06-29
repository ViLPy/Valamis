package com.arcusys.learn.models.request

/**
 * User: Yulia.Glushonkova
 * Date: 05.05.14
 */
object QuestionActionType extends Enumeration {
  val Add = Value("ADD")
  val Update = Value("UPDATE")
  val Delete = Value("DELETE")
  val Move = Value("MOVE")
  val GetById = Value("GETBYID")
  val GetChildren = Value("GETCHILDREN")
  val MoveToCourse = Value("MOVETOCOURSE")

  type QuestionActionType = Value
}
