package com.arcusys.valamis.certificate.repository

import javax.inject.Inject

import com.arcusys.valamis.certificate.model.{CertificateStateFilter, CertificateStatus, Certificate, CertificateState}
import com.arcusys.valamis.certificate.schema.{CertificateTableComponent, CertificateStateTableComponent}
import com.arcusys.valamis.certificate.storage.CertificateStateRepository
import com.arcusys.valamis.core.{SlickProfile, SlickDBInfo}
import com.escalatesoft.subcut.inject.{Injectable, BindingModule}
import org.joda.time.DateTime

import scala.slick.driver.JdbcProfile
import scala.slick.jdbc.JdbcBackend

class CertificateStateRepositoryImpl @Inject() (val db: JdbcBackend#DatabaseDef,
                                                val driver: JdbcProfile)
  extends CertificateStateTableComponent
  with CertificateStateRepository
  with SlickProfile
  with CertificateTableComponent{

  import driver.simple._

  implicit val CertificateStatusTypeMapper = MappedColumnType.base[CertificateStatus.Value, String](
    s => s.toString,
    s => CertificateStatus.withName(s)
  )

  override def create(state: CertificateState) = db.withSession { implicit session =>
    certificateStates.insert(state)
    getBy(state.userId, state.certificateId).get
  }

  override def getBy(userId: Long, certificateId: Long) = db.withSession { implicit session =>
    certificateStates.filter(ca => ca.userId === userId && ca.certificateId === certificateId).firstOption
  }

  override def getBy(filter: CertificateStateFilter) = db.withSession { implicit session =>
    val collection = certificateStates
    val userIdFiltered = 
      if(filter.userId.isDefined) collection.filter(_.userId === filter.userId.get)
      else collection
    val certificateIdFiltered =
      if(filter.certificateId.isDefined) userIdFiltered.filter(_.certificateId === filter.certificateId.get)
      else userIdFiltered
    val statusFiltered =
      if(filter.statuses.nonEmpty) certificateIdFiltered.filter(_.status inSet(filter.statuses))
      else certificateIdFiltered
    statusFiltered.run
  }

  override def update(state: CertificateState) = db.withSession { implicit session =>
    certificateStates.filter(entity => entity.certificateId === state.certificateId.toLong && entity.userId === state.userId).update(state)
    getBy(state.userId, state.certificateId).get
  }


  override def delete(userId: Long, certificateId: Long) = db.withSession { implicit session =>
    certificateStates.filter(ca => ca.userId === userId && ca.certificateId === certificateId).delete
  }

  override def delete(states: Seq[CertificateState]) = db.withSession { implicit session =>
    if(!states.isEmpty)
      certificateStates
        .filter(dbCA => states.map(ca => dbCA.userId === ca.userId && dbCA.certificateId === ca.certificateId).reduce(_||_))
        .delete
  }
}
