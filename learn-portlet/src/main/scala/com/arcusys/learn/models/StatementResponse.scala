package com.arcusys.learn.models

/**
 * Created by Iliya Tryapitsin on 12.03.14.
 */
case class StatementResponse(
  certificateId: Int,
  tincanStmntObj: String,
  tincanStmntVerb: String,
  value: Option[Int],
  period: String)
