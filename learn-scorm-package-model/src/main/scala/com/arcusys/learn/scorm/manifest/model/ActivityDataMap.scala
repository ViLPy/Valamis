package com.arcusys.learn.scorm.manifest.model

/**
 * Shared data associated with leaf activity
 * @param targetId        ID of shared data targeted for the mapping
 * @param readSharedData  If true, activity utilizes currently available shared data while it's active
 * @param writeSharedData If true, shared data should be persisted upon termination of the activity
 */
class ActivityDataMap(
  val targetId: String,
  val readSharedData: Boolean,
  val writeSharedData: Boolean)