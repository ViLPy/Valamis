package com.arcusys.learn.export.question

import java.io.File
import com.arcusys.learn.facades._
import com.arcusys.valamis.export.ImportProcessor
import com.arcusys.valamis.questionbank.service.QuestionService
import com.arcusys.valamis.util.JsonSupport
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.json4s.{ DefaultFormats, Formats }

class QuestionImportProcessor(implicit configuration: BindingModule) extends ImportProcessor[QuestionCategoryExport] with Injectable with JsonSupport {

  override implicit def bindingModule: BindingModule = configuration

  private lazy val questionFacade = inject[QuestionFacadeContract]
  private lazy val questionService = inject[QuestionService]

  def importItems(items: List[QuestionCategoryExport], courseId: Long, tempDirectory: File, userId: Long): Unit = {
    items.foreach(qc => {
      val categoryId = if (qc.title == "root") {
        None
      } else {
        Option(questionService.createCategory(qc.title, qc.description, None, Option(courseId.toInt)).id)
      }
      qc.children.map(q =>
        questionFacade.createQuestion(
          categoryId,
          q.questionType,
          q.title,
          q.text,
          q.explanationText,
          q.rightAnswerText.getOrElse(""),
          q.wrongAnswerText.getOrElse(""),
          q.forceCorrectCount,
          q.isCaseSensitive,
          Option(courseId.toInt),
          q.answers.map(_.toAnswerResponse()
        ).toList)
      )
    })
  }
}

