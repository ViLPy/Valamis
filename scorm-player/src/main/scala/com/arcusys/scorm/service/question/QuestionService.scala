package com.arcusys.scorm.service.question

import com.arcusys.scorm.service.StorageFactory._
import org.scalatra.ScalatraServlet
import com.arcusys.scala.scalatra.json.JsonSupport
import com.arcusys.scorm.model.quiz._
import com.arcusys.scorm.util._
import com.arcusys.scala.json.Json._

class QuestionService extends ScalatraServlet with JsonSupport
{
  get("/") {
    json(QuestionSerializer.buildOutputJSON(getQuestionStorage.getAll))
  }
  
  get("/id/:id"){
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    json(QuestionSerializer.buildItemMap(getQuestionStorage.getByID(id).get))
  }
  
  get("/category") {
    val id = params.getOrElse("id", "-1").toInt
    val categoryID = if (id == -1) { None } else {Some(id)}
    json(QuestionSerializer.buildOutputJSON(getQuestionStorage.getByCategory(categoryID)))
  }
  
  post("/") {
    val questionType = params.getOrElse("type", halt(405, "Type is not specified")).toInt
    val categoryID = params.getOrElse("categoryID", "-1").toInt
    val checkCategoryID = if (categoryID == -1) { None } else {Some(categoryID)}
    val title = params.getOrElse("title", halt(405, "Title is not specified"))
    val text = params.getOrElse("text", "")
    val explanationText = params.getOrElse("explanationText", "")
    val forceCorrectCount = params.getOrElse("forceCorrectCount", halt(405, "'forceCorrectCount' flag is not specified")).toBoolean
    val isCaseSensitive = params.getOrElse("isCaseSensitive", halt(405, "Case sensitivity is not specified")).toBoolean
    val questions = getQuestionStorage.getByCategory(checkCategoryID)
    val optionCategoryID = if(categoryID < 0) { None } else { Some(categoryID) }
    val entity = questionType match {
      case 0 => ChoiceQuestion(0, optionCategoryID, title, text,explanationText, Seq[ChoiceAnswer](), forceCorrectCount)
      case 1 => ShortAnswerQuestion(0, optionCategoryID, title, text,explanationText, Seq[ShortAnswer](), isCaseSensitive)
      case 2 => NumericQuestion(0, optionCategoryID, title, text,explanationText, Seq[NumericAnswer]())
      case 3 => PositioningQuestion(0, optionCategoryID, title, text,explanationText, Seq[PositioningAnswer](),forceCorrectCount)
      case 4 => MatchingQuestion(0, optionCategoryID, title, text,explanationText, Seq[MatchingAnswer]())
      case 5 => EssayQuestion(0, optionCategoryID, title, text,explanationText, Seq[EssayAnswer]())
      case 6 => EmbeddedAnswerQuestion(0, optionCategoryID, title, text,explanationText, Seq[EmbeddedAnswer]())
      case _ => halt(405, "Service: Oops! Can't create question")
    }
    json(QuestionSerializer.buildItemMap(getQuestionStorage.createQuestion(entity)))
  }
  
  post("/update") {
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    val categoryId = getQuestionStorage.getByID(id).get.categoryID
    val questionType = params.getOrElse("type", halt(405, "Question type is not specified")).toInt
    val title = params.getOrElse("title", halt(405, "Title is not specified"))
    val text = params.getOrElse("text", halt(405, "Text is not specified"))
    val explanationText = params.getOrElse("explanationText", halt(405, "Text is not specified"))
    val forceCorrectCount = params.getOrElse("forceCorrectCount", halt(405, "'forceCorrectCount' flag is not specified")).toBoolean
    val isCaseSensitive = params.getOrElse("isCaseSensitive", halt(405, "Case sesitivity is not specified")).toBoolean
    val answers = params.getOrElse("answers", "[]")
    
    val entity = questionType match {
      case 0 => ChoiceQuestion(id, categoryId, title, text,explanationText, Seq[ChoiceAnswer](), forceCorrectCount)
      case 1 => ShortAnswerQuestion(id, categoryId, title, text,explanationText, Seq[ShortAnswer](), isCaseSensitive)
      case 2 => NumericQuestion(id, categoryId, title, text,explanationText, Seq[NumericAnswer]())
      case 3 => PositioningQuestion(id, categoryId, title, text,explanationText, Seq[PositioningAnswer](),forceCorrectCount)
      case 4 => MatchingQuestion(id, categoryId, title, text,explanationText, Seq[MatchingAnswer]())
      case 5 => EssayQuestion(id, categoryId, title, text,explanationText, Seq[EssayAnswer]())
      case 6 => EmbeddedAnswerQuestion(id, categoryId, title, text,explanationText, Seq[EmbeddedAnswer]())
      case _ => halt(405, "Service: Oops! Can't update question")
    }
    setAnswers(id, questionType, answers)
    
    json(QuestionSerializer.buildItemMap(getQuestionStorage.modifyQuestion(entity)))
  }
  
  post("/move") {
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    val dndMode = params.getOrElse("dndMode", halt(405, ""))
    val targetId = params.getOrElse("targetId", halt(405, "-2")).toInt
    val itemType = params.getOrElse("itemType", halt(405, ""))
    
    val question = getQuestionStorage.getByID(id).getOrElse(halt(404, "Can't find category"))
    val isMoveToCategory = (dndMode.equals("last") || (dndMode.equals("after") && itemType.equals("folder")))
    val isMoveAfterTarget = dndMode.equals("after")
    
    val parentID = if (targetId != -1 && dndMode.equals("last")) Some(targetId)
    else if (targetId != -1 && (dndMode.equals("after") && itemType.equals("folder"))) getQuestionCategoryStorage.getByID(targetId).getOrElse(halt(404, "Can't find category")).parentID
    else if (!isMoveToCategory) getQuestionStorage.getByID(targetId).getOrElse(halt(404, "Can't find category")).categoryID
    else None
    
    
    json(QuestionSerializer.buildItemMap(getQuestionStorage.move(question, isMoveToCategory, isMoveAfterTarget, targetId, parentID)))
       
  }
  
  post("/delete") {
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    val question = getQuestionStorage.getByID(id).getOrElse(halt(404, "Can't find question with id:" + id))
    for (answer<-question.answers) getAnswerStorage.delete(answer.id)
    getQuestionStorage.delete(id)
  }
  
  private def setAnswers(questionID: Int, questionType: Int, answersJSON: String) {

    def createAnswer(data: Map[String, Any]) = {
      questionType match {
        case 0 => ChoiceAnswer(0, 
                               data.getOrElse("text", "").toString, 
                               data.getOrElse("isCorrect", "false").toString.toBoolean)
        case 1 => ShortAnswer(0, 
                              data.getOrElse("text", "").toString)
        case 2 => NumericAnswer(0, 
                                (BigDecimal.apply(data.getOrElse("from",0).toString),
                                 BigDecimal.apply(data.getOrElse("to",0).toString)))
        case 3 => PositioningAnswer(0, 
                                    data.getOrElse("text", "").toString, 
                                    data.getOrElse("isCorrect", "false").toString.toBoolean)
        case 4 => MatchingAnswer(0, 
                                 data.getOrElse("text", "").toString, 
                                 data.get("matchingText").asInstanceOf[Option[String]])
        case 5 => EssayAnswer(0)
        case 6 => EmbeddedAnswer(0)
        case _ => halt(405, "Service: Oops! Can't create answer")
      }
    }
    
    // delete all answers from question
    val question = getQuestionStorage.getByID(questionID).get
    for (answer <- question.answers) {
      getAnswerStorage.delete(answer.id)
    }
    
    // and add new answers
    val answersRawDataList = toObject(answersJSON).asInstanceOf[List[Map[String, Any]]]
    val answersSeq = answersRawDataList.map(e=>createAnswer(e)).toSeq

    (0 until answersSeq.length).map(i => getAnswerStorage.create(questionID, i, answersSeq.apply(i)))
  }
}
