package com.arcusys.valamis.gradebook.storage

import com.arcusys.valamis.gradebook.model.PackageGrade

trait PackageGradesStorage {
  def get(userId: Long, packageId: Long): Option[PackageGrade]

  def delete(userId: Long, packageId: Long): Unit

  def modify(entity: PackageGrade): PackageGrade

  def create(entity: PackageGrade): PackageGrade
}
