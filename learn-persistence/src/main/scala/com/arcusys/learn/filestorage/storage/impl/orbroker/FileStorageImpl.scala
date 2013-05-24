package com.arcusys.learn.filestorage.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.tracking.model.FileRecord
import com.arcusys.learn.filestorage.storage.impl.FileRecordEntityStorage

class FileStorageImpl extends GenericEntityStorageImpl[FileRecord]("FileStorage") with FileRecordEntityStorage with FileRecordExtractor

trait FileRecordExtractor extends RowExtractor[FileRecord] {
  def extract(row: Row) = FileRecord(row.string("filename").get, row.binary("content"))
}


