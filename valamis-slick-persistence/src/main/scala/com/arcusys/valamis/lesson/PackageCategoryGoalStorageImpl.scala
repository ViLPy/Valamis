package com.arcusys.valamis.lesson

import com.arcusys.valamis.lesson.tincan.model.PackageCategoryGoal
import com.arcusys.valamis.lesson.tincan.storage.PackageCategoryGoalStorage

import scala.slick.driver.JdbcProfile
import scala.slick.jdbc.JdbcBackend

class PackageCategoryGoalStorageImpl(db: JdbcBackend#DatabaseDef, val driver: JdbcProfile)
  extends PackageCategoryGoalStorage
  with PackageCategoryGoalTableComponent{

  import driver.simple._

  override def get(packageId: Long): Seq[PackageCategoryGoal] = db.withSession{ implicit session =>
    packageCategoryGoals.filter(_.packageId === packageId).list
  }

  override def delete(packageId: Long): Unit = db.withSession { implicit session =>
    packageCategoryGoals.filter(_.packageId === packageId).delete
  }

  override def add(goals: Seq[PackageCategoryGoal]): Unit = db.withSession { implicit session =>
    packageCategoryGoals ++= goals
  }
}
