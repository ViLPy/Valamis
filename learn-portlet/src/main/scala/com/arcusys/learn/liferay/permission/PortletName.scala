package com.arcusys.learn.liferay.permission

/**
 * Created by asemenov on 09.02.15.
 */
sealed abstract class PortletName(val name: String) {
  val key = name + "_WAR_learnportlet"

  override def toString(): String = {
    name
  }
}

object PortletName {

  case object GradeBook extends PortletName("Gradebook")

  case object CertificateManager extends PortletName("Curriculum")

  case object CertificateViewer extends PortletName("CurriculumUser")

  case object LessonManager extends PortletName("PackageManager")

  case object LessonViewer extends PortletName("SCORMApplication")

  case object LessonDesigner extends PortletName("SCORMQuizes")

  case object ContentManager extends PortletName("ContentManager")

  case object LRSToActivityMapper extends PortletName("LRSToActivityMapper")

  case object LearningTranscript extends PortletName("LearningTranscript")

  case object UserPortfolio extends PortletName("SCORMUserAccount")

  case object AdminView extends PortletName("SCORMApplicationAdmin")

  case object ActivityToLRSMapper extends PortletName("SocialActivitiesTinCanMapper")

  case object SlidesEditor extends PortletName("ValamisSlidesEditor")

  case object AchievedCertificates extends PortletName("AchievedCertificates")

  case object RecentLessons extends PortletName("RecentLessons")

  case object ValamisActivities extends PortletName("ValamisActivities")

  case object LearningPaths extends PortletName("LearningPaths")

}

