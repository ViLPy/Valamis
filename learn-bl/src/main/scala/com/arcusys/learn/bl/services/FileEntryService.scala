package com.arcusys.learn.bl.services

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.bl.models.RangeResult
import com.arcusys.learn.liferay.services.FileEntryServiceHelper
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.liferay.portal.model.User
import com.liferay.portal.security.auth.PrincipalThreadLocal
import com.liferay.portal.security.permission.{ PermissionThreadLocal, PermissionCheckerFactoryUtil }
import com.liferay.portlet.documentlibrary.model.DLFileEntry
/**
 * User: Yulia.Glushonkova
 * Date: 27.10.2014
 */
class FileEntryService(configuration: BindingModule) extends FileEntryServiceContract with Injectable {
  def this() = this(DomainConfiguration)

  implicit val bindingModule = configuration

  def getImages(user: User, groupID: Int, filter: String, skip: Int, count: Int, isSortDirectionAsc: Boolean): RangeResult[DLFileEntry] = {
    val permissionChecker = PermissionCheckerFactoryUtil.create(user)
    PermissionThreadLocal.setPermissionChecker(permissionChecker)
    PrincipalThreadLocal.setName(user.getUserId)

    val allImagesAmount = FileEntryServiceHelper.getImagesCount(groupID, filter)
    val data = FileEntryServiceHelper.getImages(groupID, skip, count, filter, isSortDirectionAsc)

    RangeResult(
      allImagesAmount,
      data
    )
  }

  def getVideo(user: User, groupID: Int, skip: Int, count: Int): RangeResult[DLFileEntry] = {
    val permissionChecker = PermissionCheckerFactoryUtil.create(user)

    PermissionThreadLocal.setPermissionChecker(permissionChecker)
    PrincipalThreadLocal.setName(user.getUserId)

    val allAmount = FileEntryServiceHelper.getVideoCount(groupID)
    val data = FileEntryServiceHelper.getVideo(groupID, skip, count)

    RangeResult(
      allAmount,
      data
    )
  }
}
