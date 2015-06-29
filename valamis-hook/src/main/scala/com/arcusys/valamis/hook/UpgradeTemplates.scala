package com.arcusys.valamis.hook

import java.util.Locale

import com.liferay.portal.kernel.events.SimpleAction
import com.liferay.portal.kernel.log.{Log, LogFactoryUtil}
import com.liferay.portal.kernel.util.{FileUtil, LocaleUtil}
import com.liferay.portal.model.Group
import com.liferay.portal.service.{ClassNameLocalServiceUtil, ServiceContext, GroupLocalServiceUtil, UserLocalServiceUtil}
import com.liferay.portlet.dynamicdatamapping.model.{DDMTemplate, DDMTemplateConstants, DDMStructure, DDMStructureConstants}
import com.liferay.portlet.dynamicdatamapping.service.{DDMTemplateLocalServiceUtil, DDMStructureLocalServiceUtil}
import com.liferay.portlet.journal.model.JournalArticle
import scala.collection.JavaConverters._
import com.liferay.portal.kernel.template.TemplateConstants._


class UpgradeTemplates extends SimpleAction {
  private val _log: Log = LogFactoryUtil.getLog(classOf[UpgradeTemplates])

  override def run(companyIds: Array[String]): Unit = {
    _log.info("SAVE VALAMIS WEB CONTENT TEMPLATE ")

    companyIds.foreach(companyId => {
      val group: Group = GroupLocalServiceUtil.getCompanyGroup(companyId.toLong)
      val groupId: Long = group.getGroupId
      val userId: Long = UserLocalServiceUtil.getDefaultUserId(companyId.toLong)

      Upgrade(groupId, userId)
    })
  }

  private def Upgrade(groupId: Long, userId: Long) {
    val structureId = addStructure(
      groupId,
      userId,
      "ValamisWebContent",
      Map(LocaleUtil.getDefault -> "ValamisWebContent"),
      Map(LocaleUtil.getDefault -> "ValamisWebContent"),
      getFileAsString("structures/ValamisWebContent.xml")
    )

    addTemplate(
      groupId,
      userId,
      structureId,
      "ValamisWebContent",
      Map(LocaleUtil.getDefault -> "ValamisWebContent"),
      Map(LocaleUtil.getDefault -> "ValamisWebContent"),
      getFileAsString("templates/ValamisWebContent.ftl"),
      LANG_TYPE_FTL
    )
  }
  
  private def getFileAsString(path: String): String = {
    val classLoader = Thread.currentThread().getContextClassLoader
    val is = classLoader.getResourceAsStream(path)
    new String(FileUtil.getBytes(is))
  }

  private def addStructure(groupId: Long, userId: Long, structureKey: String, nameMap: Map[Locale, String], descriptionMap: Map[Locale, String], xsd: String): Long = {

    val serviceContext: ServiceContext = new ServiceContext
    serviceContext.setAddGuestPermissions(true)

    val structureClassNameId = ClassNameLocalServiceUtil.getClassNameId(classOf[JournalArticle])

    DDMStructureLocalServiceUtil.fetchStructure(groupId, structureClassNameId, structureKey) match {
      case null =>
        val newStructure = DDMStructureLocalServiceUtil.addStructure(userId, groupId,
          DDMStructureConstants.DEFAULT_PARENT_STRUCTURE_ID, structureClassNameId, structureKey,
          nameMap.asJava, descriptionMap.asJava, xsd, "xml", DDMStructureConstants.TYPE_DEFAULT, serviceContext)

        _log.info("Could not find an existing structure. Adding a new structure with id: " + structureKey)

        newStructure.getStructureId
      case structure: DDMStructure =>
        _log.info("Existing structure found with id: " + structure.getStructureId)

        structure.setXsd(xsd)

        DDMStructureLocalServiceUtil.updateStructure(
          structure.getStructureId,
          DDMStructureConstants.DEFAULT_PARENT_STRUCTURE_ID,
          nameMap.asJava,
          descriptionMap.asJava, xsd, serviceContext)

        _log.info("Structure " + structure.getStructureId + " updated successfully.")

        structure.getStructureId
    }
  }

  private def addTemplate(groupId: Long, userId: Long, structureId: Long, templateKey: String,
                  nameMap: Map[Locale, String], descriptionMap: Map[Locale, String], body: String, langType: String): Unit = {

    val serviceContext: ServiceContext = new ServiceContext
    serviceContext.setAddGuestPermissions(true)

    val templateClassNameId = ClassNameLocalServiceUtil.getClassNameId(classOf[DDMStructure])

    DDMTemplateLocalServiceUtil.fetchTemplate(groupId, templateClassNameId, templateKey, true) match {
      case null =>
        DDMTemplateLocalServiceUtil.addTemplate(userId, groupId,
          templateClassNameId, structureId,
          templateKey, nameMap.asJava, descriptionMap.asJava,
          DDMTemplateConstants.TEMPLATE_TYPE_DISPLAY, null, langType,
          body, true, false, null, null, serviceContext)

        _log.info("Could not find an existing template. Adding a new template with id: " + templateKey + " for structure with id: " + structureId)

      case template: DDMTemplate =>
        _log.info("Existing template found with id: " + template.getTemplateId)

        DDMTemplateLocalServiceUtil.updateTemplate(
          template.getTemplateId, structureId,
          nameMap.asJava, descriptionMap.asJava,
          DDMTemplateConstants.TEMPLATE_TYPE_DISPLAY, null, LANG_TYPE_FTL,
          body, true, false, null, null, serviceContext)

        _log.info("Template " + template.getTemplateId + " updated successfully.")
    }
  }
}