package com.arcusys.learn.facades

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.QueryUtilHelper
import com.arcusys.learn.liferay.services.GroupLocalServiceHelper
import com.arcusys.learn.models.CourseResponse
import com.arcusys.learn.scorm.course.CourseStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portal.service.CompanyLocalServiceUtil

import scala.collection.JavaConverters._

/**
 * Created by Iliya Tryapitsin on 19.03.14.
 */
class CourseFacade(configuration: BindingModule) extends CourseFacadeContract with Injectable with Paginator {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  val courseStorage = inject[CourseStorage]

  def getAllCourses(companyId: Long): Seq[LGroup] = GroupLocalServiceHelper
    .getCompanyGroups(companyId, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
    .asScala
    .filter(x => {
      val url = x.getFriendlyURL
      val name = x.getDescriptiveName.toLowerCase
      x.isSite && x.isActive &&
        //remove control panel
        url != "/control_panel"
    })

  private def getAllCourses(companyId: Long, filter: String): Seq[LGroup] = getAllCourses(companyId)
    .filter(site => {
      val name = site.getDescriptiveName.toLowerCase
      name.contains(filter.toLowerCase)
    })

  def all(companyId: Long,
    skip: Int,
    take: Int,
    filter: String,
    sortAscDirection: Boolean): Seq[CourseResponse] = {

    val allCourses = getAllCourses(companyId, filter)
    val paged = takeForPage(allCourses, skip, take, sortAscDirection)

    paged.map(group => {
      CourseResponse(
        group.getGroupId,
        group.getDescriptiveName,
        group.getFriendlyURL,
        group.getDescription.replace("\n", " "))
    })
  }

  def all = GroupLocalServiceHelper.getGroups.asScala map { course =>
    CourseResponse(
      course.getGroupId,
      course.getDescriptiveName,
      course.getFriendlyURL,
      course.getDescription.replace("\n", " "))
  }

  def count(companyId: Long, filter: String): Int = getAllCourses(companyId, filter).length

  def getCourse(siteId: Int): CourseResponse = {
    val course = GroupLocalServiceHelper.getGroup(siteId)
    CourseResponse(
      siteId,
      course.getDescriptiveName,
      course.getFriendlyURL,
      course.getDescription.replace("\n", " "))
  }

  def getByUserId(userId: Long): Seq[CourseResponse] = {
    val groups = GroupLocalServiceHelper.getGroupsByUserId(userId).asScala
    groups map { g =>
      CourseResponse(g.getGroupId, g.getDescriptiveName, g.getFriendlyURL, g.getDescription.replace("\n", " "))
    }
  }

  def getCompanyIds: Seq[Long] = CompanyLocalServiceUtil.getCompanies(-1, -1).asScala.map(_.getCompanyId).toSeq

  //  def getTotalGrade(courseId: Int, valamisUserId: Int): Float = courseStorage.get(courseId, valamisUserId) match {
  //    case Some(value) => Try(value.grade.toFloat).getOrElse(0)
  //    case None        => 0
  //  }
  //
  //  def getTotalComment(courseId: Int, valamisUserId: Int): String = courseStorage.get(courseId, valamisUserId) match {
  //    case Some(value) => value.comment
  //    case None        => ""
  //  }

  //  def getGrades(courseId: Int, valamisUserId: Int): Seq[PackageGradeResponse] = throw new NotImplementedException
}
