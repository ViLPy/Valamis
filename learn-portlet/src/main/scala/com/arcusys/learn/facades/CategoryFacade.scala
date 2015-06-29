package com.arcusys.learn.facades

import com.arcusys.valamis.exception.EntityNotFoundException
import com.arcusys.valamis.questionbank.model.QuestionCategory
import com.arcusys.valamis.questionbank.service.QuestionService
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models._
import org.apache.commons.lang.NotImplementedException
import com.arcusys.learn.models.request.DndModeType
import com.arcusys.learn.models.request.DndModeType.DndModeType
import scala.util.Try

class CategoryFacade(configuration: BindingModule) extends CategoryFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration
  val questionService = inject[QuestionService]
  lazy val questionFacade = inject[QuestionFacadeContract]

  def getChild(parentId: Option[Int], courseId: Option[Int]) = {
    questionService.getCategories(parentId, courseId)
      .map(category => CategoryResponse(
        category.id,
        category.title,
        category.description,
        category.parentId,
        arrangementIndex = category.arrangementIndex,
        courseId = category.courseId.get,
        uniqueId = "q_" + category.id,
        childrenAmount = questionService.getQuestionsCountByCategory(Some(category.id), courseId)))
  }

  def collectAllChildren(parentId: Option[Int], courseId: Option[Int]):Seq[ContentResponse] = {

    val questions = questionFacade.getChildren(parentId, courseId)

    val categories = questionService.getCategories(parentId, courseId)
      .map(category => {
      val children = collectAllChildren(Some(category.id), courseId)
      val questionCount = children.filter(c => c.contentType == "category")
        .map(c => c.asInstanceOf[CategoryResponse].childrenAmount).sum

      CategoryResponse(
        category.id,
        category.title,
        category.description,
        category.parentId,
        children = children,
        arrangementIndex = category.arrangementIndex,
        courseId = category.courseId.get,
        uniqueId = "c_" + category.id,
        childrenAmount = questionCount + children.count(c => c.contentType == "question"))
    })

    questions ++ categories
  }

  def getAllContent(parentId: Option[Int], courseId: Option[Int]):Seq[ContentResponse] = {
    collectAllChildren(parentId, courseId)
  }

  def getContentAmount(parentId: Option[Int], courseId: Option[Int]):Int = {
    val children = collectAllChildren(parentId, courseId)
    val currentQuestionAmount = children.count(_.contentType == "question")

    val currentCategoriesQuestionAmount = children.filter(_.contentType == "category")
      .map(_.asInstanceOf[CategoryResponse].childrenAmount).sum

    currentQuestionAmount + currentCategoriesQuestionAmount
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

  //    val categoryIdSet = Parameter("categories").required.trim
  //    val questionsIdSet = parameter("questions").required.trim
  //    val categoriesSet = mutable.LinkedHashSet[QuestionCategory]()
  //    val questionSet = mutable.LinkedHashSet[Question[Answer]]()
  //    val courseId = parameter("courseId").intOption(-1)
  //    val parentId = 0
  //
  //    //log.debug("Get all child with questions based on categories = [" + categoryIdSet + "] and questions = [" + questionsIdSet + "]")
  //
  //    def getQuestions(id: Option[Int]) {
  //      questionStorage.getByCategory(id, courseId).foreach(question => questionSet.add(question))
  //    }
  //
  //    def traversal(id: Option[Int]) {
  //      questionCategoryStorage.getChildren(id, courseId).foreach(cat => {
  //        categoriesSet.add(cat)
  //        traversal(Some(cat.id))
  //      }
  //      )
  //      getQuestions(id)
  //    }
  //
  //    if (!questionsIdSet.isEmpty) {
  //      //log.debug("> Fetching questions")
  //      questionsIdSet.split(';').foreach(questionId => questionSet.add(questionStorage.getByID(questionId.toInt).get))
  //    }
  //
  //    if (!categoryIdSet.isEmpty) {
  //      //log.debug("> Fetching categories")
  //      categoryIdSet.split(';').foreach(catId => {
  //        val id = if (catID.toInt == -1) None else Some(catId.toInt)
  //        if (id != None) categoriesSet.add(questionCategoryStorage.getByID(catId.toInt).get)
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

  def moveToCourse(id: Int, courseId: Option[Int], newCourseId: Option[Int]): Unit = {
    questionService.moveCategoryToCourse(id, courseId, newCourseId, parentId = None)
  }

  @deprecated
  def move(id: Int, dndMode: DndModeType, targetId: Int, itemType: String) = {

    val siblingId = dndMode match {
      case DndModeType.Last => None
      case DndModeType.Inside => None
      case DndModeType.Before if itemType == "entity" => None
      case DndModeType.After => Option(targetId)
      case _ => Option(targetId)
    }

    val category = if (siblingId != None) {
      questionService.moveCategoryToSibling(id, siblingId.get, dndMode == DndModeType.After)
    } else {
      if (itemType != "entity")
        questionService.moveCategoryToCategory(id, Some(targetId), dndMode == DndModeType.After)
      else
        questionService.moveCategoryToQuestion(id, targetId)
    }

    toResponse(category)
    //    val siblingId = if (
    //      dndMode == DndModeType.Last
    //      || (dndMode == DndModeType.Before && itemType == "entity")
    //      || dndMode == DndModeType.Inside
    //    )
    //      None
    //    else
    //      Option(targetId)
    //
    //    val parentId = if (siblingId != None)
    //      questionCategoryStorage
    //        .getByID(targetId)
    //        .getOrElse(throw new EntityNotFoundException)
    //        .parentId
    //    else if (itemType != "entity")
    //      Option(targetId)
    //    else questionStorage
    //      .getByID(targetId)
    //      .getOrElse(throw new EntityNotFoundException)
    //      .categoryId
    //
    //    questionService.moveCategory(id, parentId, siblingId, dndMode == DndModeType.After)
    //    getById(id)
  }

  def move(id: Int, index: Int, parentId: Option[Int] /*, newCourseId: Option[Int]*/ ) = {
    val category = questionService.moveCategory(id, index, parentId /*, newCourseId*/ )
    toResponse(category)
  }

  private def toResponse(category: QuestionCategory): CategoryResponse = {
    CategoryResponse(
      category.id,
      category.title,
      category.description,
      category.parentId,
      arrangementIndex = category.arrangementIndex,
      courseId = category.courseId.get,
      uniqueId = "q_" + category.id
    )
  }
}
