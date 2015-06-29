package com.arcusys.learn.liferay.services

import com.liferay.portlet.asset.model.AssetEntry
import com.liferay.portlet.asset.service.{ AssetCategoryLocalServiceUtil, AssetEntryLocalServiceUtil }
import java.util.Date

object AssetEntryLocalServiceHelper {
  def getAssetEntry(entryId: Long): AssetEntry = AssetEntryLocalServiceUtil.getAssetEntry(entryId)

  def deleteAssetEntry(entryId: Long): AssetEntry = AssetEntryLocalServiceUtil.deleteAssetEntry(entryId)

  def updateEntry(userId: Long,
    groupId: Long,
    className: String,
    classPK: Long,
    classUuid: String,
    classTypeId: Long,
    categoryIds: Array[Long],
    tagNames: Array[String],
    visible: Boolean,
    startDate: Date,
    endDate: Date,
    publishDate: Date,
    expirationDate: Date,
    mimeType: String,
    title: String,
    description: String,
    summary: String,
    url: String,
    layoutUuid: String,
    height: Int,
    width: Int,
    priority: java.lang.Integer,
    sync: Boolean) =
    AssetEntryLocalServiceUtil.updateEntry(userId, groupId, className, classPK, classUuid, classTypeId,
      categoryIds, tagNames, visible, startDate, endDate, publishDate, expirationDate, mimeType, title,
      description, summary, url, layoutUuid, height, width, priority, sync)

  def updateAssetEntry(assetEntry: AssetEntry): AssetEntry =
    AssetEntryLocalServiceUtil.updateAssetEntry(assetEntry)

  def setAssetCategories(entryId: Long, categoryIds: Array[Long]) = {
    if (!categoryIds.isEmpty)
      categoryIds.map(categoryId => AssetCategoryLocalServiceUtil.setAssetEntryAssetCategories(entryId, categoryIds))
    else
      AssetCategoryLocalServiceUtil.clearAssetEntryAssetCategories(entryId)
  }

  def addAssetCategories(entryId: Long, categoryIds: Array[Long]) =
    categoryIds.map(categoryId => AssetCategoryLocalServiceUtil.addAssetEntryAssetCategories(entryId, categoryIds))

  def removeAssetCategories(entryId: Long, categoryIds: Array[Long]) =
    categoryIds.map(categoryId => AssetCategoryLocalServiceUtil.deleteAssetEntryAssetCategories(entryId, categoryIds))
}
