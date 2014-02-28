package com.arcusys.learn.filestorage.storage.impl.liferay

import com.arcusys.learn.filestorage.storage.{FileStorageJUnitMethods, FileStorage}
import com.arcusys.learn.storage.impl.liferay.LFStorages

/**
 * User: dkudinov
 * Date: 12.3.2013
 */
class FileStorageWithLFTest extends FileStorageJUnitMethods {
  val fileStorage: FileStorage = LFStorages.fileStorage
}
