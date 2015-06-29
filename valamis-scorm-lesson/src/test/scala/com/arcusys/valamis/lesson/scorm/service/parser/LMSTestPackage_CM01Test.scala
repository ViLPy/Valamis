package com.arcusys.valamis.lesson.scorm.service.parser

import java.util.Calendar
import javax.xml.datatype.DatatypeFactory

import com.arcusys.valamis.lesson.scorm.model.manifest._
import org.junit.Assert._
import org.junit._

import scala.xml.XML

class LMSTestPackage_CM01Test {
  val root = XML.load(getClass.getResource("/LMSTestPackage_CM-01/imsmanifest.xml"))
  val doc = new ManifestParser(root, "title", "summary").parse
  val manifest = doc.manifest

  @Test
  def testManifest() {
    assertEquals(Some("1.1.1"), manifest.version)
    assertEquals(None, manifest.base)
    assertEquals("2004 4th Edition", manifest.scormVersion)
  }

  @Test
  def testManifestMetadata() {
    val metadata = manifest.metadata
    assertEquals(None, metadata)
  }

  @Test
  def testOrganizations() {
    val organizations = doc.organizations
    assertEquals(1, organizations.size)
    assertEquals("CM-01", manifest.defaultOrganizationID.get)
  }

  @Test
  def testOrganization() {
    val organization = doc.organizations(0).item.asInstanceOf[Organization]
    assertEquals("CM-01", organization.id)
    assertEquals(true, organization.objectivesGlobalToSystem)
    assertEquals(true, organization.sharedDataGlobalToSystem)
    assertEquals(None, organization.metadata)
    assertEquals("LMS Test Content Package CM-01", organization.title)
    assertEquals(3, doc.organizations(0).children.size)
  }

  @Test
  def testAllActivitiesMap() {
    val activities = doc.organizations(0).children
    val allActivities = doc.allActivities
    assertEquals(4, allActivities.size)
    assertEquals(doc.organizations(0).item, allActivities("CM-01"))
    assertEquals(activities(0).item, allActivities("activity_1"))
    assertEquals(activities(1).item, allActivities("activity_2"))
    assertEquals(activities(2).item, allActivities("activity_3"))
  }

  @Test
  def testActivity1() {
    val activities = doc.organizations(0).children
    val activity = activities(0).item
    assertEquals("activity_1", activity.id)
    assertEquals("Activity 1", activity.title)
    assertEquals(3, activity.hiddenNavigationControls.size)
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.Continue))
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.Previous))
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.SuspendAll))
    assertTrue(activity.visible)
    assertEquals(None, activity.metadata)
    assertEquals(CompletionThreshold.Default.completedByMeasure, activity.completionThreshold.completedByMeasure)
    assertEquals(CompletionThreshold.Default.minProgressMeasure, activity.completionThreshold.minProgressMeasure)
    assertEquals(CompletionThreshold.Default.progressWeight, activity.completionThreshold.progressWeight)
    assertTrue(activity.isInstanceOf[LeafActivity])
    val leaf = activity.asInstanceOf[LeafActivity]
    assertEquals("SEQ01", leaf.resourceIdentifier)
    assertEquals("?tc=CM-01&act=1", leaf.resourceParameters.get)
    assertEquals(None, leaf.timeLimitAction)
    assertEquals(0, leaf.data.size)
    assertEquals(None, leaf.dataFromLMS)
  }

  @Test
  def testActivity1Sequencing() {
    val activities = doc.organizations(0).children
    val sequencing = activities(0).item.sequencing
    assertEquals(None, sequencing.sharedId)
    assertEquals(None, sequencing.sharedSequencingIdReference)
    assertEquals(Some(BigInt(DatatypeFactory.newInstance.newDuration("P5Y6M4DT12H30M58S").getTimeInMillis(Calendar.getInstance.getTime))), sequencing.durationLimitInMilliseconds)
    assertEquals(None, sequencing.attemptLimit)
    assertTrue(sequencing.permissions.choiceForChildren)
    assertTrue(sequencing.permissions.choiceForNonDescendants)
    assertFalse(sequencing.permissions.flowForChildren)
    assertFalse(sequencing.permissions.forwardOnlyForChildren)
    assertTrue(sequencing.onlyCurrentAttemptObjectiveProgressForChildren)
    assertTrue(sequencing.onlyCurrentAttemptAttemptProgressForChildren)
    assertTrue(sequencing.rollupContribution.satisfaction.isDefined)
    assertTrue(sequencing.rollupContribution.completion.isDefined)
    assertEquals(BigDecimal.apply(1), sequencing.rollupContribution.objectiveMeasureWeight)
    assertEquals(0, sequencing.preConditionRules.size)
    assertEquals(0, sequencing.postConditionRules.size)
    assertEquals(0, sequencing.exitConditionRules.size)
    assertEquals(2, sequencing.rollupRules.size)
    assertTrue(sequencing.primaryObjective.isDefined)
    assertEquals(0, sequencing.nonPrimaryObjectives.size)
    assertEquals(None, sequencing.childrenSelection.reorder)
    assertEquals(None, sequencing.childrenSelection.take)
    assertTrue(sequencing.tracking.isDefined)
    assertFalse(sequencing.tracking.get.completionSetByContent)
    assertFalse(sequencing.tracking.get.objectiveSetByContent)
    assertFalse(sequencing.preventChildrenActivation)
    assertFalse(sequencing.constrainChoice)
    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.satisfaction.get.contributeToSatisfied)
    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.satisfaction.get.contributeToNotSatisfied)
    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.completion.get.contributeToCompleted)
    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.completion.get.contributeToIncomplete)
    assertTrue(sequencing.rollupContribution.measureSatisfactionIfActive)
  }

  @Test
  def testActivity2() {
    val activities = doc.organizations(0).children
    val activity = activities(1).item
    assertEquals("activity_2", activity.id)
    assertEquals("Activity 2", activity.title)
    assertEquals(3, activity.hiddenNavigationControls.size)
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.Continue))
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.Previous))
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.SuspendAll))
    assertTrue(activity.visible)
    assertEquals(None, activity.metadata)
    assertEquals(CompletionThreshold.Default.completedByMeasure, activity.completionThreshold.completedByMeasure)
    assertEquals(CompletionThreshold.Default.minProgressMeasure, activity.completionThreshold.minProgressMeasure)
    assertEquals(CompletionThreshold.Default.progressWeight, activity.completionThreshold.progressWeight)
    assertTrue(activity.isInstanceOf[LeafActivity])
    val leaf = activity.asInstanceOf[LeafActivity]
    assertEquals("SEQ01", leaf.resourceIdentifier)
    assertEquals("?tc=CM-01&act=2", leaf.resourceParameters.get)
    assertEquals(None, leaf.timeLimitAction)
    assertEquals(0, leaf.data.size)
    assertEquals(None, leaf.dataFromLMS)
  }

  @Test
  def testActivity2Sequencing() {
    val activities = doc.organizations(0).children
    val sequencing = activities(1).item.sequencing
    assertEquals(None, sequencing.sharedId)
    assertEquals(None, sequencing.sharedSequencingIdReference)

    assertEquals(None, sequencing.durationLimitInMilliseconds)
    assertEquals(None, sequencing.attemptLimit)

    assertTrue(sequencing.permissions.choiceForChildren)
    assertTrue(sequencing.permissions.choiceForNonDescendants)
    assertFalse(sequencing.permissions.flowForChildren)
    assertFalse(sequencing.permissions.forwardOnlyForChildren)

    assertTrue(sequencing.onlyCurrentAttemptObjectiveProgressForChildren)
    assertTrue(sequencing.onlyCurrentAttemptAttemptProgressForChildren)

    assertTrue(sequencing.rollupContribution.satisfaction.isDefined)
    assertTrue(sequencing.rollupContribution.completion.isDefined)
    assertEquals(BigDecimal(1), sequencing.rollupContribution.objectiveMeasureWeight)

    assertEquals(0, sequencing.preConditionRules.size)
    assertEquals(0, sequencing.postConditionRules.size)
    assertEquals(0, sequencing.exitConditionRules.size)
    assertEquals(2, sequencing.rollupRules.size)

    val primaryObjective = sequencing.primaryObjective.get
    assertEquals(None, primaryObjective.id)
    assertTrue(primaryObjective.satisfiedByMeasure)
    assertEquals(BigDecimal("0.8"), primaryObjective.minNormalizedMeasure)

    assertEquals(0, sequencing.nonPrimaryObjectives.size)

    assertEquals(None, sequencing.childrenSelection.reorder)
    assertEquals(None, sequencing.childrenSelection.take)

    assertTrue(sequencing.tracking.isDefined)
    assertFalse(sequencing.tracking.get.completionSetByContent)
    assertFalse(sequencing.tracking.get.objectiveSetByContent)

    assertFalse(sequencing.preventChildrenActivation)
    assertFalse(sequencing.constrainChoice)

    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.satisfaction.get.contributeToSatisfied)
    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.satisfaction.get.contributeToNotSatisfied)
    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.completion.get.contributeToCompleted)
    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.completion.get.contributeToIncomplete)

    assertTrue(sequencing.rollupContribution.measureSatisfactionIfActive)
  }

  @Test
  def testActivity3() {
    val activities = doc.organizations(0).children
    val activity = activities(2).item
    assertEquals("activity_3", activity.id)
    assertEquals("Activity 3", activity.title)
    assertEquals(3, activity.hiddenNavigationControls.size)
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.Continue))
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.Previous))
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.SuspendAll))
    assertTrue(activity.visible)
    assertEquals(None, activity.metadata)
    assertEquals(CompletionThreshold.Default.completedByMeasure, activity.completionThreshold.completedByMeasure)
    assertEquals(CompletionThreshold.Default.minProgressMeasure, activity.completionThreshold.minProgressMeasure)
    assertEquals(CompletionThreshold.Default.progressWeight, activity.completionThreshold.progressWeight)
    assertTrue(activity.isInstanceOf[LeafActivity])
    val leaf = activity.asInstanceOf[LeafActivity]
    assertEquals("SEQ01", leaf.resourceIdentifier)
    assertEquals("?tc=CM-01&act=3", leaf.resourceParameters.get)
    assertEquals(None, leaf.timeLimitAction)
    assertEquals(0, leaf.data.size)
    assertEquals(None, leaf.dataFromLMS)
  }

  @Test
  def testActivity3Sequencing() {
    val activities = doc.organizations(0).children
    val sequencing = activities(2).item.sequencing
    assertEquals(None, sequencing.sharedId)
    assertEquals(None, sequencing.sharedSequencingIdReference)

    assertEquals(Some(BigInt.apply(DatatypeFactory.newInstance.newDuration("P5Y6M4DT12H30M58.55S").getTimeInMillis(Calendar.getInstance.getTime))), sequencing.durationLimitInMilliseconds)
    assertEquals(None, sequencing.attemptLimit)

    assertTrue(sequencing.permissions.choiceForChildren)
    assertTrue(sequencing.permissions.choiceForNonDescendants)
    assertFalse(sequencing.permissions.flowForChildren)
    assertFalse(sequencing.permissions.forwardOnlyForChildren)

    assertTrue(sequencing.onlyCurrentAttemptObjectiveProgressForChildren)
    assertTrue(sequencing.onlyCurrentAttemptAttemptProgressForChildren)

    assertTrue(sequencing.rollupContribution.satisfaction.isDefined)
    assertTrue(sequencing.rollupContribution.completion.isDefined)
    assertEquals(BigDecimal.apply(1), sequencing.rollupContribution.objectiveMeasureWeight)

    assertEquals(0, sequencing.preConditionRules.size)
    assertEquals(0, sequencing.postConditionRules.size)
    assertEquals(0, sequencing.exitConditionRules.size)
    assertEquals(2, sequencing.rollupRules.size)

    val primaryObjective = sequencing.primaryObjective.get
    assertEquals(None, primaryObjective.id)
    assertTrue(primaryObjective.satisfiedByMeasure)
    assertEquals(BigDecimal.apply("0.7"), primaryObjective.minNormalizedMeasure)

    assertEquals(0, sequencing.nonPrimaryObjectives.size)

    assertEquals(None, sequencing.childrenSelection.reorder)
    assertEquals(None, sequencing.childrenSelection.take)

    assertTrue(sequencing.tracking.isDefined)

    assertFalse(sequencing.tracking.get.completionSetByContent)
    assertFalse(sequencing.tracking.get.objectiveSetByContent)

    assertFalse(sequencing.preventChildrenActivation)
    assertFalse(sequencing.constrainChoice)

    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.satisfaction.get.contributeToSatisfied)
    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.satisfaction.get.contributeToNotSatisfied)
    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.completion.get.contributeToCompleted)
    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.completion.get.contributeToIncomplete)

    assertTrue(sequencing.rollupContribution.measureSatisfactionIfActive)
  }

  @Test
  def testOrganizationSequencing() {
    val organization = doc.organizations(0).item.asInstanceOf[Organization]
    val sequencing = organization.sequencing
    assertEquals(None, sequencing.sharedId)
    assertEquals(None, sequencing.sharedSequencingIdReference)

    assertEquals(None, sequencing.durationLimitInMilliseconds)
    assertEquals(None, sequencing.attemptLimit)

    assertFalse(sequencing.permissions.choiceForChildren)
    assertTrue(sequencing.permissions.choiceForNonDescendants)
    assertTrue(sequencing.permissions.flowForChildren)
    assertFalse(sequencing.permissions.forwardOnlyForChildren)

    assertTrue(sequencing.onlyCurrentAttemptObjectiveProgressForChildren)
    assertTrue(sequencing.onlyCurrentAttemptAttemptProgressForChildren)

    assertTrue(sequencing.rollupContribution.satisfaction.isDefined)
    assertTrue(sequencing.rollupContribution.completion.isDefined)
    assertEquals(BigDecimal.apply(1), sequencing.rollupContribution.objectiveMeasureWeight)

    assertEquals(0, sequencing.preConditionRules.size)
    assertEquals(0, sequencing.postConditionRules.size)
    assertEquals(0, sequencing.exitConditionRules.size)
    assertEquals(2, sequencing.rollupRules.size)

    assertTrue(sequencing.primaryObjective.isDefined)
    assertEquals(0, sequencing.nonPrimaryObjectives.size)

    assertEquals(None, sequencing.childrenSelection.reorder)
    assertEquals(None, sequencing.childrenSelection.take)

    assertTrue(sequencing.tracking.isDefined)
    assertFalse(sequencing.tracking.get.completionSetByContent)
    assertFalse(sequencing.tracking.get.objectiveSetByContent)

    assertFalse(sequencing.preventChildrenActivation)
    assertFalse(sequencing.constrainChoice)

    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.satisfaction.get.contributeToSatisfied)
    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.satisfaction.get.contributeToNotSatisfied)
    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.completion.get.contributeToCompleted)
    assertEquals(RollupConsiderationType.Always, sequencing.rollupContribution.completion.get.contributeToIncomplete)

    assertTrue(sequencing.rollupContribution.measureSatisfactionIfActive)
  }

  @Test
  def testResources() {
    assertEquals(7, doc.resources.size)
    assertEquals(None, manifest.resourcesBase)
  }

  @Test
  def testResourceSEQ01() {
    val resource = doc.resourceMap("SEQ01")
    assertEquals("SEQ01", resource.id)
    assertTrue(resource.isInstanceOf[ScoResource])
    assertEquals("resources/", resource.base.get)
    assertEquals("SequencingTest.htm", resource.href.get)
    assertEquals(None, resource.metadata)
    assertEquals(1, resource.files.size)
    assertEquals("SequencingTest.htm", resource.files(0).href)
    assertEquals(None, resource.files(0).metadata)
    assertEquals(5, resource.dependencyIds.size)
    assertEquals("LMSFNCTS01", resource.dependencyIds(0))
    assertEquals("JAR01", resource.dependencyIds(1))
    assertEquals("ABOUT01", resource.dependencyIds(2))
    assertEquals("EMULATION01", resource.dependencyIds(3))
    assertEquals("LMSINCLUDE", resource.dependencyIds(4))
  }

  @Test
  def testResourceLMSFNCTS01() {
    val resource = doc.resourceMap("LMSFNCTS01")
    assertEquals("LMSFNCTS01", resource.id)
    assertTrue(resource.isInstanceOf[AssetResource])
    assertEquals(None, resource.base)
    assertEquals(None, resource.href)
    assertEquals(None, resource.metadata)
    assertEquals(1, resource.files.size)
    assertEquals("common/lmsrtefunctions.js", resource.files(0).href)
    assertEquals(None, resource.files(0).metadata)
    assertEquals(0, resource.dependencyIds.size)
  }

  @Test
  def testResourceJAR01() {
    val resource = doc.resourceMap("JAR01")
    assertEquals("JAR01", resource.id)
    assertTrue(resource.isInstanceOf[AssetResource])
    assertEquals("common/", resource.base.get)
    assertEquals(None, resource.href)
    assertEquals(None, resource.metadata)
    assertEquals(1, resource.files.size)
    assertEquals("LMSTest.jar", resource.files(0).href)
    assertEquals(None, resource.files(0).metadata)
    assertEquals(0, resource.dependencyIds.size)
  }

  @Test
  def testResourceABOUT01() {
    val resource = doc.resourceMap("ABOUT01")
    assertEquals("ABOUT01", resource.id)
    assertTrue(resource.isInstanceOf[AssetResource])
    assertEquals(None, resource.base)
    assertEquals(None, resource.href)
    assertEquals(None, resource.metadata)
    assertEquals(1, resource.files.size)
    assertEquals("common/About.js", resource.files(0).href)
    assertEquals(None, resource.files(0).metadata)
    assertEquals(0, resource.dependencyIds.size)
  }

  @Test
  def testResourceEMULATION01() {
    val resource = doc.resourceMap("EMULATION01")
    assertEquals("EMULATION01", resource.id)
    assertTrue(resource.isInstanceOf[AssetResource])
    assertEquals(None, resource.base)
    assertEquals(None, resource.href)
    assertEquals(None, resource.metadata)
    assertEquals(1, resource.files.size)
    assertEquals("common/EmulationCode.js", resource.files(0).href)
    assertEquals(None, resource.files(0).metadata)
    assertEquals(1, resource.dependencyIds.size)
    assertEquals("BROWSERDETECT01", resource.dependencyIds(0))
  }

  @Test
  def testResourceBROWSERDETECT01() {
    val resource = doc.resourceMap("BROWSERDETECT01")
    assertEquals("BROWSERDETECT01", resource.id)
    assertTrue(resource.isInstanceOf[AssetResource])
    assertEquals(None, resource.base)
    assertEquals(None, resource.href)
    assertEquals(None, resource.metadata)
    assertEquals(1, resource.files.size)
    assertEquals("common/BrowserDetect.js", resource.files(0).href)
    assertEquals(None, resource.files(0).metadata)
    assertEquals(0, resource.dependencyIds.size)
  }

  @Test
  def testResourceLMSINCLUDE() {
    val resource = doc.resourceMap("LMSINCLUDE")
    assertEquals("LMSINCLUDE", resource.id)
    assertTrue(resource.isInstanceOf[AssetResource])
    assertEquals(None, resource.base)
    assertEquals(None, resource.href)
    assertEquals(None, resource.metadata)
    assertEquals(1, resource.files.size)
    assertEquals("includes/LMSTestContentPackages_style.css", resource.files(0).href)
    assertEquals(None, resource.files(0).metadata)
    assertEquals(0, resource.dependencyIds.size)
  }

  @Test
  def testSequencingCollection() {
    assertEquals(0, doc.sequencingCollection.size)
  }
}