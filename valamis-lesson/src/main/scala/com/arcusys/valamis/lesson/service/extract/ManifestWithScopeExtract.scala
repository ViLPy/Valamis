package com.arcusys.valamis.lesson.service.extract

import com.arcusys.valamis.lesson.scorm.model.ScormPackage
import com.arcusys.valamis.lesson.scorm.model.manifest._
import com.arcusys.valamis.lesson.storage.PackageScopeRuleStorage
import com.arcusys.valamis.lesson.tincan.model.{ TincanManifest, TincanPackage }
import com.arcusys.valamis.model.ScopeType.ScopeType

/**
 * Created by mminin on 06.03.15.
 */
trait ManifestWithScopeExtract extends ManifestExtract {

  protected def packageScopeRuleStorage: PackageScopeRuleStorage

  protected def toTincanManifestWithScopeValues(tincanPackage: TincanPackage, scope: ScopeType, scopeId: Option[String]): Seq[TincanManifest] = {
    val scopeRules = packageScopeRuleStorage.getAll(tincanPackage.id.toInt, scope, scopeId)
    if (scopeRules.isEmpty) {
      Seq(toTincanManifest(tincanPackage, None))
    } else {
      scopeRules.map(scopeRule => toTincanManifest(tincanPackage, Some(scopeRule)))
    }
  }

  protected def toScormManifestWithScopeValues(scormPackage: ScormPackage, scope: ScopeType, scopeId: Option[String]): Seq[Manifest] = {
    val scopeRules = packageScopeRuleStorage.getAll(scormPackage.id.toInt, scope, scopeId)
    if (scopeRules.isEmpty) {
      Seq(toScormManifest(scormPackage, None))
    } else {
      scopeRules.map(scopeRule => toScormManifest(scormPackage, Some(scopeRule)))
    }
  }
}
