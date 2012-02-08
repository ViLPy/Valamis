package com.arcusys.scorm.service.question

import com.arcusys.scorm.service.StorageFactory._
import org.scalatra.ScalatraServlet
import com.arcusys.scala.scalatra.json.JsonSupport
import com.arcusys.scorm.model.quiz._
import com.arcusys.scorm.util._

class CategoryService extends ScalatraServlet with JsonSupport
{
  get("/") {
    json(buildOutputCategoriesJSON(getQuestionCategoryStorage.getAll))
  }
  
  get("/children/:id") {
    val id = params.getOrElse("id", halt(405, "-1")).toInt
    val parentID = if (id == -1) { None } else {Some(id)}
    val categories = getQuestionCategoryStorage.getChildren(parentID)
    val questions = getQuestionStorage.getByCategory(parentID)
    json(buildOutputCategoriesJSON(categories) ++ QuestionSerializer.buildOutputJSON(questions))
  }
  
  post("/") {
    val title = params.getOrElse("title", halt(405, "Title is not specified"))
    val description = params.getOrElse("description", halt(405, "Description is not specified"))
    val parentID = params.getOrElse("parentID", "-1").toInt
    val checkParentID = if (parentID == -1) None else Some(parentID)
    val optionParentID = if(parentID < 0) None else Some(parentID)
    val categories = getQuestionCategoryStorage.getChildren(checkParentID)
    json(buildOutputCategoryJSON(getQuestionCategoryStorage.getByID(getQuestionCategoryStorage.create(QuestionCategory(0, title, description, optionParentID)).id).get))
  }
  
  post("/update") {
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    val title = params.getOrElse("title", halt(405, "Title is not specified"))
    val description = params.getOrElse("description", halt(405, "Description is not specified"))
    val category = getQuestionCategoryStorage.getByID(id).getOrElse(halt(404, "Can't find category"))
    json(buildOutputCategoryJSON(getQuestionCategoryStorage.modify(QuestionCategory(id, title, description, category.parentID))))
  }
  
  post("/move") {
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    val dndMode = params.getOrElse("dndMode", "")
    val targetId = params.getOrElse("targetId", "-1").toInt
    val itemType = params.getOrElse("itemType", "")
    
    val isMoveToEnd = (dndMode.equals("last") || (dndMode.equals("before") && itemType.equals("entity")))
    val isMoveAfterTarget = dndMode.equals("after")
    
    val parentID = if (targetId != -1 && isMoveToEnd) Some(targetId)
    else if (!isMoveToEnd) getQuestionCategoryStorage.getByID(targetId).getOrElse(halt(404, "Can't find category")).parentID
    else None
    
    val category = getQuestionCategoryStorage.getByID(id).getOrElse(halt(404, "Can't find category")).copy(parentID = parentID)
    
    json(buildOutputCategoryJSON(getQuestionCategoryStorage.move(category, isMoveToEnd, isMoveAfterTarget, targetId)))
    
  }
  
  post("/delete") {
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    getQuestionCategoryStorage.delete(id)
  }
  
  //[{attr:{"id":_id, "rel":"folder"}, "data":_name,"state":"closed"}]
  private def buildOutputCategoryJSON(category:QuestionCategory) = {
    Map("id"->category.id, 
        "description"->category.description.toString, 
        "parentID"->category.parentID.getOrElse(-1),
        "title"->category.title,
        "type"->"folder")
  }
  
  private def buildOutputCategoriesJSON(categories:Seq[QuestionCategory]) = categories.map(buildOutputCategoryJSON(_))
}
