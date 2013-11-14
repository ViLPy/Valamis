package com.arcusys.learn.quiz.service

import com.arcusys.learn.quiz.model.Quiz
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.service.util.{AntiSamyHelper, SessionHandler}

class QuizService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  val jsonModel = new JsonModelBuilder[Quiz](quiz =>
    Map("id" -> quiz.id,
      "description" -> quiz.description,
      "title" -> quiz.title,
      "welcomePageContent" -> quiz.welcomePageContent,
      "finalPageContent" -> quiz.finalPageContent,
      "questionCount" -> quizQuestionStorage.getCount(quiz.id),
      "courseID" -> quiz.courseID)
  )

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  get("/") {
    requireTeacherPermissions()

    //jsonModel(quizStorage.getAll)
    val courseID = parameter("courseID").intOption(-1)
    jsonModel(quizStorage.getByCourseID(courseID))
  }

  get("/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    jsonModel(quizStorage.getByID(id))
  }

  post("/") {
    requireTeacherPermissions()

    val title = AntiSamyHelper.sanitize(parameter("title").required)
    val description = AntiSamyHelper.sanitize(parameter("description").required)
    val welcomePageContent = AntiSamyHelper.sanitize(parameter("welcomePageContent").required)
    val finalPageContent = AntiSamyHelper.sanitize(parameter("finalPageContent").required)
    val courseID = parameter("courseID").intOption(-1)
    val quizId = quizStorage.createAndGetID(new Quiz(0, title, description, welcomePageContent, finalPageContent, courseID))
    jsonModel(quizStorage.getByID(quizId).get)
  }

  post("/update/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    val title = AntiSamyHelper.sanitize(parameter("title").required)
    val description = AntiSamyHelper.sanitize(parameter("description").required)
    val welcomePageContent = AntiSamyHelper.sanitize(parameter("welcomePageContent").required)
    val finalPageContent = AntiSamyHelper.sanitize(parameter("finalPageContent").required)
    val quiz = new Quiz(id, title, description, welcomePageContent, finalPageContent, None)
    quizStorage.modify(quiz)
    jsonModel(quiz)
  }

  post("/delete/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    quizStorage.delete(id)
  }
}