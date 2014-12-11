package com.arcusys.learn.bl.services

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.scorm.tracking.model.CourseGrade

/**
 * User: Yulia.Glushonkova
 * Date: 13.10.2014
 */
trait CourseServiceContract {
  def getAllCourses(companyId: Long): Seq[LGroup]

  def all(companyId: Long, skip: Int, take: Int, filter: String, sortAscDirection: Boolean): Seq[LGroup]

  def all: Seq[LGroup]

  def count(companyId: Long, filter: String): Int

  def getCourseGradeOption(courseId: Int, userId: Int): Option[CourseGrade]

  def getCourse(siteId: Int): LGroup

  def getByUserId(userId: Long): Seq[LGroup]

  def getCompanyIds: Seq[Long]

  def create(course: CourseGrade)

  def modify(course: CourseGrade)

  def get(courseId: Int, userID: Int): Option[CourseGrade]

  def getCoursesByCompanyIdAndName(companyId: Long, namePattern: String): Seq[LGroup]

  def getCoursesByCompanyId(companyId: Long): Seq[LGroup]
}
