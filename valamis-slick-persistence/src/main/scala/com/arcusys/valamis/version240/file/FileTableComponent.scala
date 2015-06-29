package com.arcusys.valamis.version240.file

import com.arcusys.valamis.core.DbNameUtils._
import scala.slick.driver.JdbcProfile

trait FileTableComponent {
  protected val driver: JdbcProfile
  import driver.simple._

  type FileRecord = (String, Option[Array[Byte]])
  class FileTable(tag : Tag) extends Table[FileRecord](tag, tblName("FILE")) {
    def filename = column[String]("FILENAME", O.PrimaryKey, O.DBType("varchar(255)"))
    def content = column[Option[Array[Byte]]]("CONTENT", O.NotNull :: binaryOptions: _*)

    def * = (filename, content)
  }

  val files = TableQuery[FileTable]
}

