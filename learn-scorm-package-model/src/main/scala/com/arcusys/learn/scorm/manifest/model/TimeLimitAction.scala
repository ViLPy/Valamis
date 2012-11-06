package com.arcusys.learn.scorm.manifest.model

/** Action to be taken when max time allowed in the attempt is exceeded */
object TimeLimitAction extends Enumeration {
  type TimeLimitAction = Value
  /**Learner is forced to exit, timeout message is shown*/
  val ExitMessage = Value("exit,message")
  /**Learner is forced to exit, timeout message is not shown*/
  val ExitNoMessage = Value("exit,no message")
  /**Learner is allowed to continue, timeout message is shown*/
  val ContinueMessage = Value("continue,message")
  /**Learner is allowed to continue, timeout message is not shown*/
  val ContinueNoMessage = Value("continue,no message")
}