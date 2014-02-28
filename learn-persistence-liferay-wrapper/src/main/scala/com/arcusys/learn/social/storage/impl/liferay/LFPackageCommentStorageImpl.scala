package com.arcusys.learn.social.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.LFPackageCommentLocalServiceUtil
import com.arcusys.learn.social.model.{SocialPackage, PackageComment}
import com.arcusys.learn.persistence.liferay.model.{LFPackageComment, LFSocialPackage}
import scala.collection.JavaConverters._

trait LFPackageCommentStorageImpl extends KeyedEntityStorage[PackageComment] {
  protected def doRenew() {
    LFPackageCommentLocalServiceUtil.removeAll()
  }

  def extract(entity: LFPackageComment) = PackageComment(
    entity.getId.toInt,
    entity.getSocialPackageID,
    entity.getAuthorID,
    entity.getComment,
    entity.getPublishDate)

  def getAll(parameters: (String, Any)*): Seq[PackageComment] = parameters match {
    case Seq(("packageID", packageID: Int)) => LFPackageCommentLocalServiceUtil.findBySocialPackageID(packageID).asScala.map(extract)
    case _ => Nil
  }

  def createAndGetID(entity: PackageComment, parameters: (String, Any)*): Int = {
    val newEntity = LFPackageCommentLocalServiceUtil.createLFPackageComment()
    newEntity.setSocialPackageID(entity.socialPackageID)
    newEntity.setAuthorID(entity.authorID)
    newEntity.setComment(entity.comment)
    newEntity.setPublishDate(entity.publishDate)
    LFPackageCommentLocalServiceUtil.addLFPackageComment(newEntity).getId.toInt
  }

  def delete(parameters: (String, Any)*) {
    parameters.find(_._1 == "id").map(_._2.asInstanceOf[Int]) foreach {
      id => LFPackageCommentLocalServiceUtil.deleteLFPackageComment(id)
    }
  }

  // Unsupported

  def getOne(parameters: (String, Any)*): Option[PackageComment] = throw new UnsupportedOperationException

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def create(entity: PackageComment, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(entity: PackageComment, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[PackageComment] = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[PackageComment] = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getByID(id: Int, parameters: (String, Any)*): Option[PackageComment] = throw new UnsupportedOperationException

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException
}
