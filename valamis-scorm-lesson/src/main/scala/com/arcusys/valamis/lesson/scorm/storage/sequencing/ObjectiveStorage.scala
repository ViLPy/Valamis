package com.arcusys.valamis.lesson.scorm.storage.sequencing

import com.arcusys.valamis.lesson.scorm.model.manifest.Objective

trait ObjectiveStorage {
  def create(sequencingID: Int, objective: Objective, isPrimary: Boolean)

  def getPrimary(sequencingID: Int): Option[Objective]

  def getNonPrimary(sequencingID: Int): Seq[Objective]
  def renew()
}
