package com.arcusys.valamis.gradebook.service

import com.arcusys.valamis.lesson.scorm.model.manifest.{ Organization, ContainerActivity, LeafActivity, Activity }

class GradeReport(val root: GradeReportNode)

abstract class GradeReportNode(val activity: Activity) {
  def packageID: Int
  def correctShare: Option[Double]
  def essayComment: String
  def weight: Double
  def questionType: Option[String]

  def weightedCorrectShare: Option[Double] = correctShare map (_ * weight)

  override def toString = "Activity: " + activity.id + "/" + activity.title + ",\n Correct share: " + correctShare + ",\nWeight" + weight + ",\nCorrect count: " + weightedCorrectShare
}

class GradeReportLeaf(override val activity: LeafActivity,
  val score: Option[Double],
  val text: Option[String], val userResponse: Option[String], val attemptCompleted: Boolean, val essayCommentText: String, val packID: Int, val questType: Option[String])
    extends GradeReportNode(activity) {
  val correctShare = score
  val essayComment = essayCommentText
  val weight = 1.0
  val packageID = packID
  val questionType = questType
}

class GradeReportBranch(override val activity: ContainerActivity, val children: Seq[GradeReportNode], val essayCommentText: String, val packID: Int)
    extends GradeReportNode(activity) {
  val weight = children.filter(item => item.weightedCorrectShare.isDefined || item.questionType == Some("long_fill_in")).foldLeft(0.0)(_ + _.weight)
  // TODO: be aware of Double.NaN in case if weight == 0.0
  val correctShare = if (weight == 0.0 || children.filter(item => item.weightedCorrectShare.isDefined || item.questionType == Some("long_fill_in")).find(_.weightedCorrectShare.isEmpty).isDefined) None
  else Some(children.filter(item => item.weightedCorrectShare.isDefined || item.questionType == Some("long_fill_in")).foldLeft(0.0)(_ + _.weightedCorrectShare.get) / weight)
  val essayComment = essayCommentText
  val packageID = packID
  val questionType = None
  override def toString = super.toString + ",\nChildren: " + children
}

class GradeReportRoot(override val activity: Organization, val children: Seq[GradeReportNode], val essayCommentText: String, val packID: Int)
    extends GradeReportNode(activity) {
  val weight = children.filter(item => item.weightedCorrectShare.isDefined || item.questionType == Some("long_fill_in")).foldLeft(0.0)(_ + _.weight)
  // TODO: be aware of Double.NaN in case if weight == 0.0
  val correctShare = if (weight == 0.0 || children.filter(item => item.weightedCorrectShare.isDefined || item.questionType == Some("long_fill_in")).find(_.weightedCorrectShare.isEmpty).isDefined) None
  else Some(children.filter(item => item.weightedCorrectShare.isDefined || item.questionType == Some("long_fill_in")).foldLeft(0.0)(_ + _.weightedCorrectShare.get) / weight)
  val essayComment = essayCommentText
  val packageID = packID
  val questionType = None
  override def toString = super.toString + ",\nChildren: " + children
}
