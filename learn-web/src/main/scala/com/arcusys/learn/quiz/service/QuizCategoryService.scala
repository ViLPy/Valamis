package com.arcusys.learn.quiz.service

import com.arcusys.learn.quiz.model.QuizQuestionCategory
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.web.ServletBase

class QuizCategoryService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  val jsonModel = new JsonModelBuilder[QuizQuestionCategory](quizCategory =>
    Map(
      "id" -> quizCategory.id,
      "description" -> quizCategory.description,
      "title" -> quizCategory.title,
      "quizID" -> quizCategory.quizID,
      "parentID" -> quizCategory.parentID.getOrElse("-1"),
      "type" -> "folder"
    )
  )
  get("/:id") {
    val id = parameter("id").intRequired
    jsonModel(quizQuestionCategoryStorage.getByID(id))
  }

  get("/children/:quizID/:id") {
    val parentID = parameter("id").intOption(-1)
    val quizID = parameter("quizID").intRequired
    jsonModel(quizQuestionCategoryStorage.getChildren(quizID, parentID))
  }

  post("/") {
    val title = parameter("title").required
    val description = parameter("description").required
    val quizID = parameter("quizID").intRequired
    val parentID = parameter("parentID").intOption(-1)
    val newQuizCategoryId = quizQuestionCategoryStorage.createAndGetID(new QuizQuestionCategory(0, title, description, quizID, parentID))
    jsonModel(quizQuestionCategoryStorage.getByID(newQuizCategoryId).get)
  }

  post("/update/:id") {
    val id = parameter("id").intRequired
    val title = parameter("title").required
    val description = parameter("description").required
    val quizID = parameter("quizID").intRequired
    val parentID = parameter("parentID").intOption(-1)
    //TODO: guess parentID should not ever be changed here
    quizQuestionCategoryStorage.modify(id, title, description)
    jsonModel(quizQuestionCategoryStorage.getByID(id))
  }

  post("/move/:id") {
    val id = parameter("id").intRequired
    val dndMode = parameter("dndMode").required
    val itemType = parameter("itemType").required

    val targetID = parameter("targetId").intOption(-1)

    val moveAfterTarget = dndMode == "after"

    val siblingID = if (dndMode == "last" || (dndMode == "before" && itemType == "entity")) None
    else targetID

    val parentID = if (siblingID != None) (quizQuestionCategoryStorage getByID siblingID.get getOrElse halt(404, "Can't find category")).parentID
    else targetID

    jsonModel(quizQuestionCategoryStorage.move(id, parentID, siblingID, moveAfterTarget))
  }

  post("/delete") {
    val id = parameter("id").intRequired
    quizQuestionCategoryStorage.delete(id)
  }
}