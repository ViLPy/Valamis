package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.scorm.tracking.model.certificating.Certificate

import org.junit.Assert._
import org.junit.{ Test, Before }
import org.joda.time.DateTime

trait CertificateStorageJUnit {
  def certificateStorage: CertificateStorage

  @Before
  def setUp() {
    certificateStorage.renew()
  }

  @Test
  def noDataInitially() {
    // should be one guest
    assertEquals(0, certificateStorage.getAll.size)
  }

  @Test
  def canCreate() {
    certificateStorage.createAndGetID(Certificate(0, "certificate1", "", companyId = 1, createdAt = new DateTime))
    certificateStorage.createAndGetID(Certificate(0, "certificate2", "", companyId = 1, createdAt = new DateTime))
    // should be one guest
    assertEquals(2, certificateStorage.getAll.size)
  }

  @Test
  def canGetByID() {
    val item = Certificate(0, "certificate3", "", companyId = 1, createdAt = new DateTime)
    val testId = certificateStorage.createAndGetID(item)
    assertEquals(item.id, testId)
    val fetched = certificateStorage.getByID(testId).get
    assertEquals(item, fetched)
    assertEquals("certificate3", fetched.title)
  }

  @Test
  def canUpdate() {
    val item = Certificate(0, "certificate4", "", companyId = 1, createdAt = new DateTime)
    val testId = certificateStorage.createAndGetID(item)
    assertEquals(item.id, testId)
    val newName = "Updated Title"
    certificateStorage.modify(item.copy(title = newName))
    val fetched = certificateStorage.getByID(testId).get
    assertEquals(newName, fetched.title)
  }

}
