package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.tincan.model.{Document, OtherContent, JSONContent, ActivityProfile}
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsActivityProfileLocalServiceUtil
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsDocumentLocalServiceUtil
import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException

trait LFActivityProfileStorageImpl extends EntityStorage[ActivityProfile] {

  def getOne(parameters: (String, Any)*): Option[ActivityProfile] = parameters match {
    case Seq(("activityId", activityId: String), ("profileId", profileId: String)) => {
      try {
        val lfActivityProfile = LFTincanLrsActivityProfileLocalServiceUtil.findByActivityIdAndProfileId(activityId, profileId)
        val lfDocument = LFTincanLrsDocumentLocalServiceUtil.getLFTincanLrsDocument(lfActivityProfile.getDocumentId.toLong)
        Some(ActivityProfile(
          lfActivityProfile.getActivityId,
          lfActivityProfile.getProfileId,
          new Document(
            lfDocument.getDocumentId,
            lfDocument.getUpdate,
            lfDocument.getContent,
            lfDocument.getContentType match {
              case "Json" => JSONContent
              case "Other" => OtherContent
            }
          )
        ))
      } catch {
        case e: NoSuchLFTincanLrsActivityProfileException => None
      }
    }
  }

  def create(parameters: (String, Any)*) = parameters match {
    case Seq(("activityId", activityId: String), ("profileId", profileId: String), ("document", document: Document)) => {
      val lfDocument = LFTincanLrsDocumentLocalServiceUtil.createLFTincanLrsDocument(
        document.id,
        document.updated,
        document.cType match {
          case JSONContent => "Json"
          case OtherContent => "Other"
        },
        new String(document.contents)
      )
      LFTincanLrsActivityProfileLocalServiceUtil.createLFTincanLrsActivityProfile(activityId, profileId, lfDocument.getId.toInt)
    }
  }

  def renew() = {
    LFTincanLrsActivityProfileLocalServiceUtil.removeAll()
  }

  def delete(parameters: (String, Any)*) = parameters match {
    case Seq(("activityId", activityId: String), ("profileId", profileId: String)) => {
      try {
        val lfActivityProfile = LFTincanLrsActivityProfileLocalServiceUtil.findByActivityIdAndProfileId(activityId, profileId)
        if (lfActivityProfile != null) {
          LFTincanLrsActivityProfileLocalServiceUtil.deleteLFTincanLrsActivityProfile(lfActivityProfile)
          LFTincanLrsDocumentLocalServiceUtil.deleteLFTincanLrsDocument(lfActivityProfile.getDocumentId.toLong)
        }
      } catch {
        case e: NoSuchLFTincanLrsActivityProfileException => {
          /*ok. nothing to delete*/
        }
      }
    }
  }

  def modify(parameters: (String, Any)*) = parameters match {
    case Seq(("activityId", activityId: String), ("profileId", profileId: String), ("documentContent", newContent: String)) => {
      try {
        val lfActivity = LFTincanLrsActivityProfileLocalServiceUtil.findByActivityIdAndProfileId(activityId, profileId)
        val lfDocument = LFTincanLrsDocumentLocalServiceUtil.getLFTincanLrsDocument(lfActivity.getDocumentId.toLong)
        lfDocument.setContent(newContent)
        LFTincanLrsDocumentLocalServiceUtil.updateLFTincanLrsDocument(lfDocument)
      } catch {
        case e: NoSuchLFTincanLrsActivityProfileException => {
          /*nothing to modify*/
        }
      }
    }
  }

  def getAll(parameters: (String, Any)*): Seq[ActivityProfile] = throw new UnsupportedOperationException()

  def create(entity: ActivityProfile, parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def modify(entity: ActivityProfile, parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def execute(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[ActivityProfile] = throw new UnsupportedOperationException()

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[ActivityProfile] = throw new UnsupportedOperationException()

  def modify(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException()
}
