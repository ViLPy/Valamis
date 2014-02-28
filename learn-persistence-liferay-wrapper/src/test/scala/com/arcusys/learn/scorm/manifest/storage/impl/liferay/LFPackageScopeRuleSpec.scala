package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mock.Mockito
import org.specs2.specification.Scope
import org.specs2.matcher.ThrownExpectations
import com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalServiceUtil
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.scorm.manifest.model.{ScopeType, PackageScopeRule}

/**
 * User: Yulia.Glushonkova
 * Date: 12.04.13
 */
class LFPackageScopeRuleSpec extends SpecificationWithJUnit with Mockito with ThrownExpectations {
  "Mockito" should {
    "mock service method" in new Context {
      LFPackageScopeRuleLocalServiceUtil.createLFPackageScopeRule() must not(throwA[Exception])
      there was atLeastOne(packageService).createLFPackageScopeRule()
    }
  }
  "LFPackageScopeRuleStorageImpl" should {

    "execute 'create' without errors" in new Context {
      val scope = ScopeType.Instance
      packageStorage.create(new PackageScopeRule(1, scope, None, true, false),
        "scope" -> scope.toString) must not(throwA[Exception])
    }

    "execute 'get by package' without errors" in new Context{
      val scope = ScopeType.Instance
      packageStorage.create(new PackageScopeRule(1, scope, None, true, false),
        "scope" -> scope.toString) must not(throwA[Exception])

      val rule = packageStorage.getOne("packageID"->1, "scope" -> scope.toString, "scopeID" -> "-1")
      rule must beSome
      rule.get.packageID must beEqualTo(1)
      rule.get.scope must beEqualTo(scope)
    }

    "execute 'get by package and scope' without errors" in new Context{
      val scope1 = ScopeType.Instance
      val scope2 = ScopeType.Page
      packageStorage.create(new PackageScopeRule(2, scope1, None, true, false), "scope" -> scope1.toString) must not(throwA[Exception])
      packageStorage.create(new PackageScopeRule(2, scope2, Some("page1"), true, false), "scope" -> scope2.toString) must not(throwA[Exception])

      val rule = packageStorage.getOne("packageID"->2, "scope"-> scope1.toString, "scopeID" -> "-1")
      rule must beSome
      rule.get.packageID must beEqualTo(2)
      rule.get.scope must beEqualTo(scope1)
      rule.get.scopeID must beNone

      val rule2 = packageStorage.getOne("packageID"->2, "scope"-> scope2.toString, "scopeID" -> "page1")
      rule2 must beSome
      rule2.get.packageID must beEqualTo(2)
      rule2.get.scope must beEqualTo(scope2)
      rule2.get.scopeID must beEqualTo(Some("page1"))

      val rule3 = packageStorage.getAll("packageID"->2, "scope"-> scope1.toString, "scopeID" -> "-1")
      rule3.length must beEqualTo(1)
      rule3.head.packageID must beEqualTo(2)
      rule3.head.scope must beEqualTo(scope1)
      rule3.head.scopeID must beNone

      val rule4 = packageStorage.getAll("packageID"->2, "scope"-> scope2.toString, "scopeID" -> "page1")
      rule4.length must beEqualTo(1)
      rule4.head.packageID must beEqualTo(2)
      rule4.head.scope must beEqualTo(scope2)
      rule4.head.scopeID must beEqualTo(Some("page1"))

    }

    "execute 'get visible' without errors" in new Context{
      val scope = ScopeType.Site
      val scope2 = ScopeType.Page
      packageStorage.create(new PackageScopeRule(3, scope, Option("site1"), true, false), "scope" -> scope.toString) must not(throwA[Exception])
      packageStorage.create(new PackageScopeRule(3, scope2, Option("page1"), true, false), "scope" -> scope.toString) must not(throwA[Exception])
      packageStorage.create(new PackageScopeRule(4, scope, Option("site1"), false, false), "scope" -> scope.toString) must not(throwA[Exception])
      packageStorage.create(new PackageScopeRule(5, scope, Option("site1"), true, false), "scope" -> scope.toString) must not(throwA[Exception])

      val rules = packageStorage.getAll("scope"->scope.toString, "scopeID"->"site1", "visibility"-> true)
      rules.length must beEqualTo(2)
    }

    "execute 'modify' without errors" in new Context{
      val rule = new PackageScopeRule(6, ScopeType.Instance, None, true, false)
      packageStorage.create(rule, "scope" -> ScopeType.Instance.toString) must not(throwA[Exception])
      val rule1 = new PackageScopeRule(6, ScopeType.Instance, None, false, false)
      packageStorage.modify(rule1, "scope" -> ScopeType.Instance, "scopeID" -> None) must not(throwA[Exception])
      val fetched = packageStorage.getOne("packageID"->6, "scope"-> ScopeType.Instance.toString, "scopeID" -> "-1")
      fetched must beSome
      fetched.get.visibility must beFalse
    }

    "execute 'delete' without errors" in new Context{
      val rule = new PackageScopeRule(7, ScopeType.Instance, None, true, false)
      packageStorage.create(rule, "scope" -> ScopeType.Instance.toString) must not(throwA[Exception])
      packageStorage.delete("packageID"->7) must not(throwA[Exception])
      val fetched = packageStorage.getOne("packageID"->7, "scope" -> ScopeType.Instance.toString, "scopeID" -> "-1")
      fetched must beNone
    }
  }

  trait Context extends Scope {
    // do initialize mock services
    val packageService = PackageScopeRuleEntityContainer.mockLocalService
    val packageStorage: EntityStorage[PackageScopeRule] = new LFPackageScopeRuleStorageImpl() {}
  }

}
