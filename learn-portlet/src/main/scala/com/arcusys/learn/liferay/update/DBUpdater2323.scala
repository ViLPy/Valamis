package com.arcusys.learn.liferay.update

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses.LUpgradeProcess
import com.arcusys.valamis.core.SlickDBInfo
import com.arcusys.valamis.social.schema.{CommentTableComponent, LikeTableComponent}
import com.escalatesoft.subcut.inject.Injectable

import scala.slick.driver.JdbcProfile

class DBUpdater2323 extends LUpgradeProcess with Injectable {
  implicit lazy val bindingModule = Configuration

  override def getThreshold = 2323

  override def doUpgrade(): Unit = {
    val dbInfo = inject[SlickDBInfo]

    new LikeTableComponent with CommentTableComponent {
      override val driver: JdbcProfile = dbInfo.slickProfile
      import driver.simple._

      dbInfo.databaseDef.withSession { implicit session =>
        (likes.ddl ++ comments.ddl).create
      }
    }
  }
}
