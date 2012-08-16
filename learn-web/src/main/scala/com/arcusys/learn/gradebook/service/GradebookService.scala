package com.arcusys.learn.gradebook.service

import com.arcusys.scorm.lms._
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import java.net._

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
          case leaf: GradeReportLeaf => leaf.questionText
          case _ => None
        }),
        "userResponse" -> (node match {
          case leaf: GradeReportLeaf => leaf.response
          case _ => None
        }),
        "children" -> (node match {
          case branch: GradeReportBranch => branch.children.map(mapNode)
          case root: GradeReportRoot => root.children.map(mapNode)
          case _ => Nil
        })
      )
    mapNode(node)
  })

  get("/GetResultsForPackage/:packageID/user/:userID") {
    val packageID = parameter("packageID").intRequired
    val userID = parameter("userID").intRequired
    val report = (new GradeReportGenerator).getForCurrentAttempt(userID, packageID)

    jsonModel(report)
  }

  post("/UpdateSuccessStatus") {
    val packageID = parameter("packageID").intRequired
    val userID = parameter("userID").intRequired
    val activityID = parameter("activityID").required
    val status = parameter("status").required
    val score = parameter("score").required
    attemptStorage.getLast(userID, packageID).map {
      activeAttempt =>
        val dataModel = new DataModelService(activeAttempt, activityID)
        dataModel.setValue("cmi.success_status", status)
        dataModel.setValue("cmi.score.scaled", score)
    }
    ""
  }
}
