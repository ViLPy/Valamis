package com.arcusys.learn.storage.impl.orbroker

import org.junit._
import com.arcusys.scorm.util.PropertyUtil

class StorageFactoryTest {
  BrokerFactory.init(PropertyUtil.load("db"))

  @Test
  def canRenewStorageWithoutAnyException() {
    StorageFactory.renewWholeStorage()
  }
}