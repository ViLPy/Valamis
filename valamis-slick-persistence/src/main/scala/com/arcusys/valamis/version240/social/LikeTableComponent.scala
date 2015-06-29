package com.arcusys.valamis.version240.social

import com.arcusys.valamis.core.DbNameUtils._
import com.github.tototoshi.slick.GenericJodaSupport
import org.joda.time.DateTime

import scala.slick.driver.{JdbcDriver, JdbcProfile}

trait LikeTableComponent {
  protected val driver: JdbcProfile
  import driver.simple._

  type Like = (Long, Long, Long, Option[Long], DateTime)
  class LikeTable(tag: Tag) extends Table[Like](tag, tblName("LIKE")) {
    val jodaMapper = new GenericJodaSupport(driver.asInstanceOf[JdbcDriver])
    import jodaMapper._

    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def companyId = column[Long]("COMPANY_ID")
    def userId = column[Long]("USER_ID")
    def creationDate = column[DateTime]("CREATION_DATE")
    def activityId = column[Long]("ACTIVITY_ID")

    def userActivityIndex = index(indxName("LIKE_UID_S_SID"), (userId, activityId), unique = true)
    def * = (companyId, userId, activityId, id.?, creationDate)
  }

  val likes = TableQuery[LikeTable]
}