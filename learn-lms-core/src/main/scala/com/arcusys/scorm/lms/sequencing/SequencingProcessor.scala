package com.arcusys.scorm.lms.sequencing

import model._
import org.scala_tools.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.scorm.tracking.model.Attempt
import com.arcusys.learn.storage.StorageFactoryContract

class SequencingProcessor(attempt: Attempt)(implicit val bindingModule: BindingModule) extends Injectable {
  private val storageFactory = inject[StorageFactoryContract]
  private val treeStateStorage = storageFactory.activityStateTreeStorage
  private val attemptStorage = storageFactory.attemptStorage
  val navigationRequestService = inject[NavigationRequestServiceContract]
  val terminationRequestService = inject[TerminationRequestServiceContract]
  val sequencingRequestService = inject[SequencingRequestServiceContract]
  val deliveryRequestService = inject[DeliveryRequestServiceContract]

  lazy val treeOption = treeStateStorage.get(attempt.id)
  require(treeOption.isDefined, "Tree should exist!")
  lazy val tree = treeOption.get
  //lazy val tree = ActivityStateTree(activityStorage.getOrganizationTree(attempt.packageID, attempt.organizationID), attempt.currentActivityID, currentActive = false, suspendedActivityID = attempt.suspendedActivityID)

  /**
   * Overall Sequencing Process [OP.1]
   * @param request request string
   */
  def process(request: String): Map[String, Any] = {

    val reqexReplacer = """\{.+\}""".r // for conversion 'foo{bar}' to 'foo'
    val regexExtractor = """(?<=\{).+(?=\})""".r // for extracting 'bar' from 'foo{bar}'
    val requestAction = reqexReplacer.replaceAllIn(request, "")
    val targetActivityId = regexExtractor.findFirstIn(request).getOrElse("")
    val navigationRequest = NavigationRequestType.values.find(_.toString == requestAction)

    val navigationResponse = navigationRequest match {
      case None => NavigationResponse.invalid("Undefined / unsupported navigation request")
      case Some(requestType) => {
        navigationRequestService(tree, requestType, targetActivityId)
      }
    }
    navigationResponse match {
      /* Handle navigation request exception (do nothing) */
      case NavigationResponseInvalid => {}
      case _ => {
        val navigationSequencingRequest = SequencingRequestType.forNavigationRequest(navigationRequest.get)
        val sequencingRequestOption = if (navigationResponse == NavigationResponseWithTermination) {
          terminationRequestService(tree, TerminationRequestType.forNavigationRequest(navigationRequest.get)) match {
            case TerminationResponseInvalid => None
            case TerminationResponseValid(None) => Some(navigationSequencingRequest)
            case TerminationResponseValid(Some(terminationSequencingRequest)) => Some(terminationSequencingRequest)
          }
        } else Some(navigationSequencingRequest)
        sequencingRequestOption match {
          /* Handle termination request exception (do nothing) */
          case None => {}
          case Some(sequencingRequest) => sequencingRequestService(tree, sequencingRequest, targetActivityId) match {
            case SequencingResponseDelivery(activity) =>
              if (activity.canBeDelivered) {
                deliveryRequestService(tree, activity)
              } else {} /* Handle delivery request exception (do nothing) */
            // Exiting from the root of the activity tree ends the sequencing session; return control to the LTS
            case SequencingResponseEndSession => {
              if (tree.suspendedActivity.isDefined) {
                tree.currentActivity = None
                treeStateStorage.modify(attempt.id, tree)
              } else {
                treeStateStorage.modify(attempt.id, tree)
                attemptStorage.markAsComplete(attempt.id)
                return Map("currentActivity" -> None, "suspendedActivity" -> None, "endSession" -> true)
              }
            }
            case SequencingResponseEmpty => {}
            case SequencingResponseInvalid => {}
          }
        }
      }
    }
    treeStateStorage.modify(attempt.id, tree)
    Map("currentActivity" -> tree.currentActivity.map(_.item.activity.id),
      //"suspendedActivity" -> tree.suspendedActivity.map(_.item.activity.id),
      "endSession" -> false)
  }
}