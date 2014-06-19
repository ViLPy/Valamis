package com.arcusys.learn.models.Gradebook

import org.joda.time.DateTime

/**
 * Activity attempt model for response
 */
case class StatementAttemptResponse(id: Int,
  date: DateTime,
  grade: Int,
  userResponse: String,
  correctResponse: String)
