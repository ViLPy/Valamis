package com.arcusys.learn.social.model

import java.util.Date

/**
 * Represents package model for Valamis Social Dashboard
 *
 * @param id - model primary key
 * @param packageID - SCORM package ID
 * @param aboutPackage - package detailed description
 * @param publishDate - date  of publishing
 * @param authorID - Liferay user ID
 * @param tags - list of tags associated to package
 */
case class SocialPackage(id: Int,
                        packageID: Int,
                        aboutPackage: String,
                        publishDate: Date,
                        authorID: Int,
                        tags: Seq[String])
