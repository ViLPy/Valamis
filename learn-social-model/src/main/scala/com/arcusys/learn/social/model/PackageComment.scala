package com.arcusys.learn.social.model

import org.joda.time.DateTime

/**
 * Represents comment model for Valamis Social Package
 *
 * @param id - primary key
 * @param socialPackageID - package ID which is parent for comment
 * @param authorID - Liferay user ID
 * @param comment - content
 * @param publishDate - date  of publishing
 */
case class PackageComment(id: Int,
  socialPackageID: Int,
  authorID: Int,
  comment: String,
  publishDate: DateTime)
