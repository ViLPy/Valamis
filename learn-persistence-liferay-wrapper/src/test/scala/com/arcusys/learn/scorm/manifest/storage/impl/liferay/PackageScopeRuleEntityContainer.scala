package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalService
import com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule
import com.arcusys.learn.storage.impl.liferay.MockEntityContainer

import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 12.04.13
 */

object PackageScopeRuleEntityContainer extends MockEntityContainer[LFPackageScopeRuleLocalService, LFPackageScopeRule] {
  lazy val mockServiceBeanName = classOf[LFPackageScopeRuleLocalService].getName
  lazy val mockLocalService = mock[LFPackageScopeRuleLocalService]

  // service related mocks
  def createFunction = _.createLFPackageScopeRule()
  def addFunction = _.addLFPackageScopeRule(_)
  def deleteFunction = _.deleteLFPackageScopeRule(_)
  def updateFunction = _.updateLFPackageScopeRule(_)
  def orNull = _.orNull
  def getAllFunction = _.getLFPackageScopeRules(_,_)
  def removeAllFunction = _.removeAll()

  // entity related mocks
  def createMockEntity() = mock[LFPackageScopeRule]
  def mockEntityProperties(mockEntity: LFPackageScopeRule) {
    mockIntegerProperty(mockEntity.setPackageID(_), _.getPackageID)
    mockStringProperty(mockEntity.setScope(_), _.getScope)
    mockStringProperty(mockEntity.setScopeID(_), _.getScopeID)
    mockBooleanProperty(mockEntity.setVisibility(_), _.getVisibility)
    mockBooleanProperty(mockEntity.setIsDefault(_), _.getIsDefault)
  }
  def getIdFunction = _.getId

  mockLocalService.findByPackageID(any) answers {id=>
    /*val result = */filterByPackageID(id).asJava
    //if (result.isEmpty) Seq().asJava else result.asJava
  }

  mockLocalService.fetchByPackageIDAndScope(any,any,any) answers{ (paramsRaw, mockService) =>{
    getByPackageIDAndScope(paramsRaw, mockService)
  }}
  mockLocalService.findByPackageIDAndScope(any,any,any) answers{ (paramsRaw, mockService) =>{
    getByPackageIDAndScope(paramsRaw, mockService)
  }}

  mockLocalService.findByScope(any, any) answers {  (paramsRaw, mockService) =>{
    val paramsTuple: (Any, Any) = paramsRaw match {
      case Array(a, b) => (a, b)
    }
    val scope = paramsTuple._1 match { case x: String => x }
    val scopeID = paramsTuple._2 match {
      case x: String => x
      case null => null
    }

    internalStorage.values.filter(entity => entity.getScope == scope && entity.getScopeID == scopeID).toList.asJava
  }}

  def getByPackageIDAndScope(paramsRaw: Any, mockService: Any)={
    val paramsTuple: (Any, Any, Any) = paramsRaw match {
      case Array(a, b, c) if a.isInstanceOf[Int] && b.isInstanceOf[String] => (a, b, c)
    }
    val packageID = paramsTuple._1 match { case x: Int => x }
    val scope = paramsTuple._2 match { case x: String => x }
    val scopeID = paramsTuple._3 match {
      case x: String => x
      case null => null
    }

    val result = internalStorage.values.filter(entity => entity.getPackageID == packageID && entity.getScope == scope && entity.getScopeID == scopeID).headOption
    if (result.isEmpty) null else result.get
  }

  mockLocalService.findByAllByPackageIDAndScope(any,any,any) answers { (paramsRaw, mockService) =>
    val paramsTuple: (Any, Any, Any) = paramsRaw match {
      case Array(a, b, c) => (a, b, c)
    }
    val packageID = paramsTuple._1.asInstanceOf[Int]
    val scope = paramsTuple._2.toString
    val scopeID = paramsTuple._3 match {
      case x: String => x
      case null => null
    }

    internalStorage.values.filter(entity => entity.getPackageID == packageID && entity.getScope == scope && entity.getScopeID == scopeID).toList.asJava
  }

  mockLocalService.findByVisibility(any,any,any) answers { (paramsRaw, mockService) =>
    val paramsTuple: (Any, Any, Any) = paramsRaw match {
      case Array(a, b, c) => (a, b, c)
    }
    val scope = paramsTuple._1.toString
    val scopeID = paramsTuple._2 match {
      case x: String => x
      case null => null
    }
    val visibility = paramsTuple._3.asInstanceOf[Boolean]

    internalStorage.values.filter(entity => entity.getScope == scope && entity.getScopeID == scopeID && entity.getVisibility == visibility).toList.asJava

  }

  private def filterByPackageID(raw: Any): Seq[LFPackageScopeRule] = {
    internalStorage.values.filter(entity => entity.getPackageID == raw).toSeq
  }
}
