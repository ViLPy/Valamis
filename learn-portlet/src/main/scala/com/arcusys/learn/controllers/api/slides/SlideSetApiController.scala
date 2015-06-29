package com.arcusys.learn.controllers.api.slides

import com.arcusys.learn.controllers.api.BaseApiController
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.permission.PermissionUtil
import com.arcusys.learn.liferay.services.PermissionHelper
import com.arcusys.learn.models.request.{ SlideActionType, SlideRequest }
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.valamis.slide.model.SlideSetModel
import com.arcusys.valamis.slide.service.SlideSetServiceContract
import com.escalatesoft.subcut.inject.BindingModule

class SlideSetApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  private lazy val slideSetService = inject[SlideSetServiceContract]

  get("/slidesets(/)")(jsonAction {
    val slideRequest = SlideRequest(this)
    val page = slideRequest.page
    val itemsOnPage = slideRequest.itemsOnPage
    val titleFilter = slideRequest.titleFilter
    val sortTitleAsc = slideRequest.sortTitleAsc

    val requestedSlideSetsCount = slideSetService.getSlideSetsCount(slideRequest.titleFilter, slideRequest.courseIdOption)
    val requestedSlideSets = slideSetService.getSlideSets(slideRequest.titleFilter, slideRequest.sortTitleAsc, slideRequest.page, slideRequest.itemsOnPage, slideRequest.courseIdOption)

    CollectionResponse(page, requestedSlideSets, requestedSlideSetsCount)
  })

  post("/slidesets(/)(:id)")(jsonAction {
    val slideRequest = SlideRequest(this)

    val userId = PermissionUtil.getUserId
    PermissionHelper.preparePermissionChecker(userId)

    val learnPortletPath = getServletContext.getRealPath("/")

    slideRequest.action match {
      case SlideActionType.Delete => slideSetService.delete(slideRequest.id.get)
      case SlideActionType.Update => slideSetService.update(
        SlideSetModel(
          slideRequest.id,
          slideRequest.title,
          slideRequest.description,
          slideRequest.courseIdOption,
          slideRequest.logo,
          List()
        )
      )
      case SlideActionType.Create => slideSetService.createWithDefaultSlide(
        SlideSetModel(
          None,
          slideRequest.title,
          slideRequest.description,
          slideRequest.courseIdOption,
          slideRequest.logo,
          List()
        )
      )
      case SlideActionType.Publish => slideSetService.publishSlideSet(
        slideRequest.id.get,
        userId,
        learnPortletPath,
        slideRequest.courseId
      )
      case _ => throw new UnsupportedOperationException("Unknown action type")
    }
  })
}

