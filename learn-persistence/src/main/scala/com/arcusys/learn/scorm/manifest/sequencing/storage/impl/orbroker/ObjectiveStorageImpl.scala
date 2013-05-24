package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageBaseImpl
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import impl.{ObjectiveFieldsMapper, ObjectiveEntityCreator, ObjectiveEntityStorage}
import org.orbroker.{RowExtractor, Row}

class ObjectiveStorageImpl extends KeyedEntityStorageBaseImpl[Objective]("Objective", "id") with ObjectiveEntityStorage with ObjectiveExtractor with ObjectiveEntityCreator{
  val mapStorage: ObjectiveMapStorage = new ObjectiveMapStorageImpl
}


trait ObjectiveExtractor extends RowExtractor[Objective] {
  def mapStorage: ObjectiveMapStorage
  def extract(row: Row) = {
    val mapper = new ObjectiveFieldsMapper {
      def identifier =  row.string("identifier")
      def minNormalizedMeasure = row.decimal("minNormalizedMeasure").get
      def satisfiedByMeasure = row.bit("satisfiedByMeasure").get
    }
    createObjective(row.integer("id").get, mapper)
  }
  def createObjective(id: Int, mapper: ObjectiveFieldsMapper): Objective
}
