package com.arcusys.tincan.generator.file.html

import com.arcusys.learn.quiz.model.PPTXQuizQuestion
import com.arcusys.scorm.generator.util.ResourceHelpers
import com.arcusys.learn.questionbank.model._
import com.arcusys.learn.util.mustache._
import com.arcusys.learn.util.JsonSupport._
import scala.util.Random

import java.net.URLDecoder

class TinCanQuestionViewGenerator(isPreview: Boolean) {
  private def decode(source: String) = if (source != null) URLDecoder.decode(source, "UTF-8").replaceAll("\n", "").replaceAll("\r", "") else null
  private def decodeKeepNewlines(source: String) = if (source != null) URLDecoder.decode(source, "UTF-8") else null

  private def getResourceStream(name: String) = Thread.currentThread.getContextClassLoader.getResourceAsStream(name)

  private def prepareString(source: String) = (if (isPreview) decode(source) else ResourceHelpers.skipContextPathURL(decode(source))).replaceAll("\n", "").replaceAll("\r", "")
  private def prepareStringKeepNewlines(source: String) = if (isPreview) decodeKeepNewlines(source) else ResourceHelpers.skipContextPathURL(decodeKeepNewlines(source))

  def getHTMLForStaticPage(pageData: String) = {
    val string = prepareString(pageData)
    generateHTMLByQuestionType("static", Map("data" -> string))
  }

  def getHTMLForRevealPage(pageData: String) = {
    val string = prepareString(pageData)
    generateHTMLByQuestionType("reveal", Map("data" -> string))
  }

  def getHTMLForPDFPage(id: Int, title: String, filename: String) = {
    generateHTMLByQuestionType("pdf", Map("id" -> id, "title" -> title, "filename" -> filename))
  }

  def getHTMLForPPTXPage(pptx: PPTXQuizQuestion) = {
    generateHTMLByQuestionType("pptx", Map("id" -> pptx.id, "title" -> pptx.title.get.takeWhile(_ != '.')))
  }

  def getHTMLForPPTXForegroundPage(pptx: PPTXQuizQuestion) = {
    generateHTMLByQuestionType("pptx-foreground-iframe", Map("quizID" -> pptx.quizID, "file" -> pptx.file))
  }

  def getHTMLForIframePage(id: Int, title: String, src: String) = {
    generateHTMLByQuestionType("iframe", Map("id" -> id, "title" -> title, "src" -> src))
  }

  def getHTMLByQuestionId(question: Question[Answer], autoShowAnswer: Boolean, contextPath: String = "") = {
    question match {
      case choiceQuestion: ChoiceQuestion =>
        val answers = choiceQuestion.answers.map(answer =>
          Map("text" -> prepareString(answer.text),
            "id" -> answer.id,
            "score" -> answer.score))
        val correctAnswers = json(choiceQuestion.answers.filter(_.isCorrect).map(x => x.id)).get
        val multipleChoice = !choiceQuestion.forceCorrectCount || (choiceQuestion.answers.count(_.isCorrect) > 1)
        val viewModel = Map(
          "id" -> choiceQuestion.id,
          "title" -> decode(choiceQuestion.title),
          "text" -> prepareStringKeepNewlines(choiceQuestion.text),
          "answer" -> correctAnswers,
          "answers" -> answers,
          "multipleChoice" -> multipleChoice,
          "autoShowAnswer" -> autoShowAnswer,
          "hasExplanation" -> choiceQuestion.explanationText.nonEmpty,
          "explanation" -> decodeKeepNewlines(choiceQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("ChoiceQuestion", viewModel)

      case textQuestion: TextQuestion =>
        val possibleAnswers = json(textQuestion.answers.map(answer => Map("text" -> answer.text, "score" -> answer.score)))
        val isCaseSensitive = textQuestion.isCaseSensitive
        val viewModel = Map(
          "id" -> textQuestion.id,
          "title" -> decode(textQuestion.title),
          "answers" -> possibleAnswers.get,
          "isCaseSensitive" -> isCaseSensitive,
          "text" -> prepareStringKeepNewlines(textQuestion.text),
          "autoShowAnswer" -> autoShowAnswer,
          "hasExplanation" -> textQuestion.explanationText.nonEmpty,
          "explanation" -> decodeKeepNewlines(textQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("ShortAnswerQuestion", viewModel)

      case numericQuestion: NumericQuestion =>
        val answers = json(numericQuestion.answers.map(answer =>
          Map("from" -> answer.notLessThan, "to" -> answer.notGreaterThan, "score" -> answer.score))).get
        val viewModel = Map(
          "id" -> numericQuestion.id,
          "title" -> decode(numericQuestion.title),
          "text" -> prepareStringKeepNewlines(numericQuestion.text),
          "answers" -> answers,
          "autoShowAnswer" -> autoShowAnswer,
          "hasExplanation" -> numericQuestion.explanationText.nonEmpty,
          "explanation" -> decodeKeepNewlines(numericQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("NumericQuestion", viewModel)

      case positioningQuestion: PositioningQuestion =>
        val answers = json(positioningQuestion.answers.map(answer => Map("id" -> answer.id, "text" -> prepareString(answer.text)))).get
        val viewModel = Map(
          "id" -> positioningQuestion.id,
          "title" -> decode(positioningQuestion.title),
          "text" -> prepareStringKeepNewlines(positioningQuestion.text),
          "answers" -> answers,
          "autoShowAnswer" -> autoShowAnswer,
          "hasExplanation" -> positioningQuestion.explanationText.nonEmpty,
          "score" -> positioningQuestion.answers.headOption.map(_.score),
          "explanation" -> decodeKeepNewlines(positioningQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("PositioningQuestion", viewModel)

      case matchingQuestion: MatchingQuestion =>
        val answers = matchingQuestion.answers.map(answer =>
          Map("answerText" -> decode(answer.text),
            "matchingText" -> decode(answer.keyText.getOrElse(null)),
            "score" -> answer.score))
        val viewModel = Map(
          "id" -> matchingQuestion.id,
          "title" -> decode(matchingQuestion.title),
          "text" -> prepareStringKeepNewlines(matchingQuestion.text),
          "answers" -> answers,
          "answersMatching" -> Random.shuffle(answers),
          "answerData" -> json(answers).get,
          "autoShowAnswer" -> autoShowAnswer,
          "hasExplanation" -> matchingQuestion.explanationText.nonEmpty,
          "explanation" -> decodeKeepNewlines(matchingQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("MatchingQuestion", viewModel)

      case categorizationQuestion: CategorizationQuestion =>
        val answerJSON = json(categorizationQuestion.answers.map(answer =>
          Map("text" -> prepareString(answer.text),
            "matchingText" -> answer.answerCategoryText.map(prepareString),
            "score" -> answer.score))).get
        val answerText = categorizationQuestion.answers.map(answer => prepareString(answer.text)).distinct
        val matchingText = categorizationQuestion.answers.filter(a => a.answerCategoryText != None && !a.answerCategoryText.get.isEmpty).
          sortBy(_.answerCategoryText).
          map(answer => prepareString(answer.answerCategoryText.getOrElse("")))
        val viewModel = Map(
          "id" -> categorizationQuestion.id,
          "title" -> decode(categorizationQuestion.title),
          "text" -> prepareStringKeepNewlines(categorizationQuestion.text),
          "answerText" -> answerText,
          "matchingText" -> matchingText,
          "answers" -> answerJSON,
          "autoShowAnswer" -> autoShowAnswer,
          "hasExplanation" -> categorizationQuestion.explanationText.nonEmpty,
          "explanation" -> decodeKeepNewlines(categorizationQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("CategorizationQuestion", viewModel)

      case essayQuestion: EssayQuestion =>
        val viewModel = Map(
          "id" -> essayQuestion.id,
          "title" -> decode(essayQuestion.title),
          "text" -> decodeKeepNewlines(essayQuestion.text),
          "autoShowAnswer" -> autoShowAnswer,
          "explanation" -> decodeKeepNewlines(essayQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("EssayQuestion", viewModel)

      case embeddedAnswerQuestion: EmbeddedAnswerQuestion =>
        val viewModel = Map(
          "id" -> embeddedAnswerQuestion.id,
          "title" -> decode(embeddedAnswerQuestion.title),
          "text" -> decodeKeepNewlines(embeddedAnswerQuestion.text),
          "autoShowAnswer" -> autoShowAnswer,
          "explanation" -> decodeKeepNewlines(embeddedAnswerQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("EmbeddedAnswerQuestion", viewModel)

      case plainText: PlainText =>
        val viewModel = Map(
          "id" -> plainText.id,
          "title" -> decode(plainText.title),
          "text" -> prepareStringKeepNewlines(plainText.text),
          "autoShowAnswer" -> autoShowAnswer,
          "explanation" -> decodeKeepNewlines(plainText.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("PlainText", viewModel)

      case videoDLQuestion: DLVideo =>
        val viewModel = Map(
          "id" -> videoDLQuestion.id,
          "title" -> decode(videoDLQuestion.title),
          "uuid" -> prepareString(videoDLQuestion.uuid),
          "autoShowAnswer" -> autoShowAnswer,
          "groupId" -> videoDLQuestion.groupId,
          "hasExplanation" -> videoDLQuestion.explanationText.nonEmpty,
          "explanation" -> decode(videoDLQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("DLVideo", viewModel)

      case purePlainText: PurePlainText =>
        val viewModel = Map("data" -> decodeKeepNewlines(purePlainText.text),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("PurePlainText", viewModel)

      case _ => throw new Exception("Service: Oops! Can't recognize question type")
    }
  }

  def generateRevealJSQuiz(id: Int, title: String, description: String, theme: Option[String], sections: String, randomOrdering: Boolean, questionsPerUser: Option[Int], maxDuration: Option[Int], rootActivity: String = "") = {
    val mustachedTimer = {
      val timerModel = Map("maxDuration" -> maxDuration.map(_ * 60).getOrElse(0))
      val is = getResourceStream("common/timer.js")

      new Mustache(scala.io.Source.fromInputStream(is).mkString).render(timerModel)
    }
    val viewModel = Map(
      "id" -> id,
      "title" -> title,
      "description" -> description,
      "sections" -> sections,
      "rootActivity" -> rootActivity,
      "isPreview" -> isPreview,
      "initProperties" -> json(Map("randomOrdering" -> randomOrdering, "questionsCount" -> questionsPerUser)).get,
      "isRandomized" -> randomOrdering,
      "theme" -> theme.getOrElse("default"),
      "timerSource" -> mustachedTimer
    )
    new Mustache(scala.io.Source.fromInputStream(getResourceStream("tincan/revealjs.html")).mkString).render(viewModel)
  }

  def generateExternalIndex(endpoint: String) = {
    generateHTMLByQuestionType("external-reveal", Map("endpoint" -> endpoint))
  }

  private def generateHTMLByQuestionType(questionTypeName: String, viewModel: Map[String, Any]) = {
    val renderedQuestion = new Mustache(scala.io.Source.fromInputStream(getResourceStream("tincan/" + questionTypeName + ".html")).mkString).render(viewModel + ("isPreview" -> isPreview))
    if (isPreview) {
      generateRevealJSQuiz(0, "Preview", "Preview", None, renderedQuestion, false, None, None)
    } else {
      renderedQuestion
    }
  }
}