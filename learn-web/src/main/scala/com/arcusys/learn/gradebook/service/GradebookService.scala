package com.arcusys.learn.gradebook.service

import com.arcusys.scorm.lms._
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import java.net._
import com.arcusys.learn.scorm.tracking.model.Course

class GradebookService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  private def encode(str: String) = URLEncoder.encode(str, "UTF-8")

  val jsonModel = new JsonModelBuilder[GradeReportNode](node => {
    def mapNode(node: GradeReportNode): Map[String, Any] =
      Map(
        "id" -> node.activity.id,
        "title" -> node.activity.title,
        "share" -> node.correctShare,
        "questionText" -> (node match {
          case leaf: GradeReportLeaf => leaf.text
          case _ => None
        }),
        "userResponse" -> (node match {
          case leaf: GradeReportLeaf => leaf.userResponse
          case _ => None
        }),
        "children" -> (node match {
          case branch: GradeReportBranch => branch.children.map(mapNode)
          case root: GradeReportRoot => root.children.map(mapNode)
          case _ => Nil
        }),
        "viewedState" -> (node match {
          case leaf: GradeReportLeaf => leaf.attemptCompleted
          case _ => None
        }),
        "essayComment"-> node.essayComment,
        "currentPackageID"-> node.packageID
      )
    mapNode(node)
  })

  val courseInfoJsonModel = new JsonModelBuilder[Course](course => {
    def mapNode(course: Course): Map[String, Any] =
      Map(
        "courseID" -> course.courseID,
        "userID" -> course.userID,
        "grade" -> course.grade,
        "comment" -> course.comment
      )
    mapNode(course)
  })


  get("/GetResultsForPackage/user/:userID/:packageID/:courseID") {
    val courseID = parameter("courseID").intRequired
    val packageID = parameter("packageID").intRequired
    val userID = parameter("userID").intRequired
    val report = if (packageID == 0)
    {
      //val reports = attemptStorage.getPackagesWithUserAttempts(userID).map(
      val reports = PackageService.getPackagesWithAttemptsByCourseIDNoMap(courseID, userID).map(
        pack =>
          (new GradeReportGenerator).getForCurrentAttempt(userID, pack.id)
      ).filter(report=> report!=None).map(report=>report.get)
     jsonModel(reports)
    }
    else {
      jsonModel(((new GradeReportGenerator).getForCurrentAttempt(userID, packageID)).toSeq)
    }
    report
  }

  get("/GetCourseInfo/:courseID/user/:userID"){
    val courseID = parameter("courseID").intRequired
    val userID = parameter("userID").intRequired
    courseInfoJsonModel(CourseService.getCourseGradeAndComment(courseID, userID))
  }

  post("/UpdateScoreAndStatus") {
    val packageID = parameter("packageID").intRequired
    val userID = parameter("userID").intRequired
    val activityID = parameter("activityID").required
    val score = parameter("score").withDefault("")
    val essayComment = parameter("essayComment").withDefault("")
    val status = if(score.toDouble>0) "passed" else "failed"

    attemptStorage.getLast(userID, packageID, complete = true).map {
      activeAttempt =>
        val dataModel = new DataModelService(activeAttempt, activityID)
        dataModel.setValue("cmi.success_status", status)
        dataModel.setValue("cmi.score.scaled", score)
        dataModel.setValue("cmi.essay_comment", essayComment)
    }
    ""
  }

  post("/SaveCourseGradeAndComment"){
    val courseID = parameter("courseID").intRequired
    val userID = parameter("userID").intRequired
    val grade = parameter("grade").withDefault("")
    val comment = parameter("comment").withDefault("")
    CourseService.saveCourseGradeAndComment( courseID, userID, grade, comment)
    ""
  }

}
