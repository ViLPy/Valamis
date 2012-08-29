package com.arcusys.learn.scorm.tracking.model.sequencing

import org.slf4j.LoggerFactory

// Navigation request response model for handling navigation request result
// taken from Navigation Request Process [NB.2.1] (SN SCORM book)
sealed abstract class NavigationResponse {}

case object NavigationResponseInvalid extends NavigationResponse

case object NavigationResponseWithoutTermination extends NavigationResponse

case object NavigationResponseWithTermination extends NavigationResponse

object NavigationResponse {
  private val LOG = LoggerFactory.getLogger(classOf[NavigationResponse])

  def invalid(message: String) = {
    LOG.warn(message)
    NavigationResponseInvalid
  }

  def valid(termination: Boolean) = if (termination) NavigationResponseWithTermination else NavigationResponseWithoutTermination
}