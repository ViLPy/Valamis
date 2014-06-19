package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.tincan.model.{ Document, OtherContent, JSONContent, ActivityProfile }
import com.arcusys.learn.persistence.liferay.model.LFTincanActProfile
import com.arcusys.learn.persistence.liferay.service.{ LFTincanActProfileLocalServiceUtil, LFTincanLrsDocumentLocalServiceUtil }
import com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException
import scala.collection.JavaConverters._
import org.joda.time.DateTime

trait LFActivityProfileStorageImpl extends EntityStorage[ActivityProfile] {

  def mapper(entity: LFTincanActProfile): ActivityProfile = {
    val lfDocument = LFTincanLrsDocumentLocalServiceUtil.getLFTincanLrsDocument(entity.getDocumentId.toLong)

    ActivityProfile(entity.getActivityId,
      entity.getProfileId,
      new Document(
        lfDocument.getDocumentId,
        new DateTime(lfDocument.getUpdate),
        lfDocument.getContent,
        lfDocument.getContentType match {
          case "Json"  => JSONContent
          case "Other" => OtherContent
        }
      ))
  }

  def getOne(parameters: (String, Any)*): Option[ActivityProfile] = parameters match {
    case Seq(("activityId", activityId: String), ("profileId", profileId: String)) => {
      try {

        val lfActivityProfile = LFTincanActProfileLocalServiceUtil.findByActivityIdAndProfileId(activityId, profileId)
        Some(mapper(lfActivityProfile))

      } catch {
        case e: NoSuchLFTincanActProfileException => None
      }
    }
  }

  def create(parameters: (String, Any)*) = parameters match {
    case Seq(("activityId", activityId: String), ("profileId", profileId: String), ("document", document: Document)) => {
      val lfDocument = LFTincanLrsDocumentLocalServiceUtil.createLFTincanLrsDocument(
        document.id,
        document.updated.toDate,
        document.cType match {
          case JSONContent  => "Json"
          case OtherContent => "Other"
        },
        new String(document.contents)
      )
      LFTincanActProfileLocalServiceUtil.createLFTincanLrsActivityProfile(activityId, profileId, lfDocument.getId.toInt)
    }
  }

  def renew() = {
    LFTincanActProfileLocalServiceUtil.removeAll()
  }

  def delete(parameters: (String, Any)*) = parameters match {
    case Seq(("activityId", activityId: String), ("profileId", profileId: String)) => {
      try {
        val lfActivityProfile = LFTincanActProfileLocalServiceUtil.findByActivityIdAndProfileId(activityId, profileId)
        if (lfActivityProfile != null) {
          LFTincanActProfileLocalServiceUtil.deleteLFTincanActProfile(lfActivityProfile)
          LFTincanLrsDocumentLocalServiceUtil.deleteLFTincanLrsDocument(lfActivityProfile.getDocumentId.toLong)
        }
      } catch {
        case e: NoSuchLFTincanActProfileException => {
          /*ok. nothing to delete*/
        }
      }
    }
  }

  def modify(parameters: (String, Any)*) = parameters match {
    case Seq(("activityId", activityId: String), ("profileId", profileId: String), ("documentContent", newContent: String)) => {
      try {
        val lfActivity = LFTincanActProfileLocalServiceUtil.findByActivityIdAndProfileId(activityId, profileId)
        val lfDocument = LFTincanLrsDocumentLocalServiceUtil.getLFTincanLrsDocument(lfActivity.getDocumentId.toLong)
        lfDocument.setContent(newContent)
        LFTincanLrsDocumentLocalServiceUtil.updateLFTincanLrsDocument(lfDocument)
      } catch {
        case e: NoSuchLFTincanActProfileException => {
          /*nothing to modify*/
        }
      }
    }
  }

  def getAll(parameters: (String, Any)*): Seq[ActivityProfile] = parameters match {
    case Seq(("activityId", activityId: String), ("since", since: Option[DateTime])) => {
      LFTincanActProfileLocalServiceUtil.findByActivityId(activityId).asScala
        .map(mapper)
        .filter(activity =>
          (!since.isDefined || activity.document.updated.getMillis >= since.get.getMillis))
    }
    case _ => Nil
  }

  def create(entity: ActivityProfile, parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def modify(entity: ActivityProfile, parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def execute(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[ActivityProfile] = throw new UnsupportedOperationException()

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[ActivityProfile] = throw new UnsupportedOperationException()

  def modify(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException()
}
