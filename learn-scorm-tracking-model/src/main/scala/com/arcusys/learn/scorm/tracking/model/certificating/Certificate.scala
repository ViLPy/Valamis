package com.arcusys.learn.scorm.tracking.model.certificating

/**
 * Certificate to be passed by user. Contains list of sites.
 *
 * @param id                  Unique internal ID
 * @param title               Short title
 * @param description         More detailed description
 */
case class Certificate
(
  id: Int,
  title: String,
  description: String
)
