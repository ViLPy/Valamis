package com.arcusys.learn.models.request

import com.arcusys.learn.service.util.Parameter
import org.scalatra.ScalatraBase
import com.arcusys.learn.models.request.GradebookActionType._
import java.util.UUID

object GradebookRequest extends BaseCollectionFilteredRequest with BaseRequest {
  val COURSE_ID = "courseId"

  val STUDENT_ID = "studentId"
  val STUDENT_NAME_FILTER = "studentName"
  val ORGANIZATION_NAME_FILTER = "organizationName"
  val RESULT_AS = "resultAs"
  val SELECTED_PACKAGES = "selectedPackages"
  val GRADE = "totalGrade"
  val GRADE_COMMENT = "gradeComment"
  val STATEMENT_ID = "statementId"
  val STATEMENT_GRADE = "statementGrade"
  val PACKAGE_ID = "packageId"
  val SORT = "sort"

  val SHORT_RESULT_VALUE = "short"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(scalatra: ScalatraBase) extends BaseCollectionFilteredRequestModel(scalatra) {

    def actionType: GradebookActionType = GradebookActionType.withName(Parameter(ACTION).required.toUpperCase)

    def studentId = Parameter(STUDENT_ID).intRequired

    def courseId = Parameter(COURSE_ID).intRequired

    def organizationName = Parameter(ORGANIZATION_NAME_FILTER).option match {
      case Some(value) => value
      case None        => ""
    }

    def studentName = Parameter(STUDENT_NAME_FILTER).option match {
      case Some(value) => value
      case None        => ""
    }

    def isShortResult = Parameter(RESULT_AS).option match {
      case Some(value) => value != "detailed"
      case None        => true
    }

    def selectedPackages = Parameter(SELECTED_PACKAGES).multiWithEmpty.map(x => x.toInt).toSeq

    def gradeComment = Parameter(GRADE_COMMENT).option

    def grade = Parameter(GRADE).required

    def statementId = UUID.fromString(Parameter(STATEMENT_ID).required)

    def packageId = Parameter(PACKAGE_ID).intRequired

    def statementGrade = Parameter(STATEMENT_GRADE).intRequired

    def sortBy = Parameter(SORT).required
  }
}

