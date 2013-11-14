package com.arcusys.learn.social.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.{LFPackageVoteLocalServiceUtil, LFPackageCommentLocalServiceUtil}
import com.arcusys.learn.social.model.{PackageVote, PackageComment}
import com.arcusys.learn.persistence.liferay.model.{LFPackageVote, LFPackageComment}
import scala.collection.JavaConverters._

trait LFPackageVoteStorageImpl extends KeyedEntityStorage[PackageVote] {
  protected def doRenew() {
    LFPackageVoteLocalServiceUtil.removeAll()
  }

  def extract(entity: LFPackageVote) = PackageVote(
    entity.getId.toInt,
    entity.getUserID,
    entity.getSocialPackageID,
    entity.getVoteValue)

  def getAll(parameters: (String, Any)*): Seq[PackageVote] = parameters match {
    case Seq(("packageID", packageID: Int)) => LFPackageVoteLocalServiceUtil.findBySocialPackageID(packageID).asScala.map(extract)
    case _ => Nil
  }

  def createAndGetID(entity: PackageVote, parameters: (String, Any)*): Int = {
    val newEntity = LFPackageVoteLocalServiceUtil.createLFPackageVote()
    newEntity.setSocialPackageID(entity.socialPackageID)
    newEntity.setUserID(entity.userID)
    newEntity.setVoteValue(entity.value)
    LFPackageVoteLocalServiceUtil.addLFPackageVote(newEntity).getId.toInt
  }

  def delete(parameters: (String, Any)*) {
    parameters.find(_._1 == "id").map(_._2.asInstanceOf[Int]) foreach {
      id => LFPackageVoteLocalServiceUtil.deleteLFPackageVote(id)
    }
  }

  // Unsupported

  def getOne(parameters: (String, Any)*): Option[PackageVote] = throw new UnsupportedOperationException

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def create(entity: PackageVote, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(entity: PackageVote, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[PackageVote] = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[PackageVote] = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getByID(id: Int, parameters: (String, Any)*): Option[PackageVote] = throw new UnsupportedOperationException

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException
}
