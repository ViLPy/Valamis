package com.arcusys.learn.achievements

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.models.{ActivityModel, GeneralResponse}
import com.arcusys.learn.ioc.Configuration
import javax.servlet.http.HttpServletRequest

class ActivityWebService (configuration: BindingModule) extends BaseWebService(configuration) {
  def this() = this(Configuration)

  private def createActivityModels(name: List[String]) = name.map(x => ActivityModel(x, getTranslation.getOrElse(x, x)))

  get("/")(action {

    val data = createActivityModels(
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
