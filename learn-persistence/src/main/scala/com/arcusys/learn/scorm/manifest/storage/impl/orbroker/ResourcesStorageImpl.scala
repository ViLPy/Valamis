package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.storage._
import com.arcusys.learn.storage.impl.orbroker._
import impl.ResourceEntityStorage
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.questionbank.storage.impl.QuestionCategoryEntityStorage

class ResourcesStorageImpl extends KeyedEntityStorageBaseImpl[Resource]("Resource", "id") with ResourceEntityStorage with ResourcesStorageExtractor

trait ResourcesStorageExtractor extends RowExtractor[Resource] {
  def extract(row: Row) = {
    val id = row.string("identifierRef").get
    val href = row.string("href")
    val base = row.string("base")
    if (row.string("scormType").getOrElse("").toLowerCase.equals("sco")) new ScoResource(id, href.get, base, Nil, Nil)
    else new AssetResource(id, href, base, Nil, Nil)
  }
}