package com.arcusys.learn.liferay.services

import com.liferay.counter.service.CounterLocalServiceUtil
import com.liferay.portal.service.{ GroupLocalServiceUtil, UserLocalServiceUtil }
import com.liferay.portal.util.PortalUtil
import com.liferay.portlet.asset.NoSuchVocabularyException
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil
import java.util.{ Date, Locale }

object AssetVocabularyLocalServiceHelper {
  def addAssetVocabulary(companyId: Long, vocabularyName: String) = {
    val globalGroupId = GroupLocalServiceUtil.getCompanyGroup(companyId).getGroupId
    val defaultUserId = UserLocalServiceUtil.getDefaultUserId(companyId.toLong)

    try {
      GroupLocalServiceHelper.getGroupVocabulary(globalGroupId, vocabularyName)
    } catch {
      case e: NoSuchVocabularyException =>
        val newId = CounterLocalServiceUtil.increment()
        val vocabulary = AssetVocabularyLocalServiceUtil.createAssetVocabulary(newId)
        val locale = PortalUtil.getSiteDefaultLocale(globalGroupId)
        val date = new Date()
        val titles = new java.util.HashMap[Locale, String]()
        titles.put(locale, vocabularyName)
        vocabulary.setCompanyId(companyId)
        vocabulary.setGroupId(globalGroupId)
        vocabulary.setTitleMap(titles)
        vocabulary.setDescriptionMap(titles)
        vocabulary.setUserId(defaultUserId)
        vocabulary.setCreateDate(date)
        vocabulary.setModifiedDate(date)
        vocabulary.setName(vocabularyName)

        AssetVocabularyLocalServiceUtil.updateAssetVocabulary(vocabulary)
    }
  }
}
