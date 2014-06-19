package com.arcusys.learn.scorm.manifest.sequencing.storage.impl

import com.arcusys.learn.scorm.manifest.sequencing.storage.{ ObjectiveMapStorage, SequencingPermissionsStorage }
import com.arcusys.learn.storage.impl.EntityStorageExt
import com.arcusys.learn.scorm.manifest.model.{ ObjectiveMap, SequencingPermissions }

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
