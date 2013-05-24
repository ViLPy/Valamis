package com.arcusys.learn.scorm.tracking.states.storage.impl.orbroker

import com.arcusys.learn.scorm.tracking.storage.impl.orbroker.{UserStorageImpl, AttemptStorageImpl}
import com.arcusys.learn.scorm.manifest.storage.impl.orbroker.{PackagesStorageImpl, ActivitiesStorageImpl}
import com.arcusys.learn.scorm.tracking.states.storage.impl.ActivityStateTreeStorageJUnit
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests

import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = classOf[Parameterized])
class ActivityStateTreeStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName)
                                                       with ActivityStateTreeStorageJUnit {
  val attemptStorage = new AttemptStorageImpl
  val activityStorage = new ActivitiesStorageImpl
  val packagesStorage = new PackagesStorageImpl
  val treeStateStorage = new ActivityStateTreeStorageImpl
  val stateStorage = new ActivityStateStorageImpl
  val userStorage = new UserStorageImpl
}
