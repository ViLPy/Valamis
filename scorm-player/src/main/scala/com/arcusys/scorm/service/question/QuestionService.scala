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
    val position = if(questions.size>0)questions.map(question=>question.position).max + 1 else 0
    val optionCategoryID = if(categoryID < 0) { None } else { Some(categoryID) }
    val entity = questionType match {
      case 0 => ChoiceQuestion(0, optionCategoryID, title, text,explanationText, Seq[ChoiceAnswer](), forceCorrectCount,position)
      case 1 => ShortAnswerQuestion(0, optionCategoryID, title, text,explanationText, Seq[ShortAnswer](), isCaseSensitive,position)
      case 2 => NumericQuestion(0, optionCategoryID, title, text,explanationText, Seq[NumericAnswer](),position)
      case 3 => PositioningQuestion(0, optionCategoryID, title, text,explanationText, Seq[PositioningAnswer](),forceCorrectCount,position)
      case 4 => MatchingQuestion(0, optionCategoryID, title, text,explanationText, Seq[MatchingAnswer](),position)
      case 5 => EssayQuestion(0, optionCategoryID, title, text,explanationText, Seq[EssayAnswer](),position)
      case 6 => EmbeddedAnswerQuestion(0, optionCategoryID, title, text,explanationText, Seq[EmbeddedAnswer](),position)
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
    
    val position = getQuestionStorage.getByID(id).getOrElse(halt(404, "Can't find queston")).position
    
    val entity = questionType match {
      case 0 => ChoiceQuestion(id, categoryId, title, text,explanationText, Seq[ChoiceAnswer](), forceCorrectCount,position)
      case 1 => ShortAnswerQuestion(id, categoryId, title, text,explanationText, Seq[ShortAnswer](), isCaseSensitive,position)
      case 2 => NumericQuestion(id, categoryId, title, text,explanationText, Seq[NumericAnswer](),position)
      case 3 => PositioningQuestion(id, categoryId, title, text,explanationText, Seq[PositioningAnswer](),forceCorrectCount,position)
      case 4 => MatchingQuestion(id, categoryId, title, text,explanationText, Seq[MatchingAnswer](),position)
      case 5 => EssayQuestion(id, categoryId, title, text,explanationText, Seq[EssayAnswer](),position)
      case 6 => EmbeddedAnswerQuestion(id, categoryId, title, text,explanationText, Seq[EmbeddedAnswer](),position)
      case _ => halt(405, "Service: Oops! Can't update question")
    }
    setAnswers(id, questionType, answers)
    
    json(QuestionSerializer.buildItemMap(getQuestionStorage.modifyQuestion(entity)))
  }
  
  post("/move") {
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    val categoryId = getQuestionStorage.getByID(id).get.categoryID
    val questionType = params.getOrElse("type", halt(405, "Question type is not specified")).toInt
    val dndMode = params.getOrElse("dndMode", halt(405, ""))
    val targetId = params.getOrElse("targetId", halt(405, "-2")).toInt
    val itemType = params.getOrElse("itemType", halt(405, ""))
    
    val position = if(dndMode.equals("last"))
    {
      val checkTargetId = if (targetId == -1) { None } else {Some(targetId)}
      val questions = getQuestionStorage.getByCategory(checkTargetId)
      if(questions.size>0)questions.map(question=>question.position).max + 1 else 0
    }
    else if(dndMode.equals("after")){
      val (pos,questions) = if(itemType.equals("entity")){
        val targetQuestion = getQuestionStorage.getByID(targetId).get
        (targetQuestion.position+ 1,getQuestionStorage.getByCategory(targetQuestion.categoryID))
      }else {
        
        (0,getQuestionStorage.getByCategory(getQuestionCategoryStorage.getByID(targetId).get.parentID))
      }
      questions.foreach(question=>{
          if(question.position>=pos){
            updatePosition(question,question.position+1)
          }
        })
      pos
    }else if(dndMode.equals("before"))    {
      val (pos,questions) = if(itemType.equals("entity")){
        val targetQuestion = getQuestionStorage.getByID(targetId).get
        (targetQuestion.position,getQuestionStorage.getByCategory(targetQuestion.categoryID))
      }else {
        (0,getQuestionStorage.getByCategory(getQuestionCategoryStorage.getByID(targetId).get.parentID))
      }
      questions.foreach(question=>{
          if(question.position>=pos){
            updatePosition(question,question.position+1)
          }
        })
      pos
    }else{
      getQuestionStorage.getByID(id).getOrElse(halt(404, "Can't find queston")).position
    }
    val oldQuestion = getQuestionStorage.getByID(id).getOrElse(halt(404, "Can't find queston"))
    if (QuestionSerializer.getTypeIDByEntity(oldQuestion) != questionType) {
      for (answer<-oldQuestion.answers) getAnswerStorage.delete(answer.id)
    }
    val optionCategoryID = if(targetId>(-2)){
      if(itemType.equals("entity"))(getQuestionStorage.getByID(targetId).get.categoryID) else {
        if(dndMode.equals("last")){
          Some(targetId)
        }
        else{
          getQuestionCategoryStorage.getByID(targetId).get.parentID
        }
      }
    }
    else{
      categoryId
    }
      
    val question = getQuestionStorage.getByID(id).getOrElse(halt(404, "Can't find queston")) match {
      case c: ChoiceQuestion => c.copy(categoryID=optionCategoryID, position=position)
      case sa: ShortAnswerQuestion => sa.copy(categoryID=optionCategoryID, position=position)
      case n: NumericQuestion => n.copy(categoryID=optionCategoryID, position=position)
      case p: PositioningQuestion => p.copy(categoryID=optionCategoryID, position=position)
      case m: MatchingQuestion => m.copy(categoryID=optionCategoryID, position=position)
      case e: EssayQuestion => e.copy(categoryID=optionCategoryID, position=position)
      case ea: EmbeddedAnswerQuestion => ea.copy(categoryID=optionCategoryID, position=position)
      case _ => halt(405, "Service: Oops! Can't update question")
    }
    
    json(QuestionSerializer.buildItemMap(getQuestionStorage.modifyQuestion(question)))
  }
  
  private def updatePosition(entity:Question[Answer],pos:Int){
    val toStore=entity match {
      case e:ChoiceQuestion => e.copy(position=pos)
      case e:ShortAnswerQuestion => e.copy(position=pos)
      case e:NumericQuestion => e.copy(position=pos)
      case e:PositioningQuestion => e.copy(position=pos)
      case e:MatchingQuestion => e.copy(position=pos)
      case e:EssayQuestion => e.copy(position=pos)
      case e:EmbeddedAnswerQuestion => e.copy(position=pos)
      case _ => null
    }
    getQuestionStorage.modifyQuestion(toStore)
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
