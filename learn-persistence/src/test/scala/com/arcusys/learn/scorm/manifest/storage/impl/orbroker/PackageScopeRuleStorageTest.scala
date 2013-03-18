package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import org.junit._
import Assert._
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.storage.impl.orbroker.ParameterizedUnitTests
import runner.RunWith
import runners.Parameterized

@RunWith(value = classOf[Parameterized])
class PackageScopeRuleStorageTest(dbFileName: String) extends ParameterizedUnitTests(dbFileName) {
  val packagesScopeRuleStorage = new PackageScopeRuleStorageImpl
  val packagesStorage = new PackagesStorageImpl

  @Before
  def setUp() {
    packagesStorage.renew()
    packagesScopeRuleStorage.renew()
  }


  @Test
  def canCreate() {
    val manifest = new Manifest(12, None, Some("NoneBase/"), "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false)
    val testPackageId = packagesStorage.createAndGetID(manifest)
    packagesScopeRuleStorage.create(testPackageId, ScopeType.Instance, None, true)
    val rule = packagesScopeRuleStorage.get(testPackageId, ScopeType.Instance, None)
    assertEquals(rule.get.visibility, true)
    assertEquals(rule.get.isDefault, None)
    assertEquals(rule.get.packageID, testPackageId)
  }

  @Test
  def setVisibility() {
    val manifest = new Manifest(12, None, Some("NoneBase/"), "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(0), isDefault = false)
    val testPackageId = packagesStorage.createAndGetID(manifest)
    packagesScopeRuleStorage.create(testPackageId, ScopeType.Instance, None, false)
    packagesScopeRuleStorage.create(testPackageId, ScopeType.Site, Option("test"), false)
    val rule = packagesScopeRuleStorage.get(testPackageId, ScopeType.Instance, None)
    assertEquals(rule.get.visibility, false)
    assertEquals(rule.get.isDefault, None)
    assertEquals(rule.get.packageID, testPackageId)

    packagesScopeRuleStorage.update(testPackageId, ScopeType.Instance, None, true)
    packagesScopeRuleStorage.update(testPackageId, ScopeType.Site, Option("test"), true)

    val updatedRule = packagesScopeRuleStorage.get(testPackageId, ScopeType.Instance, None)
    assertEquals(updatedRule.get.visibility, true)
    assertEquals(updatedRule.get.isDefault, None)
    assertEquals(updatedRule.get.packageID, testPackageId)

    val siteRule = packagesScopeRuleStorage.get(testPackageId, ScopeType.Site, Option("test"))
    assertEquals(siteRule.get.visibility, true)
    assertEquals(siteRule.get.isDefault, None)
    assertEquals(siteRule.get.packageID, testPackageId)
  }

  @Test
  def setVisibilityAndGetByInstance() {
    setUp()
    val manifest = new Manifest(12, None, Some("NoneBase/"), "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(2), isDefault = false)
    val testPackageId = packagesStorage.createAndGetID(manifest)
    packagesScopeRuleStorage.create(testPackageId, ScopeType.Instance, None, false)
    val testPackageId2 = packagesStorage.createAndGetID(manifest)
    packagesScopeRuleStorage.create(testPackageId2, ScopeType.Instance, None, true)
    val testPackageId3 = packagesStorage.createAndGetID(manifest)
    packagesScopeRuleStorage.create(testPackageId3, ScopeType.Instance, None, true)

    val packageByID = packagesScopeRuleStorage.get(testPackageId2, ScopeType.Instance, None)
    assertEquals(true, packageByID.get.visibility)

    val packages = packagesStorage.getAllForInstance(List(1, 2))
    assertEquals(3, packages.length)
    assertEquals(Some(false), packages(0).visibility)
    assertEquals(Some(true), packages(1).visibility)
    assertEquals(Some(true), packages(2).visibility)
  }

  @Test
  def setVisibilityAndGetByInstance1() {
    setUp()
    val manifest = new Manifest(12, None, Some("NoneBase/"), "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(2), isDefault = false)
    val testPackageId = packagesStorage.createAndGetID(manifest)
    packagesScopeRuleStorage.create(testPackageId, ScopeType.Instance, None, false)
    packagesScopeRuleStorage.update(testPackageId, ScopeType.Instance, None, true)

    val packages = packagesStorage.getAllForInstance(List(1, 2))
    assertEquals(1, packages.length)
    assertEquals(Some(true), packages(0).visibility)

    val packageByID = packagesStorage.getByID(testPackageId, 2, ScopeType.Instance, "")
    assertEquals(Some(true), packageByID.get.visibility)
    assertEquals(Some(2), packageByID.get.courseID)
    assertEquals(testPackageId, packageByID.get.id)
  }

  @Test
  def setVisibilityAndGetByInstanceOnlyVisible() {
    setUp()
    val manifest = new Manifest(12, None, Some("NoneBase/"), "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(2), isDefault = false)
    val testPackageId = packagesStorage.createAndGetID(manifest)
    packagesScopeRuleStorage.create(testPackageId, ScopeType.Instance, None, false)
    val testPackageId2 = packagesStorage.createAndGetID(manifest)
    packagesScopeRuleStorage.create(testPackageId2, ScopeType.Instance, None, true)
    val testPackageId3 = packagesStorage.createAndGetID(manifest)
    packagesScopeRuleStorage.create(testPackageId3, ScopeType.Instance, None, true)

    val packages = packagesStorage.getInstanceScopeOnlyVisbile(List(1, 2))
    assertEquals(2, packages.length)
    assertEquals(Some(true), packages(0).visibility)
    assertEquals(Some(true), packages(1).visibility)
  }

  @Test
  def setIsDefault() {
    setUp()
    val manifest = new Manifest(12, None, Some("NoneBase/"), "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(2), isDefault = false)
    val manifest2 = new Manifest(15, None, Some("NoneBase/"), "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(333), isDefault = false)
    val manifest3 = new Manifest(20, None, Some("NoneBase/"), "", Some("defaultOrganizationIdentifier"), Some("resourcesBase/"), "title", courseID = Some(2), isDefault = false)
    val testPackageId = packagesStorage.createAndGetID(manifest)
    packagesScopeRuleStorage.create(testPackageId, ScopeType.Instance, None, false)
    packagesScopeRuleStorage.create(testPackageId, ScopeType.Site, Option("2"), false)

    val testPackageId2 = packagesStorage.createAndGetID(manifest2)
    packagesScopeRuleStorage.create(testPackageId2, ScopeType.Instance, None, false)
    packagesScopeRuleStorage.create(testPackageId2, ScopeType.Site, Option("333"), false)

    val testPackageId3 = packagesStorage.createAndGetID(manifest3)
    packagesScopeRuleStorage.create(testPackageId3, ScopeType.Instance, None, false)
    packagesScopeRuleStorage.create(testPackageId3, ScopeType.Site, Option("2"), false)


    packagesScopeRuleStorage.updateIsDefaultProperty(testPackageId, ScopeType.Site, Option("2"), true)

    val rule1 = packagesScopeRuleStorage.get(testPackageId, ScopeType.Site, Option("2"))
    assertEquals(Option(true), rule1.get.isDefault)

    packagesScopeRuleStorage.updateIsDefaultProperty(testPackageId3, ScopeType.Site, Option("2"), true)

    val rule2 = packagesScopeRuleStorage.get(testPackageId, ScopeType.Site, Option("2"))
    val rule3 = packagesScopeRuleStorage.get(testPackageId3, ScopeType.Site, Option("2"))
    assertEquals(None, rule2.get.isDefault)
    assertEquals(Option(true), rule3.get.isDefault)

    val packages = packagesStorage.getByCourseID(Option(2))
    assertEquals(2, packages.length)
    assertEquals(Some(false), packages(0).visibility)
    assertEquals(Some(false), packages(1).visibility)

    assertEquals(false, packages(0).isDefault)
    assertEquals(true, packages(1).isDefault)

    packagesScopeRuleStorage.updateIsDefaultProperty(testPackageId, ScopeType.Instance, None, true)
    packagesScopeRuleStorage.updateIsDefaultProperty(testPackageId2, ScopeType.Instance, None, true)
    packagesScopeRuleStorage.updateIsDefaultProperty(testPackageId3, ScopeType.Instance, None, true)
    packagesScopeRuleStorage.update(testPackageId, ScopeType.Instance, None, true)
    packagesScopeRuleStorage.update(testPackageId3, ScopeType.Instance, None, true)
    val packages2 = packagesStorage.getAllForInstance(List(1, 2, 333))
    assertEquals(3, packages2.length)
    assertEquals(Some(true), packages2(0).visibility)
    assertEquals(Some(false), packages2(1).visibility)
    assertEquals(Some(true), packages2(2).visibility)

    assertEquals(false, packages2(0).isDefault)
    assertEquals(false, packages2(1).isDefault)
    assertEquals(true, packages2(2).isDefault)

  }

}
