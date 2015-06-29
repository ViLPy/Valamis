package com.arcusys.valamis.lesson.scorm.storage.sequencing

import com.arcusys.valamis.lesson.scorm.model.manifest.ObjectiveMap

trait ObjectiveMapStorage {
  def create(objectiveID: Int, info: ObjectiveMap)
  def delete(objectiveID: Int)
  def get(objectiveID: Int): Option[ObjectiveMap]
  def renew()
}
