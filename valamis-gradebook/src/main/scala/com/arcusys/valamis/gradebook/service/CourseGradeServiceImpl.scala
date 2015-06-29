package com.arcusys.valamis.gradebook.service

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.QueryUtilHelper
import com.arcusys.learn.liferay.services.GroupLocalServiceHelper
import com.arcusys.valamis.gradebook.model.CourseGrade
import com.arcusys.valamis.gradebook.storage.CourseGradeStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import com.liferay.portal.service.CompanyLocalServiceUtil

import scala.collection.JavaConverters._
import scala.util.Try

/**
 * User: Yulia.Glushonkova
 * Date: 13.10.2014
 */
class CourseGradeServiceImpl(implicit val bindingModule: BindingModule) extends CourseGradeService with Injectable {

  val courseRepository = inject[CourseGradeStorage]

  def getAllCourses(companyId: Long): Seq[LGroup] = GroupLocalServiceHelper
    .getCompanyGroups(companyId, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
    .asScala
    .filter(x => {
      val url = x.getFriendlyURL
      x.isSite && x.isActive &&
        //remove control panel
        url != "/control_panel"
    })

  def getGroupIdsForAllCourses(companyId: Long): Seq[Long] = GroupLocalServiceHelper
    .getCompanyGroupIdsActiveSites(companyId, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)

  def getGroupIdsForAllCoursesFromAllCompanies: Seq[Long] = GroupLocalServiceHelper
    .getGroupIdsForAllActiveSites

  def all(companyId: Long, skip: Int, take: Int, filter: String, sortAscDirection: Boolean): Seq[LGroup] = {
    var allCourses = getCoursesByCompanyIdAndName(companyId, filter)

    if (!sortAscDirection) allCourses = allCourses.reverse

    if (take == 0)
      allCourses
    else
      allCourses.drop(skip).take(take)
  }

  def all = GroupLocalServiceHelper.getGroups.asScala

  def count(companyId: Long, filter: String): Int = getCoursesByCompanyIdAndName(companyId, filter).length

  def getCourseGradeOption(courseId: Int, userId: Int): Option[CourseGrade] = {
    courseRepository.get(courseId, userId)
  }

  def getCourse(siteId: Long) =
    GroupLocalServiceHelper.getGroup(siteId)

  def getByUserId(userId: Long) =
    GroupLocalServiceHelper.getGroupsByUserId(userId).asScala

  def getCompanyIds: Seq[Long] = CompanyLocalServiceUtil.getCompanies(-1, -1).asScala.map(_.getCompanyId).toSeq

  def create(course: CourseGrade) = courseRepository.create(course)

  def modify(course: CourseGrade) = courseRepository.modify(course)

  def getById(id: Int) = Try { GroupLocalServiceHelper.getGroup(id) }.toOption

  def get(courseId: Int, userID: Int): Option[CourseGrade] = courseRepository.get(courseId, userID)

  def getCoursesByCompanyIdAndName(companyId: Long, namePattern: String): Seq[LGroup] = {
    def criterion(entity: LGroup) = {
      val url = entity.getFriendlyURL
      val name = entity.getDescriptiveName.toLowerCase
      val result = entity.isSite && entity.isActive && url != "/control_panel" && !name.isEmpty && entity.getCompanyId == companyId

      if (namePattern.isEmpty)
        result
      else
        result && name.contains(namePattern.toLowerCase)
    }
    GroupLocalServiceHelper
      .getGroups
      .asScala
      .filter(criterion)
  }

  def getCoursesByCompanyId(companyId: Long): Seq[LGroup] = {
    def criterion(entity: LGroup) = {
      val url = entity.getFriendlyURL
      val name = entity.getDescriptiveName.toLowerCase
      entity.isSite && entity.isActive && url != "/control_panel" && !name.isEmpty && entity.getCompanyId == companyId
    }
    GroupLocalServiceHelper
      .getGroups
      .asScala
      .filter(criterion)
  }
}
