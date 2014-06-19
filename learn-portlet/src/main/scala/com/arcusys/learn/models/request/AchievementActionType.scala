package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object AchievementActionType extends Enumeration {
  type AchievementActionType = Value

  val ADD = Value("ADD")
  val UPDATE = Value("UPDATE")
  val DELETE = Value("DELETE")
  val ALL = Value("ALL")
  val CURRENT_USER = Value("CURRENTUSER")
  val USER = Value("USER")
  val APPLY = Value("APPLY")
  val REMOVE = Value("REMOVE")
}
