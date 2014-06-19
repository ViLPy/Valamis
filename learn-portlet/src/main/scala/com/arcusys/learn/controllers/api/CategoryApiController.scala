package com.arcusys.learn.controllers.api

import com.arcusys.learn.ioc.Configuration
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.models.request.{ CategoryActionType, CategoryRequest }
import com.arcusys.learn.facades.CategoryFacadeContract
import com.arcusys.learn.exceptions.BadRequestException

class CategoryApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  val categoryRequest = CategoryRequest(this)
  val categoryFacade = inject[CategoryFacadeContract]

  get("/(:id)")(jsonAction {
    requireTeacherPermissions()

    categoryRequest.action match {
      case None => categoryFacade.getChild(
        categoryRequest.parentId,
        categoryRequest.courseId)

      case CategoryActionType.WITH_QUESTIONS => categoryFacade.getChildWithQuestion(
        categoryRequest.parentId,
        categoryRequest.courseId,
        categoryRequest.questionsIDSet,
        categoryRequest.categoryIDSet)

      case _ => throw new BadRequestException
    }
  })

  post("/(:id)")(jsonAction {
    requireTeacherPermissions()

    categoryRequest.action match {
      case CategoryActionType.ADD => categoryFacade.create(
        categoryRequest.title,
        categoryRequest.description,
        categoryRequest.parentId,
        categoryRequest.courseId)

      case CategoryActionType.UPDATE => categoryFacade.update(
        categoryRequest.id,
        categoryRequest.title,
        categoryRequest.description)

      case CategoryActionType.MOVE => categoryFacade.move(
        categoryRequest.id,
        categoryRequest.dndMode,
        categoryRequest.targetId,
        categoryRequest.itemType)

      case CategoryActionType.DELETE => categoryFacade.delete(categoryRequest.id)

      case _                         => throw new BadRequestException
    }
  })
}
