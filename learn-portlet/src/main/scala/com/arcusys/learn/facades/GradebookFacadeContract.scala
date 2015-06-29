package com.arcusys.learn.facades

import com.arcusys.learn.models.response.PieData
import com.arcusys.valamis.gradebook.model.GradebookUserSortBy
import GradebookUserSortBy.GradebookUserSortBy
import com.arcusys.learn.models.Gradebook._
import com.arcusys.valamis.lrs.api.StatementApi

trait GradebookFacadeContract {
  def getStudents(statementApi: StatementApi,
                  courseId: Int,
                  skip: Int,
                  count: Int,
                  nameFilter: String,
                  orgNameFilter: String,
                  sortBy: GradebookUserSortBy,
                  sortAZ: Boolean,
                  detailed: Boolean = false,
                  packageIds: Seq[Int] = Seq()): Seq[StudentResponse]

  def getStudentsCount(courseId: Int,
    nameFilter: String,
    orgNameFilter: String): Int

  def getGradesForStudent(statementApi: StatementApi,
                          studentId: Int,
                          courseId: Int,
                          skip: Int,
                          count: Int,
                          sortAsc: Boolean = false,
                          withStatements: Boolean = true): StudentResponse

  /** See the body, name not descriptive */
  def getUnfinishedPackages(
    statementApi: StatementApi,
    userId: Long): Seq[GradedPackageResponse]

  def getCompletedPackagesCount(statementApi: StatementApi, userId: Long): Int

  def getCompletedPackages(statementApi: StatementApi, userId: Long): Seq[PieData]

  def getTotalGradeForStudent(studentId: Int,
    courseId: Int): TotalGradeResponse

  def changeTotalGrade(studentId: Int,
    courseId: Int,
    totalGrade: String,
    comment: Option[String])

  def changePackageGrade(studentId: Int,
    packageId: Int,
    totalGrade: String,
    comment: Option[String])

  def getLastModified(statementApi: StatementApi, courseId: Int, userId: Long): String

  def getPackageGradeWithStatements(statementApi: StatementApi, valamisUserId: Int,
    packageId: Long): PackageGradeResponse
}
