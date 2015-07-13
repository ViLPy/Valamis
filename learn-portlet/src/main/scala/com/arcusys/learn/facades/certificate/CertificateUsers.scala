package com.arcusys.learn.facades.certificate

import com.arcusys.valamis.certificate.model.CertificateSortBy
import CertificateSortBy.CertificateSortBy
import com.arcusys.learn.facades.CertificateFacadeContract
import com.arcusys.learn.models.response.certificates.CertificateResponseContract
import com.arcusys.learn.models.response.users.{ UserShortResponse, UserResponseUtils, UserResponseWithCertificateStatus }
import com.arcusys.valamis.certificate.model.badge.{IssuerModel, BadgeModel, BadgeResponse}
import com.arcusys.valamis.certificate.service.{ CertificateStatusChecker, CertificateService }
import com.arcusys.valamis.lrs.api.StatementApi
import com.escalatesoft.subcut.inject.Injectable

trait CertificateUsers extends Injectable with CertificateResponseFactory with CertificateFacadeContract {

  //private val certificateUserService = inject[CertificateServiceContract]
  private lazy val certificateService = inject[CertificateService]
  private lazy val checker = inject[CertificateStatusChecker]

  def addUser(certificateId: Int, userId: Int) = {
    certificateService.addUser(certificateId, userId)
  }

  def deleteUser(certificateId: Int, userId: Int) = {
    certificateService.deleteUser(certificateId, userId)
  }

  def getForUser(companyID: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean,
    userId: Int, isShortResult: Boolean, isOnlyPublished: Boolean): Seq[CertificateResponseContract] = {
    certificateService.getForUser(companyID, skip, take, filter, sortAZ, userId, isOnlyPublished)
      .map(toCertificateResponse(isShortResult))
  }

  def forUserCount(companyID: Int, filter: String, userId: Int, isOnlyPublished: Boolean): Int =
    certificateService.forUserCount(companyID, filter, userId, isOnlyPublished)

  def availableForUserCount(companyID: Int, userId: Int, filter: String, isOnlyPublished: Boolean, scope: Option[Long]): Int = {
    certificateService.availableForUserCount(companyID, userId, filter, isOnlyPublished, scope)
  }

  def getForUserWithStatus(statementApi: StatementApi, companyID: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean,
    userId: Int, isShortResult: Boolean, isOnlyPublished: Boolean): Seq[CertificateResponseContract] = {
    val c = certificateService.getForUserWithStatus(companyID, skip, take, filter, sortAZ, userId, isOnlyPublished)

    c.map(toCertificateWithUserStatusResponse(statementApi, userId))
  }

  def getForUser(companyID: Int, userId: Int, isShortResult: Boolean): Seq[CertificateResponseContract] =
    certificateService.getForUser(userId)
      .map(toCertificateResponse(isShortResult))

  def getAvailableForUser(companyID: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean, userId: Int,
    isShortResult: Boolean, isOnlyPublished: Boolean, scope: Option[Long]): Seq[CertificateResponseContract] = {
    certificateService.getAvailableForUser(companyID, skip, take, filter, sortAZ, userId, isOnlyPublished, scope)
      .map(toCertificateResponse(isShortResult))
  }

  def getJoinedUsers(statementApi: StatementApi, certificateId: Int, filterName: String, orgId: Int, sortBy: CertificateSortBy,
    sortAscDirection: Boolean, skip: Int, take: Int): Iterable[(String, UserResponseWithCertificateStatus)] = {
    val result = certificateService.getJoinedUsers(certificateId, filterName, orgId, sortBy, sortAscDirection, skip, take)
    result.map(i => {
      (i._1,
        UserResponseWithCertificateStatus(i._2.getUserId, i._2.getFullName, UserResponseUtils.getPortraitUrl(i._2),
          UserResponseUtils.getPublicUrl(i._2), checker.getStatus(statementApi, certificateId, i._2.getUserId.toInt).toString))
    })
  }

  def getJoinedUsersCount(certificateId: Int, filterName: String, orgId: Int): Int = {
    certificateService.getJoinedUsersCount(certificateId, filterName, orgId)
  }

  def getFreeStudents(certificateId: Int, filterName: String, orgId: Int, sortBy: CertificateSortBy,
    sortAscDirection: Boolean, skip: Int, take: Int): Iterable[UserShortResponse] = {
    val u = certificateService.getFreeStudents(certificateId, filterName, orgId, sortBy, sortAscDirection, skip, take)
    u.map(u => UserShortResponse(u.getUserId, u.getFullName, UserResponseUtils.getPortraitUrl(u), UserResponseUtils.getPublicUrl(u)))
  }

  def getFreeStudentsCount(certificateId: Int, orgId: Int, filterName: String): Int = {
    certificateService.getFreeStudentsCount(certificateId, orgId, filterName)
  }

  def getCertificatesByUserWithOpenBadges(statementApi: StatementApi, companyID: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean,
    userId: Int, isOnlyPublished: Boolean): Seq[CertificateResponseContract] = {

    certificateService.getCertificatesByUserWithOpenBadges(statementApi, companyID, skip, take, filter, sortAZ, userId, isOnlyPublished).
      map(toCertificateResponse)
  }

  def getCertificatesByUserWithOpenBadges(statementApi: StatementApi, companyID: Int, userId: Int, isOnlyPublished: Boolean): Seq[CertificateResponseContract] = {
    certificateService.getCertificatesByUserWithOpenBadges(statementApi, companyID, userId, isOnlyPublished).
      map(toShortCertificateResponse)
  }

  def getCertificatesCountByUserWithOpenBadges(statementApi: StatementApi, companyID: Int, filter: String, userId: Int, isOnlyPublished: Boolean): Int = {
    certificateService.getCertificatesCountByUserWithOpenBadges(statementApi, companyID, filter, userId, isOnlyPublished)
  }

  def getIssuerBadge(certificateId: Int, liferayUserId: Int, rootUrl: String): BadgeResponse = {
    certificateService.getIssuerBadge(certificateId, liferayUserId, rootUrl)
  }

  def getBadgeModel(certificateId: Int, rootUrl: String): BadgeModel = {
    certificateService.getBadgeModel(certificateId, rootUrl)
  }

  def getIssuerModel(rootUrl: String): IssuerModel = {
    certificateService.getIssuerModel(rootUrl)
  }
}
