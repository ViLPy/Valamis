package com.arcusys.learn.scorm.course.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFCourseLocalService
import com.arcusys.learn.persistence.liferay.model.LFCourse
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer
import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

/**
 * Created with IntelliJ IDEA.
 * User: Yulia.Glushonkova
 * Date: 26.03.13
 */

object CourseEntityContainer extends MockEntityContainer[LFCourseLocalService, LFCourse] {
  lazy val mockServiceBeanName = classOf[LFCourseLocalService].getName
  lazy val mockLocalService = mock[LFCourseLocalService]

  def createFunction = _.createLFCourse()
  def addFunction = _.addLFCourse(_)
  def deleteFunction = _.deleteLFCourse(_)
  def updateFunction = _.updateLFCourse(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFCourses(_, _)
  def removeAllFunction = _.removeAll()

  def createMockEntity() = mock[LFCourse]
  def mockEntityProperties(mockEntity: LFCourse) {
    mockIntegerProperty(mockEntity.setCourseID(_), _.getCourseID)
    mockIntegerProperty(mockEntity.setUserID(_), _.getUserID)
    mockStringProperty(mockEntity.setComment(_), _.getComment)
    mockStringProperty(mockEntity.setGrade(_), _.getGrade)
  }

  def getIdFunction = _.getId

  mockLocalService.fetchByCourseIdAndUserId(any, any) answers { (paramsRaw, mockService) =>
    getByCourseIdAndUserId(paramsRaw, mockService)
  }
  mockLocalService.findByCourseIdAndUserId(any, any) answers {
    (paramsRaw, mockService) => getByCourseIdAndUserId(paramsRaw, mockService)
  }

  def getByCourseIdAndUserId(paramsRaw: Any, mockService: Any) = {
    val paramsTuple: (Any, Any) = paramsRaw match {
      case Array(a, b) if a.isInstanceOf[Int] && b.isInstanceOf[Int] => (a, b)
    }
    val courseId = paramsTuple._1 match { case x: Int => x }
    val userId = paramsTuple._2 match { case x: Int => x }

    val result = internalStorage.values.filter(entity => Option(entity.getCourseID).getOrElse(nullInteger) == courseId
      && Option(entity.getUserID).getOrElse(nullInteger) == userId).headOption
    if (result.isEmpty) null else result.get
  }

}
