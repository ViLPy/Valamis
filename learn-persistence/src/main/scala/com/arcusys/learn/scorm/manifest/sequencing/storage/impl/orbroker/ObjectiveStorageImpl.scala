package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageImpl
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import org.orbroker.Row

class ObjectiveStorageImpl extends KeyedEntityStorageImpl[Objective]("Objective", "id") with ObjectiveStorage {
  private val mapStorage = new ObjectiveMapStorageImpl

  def create(sequencingID: Int, objective: Objective, isPrimary: Boolean) {
    val objectiveID = createAndGetID(objective, "sequencingID" -> sequencingID, "isPrimary" -> isPrimary)
    mapStorage.create(objectiveID, objective.globalObjectiveMap)
  }

  def getPrimary(sequencingID: Int) = {
    getOne("sequencingID" -> sequencingID, "isPrimary" -> true)
  }

  def getNonPrimary(sequencingID: Int): Seq[Objective] =
    getAll("sequencingID" -> sequencingID, "isPrimary" -> false)

  def extract(row: Row) = {
    val globalObjectiveMap = mapStorage.get(row.integer("id").get)
    require(globalObjectiveMap.isDefined, "Objective should have globalObjectiveMap")
    new Objective(
      row.string("identifier"),
      row.bit("satisfiedByMeasure").get,
      row.decimal("minNormalizedMeasure").get,
      globalObjectiveMap.get
    )
  }
}
