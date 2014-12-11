package com.arcusys.learn.bl.services.lesson

import com.arcusys.learn.bl.exceptions.PassingLimitExceededException
import com.arcusys.learn.bl.services.LessonLimitChecker
import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.scorm.manifest.storage.ScormPackagesStorage
import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage
import com.arcusys.learn.tincan.manifest.storage.{ TincanManifestActivityStorage, TincanPackageStorage }
import com.arcusys.learn.tincan.model.lrsClient.LrsEndpointSettings
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portal.model.User

// TODO refactor with lesson package
class PackageService(configuration: BindingModule) extends PackageServiceContract with Injectable {

  implicit val bindingModule = configuration
  private val packageRepository = inject[ScormPackagesStorage]
  private val passingLimitChecker = inject[LessonLimitChecker]
  private val tincanPackageRepository = inject[TincanPackageStorage]
  private val tincanActivityStorage = inject[TincanManifestActivityStorage]
  private val tincanLrsEndpointRepository = inject[TincanLrsEndpointStorage]

  def this() = this(DomainConfiguration)

  override def getTincanLaunchWithLimitTest(packageId: Int, user: User): String = {

    val tincanPackage = tincanPackageRepository.getByID(packageId)
    if (!tincanPackage.isDefined)
      throw new UnsupportedOperationException()

    if (!passingLimitChecker.checkTincanPackage(user, packageId))
      throw new PassingLimitExceededException

    val activities = tincanActivityStorage.getByPackageID(packageId)
    val firstActivity = activities.find(a => a.launch != null && !a.launch.isEmpty).getOrElse(throw new UnsupportedOperationException("tincan package without launch not supported"))

    val mainFileName = "data/" + tincanPackage.get.id + "/" + firstActivity.launch.get
    mainFileName
  }

  override def getScormManifest(packageId: Int) = {
    packageRepository.getByID(packageId).get
  }

  override def setTincanEndpoint(endpointSettings: LrsEndpointSettings): Unit = {
    tincanLrsEndpointRepository.set(Some(endpointSettings))
  }

  override def removeTincanEndpoint(): Unit = {
    tincanLrsEndpointRepository.set(None)
  }

  override def getTincanEndpoint(): Option[LrsEndpointSettings] = {
    tincanLrsEndpointRepository.get
  }
}
