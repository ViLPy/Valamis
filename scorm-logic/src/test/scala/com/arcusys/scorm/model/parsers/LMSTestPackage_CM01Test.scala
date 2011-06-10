package com.arcusys.scorm.model.parsers

import org.junit._
import Assert._
import java.io.File
import com.arcusys.scorm.model._
import javax.xml.datatype.DatatypeFactory
import java.util.Calendar
import scala.xml.XML

class LMSTestPackage_CM01Test {
  val root = XML.loadFile(new File("src/test/resources/LMSTestPackage_CM-01/imsmanifest.xml"))
  val manifest = new ManifestParser(root).parse

  @Test
  def testManifest = {
    assertEquals("LMSTestPackage_CM-01", manifest.identifier)
    assertEquals(Some("1.1.1"), manifest.version)
    assertEquals(None, manifest.base)
  }

  @Test
  def testManifestMetadata = {
    val metadata = manifest.metadata;
    assertEquals("ADL SCORM", metadata.schema);
    assertEquals("2004 4th Edition", metadata.schemaversion);
    assertEquals(0, metadata.externalMetadataLocations.size);
    assertEquals(0, metadata.inlineMetadata.size);
  }

  @Test
  def testOrganizations = {
    val organizations = manifest.organizations
    assertEquals(1, organizations.size)
    assertEquals("CM-01", manifest.defaultOrganizationIdentifier.get)
  }

  @Test
  def testOrganization = {
    val organization = manifest.organizations("CM-01")
    assertEquals("CM-01", organization.identifier)
    assertEquals(true, organization.objectivesGlobalToSystem)
    assertEquals(true, organization.sharedDataGlobalToSystem)
    assertEquals(None, organization.metadata)
    assertEquals("LMS Test Content Package CM-01 ", organization.title)
    assertEquals(3, organization.activities.size)
  }

  @Test
  def testAllActivitiesMap = {
    val organizationActivities = manifest.organizations("CM-01").activities;
    val allActivities = manifest.allActivities;
    assertEquals(3, allActivities.size);
    assertEquals(organizationActivities(0), allActivities("activity_1"));
    assertEquals(organizationActivities(1), allActivities("activity_2"));
    assertEquals(organizationActivities(2), allActivities("activity_3"));
  }

  @Test
  def testActivity1 = {
    val activity = manifest.organizations("CM-01").activities(0)
    assertEquals("activity_1", activity.identifier)
    assertEquals("Activity 1", activity.title)
    assertEquals(3, activity.hiddenNavigationControls.size)
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.Continue))
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.Previous))
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.SuspendAll))
    assertTrue(activity.visible)
    assertEquals(None, activity.metadata)
    assertEquals(None, activity.completionThreshold)
    assertTrue(activity.isInstanceOf[LeafActivity])
    val leaf = activity.asInstanceOf[LeafActivity]
    assertEquals("SEQ01", leaf.resourceIdentifier)
    assertEquals("?tc=CM-01&act=1", leaf.resourceParameters.get)
    assertEquals(TimeLimitAction.NotDefined, leaf.timeLimitAction)
    assertEquals(0, leaf.data.size)
    assertEquals(None, leaf.dataFromLMS)
  }

  @Test
  def testActivity1Sequencing = {
    val sequencing = manifest.organizations("CM-01").activities(0).sequencing.get
    assertEquals(None,sequencing.sharedId);
    assertEquals(None,sequencing.sharedSequencingIdReference)
    assertEquals(Some(BigInt(DatatypeFactory.newInstance.newDuration("P5Y6M4DT12H30M58S").getTimeInMillis(Calendar.getInstance.getTime))), sequencing.durationLimitInMilliseconds)
    assertEquals(None, sequencing.attemptLimit);
    assertTrue(sequencing.choicePermittedForChildren);
    assertTrue(sequencing.choicePermittedForNonDescendants);
    assertFalse(sequencing.continuePreviousFlowPermittedForChildren);
    assertFalse(sequencing.forwardOnlyForChildren);
    assertTrue(sequencing.rollupOnlyCurrentAttemptObjectiveProgressForChildren);
    assertTrue(sequencing.rollupOnlyCurrentAttemptAttemptProgressForChildren);
    assertTrue(sequencing.rollupObjectiveSatisfied);
    assertTrue(sequencing.rollupProgressCompletion);
    assertEquals(BigDecimal.apply(1), sequencing.objectiveMeasureWeight);
    assertEquals(0, sequencing.preConditionRules.size);
    assertEquals(0, sequencing.postConditionRules.size);
    assertEquals(0, sequencing.exitConditionRules.size);
    assertEquals(0, sequencing.rollupRules.size);
    assertEquals(None, sequencing.primaryObjective);
    assertEquals(0, sequencing.nonPrimaryObjectives.size);
    assertEquals(RandomizationTimingType.Never, sequencing.childrenRandomizationTiming);
    assertEquals(None, sequencing.childrenSelectCount);
    assertFalse(sequencing.reorderChildren);
    assertEquals(RandomizationTimingType.Never, sequencing.childrenSelectionTiming);
    assertTrue(sequencing.tracked);
    assertFalse(sequencing.completionSetByContent);
    assertFalse(sequencing.objectiveSetByContent);
    assertFalse(sequencing.preventChildrenActivation);
    assertFalse(sequencing.constrainChoice);
    assertEquals(RollupConsiderationType.Always, sequencing.contributeToSatisfiedRollup);
    assertEquals(RollupConsiderationType.Always, sequencing.contributeToNotSatisfiedRollup);
    assertEquals(RollupConsiderationType.Always, sequencing.contributeToCompletedRollup);
    assertEquals(RollupConsiderationType.Always, sequencing.contributeToIncompleteRollup);
    assertTrue(sequencing.measureSatisfactionIfActive);
  }

  @Test
  def testActivity2 = {
    val activity = manifest.organizations("CM-01").activities(1)
    assertEquals("activity_2", activity.identifier)
    assertEquals("Activity 2", activity.title)
    assertEquals(3, activity.hiddenNavigationControls.size)
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.Continue))
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.Previous))
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.SuspendAll))
    assertTrue(activity.visible)
    assertEquals(None, activity.metadata)
    assertEquals(None, activity.completionThreshold)
    assertTrue(activity.isInstanceOf[LeafActivity])
    val leaf = activity.asInstanceOf[LeafActivity]
    assertEquals("SEQ01", leaf.resourceIdentifier)
    assertEquals("?tc=CM-01&act=2", leaf.resourceParameters.get)
    assertEquals(TimeLimitAction.NotDefined, leaf.timeLimitAction)
    assertEquals(0, leaf.data.size)
    assertEquals(None, leaf.dataFromLMS)
  }

  @Test
  def testActivity2Sequencing = {
    val sequencing = manifest.organizations("CM-01").activities(1).sequencing.get
    assertEquals(None, sequencing.sharedId);
    assertEquals(None, sequencing.sharedSequencingIdReference);

    assertEquals(None, sequencing.durationLimitInMilliseconds);
    assertEquals(None, sequencing.attemptLimit);

    assertTrue(sequencing.choicePermittedForChildren);
    assertTrue(sequencing.choicePermittedForNonDescendants);
    assertFalse(sequencing.continuePreviousFlowPermittedForChildren);
    assertFalse(sequencing.forwardOnlyForChildren);

    assertTrue(sequencing.rollupOnlyCurrentAttemptObjectiveProgressForChildren);
    assertTrue(sequencing.rollupOnlyCurrentAttemptAttemptProgressForChildren);

    assertTrue(sequencing.rollupObjectiveSatisfied);
    assertTrue(sequencing.rollupProgressCompletion);
    assertEquals(BigDecimal.apply(1), sequencing.objectiveMeasureWeight);

    assertEquals(0, sequencing.preConditionRules.size);
    assertEquals(0, sequencing.postConditionRules.size);
    assertEquals(0, sequencing.exitConditionRules.size);
    assertEquals(0, sequencing.rollupRules.size);

    val primaryObjective = sequencing.primaryObjective.get
    assertEquals(None, primaryObjective.identifier);
    assertTrue(primaryObjective.satisfiedByMeasure);
    assertEquals(BigDecimal.apply("0.8"), primaryObjective.minNormalizedMeasure);
    assertEquals(0, primaryObjective.objectiveMap.size);

    assertEquals(0, sequencing.nonPrimaryObjectives.size);

    assertEquals(RandomizationTimingType.Never, sequencing.childrenRandomizationTiming);
    assertEquals(None, sequencing.childrenSelectCount);
    assertFalse(sequencing.reorderChildren);
    assertEquals(RandomizationTimingType.Never, sequencing.childrenSelectionTiming);

    assertTrue(sequencing.tracked);

    assertFalse(sequencing.completionSetByContent);
    assertFalse(sequencing.objectiveSetByContent);

    assertFalse(sequencing.preventChildrenActivation);
    assertFalse(sequencing.constrainChoice);

    assertEquals(RollupConsiderationType.Always, sequencing.contributeToSatisfiedRollup);
    assertEquals(RollupConsiderationType.Always, sequencing.contributeToNotSatisfiedRollup);
    assertEquals(RollupConsiderationType.Always, sequencing.contributeToCompletedRollup);
    assertEquals(RollupConsiderationType.Always, sequencing.contributeToIncompleteRollup);

    assertTrue(sequencing.measureSatisfactionIfActive);
  }

  @Test
  def testActivity3 = {
    val activity = manifest.organizations("CM-01").activities(2)
    assertEquals("activity_3", activity.identifier)
    assertEquals("Activity 3", activity.title)
    assertEquals(3, activity.hiddenNavigationControls.size)
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.Continue))
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.Previous))
    assertTrue(activity.hiddenNavigationControls.contains(NavigationControlType.SuspendAll))
    assertTrue(activity.visible)
    assertEquals(None, activity.metadata)
    assertEquals(None, activity.completionThreshold)
    assertTrue(activity.isInstanceOf[LeafActivity])
    val leaf = activity.asInstanceOf[LeafActivity]
    assertEquals("SEQ01", leaf.resourceIdentifier)
    assertEquals("?tc=CM-01&act=3", leaf.resourceParameters.get)
    assertEquals(TimeLimitAction.NotDefined, leaf.timeLimitAction)
    assertEquals(0, leaf.data.size)
    assertEquals(None, leaf.dataFromLMS)
  }

  @Test
  def testActivity3Sequencing = {
    val sequencing = manifest.organizations("CM-01").activities(2).sequencing.get
    assertEquals(None, sequencing.sharedId);
    assertEquals(None, sequencing.sharedSequencingIdReference);

    assertEquals(Some(BigInt.apply(DatatypeFactory.newInstance.newDuration("P5Y6M4DT12H30M58.55S").getTimeInMillis(Calendar.getInstance.getTime))), sequencing.durationLimitInMilliseconds);
    assertEquals(None, sequencing.attemptLimit);

    assertTrue(sequencing.choicePermittedForChildren);
    assertTrue(sequencing.choicePermittedForNonDescendants);
    assertFalse(sequencing.continuePreviousFlowPermittedForChildren);
    assertFalse(sequencing.forwardOnlyForChildren);

    assertTrue(sequencing.rollupOnlyCurrentAttemptObjectiveProgressForChildren);
    assertTrue(sequencing.rollupOnlyCurrentAttemptAttemptProgressForChildren);

    assertTrue(sequencing.rollupObjectiveSatisfied);
    assertTrue(sequencing.rollupProgressCompletion);
    assertEquals(BigDecimal.apply(1), sequencing.objectiveMeasureWeight);

    assertEquals(0, sequencing.preConditionRules.size);
    assertEquals(0, sequencing.postConditionRules.size);
    assertEquals(0, sequencing.exitConditionRules.size);
    assertEquals(0, sequencing.rollupRules.size);

    val primaryObjective = sequencing.primaryObjective.get
    assertEquals(None, primaryObjective.identifier);
    assertTrue(primaryObjective.satisfiedByMeasure);
    assertEquals(BigDecimal.apply("0.7"), primaryObjective.minNormalizedMeasure);
    assertEquals(0, primaryObjective.objectiveMap.size);

    assertEquals(0, sequencing.nonPrimaryObjectives.size);

    assertEquals(RandomizationTimingType.Never, sequencing.childrenRandomizationTiming);
    assertEquals(None, sequencing.childrenSelectCount);
    assertFalse(sequencing.reorderChildren);
    assertEquals(RandomizationTimingType.Never, sequencing.childrenSelectionTiming);

    assertTrue(sequencing.tracked);

    assertFalse(sequencing.completionSetByContent);
    assertFalse(sequencing.objectiveSetByContent);

    assertFalse(sequencing.preventChildrenActivation);
    assertFalse(sequencing.constrainChoice);

    assertEquals(RollupConsiderationType.Always, sequencing.contributeToSatisfiedRollup);
    assertEquals(RollupConsiderationType.Always, sequencing.contributeToNotSatisfiedRollup);
    assertEquals(RollupConsiderationType.Always, sequencing.contributeToCompletedRollup);
    assertEquals(RollupConsiderationType.Always, sequencing.contributeToIncompleteRollup);

    assertTrue(sequencing.measureSatisfactionIfActive);
  }

  @Test
  def testOrganizationSequencing = {
    val sequencing = manifest.organizations("CM-01").sequencing.get
    assertEquals(None, sequencing.sharedId);
    assertEquals(None, sequencing.sharedSequencingIdReference);

    assertEquals(None, sequencing.durationLimitInMilliseconds);
    assertEquals(None, sequencing.attemptLimit);

    assertFalse(sequencing.choicePermittedForChildren);
    assertTrue(sequencing.choicePermittedForNonDescendants);
    assertTrue(sequencing.continuePreviousFlowPermittedForChildren);
    assertFalse(sequencing.forwardOnlyForChildren);

    assertTrue(sequencing.rollupOnlyCurrentAttemptObjectiveProgressForChildren);
    assertTrue(sequencing.rollupOnlyCurrentAttemptAttemptProgressForChildren);

    assertTrue(sequencing.rollupObjectiveSatisfied);
    assertTrue(sequencing.rollupProgressCompletion);
    assertEquals(BigDecimal.apply(1), sequencing.objectiveMeasureWeight);

    assertEquals(0, sequencing.preConditionRules.size);
    assertEquals(0, sequencing.postConditionRules.size);
    assertEquals(0, sequencing.exitConditionRules.size);
    assertEquals(0, sequencing.rollupRules.size);

    assertEquals(None, sequencing.primaryObjective);
    assertEquals(0, sequencing.nonPrimaryObjectives.size);

    assertEquals(RandomizationTimingType.Never, sequencing.childrenRandomizationTiming);
    assertEquals(None, sequencing.childrenSelectCount);
    assertFalse(sequencing.reorderChildren);
    assertEquals(RandomizationTimingType.Never, sequencing.childrenSelectionTiming);

    assertTrue(sequencing.tracked);

    assertFalse(sequencing.completionSetByContent);
    assertFalse(sequencing.objectiveSetByContent);

    assertFalse(sequencing.preventChildrenActivation);
    assertFalse(sequencing.constrainChoice);

    assertEquals(RollupConsiderationType.Always, sequencing.contributeToSatisfiedRollup);
    assertEquals(RollupConsiderationType.Always, sequencing.contributeToNotSatisfiedRollup);
    assertEquals(RollupConsiderationType.Always, sequencing.contributeToCompletedRollup);
    assertEquals(RollupConsiderationType.Always, sequencing.contributeToIncompleteRollup);

    assertTrue(sequencing.measureSatisfactionIfActive);
  }

  @Test
  def testResources = {
    assertEquals(7, manifest.resources.size)
    assertEquals(None,manifest.resourcesBase)
  }

  @Test
  def testResourceSEQ01 = {
    val resource = manifest.resources("SEQ01")
    assertEquals("SEQ01", resource.identifier)
    assertEquals("webcontent", resource.resourceType)
    assertEquals(ResourceScormType.Sco, resource.scormType)
    assertEquals("resources/", resource.base.get)
    assertEquals("SequencingTest.htm", resource.href.get)
    assertEquals(None, resource.metadata)
    assertEquals(1, resource.files.size)
    assertEquals("SequencingTest.htm", resource.files(0).href)
    assertEquals(None, resource.files(0).metadata)
    assertEquals(5, resource.dependencyIdentifiers.size)
    assertEquals("LMSFNCTS01", resource.dependencyIdentifiers(0))
    assertEquals("JAR01", resource.dependencyIdentifiers(1))
    assertEquals("ABOUT01", resource.dependencyIdentifiers(2))
    assertEquals("EMULATION01", resource.dependencyIdentifiers(3))
    assertEquals("LMSINCLUDE", resource.dependencyIdentifiers(4))
  }

  @Test
  def testResourceLMSFNCTS01 = {
    val resource = manifest.resources("LMSFNCTS01")
    assertEquals("LMSFNCTS01", resource.identifier)
    assertEquals("webcontent", resource.resourceType)
    assertEquals(ResourceScormType.Asset, resource.scormType)
    assertEquals(None, resource.base)
    assertEquals(None, resource.href)
    assertEquals(None, resource.metadata)
    assertEquals(1, resource.files.size)
    assertEquals("common/lmsrtefunctions.js", resource.files(0).href)
    assertEquals(None,resource.files(0).metadata)
    assertEquals(0, resource.dependencyIdentifiers.size)
  }

  @Test
  def testResourceJAR01 = {
    val resource = manifest.resources("JAR01")
    assertEquals("JAR01", resource.identifier)
    assertEquals("webcontent", resource.resourceType)
    assertEquals(ResourceScormType.Asset, resource.scormType)
    assertEquals("common/", resource.base.get)
    assertEquals(None, resource.href)
    assertEquals(None, resource.metadata)
    assertEquals(1, resource.files.size)
    assertEquals("LMSTest.jar", resource.files(0).href)
    assertEquals(None, resource.files(0).metadata)
    assertEquals(0, resource.dependencyIdentifiers.size)
  }

  @Test
  def testResourceABOUT01 = {
    val resource = manifest.resources("ABOUT01")
    assertEquals("ABOUT01", resource.identifier)
    assertEquals("webcontent", resource.resourceType)
    assertEquals(ResourceScormType.Asset, resource.scormType)
    assertEquals(None, resource.base)
    assertEquals(None, resource.href)
    assertEquals(None, resource.metadata)
    assertEquals(1, resource.files.size)
    assertEquals("common/About.js", resource.files(0).href)
    assertEquals(None, resource.files(0).metadata)
    assertEquals(0, resource.dependencyIdentifiers.size)
  }

  @Test
  def testResourceEMULATION01 = {
    val resource = manifest.resources("EMULATION01")
    assertEquals("EMULATION01", resource.identifier)
    assertEquals("webcontent", resource.resourceType)
    assertEquals(ResourceScormType.Asset, resource.scormType)
    assertEquals(None, resource.base)
    assertEquals(None, resource.href)
    assertEquals(None, resource.metadata)
    assertEquals(1, resource.files.size)
    assertEquals("common/EmulationCode.js", resource.files(0).href)
    assertEquals(None, resource.files(0).metadata)
    assertEquals(1, resource.dependencyIdentifiers.size)
    assertEquals("BROWSERDETECT01", resource.dependencyIdentifiers(0))
  }

  @Test
  def testResourceBROWSERDETECT01 = {
    val resource = manifest.resources("BROWSERDETECT01")
    assertEquals("BROWSERDETECT01", resource.identifier)
    assertEquals("webcontent", resource.resourceType)
    assertEquals(ResourceScormType.Asset, resource.scormType)
    assertEquals(None, resource.base)
    assertEquals(None, resource.href)
    assertEquals(None, resource.metadata)
    assertEquals(1, resource.files.size)
    assertEquals("common/BrowserDetect.js", resource.files(0).href)
    assertEquals(None, resource.files(0).metadata)
    assertEquals(0, resource.dependencyIdentifiers.size)
  }

  @Test
  def testResourceLMSINCLUDE = {
    val resource = manifest.resources("LMSINCLUDE")
    assertEquals("LMSINCLUDE", resource.identifier)
    assertEquals("webcontent", resource.resourceType)
    assertEquals(ResourceScormType.Asset, resource.scormType)
    assertEquals(None, resource.base)
    assertEquals(None, resource.href)
    assertEquals(None, resource.metadata)
    assertEquals(1, resource.files.size)
    assertEquals("includes/LMSTestContentPackages_style.css", resource.files(0).href)
    assertEquals(None, resource.files(0).metadata)
    assertEquals(0, resource.dependencyIdentifiers.size)
  }

  @Test
  def testSequencingCollection = {
    assertEquals(0, manifest.sequencingCollection.size)
  }

  @Test
  def testFullResourceUrl = {
    val resource = manifest.resources("SEQ01")
    assertEquals("resources/SequencingTest.htm", manifest.getFullResourceUrl(resource))
  }

  @Test
  def testFullResourceUrlById = {
    assertEquals("resources/SequencingTest.htm", manifest.getFullResourceUrl("SEQ01"));
  }

  @Test
  def testFullFileUrlSEQ01 = {
    val resource = manifest.resources("SEQ01");
    val url = manifest.getFullFileUrl(resource, resource.files(0));
    assertEquals("resources/SequencingTest.htm", url);
  }

  @Test
  def testFullFileUrlByIdSEQ01 = {
    val resourceFile = manifest.resources("SEQ01").files(0);
    assertEquals("resources/SequencingTest.htm", manifest.getFullFileUrl("SEQ01", resourceFile));
  }

  @Test
  def testFullFileUrlLMSFNCTS01 = {
    val resource = manifest.resources("LMSFNCTS01");
    val url = manifest.getFullFileUrl(resource, resource.files(0));
    assertEquals("common/lmsrtefunctions.js", url);
  }

  @Test
  def testFullFileUrlByIdLMSFNCTS01 = {
    val resourceFile = manifest.resources("LMSFNCTS01").files(0);
    assertEquals("common/lmsrtefunctions.js", manifest.getFullFileUrl("LMSFNCTS01", resourceFile));
  }

  @Test
  def testFullFileUrlJAR01 = {
    val resource = manifest.resources("JAR01");
    val url = manifest.getFullFileUrl(resource, resource.files(0));
    assertEquals("common/LMSTest.jar", url);
  }

  @Test
  def testFullFileUrlByIdJAR01 = {
    val resourceFile = manifest.resources("JAR01").files(0);
    assertEquals("common/LMSTest.jar", manifest.getFullFileUrl("JAR01", resourceFile));
  }

  @Test
  def testFullFileUrlABOUT01 = {
    val resource = manifest.resources("ABOUT01");
    val url = manifest.getFullFileUrl(resource, resource.files(0));
    assertEquals("common/About.js", url);
  }

  @Test
  def testFullFileUrlByIdABOUT01 = {
    val resourceFile = manifest.resources("ABOUT01").files(0);
    assertEquals("common/About.js", manifest.getFullFileUrl("ABOUT01", resourceFile));
  }

  @Test
  def testFullFileUrlEMULATION01 = {
    val resource = manifest.resources("EMULATION01");
    val url = manifest.getFullFileUrl(resource, resource.files(0));
    assertEquals("common/EmulationCode.js", url);
  }

  @Test
  def testFullFileUrlByIdEMULATION01 = {
    val resourceFile = manifest.resources("EMULATION01").files(0);
    assertEquals("common/EmulationCode.js", manifest.getFullFileUrl("EMULATION01", resourceFile));
  }

  @Test
  def testFullFileUrlBROWSERDETECT01 = {
    val resource = manifest.resources("BROWSERDETECT01");
    val url = manifest.getFullFileUrl(resource, resource.files(0));
    assertEquals("common/BrowserDetect.js", url);
  }

  @Test
  def testFullFileUrlByIdBROWSERDETECT01 = {
    val resourceFile = manifest.resources("BROWSERDETECT01").files(0);
    assertEquals("common/BrowserDetect.js", manifest.getFullFileUrl("BROWSERDETECT01", resourceFile));
  }

  @Test
  def testFullFileUrlLMSINCLUDE = {
    val resource = manifest.resources("LMSINCLUDE");
    val url = manifest.getFullFileUrl(resource, resource.files(0));
    assertEquals("includes/LMSTestContentPackages_style.css", url);
  }

  @Test
  def testFullFileUrlByIdLMSINCLUDE = {
    val resourceFile = manifest.resources("LMSINCLUDE").files(0);
    val url = manifest.getFullFileUrl("LMSINCLUDE", resourceFile);
    assertEquals("includes/LMSTestContentPackages_style.css", url);
  }

  @Test
  def testFullActivity1Url = {
    val activity = manifest.allActivities("activity_1").asInstanceOf[LeafActivity];
    assertEquals("resources/SequencingTest.htm?tc=CM-01&act=1", manifest.getFullActivityUrl(activity));
  }

  @Test
  def testFullActivity1UrlById = {
    assertEquals("resources/SequencingTest.htm?tc=CM-01&act=1", manifest.getFullActivityUrl("activity_1"));
  }

  @Test
  def testFullActivity2Url = {
    val activity = manifest.allActivities("activity_2").asInstanceOf[LeafActivity];
    assertEquals("resources/SequencingTest.htm?tc=CM-01&act=2", manifest.getFullActivityUrl(activity));
  }

  @Test
  def testFullActivity2UrlById = {
    assertEquals("resources/SequencingTest.htm?tc=CM-01&act=2", manifest.getFullActivityUrl("activity_2"));
  }

  @Test
  def testFullActivity3Url = {
    val activity = manifest.allActivities("activity_3").asInstanceOf[LeafActivity];
    assertEquals("resources/SequencingTest.htm?tc=CM-01&act=3", manifest.getFullActivityUrl(activity));
  }

  @Test
  def testFullActivity3UrlById = {
    assertEquals("resources/SequencingTest.htm?tc=CM-01&act=3", manifest.getFullActivityUrl("activity_3"));
  }
}