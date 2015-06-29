package com.arcusys.valamis.certificate.schema

import com.arcusys.valamis.certificate.model.Certificate
import com.arcusys.valamis.core.DbNameUtils._
import com.arcusys.valamis.core.SlickProfile
import com.arcusys.valamis.model.PeriodTypes
import com.github.tototoshi.slick.GenericJodaSupport
import org.joda.time.DateTime

import scala.slick.driver.JdbcDriver

trait CertificateTableComponent { self: SlickProfile =>
  import driver.simple._

  class CertificateTable(tag: Tag) extends Table[Certificate](tag, tblName("CERTIFICATE")) {
    implicit val ValidPeriodTypeMapper = MappedColumnType.base[PeriodTypes.PeriodType, String](
      s => s.toString,
      s => PeriodTypes.withName(s)
    )

    val jodaMapper = new GenericJodaSupport(driver.asInstanceOf[JdbcDriver])
    import jodaMapper._

    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def title = column[String]("TITLE")
    def description = column[String]("DESCRIPTION")
    def logo = column[String]("LOGO")
    def isPermanent = column[Boolean]("IS_PERMANENT")
    def isPublishBadge = column[Boolean]("IS_PUBLISH_BADGE")
    def shortDescription = column[String]("SHORT_DESCRIPTION")
    def companyId = column[Long]("COMPANY_ID")
    def validPeriodType = column[PeriodTypes.PeriodType]("PERIOD_TPE")
    def validPeriod = column[Int]("VALID_PERIOD")
    def createdAt = column[DateTime]("CREATED_AT")
    def isPublished = column[Boolean]("IS_PUBLISHED")
    def scope = column[Option[Long]]("SCOPE")

    private def customTupled(tuple: Tuple13[Long, String, String, String, Boolean, Boolean, String, Long, PeriodTypes.PeriodType, Int, DateTime, Boolean, Option[Long]]) = tuple match {
      case (id: Long, title: String, description: String, logo: String, isPermanent: Boolean, isPublishBadge: Boolean, shortDescription: String, companyId: Long, validPeriodType: PeriodTypes.PeriodType, validPeriod: Int, createdAt: DateTime, isPublished: Boolean, scope: Option[Long]) =>
        Certificate(id.toInt, title, description, logo, isPermanent, isPublishBadge, shortDescription, companyId.toInt, validPeriodType, validPeriod, createdAt, isPublished, scope)
    }
    private def customUnapply(certificate: Certificate) = certificate match{
      case Certificate(id, title, description, logo, isPermanent, isPublishBadge, shortDescription, companyId, validPeriodType, validPeriod, createdAt, isPublished, scope) =>
        Some(id.toLong, title, description, logo, isPermanent, isPublishBadge, shortDescription, companyId.toLong, validPeriodType, validPeriod, createdAt, isPublished, scope)
    }

    def * = (id, title, description, logo, isPermanent, isPublishBadge, shortDescription, companyId, validPeriodType, validPeriod, createdAt, isPublished, scope) <> (customTupled, customUnapply)
  }

  val certificates = TableQuery[CertificateTable]
}