package com.arcusys.learn.questionbank.service

import com.arcusys.learn.questionbank.model._
import com.arcusys.scorm.util._
import com.arcusys.scala.json.Json._
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.service.util.{AntiSamyHelper, SessionHandler}

class QuestionService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  get("/id/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    json(QuestionSerializer.buildItemMap(questionStorage.getByID(id).get))
  }

  get("/children/:id") {
    requireTeacherPermissions()

    val categoryID = parameter("id").intOption(-1)
    val courseID = parameter("courseID").intOption(-1)
    json(QuestionSerializer.buildOutputJSON(questionStorage.getByCategory(categoryID, courseID)))
  }

  post("/") {
    requireTeacherPermissions()

    val questionType = parameter("questionType").intRequired
    val categoryID = parameter("categoryID").intOption(-1)
    val title = AntiSamyHelper.sanitize(parameter("title").required)
    val text = AntiSamyHelper.sanitize(parameter("text").withDefault(""))
    val explanationText = AntiSamyHelper.sanitize(parameter("explanationText").withDefault(""))
    val forceCorrectCount = parameter("forceCorrectCount").booleanRequired
    val isCaseSensitive = parameter("isCaseSensitive").booleanRequired
    val courseID = parameter("courseID").intOption(-1)
    val entity = questionType match {
      case 0 => new ChoiceQuestion(0, categoryID, title, text, explanationText, Nil, forceCorrectCount, courseID)
      case 1 => new TextQuestion(0, categoryID, title, text, explanationText, Nil, isCaseSensitive, courseID)
      case 2 => new NumericQuestion(0, categoryID, title, text, explanationText, Nil, courseID)
      case 3 => new PositioningQuestion(0, categoryID, title, text, explanationText, Nil, forceCorrectCount, courseID)
      case 4 => new MatchingQuestion(0, categoryID, title, text, explanationText, Nil, courseID)
      case 5 => new EssayQuestion(0, categoryID, title, text, explanationText, courseID)
      case 6 => new EmbeddedAnswerQuestion(0, categoryID, title, text, explanationText, courseID)
      case 7 => new CategorizationQuestion(0, categoryID, title, text, explanationText, Nil, courseID)
      case 8 => new PlainText(0, categoryID, title, text, courseID)
      case _ => halt(405, "Service: Oops! Can't create question")
    }
    json(QuestionSerializer.buildItemMap(questionStorage.getByID(questionStorage.createAndGetID(entity)).get))
  }

  post("/update/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    val categoryId = questionStorage.getByID(id).get.categoryID
    val questionType = parameter("questionType").intRequired
    val title = AntiSamyHelper.sanitize(parameter("title").required)
    val text = AntiSamyHelper.sanitize(parameter("text").required)
    val explanationText = AntiSamyHelper.sanitize(parameter("explanationText").required)
    val forceCorrectCount = parameter("forceCorrectCount").booleanRequired
    val isCaseSensitive = parameter("isCaseSensitive").booleanRequired
    val courseID = parameter("courseID").intOption(-1)
    val answersMap = toObject(parameter("answers").withDefault("[]")).asInstanceOf[List[Map[String, Any]]]
    val entity = questionType match {
      case 0 => new ChoiceQuestion(id, categoryId, title, text, explanationText, answersMap.map(parseChoiceAnswer(_)), forceCorrectCount, courseID)
      case 1 => new TextQuestion(id, categoryId, title, text, explanationText, answersMap.map(parseTextAnswer(_)), isCaseSensitive, courseID)
      case 2 => new NumericQuestion(id, categoryId, title, text, explanationText, answersMap.map(parseNumericAnswer(_)), courseID)
      case 3 => new PositioningQuestion(id, categoryId, title, text, explanationText, answersMap.map(parsePositioningAnswer(_)), forceCorrectCount,courseID)
      case 4 => new MatchingQuestion(id, categoryId, title, text, explanationText, answersMap.map(parseMatchingAnswer(_)),courseID)
      case 5 => new EssayQuestion(id, categoryId, title, text, explanationText, courseID)
      case 6 => new EmbeddedAnswerQuestion(id, categoryId, title, text, explanationText, courseID)
      case 7 => new CategorizationQuestion(id, categoryId, title, text, explanationText, answersMap.map(parseCategorizationAnswer(_)), courseID)
      case 8 => new PlainText(id, categoryId, title, text, courseID)
      case _ => halt(405, "Service: Oops! Can't update question")
    }
    questionStorage.modify(entity)
    json(QuestionSerializer.buildItemMap(entity))
  }

  post("/move/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    val dndMode = parameter("dndMode").required
    val targetID = parameter("targetId").intOption(-1)
    val itemType = parameter("itemType").required

    val moveAfterTarget = dndMode == "after"

    val siblingID = if (dndMode == "last" || (dndMode == "after" && itemType == "folder")) None
    else targetID

    val parentID = if (targetID != None && dndMode == "last") targetID
    else if (targetID != None && (dndMode == "after" && itemType == "folder")) questionCategoryStorage.getByID(targetID.get).getOrElse(halt(404, "Can't find category")).parentID
    else if (siblingID != None) questionStorage.getByID(targetID.get).getOrElse(halt(404, "Can't find category")).categoryID
    else None

    questionStorage.move(id, parentID, siblingID, moveAfterTarget)
    json(QuestionSerializer.buildItemMap(questionStorage.getByID(id).get))

  }
  post("/delete/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    questionStorage.delete(id)
  }

  private def parseChoiceAnswer(data: Map[String, Any]) = new ChoiceAnswer(0, data.getOrElse("answerText", "").toString, data.getOrElse("isCorrect", "false").toString.toBoolean)

  private def parseTextAnswer(data: Map[String, Any]) = new TextAnswer(0, data.getOrElse("answerText", "").toString)

  private def parseNumericAnswer(data: Map[String, Any]) = {
    def getBigDecimal(value:String) = try {
      BigDecimal(value)
    } catch {
      case _ => BigDecimal("0")
    }

    new NumericAnswer(0, getBigDecimal(data.getOrElse("rangeFrom", 0).toString), getBigDecimal(data.getOrElse("rangeTo", 0).toString))
  }

  private def parsePositioningAnswer(data: Map[String, Any]) = new PositioningAnswer(0, data.getOrElse("answerText", "").toString, data.getOrElse("isCorrect", "false").toString.toBoolean)

  private def parseMatchingAnswer(data: Map[String, Any]) = new MatchingAnswer(0, data.getOrElse("answerText", "").toString, data.get("matchingText").asInstanceOf[Option[String]])

  private def parseCategorizationAnswer(data: Map[String, Any]) = new CategorizationAnswer(0, data.getOrElse("answerText", "").toString, data.get("matchingText").asInstanceOf[Option[String]])
}
