package com.arcusys.learn.scorm.manifest.sequencing.storage

import com.arcusys.learn.scorm.manifest.model.Objective

trait ObjectiveStorage {
  def create(sequencingID: Int, objective: Objective, isPrimary: Boolean)

  def getPrimary(sequencingID: Int): Option[Objective]

  def getNonPrimary(sequencingID: Int): Seq[Objective]
  def renew()
}
