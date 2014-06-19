package com.arcusys.learn.social.model

/**
 * Represents vote which is used for calculating package rating
 *
 * @param id - primary key
 * @param userID - voter ID
 * @param socialPackageID - package ID
 * @param value - voting value, e.g. -1, 1
 */
case class PackageVote(id: Int,
  userID: Int,
  socialPackageID: Int,
  value: Int)
