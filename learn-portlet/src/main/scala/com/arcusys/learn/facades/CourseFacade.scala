package com.arcusys.learn.facades

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.models.CourseResponse
import com.arcusys.valamis.gradebook.service.CourseGradeService
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

/**
 * Created by Iliya Tryapitsin on 19.03.14.
 */
class CourseFacade(configuration: BindingModule) extends CourseFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  val courseService = inject[CourseGradeService]

  def getAllCourses(companyId: Long): Seq[LGroup] =
    courseService.getAllCourses(companyId)

  def getGroupIdsForAllCourses(companyId: Long): Seq[Long] = courseService.getGroupIdsForAllCourses(companyId)

  def getGroupIdsForAllCoursesFromAllCompanies: Seq[Long] = courseService.getGroupIdsForAllCoursesFromAllCompanies

  def all(companyId: Long,
    skip: Int,
    take: Int,
    filter: String,
    sortAscDirection: Boolean): Seq[CourseResponse] = {
    val paged = courseService.all(companyId, skip, take, filter, sortAscDirection)

    paged.map(group => {
      CourseResponse(
        group.getGroupId,
        group.getDescriptiveName,
        group.getFriendlyURL,
        group.getDescription.replace("\n", " "))
    })
  }

  def all = courseService.all
    .map(course => CourseResponse(
      course.getGroupId,
      course.getDescriptiveName,
      course.getFriendlyURL,
      course.getDescription.replace("\n", " ")))

  def count(companyId: Long, filter: String): Int = courseService.count(companyId, filter)

  def getCourse(siteId: Long): CourseResponse = {
    val course = courseService.getCourse(siteId)
    CourseResponse(
      siteId,
      course.getDescriptiveName,
      course.getFriendlyURL,
      course.getDescription.replace("\n", " "))
  }

  def getByUserId(userId: Long): Seq[CourseResponse] = {
    val groups = courseService.getByUserId(userId)
    groups map { g =>
      CourseResponse(g.getGroupId, g.getDescriptiveName, g.getFriendlyURL, g.getDescription.replace("\n", " "))
    }
  }

  def getCompanyIds: Seq[Long] = courseService.getCompanyIds
}
