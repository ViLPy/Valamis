package com.arcusys.valamis.file

import javax.inject.Inject

import com.arcusys.valamis.core.SlickDBInfo
import com.arcusys.valamis.file.model.FileRecord
import com.arcusys.valamis.file.storage.FileStorage
import com.escalatesoft.subcut.inject.{Injectable, BindingModule}

import scala.slick.driver.JdbcProfile
import scala.slick.jdbc.JdbcBackend

class FileRepositoryImpl @Inject() (val db:     JdbcBackend#DatabaseDef,
                                    val driver: JdbcProfile)
  extends FileStorage
  with FileTableComponent {

  import driver.simple._

  override def getFile(fileName: String): Option[FileRecord] = {
    db.withSession { implicit s =>
      files.filter(f => f.filename === fileName).firstOption
    }
  }

  //TODO: remove
  override def store(fileName: String): Unit = {}
  //TODO: remove method
  override def renew(): Unit = {}

  override def store(fileName: String, content: Array[Byte]): Unit = {
    db.withSession { implicit s =>
      files.insert(new FileRecord(fileName, Some(content)))
    }
  }

  //TODO: replace to 'remove' and 'remove by name prefix'
  override def delete(fileName: String, byPrefix: Boolean): Unit = {
    db.withSession { implicit s =>
      if (byPrefix)
        files.filter(f => f.filename.startsWith(fileName)).delete
      else
        files.filter(f => f.filename === fileName).delete
    }
  }

  override def getFiles(namePrefix: String): Seq[FileRecord] = {
    db.withSession { implicit s =>
      files.filter(f => f.filename.startsWith(namePrefix)).list
    }
  }
}
