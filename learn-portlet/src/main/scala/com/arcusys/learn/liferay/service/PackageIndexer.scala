package com.arcusys.learn.liferay.service

import asset.AssetHelper
import javax.portlet.PortletURL
import java.util.Locale
import com.arcusys.learn.scorm.manifest.model._
import java.util
import com.arcusys.learn.ioc.InjectableFactory
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.FieldHelper
import com.arcusys.learn.liferay.util.{ ValidatorHelper, StringUtilHelper, GetterUtilHelper, SearchEngineUtilHelper }
import com.arcusys.learn.liferay.helpers.IndexerHelper

object PackageIndexer {
  val PORTLET_ID: String = utils.PortletKeys.SCORM_PACKAGE
  private final val CLASS_NAMES: Array[String] = Array[String](classOf[Manifest].getName)
}

class PackageIndexer extends IndexerHelper with InjectableFactory {
  lazy val packageStorage = storageFactory.packageStorage
  lazy val assetHelper = new AssetHelper()

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
      case s: Manifest    => s
      case a: LAssetEntry => packageStorage.getByRefID(a.getClassPK).getOrElse(obj.asInstanceOf[Manifest])
      case _              => obj.asInstanceOf[Manifest]
    }
    deleteDocument(assetHelper.getAssetFromManifest(pkg).getCompanyId, pkg.assetRefID.get)
  }

  protected def doGetDocument(obj: Object) = {
    val pkg = obj match {
      case s: Manifest    => s
      case a: LAssetEntry => packageStorage.getByRefID(a.getClassPK).getOrElse(obj.asInstanceOf[Manifest])
      case _              => obj.asInstanceOf[Manifest]
    }

    val document = new LDocumentImpl
    val asset = assetHelper.getAssetFromManifest(pkg)
    document.addUID(PackageIndexer.PORTLET_ID, pkg.assetRefID.get)
    document.addKeyword(FieldHelper.COMPANY_ID, asset.getCompanyId)
    document.addKeyword(FieldHelper.ENTRY_CLASS_NAME, classOf[Manifest].getName)
    document.addKeyword(FieldHelper.ENTRY_CLASS_PK, pkg.assetRefID.get)
    document.addKeyword(FieldHelper.PORTLET_ID, PackageIndexer.PORTLET_ID)
    document.addKeyword(FieldHelper.GROUP_ID, asset.getGroupId)

    //document.addText(Field.CONTENT, HtmlUtil.extractText(pkg.summary))
    document.addText(FieldHelper.DESCRIPTION, asset.getSummary)
    document.addText(FieldHelper.TITLE, asset.getTitle)
    document
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
      case s: Manifest    => s
      case a: LAssetEntry => packageStorage.getByRefID(a.getClassPK).getOrElse(obj.asInstanceOf[Manifest])
      case _              => obj.asInstanceOf[Manifest]
    }
    SearchEngineUtilHelper.updateDocument(getSearchEngineId, assetHelper.getAssetFromManifest(pkg).getCompanyId, getDocument(pkg))
  }

  protected def doReindex(className: String, classPK: Long) {
    val pkg = packageStorage.getByRefID(classPK).getOrElse(throw new Exception("Can't find Manifest with ID " + classPK))
    reindexPackages(pkg)
  }

  protected def doReindex(ids: Array[String]) {
    val companyId: Long = GetterUtilHelper.getLong(ids(0))
    reindexPackages(companyId)
  }

  protected def getPortletId(searchContext: LSearchContext): String = PackageIndexer.PORTLET_ID

  protected def reindexPackages(pkg: Manifest) {
    val documents = new util.ArrayList[LDocument]
    documents.add(getDocument(pkg))
    SearchEngineUtilHelper.updateDocuments(getSearchEngineId, assetHelper.getAssetFromManifest(pkg).getCompanyId, documents)
  }

  protected def reindexPackages(companyId: Long) {
    reindexKBArticles(companyId, 0, 0)
  }

  protected def reindexKBArticles(companyId: Long, startKBArticleId: Long, endKBArticleId: Long) {
    val packages = packageStorage.getAll.filter(pkg => pkg.assetRefID.isDefined && assetHelper.getAssetFromManifest(pkg).getCompanyId == companyId)
    val documents = new java.util.ArrayList[LDocument]
    for (pkg <- packages) {
      val document = doGetDocument(pkg)
      documents.add(document)
    }
    SearchEngineUtilHelper.updateDocuments(getSearchEngineId, companyId, documents)
  }

}