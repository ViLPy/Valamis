package com.arcusys.learn.quiz.service

import com.arcusys.learn.quiz.model._
import com.arcusys.scorm.util.QuestionSerializer
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import java.net.URLEncoder
import com.arcusys.learn.liferay.services.JournalArticleLocalServiceHelper

class QuizQuestionService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  val jsonModel = new JsonModelBuilder[QuizQuestion](question =>
    Map(
      "id" -> question.id,
      "categoryID" -> question.categoryID.getOrElse("-1")
    ) ++ (question match {
        case questionBankQuestion: QuestionBankQuizQuestion =>
          Map(
            "question" -> QuestionSerializer.buildItemMap(questionBankQuestion.question),
            "title" -> questionBankQuestion.question.title,
            "questionType" -> QuizQuestionType.QuestionBank.toString
          )
        case external: ExternalQuizQuestion =>
          Map(
            "url" -> external.url,
            "title" -> question.title,
            "questionType" -> QuizQuestionType.External.toString
          )
        case plain: PlainTextQuizQuestion =>
          Map(
            "text" -> plain.text,
            "title" -> question.title,
            "questionType" -> QuizQuestionType.PlainText.toString
          )
        case reveal: RevealJSQuizQuestion =>
          Map(
            "text" -> reveal.content,
            "title" -> question.title,
            "questionType" -> QuizQuestionType.RevealJS.toString
          )
        case _ => Map()
      })
  )

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  get("/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    jsonModel(quizQuestionStorage getByID id)
  }

  get("/children/:quizID/:id") {
    requireTeacherPermissions()

    val categoryID = parameter("id").intOption(-1)
    val quizID = parameter("quizID").intRequired
    jsonModel(quizQuestionStorage.getByCategory(quizID, categoryID))
  }

  post("/update/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    val title = parameter("title").required
    val url = parameter("url").required
    quizQuestionStorage.modifyExternal(id, title, url)
    jsonModel(quizQuestionStorage.getByID(id))
  }

  post("/listIntoCategory/:quizID/:categoryID") {
    requireTeacherPermissions()

    val parentID = parameter("categoryID").intOption(-1)
    val questionsIDSet = parameter("questionIDs").required.trim
    val quizID = parameter("quizID").intRequired
    jsonModel(for {
      questionID <- questionsIDSet.split(';').toSeq
      quizQuestionId = quizQuestionStorage.createFromQuestionBankAndGetID(quizID, parentID, questionID.toInt)
    } yield quizQuestionStorage.getByID(quizQuestionId).get)
  }

  post("/external/:quizID/:categoryID") {
    requireTeacherPermissions()

    val parentID = parameter("categoryID").intOption(-1)
    val title = parameter("title").withDefault("External quiz resource")
    val url = parameter("url").required
    val quizID = parameter("quizID").intRequired
    jsonModel(quizQuestionStorage.getByID(quizQuestionStorage.createExternalAndGetID(quizID, parentID, title, url)).get)
  }

  post("/fromLiferay/:quizID/:categoryID") {
    requireTeacherPermissions()

    val quizID = parameter("quizID").intRequired
    val parentID = parameter("categoryID").intOption(-1)
    val groupID = parameter("groupID").longRequired
    val articleID = parameter("articleID").required
    val articleLanguage = parameter("language").required
    val article = JournalArticleLocalServiceHelper.getArticle(groupID, articleID)
    val title = article.getTitle(articleLanguage)

    val text = parameter("text").required
    val preparedText = URLEncoder.encode(text.replaceAll("\\+", "%2B"), "UTF-8").replaceAll("\\+", "%20") //.replaceAll("\n","").replaceAll("\t","")).replaceAll("\\\\\"","\\\\\\\"")
    jsonModel(quizQuestionStorage.getByID(quizQuestionStorage.createPlainAndGetID(quizID, parentID, title, preparedText)).get)
  }

  post("/move/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    val dndMode = parameter("dndMode").required
    val targetID = parameter("targetId").intOption(-1)
    val itemType = parameter("itemType").required

    val isMoveAfterTarget = dndMode == "after"

    val siblingID = if (dndMode == "last" || (dndMode == "after" && itemType == "folder")) None
    else targetID

    val parentID = if (targetID != None && dndMode == "last") targetID
    else if (targetID != None && (dndMode == "after" && itemType == "folder")) quizQuestionCategoryStorage.getByID(targetID.get).getOrElse(halt(404, "Can't find category")).parentID
    else if (siblingID != None) quizQuestionStorage.getByID(targetID.get).getOrElse(halt(404, "Can't find category")).categoryID
    else None

    jsonModel(quizQuestionStorage.move(id, parentID, siblingID, isMoveAfterTarget))
  }

  post("/delete/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    quizQuestionStorage.delete(id)
  }
}