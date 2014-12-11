package com.arcusys.learn.bl.services

import com.arcusys.learn.bl.models.RangeResult
import com.liferay.portal.model.User
import com.liferay.portlet.documentlibrary.model.DLFileEntry

/**
 * User: Yulia.Glushonkova
 * Date: 27.10.2014
 */
trait FileEntryServiceContract {
  def getImages(user: User, groupID: Int, filter: String, skip: Int, count: Int, isSortDirectionAsc: Boolean): RangeResult[DLFileEntry]
  def getVideo(user: User, groupID: Int, skip: Int, count: Int): RangeResult[DLFileEntry]
}
