package com.arcusys.learn.questionbank.service

import com.arcusys.learn.questionbank.model._
import com.arcusys.scorm.util._
import scala.collection.mutable

import com.arcusys.learn.ioc.Configuration
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase

class CategoryService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  val jsonModel = new JsonModelBuilder[QuestionCategory](category =>
    Map("id" -> category.id,
      "description" -> category.description.toString,
      "parentID" -> category.parentID.getOrElse(-1),
      "title" -> category.title,
      "type" -> "folder")
  )

  import storageFactory._

  get("/") {
    val courseID = parameter("courseID").intOption(-1)
    jsonModel(questionCategoryStorage.getAllByCourseID(courseID))
  }

  get("/children/:id") {
    val parentID = parameter("id").intOption(-1)
    val courseID = parameter("courseID").intOption(-1)
    jsonModel(questionCategoryStorage.getChildren(parentID, courseID))
  }

  get("/children/withQuestions/") {
    val categoryIDSet = parameter("categories").required.trim
    val questionsIDSet = parameter("questions").required.trim
    val categoriesSet = mutable.LinkedHashSet[QuestionCategory]()
    val questionSet = mutable.LinkedHashSet[Question[Answer]]()
    val courseID = parameter("courseID").intOption(-1)
    val parentID = 0

    //log.debug("Get all child with questions based on categories = [" + categoryIDSet + "] and questions = [" + questionsIDSet + "]")

    def getQuestions(id: Option[Int] ) {
      questionStorage.getByCategory(id, courseID).foreach(question => questionSet.add(question))
    }

    def traversal(id: Option[Int]) {
      questionCategoryStorage.getChildren(id, courseID).foreach(cat => {
        categoriesSet.add(cat)
        traversal(Some(cat.id))
      }
      )
      getQuestions(id)
    }

    if (!questionsIDSet.isEmpty) {
      //log.debug("> Fetching questions")
      questionsIDSet.split(';').foreach(questionID => questionSet.add(questionStorage.getByID(questionID.toInt).get))
    }

    if (!categoryIDSet.isEmpty) {
      //log.debug("> Fetching categories")
      categoryIDSet.split(';').foreach(catID => {
        val id = if (catID.toInt == -1) None else Some(catID.toInt)
        if (id != None) categoriesSet.add(questionCategoryStorage.getByID(catID.toInt).get)
        traversal(id)
      }
      )
    }

    json(Map("categories" -> jsonModel.map(categoriesSet.groupBy(_.id).map(_._2.head).toSeq), "questions" -> QuestionSerializer.buildOutputJSON(questionSet.groupBy(_.id).map(_._2.head).toSeq)))
  }

  post("/") {
    val title = parameter("title").required
    val description = parameter("description").required
    val parentID = parameter("parentID").intOption(-1)
    val courseID =  parameter("courseID").intOption(-1)
    //log.debug("Creating category(" + title + ", " + description + ", " + parentID + ")")
    val id = questionCategoryStorage.createAndGetID(new QuestionCategory(0, title, description, parentID, courseID))
    jsonModel(questionCategoryStorage.getByID(id))
  }

  post("/update/:id") {
    val id = parameter("id").intRequired
    val title = parameter("title").required
    val description = parameter("description").required

    //log.debug("Updating category(" + id + ", " + title + ", " + description + ")")
    questionCategoryStorage.modify(id, title, description)
    jsonModel(questionCategoryStorage.getByID(id))
  }

  post("/move/:id") {
    val id = parameter("id").intRequired
    val dndMode = parameter("dndMode").required
    val targetID = parameter("targetId").intOption(-1)
    val itemType = parameter("itemType").required

    val moveAfterTarget = dndMode == "after"

    val siblingID = if (dndMode == "last" || (dndMode == "before" && itemType == "entity") || dndMode == "inside") None
    else targetID

    val parentID = if (siblingID != None) questionCategoryStorage.getByID(targetID.get).getOrElse(halt(404, "Can't find category")).parentID
    else if (itemType != "entity") targetID
    else questionStorage.getByID(targetID.get).getOrElse(halt(404, "Can't find question")).categoryID
    //log.debug("Moving category " + id + " with parentID=" + parentID + " siblingID=" + siblingID + " moving after sibling=" + moveAfterTarget)
    questionCategoryStorage.move(id, parentID, siblingID, moveAfterTarget)
    jsonModel(questionCategoryStorage.getByID(id))

  }

  post("/delete/:id") {
    val id = parameter("id").intRequired
    questionCategoryStorage.delete(id)
  }

  //[{attr:{"id":_id, "rel":"folder"}, "data":_name,"state":"closed"}]
}
