/*
package com.arcusys.learn.achievements

import org.scalatest.FlatSpec
import org.scalamock.scalatest.MockFactory
import org.junit.runner.RunWith
import com.arcusys.learn.scorm.tracking.model.achivements.RequiredActivity
import com.arcusys.learn.liferay.LiferayClasses.LSocialActivity
import org.scalamock.proxy.ProxyMockFactory

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ActivityListenerTest extends FlatSpec with MockFactory with ProxyMockFactory {
  behavior of "Activity Listener"

  it should "not record achievement with no required activities specified" in {
    assert(ActivityListener.containsAllRequiredActivities(List(), List()) === false)
  }

  it should "record achievement with one completed required activity" in {
    val ra1 = RequiredActivity(-1, 1, "activity.class.name", 1)
    val requiredActivities = List(ra1)

    val sa1 = mock[LSocialActivity]
    val socialActivities = List(sa1)
    sa1.expects('getClassName).returning("activity.class.name")

    assert(ActivityListener.containsAllRequiredActivities(requiredActivities, socialActivities) === true)
  }

  it should "record achievement with two completed required activities" in {
    val ra1 = RequiredActivity(-1, 1, "activity.class.name", 2)
    val requiredActivities = List(ra1)

    val sa1 = mock[LSocialActivity]
    val sa2 = mock[LSocialActivity]
    val socialActivities = List(sa1, sa2)
    sa1.expects('getClassName).returning("activity.class.name")
    sa2.expects('getClassName).returning("activity.class.name")

    assert(ActivityListener.containsAllRequiredActivities(requiredActivities, socialActivities) === true)
  }

  it should "not record achievement with only one required activity, while two needed" in {
    val ra1 = RequiredActivity(-1, 1, "activity.class.name", 2)
    val requiredActivities = List(ra1)

    val sa1 = mock[LSocialActivity]
    val socialActivities = List(sa1)
    sa1.expects('getClassName).returning("activity.class.name")

    assert(ActivityListener.containsAllRequiredActivities(requiredActivities, socialActivities) === false)
  }

  it should "record achievement with multiple different required activities" in {
    val ra1 = RequiredActivity(-1, 1, "activity.class.name", 1)
    val ra2 = RequiredActivity(-1, 1, "new.activity.class.name", 1)
    val requiredActivities = List(ra1, ra2)

    val sa1 = mock[LSocialActivity]
    val sa2 = mock[LSocialActivity]
    val socialActivities = List(sa1, sa2)
    sa1.expects('getClassName).returning("activity.class.name")
    sa2.expects('getClassName).returning("new.activity.class.name")

    assert(ActivityListener.containsAllRequiredActivities(requiredActivities, socialActivities) === true)
  }

  it should "record achievement with multiple different required activities, multiple activities per requiredActivityClass" in {
    val ra1 = RequiredActivity(-1, 1, "activity.class.name", 2)
    val ra2 = RequiredActivity(-1, 1, "new.activity.class.name", 1)
    val requiredActivities = List(ra1, ra2)

    val sa1 = mock[LSocialActivity]
    val sa2 = mock[LSocialActivity]
    val sa3 = mock[LSocialActivity]
    val socialActivities = List(sa1, sa2, sa3)
    sa1.expects('getClassName).returning("activity.class.name")
    sa2.expects('getClassName).returning("new.activity.class.name")
    sa3.expects('getClassName).returning("activity.class.name")

    assert(ActivityListener.containsAllRequiredActivities(requiredActivities, socialActivities) === true)
  }
}*/
