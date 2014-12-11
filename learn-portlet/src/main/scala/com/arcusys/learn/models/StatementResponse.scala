package com.arcusys.learn.models

import com.arcusys.learn.tincan.model.LanguageMap

/**
 * Created by Iliya Tryapitsin on 12.03.14.
 */
case class StatementResponse(
  certificateId: Int,
  tincanStmntObj: String,
  tincanStmntVerb: String,
  value: Option[Int],
  period: String)

case class AvailableStatementResponse(
  verb: String,
  verbName: LanguageMap,
  obj: String,
  objName: LanguageMap)
