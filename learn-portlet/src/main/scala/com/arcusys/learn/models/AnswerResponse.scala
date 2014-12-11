package com.arcusys.learn.models

import org.json4s.{ DefaultFormats, Extraction, CustomSerializer }
import org.json4s.JsonAST.{ JNothing, JValue }
import org.json4s.jackson.JsonMethods._
import com.arcusys.learn.tincan.model.Score

/**
 * User: Yulia.Glushonkova
 * Date: 05.05.14
 */
case class AnswerResponse(
  answerId: Long = 0,
  answerText: String = "",
  isCorrect: Boolean = false,
  rangeFrom: BigDecimal = 0,
  rangeTo: BigDecimal = 0,
  matchingText: String = "",
  score: Option[Double] = None,
  questionId: Long = 0)

class AnswerSerializer extends CustomSerializer[AnswerResponse](implicit format => ({
  case jValue: JValue =>
    val score = jValue.\("score") match {
      case JNothing => None
      case value: JValue =>
        try {
          Some(value.extract[String].toDouble)
        } catch {

          case e: Exception => None
        }
    }
    val isCorrect = jValue.\("isCorrect") match {
      case JNothing      => false
      case value: JValue => value.extract[Boolean]
    }
    AnswerResponse(
      jValue.\("answerId").extractOrElse(0), //.extract[Long],
      jValue.\("answerText").extractOrElse(""), //.extract[String],
      isCorrect, //jValue.\("isCorrect").extract[Boolean],
      jValue.\("rangeFrom").extractOrElse(0), //.extract[BigDecimal],
      jValue.\("rangeTo").extractOrElse(0), //extract[BigDecimal],
      jValue.\("matchingText").extractOrElse(""), //extract[String],
      score
    )
}, {
  case pack: AnswerResponse => render(Extraction.decompose(pack)(DefaultFormats))

}))