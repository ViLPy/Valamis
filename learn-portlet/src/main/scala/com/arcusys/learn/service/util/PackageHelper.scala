package com.arcusys.learn.service.util

import com.arcusys.learn.models.valamispackage.PackageModel
import com.arcusys.learn.scorm.manifest.model.{ Manifest, BaseManifest }
import com.arcusys.learn.tincan.manifest.model.TincanManifest

object PackageHelper {
  def toPackageWithLogoUrl(manifest: BaseManifest): BaseManifest = {

    manifest match {
      case tincan: TincanManifest => toPackageWithLogoUrl(tincan)
      case scorm: Manifest        => toPackageWithLogoUrl(scorm)
    }
  }

  def toPackageWithLogoUrl(tincan: TincanManifest): TincanManifest = {
    tincan.copy(logo = Some(getLogoUrl(tincan.id, tincan.logo)))
  }

  def toPackageWithLogoUrl(scorm: Manifest): Manifest = {
    scorm.copy(logo = Some(getLogoUrl(scorm.id, scorm.logo)))
  }

  def toPackageWithLogoUrl(valamisPackage: PackageModel): PackageModel = {
    valamisPackage.copy(logo = Some(getLogoUrl(valamisPackage.id, valamisPackage.logo)))
  }

  def getLogoUrl(packageId: Int, logoNameOption: Option[String]): String = {
    val default = ""
    logoNameOption match {
      case Some("")               => default
      case Some(logoName: String) => "/delegate/files/images?folderId=package_logo_" + packageId + "&file=" + logoName
      case _                      => default
    }
  }
}
