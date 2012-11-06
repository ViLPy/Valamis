package com.arcusys.learn.questionbank.model

/**
 * A correct answer to a Numeric question
 * @param id              Unique internal ID of option/answer
 * @param notLessThan     Lower inclusive boundary of correct answer range
 * @param notGreaterThan  Higher inclusive boundary of correct answer range
 */
class NumericAnswer(id: Int, val notLessThan: BigDecimal, val notGreaterThan: BigDecimal) extends Answer(id)