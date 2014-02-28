package com.arcusys.learn.tincan.model

import com.arcusys.learn.tincan.model.LrsScope.LrsScope

//
// Created by iliya.tryapitsin on 12.02.14.
//
object LrsScope extends Enumeration {
  type LrsScope = Value

  object OAuth {
    val NAME: String = "scope"
  }

  val StatementsWrite = Value(1, "StatementsWrite")
  val StatementsReadMine = Value(2, "StatementsReadMine")
  val StatementsRead = Value(4, "StatementsRead")
  val State = Value(8, "State")
  val Define = Value(16, "Define")
  val Profile = Value(32, "Profile")
  val AllRead = Value(64, "AllRead")
  val All = Value(128, "All")
}

object LrsScopeConverters {
  implicit def fromString(strScope: String): LrsScope = {
    return LrsScope.withName(strScope)
  }
}
