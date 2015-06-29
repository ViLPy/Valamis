package com.arcusys.learn.liferay.services

import java.util.Locale

import com.liferay.counter.service.CounterLocalServiceUtil
import com.liferay.portal.service.UserLocalServiceUtil
import com.liferay.portal.util.PortalUtil
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil

object AssetCategoryLocalServiceHelper {
  def addAssetCategory(companyId: Long, name: String) = {
    val vocabularyName = "ValamisPackageTags"
    val newId = CounterLocalServiceUtil.increment()
    val category = AssetCategoryLocalServiceUtil.createAssetCategory(newId)

    val globalGroupId = GroupLocalServiceHelper.getCompanyGroup(companyId).getGroupId
    val assetVocabularyId = GroupLocalServiceHelper.getGroupVocabulary(globalGroupId, vocabularyName).getVocabularyId

    val locale = PortalUtil.getSiteDefaultLocale(globalGroupId)

    val titles = new java.util.HashMap[Locale, String]()
    titles.put(locale, name)

    category.setVocabularyId(assetVocabularyId)
    category.setGroupId(globalGroupId)
    category.setTitleMap(titles)
    category.setDescriptionMap(titles)
    category.setUserId(UserLocalServiceUtil.getDefaultUserId(companyId))
    category.setParentCategoryId(0)
    category.setName(name)

    AssetCategoryLocalServiceUtil.updateAssetCategory(category)
  }
}
