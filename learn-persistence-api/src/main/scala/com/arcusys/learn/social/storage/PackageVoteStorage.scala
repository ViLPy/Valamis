package com.arcusys.learn.social.storage

import com.arcusys.learn.social.model.PackageVote

trait PackageVoteStorage {
  def getByPackageID(packageID: Int): Seq[PackageVote]
  def createAndGetID(entity: PackageVote): Int
  def delete(id: Int)
  def modify(entity: PackageVote)
  def renew()
}
