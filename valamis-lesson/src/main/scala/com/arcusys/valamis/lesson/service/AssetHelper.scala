package com.arcusys.valamis.lesson.service

import com.arcusys.learn.liferay.LiferayClasses.LNoSuchEntryException
import com.arcusys.learn.liferay.constants.ContentTypesHelper
import com.arcusys.learn.liferay.services.{ AssetEntryLocalServiceHelper, ClassNameLocalServiceHelper, CounterLocalServiceHelper }
import com.arcusys.learn.liferay.util.IndexerRegistryUtilHelper
import com.arcusys.valamis.lesson.model.BaseManifest
import com.arcusys.valamis.lesson.scorm.model
import com.arcusys.valamis.lesson.scorm.model.manifest
import com.arcusys.valamis.lesson.scorm.model.manifest.Manifest
import com.arcusys.valamis.lesson.scorm.storage.ScormPackagesStorage
import com.arcusys.valamis.lesson.tincan.model.TincanManifest
import com.arcusys.valamis.lesson.tincan.storage.TincanPackageStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class AssetHelper(implicit val bindingModule: BindingModule) extends Injectable {

  lazy val scormRepository = inject[ScormPackagesStorage]
  lazy val tincanRepository = inject[TincanPackageStorage]
  lazy val packageService = inject[ValamisPackageService]

  def deletePackageAssetEntry(entryId: Long, manifest: BaseManifest) {
    try {
      if (AssetEntryLocalServiceHelper.getAssetEntry(entryId) != null) {
        val indexer = IndexerRegistryUtilHelper.getIndexer(classOf[model.manifest.Manifest])
        indexer.delete(manifest)
        AssetEntryLocalServiceHelper.deleteAssetEntry(entryId)
      }
    } catch {
      case e: LNoSuchEntryException => System.out.println("Asset not found")
    }
  }

  def addTincanPackageAssetEntry(userId: Long, groupId: Long, packageId: Long, title: String, summary: Option[String]): Long = {
    val assetRefId = createAsset(userId, groupId, title, summary)

    tincanRepository.setAssetRefID(packageId, assetRefId)
    val newManifest = packageService.getPackage(packageId)
    val indexer = IndexerRegistryUtilHelper.getIndexer(classOf[TincanManifest])
    if (indexer != null) indexer.reindex(newManifest)

    assetRefId
  }

  def addScormPackageAssetEntry(userId: Long, groupId: Long, packageId: Long, title: String, summary: Option[String]): Long = {
    val assetRefId = createAsset(userId, groupId, title, summary)

    scormRepository.setAssetRefID(packageId, assetRefId)
    val newManifest = packageService.getPackage(packageId)
    val indexer = IndexerRegistryUtilHelper.getIndexer(classOf[manifest.Manifest])
    if (indexer != null) indexer.reindex(newManifest)

    assetRefId
  }

  private def createAsset(userId: Long, groupId: Long, title: String, description: Option[String]): Long = {
    val content: String = ""
    val categoriesIds: Array[Long] = null

    val classNameId = ClassNameLocalServiceHelper.getClassNameId(classOf[manifest.Manifest].getName)
    val classPK = CounterLocalServiceHelper.increment
    val entry = AssetEntryLocalServiceHelper.updateEntry(userId, groupId, classOf[Manifest].getName,
      classPK, "", classNameId, categoriesIds, null, visible = true, null,
      null, null, null, ContentTypesHelper.TEXT_HTML, title,
      content, description.getOrElse(""), null, null, 0, 0, null, sync = false)
    entry.setClassPK(entry.getPrimaryKey)
    AssetEntryLocalServiceHelper.updateAssetEntry(entry)

    entry.getPrimaryKey
  }
}
