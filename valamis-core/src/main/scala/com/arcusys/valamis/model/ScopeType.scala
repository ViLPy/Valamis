package com.arcusys.valamis.model

/** When to do randomization of child activities */
object ScopeType extends Enumeration {
  type ScopeType = Value
  val Instance = Value("instance")
  val Site = Value("site")
  val Page = Value("page")
  val Player = Value("player")
}