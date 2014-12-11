package com.arcusys.learn.bl.liferay.service.asset

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.liferay.util.IndexerRegistryUtilHelper
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.storage.ScormPackagesStorage
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.arcusys.learn.liferay.services.{ CounterLocalServiceHelper, ClassNameLocalServiceHelper, AssetEntryLocalServiceHelper }
import com.arcusys.learn.liferay.LiferayClasses.LNoSuchEntryException
import com.arcusys.learn.liferay.constants.ContentTypesHelper

class AssetHelper(configuration: BindingModule) extends Injectable {
  implicit val bindingModule = configuration

  def this() = this(DomainConfiguration)

  val packageRepository = inject[ScormPackagesStorage]

  def getAssetFromManifest(man: Manifest) = AssetEntryLocalServiceHelper.getAssetEntry(man.assetRefID.get)

  def deletePackage(entryID: Long) {
    try {
      if (AssetEntryLocalServiceHelper.getAssetEntry(entryID) != null) {
        val indexer = IndexerRegistryUtilHelper.getIndexer(classOf[Manifest])
        indexer.delete(packageRepository.getByRefID(entryID).getOrElse(throw new Exception("Package with refID " + entryID + " can not be found!")))
        AssetEntryLocalServiceHelper.deleteAssetEntry(entryID)
      }
    } catch {
      case e: LNoSuchEntryException => System.out.println("Asset not found")
    }
  }

  def addPackage(userID: Long, groupID: Long, manifest: Manifest, content: String = "") {
    val classNameId = ClassNameLocalServiceHelper.getClassNameId(classOf[Manifest].getName)
    val classPK = CounterLocalServiceHelper.increment
    val entry = AssetEntryLocalServiceHelper.updateEntry(userID, groupID, classOf[Manifest].getName,
      classPK, "", classNameId, null, null, true, null,
      null, null, null, ContentTypesHelper.TEXT_HTML, manifest.title,
      content, manifest.summary.getOrElse(""), null, null, 0, 0, null, false)
    entry.setClassPK(entry.getPrimaryKey)
    AssetEntryLocalServiceHelper.updateAssetEntry(entry)

    packageRepository.setAssetRefID(manifest.id, entry.getPrimaryKey)

    val indexer = IndexerRegistryUtilHelper.getIndexer(classOf[Manifest])
    indexer.reindex(packageRepository.getByID(manifest.id).getOrElse(throw new Exception("Can't get updated manifest")))
  }
}
