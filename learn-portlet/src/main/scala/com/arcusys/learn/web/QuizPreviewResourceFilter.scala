package com.arcusys.learn.web

import com.arcusys.scorm.generator.util.ResourceHelpers
import com.arcusys.scorm.generator.file.html.QuestionViewGenerator
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.scorm.util.FileSystemUtil
import com.arcusys.learn.quiz.model.{PlainTextQuizQuestion, ExternalQuizQuestion, QuestionBankQuizQuestion}
import com.arcusys.learn.questionbank.model.PlainText

class QuizPreviewResourceFilter(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  get("/*.*") {
    val filename = multiParams("splat").mkString(".")
    val extension = multiParams("splat").last
    contentType = extension match {
      case "css" => "text/css"
      case "js" => "application/javascript"
      case _ => FileSystemUtil.getMimeType(filename)
    }
    val input = ResourceHelpers.getCommonResourceByName(filename)
    org.scalatra.util.io.copy(input, response.getOutputStream)
    input.close()
  }

  before("/preview") {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
    contentType = "text/html"
  }

  get("/preview") {
    val id = params("id").toInt
    val context = params("context")
    val gen = new QuestionViewGenerator(isPreview = true)
    val quizQuestion = quizQuestionStorage.getByID(id).get
    quizQuestion match {
      case question: QuestionBankQuizQuestion => gen.getHTMLByQuestionId(question.question, context)
        // interpret as usual plain text
      case plain: PlainTextQuizQuestion => gen.getHTMLByQuestionId(new PlainText(plain.id, plain.categoryID, plain.title.getOrElse(""), plain.text, plain.categoryID), context)
      case external: ExternalQuizQuestion => redirect(external.url)
    }
  }
}
