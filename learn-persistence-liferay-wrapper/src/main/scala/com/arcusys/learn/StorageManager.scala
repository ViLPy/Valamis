package com.arcusys.learn

import com.arcusys.learn.persistence.liferay.service._

/**
 * Created by Iliya Tryapitsin on 16.05.2014.
 */
class StorageManager extends StorageManagerContract {
  def renew() = {
    // Remove packages
    LFPackageLocalServiceUtil.removeAll()
    LFPackageGradeStorageLocalServiceUtil.removeAll()

    // Remove certificates
    LFCertificateCourseLocalServiceUtil.removeAll()
    LFCertificateUserLocalServiceUtil.removeAll()
    LFCertificateLocalServiceUtil.removeAll()
  }
}
