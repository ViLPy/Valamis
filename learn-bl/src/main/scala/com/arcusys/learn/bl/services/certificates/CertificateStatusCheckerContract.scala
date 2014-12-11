package com.arcusys.learn.bl.services.certificates
import com.arcusys.learn.scorm.tracking.model.certificating.CertificateStatus.CertificateStatus
import org.joda.time.DateTime

/**
 * Created by igorborisov on 21.10.14.
 */
trait CertificateStatusCheckerContract {

  def getStatus(certificateId: Int, userId: Int): CertificateStatus

  def getCoursesStatuses(certificateId: Int, userId: Int): Iterable[(Int, CertificateStatus, DateTime)]

  def getCoursesDeadlines(certificateId: Int, userId: Int): Seq[(Int, Option[DateTime])]

  def getActivitiesStatuses(certificateId: Int, userId: Int): Iterable[(String, CertificateStatus, Option[DateTime])]

  def getActivitiesDeadlines(certificateId: Int, userId: Int): Seq[(String, Option[DateTime])]

  def getStatementsStatuses(certificateId: Int, userId: Int): Iterable[(String, String, CertificateStatus, DateTime)]

  def getStatementsDeadlines(certificateId: Int, userId: Int): Seq[(String, String, Option[DateTime])]
}
