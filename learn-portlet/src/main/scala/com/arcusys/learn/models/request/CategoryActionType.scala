package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 10.04.2014.
 */
object CategoryActionType extends Enumeration {
  type CategoryActionType = Value

  val WITH_QUESTIONS = Value("WITHQUESTIONS")
  val ADD = Value("ADD")
  val UPDATE = Value("UPDATE")
  val DELETE = Value("DELETE")
  val MOVE = Value("MOVE")
  val MOVE_TO_COURSE = Value("MOVETOCOURSE")
}