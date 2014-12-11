package com.arcusys.learn.export.question

import com.arcusys.learn.bl.export.ImportProcessor
import com.arcusys.learn.facades._
import com.arcusys.learn.models.AnswerResponse
import com.arcusys.learn.util.JsonSupport
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import org.json4s.{ DefaultFormats, Formats }

class QuestionImportProcessor(implicit configuration: BindingModule) extends ImportProcessor[QuestionCategoryExport] with Injectable with JsonSupport {

  override implicit def bindingModule: BindingModule = configuration

  private lazy val questionFacade = inject[QuestionFacadeContract]
  private lazy val categoryFacade = inject[CategoryFacadeContract]

  def importItemsImpl(raw: String, courseID: Int, exportTempDirectory: String): Unit = {
    implicit val fs: Formats = DefaultFormats
    val questionCategories = parseJson[List[QuestionCategoryExport]](raw).get //OrElse(List())//throw new BadRequestException("Cannot deserialize lessons"))
    questionCategories.foreach(qc => {
      val categoryID = if (qc.title == "root") {
        None
      } else {
        Option(categoryFacade.create(qc.title, qc.description, None, Option(courseID)).id)
      }
      qc.children.map(q => {
        val res = questionFacade.createQuestion(categoryID, q.questionType, q.title, q.text, q.explanationText, q.forceCorrectCount, q.isCaseSensitive, Option(courseID))
        questionFacade.updateQuestion(res.id, categoryID, q.questionType, q.title, q.text, q.explanationText, q.forceCorrectCount, q.isCaseSensitive, Option(courseID),
          q.answers.map(_.toAnswerResponse()).toList)
      })
    })
  }
}

