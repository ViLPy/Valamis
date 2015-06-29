package com.arcusys.learn.models.request

import com.arcusys.learn.liferay.permission.PermissionUtil
import com.arcusys.learn.service.util.{ AntiSamyHelper, Parameter }
import com.arcusys.valamis.gradebook.model.GradebookUserSortBy
import org.scalatra.ScalatraBase
import com.arcusys.learn.models.request.GradebookActionType._
import java.util.UUID

object GradebookRequest extends BaseCollectionFilteredRequest with BaseRequest {

  val StudentId = "studentId"
  val StudentNameFilter = "studentName"
  val OrganisationNameFilter = "organizationName"
  val ResultAs = "resultAs"
  val SelectedPackages = "selectedPackages"
  val Grade = "totalGrade"
  val GradeComment = "gradeComment"
  val StatementId = "statementId"
  val StatementGrade = "statementGrade"
  val PackageId = "packageId"
  val StudyCourseId = "studyCourseId"
  val WithStatements = "withStatements"

  val SHORT_RESULT_VALUE = "short"

  def apply(scalatra: ScalatraBase) = new Model(scalatra)

  class Model(val scalatra: ScalatraBase) extends BaseSortableCollectionFilteredRequestModel(scalatra, GradebookUserSortBy.apply)
    with OAuthModel {

    def actionType: GradebookActionType = GradebookActionType.withName(Parameter(Action).required.toUpperCase)

    def studentId = Parameter(StudentId).intRequired

    def userIdServer = PermissionUtil.getUserId

    def courseId = Parameter(CourseId).intRequired

    def studyCourseId = Parameter(StudyCourseId).intRequired

    def withStatements = Parameter(WithStatements).booleanOption.getOrElse(true)

    def organizationName = Parameter(OrganisationNameFilter).option match {
      case Some(value) => value
      case None        => ""
    }

    def studentName = Parameter(StudentNameFilter).option match {
      case Some(value) => value
      case None        => ""
    }

    def isShortResult = Parameter(ResultAs).option match {
      case Some(value) => value != "detailed"
      case None        => true
    }

    def selectedPackages = Parameter(SelectedPackages).multiWithEmpty.map(x => x.toInt)

    def gradeComment = Parameter(GradeComment).option.map(AntiSamyHelper.sanitize)

    def grade = AntiSamyHelper.sanitize(Parameter(Grade).required)

    def statementId = UUID.fromString(Parameter(StatementId).required)

    def packageId = Parameter(PackageId).intRequired

    def statementGrade = Parameter(StatementGrade).intRequired
  }
}

