package com.arcusys.learn.controllers.api

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.facades.CourseFacadeContract
import com.arcusys.learn.models.request.CourseRequest
import com.arcusys.learn.models.response.CollectionResponse

/**
 * Created by Iliya Tryapitsin on 19.03.14.
 * Documentation: https://confluence.intra.arcusys.fi/display/VAL/Web+API+Specification:+Course
 */
class CourseApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  val courseFacade = inject[CourseFacadeContract]

  get("/")(jsonAction {
    val courseRequest = CourseRequest(this)
    val courses = courseFacade.all(courseRequest.companyId,
      courseRequest.skip,
      courseRequest.count,
      courseRequest.filter,
      courseRequest.isSortDirectionAsc)

    val count = courseFacade.count(courseRequest.companyId, courseRequest.filter)

    CollectionResponse(courseRequest.page, courses, count)
  })

}
