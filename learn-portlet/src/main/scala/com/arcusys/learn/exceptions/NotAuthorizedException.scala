package com.arcusys.learn.exceptions

case class NotAuthorizedException(message: String = null) extends Exception(message)
