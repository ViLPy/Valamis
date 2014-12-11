package com.arcusys.learn.facades

import com.arcusys.learn.models.Gradebook.{ PackageGradeResponse, TotalGradeResponse, StudentResponse }

/**
 * Created by Iliya Tryapitsin on 15.04.2014.
 */
trait GradebookFacadeContract {
  private[facades] def getTotalGrade(courseId: Int, valamisUserId: Int): Float
  private[facades] def getPacketGradeWithStatements(packetId: Int, valamisUserId: Int, packageIds: Option[Seq[Int]], sortAsc: Boolean = false): Seq[PackageGradeResponse]

  def getStudents(courseId: Int,
    page: Int,
    count: Int,
    nameFilter: String,
    orgNameFilter: String,
    sortBy: String): Seq[StudentResponse]

  def getStudentsCount(courseId: Int,
    nameFilter: String,
    orgNameFilter: String): Int

  def getExtStudents(courseId: Int,
    page: Int,
    count: Int,
    nameFilter: String,
    orgNameFilter: String,
    packageIds: Seq[Int],
    sortBy: String): Seq[StudentResponse]

  def getGradesForStudent(studentId: Int,
    courseID: Int,
    page: Int,
    count: Int,
    sortAsc: Boolean = false): StudentResponse

  def getTotalGradeForStudent(studentId: Int,
    courseID: Int): TotalGradeResponse

  def changeTotalGrade(studentId: Int,
    courseID: Int,
    totalGrade: String,
    comment: Option[String])

  def changePackageGrade(studentId: Int,
    packageId: Int,
    totalGrade: String,
    comment: Option[String])
}
