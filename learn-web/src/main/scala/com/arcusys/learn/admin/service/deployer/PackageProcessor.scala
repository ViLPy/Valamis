package com.arcusys.learn.admin.service.deployer

import org.scala_tools.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.liferay.service.asset.AssetHelper
import com.arcusys.learn.storage.StorageFactoryContract

case class ProcessResult(packageId:Int, packageType:String)

class PackageProcessor(implicit val bindingModule: BindingModule) extends Injectable {
  val storageFactory = inject[StorageFactoryContract]

  def processPackageAndGetID(packageTitle: String, packageSummary: String, packageTmpUUID: String, courseID: Option[Int], userID: Long, groupID: Long) : ProcessResult = {
    if (com.arcusys.scorm.deployer.PackageProcessor.isValidPackage(packageTmpUUID)) {
      val packageID = new com.arcusys.scorm.deployer.PackageProcessor().processPackageAndGetID(packageTitle, packageSummary, packageTmpUUID, courseID)
      if (groupID != -1) new AssetHelper().addPackage(userID, groupID, storageFactory.packageStorage.getByID(packageID).getOrElse(throw new Exception("Can't find newly created package")))
      ProcessResult(packageID, "scorm")
    }
    else if (com.arcusys.tincan.deployer.PackageProcessor.isValidPackage(packageTmpUUID)) {
      val packageID = new com.arcusys.tincan.deployer.PackageProcessor().processPackageAndGetID(packageTitle, packageSummary, packageTmpUUID, courseID)
      //if (groupID != -1) new AssetHelper().addTincanPackage(userID, groupID, storageFactory.tincanPackageStorage.getByID(packageID).getOrElse(throw new Exception("Can't find newly created package")))
      ProcessResult(packageID, "tincan")
    }
    else {
      throw new RuntimeException("unsupport package")
    }

  }
}
