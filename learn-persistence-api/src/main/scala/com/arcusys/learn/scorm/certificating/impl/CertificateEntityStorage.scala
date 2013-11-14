package com.arcusys.learn.scorm.certificating.impl

import com.arcusys.learn.scorm.certificating.CertificateStorage
import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}
import com.arcusys.learn.scorm.tracking.model.certificating.{CertificatePage, Certificate}

/**
 * User: Yulia.Glushonkova
 * Date: 10.06.13
 */
trait CertificateEntityStorage extends CertificateStorage with KeyedEntityStorageExt[Certificate] with EntityStorageExt[Certificate] {
  def getPage(companyID: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean): CertificatePage = {
    val all = getAll("companyID" -> companyID)
    val allFiltered = if (!filter.isEmpty) all.filter(i=>i.title.toLowerCase.contains(filter.toLowerCase)) else all
    val allSortedAZ = allFiltered.sortBy(_.title.toLowerCase)
    val allSorted = if (sortAZ) allSortedAZ else allSortedAZ.reverse
    val page = allSorted.drop(skip).take(take).reverse
    new CertificatePage(page, allFiltered.length)
  }

  def saveLogo(id: Int, logo: String) {
    modify("id" -> id, "logo" -> logo)
  }

}
