package com.arcusys.learn.quiz.service

import com.arcusys.learn.quiz.model.QuizQuestion
import com.arcusys.scorm.util.QuestionSerializer
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration

class QuizQuestionService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  val jsonModel = new JsonModelBuilder[QuizQuestion](question =>
    Map(
      "id" -> question.id,
      "categoryID" -> question.categoryID.getOrElse("-1"),
      "question" -> question.question.map(question => QuestionSerializer.buildItemMap(question)),
      "title" -> question.question.map(_.title).getOrElse(question.title),
      "url" -> question.url
    )
  )

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  get("/:id") {
    val id = parameter("id").intRequired
    jsonModel(quizQuestionStorage getByID id)
  }

  get("/children/:quizID/:id") {
    val categoryID = parameter("id").intOption(-1)
    val quizID = parameter("quizID").intRequired
    jsonModel(quizQuestionStorage.getByCategory(quizID, categoryID))
  }

  post("/update/:id") {
    val id = parameter("id").intRequired
    val title = parameter("title").required
    val url = parameter("url").required
    quizQuestionStorage.modifyExternal(id, title, url)
    jsonModel(quizQuestionStorage.getByID(id))
  }

  post("/listIntoCategory/:quizID/:categoryID") {
    val parentID = parameter("categoryID").intOption(-1)
    val questionsIDSet = parameter("questionIDs").required.trim
    val quizID = parameter("quizID").intRequired
    jsonModel(for {
      questionID <- questionsIDSet.split(';').toSeq
      quizQuestionId = quizQuestionStorage.createAndGetID(quizID, parentID, questionID.toInt)
    } yield quizQuestionStorage.getByID(quizQuestionId).get)
  }

  post("/external/:quizID/:categoryID") {
    val parentID = parameter("categoryID").intOption(-1)
    val title = parameter("title").withDefault("External quiz resource")
    val url = parameter("url").required
    val quizID = parameter("quizID").intRequired
    jsonModel(quizQuestionStorage.getByID(quizQuestionStorage.createAndGetID(quizID, parentID, title, url)).get)
  }

  post("/move/:id") {
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
    val id = parameter("id").intRequired
    quizQuestionStorage.delete(id)
  }
}