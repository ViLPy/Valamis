//package com.arcusys.learn.facades
//
//import com.arcusys.learn.models.response.certificates.CertificateResponseContract
//import com.arcusys.learn.service.util.OpenBadgesHelper
//import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
//import com.escalatesoft.subcut.inject.Injectable
//import org.joda.time.DateTime
//import com.arcusys.learn.liferay.services.UserLocalServiceHelper
//import com.arcusys.learn.scorm.certificating.CertificateUserRepositoryContract
//
///**
// * Created by Iliya Tryapitsin on 10.06.2014.
// */
//trait CertificatesByUser extends Injectable {
//  private lazy val userFacade = inject[UserFacadeContract]
//  private lazy val userLocalServiceHelper = inject[UserLocalServiceHelper]
//  private lazy val certificateToUserRepository = inject[CertificateUserRepositoryContract]
//
//  private def getForUser(companyID: Int,
//    userId: Int): Seq[Certificate] = {
//    val user = userLocalServiceHelper.getUserById(companyID, userId)
//    certificateToUserRepository.getRight((DateTime.now, user))
//  }
//
//  def getCertificatesByUserWithOpenBadges(companyID: Int,
//    userId: Int,
//    isOnlyPublished: Boolean): Seq[CertificateResponseContract] = {
//    val all = getForUser(companyID, userId)
//      .filter(c => if (isOnlyPublished) c.isPublished else true)
//
//    val allSortedAZ = all.sortBy(_.title.toLowerCase)
//
//    val userEmail = userFacade.byId(userId).getEmailAddress
//
//    val openbadges = OpenBadgesHelper.getOpenBadges(userEmail)
//      .map(x => Certificate(id = -1, title = x("title").toString, description = x("description").toString, logo = x("logo").toString, companyId = companyID))
//      .filter(p => !allSortedAZ.exists(c => c.title == p.title))
//
//    (allSortedAZ ++ openbadges).map(toCertificateResponse(true))
//  }
//
//  def getCertificatesByUserWithOpenBadges(companyID: Int,
//    skip: Int,
//    take: Int,
//    filter: String,
//    sortAZ: Boolean,
//    userId: Int,
//    isOnlyPublished: Boolean): Seq[CertificateResponseContract] = {
//    val all = getCertificatesByUserWithOpenBadges(companyID, userId, isOnlyPublished)
//    val allFiltered = filtering(all, filter)
//    takeForPage(allFiltered, skip, take, sortAZ)
//  }
//
//  def getCertificatesCountByUserWithOpenBadges(companyID: Int,
//    filter: String,
//    userId: Int,
//    isOnlyPublished: Boolean): Int = {
//    val all = getCertificatesByUserWithOpenBadges(companyID, userId, isOnlyPublished)
//    val allFiltered = filtering(all, filter)
//    allFiltered.length
//  }
//}
