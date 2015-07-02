package com.arcusys.valamis.lesson.generator.tincan.file.html

import com.arcusys.valamis.lesson.generator.tincan.TinCanPackageGeneratorProperties
import com.arcusys.valamis.lesson.generator.util.ResourceHelpers
import com.arcusys.valamis.questionbank.model._
import com.arcusys.valamis.quiz.model.PPTXQuizQuestion
import com.arcusys.valamis.util.mustache.Mustache
import com.arcusys.valamis.util.JsonSupport._
import scala.util.Random


class TinCanQuestionViewGenerator(isPreview: Boolean) {
  private def removeLineBreak(source: String) = if (source != null) source.replaceAll("\n", "").replaceAll("\r", "") else null

  private def getResourceStream(name: String) = Thread.currentThread.getContextClassLoader.getResourceAsStream(name)

  private def prepareString(source: String) = (if (isPreview) removeLineBreak(source) else ResourceHelpers.skipContextPathURL(removeLineBreak(source))).replaceAll("\n", "").replaceAll("\r", "")
  private def prepareStringKeepNewlines(source: String) = if (isPreview) source else ResourceHelpers.skipContextPathURL(source)

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
    val newsrc = src match {
      case s if s contains "youtube.com/embed" => s match {
        case x if x contains "?" => src + "&enablejsapi=1"
        case _                   => src + "?enablejsapi=1"
      }
      case s if s contains "player.vimeo.com/" => s match {
        case x if x contains "?" => src + "&api=1"
        case _                   => src + "?api=1"
      }
      case _ => src
    }
    generateHTMLByQuestionType("iframe", Map("id" -> id, "title" -> title, "src" -> newsrc))
  }

  def getViewModelFromQuestion(question: Question[Answer], autoShowAnswer: Boolean = false, contextPath: String = "") = question match {
    case choiceQuestion: ChoiceQuestion =>
      val answers = choiceQuestion.answers.map(answer =>
        Map("text" -> prepareString(answer.text),
          "id" -> answer.id,
          "score" -> answer.score))
      val correctAnswers = json(choiceQuestion.answers.filter(_.isCorrect).map(x => x.id)).get
      val multipleChoice = !choiceQuestion.forceCorrectCount || (choiceQuestion.answers.count(_.isCorrect) > 1)
      val viewModel = Map(
        "id" -> choiceQuestion.id,
        "title" -> removeLineBreak(choiceQuestion.title),
        "text" -> prepareStringKeepNewlines(choiceQuestion.text),
        "answer" -> correctAnswers,
        "answers" -> answers,
        "multipleChoice" -> multipleChoice,
        "autoShowAnswer" -> autoShowAnswer,
        "hasExplanation" -> choiceQuestion.explanationText.nonEmpty,
        "rightAnswerText" -> choiceQuestion.rightAnswerText,
        "wrongAnswerText" -> choiceQuestion.wrongAnswerText,
        "explanation" -> choiceQuestion.explanationText,
        "contextPath" -> contextPath)
      viewModel
    case textQuestion: TextQuestion =>
      val possibleAnswers = json(textQuestion.answers.map(answer => Map("text" -> answer.text, "score" -> answer.score)))
      val isCaseSensitive = textQuestion.isCaseSensitive
      val viewModel = Map(
        "id" -> textQuestion.id,
        "title" -> removeLineBreak(textQuestion.title),
        "answers" -> possibleAnswers.get,
        "isCaseSensitive" -> isCaseSensitive,
        "text" -> prepareStringKeepNewlines(textQuestion.text),
        "autoShowAnswer" -> autoShowAnswer,
        "hasExplanation" -> textQuestion.explanationText.nonEmpty,
        "explanation" -> textQuestion.explanationText,
        "rightAnswerText" -> textQuestion.rightAnswerText,
        "wrongAnswerText" -> textQuestion.wrongAnswerText,
        "contextPath" -> contextPath)
      viewModel
    case numericQuestion: NumericQuestion =>
      val answers = json(numericQuestion.answers.map(answer =>
        Map("from" -> answer.notLessThan, "to" -> answer.notGreaterThan, "score" -> answer.score))).get
      val viewModel = Map(
        "id" -> numericQuestion.id,
        "title" -> removeLineBreak(numericQuestion.title),
        "text" -> prepareStringKeepNewlines(numericQuestion.text),
        "answers" -> answers,
        "autoShowAnswer" -> autoShowAnswer,
        "hasExplanation" -> numericQuestion.explanationText.nonEmpty,
        "explanation" -> numericQuestion.explanationText,
        "rightAnswerText" -> numericQuestion.rightAnswerText,
        "wrongAnswerText" -> numericQuestion.wrongAnswerText,
        "contextPath" -> contextPath)
      viewModel
    case positioningQuestion: PositioningQuestion =>
      val answers = json(positioningQuestion.answers.map(answer => Map("id" -> answer.id, "text" -> prepareString(answer.text)))).get
      val viewModel = Map(
        "id" -> positioningQuestion.id,
        "title" -> removeLineBreak(positioningQuestion.title),
        "text" -> prepareStringKeepNewlines(positioningQuestion.text),
        "answers" -> answers,
        "autoShowAnswer" -> autoShowAnswer,
        "hasExplanation" -> positioningQuestion.explanationText.nonEmpty,
        "score" -> positioningQuestion.answers.headOption.map(_.score),
        "explanation" -> positioningQuestion.explanationText,
        "rightAnswerText" -> positioningQuestion.rightAnswerText,
        "wrongAnswerText" -> positioningQuestion.wrongAnswerText,
        "contextPath" -> contextPath)
      viewModel
    case matchingQuestion: MatchingQuestion =>
      val answers = matchingQuestion.answers.map(answer =>
        Map("answerText" -> removeLineBreak(answer.text),
          "matchingText" -> removeLineBreak(answer.keyText.getOrElse(null)),
          "score" -> answer.score))
      val viewModel = Map(
        "id" -> matchingQuestion.id,
        "title" -> removeLineBreak(matchingQuestion.title),
        "text" -> prepareStringKeepNewlines(matchingQuestion.text),
        "answers" -> answers,
        "answersMatching" -> Random.shuffle(answers),
        "answerData" -> json(answers).get,
        "autoShowAnswer" -> autoShowAnswer,
        "hasExplanation" -> matchingQuestion.explanationText.nonEmpty,
        "explanation" -> matchingQuestion.explanationText,
        "rightAnswerText" -> matchingQuestion.rightAnswerText,
        "wrongAnswerText" -> matchingQuestion.wrongAnswerText,
        "contextPath" -> contextPath)
      viewModel
    case categorizationQuestion: CategorizationQuestion =>
      val answerJSON = json(categorizationQuestion.answers.map(answer =>
        Map("text" -> prepareString(answer.text),
          "matchingText" -> answer.answerCategoryText.map(prepareString),
          "score" -> answer.score))).get
      val answerText = categorizationQuestion.answers.map(answer => prepareString(answer.text)).distinct
      val matchingText = categorizationQuestion.answers.filter(a => a.answerCategoryText != None && !a.answerCategoryText.get.isEmpty).
        sortBy(_.answerCategoryText).
        map(answer => prepareString(answer.answerCategoryText.getOrElse("")))
      val randomAnswers = Random.shuffle(matchingText)
      val randomAnswersSize = if (randomAnswers.length % answerText.length == 0) randomAnswers.length / answerText.length else randomAnswers.length / answerText.length + 1
      val viewModel = Map(
        "id" -> categorizationQuestion.id,
        "title" -> removeLineBreak(categorizationQuestion.title),
        "text" -> prepareStringKeepNewlines(categorizationQuestion.text),
        "answerText" -> answerText,
        "matchingText" -> matchingText,
        "randomAnswers" -> (1 to randomAnswersSize).zipWithIndex.map {
          case (model, index) => {
            val skip = index * answerText.length
            val take = if (randomAnswers.length - skip < answerText.length) randomAnswers.length % answerText.length else answerText.length
            randomAnswers.drop(skip).take(take)
          }
        },
        "answers" -> answerJSON,
        "autoShowAnswer" -> autoShowAnswer,
        "hasExplanation" -> categorizationQuestion.explanationText.nonEmpty,
        "explanation" -> categorizationQuestion.explanationText,
        "rightAnswerText" -> categorizationQuestion.rightAnswerText,
        "wrongAnswerText" -> categorizationQuestion.wrongAnswerText,
        "contextPath" -> contextPath)
      viewModel
    case essayQuestion: EssayQuestion =>
      val viewModel = Map(
        "id" -> essayQuestion.id,
        "title" -> removeLineBreak(essayQuestion.title),
        "text" -> essayQuestion.text,
        "autoShowAnswer" -> autoShowAnswer,
        "explanation" -> essayQuestion.explanationText,
        "contextPath" -> contextPath)
      viewModel
    case embeddedAnswerQuestion: EmbeddedAnswerQuestion =>
      val viewModel = Map(
        "id" -> embeddedAnswerQuestion.id,
        "title" -> removeLineBreak(embeddedAnswerQuestion.title),
        "text" -> embeddedAnswerQuestion.text,
        "autoShowAnswer" -> autoShowAnswer,
        "explanation" -> embeddedAnswerQuestion.explanationText,
        "rightAnswerText" -> embeddedAnswerQuestion.rightAnswerText,
        "wrongAnswerText" -> embeddedAnswerQuestion.wrongAnswerText,
        "contextPath" -> contextPath)
      viewModel
    case plainText: PlainText =>
      val viewModel = Map(
        "id" -> plainText.id,
        "title" -> removeLineBreak(plainText.title),
        "text" -> prepareStringKeepNewlines(plainText.text),
        "autoShowAnswer" -> autoShowAnswer,
        "explanation" -> plainText.explanationText,
        "contextPath" -> contextPath)
      viewModel
    case videoDLQuestion: DLVideo =>
      val viewModel = Map(
        "id" -> videoDLQuestion.id,
        "title" -> removeLineBreak(videoDLQuestion.title),
        "uuid" -> prepareString(videoDLQuestion.uuid),
        "autoShowAnswer" -> autoShowAnswer,
        "groupId" -> videoDLQuestion.groupId,
        "hasExplanation" -> videoDLQuestion.explanationText.nonEmpty,
        "explanation" -> removeLineBreak(videoDLQuestion.explanationText),
        "contextPath" -> contextPath)
      viewModel
    case purePlainText: PurePlainText =>
      val viewModel = Map("data" -> purePlainText.text,
        "contextPath" -> contextPath)
      viewModel
    case _ => throw new Exception("Service: Oops! Can't recognize question type")
  }

  def getHTMLByQuestionId(question: Question[Answer], autoShowAnswer: Boolean, contextPath: String = "") = {
    val viewModel = getViewModelFromQuestion(question, autoShowAnswer, contextPath)
    question match {
      case choiceQuestion: ChoiceQuestion => generateHTMLByQuestionType("ChoiceQuestion", viewModel)
      case textQuestion: TextQuestion => generateHTMLByQuestionType("ShortAnswerQuestion", viewModel)
      case numericQuestion: NumericQuestion => generateHTMLByQuestionType("NumericQuestion", viewModel)
      case positioningQuestion: PositioningQuestion => generateHTMLByQuestionType("PositioningQuestion", viewModel)
      case matchingQuestion: MatchingQuestion => generateHTMLByQuestionType("MatchingQuestion", viewModel)
      case categorizationQuestion: CategorizationQuestion => generateHTMLByQuestionType("CategorizationQuestion", viewModel)
      case essayQuestion: EssayQuestion => generateHTMLByQuestionType("EssayQuestion", viewModel)
      case embeddedAnswerQuestion: EmbeddedAnswerQuestion => generateHTMLByQuestionType("EmbeddedAnswerQuestion", viewModel)
      case plainText: PlainText => generateHTMLByQuestionType("PlainText", viewModel)
      case videoDLQuestion: DLVideo => generateHTMLByQuestionType("DLVideo", viewModel)
      case purePlainText: PurePlainText => generateHTMLByQuestionType("PurePlainText", viewModel)
      case _ => throw new Exception("Service: Oops! Can't recognize question type")
    }
  }

  def generateRevealJSQuiz(id: Int, rootActivityId: String, title: String, description: String, serializedQuestionData: String, sections: String, maxDuration: Option[Int], properties: TinCanPackageGeneratorProperties) = {
    val mustachedTimer = {
      val timerModel = Map("maxDuration" -> maxDuration.map(_ * 60).getOrElse(0))
      val is = getResourceStream("common/timer.js")

      new Mustache(scala.io.Source.fromInputStream(is).mkString).render(timerModel)
    }
    val viewModel = Map(
      "id" -> id,
      "rootActivityId" -> rootActivityId,
      "title" -> title,
      "description" -> description,
      "serializedQuestionData" -> serializedQuestionData,
      "sections" -> sections,
      "isPreview" -> isPreview,
      "initProperties" -> json(Map("randomOrdering" -> properties.randomOrdering, "questionsCount" -> properties.questionsPerUser)).get,
      "isRandomized" -> properties.randomOrdering,
      "theme" -> properties.theme,
      "timerSource" -> mustachedTimer,
      "scoreLimit" -> properties.scoreLimit
    )
    new Mustache(scala.io.Source.fromInputStream(getResourceStream("tincan/revealjs.html")).mkString).render(viewModel)
  }

  def generateExternalIndex(endpoint: String) = {
    generateHTMLByQuestionType("external-reveal", Map("endpoint" -> endpoint))
  }

  private def generateHTMLByQuestionType(questionTypeName: String, viewModel: Map[String, Any]) = {
    val renderedQuestion = new Mustache(scala.io.Source.fromInputStream(getResourceStream("tincan/" + questionTypeName + ".html")).mkString).render(viewModel + ("isPreview" -> isPreview))
    if (isPreview) {
      generateRevealJSQuiz(0, "", "Preview", "Preview", renderedQuestion, "", None, new TinCanPackageGeneratorProperties())
    } else {
      renderedQuestion
    }
  }
}