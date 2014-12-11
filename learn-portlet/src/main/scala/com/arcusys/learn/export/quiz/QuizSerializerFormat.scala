package com.arcusys.learn.export.quiz

import org.json4s.JsonAST._
import org.json4s.jackson.JsonMethods._
import org.json4s.{ CustomSerializer, DefaultFormats, Extraction }

class QuizContentSerializer extends CustomSerializer[QuizContentExport](implicit format => ({
  case jObject: JObject =>
    jObject.\("contentType").extractOpt[String] match {
      case Some("category") | None          => jObject.extract[QuizCategoryExport]
      case Some("questionExternalResource") => jObject.extract[QuizQuestionExternalExport]
      case Some("questionPlainText")        => jObject.extract[QuizQuestionPlainTextExport]
      case Some("question")                 => jObject.extract[QuizQuestionBankExport]
      case Some("questionRevealJS")         => jObject.extract[QuizQuestionRevealJSExport]
      case Some("questionVideo")            => jObject.extract[QuizQuestionVideoExport]
      case Some("questionPDF")              => jObject.extract[QuizQuestionPDFExport]
      case Some("questionPPTX")             => jObject.extract[QuizQuestionPptxExport]
    }
}, {
  case quiz: QuizExportResponse => render(Extraction.decompose(quiz)(DefaultFormats))

}))

class QuizQuestionSerializer extends CustomSerializer[QuizQuestionExport](implicit format => ({
  case jObject: JObject =>
    jObject.\("contentType").extractOpt[String] match {
      case Some("questionExternalResource") => jObject.extract[QuizQuestionExternalExport]
      case Some("questionPlainText")        => jObject.extract[QuizQuestionPlainTextExport]
      case Some("question")                 => jObject.extract[QuizQuestionBankExport]
      case Some("questionRevealJS")         => jObject.extract[QuizQuestionRevealJSExport]
      case Some("questionVideo")            => jObject.extract[QuizQuestionVideoExport]
      case Some("questionPDF")              => jObject.extract[QuizQuestionPDFExport]
      case Some("questionPPTX")             => jObject.extract[QuizQuestionPptxExport]
    }
}, {
  case quiz: QuizExportResponse => render(Extraction.decompose(quiz)(DefaultFormats))

}))

