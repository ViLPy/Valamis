package com.arcusys.learn.scorm.tracking.model.certificating

/**
* A site which is part of certificate
* @param id             Unique internal ID
* @param certificateID  ID of certificate this site belongs to
*/
case class CertificateSite (
  id: Int,
  certificateID: Int,
  siteID: Int,
  arrangementIndex: Int
)
