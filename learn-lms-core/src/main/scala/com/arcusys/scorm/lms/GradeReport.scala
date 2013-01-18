package com.arcusys.scorm.lms

import com.arcusys.learn.scorm.manifest.model._

class GradeReport(val root: GradeReportNode)

abstract class GradeReportNode(val activity: Activity) {
  def packageID: Int
  def correctShare: Option[Double]
  def essayComment: String
  def weight: Double

  def weightedCorrectShare: Option[Double] = correctShare map (_ * weight)

  override def toString = "Activity: "+activity.id + "/" +activity.title +",\n Correct share: "+correctShare+",\nWeight"+weight+",\nCorrect count: "+weightedCorrectShare
}

class GradeReportLeaf(override val activity: LeafActivity,
                      val score:Option[Double],
                      val text: Option[String], val userResponse:Option[String], val attemptCompleted:Boolean, val essayCommentText:String, val packID:Int)
  extends GradeReportNode(activity) {
  val correctShare = score
  val essayComment = essayCommentText
  val weight = 1.0
  val packageID = packID
}

class GradeReportBranch(override val activity: ContainerActivity, val children: Seq[GradeReportNode], val essayCommentText:String, val packID:Int)
  extends GradeReportNode(activity) {
  val weight = children.foldLeft(0.0)(_ + _.weight)
  val correctShare = if (children.find(_.weightedCorrectShare.isEmpty).isDefined) None
                     else Some(children.foldLeft(0.0)(_ + _.weightedCorrectShare.get) / weight)
  val essayComment = essayCommentText
  val packageID = packID
  override def toString = super.toString + ",\nChildren: "+children
}

class GradeReportRoot(override val activity: Organization, val children: Seq[GradeReportNode], val essayCommentText:String, val packID: Int)
  extends GradeReportNode(activity) {
  val weight = children.foldLeft(0.0)(_ + _.weight)
  val correctShare = if (children.find(_.weightedCorrectShare.isEmpty).isDefined) None
                     else Some(children.foldLeft(0.0)(_ + _.weightedCorrectShare.get) / weight)
  val essayComment = essayCommentText
  val packageID = packID
  override def toString = super.toString + ",\nChildren: "+children
}

object GradeReport {
  def get(attemptID: Int) {}

  def get(userID: Int, packageID: Int) {}
}
