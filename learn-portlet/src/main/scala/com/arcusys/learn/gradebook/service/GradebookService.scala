package com.arcusys.learn.gradebook.service

import com.arcusys.scorm.lms._
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import java.net._
import com.arcusys.learn.scorm.tracking.model.Course
import com.arcusys.learn.service.util.SessionHandler

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
        "essayComment" -> node.essayComment,
        "currentPackageID" -> node.packageID,
        "questioinType" -> node.questionType
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

  private val packageService = new PackageService()

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  get("/GetResultsForPackage/user/:userID/:packageID/:courseID") {
    val courseID = parameter("courseID").intRequired
    val packageID = parameter("packageID").intRequired
    val userID = parameter("userID").intRequired

    if (!hasTeacherPermissions && userID != getSessionUserID) halt(401) // only teachers and admins can see result of other people

    val answers = if (userID == 0) {
      val users = (new UserManagement).getStudentsWithAttemptsByCourseID(courseID).map(user => {

        val userID = user("id").toString.toInt
        val courseID = parameter("courseID").intRequired
        val grades = packageService.getPackagesWithAttemptsByCourseIDNoMap(courseID, userID).map(pack =>
          Map(
            "packageID" -> pack.id,
            "packageName" -> pack.title,
            "userGrade" -> (new GradeReportGenerator).getForCurrentAttempt(userID, pack.id).map(_.correctShare).getOrElse(Some("unknown")).getOrElse("unknown") //TODO: change to properties file.
          )
        ).toList

        Map(
          "userID" -> userID,
          "userName" -> user("name"),
          "grades" -> grades,
          "totalGrade" -> courseService.getCourseGradeAndComment(courseID, userID).map(_.grade).getOrElse("unknown")
        )
      }).toList

      json(
        Map("packages" -> new PackageService().getPackagesWithAttemptsByCourseIDNoMap(courseID, 0).map(item => Map("title" -> item.title, "id" -> item.id)),
          "users" -> users
        )
      )
    } else {
      val report = if (packageID == 0) {
        val reports = packageService.getPackagesWithAttemptsByCourseIDNoMap(courseID, userID).map(
          pack =>
            (new GradeReportGenerator).getForCurrentAttempt(userID, pack.id)
        ).filter(report => report != None).map(report => report.get)
        jsonModel(reports)
      }
      else {
        jsonModel(((new GradeReportGenerator).getForCurrentAttempt(userID, packageID)).toSeq)
      }
      report
    }
    answers
  }

  private val courseService = new CourseService()

  get("/GetCourseInfo/:courseID/user/:userID") {
    val courseID = parameter("courseID").intRequired
    val userID = parameter("userID").intRequired

    if (!hasTeacherPermissions && userID != getSessionUserID) halt(401) // only teachers and admins can see result of other people

    courseInfoJsonModel(courseService.getCourseGradeAndComment(courseID, userID))
  }

  post("/UpdateScoreAndStatus") {
    requireTeacherPermissions()

    val packageID = parameter("packageID").intRequired
    val userID = parameter("userID").intRequired
    val activityID = parameter("activityID").required
    val score = parameter("score").withDefault("")
    val essayComment = parameter("essayComment").withDefault("")
    val status = if (score.toDouble > 0) "passed" else "failed"

    attemptStorage.getLast(userID, packageID, complete = true).map {
      activeAttempt =>
        val dataModel = new DataModelService(activeAttempt, activityID)
        dataModel.setValue("cmi.success_status", status)
        dataModel.setValue("cmi.score.scaled", score)
        dataModel.setValue("cmi.essay_comment", essayComment.replace("\n", "%20"))
    }
    ""
  }

  post("/SaveCourseGradeAndComment") {
    requireTeacherPermissions()

    val courseID = parameter("courseID").intRequired
    val userID = parameter("userID").intRequired
    val grade = parameter("grade").withDefault("")
    val comment = parameter("comment").withDefault("")
    courseService.saveCourseGradeAndComment(courseID, userID, grade, comment.replace("\n", "%20"))
    new CertificateService().addCertificatePassedActivity(courseID, userID, courseID)
    ""
  }

}
