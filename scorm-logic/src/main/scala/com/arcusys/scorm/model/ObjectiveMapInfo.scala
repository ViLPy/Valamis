package com.arcusys.scorm.model

class ObjectiveMapInfo(
  /**
   * Identifier of global objective this mapping element points to
   */
  val targetObjectiveIdentifier: String) {
  /**
   * Retrieve satisfaction status from global objective when its progress is defined
   */  
  var readSatisfiedStatus = false
  /**
   * Retrieve normalized measure from global objective when it's defined
   */
  var readNormalizedMeasure = false
  /**
   * Transfer satisfaction status to global objective upon termination of the attempt on the activity
   */
  var writeSatisfiedStatus = false
  /**
   * Transfer normalized measure to global objective upon termination of the attempt on the activity
   */
  var writeNormalizedMeasure = false
  /**
   * Retrieve raw score from global objective during launch of activity
   */
  var readRawScore = false
  /**
   * Retrieve minimum value in the range of the raw score from global objective during launch of activity
   */
  var readMinScore = false
  /**
   * Retrieve maximum value in the range of the raw score from global objective during launch of activity
   */
  var readMaxScore = false
  /**
   * Retrieve completion status from global objective when it's defined
   */
  var readCompletionStatus = false
  /**
   * Retrieve progress measure from global objective when it's defined
   */
  var readProgressMeasure = false
  /**
   * Transfer raw score to global objective upon termination of the attempt on the activity
   */
  var writeRawScore = false
  /**
   * Transfer minimum value in the range of the raw score to global objective upon termination of the attempt on the activity
   */
  var writeMinScore = false
  /**
   * Transfer maximum value in the range of the raw score to global objective upon termination of the attempt on the activity
   */
  var writeMaxScore = false
  /**
   * Transfer completion status to global objective upon termination of the attempt on the activity
   */
  var writeCompletionStatus = false
  /**
   * Transfer progress measure to global objective upon termination of the attempt on the activity
   */
  var writeProgressMeasure = false
}