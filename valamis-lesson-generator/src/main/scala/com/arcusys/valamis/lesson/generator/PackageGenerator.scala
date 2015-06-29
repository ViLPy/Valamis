package com.arcusys.valamis.lesson.generator

import java.io.File

//Is used to track all PackageGenerators
trait GenericPackageGenerator

trait PackageGenerator extends GenericPackageGenerator {
  def generateZip(courseID: Option[Int]): File
}
