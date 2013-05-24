package com.arcusys.learn.scorm.tracking.states.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker.ObjectiveMapStorageImpl
import com.arcusys.learn.scorm.tracking.model.ObjectiveState
import com.arcusys.learn.scorm.tracking.states.storage.impl.{ObjectiveStateCreator, ObjectiveStateEntityStorage, ObjectiveStateFieldsMapper}

class ObjectiveStateStorageImpl extends GenericEntityStorageImpl[(Option[String], ObjectiveState)]("ObjectiveState") with ObjectiveStateEntityStorage with ObjectiveStateStorageExtractor with ObjectiveStateCreator {
  val objectiveMapStorage = new ObjectiveMapStorageImpl()
}

trait ObjectiveStateStorageExtractor extends RowExtractor[(Option[String], ObjectiveState)] {
  def extract(row: Row) = {
    val mapper = new ObjectiveStateFieldsMapper {
      def mapKey: Option[String] = row.string("mapKey")

      def objectiveID: Option[Int] = row.integer("objectiveID")

      def satisfied: Option[Boolean] = row.bit("satisfied")

      def normalizedMeasure: Option[BigDecimal] = row.decimal("normalizedMeasure").map(BigDecimal(_))
    }

    createObjectiveState(mapper)
  }

  def createObjectiveState(mapper: ObjectiveStateFieldsMapper): (Option[String], ObjectiveState)
}
