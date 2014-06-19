package com.arcusys.learn.quiz.service

import com.arcusys.learn.quiz.model.Quiz
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.service.util.{ AntiSamyHelper, SessionHandler }

class QuizService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  var elements = (1 to 29)
    .map(i => new Quiz(i, "title" + i, "simple description", "welcome!", "good luck", Some(1), "/learn-portlet/images/certificate-01.png"))

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

  val jsonModel2 = new JsonModelBuilder[Quiz](quiz =>
    Map("id" -> quiz.id,
      "description" -> quiz.description,
      "title" -> quiz.title,
      "welcomePageContent" -> quiz.welcomePageContent,
      "finalPageContent" -> quiz.finalPageContent,
      "questionCount" -> quizQuestionStorage.getCount(quiz.id),
      "courseID" -> quiz.courseID,
      "logo" -> quiz.logo)
  )

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  get("/") {
    requireTeacherPermissions()

    val sortBy = parameter("sortBy").required
    val namePattern = parameter("namePattern").required
    val itemsOnPage = parameter("itemsOnPage").intRequired
    val currentPage = parameter("currentPage").intRequired

    //jsonModel(quizStorage.getAll)
    val courseID = parameter("courseID").intOption(-1)

    //Stubbed
    //    jsonModel(quizStorage.getByCourseID(courseID))
    //===

    val filtered = elements
      .filter(_.title.contains(namePattern))
      .sortWith((a, b) => sortBy match {
        case "title(asc)"  => a.title < b.title
        case "title(desc)" => a.title > b.title
        case "id"          => a.id < b.id
        case _             => true
      })

    val pageElements = filtered
      .drop((currentPage - 1) * itemsOnPage)
      .take(itemsOnPage)

    json(Map("elements" -> pageElements, "totalElements" -> filtered.size)).get
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
    //    val welcomePageContent = AntiSamyHelper.sanitize(parameter("welcomePageContent").required)
    //    val finalPageContent = AntiSamyHelper.sanitize(parameter("finalPageContent").required)
    val courseID = parameter("courseID").intOption(-1)
    val logo = AntiSamyHelper.sanitize(parameter("logo").required)
    //    Stubbed
    //    val quizId = quizStorage.createAndGetID(new Quiz(0, title, description, welcomePageContent, finalPageContent, courseID))
    //    jsonModel(quizStorage.getByID(quizId).get)
    //    =======
    val nextId = elements.map(_.id).max + 1

    val newQuiz = new Quiz(nextId, title, description, "", "", courseID, logo)
    elements :+= newQuiz
    jsonModel2(newQuiz)
  }

  post("/update/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    val title = AntiSamyHelper.sanitize(parameter("title").required)
    val description = AntiSamyHelper.sanitize(parameter("description").required)
    val welcomePageContent = AntiSamyHelper.sanitize(parameter("welcomePageContent").required)
    val finalPageContent = AntiSamyHelper.sanitize(parameter("finalPageContent").required)
    val logo = AntiSamyHelper.sanitize(parameter("logo").required)

    val quiz = new Quiz(id, title, description, welcomePageContent, finalPageContent, None, logo)
    elements = elements.filterNot(_.id == id)
    elements :+= quiz

    jsonModel2(quiz)
  }

  post("/delete/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    elements = elements.filterNot(_.id == id)
  }

  post("/clone/:id") {
    requireTeacherPermissions()
    val id = parameter("id").intRequired

    val nextId = elements.map(_.id).max + 1
    elements :+= elements.find(_.id == id).map(_.copy(id = nextId)).get
  }

  get("/fullContent/:id") {
    val id = parameter("id").intRequired
    //    element = elements.find(_.id == id).get

    json(List(
      Map("type" -> "question",
        "title" -> "This is question!"
      ),
      Map("type" -> "category",
        "title" -> "This is GREAT category!",
        "children" -> List(
          Map("type" -> "question",
            "title" -> "Simple numeric")
        )
      ),
      Map("type" -> "question",
        "title" -> "And this one is awesome!"
      ),
      Map("type" -> "category",
        "title" -> "category1",
        "children" -> List(
          Map("type" -> "question",
            "title" -> "Simple numeric"
          ),
          Map("type" -> "question",
            "title" -> "Simple question"
          ),
          Map("type" -> "question",
            "title" -> "And this one is awesome!"
          )
        )
      )
    )).get
  }
}