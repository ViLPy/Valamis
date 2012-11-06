package com.arcusys.learn.scorm.manifest.model

/**
 * An activity from the activity tree. Can be a content organization, container activity or leaf activity
 * @param id                        Manifest-wide unique identifier of activity
 * @param title                     Title of the activity
 * @param parentID                  ID of activity's parent. Empty for organizations since they're on the root of the tree. Defined for all other activities
 * @param organizationID            ID of the organization this activity belongs to. For organizations equals ID. For activities directly under organization equals Parent ID
 * @param sequencing                Sequencing information about activity
 * @param completionThreshold       Information about completion threshold and progress weight
 * @param hiddenNavigationControls  Information on hidden navigation controls
 * @param visible                   True if activity is visible, false if it's hidden
 * @param metadata                  Activity metadata
 */
sealed abstract class Activity
(
  val id: String,
  val title: String,
  val parentID: Option[String],
  val organizationID: String,
  val sequencing: Sequencing,
  val completionThreshold: CompletionThreshold,
  val hiddenNavigationControls: Set[NavigationControlType.Value],
  val visible: Boolean,
  val metadata: Option[Metadata]
  ) {
  val isTracked = sequencing.tracking.isDefined
  val isCompletionSetByContent = sequencing.tracking.isDefined && sequencing.tracking.get.completionSetByContent
  val isObjectiveSetByContent = sequencing.tracking.isDefined && sequencing.tracking.get.objectiveSetByContent
}

/**
 * Content organization - activity on the root of an activity tree
 * @param id                        Identifier of organization, unique among all activity IDs in manifest
 * @param title                     Title of the organization
 * @param objectivesGlobalToSystem  True if mapped global objectives of this organization are global for the lifetime of the learner within the LMS
 * @param sharedDataGlobalToSystem  True if shared data mapped across SCOs (adlcp:data) are global for the lifetime of the learner within the LMS
 * @param sequencing                Sequencing information about organization
 * @param completionThreshold       Information about completion threshold and progress weight
 * @param metadata                  Organization metadata
 */
class Organization
(
  id: String,
  title: String,
  val objectivesGlobalToSystem: Boolean = true,
  val sharedDataGlobalToSystem: Boolean = true,
  sequencing: Sequencing = Sequencing.Default,
  completionThreshold: CompletionThreshold = CompletionThreshold.Default,
  metadata: Option[Metadata] = None)
  extends Activity(
    id = id,
    title = title,
    parentID = None,
    organizationID = id,
    sequencing = sequencing,
    completionThreshold = completionThreshold,
    hiddenNavigationControls = Set(),
    visible = true,
    metadata = metadata
  )

/**
 * Container activity. May contain other container activities and leaf activities
 * @param id                        Identifier of container activity, unique among all activity IDs in manifest
 * @param title                     Title of the container activity
 * @param parentID                  ID of container activity's parent
 * @param organizationID            ID of the organization this container activity belongs to. For activities directly under organization equals Parent ID
 * @param sequencing                Sequencing information about container activity
 * @param completionThreshold       Information about completion threshold and progress weight
 * @param hiddenNavigationControls  Information on hidden navigation controls
 * @param visible                   True if container activity is visible, false if it's hidden
 * @param metadata                  Container activity metadata
 */
class ContainerActivity
(
  id: String,
  title: String,
  parentID: String,
  organizationID: String,
  sequencing: Sequencing = Sequencing.Default,
  completionThreshold: CompletionThreshold = CompletionThreshold.Default,
  hiddenNavigationControls: Set[NavigationControlType.Value] = Set(),
  visible: Boolean = true,
  metadata: Option[Metadata] = None
  )
  extends Activity(id, title, Some(parentID), organizationID, sequencing, completionThreshold, hiddenNavigationControls, visible, metadata)

/**
 * Leaf activity. Does not contain other activities. References a resource
 * @param id                        Identifier of leaf activity, unique among all activity IDs in manifest
 * @param title                     Title of the leaf activity
 * @param parentID                  ID of leaf activity's parent
 * @param organizationID            ID of the organization this leaf activity belongs to. For activities directly under organization equals Parent ID
 * @param resourceIdentifier        ID of the resource this leaf activity references
 * @param resourceParameters        Parameters to pass to the resource (via URL), if any
 * @param timeLimitAction           Action to be taken (if any) when max time allowed in the current attempt of the activity is exceeded
 * @param dataFromLMS               Initialization data to be sent to the SCO after launch, if any
 * @param data                      Shared data associated with leaf activity
 * @param sequencing                Sequencing information about container activity
 * @param completionThreshold       Information about completion threshold and progress weight
 * @param hiddenNavigationControls  Information on hidden navigation controls
 * @param visible                   True if leaf activity is visible, false if it's hidden
 * @param metadata                  Leaf activity metadata
 */
class LeafActivity
(
  id: String,
  title: String,
  parentID: String,
  organizationID: String,
  val resourceIdentifier: String,
  val resourceParameters: Option[String] = None,
  val timeLimitAction: Option[TimeLimitAction.Value] = None,
  val dataFromLMS: Option[String] = None,
  val data: Seq[ActivityDataMap] = Nil,
  sequencing: Sequencing = Sequencing.Default,
  completionThreshold: CompletionThreshold = CompletionThreshold.Default,
  hiddenNavigationControls: Set[NavigationControlType.Value] = Set(),
  visible: Boolean = true,
  metadata: Option[Metadata] = None,
  val masteryScore: Option[String] = None,
  val maxTimeAllowed: Option[String] = None
  )
  extends Activity(id, title, Some(parentID), organizationID, sequencing, completionThreshold, hiddenNavigationControls, visible, metadata)