package com.arcusys.learn.scorm.course.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.matcher.ThrownExpectations
import com.arcusys.learn.persistence.liferay.service.LFCourseLocalServiceUtil
import org.specs2.specification.Scope
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.tracking.model.CourseGrade

/**
 * Created with IntelliJ IDEA.
 * User: Yulia.Glushonkova
 * Date: 25.03.13
 */
class LFCourseSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {

  "Mockito" should {
    "mock service method" in new Context {
      LFCourseLocalServiceUtil.createLFCourse()
      there was atLeastOne(courseService).createLFCourse()
    }
  }

  "LFCourseStorageImpl" should {

    "execute 'create' without errors" in new Context {
      courseStorage.create(new CourseGrade(100, 1, "", "")) must not(throwA[Exception])
    }

    "execute 'getByCourseIdAndUserId' without errors" in new Context {
      courseStorage.create(new CourseGrade(200, 423, "", "")) must not(throwA[Exception])
      var fetched = courseStorage.getOne("courseID" -> 200, "userID" -> 423)
      fetched must beSome
      fetched.get.courseID must beEqualTo(200)
    }

    "execute 'get not existed' without errors" in new Context {
      var fetched = courseStorage.getOne("courseID" -> 9, "userID" -> 1)
      fetched must beNone
    }

    "execute 'modify' without errors" in new Context {
      courseStorage.create(new CourseGrade(300, 1, "", "")) must not(throwA[Exception])
      courseStorage.modify(new CourseGrade(300, 1, "grade1", "comment1")) must not(throwA[Exception])
      val updated = courseStorage.getOne("courseID" -> 300, "userID" -> 1)
      updated must beSome
      updated.get.courseID must beEqualTo(300)
      updated.get.comment must beEqualTo("comment1")
    }

  }

  trait Context extends Scope {
    // do initialize mock services
    val courseService = CourseEntityContainer.mockLocalService
    val courseStorage: EntityStorage[CourseGrade] = new LFCourseStorageImpl {}
  }
}
