package com.arcusys.learn.social.storage.impl

import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}
import com.arcusys.learn.social.storage.PackageCommentStorage
import com.arcusys.learn.social.model.PackageComment

trait PackageCommentEntityStorage extends PackageCommentStorage with KeyedEntityStorageExt[PackageComment] with EntityStorageExt[PackageComment] {
  def getByPackageID(packageID: Int) = getAll("packageID" -> packageID)
}
