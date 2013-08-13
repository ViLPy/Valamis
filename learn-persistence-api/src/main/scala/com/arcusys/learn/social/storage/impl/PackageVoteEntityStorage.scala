package com.arcusys.learn.social.storage.impl

import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}
import com.arcusys.learn.social.storage.PackageVoteStorage
import com.arcusys.learn.social.model.PackageVote

trait PackageVoteEntityStorage extends PackageVoteStorage with KeyedEntityStorageExt[PackageVote] with EntityStorageExt[PackageVote] {
   def getByPackageID(packageID: Int) = getAll("packageID" -> packageID)
 }
