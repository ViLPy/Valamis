package com.arcusys.valamis.certificate.repository

import javax.inject.Inject

import com.arcusys.valamis.certificate.{CertificateSortCriteria, CertificateSortBy}
import com.arcusys.valamis.certificate.model.Certificate
import com.arcusys.valamis.certificate.schema.CertificateTableComponent
import com.arcusys.valamis.certificate.storage._
import com.arcusys.valamis.core.DbNameUtils._
import com.arcusys.valamis.core.SlickProfile
import com.arcusys.valamis.exception.EntityNotFoundException
import com.arcusys.valamis.model.{SkipTake, Order}
import scala.slick.driver.JdbcProfile
import scala.slick.jdbc.JdbcBackend

class CertificateRepositoryImpl @Inject() (val db: JdbcBackend#DatabaseDef,
                                           val driver: JdbcProfile)
  extends CertificateRepository
  with CertificateTableComponent
  with SlickProfile {

  import driver.simple._

  override def create(certificate: Certificate) = db.withSession { implicit session =>
    val id = (certificates returning certificates.map(_.id)).insert(certificate)
    getById(id.toInt)
  }

  override def update(certificate: Certificate) = db.withSession { implicit session =>
    certificates.filter(_.id === certificate.id.toLong).update(certificate)
    getById(certificate.id)
  }

  override def delete(id: Int) = db.withSession(implicit session => certificates.filter(_.id === id.toLong).delete)

  override def getById(id: Long) = db.withSession(implicit session => certificates.filter(_.id === id).firstOption.getOrElse(throw new EntityNotFoundException(s"no cetificate with id: $id")))

  override def getByIds(ids: Set[Long]) =
    if (ids.isEmpty) Seq()
    else db.withSession(implicit session => certificates.filter(_.id inSet(ids)).run)

  private def composeQuery(companyId: Long,
                          titlePattern: Option[String] = None,
                          scope: Option[Option[Long]] = None,
                          sortBy: Option[CertificateSortBy] = None,
                          skipTake: Option[SkipTake] = None
                           )(implicit session: JdbcBackend#Session) = {
    val companyIdFiltered = certificates.filter(_.companyId === companyId)
    val titleFiltered = if(titlePattern.isDefined) companyIdFiltered.filter(_.title.toLowerCase.like(likePattern(titlePattern.get.toLowerCase))) else companyIdFiltered
    val scopeFiltered =
      scope match {
        case None => titleFiltered
        case Some(None) => titleFiltered.filter(_.scope.isEmpty)
        case Some(scopeValue) => titleFiltered.filter(_.scope === scopeValue)
      }

    val sorted = if(sortBy.isDefined) sortBy.get match {
      case CertificateSortBy(CertificateSortCriteria.CreatedDate, Order.Asc) => scopeFiltered.sortBy(_.createdAt)
      case CertificateSortBy(CertificateSortCriteria.CreatedDate, Order.Desc) => scopeFiltered.sortBy(_.createdAt.desc)
      case CertificateSortBy(CertificateSortCriteria.Title, Order.Asc) => scopeFiltered.sortBy(_.title)
      case CertificateSortBy(CertificateSortCriteria.Title, Order.Desc) => scopeFiltered.sortBy(_.title.desc)
    } else scopeFiltered

    skipTake.map{ case SkipTake(skip, take) =>
      sorted.drop(skip).take(take)
    }.getOrElse(sorted)
  }

  override def getBy(companyId: Long,
            titlePattern: Option[String] = None,
            scope: Option[Option[Long]] = None,
            sortBy: Option[CertificateSortBy] = None,
            skipTake: Option[SkipTake] = None) =
    db.withSession { implicit session =>  composeQuery(companyId, titlePattern, scope, sortBy, skipTake).run }

  override def getCountBy(companyId: Long,
                 titlePattern: Option[String] = None,
                 scope: Option[Option[Long]] = None) =
    db.withSession { implicit session =>  composeQuery(companyId, titlePattern, scope).length.run }
}
