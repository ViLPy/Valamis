package com.arcusys.scorm.util

import com.arcusys.learn.questionbank.model._
import com.arcusys.scala.json.Json._

object QuestionSerializer {

  def buildItemMap(question: Question[Answer]) = {
    def buildAnswersData = {
      toJson(question match {
        case e: ChoiceQuestion =>
          for (answer <- e.answers) yield Map("answerText" -> answer.text, "isCorrect" -> answer.isCorrect)
        case e: TextQuestion =>
          for (answer <- e.answers) yield Map("answerText" -> answer.text)
        case e: NumericQuestion =>
          for (answer <- e.answers) yield Map("rangeFrom" -> answer.notLessThan, "rangeTo" -> answer.notGreaterThan)
        case e: PositioningQuestion =>
          for (answer <- e.answers) yield Map("answerText" -> answer.text, "isCorrect" -> answer.isCorrect)
        case e: MatchingQuestion =>
          for (answer <- e.answers) yield Map("answerText" -> answer.text, "matchingText" -> answer.keyText.getOrElse(""))
        case e: CategorizationQuestion =>
          for (answer <- e.answers) yield Map("answerText" -> answer.text, "matchingText" -> answer.answerCategoryText.getOrElse(""))
        case e: EssayQuestion => Seq[Map[String, Any]]()
        case e: EmbeddedAnswerQuestion => Seq[Map[String, Any]]()
        case e: PlainText => Seq[Map[String, Any]]()
        case _ => throw new Exception("Service: Oops! Can't recognize question type")
      }).replaceAll("\"", "'")
    }

    val forceCorrectCount = question match {
      case e: ChoiceQuestion => e.forceCorrectCount
      case e: PositioningQuestion => e.forceCorrectCount
      case _ => false
    }

    val isCaseSensitive = question match {
      case e: TextQuestion => e.isCaseSensitive
      case _ => false
    }

    Map("id" -> question.id,
      "type" -> "entity",
      "title" -> question.title,
      "text" -> question.text,
      "explanationText" -> question.explanationText,
      "forceCorrectCount" -> forceCorrectCount,
      "isCaseSensitive" -> isCaseSensitive,
      "answers" -> buildAnswersData,
      "questionType" -> question.questionTypeCode,
      "categoryID" -> question.categoryID.getOrElse(-1))
  }

  //[{attr:{"id":_id, "rel":"folder"}, "data":_name,"state":"closed"}]
  def buildOutputJSON(dataSeq: Seq[Question[Answer]]) = dataSeq map buildItemMap
}