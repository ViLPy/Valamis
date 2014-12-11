package com.arcusys.learn.facades

import com.arcusys.learn.bl.services.QuestionServiceContract
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.questionbank.model.QuestionCategory
import com.arcusys.learn.models.CategoryResponse
import org.apache.commons.lang.NotImplementedException
import com.arcusys.learn.bl.exceptions.EntityNotFoundException
import com.arcusys.learn.models.request.DndModeType
import com.arcusys.learn.models.request.DndModeType.DndModeType
import scala.util.Try

class CategoryFacade(configuration: BindingModule) extends CategoryFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration
  val questionService = inject[QuestionServiceContract]

  def getChild(parentId: Option[Int], courseID: Option[Int]) = {
    questionService.getCategories(parentId, courseID)
      .map(category => CategoryResponse(
        category.id,
        category.title,
        category.description,
        category.parentID.getOrElse(-1),
        childrenAmount = questionService.getQuestionsCountByCategory(Some(category.id), courseID)))
  }

  def getChildWithQuestion(parentId: Option[Int],
    courseId: Option[Int],
    questionsIds: Seq[Int],
    categoryIds: Seq[Int]) = throw new NotImplementedException

  //  {

  //    val questions = questionsIds.map(id => questionStorage.getByID(id))
  //    categoryIds.map(id => {
  //      val id = if (id == -1) None else Some(id)
  //      if (id != None)
  //        categoriesSet.add(questionCategoryStorage.getByID(id.get).get)
  //
  //      traversal(id, courseId)
  //    })

  //    val categoryIDSet = Parameter("categories").required.trim
  //    val questionsIDSet = parameter("questions").required.trim
  //    val categoriesSet = mutable.LinkedHashSet[QuestionCategory]()
  //    val questionSet = mutable.LinkedHashSet[Question[Answer]]()
  //    val courseID = parameter("courseID").intOption(-1)
  //    val parentID = 0
  //
  //    //log.debug("Get all child with questions based on categories = [" + categoryIDSet + "] and questions = [" + questionsIDSet + "]")
  //
  //    def getQuestions(id: Option[Int]) {
  //      questionStorage.getByCategory(id, courseID).foreach(question => questionSet.add(question))
  //    }
  //
  //    def traversal(id: Option[Int]) {
  //      questionCategoryStorage.getChildren(id, courseID).foreach(cat => {
  //        categoriesSet.add(cat)
  //        traversal(Some(cat.id))
  //      }
  //      )
  //      getQuestions(id)
  //    }
  //
  //    if (!questionsIDSet.isEmpty) {
  //      //log.debug("> Fetching questions")
  //      questionsIDSet.split(';').foreach(questionID => questionSet.add(questionStorage.getByID(questionID.toInt).get))
  //    }
  //
  //    if (!categoryIDSet.isEmpty) {
  //      //log.debug("> Fetching categories")
  //      categoryIDSet.split(';').foreach(catID => {
  //        val id = if (catID.toInt == -1) None else Some(catID.toInt)
  //        if (id != None) categoriesSet.add(questionCategoryStorage.getByID(catID.toInt).get)
  //        traversal(id)
  //      }
  //      )
  //    }
  //  }

  def update(id: Int, title: String, description: String) = {
    val category = questionService.updateCategory(id, title, description)
    toResponse(category)
  }

  def create(title: String, description: String, parentId: Option[Int], courseId: Option[Int]) = {
    val category = questionService.createCategory(title, description, parentId, courseId)
    toResponse(category)
  }

  def getById(id: Int) = {
    questionService.getCategoryOption(id) match {
      case Some(category) => toResponse(category)
      case None           => throw new EntityNotFoundException
    }
  }

  def delete(id: Int, courseId: Option[Int]) = {
    questionService.deleteCategory(id, courseId)

    Try(getById(id)).isFailure
  }

  def moveToCourse(id: Int, courseID: Option[Int], newCourseID: Option[Int]): Unit = {
    questionService.moveCategoryToCourse(id, courseID, newCourseID)
  }

  def move(id: Int, dndMode: DndModeType, targetId: Int, itemType: String) = {

    val siblingID = dndMode match {
      case DndModeType.LAST => None
      case DndModeType.INSIDE => None
      case DndModeType.BEFORE if itemType == "entity" => None
      case DndModeType.AFTER => Option(targetId)
      case _ => Option(targetId)
    }

    val category = if (siblingID != None) {
      questionService.moveCategoryToSibling(id, siblingID.get, dndMode == DndModeType.AFTER)
    } else {
      if (itemType != "entity")
        questionService.moveCategoryToCategory(id, Some(targetId), dndMode == DndModeType.AFTER)
      else
        questionService.moveCategoryToQuestion(id, targetId)
    }

    toResponse(category)
    //    val siblingID = if (
    //      dndMode == DndModeType.LAST
    //      || (dndMode == DndModeType.BEFORE && itemType == "entity")
    //      || dndMode == DndModeType.INSIDE
    //    )
    //      None
    //    else
    //      Option(targetId)
    //
    //    val parentId = if (siblingID != None)
    //      questionCategoryStorage
    //        .getByID(targetId)
    //        .getOrElse(throw new EntityNotFoundException)
    //        .parentID
    //    else if (itemType != "entity")
    //      Option(targetId)
    //    else questionStorage
    //      .getByID(targetId)
    //      .getOrElse(throw new EntityNotFoundException)
    //      .categoryID
    //
    //    questionService.moveCategory(id, parentId, siblingID, dndMode == DndModeType.AFTER)
    //    getById(id)
  }

  private def toResponse(category: QuestionCategory): CategoryResponse = {
    CategoryResponse(category.id, category.title, category.description, category.parentID.getOrElse(-1))
  }
}
