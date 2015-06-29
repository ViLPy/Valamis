package com.arcusys.valamis.certificate.model

/**
 * User: Yulia.Glushonkova
 * Date: 13.10.2014
 */

object CertificateSortBy extends Enumeration {
  type CertificateSortBy = Value
  val Name, Description, CreationDate, UserJoined = Value
  def apply(v: String): CertificateSortBy = v.toLowerCase() match {
    case "name"         => Name
    case "description"  => Description
    case "creationdate" => CreationDate
    case "userjoined"   => UserJoined
    case _              => throw new IllegalArgumentException()
  }
}

