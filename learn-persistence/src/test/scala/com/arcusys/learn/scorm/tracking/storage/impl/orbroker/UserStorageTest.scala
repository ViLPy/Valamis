package com.arcusys.learn.scorm.tracking.storage.impl.orbroker

import com.arcusys.learn.scorm.tracking.storage.UserStorageJUnit
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests

import org.junit._
import runner.RunWith
import runners.Parameterized


@RunWith(value = classOf[Parameterized])
class UserStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName)
                                          with UserStorageJUnit {
  val userStorage = new UserStorageImpl
}