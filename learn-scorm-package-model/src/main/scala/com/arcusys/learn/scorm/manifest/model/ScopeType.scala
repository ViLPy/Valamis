package com.arcusys.learn.scorm.manifest.model

/** When to do randomization of child activities */
object ScopeType extends Enumeration {
  type ScopeType = Value
  val Instance = Value("instanceScope")
  val Site = Value("siteScope")
  val Page = Value("pageScope")
  val Player = Value("playerScope")
}