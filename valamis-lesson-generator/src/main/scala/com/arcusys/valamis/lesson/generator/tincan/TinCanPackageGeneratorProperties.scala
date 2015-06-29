package com.arcusys.valamis.lesson.generator.tincan

class TinCanPackageGeneratorProperties(
    val theme: String,
    val randomOrdering: Boolean,
    val questionsPerUser: Option[Int],
    val scoreLimit: Double) {

  def this(theme: Option[String], randomOrdering: Boolean, questionsPerUser: Option[Int], scoreLimit: Option[Double]) = {
    this(theme.getOrElse("default"), randomOrdering, questionsPerUser, scoreLimit.getOrElse(0.7))
  }

  def this() = this(None, false, None, None)
}
