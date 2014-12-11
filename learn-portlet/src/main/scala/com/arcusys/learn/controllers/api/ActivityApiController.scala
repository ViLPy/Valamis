package com.arcusys.learn.controllers.api

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.models.{ ActivityModel, GeneralResponse }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.services.SocialActivityLocalServiceHelper

class ActivityApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  private def createActivityModels(name: List[String]) = name.map(x => ActivityModel(x, getTranslation.getOrElse(x, x)))

  get("/")(jsonAction {

    val data = createActivityModels(
      // TODO: Remove to data facade
      List(
        "com.liferay.portlet.blogs.model.BlogsEntry",
        "com.liferay.portlet.documentlibrary.model.DLFileEntry",
        "com.liferay.portlet.wiki.model.WikiPage",
        "com.liferay.portlet.messageboards.model.MBMessage",
        "com.liferay.calendar.model.CalendarBooking",
        "com.liferay.portlet.bookmarks.model.BookmarksEntry"
      )

    )

    GeneralResponse(data = data)
  })
}
