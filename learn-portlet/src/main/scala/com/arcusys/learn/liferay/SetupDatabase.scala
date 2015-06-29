package com.arcusys.learn.liferay

import com.arcusys.learn.ioc.Configuration
import com.arcusys.valamis.certificate.schema._
import com.arcusys.valamis.core.{SlickDBInfo, SlickProfile}
import com.arcusys.valamis.file.FileTableComponent
import com.arcusys.valamis.lesson.PackageCategoryGoalTableComponent
import com.arcusys.valamis.lrs.TokenTableComponent
import com.arcusys.valamis.social.schema.{CommentTableComponent, LikeTableComponent}
import com.escalatesoft.subcut.inject.{BindingModule, Injectable}
import com.liferay.portal.kernel.events.SimpleAction
import scala.slick.jdbc.meta._

class SetupDatabase extends SimpleAction {
  override def run(companyIds: Array[String]): Unit = {
    new SlickDbCreator()(Configuration).create()
  }
}

class SlickDbCreator(
    implicit val bindingModule: BindingModule)
  extends Injectable
  with LikeTableComponent
  with CommentTableComponent
  with CertificateTableComponent
  with ActivityGoalTableComponent
  with CourseGoalTableComponent
  with PackageGoalTableComponent
  with StatementGoalTableComponent
  with CertificateStateTableComponent
  with FileTableComponent
  with TokenTableComponent
  with PackageCategoryGoalTableComponent
  with SlickProfile {

  val slickDBInfo = inject[SlickDBInfo]
  val db = slickDBInfo.databaseDef
  val driver = slickDBInfo.slickProfile

  import driver.simple._

  val tables = Seq(
    certificates, activityGoals, courseGoals, packageGoals, statementGoals, certificateStates,
    files,
    tokens,
    packageCategoryGoals,
    likes, comments
  )

  // this code runs after each deploy we need to check tables before creation
  // todo: run this only on first deploy
  def create() : Unit =
    db.withTransaction { implicit session =>
      tables
        .filter(t => MTable.getTables(t.baseTableRow.tableName).firstOption.isEmpty)
        .foreach(_.ddl.create)
    }
}