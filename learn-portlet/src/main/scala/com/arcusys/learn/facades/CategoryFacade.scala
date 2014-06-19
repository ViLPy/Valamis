package com.arcusys.learn.facades

import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.questionbank.storage.{ QuestionCategoryStorage, QuestionStorage }
import com.arcusys.learn.questionbank.model.QuestionCategory
import scala.collection.mutable
import com.arcusys.learn.models.CategoryResponse
import sun.reflect.generics.reflectiveObjects.NotImplementedException
import com.arcusys.learn.exceptions.{ EntityNotFoundException }
import com.arcusys.learn.models.request.DndModeType
import com.arcusys.learn.models.request.DndModeType.DndModeType
import scala.util.Try

/**
 * Created by Iliya Tryapitsin on 10.04.2014.
 */
class CategoryFacade(configuration: BindingModule) extends CategoryFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration
  val questionStorage = inject[QuestionStorage]
  val questionCategoryStorage = inject[QuestionCategoryStorage]

  def getChild(parentId: Option[Int], courseID: Option[Int]) =
    questionCategoryStorage
      .getChildren(parentId, courseID)
      .map(category => CategoryResponse(
        category.id,
        category.title,
        category.description,
        category.parentID.getOrElse(-1),
        childrenAmount = questionStorage.getByCategory(Some(category.id), courseID).length))

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

  def update(id: Int,
    title: String,
    description: String) = {
    questionCategoryStorage.modify(id, title, description)
    getById(id)
  }

  def create(title: String,
    description: String,
    parentId: Option[Int],
    courseId: Option[Int]) = {
    val category = new QuestionCategory(0, title, description, parentId, courseId)
    val id = questionCategoryStorage.createAndGetID(category)
    getById(id)
  }

  def getById(id: Int) = questionCategoryStorage.getByID(id) match {
    case Some(value) => CategoryResponse(value.id, value.title, value.description, value.parentID.getOrElse(-1))
    case None        => throw new EntityNotFoundException
  }

  def delete(id: Int) = {
    questionCategoryStorage.delete(id)

    Try(getById(id)).isFailure
  }

  def move(id: Int, dndMode: DndModeType, targetId: Int, itemType: String) = {
    val siblingID = if (dndMode == DndModeType.LAST || (dndMode == DndModeType.BEFORE && itemType == "entity") || dndMode == DndModeType.INSIDE)
      None
    else
      Option(targetId)

    val parentId = if (siblingID != None)
      questionCategoryStorage
        .getByID(targetId)
        .getOrElse(throw new EntityNotFoundException)
        .parentID
    else if (itemType != "entity")
      Option(targetId)
    else questionStorage
      .getByID(targetId)
      .getOrElse(throw new EntityNotFoundException)
      .categoryID

    questionCategoryStorage.move(id, parentId, siblingID, dndMode == DndModeType.AFTER)
    getById(id)
  }
}
