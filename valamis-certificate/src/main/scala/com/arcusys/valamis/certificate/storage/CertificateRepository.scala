package com.arcusys.valamis.certificate.storage

import com.arcusys.valamis.certificate.CertificateSortBy
import com.arcusys.valamis.certificate.model.Certificate
import com.arcusys.valamis.model.SkipTake

trait CertificateRepository {
  def create(certificate: Certificate): Certificate
  def update(certificate: Certificate): Certificate
  def delete(id: Int)

  def getById(id: Long): Certificate
  def getByIds(ids: Set[Long]): Seq[Certificate]

  def getBy(companyId: Long,
            titlePattern: Option[String] = None,
            scope: Option[Option[Long]] = None,
            sortBy: Option[CertificateSortBy] = None,
            skipTake: Option[SkipTake] = None): Seq[Certificate]


  def getCountBy(companyId: Long,
                 titlePattern: Option[String] = None,
                 scope: Option[Option[Long]] = None): Int
}