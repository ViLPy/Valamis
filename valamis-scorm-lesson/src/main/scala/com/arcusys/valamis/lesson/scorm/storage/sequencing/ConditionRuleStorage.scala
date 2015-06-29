package com.arcusys.valamis.lesson.scorm.storage.sequencing

trait ConditionRuleStorage[T] {
  def create(sequencingID: Int, entity: T)
  def getRules(sequencingID: Int): Seq[T]
  def renew()
}
