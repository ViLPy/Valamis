package com.arcusys.valamis.file.service

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.services.{PermissionHelper, FileEntryServiceHelper}
import com.arcusys.valamis.model.RangeResult
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portlet.documentlibrary.model.DLFileEntry
/**
 * User: Yulia.Glushonkova
 * Date: 27.10.2014
 */
class FileEntryServiceImpl(implicit val bindingModule: BindingModule) extends FileEntryService with Injectable {

  def getImages(user: LUser, groupID: Int, filter: String, skip: Int, count: Int, isSortDirectionAsc: Boolean): RangeResult[DLFileEntry] = {
    PermissionHelper.preparePermissionChecker(user)

    val allImagesAmount = FileEntryServiceHelper.getImagesCount(groupID, filter)
    val data = FileEntryServiceHelper.getImages(groupID, skip, count, filter, isSortDirectionAsc)

    RangeResult(
      allImagesAmount,
      data
    )
  }

  def getVideo(user: LUser, groupID: Int, skip: Int, count: Int): RangeResult[DLFileEntry] = {
    PermissionHelper.preparePermissionChecker(user)

    val allAmount = FileEntryServiceHelper.getVideoCount(groupID)
    val data = FileEntryServiceHelper.getVideo(groupID, skip, count)

    RangeResult(
      allAmount,
      data
    )
  }
}
