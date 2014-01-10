package com.arcusys.liferay.util

import com.liferay.portal.kernel.util._
import com.liferay.portal.service.ServiceContext
import com.liferay.portlet.documentlibrary.service.{DLFolderLocalServiceUtil, DLAppServiceUtil}

trait DocumentLibrarySupport {
  protected def addDLFileEntry(userId: Long, groupId: Long, folderId: Long, fileName: String,
                               name: String, title: String, description: String, serviceContext: ServiceContext , isPublic: Boolean) = {

    val bytes = HookHelpers.getBytes(fileName)

    serviceContext.setAddGroupPermissions(true)
    serviceContext.setAddGuestPermissions(isPublic)

    DLAppServiceUtil.addFileEntry(groupId, folderId, fileName, MimeTypesUtil.getContentType(fileName), title,
      description, StringPool.BLANK, bytes, serviceContext)
  }

  protected def addDLFolder(userId: Long, groupId: Long, name: String, description: String, isPublic: Boolean) = {
    val serviceContext = new ServiceContext

    serviceContext.setAddGroupPermissions(true)
    serviceContext.setAddGuestPermissions(isPublic)

    DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, 0, name, description, serviceContext)
  }
}