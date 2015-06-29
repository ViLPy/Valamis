package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 04.03.14.
 */
object DndModeType extends Enumeration {
  type DndModeType = Value

  val Last = Value("LAST")
  val Before = Value("BEFORE")
  val Inside = Value("INSIDE")
  val After = Value("AFTER")
}