package com.arcusys.scorm.generator.file.html

import com.arcusys.learn.quiz.model.DLVideoQuizQuestion
import com.arcusys.scorm.generator.util.ResourceHelpers
import com.arcusys.learn.questionbank.model._
import com.arcusys.learn.util.mustache._
import com.arcusys.learn.util.JsonSupport._

import java.net.URLDecoder

class QuestionViewGenerator(isPreview: Boolean) {
  private lazy val genericJS = scala.io.Source.fromInputStream(getResourceStream("questionScript.html")).mkString
  private lazy val genericCSS = scala.io.Source.fromInputStream(getResourceStream("questionStyle.html")).mkString

  private lazy val previewJS = scala.io.Source.fromInputStream(getResourceStream("questionScriptPreview.html")).mkString
  private lazy val previewCSS = scala.io.Source.fromInputStream(getResourceStream("questionStylePreview.html")).mkString

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

  def getHTMLForPPTXReview(quizID: Int, file: String) = {
    //FIXME: STUB, for not dealing with generateHTMLByQuestionType
    s""" <STYLE type="text/css">
           .review-container{ height: 100%; width: 100% }
           .review-container img { max-height: 100%; max-width: 100% }
         </STYLE>
         <div class="review-container">
           <img src="/delegate/files/images?folderId=quizData${quizID}&file=${file}" />
         </div>"""
  }

  def getHTMLForPPTX(quizID: Int, file: String) = {
    generateHTMLByQuestionType("pptx-scorm", Map("quizID" -> quizID, "file" -> file))
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
        val viewModel = Map("title" -> decode(choiceQuestion.title),
          "text" -> prepareStringKeepNewlines(choiceQuestion.text),
          "answer" -> correctAnswers,
          "answers" -> answers,
          "autoShowAnswer" -> autoShowAnswer,
          "multipleChoice" -> multipleChoice,
          "hasExplanation" -> choiceQuestion.explanationText.nonEmpty,
          "explanation" -> decodeKeepNewlines(choiceQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("ChoiceQuestion", viewModel)

      case textQuestion: TextQuestion =>
        val possibleAnswers = json(textQuestion.answers.map(answer => Map("text" -> answer.text, "score" -> answer.score)))
        val isCaseSensitive = textQuestion.isCaseSensitive
        val viewModel = Map("title" -> decode(textQuestion.title),
          "answers" -> possibleAnswers.get,
          "isCaseSensitive" -> isCaseSensitive,
          "autoShowAnswer" -> autoShowAnswer,
          "text" -> prepareStringKeepNewlines(textQuestion.text),
          "hasExplanation" -> textQuestion.explanationText.nonEmpty,
          "explanation" -> decodeKeepNewlines(textQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("ShortAnswerQuestion", viewModel)

      case numericQuestion: NumericQuestion =>
        val answers = json(numericQuestion.answers.map(answer =>
          Map("from" -> answer.notLessThan, "to" -> answer.notGreaterThan, "score" -> answer.score))).get
        val viewModel = Map("title" -> decode(numericQuestion.title),
          "text" -> prepareStringKeepNewlines(numericQuestion.text),
          "answers" -> answers,
          "autoShowAnswer" -> autoShowAnswer,
          "hasExplanation" -> numericQuestion.explanationText.nonEmpty,
          "explanation" -> decodeKeepNewlines(numericQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("NumericQuestion", viewModel)

      case positioningQuestion: PositioningQuestion =>
        val answers = json(positioningQuestion.answers.map(answer => Map("id" -> answer.id, "text" -> prepareString(answer.text)))).get
        val viewModel = Map("title" -> decode(positioningQuestion.title),
          "text" -> prepareStringKeepNewlines(positioningQuestion.text),
          "answers" -> answers,
          "autoShowAnswer" -> autoShowAnswer,
          "score" -> positioningQuestion.answers.headOption.map(_.score),
          "hasExplanation" -> positioningQuestion.explanationText.nonEmpty,
          "explanation" -> decodeKeepNewlines(positioningQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("PositioningQuestion", viewModel)

      case matchingQuestion: MatchingQuestion =>
        val answers = matchingQuestion.answers.map(answer =>
          Map("answerText" -> decode(answer.text),
            "matchingText" -> decode(answer.keyText.getOrElse(null)),
            "score" -> answer.score))
        val viewModel = Map("title" -> decode(matchingQuestion.title),
          "text" -> prepareStringKeepNewlines(matchingQuestion.text),
          "answers" -> answers,
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
        val viewModel = Map("title" -> decode(categorizationQuestion.title),
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
        val viewModel = Map("title" -> decode(essayQuestion.title),
          "text" -> decodeKeepNewlines(essayQuestion.text),
          "autoShowAnswer" -> autoShowAnswer,
          "hasExplanation" -> essayQuestion.explanationText.nonEmpty,
          "explanation" -> decodeKeepNewlines(essayQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("EssayQuestion", viewModel)

      case embeddedAnswerQuestion: EmbeddedAnswerQuestion =>
        val viewModel = Map("title" -> decode(embeddedAnswerQuestion.title),
          "text" -> decodeKeepNewlines(embeddedAnswerQuestion.text),
          "autoShowAnswer" -> autoShowAnswer,
          "hasExplanation" -> embeddedAnswerQuestion.explanationText.nonEmpty,
          "explanation" -> decodeKeepNewlines(embeddedAnswerQuestion.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("EmbeddedAnswerQuestion", viewModel)

      case plainText: PlainText =>
        val viewModel = Map("title" -> decode(plainText.title),
          "text" -> prepareStringKeepNewlines(plainText.text),
          "autoShowAnswer" -> autoShowAnswer,
          "hasExplanation" -> plainText.explanationText.nonEmpty,
          "explanation" -> decodeKeepNewlines(plainText.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("PlainText", viewModel)

      case purePlainText: PurePlainText =>
        val viewModel = Map("title" -> decode(purePlainText.title),
          "text" -> prepareString(purePlainText.text),
          "autoShowAnswer" -> autoShowAnswer,
          "hasExplanation" -> purePlainText.explanationText.nonEmpty,
          "explanation" -> decode(purePlainText.explanationText),
          "contextPath" -> contextPath)
        generateHTMLByQuestionType("PlainText", viewModel)

      case videoDLQuestion: DLVideo =>
        val viewModel = Map("title" -> decode(videoDLQuestion.title),
          "uuid" -> prepareString(videoDLQuestion.uuid),
          "autoShowAnswer" -> autoShowAnswer,
          "groupId" -> videoDLQuestion.groupId,
          "hasExplanation" -> videoDLQuestion.explanationText.nonEmpty,
          "explanation" -> decode(videoDLQuestion.explanationText),
          "contextPath" -> contextPath)

        generateHTMLByQuestionType("DLVideo", viewModel)

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
