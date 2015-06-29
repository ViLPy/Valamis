package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object AchievementActionType extends Enumeration {
  type AchievementActionType = Value

  val Add = Value("ADD")
  val Update = Value("UPDATE")
  val Delete = Value("DELETE")
  val All = Value("ALL")
  val CurrentUser = Value("CURRENTUSER")
  val User = Value("USER")
  val Apply = Value("APPLY")
  val Remove = Value("REMOVE")
}
