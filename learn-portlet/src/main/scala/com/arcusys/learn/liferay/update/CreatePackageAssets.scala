package com.arcusys.learn.liferay.update

/**
 * Created by aklimov on 05.02.15.
 */

import com.arcusys.learn.liferay.services.{ GroupLocalServiceHelper, UserLocalServiceHelper }
import com.arcusys.valamis.lesson.scorm.storage.ScormPackagesStorage
import com.arcusys.valamis.lesson.service.{ PackageService, AssetHelper }
import com.arcusys.valamis.lesson.tincan.storage.TincanPackageStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portal.kernel.log.{ Log, LogFactoryUtil }

class CreatePackageAssets(implicit val bindingModule: BindingModule) extends Injectable {
  private val _log: Log = LogFactoryUtil.getLog(classOf[CreatePackageAssets])
  val packageRepository = inject[ScormPackagesStorage]
  val tincanRepository = inject[TincanPackageStorage]
  private val packageService = new PackageService()

  def run(companyIds: Seq[Long]): Unit = {
    companyIds.foreach(companyId => {
      val defaultUserId = UserLocalServiceHelper().getDefaultUserId(companyId)
      val groupId = GroupLocalServiceHelper.getCompanyGroup(companyId).getGroupId
      createAssetRefs(companyId, groupId, defaultUserId)
    })
  }

  private def createAssetRefs(companyId: Long, groupId: Long, userId: Long) {
    val courseIds = packageService.getAllCourseIDs(companyId)
    val scormPackages = packageRepository.getAllForInstance(courseIds)
    val tincanPackages = tincanRepository.getAllForInstance(courseIds)

    scormPackages.map(p =>
      p.assetRefId match {
        case None => new AssetHelper().addScormPackageAssetEntry(userId, groupId, p.id, p.title, p.summary)
        case _    => ""
      }
    )
    tincanPackages.map(p =>
      p.assetRefId match {
        case None => new AssetHelper().addTincanPackageAssetEntry(userId, groupId, p.id, p.title, p.summary)
        case _    => ""
      }
    )
  }
}