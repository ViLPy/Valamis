package com.arcusys.learn.liferay.util

import com.liferay.portal.kernel.search.{ SearchEngineUtil, Document }

object SearchEngineUtilHelper {
  def updateDocuments(searchEngineId: String,
    companyId: Long,
    documents: java.util.Collection[Document]) =
    SearchEngineUtil.updateDocuments(searchEngineId, companyId, documents)

  def updateDocument(searchEngineId: String,
    companyId: Long,
    document: Document) =
    SearchEngineUtil.updateDocument(searchEngineId, companyId, document)
}
