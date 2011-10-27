package com.arcusys.scorm.service.question

import com.arcusys.scorm.service.StorageFactory._
import org.scalatra.ScalatraServlet
import com.arcusys.scorm.model.quiz._
import com.arcusys.scorm.util._

class CategoryService extends ScalatraServlet
{
  get("/") {
    JSON.toJSON(buildOutputCategoriesJSON(getQuestionCategoryStorage.getAll))
  }
  
  get("/Children") {
    val id = params.getOrElse("id", halt(405, "-1")).toInt
    val parentID = if (id == -1) { None } else {Some(id)}
    JSON.toJSON(buildOutputCategoriesJSON(getQuestionCategoryStorage.getChildren(parentID)) ++ QuestionSerializer.buildOutputJSON(getQuestionStorage.getByCategory(parentID)))
  }
  
  post("/") {
    val title = params.getOrElse("title", halt(405, "Title is not specified"))
    val description = params.getOrElse("description", halt(405, "Description is not specified"))
    val parentID = params.getOrElse("parentID", "-1").toInt
    val isFieldOfKnowledge = params.getOrElse("isFieldOfKnowledge", "false").toBoolean

    val optionParentID = if(parentID < 0) { None } else { Some(parentID) }
    JSON.toJSON(buildOutputCategoryJSON(getQuestionCategoryStorage.getByID(getQuestionCategoryStorage.create(QuestionCategory(0, title, description, optionParentID))._1).get))
  }
  
  post("/Update") {
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    val title = params.getOrElse("title", halt(405, "Title is not specified"))
    val description = params.getOrElse("description", halt(405, "Description is not specified"))
    val parentID = params.getOrElse("parentID", "-1").toInt
    val isFieldOfKnowledge = params.getOrElse("isFieldOfKnowledge", "false").toBoolean

    val optionParentID = if(parentID < 0) { None } else { Some(parentID) }
    JSON.toJSON(buildOutputCategoryJSON(getQuestionCategoryStorage.modify(QuestionCategory(id, title, description, optionParentID))._2))
  }
  
  post("/Delete") {
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    val categoryQuestions = getQuestionStorage.getByCategory(Some(id))
    for (question<-categoryQuestions) {
      for (answer<-question.answers) getAnswerStorage.delete(answer.id)
      getQuestionStorage.delete(question.id)
    }

    getQuestionCategoryStorage.delete(id)
  }
  
  //[{attr:{"id":_id, "rel":"folder"}, "data":_name,"state":"closed"}]
  private def buildOutputCategoryJSON(category:QuestionCategory) = {
    (Map("attr"->Map("id"->category.id, 
                     "rel"->"folder", 
                     "description"->category.description.toString, 
                     "parentID"->category.parentID.getOrElse(-1)),
         "data"->category.title,
         "state"->"closed"))
  }
  private def buildOutputCategoriesJSON(dataSeq:Seq[QuestionCategory]) = {
    (for(category<-dataSeq) yield
      buildOutputCategoryJSON(category)
    )
  }
}
