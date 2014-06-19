package com.arcusys.learn.liferay.service.asset

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.ioc.Configuration
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.liferay.services.{ CounterLocalServiceHelper, ClassNameLocalServiceHelper, AssetEntryLocalServiceHelper }
import com.arcusys.learn.liferay.util.IndexerRegistryUtilHelper
import com.arcusys.learn.liferay.LiferayClasses.LNoSuchEntryException
import com.arcusys.learn.liferay.constants.ContentTypesHelper

class AssetHelper(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  def getAssetFromManifest(man: Manifest) = AssetEntryLocalServiceHelper.getAssetEntry(man.assetRefID.get)

  def deletePackage(entryID: Long) {
    try {
      if (AssetEntryLocalServiceHelper.getAssetEntry(entryID) != null) {
        val indexer = IndexerRegistryUtilHelper.getIndexer(classOf[Manifest])
        indexer.delete(packageStorage.getByRefID(entryID).getOrElse(throw new Exception("Package with refID " + entryID + " can not be found!")))
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

    packageStorage.setAssetRefID(manifest.id, entry.getPrimaryKey)

    val indexer = IndexerRegistryUtilHelper.getIndexer(classOf[Manifest])
    indexer.reindex(packageStorage.getByID(manifest.id).getOrElse(throw new Exception("Can't get updated manifest")))
  }

  //  def addTincanPackage(userID: Long, groupID: Long, manifest: com.arcusys.learn.tincan.manifest.model.Manifest, content: String = "") {
  //    val classNameId = ClassNameLocalServiceUtil.getClassNameId(classOf[com.arcusys.learn.tincan.manifest.model.Manifest].getName)
  //    val classPK = CounterLocalServiceUtil.increment
  //    val entry = AssetEntryLocalServiceUtil.updateEntry(userID, groupID, classOf[com.arcusys.learn.tincan.manifest.model.Manifest].getName,
  //      classPK, "", classNameId, null, null, true, null,
  //      null, null, null, ContentTypes.TEXT_HTML, manifest.title,
  //      content, manifest.summary.getOrElse(""), null, null, 0, 0, null, false)
  //    entry.setClassPK(entry.getPrimaryKey)
  //    AssetEntryLocalServiceUtil.updateAssetEntry(entry)
  //
  //    tincanPackageStorage.setAssetRefID(manifest.id, entry.getPrimaryKey)
  //
  //    val indexer = IndexerRegistryUtil.getIndexer(classOf[com.arcusys.learn.tincan.manifest.model.Manifest])
  //    indexer.reindex(tincanPackageStorage.getByID(manifest.id).getOrElse(throw new Exception("Can't get updated manifest")))
  //  }
  //
  //  def deleteTincanPackage(entryID: Long) {
  //    try {
  //      if (AssetEntryLocalServiceUtil.getAssetEntry(entryID) != null) {
  //        val indexer = IndexerRegistryUtil.getIndexer(classOf[com.arcusys.learn.tincan.manifest.model.Manifest])
  //        indexer.delete(tincanPackageStorage.getByRefID(entryID).getOrElse(throw new Exception("Package with refID " + entryID + " can not be found!")))
  //        AssetEntryLocalServiceUtil.deleteAssetEntry(entryID)
  //      }
  //    } catch {
  //      case e:NoSuchEntryException => System.out.println("Asset not found")
  //    }
  //  }
}
