package com.arcusys.learn.quiz.service

import com.arcusys.learn.quiz.model.QuizQuestionCategory
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.service.util.{ AntiSamyHelper, SessionHandler }

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

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  get("/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    jsonModel(quizQuestionCategoryStorage.getByID(id))
  }

  get("/children/:quizID/:id") {
    requireTeacherPermissions()

    val parentID = parameter("id").intOption(-1)
    val quizID = parameter("quizID").intRequired
    jsonModel(quizQuestionCategoryStorage.getChildren(quizID, parentID))
  }

  post("/") {
    requireTeacherPermissions()

    val title = AntiSamyHelper.sanitize(parameter("title").required)
    val description = AntiSamyHelper.sanitize(parameter("description").required)
    val quizID = parameter("quizID").intRequired
    val parentID = parameter("parentID").intOption(-1)
    val newQuizCategoryId = quizQuestionCategoryStorage.createAndGetID(new QuizQuestionCategory(0, title, description, quizID, parentID))
    jsonModel(quizQuestionCategoryStorage.getByID(newQuizCategoryId).get)
  }

  post("/update/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    val title = AntiSamyHelper.sanitize(parameter("title").required)
    val description = AntiSamyHelper.sanitize(parameter("description").required)
    quizQuestionCategoryStorage.modify(id, title, description)
    jsonModel(quizQuestionCategoryStorage.getByID(id))
  }

  post("/move/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    val dndMode = parameter("dndMode").required
    val itemType = parameter("itemType").required

    val targetID = parameter("targetId").intOption(-1)

    val moveAfterTarget = dndMode == "after"
    val isEntityTarget = itemType == "entity"

    val siblingID = if (dndMode == "last" || (dndMode == "before" && isEntityTarget)) None
    else targetID

    val parentID = if (siblingID != None) (quizQuestionCategoryStorage getByID siblingID.get getOrElse halt(404, "Can't find category")).parentID
    else {
      if (isEntityTarget)
        quizQuestionStorage.getByID(targetID.get).getOrElse(halt(404, "Can't find question")).categoryID
      else
        targetID
    }

    jsonModel(quizQuestionCategoryStorage.move(id, parentID, siblingID, moveAfterTarget))
  }

  post("/delete") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    quizQuestionCategoryStorage.delete(id)
  }
}