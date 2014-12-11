package com.arcusys.learn.liferay.services

import com.liferay.portal.kernel.util.MimeTypesUtil
import com.liferay.portal.kernel.workflow.WorkflowConstants
import com.liferay.portal.service.ServiceContext
import com.liferay.portlet.documentlibrary.service.{ DLAppServiceUtil, DLFileEntryServiceUtil }
import com.liferay.portlet.documentlibrary.util.{ VideoProcessorUtil, ImageProcessorUtil }
import com.liferay.portlet.documentlibrary.model.{ DLFolderConstants, DLFileEntry }
import java.io.{ InputStream, ByteArrayOutputStream }

import scala.util.Try

/**
 * User: Yulia.Glushonkova
 * Date: 11.07.14
 */
object FileEntryServiceHelper {
  def getImages(groupID: Int, skip: Int, take: Int, filter: String, sortAscDirection: Boolean) = {
    val images = DLFileEntryServiceUtil.getFileEntries(groupID, 0, imageMimeTypes, -1, -1, null)
      .toArray()
      .filter(i => i.asInstanceOf[DLFileEntry].getTitle.toLowerCase.contains(filter.toLowerCase))
      .sortBy(i => i.asInstanceOf[DLFileEntry].getTitle)

    (if (sortAscDirection) images else images.reverse)
      .drop(skip)
      .take(take)
      .map(i => {
        i.asInstanceOf[DLFileEntry]
      }).toList
  }

  def getImagesCount(groupID: Int, filter: String) = {
    DLFileEntryServiceUtil.getFileEntries(groupID, 0, imageMimeTypes, -1, -1, null)
      .toArray()
      .filter(i => i.asInstanceOf[DLFileEntry].getTitle.toLowerCase.contains(filter.toLowerCase))
      .length
  }

  def getVideo(groupID: Int, skip: Int, take: Int) = {
    val video = DLFileEntryServiceUtil.getFileEntries(groupID, 0, videoMimeTypes, -1, -1, null)
      .toArray()
      .sortBy(i => i.asInstanceOf[DLFileEntry].getTitle)

    video
      .drop(skip)
      .take(take)
      .map(i => {
        i.asInstanceOf[DLFileEntry]
      }).toList
  }

  def getVideoCount(groupID: Int) = {
    DLFileEntryServiceUtil.getFileEntriesCount(groupID, 0, videoMimeTypes)
  }

  private def imageMimeTypes() = {
    ImageProcessorUtil.getImageMimeTypes().toArray.map(i => i.asInstanceOf[String])
  }
  private def videoMimeTypes() = {
    VideoProcessorUtil.getVideoMimeTypes().toArray.map(i => i.asInstanceOf[String])
  }

  def getFile(fileEntryID: Long, version: String) = {
    val stream = DLFileEntryServiceUtil.getFileAsStream(fileEntryID, version)

    val baos = new ByteArrayOutputStream()
    var reads = stream.read()

    while (reads != -1) {
      baos.write(reads)
      reads = stream.read()
    }

    stream.close()
    baos.toByteArray()
  }

  def getFile(uuid: String, groupId: Long) = {
    val fileEntry = DLFileEntryServiceUtil.getFileEntryByUuidAndGroupId(uuid, groupId)
    val stream = fileEntry.getContentStream

    streamToByteArray(stream)
  }

  def getFileEntry(uuid: String, groupId: Long): DLFileEntry = {
    val fileEntry = DLFileEntryServiceUtil.getFileEntryByUuidAndGroupId(uuid, groupId)
    fileEntry
  }

  def addFileToDocumentLibrary(filename: String, groupId: Int, videoTitle: String, extension: String, mimeType: String, size: Long): String = {

    val repositoryId = DLFolderConstants.getDataRepositoryId(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID)
    val folderId = DLFolderConstants.getFolderId(groupId, repositoryId)

    val existedFileEntry = Try(DLAppServiceUtil.getFileEntry(repositoryId, folderId, videoTitle)).toOption
    if (existedFileEntry.isDefined && existedFileEntry.get.getSize == size) return existedFileEntry.get.getUuid

    val sourceFileName = filename + "." + extension
    val file = new java.io.File(filename)
    val mimeTypeForEntry = if (mimeType.isEmpty) MimeTypesUtil.getContentType(file)
    else mimeType

    val title = if (existedFileEntry.isDefined && existedFileEntry.get.getTitle == videoTitle) videoTitle + " new"
    else videoTitle

    val serviceContext = new ServiceContext()
    serviceContext.setScopeGroupId(groupId)
    serviceContext.setAddGroupPermissions(true)
    serviceContext.setAddGuestPermissions(true)
    serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH)

    val fileEntry = DLAppServiceUtil.addFileEntry(repositoryId,
      folderId,
      sourceFileName,
      mimeTypeForEntry,
      title,
      "",
      "",
      file,
      serviceContext
    )
    fileEntry.getUuid
  }

  private def streamToByteArray(input: InputStream) = {
    val buffer = new Array[Byte](8192)
    val baos = new ByteArrayOutputStream

    def copy() {
      val read = input.read(buffer)
      if (read >= 0) {
        baos.write(buffer, 0, read)
        copy()
      }
    }
    copy()

    input.close()
    baos.toByteArray
  }
}
