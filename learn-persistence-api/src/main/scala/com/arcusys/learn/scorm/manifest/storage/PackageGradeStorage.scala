package com.arcusys.learn.scorm.manifest.storage

import com.arcusys.learn.scorm.manifest.model.PackageGrade

/**
 * Created by guestAdmin on 26.04.14.
 */
trait PackageGradeStorage {
  def get(valamisUserId: Long, packageId: Long): Option[PackageGrade]
}
