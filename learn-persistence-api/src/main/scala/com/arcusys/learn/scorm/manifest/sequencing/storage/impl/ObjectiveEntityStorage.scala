package com.arcusys.learn.scorm.manifest.sequencing.storage.impl

import com.arcusys.learn.storage.impl.{ KeyedEntityStorageExt, EntityStorageExt }
import com.arcusys.valamis.lesson.scorm.model.manifest.Objective
import com.arcusys.valamis.lesson.scorm.storage.sequencing.{ ObjectiveStorage, ObjectiveMapStorage }

/**
 * User: Yulia.Glushonkova
 * Date: 01.04.13
 */
trait ObjectiveFieldsMapper {
  def identifier: Option[String]
  def satisfiedByMeasure: Boolean
  def minNormalizedMeasure: BigDecimal
}
trait ObjectiveEntityCreator {
  def mapStorage: ObjectiveMapStorage

  def createObjective(id: Int, mapper: ObjectiveFieldsMapper): Objective = {
    import mapper._
    val globalObjectiveMap = mapStorage.get(id)
    require(globalObjectiveMap.isDefined, "Objective should have globalObjectiveMap")
    new Objective(identifier, satisfiedByMeasure, minNormalizedMeasure, globalObjectiveMap.get)
  }
}

trait ObjectiveEntityStorage extends ObjectiveStorage with KeyedEntityStorageExt[Objective] with EntityStorageExt[Objective] {

  def mapStorage: ObjectiveMapStorage

  def create(sequencingID: Int, objective: Objective, isPrimary: Boolean) {
    val objectiveID = createAndGetID(objective, "sequencingID" -> sequencingID, "isPrimary" -> isPrimary)
    mapStorage.create(objectiveID, objective.globalObjectiveMap)
  }

  def getPrimary(sequencingID: Int) = {
    getOne("sequencingID" -> sequencingID, "isPrimary" -> true)
  }

  def getNonPrimary(sequencingID: Int): Seq[Objective] =
    getAll("sequencingID" -> sequencingID, "isPrimary" -> false)

}
