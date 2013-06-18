package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import com.arcusys.learn.scorm.manifest.model._
import impl.{SequencingPermissionsEntityStorage, SequencingTrackingEntityStorage}
import org.orbroker.{RowExtractor, Row}

class SequencingPermissionsStorageImpl extends GenericEntityStorageImpl[SequencingPermissions]("SequencingPermissions") with SequencingPermissionsEntityStorage with SequencingPermissionsExtractor

trait SequencingPermissionsExtractor extends RowExtractor[SequencingPermissions] {
  def extract(row: Row) = {
    new SequencingPermissions(
      row.bit("choiceForChildren").get,
      row.bit("choiceForNonDescendants").get,
      row.bit("flowForChildren").get,
      row.bit("forwardOnlyForChildren").get
    )
  }
}
