package com.arcusys.learn.filestorage.storage

import org.junit.{Before, Test}
import org.junit.Assert._

/**
 * User: dkudinov
 * Date: 12.3.2013
 */
trait FileStorageJUnitMethods {
  def fileStorage: FileStorage

  @Before
  def setUp() {
    fileStorage.renew()
  }

  @Test
  def canStoreFolderWithoutData() {
    fileStorage.store("test")
    val fetched = fileStorage.getFile("test")
    assertEquals(true, fetched.nonEmpty)
    assertEquals(true, fetched.get.content.isEmpty)
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
    val inputStream = Thread.currentThread.getContextClassLoader.getResourceAsStream("gnugpl.png")
    val source = scala.io.Source.fromInputStream(inputStream)(scala.io.Codec.ISO8859)
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
