package com.arcusys.learn.models.Gradebook

/**
 * Statement Grade model fo response
 */
case class StatementGradeResponse(id: Int,
  obj: String, //StatementObject,
  userResponse: String,
  correctResponse: String,
  verb: String, //Verb,
  date: String,
  result: String, //Result,
  //attempts: Seq[StatementAttemptResponse],
  statements: Seq[StatementGradeResponse])
