package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.repositories.{ MutableEntityRepository, SelectEntityRepository }
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate

trait CertificateRepositoryContract extends MutableEntityRepository[Certificate] with SelectEntityRepository[Certificate] {

  def getById(id: Int): Certificate

  def getByCompany(companyId: Int): Iterable[Certificate]

  def getByCompanyAndTitle(companyId: Int, titlePattern: String, sortBy: String, ascOrder: Boolean, skip: Int, take: Int): Iterable[Certificate]
  def getCountByCompanyAndTitle(companyId: Int, titlePattern: String): Int

  def getByTitle(title: String): Iterable[Certificate]
}
