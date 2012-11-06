package com.arcusys.scorm.lms

import com.arcusys.learn.scorm.manifest.model._

class GradeReport(val root: GradeReportNode)

abstract class GradeReportNode(val activity: Activity) {
  def correctShare: Option[Double]

  def weight: Double

  def weightedCorrectShare: Option[Double] = correctShare map (_ * weight)

  override def toString = "Activity: "+activity.id + "/" +activity.title +",\n Correct share: "+correctShare+",\nWeight"+weight+",\nCorrect count: "+weightedCorrectShare
}

class GradeReportLeaf(override val activity: LeafActivity, val correct: Option[Boolean], val text: Option[String], val userResponse:Option[String], val attemptCompleted:Boolean)
  extends GradeReportNode(activity) {
  val correctShare = correct.map( _ match {
    case true => 1.0
    case _ => 0.0
  })
  val weight = 1.0
}

class GradeReportBranch(override val activity: ContainerActivity, val children: Seq[GradeReportNode])
  extends GradeReportNode(activity) {
  val weight = children.foldLeft(0.0)(_ + _.weight)
  val correctShare = if (children.find(_.weightedCorrectShare.isEmpty).isDefined) None
                     else Some(children.foldLeft(0.0)(_ + _.weightedCorrectShare.get) / weight)
  override def toString = super.toString + ",\nChildren: "+children
}

class GradeReportRoot(override val activity: Organization, val children: Seq[GradeReportNode])
  extends GradeReportNode(activity) {
  val weight = children.foldLeft(0.0)(_ + _.weight)
  val correctShare = if (children.find(_.weightedCorrectShare.isEmpty).isDefined) None
                     else Some(children.foldLeft(0.0)(_ + _.weightedCorrectShare.get) / weight)
  override def toString = super.toString + ",\nChildren: "+children
}

object GradeReport {
  def get(attemptID: Int) {}

  def get(userID: Int, packageID: Int) {}
}
