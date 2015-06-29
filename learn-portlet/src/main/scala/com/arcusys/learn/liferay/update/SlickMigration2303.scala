package com.arcusys.learn.liferay.update

import com.arcusys.learn.liferay.update.migration.{CertificateStorageMigration2303, FileStorageMigration2303}
import com.arcusys.valamis.core.{SlickDBInfo, SlickProfile}
import com.arcusys.valamis.version240.certificate._
import com.arcusys.valamis.version240.file._
import com.arcusys.valamis.version240.lrs._
import com.arcusys.valamis.version240.lesson._
import com.escalatesoft.subcut.inject.{Injectable, BindingModule}


class SlickMigration2303(
    implicit val bindingModule: BindingModule)
  extends CertificateTableComponent
  with ActivityGoalTableComponent
  with CourseGoalTableComponent
  with PackageGoalTableComponent
  with StatementGoalTableComponent
  with CertificateStateTableComponent
  with FileTableComponent
  with TokenTableComponent
  with PackageCategoryGoalTableComponent
  with SlickProfile
  with Injectable {

  val slickDBInfo = inject[SlickDBInfo]
  val db = slickDBInfo.databaseDef
  val driver = slickDBInfo.slickProfile

  val tables2303 = Seq(
    certificates, activityGoals, courseGoals, packageGoals, statementGoals, certificateStates,
    files,
    tokens
  )

  import driver.simple._

  def migrate() {
    db.withTransaction { implicit session =>
      tables2303
        .foreach(_.ddl.create)
    }

    new FileStorageMigration2303(db, driver).migrate()
    new CertificateStorageMigration2303(db, driver).migrate()
  }
}