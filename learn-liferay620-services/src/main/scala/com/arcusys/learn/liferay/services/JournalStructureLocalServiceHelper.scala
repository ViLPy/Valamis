package com.arcusys.learn.liferay.services

import com.liferay.portlet.journal.model.JournalStructure
import java.util.Locale
import com.liferay.portal.service.ServiceContext
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil

object JournalStructureLocalServiceHelper {
  def addStructure(userId: Long,
                   groupId: Long,
                   structureId: String,
                   autoStructureId: Boolean,
                   parentStructureId: String,
                   nameMap: java.util.Map[Locale, String],
                   descriptionMap: java.util.Map[Locale, String],
                   xsd: String,
                   serviceContext: ServiceContext): JournalStructure =
    JournalStructureLocalServiceUtil.addStructure(userId, groupId, structureId, autoStructureId, parentStructureId,
      nameMap, descriptionMap, xsd, serviceContext)
}
