package com.arcusys.learn.social.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.{ LFSocialPackageLocalServiceUtil, LFSocialPackageTagLocalServiceUtil }
import com.arcusys.learn.social.model.SocialPackage
import com.arcusys.learn.persistence.liferay.model.LFSocialPackage
import scala.collection.JavaConverters._
import org.joda.time.DateTime

trait LFSocialPackageStorageImpl extends KeyedEntityStorage[SocialPackage] {
  protected def doRenew() {
    LFSocialPackageLocalServiceUtil.removeAll()
  }

  private def extractTags(socialPackageID: Int) = LFSocialPackageTagLocalServiceUtil.findBySocialPackageID(socialPackageID).asScala.map(_.getName)

  def extract(entity: LFSocialPackage) = SocialPackage(
    entity.getId.toInt,
    entity.getPackageID,
    entity.getAboutPackage,
    new DateTime(entity.getPublishDate),
    entity.getAuthorID,
    extractTags(entity.getId.toInt))

  def getAll(parameters: (String, Any)*): Seq[SocialPackage] = parameters match {
    case Seq(("authorID", authorID: Int)) => LFSocialPackageLocalServiceUtil.findByAuthorID(authorID).asScala.map(extract)
    case Seq(("tags", tags: Seq[String])) => {
      // retrieve package IDs as sequences from tag database
      val packageIDs = tags.map(tag => LFSocialPackageTagLocalServiceUtil.findByName(tag).asScala.map(_.getSocialPackageID))
      // fold sequences using intersection to get package only with all tags
      val idsIntersection = packageIDs.tail.foldLeft(packageIDs.head) {
        (resultSet, ids) => resultSet.intersect(ids)
      }
      // retrieve packages by ID and skip if no package exists
      idsIntersection.map(id => getByID(id)).filter(_.isDefined).map(_.get)
    }
    case _ => LFSocialPackageLocalServiceUtil.getLFSocialPackages(-1, -1).asScala.map(extract)
  }

  def createAndGetID(entity: SocialPackage, parameters: (String, Any)*): Int = {
    val newEntity = LFSocialPackageLocalServiceUtil.createLFSocialPackage()
    newEntity.setPackageID(entity.packageID)
    newEntity.setAboutPackage(entity.aboutPackage)
    newEntity.setPublishDate(entity.publishDate.toDate)
    newEntity.setAuthorID(entity.authorID)
    val id = LFSocialPackageLocalServiceUtil.addLFSocialPackage(newEntity).getId.toInt

    entity.tags.foreach(tag => {
      val newTag = LFSocialPackageTagLocalServiceUtil.createLFSocialPackageTag()
      newTag.setSocialPackageID(id)
      newTag.setName(tag)
      LFSocialPackageTagLocalServiceUtil.addLFSocialPackageTag(newTag)
    })

    id
  }

  def delete(parameters: (String, Any)*) {
    parameters.find(_._1 == "id").map(_._2.asInstanceOf[Int]) foreach {
      id =>
        {
          LFSocialPackageTagLocalServiceUtil.findBySocialPackageID(id).asScala.foreach(
            LFSocialPackageTagLocalServiceUtil.deleteLFSocialPackageTag(_)
          )
          LFSocialPackageLocalServiceUtil.deleteLFSocialPackage(id)
        }
    }
  }

  // Unsupported
  def getOne(parameters: (String, Any)*): Option[SocialPackage] = throw new UnsupportedOperationException

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def create(entity: SocialPackage, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def modify(entity: SocialPackage, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[SocialPackage] = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[SocialPackage] = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getByID(id: Int, parameters: (String, Any)*): Option[SocialPackage] = throw new UnsupportedOperationException

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException
}
