package com.arcusys.valamis.file

import com.arcusys.valamis.core.DbNameUtils._
import com.arcusys.valamis.file.model.FileRecord

import scala.slick.driver.JdbcProfile

trait FileTableComponent {

  protected val driver: JdbcProfile
  import driver.simple._

  class FileTable(tag : Tag) extends Table[FileRecord](tag, tblName("FILE")) {
    def filename = column[String]("FILENAME", O.PrimaryKey, O.DBType("varchar(255)"))
    def content = column[Option[Array[Byte]]]("CONTENT", O.NotNull :: binaryOptions: _*)

    def * = (filename, content) <> (FileRecord.tupled, FileRecord.unapply)
  }

  val files = TableQuery[FileTable]
}

