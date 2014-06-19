package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object DndModeType extends Enumeration {
  type DndModeType = Value

  val LAST = Value("LAST")
  val BEFORE = Value("BEFORE")
  val INSIDE = Value("INSIDE")
  val AFTER = Value("AFTER")
}