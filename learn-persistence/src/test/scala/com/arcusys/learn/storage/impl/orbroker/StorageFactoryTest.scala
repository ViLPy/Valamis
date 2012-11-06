package com.arcusys.learn.storage.impl.orbroker

import org.junit._
import runner.RunWith
import runners.Parameterized

@RunWith(value = classOf[Parameterized])
class StorageFactoryTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName){

  @Test
  def canRenewStorageWithoutAnyException() {
    StorageFactory.renewWholeStorage()
  }
}