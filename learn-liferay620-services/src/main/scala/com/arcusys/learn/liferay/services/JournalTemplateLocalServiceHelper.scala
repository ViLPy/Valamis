package com.arcusys.learn.liferay.services

import com.liferay.portlet.journal.model.JournalTemplate
import java.util.Locale
import com.liferay.portal.service.ServiceContext
import java.io.File
import com.liferay.portlet.journal.service.JournalTemplateLocalServiceUtil

object JournalTemplateLocalServiceHelper {
  def addTemplate(userId: Long,
    groupId: Long,
    templateId: String,
    autoTemplateId: Boolean,
    structureId: String,
    nameMap: java.util.Map[Locale, String],
    descriptionMap: java.util.Map[Locale, String],
    xsl: String,
    formatXsl: Boolean,
    langType: String,
    cacheable: Boolean,
    smallImage: Boolean,
    smallImageURL: String,
    smallImageFile: File,
    serviceContext: ServiceContext): JournalTemplate =
    JournalTemplateLocalServiceUtil.addTemplate(userId, groupId, templateId, autoTemplateId, structureId, nameMap,
      descriptionMap, xsl, formatXsl, langType, cacheable, smallImage, smallImageURL, smallImageFile, serviceContext)
}
