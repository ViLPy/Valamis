package com.arcusys.valamis.lrs

import com.arcusys.valamis.core.DbNameUtils._
import com.arcusys.valamis.core.TypeMapper
import com.arcusys.valamis.lrsEndpoint.model.LrsToken
import org.joda.time.DateTime

import scala.slick.driver.JdbcProfile

trait TokenTableComponent {

  protected val driver: JdbcProfile
  import driver.simple._

  class TokenTable(tag : Tag) extends Table[LrsToken](tag, tblName("TOKEN")) with TypeMapper {
    def token = column[String]("TOKEN", O.PrimaryKey, O.DBType("varchar(255)"))
    def authInfo = column[String]("AUTH", O.NotNull, O.DBType("varchar(512)"))
    def authType = column[String]("TYPE", O.NotNull, O.DBType("varchar(512)"))
    def created = column[DateTime]("CREATED", O.NotNull)

    def * = (token, authInfo, authType, created) <> (LrsToken.tupled, LrsToken.unapply)
  }

  val tokens = TableQuery[TokenTable]
}
