package com.arcusys.learn.liferay.update.migration

import com.arcusys.learn.liferay.util.Base64Helper
import com.arcusys.valamis.file.FileTableComponent
import com.arcusys.valamis.file.model.FileRecord

import scala.slick.driver.JdbcProfile
import scala.slick.jdbc.{JdbcBackend, StaticQuery}

class FileStorageMigration2303(val db: JdbcBackend#DatabaseDef, val driver: JdbcProfile) extends FileTableComponent {
  import driver.simple._

  def migrate(): Unit = {
    db.withTransaction { implicit session =>
      val ids = StaticQuery.queryNA[Long]("SELECT id_ FROM Learn_LFFileStorage").list

      for (
        id <- ids;
        file <- StaticQuery.queryNA[(String, String)](s"SELECT filename, content FROM Learn_LFFileStorage where id_ = ${id}").list
      ) {
        val filename = file._1
        Option(file._2).filterNot(_.isEmpty).map(Base64Helper.stringToObject) match {
          case Some(content: Array[Byte]) =>
            files.filter(_.filename === filename).delete
            files.insert(new FileRecord(filename, Some(content)))
          case _ =>
        }
      }
    }
  }
}
