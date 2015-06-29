package com.arcusys.learn.scorm.manifest.sequencing.storage.impl

import com.arcusys.learn.storage.impl.EntityStorageExt
import com.arcusys.valamis.lesson.scorm.model.manifest.ObjectiveMap
import com.arcusys.valamis.lesson.scorm.storage.sequencing.ObjectiveMapStorage

/**
 * User: Yulia.Glushonkova
 * Date: 29.03.13
 */
trait ObjectiveMapEntityStorage extends ObjectiveMapStorage with EntityStorageExt[ObjectiveMap] {
  def get(objectiveID: Int): Option[ObjectiveMap] = getOne("objectiveID" -> objectiveID)

  def create(objectiveID: Int, entity: ObjectiveMap) {
    create(entity, "objectiveID" -> objectiveID)
  }

  def delete(objectiveID: Int) { delete("objectiveID" -> objectiveID) }
}
