package com.arcusys.learn.social.storage

import com.arcusys.learn.social.model.SocialPackage

trait SocialPackageStorage {
  def getAll: Seq[SocialPackage]
  def getByTags(tags: Seq[String]): Seq[SocialPackage]
  def getByAuthor(authorID: Int): Seq[SocialPackage]
  def getByID(id: Int): Option[SocialPackage]
  def createAndGetID(entity: SocialPackage): Int
  def delete(id: Int)
  def modify(entity: SocialPackage)
  def renew()
}
