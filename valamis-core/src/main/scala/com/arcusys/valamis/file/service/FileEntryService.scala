package com.arcusys.valamis.file.service

import com.arcusys.learn.liferay.LiferayClasses.LUser
import com.arcusys.valamis.model.RangeResult
import com.liferay.portlet.documentlibrary.model.DLFileEntry

/**
 * User: Yulia.Glushonkova
 * Date: 27.10.2014
 */
trait FileEntryService {
  def getImages(user: LUser, groupID: Int, filter: String, skip: Int, count: Int, isSortDirectionAsc: Boolean): RangeResult[DLFileEntry]
  def getVideo(user: LUser, groupID: Int, skip: Int, count: Int): RangeResult[DLFileEntry]
}
