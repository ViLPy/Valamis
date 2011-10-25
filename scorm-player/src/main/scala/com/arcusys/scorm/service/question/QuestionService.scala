package com.arcusys.scorm.service.question

import com.arcusys.scorm.service.StorageFactory._
import org.scalatra.ScalatraServlet
import com.arcusys.scorm.model.quiz._
import com.arcusys.scorm.util._

class QuestionService extends ScalatraServlet
{
  get("/") {
    JSON.toJSON(QuestionSerializer.buildOutputJSON(getQuestionStorage.getAll))
  }
  
  get("/ID/:id"){
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    JSON.toJSON(QuestionSerializer.buildItemMap(getQuestionStorage.getByID(id).get))
  }
  
  get("/Category") {
    val id = params.getOrElse("id", "-1").toInt
    val categoryID = if (id == -1) { None } else {Some(id)}
    JSON.toJSON(QuestionSerializer.buildOutputJSON(getQuestionStorage.getByCategory(categoryID)))
  }
  
  post("/") {
    val questionType = params.getOrElse("type", halt(405, "Type is not specified")).toInt
    val categoryID = params.getOrElse("categoryID", "-1").toInt
    val title = params.getOrElse("title", halt(405, "Title is not specified"))
    val text = params.getOrElse("text", halt(405, "Text is not specified"))
    val isBounded = params.getOrElse("isBounded", halt(405, "'is bound' flag is not specified")).toBoolean
    val isCaseSensitive = params.getOrElse("isCaseSensitive", halt(405, "Case sensitivity is not specified")).toBoolean

    val optionCategoryID = if(categoryID < 0) { None } else { Some(categoryID) }
    val entity = questionType match {
      case 0 => ChoiceQuestion(0, optionCategoryID, title, text, Seq[ChoiceAnswer](), isBounded)
      case 1 => ShortAnswerQuestion(0, optionCategoryID, title, text, Seq[ShortAnswer](), isCaseSensitive)
      case 2 => NumericQuestion(0, optionCategoryID, title, text, Seq[NumericAnswer]())
      case 3 => PositioningQuestion(0, optionCategoryID, title, text, Seq[PositioningAnswer](),isBounded)
      case 4 => MatchingQuestion(0, optionCategoryID, title, text, Seq[MatchingAnswer]())
      case 5 => EssayQuestion(0, optionCategoryID, title, text, Seq[EssayAnswer]())
      case 6 => EmbeddedAnswerQuestion(0, optionCategoryID, title, text, Seq[EmbeddedAnswer]())
      case _ => halt(405, "Service: Oops! Can't create question")
    }
    JSON.toJSON(QuestionSerializer.buildItemMap(getQuestionStorage.createQuestion(entity)._2))
  }
  
  post("/Update") {
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    val questionType = params.getOrElse("type", halt(405, "Question type is not specified")).toInt
    val categoryID = params.getOrElse("categoryID", halt(405, "Category is not specified")).toInt
    val title = params.getOrElse("title", halt(405, "Title is not specified"))
    val text = params.getOrElse("text", halt(405, "Text is not specified"))
    val isBounded = params.getOrElse("isBounded", halt(405, "'is bounded' flag is not specified")).toBoolean
    val isCaseSensitive = params.getOrElse("isCaseSensitive", halt(405, "Case sesitivity is not specified")).toBoolean
    val answers = params.getOrElse("answers", "[]")
    
    val oldQuestion = getQuestionStorage.getByID(id).getOrElse(halt(404, "Can't find queston"))
    if (QuestionSerializer.getTypeIDByEntity(oldQuestion) != questionType) {
      for (answer<-oldQuestion.answers) getAnswerStorage.delete(answer.id)
    }
    
    val optionCategoryID = if(categoryID < 0) { None } else { Some(categoryID) }
    val entity = questionType match {
      case 0 => ChoiceQuestion(id, optionCategoryID, title, text, Seq[ChoiceAnswer](), isBounded)
      case 1 => ShortAnswerQuestion(id, optionCategoryID, title, text, Seq[ShortAnswer](), isCaseSensitive)
      case 2 => NumericQuestion(id, optionCategoryID, title, text, Seq[NumericAnswer]())
      case 3 => PositioningQuestion(id, optionCategoryID, title, text, Seq[PositioningAnswer](),isBounded)
      case 4 => MatchingQuestion(id, optionCategoryID, title, text, Seq[MatchingAnswer]())
      case 5 => EssayQuestion(id, optionCategoryID, title, text, Seq[EssayAnswer]())
      case 6 => EmbeddedAnswerQuestion(id, optionCategoryID, title, text, Seq[EmbeddedAnswer]())
      case _ => halt(405, "Service: Oops! Can't update question")
    }
    setAnswers(id, questionType, answers)
    
    JSON.toJSON(QuestionSerializer.buildItemMap(getQuestionStorage.modifyQuestion(entity)._2))
  }
  
  post("/Delete") {
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    val question = getQuestionStorage.getByID(id).getOrElse(halt(404, "Can't find question with id:" + id))
    for (answer<-question.answers) getAnswerStorage.delete(answer.id)
    getQuestionStorage.delete(id)
  }
  
  def setAnswers(questionID: Int, questionType: Int, answersJSON: String) {

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
                                 data.get("subquestion").asInstanceOf[Option[String]])
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
    val answersRawDataList = JSON.toObject(answersJSON).asInstanceOf[List[Map[String, Any]]]
    val answersSeq = answersRawDataList.map(e=>createAnswer(e)).toSeq

    (0 until answersSeq.length).map(i => getAnswerStorage.create(questionID, i, answersSeq.apply(i)))
  }
}
