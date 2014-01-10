package com.arcusys.learn.scorm.tracking.model.sequencing

import com.escalatesoft.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.scorm.tracking.model.{ActivityStateTree, Attempt}

class SequencingProcessor(attempt: Attempt, tree: ActivityStateTree)(implicit val bindingModule: BindingModule) extends Injectable {
  val navigationRequestService = inject[NavigationRequestServiceContract]
  val terminationRequestService = inject[TerminationRequestServiceContract]
  val sequencingRequestService = inject[SequencingRequestServiceContract]
  val deliveryRequestService = inject[DeliveryRequestServiceContract]

  /**
   * Overall Sequencing Process [OP.1]
   * @param request request string
   */
  def process(request: String): ProcessorResponse = {

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
              } else {
                return ProcessorResponse.endSession(tree)
              }
            }
            case SequencingResponseEmpty => {}
            case SequencingResponseInvalid => {}
          }
        }
      }
    }
    ProcessorResponse(tree)
  }
}