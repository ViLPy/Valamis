package com.arcusys.learn.scorm.manifest.model

/**
 * A map from local objective to global objectives
 * @param readSatisfiedStatusFrom   ID of global objective to retrieve satisfaction status from when its progress is defined
 * @param readNormalizedMeasureFrom ID of global objective to retrieve normalized measure from when it's defined
 * @param writeSatisfiedStatusTo    ID of global objective to transfer satisfaction status to upon termination of the attempt on the activity
 * @param writeNormalizedMeasureTo  ID of global objective to transfer normalized measure to upon termination of the attempt on the activity
 * @param readRawScoreFrom          ID of global objective to retrieve raw score from during launch of activity
 * @param readMinScoreFrom          ID of global objective to retrieve minimum value in the range of the raw score from during launch of activity
 * @param readMaxScoreFrom          ID of global objective to retrieve maximum value in the range of the raw score from during launch of activity
 * @param readCompletionStatusFrom  ID of global objective to retrieve completion status from when it's defined
 * @param readProgressMeasureFrom   ID of global objective to retrieve progress measure from when it's defined
 * @param writeRawScoreTo           ID of global objective to transfer raw score to upon termination of the attempt on the activity
 * @param writeMinScoreTo           ID of global objective to transfer minimum value in the range of the raw score to upon termination of the attempt on the activity
 * @param writeMaxScoreTo           ID of global objective to transfer maximum value in the range of the raw score to upon termination of the attempt on the activity
 * @param writeCompletionStatusTo   ID of global objective to transfer completion status to upon termination of the attempt on the activity
 * @param writeProgressMeasureTo    ID of global objective to transfer progress measure to upon termination of the attempt on the activity
 */
class ObjectiveMap
(
  val readSatisfiedStatusFrom: Option[String] = None,
  val readNormalizedMeasureFrom: Option[String] = None,
  val writeSatisfiedStatusTo: Option[String] = None,
  val writeNormalizedMeasureTo: Option[String] = None,
  val readRawScoreFrom: Option[String] = None,
  val readMinScoreFrom: Option[String] = None,
  val readMaxScoreFrom: Option[String] = None,
  val readCompletionStatusFrom: Option[String] = None,
  val readProgressMeasureFrom: Option[String] = None,
  val writeRawScoreTo: Option[String] = None,
  val writeMinScoreTo: Option[String] = None,
  val writeMaxScoreTo: Option[String] = None,
  val writeCompletionStatusTo: Option[String] = None,
  val writeProgressMeasureTo: Option[String] = None
  )

/**
 * Factory for objective map
 */
object ObjectiveMap {
  /**
   * Pre-constructed empty map
   */
  val Empty = new ObjectiveMap()
}
