package com.arcusys.learn.filestorage.storage.impl.orbroker

import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import org.junit.Before
import com.arcusys.learn.filestorage.storage.FileStorageJUnitMethods

@RunWith(value = classOf[Parameterized])
class FileStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName) with FileStorageJUnitMethods {
  val fileStorage = new FileStorageImpl
}


