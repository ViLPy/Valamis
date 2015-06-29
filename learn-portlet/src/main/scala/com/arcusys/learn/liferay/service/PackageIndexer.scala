package com.arcusys.learn.liferay.service

import javax.portlet.PortletURL
import java.util.Locale
import com.arcusys.learn.liferay.services.AssetEntryLocalServiceHelper
import java.util
import com.arcusys.learn.ioc.InjectableFactory
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.FieldHelper
import com.arcusys.learn.liferay.util.{ ValidatorHelper, StringUtilHelper, GetterUtilHelper, SearchEngineUtilHelper }
import com.arcusys.learn.liferay.helpers.IndexerHelper
import com.arcusys.valamis.lesson.model.BaseManifest
import com.arcusys.valamis.lesson.scorm.model.manifest
import com.arcusys.valamis.lesson.scorm.model.manifest.Manifest
import com.arcusys.valamis.lesson.scorm.storage.ScormPackagesStorage
import com.arcusys.valamis.lesson.tincan.model.TincanManifest
import com.arcusys.valamis.lesson.tincan.storage.TincanPackageStorage

object PackageIndexer {
  val PORTLET_ID: String = utils.PortletKeys.SCORM_PACKAGE
  private final val CLASS_NAMES: Array[String] = Array[String](classOf[manifest.Manifest].getName, classOf[TincanManifest].getName, classOf[BaseManifest].getName)
}

//TODO remove repository using
class PackageIndexer extends IndexerHelper with InjectableFactory {
  lazy val packageRepository = inject[ScormPackagesStorage]
  lazy val tincanRepository = inject[TincanPackageStorage]

  def getClassNames: Array[String] = PackageIndexer.CLASS_NAMES

  def getPortletId: String = PackageIndexer.PORTLET_ID

  override def postProcessSearchQuery(searchQuery: LBooleanQuery, searchContext: LSearchContext) {
    addSearchTerm(searchQuery, searchContext, FieldHelper.CONTENT, true)
    addSearchTerm(searchQuery, searchContext, FieldHelper.TITLE, true)
  }

  override def search(searchContext: LSearchContext): LHits = {
    val hits = super.search(searchContext)
    val queryTerms: Array[String] = hits.getQueryTerms
    hits.setQueryTerms(queryTerms)
    hits
  }

  protected def addReindexCriteria(dynamicQuery: LDynamicQuery, companyId: Long) {
  }

  protected def doDelete(obj: Object) {
    val pkg = obj match {
      case s: manifest.Manifest => s
      case t: TincanManifest    => t
      case a: LAssetEntry       => packageRepository.getByRefID(a.getClassPK).getOrElse(obj.asInstanceOf[manifest.Manifest])
      case _                    => obj.asInstanceOf[manifest.Manifest]
    }
    for (refId <- pkg.assetRefId) {
      val assetEntry = AssetEntryLocalServiceHelper.getAssetEntry(refId)
      deleteDocument(assetEntry.getCompanyId, refId)
    }
  }

  protected def doGetDocument(obj: Object) = {
    val pkg = obj match {
      case s: manifest.Manifest => s
      case t: TincanManifest    => t
      case a: LAssetEntry       => packageRepository.getByRefID(a.getClassPK).getOrElse(obj.asInstanceOf[manifest.Manifest])
      case _                    => obj.asInstanceOf[manifest.Manifest]
    }
    pkg.assetRefId.map(refId => {
      val document = new LDocumentImpl
      val asset = AssetEntryLocalServiceHelper.getAssetEntry(refId)
      document.addUID(PackageIndexer.PORTLET_ID, refId)
      document.addKeyword(FieldHelper.COMPANY_ID, asset.getCompanyId)
      document.addKeyword(FieldHelper.ENTRY_CLASS_NAME, classOf[manifest.Manifest].getName)
      document.addKeyword(FieldHelper.ENTRY_CLASS_PK, refId)
      document.addKeyword(FieldHelper.PORTLET_ID, PackageIndexer.PORTLET_ID)
      document.addKeyword(FieldHelper.GROUP_ID, asset.getGroupId)

      //document.addText(Field.CONTENT, HtmlUtil.extractText(pkg.summary))
      document.addText(FieldHelper.DESCRIPTION, asset.getSummary)
      document.addText(FieldHelper.TITLE, asset.getTitle)
      document
    }).orNull
  }

  protected def doGetSummary(document: LDocument, locale: Locale, snippet: String, portletURL: PortletURL): LSummary = {
    val title = document.get(FieldHelper.TITLE)
    val content = {
      if (ValidatorHelper.isNull(snippet) && ValidatorHelper.isNull(document.get(FieldHelper.DESCRIPTION))) StringUtilHelper.shorten(document.get(FieldHelper.CONTENT), 200)
      else if (ValidatorHelper.isNull(snippet)) document.get(FieldHelper.DESCRIPTION)
      else snippet
    }

    val resourcePrimKey = document.get(FieldHelper.ENTRY_CLASS_PK)
    portletURL.setParameter("resourcePrimKey", resourcePrimKey)
    new LSummary(title, content, portletURL)
  }

  protected def doReindex(obj: Object) {
    val pkg = obj match {
      case s: manifest.Manifest => s
      case t: TincanManifest    => t
      case a: LAssetEntry       => packageRepository.getByRefID(a.getClassPK).getOrElse(tincanRepository.getByRefID(a.getClassPK).getOrElse(obj.asInstanceOf[manifest.Manifest]))
      case _                    => obj.asInstanceOf[Manifest]
    }
    for (refId <- pkg.assetRefId) {
      val assetEntry = AssetEntryLocalServiceHelper.getAssetEntry(refId)
      SearchEngineUtilHelper.updateDocument(getSearchEngineId, assetEntry.getCompanyId, getDocument(pkg))
    }
  }

  protected def doReindex(className: String, classPK: Long) {
    val pkg = packageRepository.getByRefID(classPK).getOrElse(tincanRepository.getByRefID(classPK).getOrElse(throw new Exception("Can't find Manifest with ID " + classPK)))
    reindexPackages(pkg)
  }

  protected def doReindex(ids: Array[String]) {
    val companyId: Long = GetterUtilHelper.getLong(ids(0))
    reindexPackages(companyId)
  }

  protected def getPortletId(searchContext: LSearchContext): String = PackageIndexer.PORTLET_ID

  protected def reindexPackages(pkg: BaseManifest) {
    val documents = new util.ArrayList[LDocument]
    documents.add(getDocument(pkg))
    for (refId <- pkg.assetRefId) {
      val assetEntry = AssetEntryLocalServiceHelper.getAssetEntry(refId)
      SearchEngineUtilHelper.updateDocuments(getSearchEngineId, assetEntry.getCompanyId, documents)
    }
  }

  protected def reindexPackages(companyId: Long) {
    reindexKBArticles(companyId, 0, 0)
  }

  protected def reindexKBArticles(companyId: Long, startKBArticleId: Long, endKBArticleId: Long) {
    val packages = packageRepository.getAll.filter(pkg => pkg.assetRefId.isDefined && AssetEntryLocalServiceHelper.getAssetEntry(pkg.assetRefId.get).getCompanyId == companyId)
    val documents = new java.util.ArrayList[LDocument]
    for (pkg <- packages) {
      val document = doGetDocument(pkg)
      documents.add(document)
    }
    SearchEngineUtilHelper.updateDocuments(getSearchEngineId, companyId, documents)
  }

}