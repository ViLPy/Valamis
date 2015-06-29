package com.arcusys.learn.controllers.api

import com.arcusys.learn.exceptions.BadRequestException
import com.arcusys.learn.facades.CategoryFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.permission.{ModifyPermission, PermissionUtil, PortletName, ViewPermission}
import com.arcusys.learn.models.request.{CategoryActionType, CategoryRequest}
import com.escalatesoft.subcut.inject.BindingModule

class CategoryApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  val categoryFacade = inject[CategoryFacadeContract]

  def this() = this(Configuration)

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/categories(/)(:id)")(jsonAction {
    val categoryRequest = CategoryRequest(this)
    PermissionUtil.requirePermissionApi(ViewPermission,
      PortletName.ContentManager,
      PortletName.LessonDesigner,
      PortletName.SlidesEditor)

    categoryRequest.action match {
      case None => categoryFacade.getChild(
        categoryRequest.parentId,
        categoryRequest.courseId)

      case CategoryActionType.WithQuestions => categoryFacade.getChildWithQuestion(
        categoryRequest.parentId,
        categoryRequest.courseId,
        categoryRequest.questionsIdSet,
        categoryRequest.categoryIdSet)

      case CategoryActionType.AllChildren => categoryFacade.getAllContent(
        categoryRequest.parentId,
        categoryRequest.courseId)

      case CategoryActionType.ContentAmount => categoryFacade.getContentAmount(
        categoryRequest.parentId,
        categoryRequest.courseId)

      case _ => throw new BadRequestException
    }
  })

  post("/categories(/)(:id)")(jsonAction {
    val categoryRequest = CategoryRequest(this)
    PermissionUtil.requirePermissionApi(ModifyPermission, PortletName.ContentManager)

    categoryRequest.action match {
      case CategoryActionType.Add => categoryFacade.create(
        categoryRequest.title,
        categoryRequest.description,
        categoryRequest.parentId,
        categoryRequest.courseId)

      case CategoryActionType.Update => categoryFacade.update(
        categoryRequest.id,
        categoryRequest.title,
        categoryRequest.description)

      case CategoryActionType.Move => categoryFacade.move(
        categoryRequest.id,
        categoryRequest.index,
        categoryRequest.parentId)

      case CategoryActionType.MoveToCourse => categoryRequest.categoryIds
        .foreach(id => categoryFacade.moveToCourse(id, categoryRequest.courseId, categoryRequest.newCourseId))

      case CategoryActionType.Delete => categoryFacade.delete(categoryRequest.id, categoryRequest.courseId)

      case _ => throw new BadRequestException
    }
  })
}
