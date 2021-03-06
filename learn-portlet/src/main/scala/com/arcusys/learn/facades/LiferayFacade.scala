package com.arcusys.learn.facades

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.models.FileEntryModel
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.valamis.file.service.FileEntryService
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.liferay.portlet.documentlibrary.model.DLFileEntry

/**
 * User: Yulia.Glushonkova
 * Date: 10.10.2014
 */
class LiferayFacade(configuration: BindingModule) extends Injectable {
  def this() = this(Configuration)
  implicit val bindingModule = configuration
  private val fileService = inject[FileEntryService]

  private def toFileEntryModel(name: Seq[DLFileEntry]) = name.map(x =>
    FileEntryModel(
      x.getFileEntryId,
      x.getTitle,
      x.getFolderId,
      x.getVersion,
      x.getMimeType,
      x.getGroupId,
      x.getUuid))

  def getImages(user: LUser, groupID: Int, filter: String, page: Int, skip: Int, count: Int, isSortDirectionAsc: Boolean) = {
    val result = fileService.getImages(user, groupID, filter, skip, count, isSortDirectionAsc)
    CollectionResponse(page, toFileEntryModel(result.items), result.total)
  }

  def getVideo(user: LUser, groupID: Int, page: Int, skip: Int, count: Int) = {
    val result = fileService.getVideo(user, groupID, skip, count)
    CollectionResponse(page, toFileEntryModel(result.items), result.total)
  }
}
