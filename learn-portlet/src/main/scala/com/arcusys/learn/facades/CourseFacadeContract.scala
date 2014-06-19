package com.arcusys.learn.facades

import com.arcusys.learn.liferay.LiferayClasses.LGroup
import com.arcusys.learn.models.CourseResponse

/**
 * Created by Iliya Tryapitsin on 19.03.14.
 */
trait CourseFacadeContract {
  def getAllCourses(companyId: Long): Seq[LGroup]

  def all(companyId: Long,
    skip: Int,
    take: Int,
    filter: String,
    sortAscDirection: Boolean): Seq[CourseResponse]

  def all: Seq[CourseResponse]

  def count(companyId: Long, filter: String): Int

  def getCourse(siteId: Int): CourseResponse

  def getByUserId(userId: Long): Seq[CourseResponse]

  def getCompanyIds: Seq[Long]

  //  def getTotalGrade(courseId: Int, valamisUserId: Int): Float
  //  def getTotalComment(courseId: Int, valamisUserId: Int): String
  //  def getGrades(courseId: Int, valamisUserId: Int): Seq[PackageGradeResponse]
}
