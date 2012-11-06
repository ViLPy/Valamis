package com.arcusys.learn.filestorage.storage.impl.orbroker

import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import org.junit.{Test, Before}
import org.junit.Assert._

@RunWith(value = classOf[Parameterized])
class FileStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName) {
  val fileStorage = new FileStorageImpl

  @Before
  def setUp() {
    fileStorage.renew()
  }

  @Test
  def canStoreAndGetArrays() {
    val data = Array[Byte]('\12', '\54', '\12', '\51', '\0')
    fileStorage.store("test.dat", data)
    val fetched = fileStorage.getFile("test.dat")
    assertEquals(true, fetched.nonEmpty)
    assertEquals(true, fetched.get.content.nonEmpty)
    assertArrayEquals(data, fetched.get.content.get)
  }

  @Test
  def canStoreAndGetFiles() {
    val path = Thread.currentThread.getContextClassLoader.getResource("gnugpl.png").getPath
    val source = scala.io.Source.fromFile(path)(scala.io.Codec.ISO8859)
    val resource = source.map(_.toByte).toArray
    source.close()
    fileStorage.store("gnugpl.png", resource)
    val fetched = fileStorage.getFile("gnugpl.png")
    assertEquals(true, fetched.nonEmpty)
    assertEquals(true, fetched.get.content.nonEmpty)
    assertArrayEquals(resource, fetched.get.content.get)
  }

  @Test
  def canDeleteFile() {
    val data = Array[Byte]('\12', '\54', '\12', '\51', '\0')
    fileStorage.store("test.dat", data)
    fileStorage.store("test/test2.dat", data)
    fileStorage.store("test/test3.dat", data)

    assertEquals(2, fileStorage.getFiles("test/").size)

    val fetched1_1 = fileStorage.getFile("test.dat")
    val fetched2_1 = fileStorage.getFile("test/test2.dat")
    val fetched3_1 = fileStorage.getFile("test/test3.dat")
    assertEquals(true, fetched1_1.nonEmpty)
    assertEquals(true, fetched2_1.nonEmpty)
    assertEquals(true, fetched3_1.nonEmpty)

    fileStorage.delete("test/", asDirectory = true)
    val fetched1_2 = fileStorage.getFile("test.dat")
    val fetched2_2 = fileStorage.getFile("test/test2.dat")
    val fetched3_2 = fileStorage.getFile("test/test3.dat")
    assertEquals(true, fetched1_2.nonEmpty)
    assertEquals(false, fetched2_2.nonEmpty)
    assertEquals(false, fetched3_2.nonEmpty)

    fileStorage.delete("test.dat")
    val fetched1_3 = fileStorage.getFile("test.dat")
    assertEquals(false, fetched1_3.nonEmpty)
  }
}
