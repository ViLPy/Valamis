package com.arcusys.learn.liferay.service

import asset.AssetHelper
import com.liferay.portal.kernel.search._
import javax.portlet.PortletURL
import java.util.Locale
import com.liferay.portlet.asset.model.AssetEntry
import com.arcusys.learn.scorm.manifest.model._
import com.liferay.portal.kernel.util._
import com.liferay.portal.kernel.dao.orm.DynamicQuery
import com.liferay.portal.security.permission.PermissionChecker
import java.util
import com.arcusys.learn.ioc.InjectableFactory

object PackageIndexer {
  val PORTLET_ID: String = utils.PortletKeys.SCORM_PACKAGE
  private final val CLASS_NAMES: Array[String] = Array[String](classOf[Manifest].getName)
}

class PackageIndexer extends BaseIndexer with InjectableFactory {
  lazy val packageStorage = storageFactory.packageStorage
  lazy val assetHelper = new AssetHelper()

  def getClassNames: Array[String] = PackageIndexer.CLASS_NAMES

  def getPortletId: String = PackageIndexer.PORTLET_ID

  override def postProcessSearchQuery(searchQuery: BooleanQuery, searchContext: SearchContext) {
    addSearchTerm(searchQuery, searchContext, Field.CONTENT, true)
    addSearchTerm(searchQuery, searchContext, Field.TITLE, true)
  }

  override def search(searchContext: SearchContext): Hits = {
    val hits = super.search(searchContext)
    val queryTerms: Array[String] = hits.getQueryTerms
    hits.setQueryTerms(queryTerms)
    hits
  }

  protected def addReindexCriteria(dynamicQuery: DynamicQuery, companyId: Long) {
  }

  protected def doDelete(obj: Object) {
    val pkg = obj match {
      case s: Manifest => s
      case a: AssetEntry => packageStorage.getByRefID(a.getClassPK).getOrElse(obj.asInstanceOf[Manifest])
      case _ => obj.asInstanceOf[Manifest]
    }
    deleteDocument(assetHelper.getAssetFromManifest(pkg).getCompanyId, pkg.assetRefID.get)
  }

  protected def doGetDocument(obj: Object) = {
    val pkg = obj match {
      case s: Manifest => s
      case a: AssetEntry => packageStorage.getByRefID(a.getClassPK).getOrElse(obj.asInstanceOf[Manifest])
      case _ => obj.asInstanceOf[Manifest]
    }

    val document = new DocumentImpl
    val asset = assetHelper.getAssetFromManifest(pkg)
    document.addUID(PackageIndexer.PORTLET_ID, pkg.assetRefID.get)
    document.addKeyword(Field.COMPANY_ID, asset.getCompanyId)
    document.addKeyword(Field.ENTRY_CLASS_NAME, classOf[Manifest].getName)
    document.addKeyword(Field.ENTRY_CLASS_PK, pkg.assetRefID.get)
    document.addKeyword(Field.PORTLET_ID, PackageIndexer.PORTLET_ID)
    document.addKeyword(Field.GROUP_ID, asset.getGroupId)

    //document.addText(Field.CONTENT, HtmlUtil.extractText(pkg.summary))
    document.addText(Field.DESCRIPTION, asset.getSummary)
    document.addText(Field.TITLE, asset.getTitle)
    document
  }

  protected def doGetSummary(document: Document, locale: Locale, snippet: String, portletURL: PortletURL): Summary = {
    val title = document.get(Field.TITLE)
    val content = {
      if (Validator.isNull(snippet) && Validator.isNull(document.get(Field.DESCRIPTION))) StringUtil.shorten(document.get(Field.CONTENT), 200)
      else if (Validator.isNull(snippet)) document.get(Field.DESCRIPTION)
      else snippet
    }

    val resourcePrimKey = document.get(Field.ENTRY_CLASS_PK)
    portletURL.setParameter("resourcePrimKey", resourcePrimKey)
    new Summary(title, content, portletURL)
  }

  protected def doReindex(obj: Object) {
    val pkg = obj match {
      case s: Manifest => s
      case a: AssetEntry => packageStorage.getByRefID(a.getClassPK).getOrElse(obj.asInstanceOf[Manifest])
      case _ => obj.asInstanceOf[Manifest]
    }
    SearchEngineUtil.updateDocument(getSearchEngineId, assetHelper.getAssetFromManifest(pkg).getCompanyId, getDocument(pkg))
  }

  protected def doReindex(className: String, classPK: Long) {
    val pkg = packageStorage.getByRefID(classPK).getOrElse(throw new Exception("Can't find Manifest with ID " + classPK))
    reindexPackages(pkg)
  }

  protected def doReindex(ids: Array[String]) {
    val companyId: Long = GetterUtil.getLong(ids(0))
    reindexPackages(companyId)
  }

  protected def getPortletId(searchContext: SearchContext): String = PackageIndexer.PORTLET_ID

  protected def reindexPackages(pkg: Manifest) {
    val documents = new util.ArrayList[Document]
    documents.add(getDocument(pkg))
    SearchEngineUtil.updateDocuments(getSearchEngineId, assetHelper.getAssetFromManifest(pkg).getCompanyId, documents)
  }

  protected def reindexPackages(companyId: Long) {
    reindexKBArticles(companyId, 0, 0)
  }

  protected def reindexKBArticles(companyId: Long, startKBArticleId: Long, endKBArticleId: Long) {
    val packages = packageStorage.getAll.filter(pkg => pkg.assetRefID.isDefined && assetHelper.getAssetFromManifest(pkg).getCompanyId == companyId)
    val documents = new java.util.ArrayList[Document]
    for (pkg <- packages) {
      val document = doGetDocument(pkg)
      documents.add(document)
    }
    SearchEngineUtil.updateDocuments(getSearchEngineId, companyId, documents)
  }

  override def hasPermission(permissionChecker: PermissionChecker, entryClassName: String, entryClassPK: Long, actionId: String): Boolean = {
    true
  }
}