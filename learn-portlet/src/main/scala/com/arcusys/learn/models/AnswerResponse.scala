package com.arcusys.learn.models

/**
 * User: Yulia.Glushonkova
 * Date: 05.05.14
 */
case class AnswerResponse(
  answerText: String = "",
  isCorrect: Boolean = false,
  rangeFrom: BigDecimal = 0,
  rangeTo: BigDecimal = 0,
  matchingText: String = "")
