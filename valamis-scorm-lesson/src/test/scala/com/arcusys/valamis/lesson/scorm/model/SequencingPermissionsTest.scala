package com.arcusys.valamis.lesson.scorm.model

import com.arcusys.valamis.lesson.scorm.model.manifest.SequencingPermissions
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class SequencingPermissionsTest extends FlatSpec with ShouldMatchers {

  "Sequencing permissions" can "be constructed" in {
    val permissions = new SequencingPermissions(choiceForChildren = false, choiceForNonDescendants = false, flowForChildren = true, forwardOnlyForChildren = true)
    permissions.choiceForChildren should equal(false)
    permissions.choiceForNonDescendants should equal(false)
    permissions.flowForChildren should equal(true)
    permissions.forwardOnlyForChildren should equal(true)
  }

  it should "have a default value" in {
    val permissions = SequencingPermissions.Default
    permissions.choiceForChildren should equal(true)
    permissions.choiceForNonDescendants should equal(true)
    permissions.flowForChildren should equal(false)
    permissions.forwardOnlyForChildren should equal(false)
  }

}
