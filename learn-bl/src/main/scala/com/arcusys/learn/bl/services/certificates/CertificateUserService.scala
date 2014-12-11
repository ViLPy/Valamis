package com.arcusys.learn.bl.services.certificates

import java.security.MessageDigest

import com.arcusys.learn.bl.services.certificates.CertificateStatusCheckerContract
import com.arcusys.learn.bl.services.{ UserServiceContract, CertificateServiceContract }
import com.arcusys.learn.bl.models.{ IssuerModel, BadgeModel, BadgeResponse }
import com.arcusys.learn.bl.models.certificates.CertificateSortBy
import com.arcusys.learn.bl.models.certificates.CertificateSortBy.CertificateSortBy
import com.arcusys.learn.bl.utils.{ OpenBadgesHelper, HexHelper }
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.scorm.certificating.{ CertificateUserRepositoryContract, CertificateRepositoryContract }
import com.arcusys.learn.scorm.tracking.model.certificating.{ CertificateStatus, Certificate }
import com.arcusys.learn.setting.storage.SettingStorage
import com.arcusys.learn.settings.model.{ EmptySetting, SettingType }
import com.escalatesoft.subcut.inject.Injectable
import com.liferay.portal.model.User
import com.liferay.portal.security.auth.PrincipalThreadLocal
import com.liferay.portal.security.permission.{ PermissionThreadLocal, PermissionCheckerFactoryUtil }
import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat

//TODO refactor, move badge client code to BadgeClient class
trait CertificateUserService extends Injectable with CertificateServiceContract {

  private lazy val userLocalServiceHelper = inject[UserLocalServiceHelper]
  private lazy val certificateRepository = inject[CertificateRepositoryContract]
  private lazy val certificateToUserRepository = inject[CertificateUserRepositoryContract]

  private lazy val userFacade = inject[UserServiceContract]
  private lazy val settingStorage = inject[SettingStorage]

  private lazy val checker = inject[CertificateStatusCheckerContract]
  //new CertificateStatusChecker(bindingModule)

  def addUser(certificateId: Int, userId: Int) = {
    val certificate = certificateRepository.getById(certificateId)
    val user = userFacade.byId(userId)

    certificateToUserRepository.create(certificate, (DateTime.now, user.getUserId))
  }

  def deleteUser(certificateId: Int, userId: Int) = {
    val certificate = certificateRepository.getById(certificateId)
    val user = userFacade.byId(userId)

    certificateToUserRepository.delete(certificate, (DateTime.now, user.getUserId))
  }

  def getForUser(companyID: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean,
    userId: Int, isOnlyPublished: Boolean): Seq[Certificate] = {
    var certificates = getForUser(companyID, userId).filter(c => if (isOnlyPublished) c.isPublished else true)
    certificates = filtering(certificates, filter)
      .sortBy(_.title.toLowerCase)
    if (!sortAZ) certificates = certificates.reverse
    if (skip < 0)
      certificates
    else
      certificates.drop(skip).take(take)
  }

  def forUserCount(companyID: Int, filter: String, userId: Int, isOnlyPublished: Boolean): Int = {
    val certificates = getForUser(companyID, userId).filter(c => if (isOnlyPublished) c.isPublished else true)
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

  def availableForUserCount(companyID: Int, userId: Int, filter: String, isOnlyPublished: Boolean, scope: Option[Long]): Int = {
    val certificates = scope match {
      case Some(value) => getAvailableForUser(companyID, userId, isOnlyPublished)
        .filter(x => x.scope.isDefined)
        .filter(x => x.scope.get == value)

      case None => getAvailableForUser(companyID, userId, isOnlyPublished)
    }

    val filteredCertificates = filtering(certificates, filter)

    filteredCertificates.length
  }

  def getForUserWithStatus(companyID: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean,
    userId: Int, isOnlyPublished: Boolean): Seq[Certificate] = {

    var certificates = getForUser(companyID, userId).filter(c => if (isOnlyPublished) c.isPublished else true)
    certificates = filtering(certificates, filter)
      .sortBy(_.title.toLowerCase)

    if (!sortAZ) certificates = certificates.reverse

    if (skip < 0)
      certificates
    else
      certificates.drop(skip).take(take)
  }

  def getForUser(companyID: Int, userId: Int): Seq[Certificate] = {
    val user = userLocalServiceHelper.getUserById(companyID, userId)
    certificateToUserRepository.getRight((DateTime.now, user.getUserId)).reverse
  }

  private def getAvailableForUser(companyID: Int, userId: Int, isOnlyPublished: Boolean): Seq[Certificate] = {
    val usersCertificates = getForUser(companyID, userId)

    val all = certificateRepository.getByCompany(companyID)
      .filter(c => if (isOnlyPublished) c.isPublished else true)

    all.filter(certificate => !usersCertificates.exists(c => c.id == certificate.id)).toSeq
  }

  def getAvailableForUser(companyID: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean, userId: Int,
    isOnlyPublished: Boolean, scope: Option[Long]): Seq[Certificate] = {
    var certificates = scope match {
      case Some(value) => getAvailableForUser(companyID, userId, isOnlyPublished)
        .filter(x => x.scope.isDefined)
        .filter(x => x.scope.get == value)

      case None => getAvailableForUser(companyID, userId, isOnlyPublished)
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
    sortAscDirection: Boolean, skip: Int, take: Int): Iterable[(String, User)] = {
    val certificate = certificateRepository.getById(certificateId)
    val certificateStudents = certificateToUserRepository.getLeft(certificate)
    val studentUserIds = certificateStudents.map(student => student._2)
    val formatter = ISODateTimeFormat.dateTime()
    var users = userFacade
      .all(certificate.companyId)
      .filter(user => studentUserIds.contains(user.getUserId.toInt))
      .filter(user => if (orgId != -1) user.getOrganizationIds.contains(orgId) else true)
      .filter(user => {
        if (filterName != "")
          user.getFullName.toLowerCase.contains(filterName.toLowerCase)
        else
          true
      })
      .map(u => {
        val permissionChecker = PermissionCheckerFactoryUtil.create(u)

        PermissionThreadLocal.setPermissionChecker(permissionChecker)
        PrincipalThreadLocal.setName(u.getUserId)

        (formatter.print(certificateStudents.find(v => v._2 == u.getUserId).head._1), u) //..UserResponseWithCertificateStatus(u.getUserId, u.getFullName, UserResponseUtils.getPortraitUrl(u), UserResponseUtils.getPublicUrl(u), checker.getStatus(certificate.id, u.getUserId.toInt).toString))
      })
      .sortBy(u => sortBy match {
        case CertificateSortBy.UserJoined => u._1
        case _                            => u._2.getFullName
      })

    if (!sortAscDirection) users = users.reverse
    users.drop(skip).take(take)
  }

  def getJoinedUsersCount(certificateId: Int, filterName: String, orgId: Int): Int = {
    val certificate = certificateRepository.getById(certificateId)
    val certificateStudents = certificateToUserRepository.getLeft(certificate)
    val studentUserIds = certificateStudents.map(student => student._2)

    userFacade
      .all(certificate.companyId)
      .filter(user => studentUserIds.contains(user.getUserId.toInt))
      .filter(user => if (orgId != -1) user.getOrganizationIds.contains(orgId) else true).count(user =>
        if (filterName != "")
          user.getFullName.toLowerCase.contains(filterName.toLowerCase)
        else
          true)
  }

  def getFreeStudents(certificateId: Int, filterName: String, orgId: Int, sortBy: CertificateSortBy,
    sortAscDirection: Boolean, skip: Int, take: Int): Iterable[User] = {
    val certificate = certificateRepository.getById(certificateId)
    val certificateStudents = certificateToUserRepository.getLeft(certificate)
    val studentUserIds = certificateStudents.map(student => student._2)

    var users = userFacade
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
    val certificateStudents = certificateToUserRepository.getLeft(certificate)
    val studentUserIds = certificateStudents.map(student => student._2)

    var users = userFacade
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

  def getCertificatesByUserWithOpenBadges(companyID: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean,
    userId: Int, isOnlyPublished: Boolean): Seq[Certificate] = {

    var certificates = getCertificatesByUserWithOpenBadges(companyID, userId, isOnlyPublished)

    if (!filter.isEmpty)
      certificates = certificates.filter(i => i.title.toLowerCase.contains(filter.toLowerCase))

    if (!sortAZ)
      certificates = certificates.reverse

    certificates.drop(skip).take(take)
  }

  def getCertificatesByUserWithOpenBadges(companyID: Int, userId: Int, isOnlyPublished: Boolean): Seq[Certificate] = {
    val all = getForUser(companyID, userId)
      .filter(c => if (isOnlyPublished) c.isPublished else true)
      .filter(c => checker.getStatus(c.id, userId) == CertificateStatus.Success)

    val allSortedAZ = all.sortBy(_.title.toLowerCase)

    val userEmail = userFacade.byId(userId).getEmailAddress

    val openbadges = OpenBadgesHelper.getOpenBadges(userEmail)
      .map(x => Certificate(id = -1, title = x("title").toString, description = x("description").toString, logo = x("logo").toString, companyId = companyID, createdAt = DateTime.now))
      .filter(p => !allSortedAZ.exists(c => c.title == p.title))

    (allSortedAZ ++ openbadges)
  }

  def getCertificatesCountByUserWithOpenBadges(companyID: Int, filter: String, userId: Int, isOnlyPublished: Boolean): Int = {
    val all = getCertificatesByUserWithOpenBadges(companyID, userId, isOnlyPublished)
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
      .getOrElse(EmptySetting(SettingType.IssuerName))
      .value

    val issuerOrganization = settingStorage
      .getByKey(SettingType.IssuerOrganization)
      .getOrElse(EmptySetting(SettingType.IssuerOrganization))
      .value

    val issuerUrl = settingStorage.getByKey(SettingType.IssuerURL)
      .getOrElse(EmptySetting(SettingType.IssuerOrganization, rootUrl))
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

  def getUsers(c: Certificate) = {
    certificateToUserRepository.getLeft(c).map(p => (p._1, UserLocalServiceHelper().getUser(p._2)))
  }
  def getUsersCount(c: Certificate) =
    certificateToUserRepository.getLeft(c).size

}
