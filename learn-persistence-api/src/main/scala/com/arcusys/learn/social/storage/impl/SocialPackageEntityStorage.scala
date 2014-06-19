package com.arcusys.learn.social.storage.impl

import com.arcusys.learn.storage.impl.{ EntityStorageExt, KeyedEntityStorageExt }
import com.arcusys.learn.social.model.SocialPackage
import com.arcusys.learn.social.storage.SocialPackageStorage

trait SocialPackageEntityStorage extends SocialPackageStorage with KeyedEntityStorageExt[SocialPackage] with EntityStorageExt[SocialPackage] {

  def getByTags(tags: Seq[String]) = getAll("tags" -> tags)

  def getByAuthor(authorID: Int) = getAll("authorID" -> authorID)
}
