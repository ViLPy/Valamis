package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 10.04.2014.
 */
object CategoryActionType extends Enumeration {
  type CategoryActionType = Value

  val WithQuestions = Value("WITHQUESTIONS")
  val Add = Value("ADD")
  val Update = Value("UPDATE")
  val Delete = Value("DELETE")
  val Move = Value("MOVE")
  val MoveToCourse = Value("MOVETOCOURSE")
  val AllChildren = Value("ALLCHILDREN")
  val ContentAmount = Value("CONTENTAMOUNT")
}