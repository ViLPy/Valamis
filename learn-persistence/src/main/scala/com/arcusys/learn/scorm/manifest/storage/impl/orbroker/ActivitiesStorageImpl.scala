package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.storage._
import com.arcusys.learn.storage.impl.orbroker._
import impl.{ActivityCreator, ActivityEntityStorage}
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker._


class ActivitiesStorageImpl extends GenericEntityStorageImpl[Activity]("Activity") with ActivityEntityStorage with ActivityExtractor with ActivityCreator{
  val sequencingStorage = new SequencingStorageImpl
  val dataStorage = new ActivityDataStorageImpl
}

trait ActivityExtractor extends RowExtractor[Activity] {
  def extract(row: Row) = {
    createActivity(row.string("identifierRef").getOrElse(""),  row.string("id").get, row.string("title").get , row.integer("packageID").get,
                  row.string("organizationID").get, row.string("parentID"),row.string("hideLMSUI").get,row.bit("visible").get,
                  row.string("resourceParameters"),row.string("masteryScore"), row.string("maxTimeAllowed"))
  }

  def createActivity(identifierRef: String, id: String, title: String, packageID: Int, organizationId: String, parentId: Option[String],
                     hideLMSUI: String, visible: Boolean, resourceParameters: Option[String], masteryScore: Option[String], maxTimeAllowed: Option[String]): Activity

}
