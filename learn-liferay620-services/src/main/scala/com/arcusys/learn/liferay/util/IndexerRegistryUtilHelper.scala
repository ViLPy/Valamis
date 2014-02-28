package com.arcusys.learn.liferay.util

import com.liferay.portal.kernel.search.{IndexerRegistryUtil, Indexer}

object IndexerRegistryUtilHelper {
  def getIndexer(clazz: Class[_]): Indexer = IndexerRegistryUtil.getIndexer(clazz)
}
