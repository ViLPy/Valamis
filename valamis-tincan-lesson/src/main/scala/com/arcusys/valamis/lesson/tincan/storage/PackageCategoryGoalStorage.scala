package com.arcusys.valamis.lesson.tincan.storage

import com.arcusys.valamis.lesson.tincan.model.PackageCategoryGoal

trait PackageCategoryGoalStorage {
  def get(packageId: Long): Seq[PackageCategoryGoal]

  def add(goals: Seq[PackageCategoryGoal]): Unit

  def delete(packageId: Long)
}
