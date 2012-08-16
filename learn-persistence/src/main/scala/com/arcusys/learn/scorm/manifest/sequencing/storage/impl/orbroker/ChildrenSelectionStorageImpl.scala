package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import org.orbroker.Row

class ChildrenSelectionStorageImpl extends GenericEntityStorageImpl[ChildrenSelection]("ChildrenSelection") with ChildrenSelectionStorage {
  def create(sequencingID: Int, entity: ChildrenSelection) {
    create(entity, "sequencingID"->sequencingID)
  }

  def get(sequencingID: Int): Option[ChildrenSelection] = getOne("sequencingID"->sequencingID)

  def extract(row: Row) = {
    val takeCount = row.integer("takeCount")
    val takeTiming = row.string("takeTimingOnEachAttempt")
    val take = if (takeCount.isDefined && takeTiming.isDefined)
      Some(new ChildrenSelectionTake(takeCount.get, RandomizationTimingType.withName(takeTiming.get)))
    else None

    val reorder = row.string("reorderOnEachAttempt")

    new ChildrenSelection(
      take,
      reorder match {
        case Some(param) => Some(RandomizationTimingType.withName(param))
        case _ => None
      }
    )
  }
}
