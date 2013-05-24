package com.arcusys.learn.scorm.tracking.storage

trait DataModelStorage
{
  def getKeyedValues(attemptID: Int, activityID: String): Map[String, Option[String]]
  def getValuesByKey(attemptID: Int, key: String): Map[String, Option[String]]
  def getValue(attemptID: Int, activityID: String, key: String): Option[String]
  def getCollectionValues(attemptID: Int, activityID: String, key: String): Map[String, Option[String]]
  def setValue(attemptID: Int, activityID: String, key: String, value: String)
  def renew()
}
