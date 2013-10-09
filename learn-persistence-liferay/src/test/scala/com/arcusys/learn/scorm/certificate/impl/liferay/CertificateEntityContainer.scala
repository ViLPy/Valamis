package com.arcusys.learn.scorm.certificate.impl.liferay

import com.arcusys.learn.persistence.liferay.service.{LFCertificateLocalService, LFPackageScopeRuleLocalService}
import com.arcusys.learn.persistence.liferay.model.{LFCertificate, LFPackageScopeRule}
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import scala.collection.JavaConverters._


object CertificateEntityContainer extends MockEntityContainer[LFCertificateLocalService, LFCertificate] {
  lazy val mockServiceBeanName = classOf[LFCertificateLocalService].getName
  lazy val mockLocalService = mock[LFCertificateLocalService]

  // service related mocks
  def createFunction = _.createLFCertificate()
  def addFunction = _.addLFCertificate(_)
  def deleteFunction = _.deleteLFCertificate(_)
  def updateFunction = _.updateLFCertificate(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFCertificates(_,_)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFCertificate]
  def mockEntityProperties(mockEntity: LFCertificate) {
    mockStringProperty(mockEntity.setDescription(_), _.getDescription)
    mockBooleanProperty(mockEntity.setIsPermanent(_), _.getIsPermanent)
    mockStringProperty(mockEntity.setLogo(_), _.getLogo)
    mockStringProperty(mockEntity.setTitle(_), _.getTitle)
  }
  def getIdFunction = _.getId


  mockLocalService.fetchLFCertificate(any) answers{ (id) =>{
    getByID(id.asInstanceOf[Int])
  }}

  def getByID(id: Long)={
    val result = internalStorage.values.filter(entity => entity.getId == id).headOption
    if (result.isEmpty) null else result.get
  }


}
