package com.arcusys.learn.liferay.service

import com.arcusys.learn.liferay.LiferayClasses.LHitsOpenSearchImpl
import com.arcusys.learn.liferay.util.IndexerRegistryUtilHelper
import com.arcusys.valamis.lesson.scorm.model.manifest.Manifest

class OpenSearchImpl extends LHitsOpenSearchImpl {
  val SEARCH_PATH = "/c/projectlearn/open_search"
  val TITLE = "Project Learn Search: "

  def getSearchPath = SEARCH_PATH

  def getPortletId = PackageIndexer.PORTLET_ID

  def getTitle(keywords: String) = TITLE + keywords

  override def getIndexer = IndexerRegistryUtilHelper.getIndexer(classOf[Manifest])
}
