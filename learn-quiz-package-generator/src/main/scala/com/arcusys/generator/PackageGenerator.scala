package com.arcusys.generator

trait PackageGenerator {
  def generateZip(courseID: Option[Int], randomOrdering: Boolean, questionsPerUser: Option[Int]): String
}
