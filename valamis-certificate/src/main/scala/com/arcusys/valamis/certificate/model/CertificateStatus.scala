package com.arcusys.valamis.certificate.model

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

  def all = Set(InProgress, Failed, Success, Overdue)

  def apply(value: String) = parse(value)
}
