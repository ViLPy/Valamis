package com.arcusys.learn.liferay.service

import com.liferay.portal.kernel.search.{IndexerRegistryUtil, HitsOpenSearchImpl}
import com.arcusys.learn.scorm.manifest.model._

class OpenSearchImpl extends HitsOpenSearchImpl {
  val SEARCH_PATH = "/c/projectlearn/open_search"
  val TITLE = "Project Learn Search: "

  def getSearchPath = SEARCH_PATH

  def getPortletId = PackageIndexer.PORTLET_ID

  def getTitle(keywords: String) = (TITLE + keywords)

  override def getIndexer = IndexerRegistryUtil.getIndexer(classOf[Manifest])
}
