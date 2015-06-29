package com.arcusys.valamis.certificate.service

import java.security.MessageDigest

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.services.{PermissionHelper, UserLocalServiceHelper}
import com.arcusys.valamis.certificate.model.CertificateSortBy.CertificateSortBy
import com.arcusys.valamis.certificate.model.badge.{ BadgeModel, BadgeResponse, IssuerModel }
import com.arcusys.valamis.certificate.model._
import com.arcusys.valamis.certificate.service.util.OpenBadgesHelper
import com.arcusys.valamis.certificate.storage.{CertificateStateRepository, CertificateRepository}
import com.arcusys.valamis.lrs.api.StatementApi
import com.arcusys.valamis.settings.model
import com.arcusys.valamis.settings.model.SettingType
import com.arcusys.valamis.settings.storage.SettingStorage
import com.arcusys.valamis.user.service.UserService
import com.arcusys.valamis.util.HexHelper
import com.escalatesoft.subcut.inject.Injectable
import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat

//TODO refactor, move badge client code to BadgeClient class
trait CertificateUserServiceImpl extends Injectable with CertificateService {

  private lazy val userLocalServiceHelper = inject[UserLocalServiceHelper]
  private lazy val certificateRepository = inject[CertificateRepository]
  private lazy val certificateToUserRepository = inject[CertificateStateRepository]

  private lazy val userService = inject[UserService]
  private lazy val settingStorage = inject[SettingStorage]

  private lazy val checker = inject[CertificateStatusChecker]
  //new CertificateStatusChecker(bindingModule)

  def addUser(certificateId: Int, userId: Int) = {
    val certificate = certificateRepository.getById(certificateId)
    val user = userService.byId(userId)

    certificateToUserRepository.create(CertificateState(user.getUserId, CertificateStatus.InProgress, DateTime.now, DateTime.now, certificate.id))//create(certificate, (DateTime.now, user.getUserId))
  }

  def deleteUser(certificateId: Int, userId: Int) = {
    val certificate = certificateRepository.getById(certificateId)
    val user = userService.byId(userId)

    certificateToUserRepository.delete(user.getUserId, certificate.id)
  }

  def getForUser(companyId: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean,
    userId: Int, isOnlyPublished: Boolean): Seq[Certificate] = {
    var certificates = getForUser(userId).filter(c => if (isOnlyPublished) c.isPublished else true)
    certificates = filtering(certificates, filter)
      .sortBy(_.title.toLowerCase)
    if (!sortAZ) certificates = certificates.reverse
    if (skip < 0)
      certificates
    else
      certificates.drop(skip).take(take)
  }

  def forUserCount(companyId: Int, filter: String, userId: Int, isOnlyPublished: Boolean): Int = {
    val certificates = getForUser(userId).filter(c => if (isOnlyPublished) c.isPublished else true)
    val filteredCertificates = filtering(certificates, filter)
    filteredCertificates.length
  }

  private def filtering(certificates: Seq[Certificate], titleFilter: String) = {
    if (titleFilter.isEmpty)
      certificates
    else {
      certificates.filter(i => i.title.toLowerCase.contains(titleFilter.toLowerCase))
    }
  }

  def availableForUserCount(companyId: Int, userId: Int, filter: String, isOnlyPublished: Boolean, scope: Option[Long]): Int = {
    val certificates = scope match {
      case Some(value) => getAvailableForUser(companyId, userId, isOnlyPublished)
        .filter(x => x.scope.isDefined)
        .filter(x => x.scope.get == value)

      case None => getAvailableForUser(companyId, userId, isOnlyPublished)
    }

    val filteredCertificates = filtering(certificates, filter)

    filteredCertificates.length
  }

  def getForUserWithStatus(companyId: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean,
    userId: Int, isOnlyPublished: Boolean): Seq[Certificate] = {

    var certificates = getForUser(userId).filter(c => if (isOnlyPublished) c.isPublished else true)
    certificates = filtering(certificates, filter)
      .sortBy(_.title.toLowerCase)

    if (!sortAZ) certificates = certificates.reverse

    if (skip < 0)
      certificates
    else
      certificates.drop(skip).take(take)
  }

  def getForUser(userId: Int): Seq[Certificate] =
    certificateRepository.getByIds(certificateToUserRepository.getBy(CertificateStateFilter(userId = Some(userId))).map(_.certificateId).toSet)

  private def getAvailableForUser(companyId: Int, userId: Int, isOnlyPublished: Boolean): Seq[Certificate] = {
    val usersCertificates = getForUser(userId)

    val all = certificateRepository.getBy(companyId = companyId)
      .filter(c => if (isOnlyPublished) c.isPublished else true)

    all.filter(certificate => !usersCertificates.exists(c => c.id == certificate.id)).toSeq
  }

  def getAvailableForUser(companyId: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean, userId: Int,
    isOnlyPublished: Boolean, scope: Option[Long]): Seq[Certificate] = {
    var certificates = scope match {
      case Some(value) => getAvailableForUser(companyId, userId, isOnlyPublished)
        .filter(x => x.scope.isDefined)
        .filter(x => x.scope.get == value)

      case None => getAvailableForUser(companyId, userId, isOnlyPublished)
    }

    certificates = filtering(certificates, filter)
      .sortBy(_.title.toLowerCase)

    if (!sortAZ) certificates = certificates.reverse

    if (skip < 0)
      certificates
    else
      certificates.drop(skip).take(take)
  }

  def getJoinedUsers(certificateId: Int, filterName: String, orgId: Int, sortBy: CertificateSortBy,
    sortAscDirection: Boolean, skip: Int, take: Int): Iterable[(String, LUser)] = {
    val certificate = certificateRepository.getById(certificateId)
    val certificateStudents = certificateToUserRepository.getBy(CertificateStateFilter(certificateId = Some(certificateId)))
    val studentUserIds = certificateStudents.map(_.userId)
    val formatter = ISODateTimeFormat.dateTime()
    var users = userService
      .all(certificate.companyId)
      .filter(user => studentUserIds.contains(user.getUserId.toInt))
      .filter(user => if (orgId != -1) user.getOrganizationIds.contains(orgId) else true)
      .filter(user => {
        if (filterName != "")
          user.getFullName.toLowerCase.contains(filterName.toLowerCase)
        else
          true
      })
      .map(user => {
        PermissionHelper.preparePermissionChecker(user)

        (formatter.print(certificateStudents.find(v => v.userId == user.getUserId).head.userJoinedDate), user)
      })
      .sortBy(u => sortBy match {
        case CertificateSortBy.UserJoined => u._1
        case _                            => u._2.getFullName
      })

    if (!sortAscDirection) users = users.reverse
    if (skip < 0) {
      users
    } else {
      users.drop(skip).take(take)
    }
  }

  def getJoinedUsersCount(certificateId: Int, filterName: String, orgId: Int): Int = {
    val certificate = certificateRepository.getById(certificateId)
    val certificateStudents = certificateToUserRepository.getBy(CertificateStateFilter(certificateId = Some(certificateId)))
    val studentUserIds = certificateStudents.map(student => student.userId)

    userService
      .all(certificate.companyId)
      .filter(user => studentUserIds.contains(user.getUserId.toInt))
      .filter(user => if (orgId != -1) user.getOrganizationIds.contains(orgId) else true).count(user =>
        if (filterName != "")
          user.getFullName.toLowerCase.contains(filterName.toLowerCase)
        else
          true)
  }

  def getFreeStudents(certificateId: Int, filterName: String, orgId: Int, sortBy: CertificateSortBy,
    sortAscDirection: Boolean, skip: Int, take: Int): Iterable[LUser] = {
    val certificate = certificateRepository.getById(certificateId)
    val certificateStudents = certificateToUserRepository.getBy(CertificateStateFilter(certificateId = Some(certificateId)))
    val studentUserIds = certificateStudents.map(student => student.userId)

    var users = userService
      .all(certificate.companyId)
      .filter(user => !studentUserIds.contains(user.getUserId.toInt))
      .filter(user => if (orgId != -1) user.getOrganizationIds.contains(orgId) else true)
      .filter(user => !user.getFullName.isEmpty)
    users = users.filter(user => {
      if (filterName != "")
        user.getFullName.toLowerCase.contains(filterName.toLowerCase)
      else
        true
    })

    if (!sortAscDirection) users = users.reverse
    users.drop(skip).take(take)
  }

  def getFreeStudentsCount(certificateId: Int, orgId: Int, filterName: String): Int = {
    val certificate = certificateRepository.getById(certificateId)
    val certificateStudents = certificateToUserRepository.getBy(CertificateStateFilter(certificateId = Some(certificateId)))
    val studentUserIds = certificateStudents.map(student => student.userId)

    var users = userService
      .all(certificate.companyId)
      .filter(user => !studentUserIds.contains(user.getUserId.toInt))
      .filter(user => if (orgId != -1) user.getOrganizationIds.contains(orgId) else true)
    users = users.filter(user => {
      if (filterName != "")
        user.getFullName.toLowerCase.contains(filterName.toLowerCase)
      else
        true
    })
    users.count(p => true)
  }

  def getCertificatesByUserWithOpenBadges(statementApi: StatementApi, companyId: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean,
    userId: Int, isOnlyPublished: Boolean): Seq[Certificate] = {

    var certificates = getCertificatesByUserWithOpenBadges(statementApi, companyId, userId, isOnlyPublished)

    if (!filter.isEmpty)
      certificates = certificates.filter(i => i.title.toLowerCase.contains(filter.toLowerCase))

    if (!sortAZ)
      certificates = certificates.reverse

    certificates.drop(skip).take(take)
  }

  def getCertificatesByUserWithOpenBadges(statementApi: StatementApi, companyId: Int, userId: Int, isOnlyPublished: Boolean): Seq[Certificate] = {
    val all = getForUser(userId)
      .filter(c => if (isOnlyPublished) c.isPublished else true)
      .filter(c => checker.getStatus(statementApi, c.id, userId) == CertificateStatus.Success)

    val allSortedAZ = all.sortBy(_.title.toLowerCase)

    val userEmail = userService.byId(userId).getEmailAddress

    val openbadges = OpenBadgesHelper.getOpenBadges(userEmail)
      .map(x => Certificate(id = -1, title = x("title").toString, description = x("description").toString, logo = x("logo").toString, companyId = companyId, createdAt = DateTime.now))
      .filter(p => !allSortedAZ.exists(c => c.title == p.title))

    allSortedAZ ++ openbadges
  }

  def getCertificatesCountByUserWithOpenBadges(statementApi: StatementApi, companyId: Int, filter: String, userId: Int, isOnlyPublished: Boolean): Int = {
    val all = getCertificatesByUserWithOpenBadges(statementApi, companyId, userId, isOnlyPublished)
    val allFiltered = if (filter.isEmpty)
      all
    else
      all.filter(i => i.title.toLowerCase.contains(filter.toLowerCase))

    allFiltered.length
  }

  def getIssuerBadge(certificateId: Int, liferayUserId: Int, rootUrl: String): BadgeResponse = {
    val certificate = certificateRepository.getById(certificateId)
    val recipient = "sha256$" + hashEmail(userLocalServiceHelper.getUser(liferayUserId).getEmailAddress)
    val issuerName = settingStorage
      .getByKey(SettingType.IssuerName)
      .getOrElse(model.EmptySetting(SettingType.IssuerName))
      .value

    val issuerOrganization = settingStorage
      .getByKey(SettingType.IssuerOrganization)
      .getOrElse(model.EmptySetting(SettingType.IssuerOrganization))
      .value

    val issuerUrl = settingStorage.getByKey(SettingType.IssuerURL)
      .getOrElse(model.EmptySetting(SettingType.IssuerOrganization, rootUrl))
      .value

    val issueOn = DateTime.now.toString("yyyy-MM-dd")
    val imageUrl = if (certificate.logo == "")
      "%s/learn-portlet/img/certificate-default.jpg".format(rootUrl)
    else
      "%s/delegate/files/images?folderId=%s&file=%s".format(rootUrl, certificate.id, certificate.logo)

    val description = certificate.shortDescription.replaceAll("%20", " ")

    val issue = IssuerModel(issuerUrl, issuerName, issuerOrganization)
    val badge = BadgeModel(certificate.title, imageUrl, description, rootUrl, issue)

    BadgeResponse(recipient, issueOn, badge)
  }

  private def hashEmail(email: String) = {
    val md = MessageDigest.getInstance("SHA-256")
    md.update(email.getBytes)
    HexHelper().toHexString(md.digest())
  }

  def getUsers(c: Certificate) = certificateToUserRepository.getBy(CertificateStateFilter(certificateId = Some(c.id))).map(p => (p.userJoinedDate, UserLocalServiceHelper().getUser(p.userId)))

  def getUsersCount(c: Certificate) = certificateToUserRepository.getBy(CertificateStateFilter(certificateId = Some(c.id))).size
}
