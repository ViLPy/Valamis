package com.arcusys.learn.bl.services

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.QueryUtilHelper
import com.arcusys.learn.liferay.services.GroupLocalServiceHelper
import com.arcusys.learn.scorm.course.CourseStorage
import com.arcusys.learn.scorm.tracking.model.CourseGrade
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.liferay.portal.service.CompanyLocalServiceUtil
import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 13.10.2014
 */
class CourseService(configuration: BindingModule) extends CourseServiceContract with Injectable {
  def this() = this(DomainConfiguration)

  implicit val bindingModule = configuration

  val courseRepository = inject[CourseStorage]

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

  def getCourse(siteId: Int) =
    GroupLocalServiceHelper.getGroup(siteId)

  def getByUserId(userId: Long) =
    GroupLocalServiceHelper.getGroupsByUserId(userId).asScala

  def getCompanyIds: Seq[Long] = CompanyLocalServiceUtil.getCompanies(-1, -1).asScala.map(_.getCompanyId).toSeq

  def create(course: CourseGrade) = courseRepository.create(course)

  def modify(course: CourseGrade) = courseRepository.modify(course)

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
