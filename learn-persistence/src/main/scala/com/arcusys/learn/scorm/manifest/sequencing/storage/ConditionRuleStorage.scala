package com.arcusys.learn.scorm.manifest.sequencing.storage

trait ConditionRuleStorage[T] {
  def create(sequencingID: Int, entity: T)

  def getRules(sequencingID:Int): Seq[T]
}