package com.arcusys.learn.facades

import com.arcusys.learn.liferay.LiferayClasses.LGroup
import com.arcusys.learn.models.CourseResponse

/**
 * Created by Iliya Tryapitsin on 19.03.14.
 */
trait CourseFacadeContract {
  def getAllCourses(companyId: Long): Seq[LGroup]

  def getGroupIdsForAllCourses(companyId: Long): Seq[Long]

  def getGroupIdsForAllCoursesFromAllCompanies: Seq[Long]

  def all(companyId: Long,
    skip: Int,
    take: Int,
    filter: String,
    sortAscDirection: Boolean): Seq[CourseResponse]

  def all: Seq[CourseResponse]

  def count(companyId: Long, filter: String): Int

  def getCourse(siteId: Long): CourseResponse

  def getByUserId(userId: Long): Seq[CourseResponse]

  def getCompanyIds: Seq[Long]
}
