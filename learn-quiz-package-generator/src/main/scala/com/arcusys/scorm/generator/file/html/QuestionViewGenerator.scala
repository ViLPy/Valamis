package com.arcusys.scorm.generator.file.html

import com.arcusys.scorm.generator.util.ResourceHelpers
import com.arcusys.learn.questionbank.model._
import com.arcusys.scala.mustache._
import com.arcusys.scala.json._
import java.net.URLDecoder

class QuestionViewGenerator(isPreview: Boolean) {
  private lazy val genericJS = scala.io.Source.fromInputStream(getResourceStream("questionScript.html")).mkString
  private lazy val genericCSS = scala.io.Source.fromInputStream(getResourceStream("questionStyle.html")).mkString

  private lazy val previewJS = scala.io.Source.fromInputStream(getResourceStream("questionScriptPreview.html")).mkString
  private lazy val previewCSS = scala.io.Source.fromInputStream(getResourceStream("questionStylePreview.html")).mkString

  private def decode(source: String) = if (source!=null) URLDecoder.decode(source, "UTF-8").replaceAll("\n","").replaceAll("\r","") else null

  private def getResourceStream(name: String) = Thread.currentThread.getContextClassLoader.getResourceAsStream(name)

  private def prepareString(source: String) = (if (isPreview) decode(source) else ResourceHelpers.skipContextPathURL(decode(source))).replaceAll("\n","").replaceAll("\r","")

  def getHTMLForStaticPage(pageData: String) = {
    val string = prepareString(pageData)
    generateHTMLByQuestionType("static", Map("data" -> string))
  }

  def getHTMLByQuestionId(question: Question[Answer], contextPath: String = "") = {
    question match {
      case choiceQuestion: ChoiceQuestion =>
        val answers = choiceQuestion.answers.map(answer => Map("text" -> prepareString(answer.text), "id" -> prepareString(answer.text)))
        val correctAnswers = Json.toJson(choiceQuestion.answers.filter(_.isCorrect).map(x => prepareString(x.text)))
        val multipleChoice = !choiceQuestion.forceCorrectCount || (choiceQuestion.answers.filter(_.isCorrect).size > 1)
        val viewModel = Map("title" -> decode(choiceQuestion.title),
          "text" -> prepareString(choiceQuestion.text),
          "answer" -> correctAnswers,
          "answers" -> answers,
          "multipleChoice" -> multipleChoice,
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("ChoiceQuestion", viewModel)

      case textQuestion: TextQuestion =>
        val possibleAnswers = Json.toJson(textQuestion.answers.map(_.text))
        val isCaseSensitive = textQuestion.isCaseSensitive
        val viewModel = Map("title" -> decode(textQuestion.title),
          "answers" -> possibleAnswers,
          "isCaseSensitive" -> Json.toJson(isCaseSensitive),
          "text" -> prepareString(textQuestion.text),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("ShortAnswerQuestion", viewModel)

      case numericQuestion: NumericQuestion =>
        val answers = Json.toJson(numericQuestion.answers.map(answer => Map("from" -> answer.notLessThan, "to" -> answer.notGreaterThan)))
        val viewModel = Map("title" -> decode(numericQuestion.title),
          "text" -> prepareString(numericQuestion.text),
          "answers" -> answers,
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("NumericQuestion", viewModel)

      case positioningQuestion: PositioningQuestion =>
        val answers = Json.toJson(positioningQuestion.answers.map(answer => Map("id" -> answer.id, "text" -> prepareString(answer.text))))
        val viewModel = Map("title" -> decode(positioningQuestion.title),
          "text" -> prepareString(positioningQuestion.text),
          "answers" -> answers,
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("PositioningQuestion", viewModel)

      case matchingQuestion: MatchingQuestion =>
        val correctAnswers = matchingQuestion.answers.map(answer => Seq(decode(answer.text), answer.keyText.getOrElse(null)).mkString("[.]")).mkString("[,]")
        val answers = matchingQuestion.answers.map(answer => Map("answerText" -> decode(answer.text), "matchingText" -> decode(answer.keyText.getOrElse(null))))
        val viewModel = Map("title" -> decode(matchingQuestion.title),
          "text" -> prepareString(matchingQuestion.text),
          "answers" -> answers,
          "answerData" -> correctAnswers.replaceAll("\"","'"),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("MatchingQuestion", viewModel)

      case categorizationQuestion: CategorizationQuestion =>
        val answerJSON = Json.toJson(categorizationQuestion.answers.map(answer => Map("text" -> prepareString(answer.text), "matchingText" -> answer.answerCategoryText.map(prepareString))))
        val answerText = categorizationQuestion.answers.map(answer => prepareString(answer.text)).distinct
        val matchingText = categorizationQuestion.answers.filter(a => a.answerCategoryText != None && !a.answerCategoryText.get.isEmpty).
          sortBy(_.answerCategoryText).
          map(answer => prepareString(answer.answerCategoryText.getOrElse("")))
        val viewModel = Map("title" -> decode(categorizationQuestion.title),
          "text" -> prepareString(categorizationQuestion.text),
          "answerText" -> answerText,
          "matchingText" -> matchingText,
          "answers" -> answerJSON,
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("CategorizationQuestion", viewModel)

      case essayQuestion: EssayQuestion =>
        val viewModel = Map("title" -> decode(essayQuestion.title),
          "text" -> decode(essayQuestion.text),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("EssayQuestion", viewModel)

      case embeddedAnswerQuestion: EmbeddedAnswerQuestion =>
        val viewModel = Map("title" -> decode(embeddedAnswerQuestion.title),
          "text" -> decode(embeddedAnswerQuestion.text),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("EmbeddedAnswerQuestion", viewModel)

      case plainText: PlainText =>
        val viewModel = Map("title" -> decode(plainText.title),
          "text" -> prepareString(plainText.text),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("PlainText", viewModel)

      case _ => throw new Exception("Service: Oops! Can't recognize question type")
    }
  }

  private def generateHTMLByQuestionType(questionTypeName: String, viewModel: Map[String, Any]) = {
    (if (isPreview)
      new Mustache(previewJS).render(viewModel) + new Mustache(previewCSS).render(viewModel + ("isPreview" -> isPreview))
    else
      genericJS + genericCSS) + new Mustache(scala.io.Source.fromInputStream(getResourceStream(questionTypeName + ".html")).mkString).render(viewModel + ("isPreview" -> isPreview))
  }
}
