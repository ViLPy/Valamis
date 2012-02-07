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
    val position = if(categories.size>0)categories.map(category=>category.position).max + 1 else 0
    json(buildOutputCategoryJSON(getQuestionCategoryStorage.getByID(getQuestionCategoryStorage.create(QuestionCategory(0, title, description, optionParentID,position)).id).get))
  }
  
  post("/update") {
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    val title = params.getOrElse("title", halt(405, "Title is not specified"))
    val description = params.getOrElse("description", halt(405, "Description is not specified"))
    val category = getQuestionCategoryStorage.getByID(id).getOrElse(halt(404, "Can't find category"))
    json(buildOutputCategoryJSON(getQuestionCategoryStorage.modify(QuestionCategory(id, title, description, category.parentID, category.position))))
  }
  
  post("/move") {
    val id = params.getOrElse("id", halt(405, "ID is not specified")).toInt
    val category = getQuestionCategoryStorage.getByID(id).getOrElse(halt(404, "Can't find category"))
    val title = category.title
    val description = category.description
    val parentID = category.parentID
    val dndMode = params.getOrElse("dndMode", "")
    val targetId = params.getOrElse("targetId", "-1").toInt
    val itemType = params.getOrElse("itemType", "")
    
    val (defaultPosition,categories) = if((dndMode.equals("before") || dndMode.equals("after")) && itemType.equals("folder")){
      val targetCategory =getQuestionCategoryStorage.getByID(targetId).get
      val pos = if(dndMode.equals("after"))targetCategory.position + 1 else targetCategory.position
      (pos,getQuestionCategoryStorage.getChildren(targetCategory.parentID))
    }else if(dndMode.equals("before")&& itemType.equals("entity")){
      val categories = getQuestionCategoryStorage.getChildren(getQuestionStorage.getByID(targetId).get.categoryID) 
      val pos = if(categories.size>0)categories.map(category=>category.position).max + 1 else 0
      (pos,categories)
    }else if(dndMode.equals("last")){
      val categories = getQuestionCategoryStorage.getChildren(Some(targetId))
      val pos = if(categories.size>0)categories.map(category=>category.position).max + 1 else 0
      (pos,categories)
    }else (0,null)
    val position = if(dndMode.equals("last"))
    {
      defaultPosition
    }
    else if(dndMode.equals("after") || dndMode.equals("before")){
      categories.foreach(category=>{
          if(category.position>=defaultPosition){
            getQuestionCategoryStorage.modify(QuestionCategory(category.id, category.title, category.description, category.parentID,category.position+1))
          }
        })
      defaultPosition
    }else{
      getQuestionCategoryStorage.getByID(id).getOrElse(halt(404, "Can't find category")).position
    }
       
    val optionParentID = if(targetId>(-2)){
      if(itemType.equals("entity")) getQuestionStorage.getByID(targetId).get.categoryID else {
        if(dndMode.equals("last")){
          Some(targetId)
        }
        else{
          getQuestionCategoryStorage.getByID(targetId).get.parentID
        }
      }
    }
    else{
      parentID
    }
    
    json(buildOutputCategoryJSON(getQuestionCategoryStorage.modify(QuestionCategory(id, title, description, optionParentID,position))))
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
        "position"->category.position,
        "title"->category.title,
        "type"->"folder")
  }
  
  private def buildOutputCategoriesJSON(categories:Seq[QuestionCategory]) = categories.map(buildOutputCategoryJSON(_))
}
