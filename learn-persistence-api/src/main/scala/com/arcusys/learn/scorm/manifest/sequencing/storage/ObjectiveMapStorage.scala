package com.arcusys.learn.scorm.manifest.sequencing.storage

import com.arcusys.learn.scorm.manifest.model.ObjectiveMap

trait ObjectiveMapStorage {
  def create(objectiveID: Int, info: ObjectiveMap)
  def delete(objectiveID: Int)
  def get(objectiveID: Int): Option[ObjectiveMap]
  def renew()
}
