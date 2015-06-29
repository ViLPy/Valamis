package com.arcusys.valamis.certificate.schema

import com.arcusys.valamis.certificate.model.{CertificateStatus, CertificateState}
import com.arcusys.valamis.core.DbNameUtils._
import com.arcusys.valamis.core.SlickProfile
import org.joda.time.DateTime

import scala.slick.driver.JdbcDriver

trait CertificateStateTableComponent extends CertificateTableComponent{ self: SlickProfile =>
    import driver.simple._

    class CertificateStateTable(tag: Tag) extends Table[CertificateState](tag, tblName("CERT_STATE")) {
      val jodaMapper = new com.github.tototoshi.slick.GenericJodaSupport(driver.asInstanceOf[JdbcDriver])
      import jodaMapper._
      implicit val CertificateStatusTypeMapper = MappedColumnType.base[CertificateStatus.Value, String](
        s => s.toString,
        s => CertificateStatus.withName(s)
      )
      def userId = column[Long]("USER_ID")
      def status = column[CertificateStatus.Value]("STATE")
      def statusAcquiredDate = column[DateTime]("STATE_ACQUIRED_DATE")
      def userJoinedDate = column[DateTime]("USER_JOINED_DATE") //Possibly not needed, was used in CertificateToUser repository
      def certificateId = column[Long]("CERTIFICATE_ID")

      def * = (userId, status, statusAcquiredDate, userJoinedDate, certificateId) <> (CertificateState.tupled, CertificateState.unapply)

      def PK = primaryKey(pkName("CERT_STATE"), (userId, certificateId))
      def certificateFK = foreignKey(fkName("CERT_STATE_TO_CERT"), certificateId, certificates)(x => x.id, onDelete = ForeignKeyAction.Cascade)
    }

    val certificateStates = TableQuery[CertificateStateTable]
}
