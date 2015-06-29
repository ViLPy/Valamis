package com.arcusys.valamis.lesson.service

import com.arcusys.learn.liferay.services.{ AssetCategoryLocalServiceHelper, AssetEntryLocalServiceHelper, AssetVocabularyLocalServiceHelper, GroupLocalServiceHelper }
import com.arcusys.valamis.lesson.model.ValamisTag
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portlet.asset.NoSuchVocabularyException
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil

import scala.collection.JavaConverters._

/**
 * Created by Yuriy Gatilin on 29.01.15.
 */
class TagService(implicit val bindingModule: BindingModule) extends TagServiceContract with Injectable {

  val vocabularyName = "ValamisPackageTags"

  def getAll(companyId: Long): Seq[ValamisTag] = {
    val globalGroupId = GroupLocalServiceHelper.getCompanyGroup(companyId).getGroupId
    try {
      val assetVocabulary = GroupLocalServiceHelper.getGroupVocabulary(globalGroupId, vocabularyName)
      val categories = AssetCategoryLocalServiceUtil.getVocabularyRootCategories(assetVocabulary.getVocabularyId, -1, -1, null)
        .asScala.map(cat => ValamisTag(cat.getCategoryId, cat.getName)).toSeq
      categories
    } catch {
      case e: NoSuchVocabularyException =>
        AssetVocabularyLocalServiceHelper.addAssetVocabulary(companyId, vocabularyName)
        getAll(companyId)
    }
  }

  def getEntryTags(entryId: Long): Seq[ValamisTag] = {
    val entry = AssetEntryLocalServiceHelper.getAssetEntry(entryId)
    val categories = entry.getCategories.asScala.map(cat => ValamisTag(cat.getCategoryId, cat.getName)).toSeq
    categories
  }

  def assignTags(entryId: Long, tagsId: Seq[Long]) = {
    AssetEntryLocalServiceHelper.setAssetCategories(entryId, tagsId.toArray) // feel the difference between add/set
  }

  def unassignTags(entryId: Long, tagsId: Seq[Long]) = {
    AssetEntryLocalServiceHelper.removeAssetCategories(entryId, tagsId.toArray)
  }

  def getTagIds(rawIds: Seq[String], companyId: Long): Seq[Long] = {
    val existingTags = getAll(companyId)

    for (tag <- rawIds) yield {
      if (existingTags.exists(_.id.toString == tag))
        tag.toLong
      else {
        val assetCategory = AssetCategoryLocalServiceHelper.addAssetCategory(companyId, tag)
        assetCategory.getCategoryId
      }
    }
  }
}