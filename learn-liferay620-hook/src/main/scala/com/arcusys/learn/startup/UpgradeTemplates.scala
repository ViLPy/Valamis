package com.arcusys.learn.startup

import com.liferay.portal.kernel.events.SimpleAction
import com.liferay.portal.kernel.log.{ LogFactoryUtil, Log }
import com.liferay.portal.kernel.util.{ LocaleUtil, FileUtil, StringPool }
import com.liferay.portal.model.Group
import com.liferay.portal.service.{ ServiceContext, UserLocalServiceUtil, GroupLocalServiceUtil }
import com.liferay.portlet.journal.model.{ JournalTemplate, JournalStructure }
import com.liferay.portlet.journal.{ NoSuchTemplateException, NoSuchStructureException }
import com.liferay.portlet.journal.service.{ JournalTemplateLocalServiceUtil, JournalStructureLocalServiceUtil }
import java.util.Locale
import scala.collection.JavaConverters._

class UpgradeTemplates extends SimpleAction {
  private val _log: Log = LogFactoryUtil.getLog(classOf[UpgradeTemplates])

  override def run(companyIds: Array[String]): Unit = {
    companyIds.foreach(companyId => {
      val group: Group = GroupLocalServiceUtil.getCompanyGroup(companyId.toLong)
      val groupId: Long = group.getGroupId
      val userId: Long = UserLocalServiceUtil.getDefaultUserId(companyId.toLong)

      Upgrade(groupId, userId)
    })
  }

  private def Upgrade(groupId: Long, userId: Long) {
    addStructure(groupId, userId, "ValamisWebContent",
      Map(LocaleUtil.getDefault -> "ValamisWebContent"),
      Map(LocaleUtil.getDefault -> "ValamisWebContent")
    )

    addTemplate(groupId, userId, "ValamisWebContent", "ValamisWebContent",
      Map(LocaleUtil.getDefault -> "ValamisWebContent"),
      Map(LocaleUtil.getDefault -> "ValamisWebContent")
    )
  }

  private def addStructure(groupId: Long, userId: Long, structureId: String,
    nameMap: Map[Locale, String], descriptionMap: Map[Locale, String]) {
    val serviceContext: ServiceContext = new ServiceContext
    serviceContext.setAddGuestPermissions(true)

    val xsd: String = getFileAsString("/structures/" + structureId + ".xml")
    val autoStructureId: Boolean = false
    val parentStructureId: String = StringPool.BLANK

    var structure: JournalStructure = null

    try {
      structure = JournalStructureLocalServiceUtil.getStructure(groupId, structureId)
    } catch {
      case nse: NoSuchStructureException =>
        JournalStructureLocalServiceUtil.addStructure(userId, groupId, structureId, autoStructureId, parentStructureId,
          nameMap.asJava, descriptionMap.asJava, xsd, serviceContext)
        if (_log.isDebugEnabled) {
          _log.debug("Could not find an existing structure. Adding a new structure with id: " + structureId)
        }
    }

    if (structure != null) {
      if (_log.isDebugEnabled) {
        _log.debug("Existing structure found with id: " + structure.getId)
      }
      structure.setUserId(userId)
      structure.setGroupId(groupId)
      structure.setStructureId(structureId)
      //structure.setParentStructureId(parentStructureId)
      structure.setDescriptionMap(descriptionMap.asJava)
      structure.setNameMap(nameMap.asJava)
      structure.setXsd(xsd)
      JournalStructureLocalServiceUtil.updateJournalStructure(structure)
      if (_log.isDebugEnabled) {
        _log.debug("Structure " + structure.getStructureId + " updated successfully.")
      }
    }
  }

  protected def addTemplate(groupId: Long, userId: Long, structureId: String, templateId: String,
    nameMap: Map[Locale, String], descriptionMap: Map[Locale, String]) {
    val serviceContext: ServiceContext = new ServiceContext
    serviceContext.setAddGuestPermissions(true)

    val langType: String = "ftl"
    val xsl: String = getFileAsString("/templates/" + templateId + ".ftl")
    val formatXsl: Boolean = false

    val autoTemplateId: Boolean = false
    val cacheable: Boolean = false

    var template: JournalTemplate = null
    try {
      template = JournalTemplateLocalServiceUtil.getTemplate(groupId, templateId)
    } catch {
      case nte: NoSuchTemplateException =>
        JournalTemplateLocalServiceUtil.addTemplate(userId, groupId, templateId, autoTemplateId, structureId,
          nameMap.asJava, descriptionMap.asJava, xsl, formatXsl, langType, cacheable, false, StringPool.BLANK, null, serviceContext)
        if (_log.isDebugEnabled) {
          _log.debug("Could not find an existing template. Adding a new template with id: " + templateId + " for structure with id: " + structureId)
        }
    }
    if (template != null) {
      if (_log.isDebugEnabled) {
        _log.debug("Existing template found with id: " + template.getId)
      }
      template.setUserId(userId)
      template.setGroupId(groupId)
      template.setTemplateId(templateId)
      template.setStructureId(structureId)
      template.setNameMap(nameMap.asJava)
      template.setDescriptionMap(descriptionMap.asJava)
      template.setXsl(xsl)
      template.setCacheable(cacheable)
      JournalTemplateLocalServiceUtil.updateJournalTemplate(template)
      if (_log.isDebugEnabled) {
        _log.debug("Template " + template.getTemplateId + " updated successfully.")
      }
    }
  }

  protected def getFileAsString(path: String): String = {
    val classLoader = Thread.currentThread().getContextClassLoader
    val is = classLoader.getResourceAsStream(path)
    new String(FileUtil.getBytes(is))
  }
}