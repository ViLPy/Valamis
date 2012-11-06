package com.arcusys.learn.liferay.service.asset

import com.arcusys.learn.scorm.manifest.model._
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil
import com.liferay.portal.service.ClassNameLocalServiceUtil
import com.liferay.counter.service.CounterLocalServiceUtil
import com.liferay.portal.kernel.search.IndexerRegistryUtil
import com.liferay.portal.kernel.util.ContentTypes
import com.arcusys.learn.storage.impl.orbroker.StorageFactory

object AssetHelper {
  def getAssetFromManifest(man: Manifest) = AssetEntryLocalServiceUtil.getAssetEntry(man.assetRefID.get)

  def deletePackage(entryID: Long) {
    val indexer = IndexerRegistryUtil.getIndexer(classOf[Manifest])
    indexer.delete(StorageFactory.packageStorage.getByRefID(entryID).getOrElse(throw new Exception("Package with refID " + entryID + " can not be found!")))
    AssetEntryLocalServiceUtil.deleteAssetEntry(entryID)
  }

  def addPackage(userID: Long, groupID: Long, manifest: Manifest, content: String = "") {
    val classNameId = ClassNameLocalServiceUtil.getClassNameId(classOf[Manifest].getName)
    val classPK = CounterLocalServiceUtil.increment
    val entry = AssetEntryLocalServiceUtil.updateEntry(userID, groupID, classOf[Manifest].getName,
      classPK , "", classNameId, null, null, true, null,
      null, null, null, ContentTypes.TEXT_HTML, manifest.title,
      content, manifest.summary.getOrElse(""), null, null, 0, 0, null, false)
    entry.setClassPK(entry.getPrimaryKey)
    AssetEntryLocalServiceUtil.updateAssetEntry(entry)

    StorageFactory.packageStorage.setAssetRefID(manifest.id, entry.getPrimaryKey)

    val indexer = IndexerRegistryUtil.getIndexer(classOf[Manifest])
    indexer.reindex(StorageFactory.packageStorage.getByID(manifest.id).getOrElse(throw new Exception("Can't get updated manifest")))
  }
}
