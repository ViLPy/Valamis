package com.arcusys.learn.scorm.tracking.model.certificating

/**
 * Created by Iliya Tryapitsin on 03.06.2014.
 */
object CertificateStatus extends Enumeration {
  type CertificateStatus = Value
  val InProgress, Failed, Success, Overdue = Value

  def parse(value: String) = value match {
    case "inprogress" => InProgress
    case "failed"     => Failed
    case "success"    => Success
    case "overdue"    => Overdue
  }

  def apply(value: Option[String]) = value match {
    case Some(value) => parse(value)
    case None        => InProgress
  }

  def apply(value: String) = parse(value)

}
