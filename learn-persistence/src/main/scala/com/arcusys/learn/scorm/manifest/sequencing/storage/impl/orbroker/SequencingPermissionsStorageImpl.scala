package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.{GenericEntityStorageImpl, KeyedEntityStorageImpl}
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import org.slf4j.LoggerFactory
import com.arcusys.learn.scorm.manifest.model._
import org.orbroker.Row

class SequencingPermissionsStorageImpl extends GenericEntityStorageImpl[SequencingPermissions]("SequencingPermissions") with SequencingPermissionsStorage {

  def create(sequencingID: Int, entity: SequencingPermissions) {
    create(entity, "sequencingID" -> sequencingID)
  }

  def get(sequencingID: Int): Option[SequencingPermissions] = {
    getOne("sequencingID" -> sequencingID)
  }

  def extract(row: Row) = {
    new SequencingPermissions(
      row.bit("choiceForChildren").get,
      row.bit("choiceForNonDescendants").get,
      row.bit("flowForChildren").get,
      row.bit("forwardOnlyForChildren").get
    )
  }
}
