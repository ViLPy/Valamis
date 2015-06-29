package com.arcusys.learn.controllers.api.slides

import javax.servlet.http.HttpServletResponse
import com.arcusys.learn.controllers.api.BaseApiController
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models.request.{ SlideRequest, SlideActionType }
import com.arcusys.valamis.slide.model.{SlideElementModel, SlideEntityType}
import com.arcusys.valamis.slide.service.SlideElementServiceContract
import com.escalatesoft.subcut.inject.BindingModule

class SlideElementApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  private lazy val slideElementService = inject[SlideElementServiceContract]

  def haltOnInvalidData(slideRequest: SlideRequest.Model) {
    if (!SlideEntityType.AvailableTypes.contains(slideRequest.slideEntityType)) halt(HttpServletResponse.SC_BAD_REQUEST, "Unknown slide entity type")
  }

  get("/slideentities(/)")(jsonAction {
    val slideRequest = SlideRequest(this)

    slideElementService.getBySlideId(slideRequest.slideId)
  })

  post("/slideentities(/)(:id)")(jsonAction {
    val slideRequest = SlideRequest(this)

    slideRequest.action match {
      case SlideActionType.Delete => slideElementService.delete(slideRequest.id.get)
      case SlideActionType.Update =>
        haltOnInvalidData(slideRequest)
        slideElementService.update(
          SlideElementModel(
            slideRequest.id,
            slideRequest.top,
            slideRequest.left,
            slideRequest.width,
            slideRequest.height,
            slideRequest.zIndex,
            slideRequest.content,
            slideRequest.slideEntityType,
            slideRequest.slideId,
            slideRequest.correctLinkedSlideId,
            slideRequest.incorrectLinkedSlideId,
            slideRequest.notifyCorrectAnswer
          )
        )
      case SlideActionType.Create =>
        haltOnInvalidData(slideRequest)
        slideElementService.create(
          SlideElementModel(
            None,
            slideRequest.top,
            slideRequest.left,
            slideRequest.width,
            slideRequest.height,
            slideRequest.zIndex,
            slideRequest.content,
            slideRequest.slideEntityType,
            slideRequest.slideId,
            slideRequest.correctLinkedSlideId,
            slideRequest.incorrectLinkedSlideId,
            slideRequest.notifyCorrectAnswer
          )
        )
    }
  })
}