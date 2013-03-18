package com.arcusys.learn.scorm.tracking.storage.impl.orbroker

import com.arcusys.learn.scorm.tracking.storage._
import com.arcusys.learn.storage.impl.orbroker._
import com.arcusys.learn.scorm.tracking.model._
import com.arcusys.learn.scorm.manifest.storage.impl.orbroker.PackagesStorageImpl
import org.orbroker.Row

class AttemptStorageImpl extends KeyedEntityStorageImpl[Attempt]("Attempt", "id") with AttemptStorage {
  val userStorage = new UserStorageImpl
  val packageStorage = new PackagesStorageImpl

  def getActive(userID: Int, packageID: Int) = getOne("userID" -> userID, "packageID" -> packageID, "isComplete" -> false)
  def getLast(userID: Int, packageID: Int, complete: Boolean = false) = getOne("userID" -> userID, "packageID" -> packageID, "getLast" -> true, "isComplete" -> complete)

  def createAndGetID(userID: Int, packageID: Int, organizationID: String) = createAndGetID(Attempt(0, User(userID), packageID, organizationID, isComplete = false))

  def markAsComplete(id: Int) {
    execute("_setcomplete", "id" -> id, "isComplete" -> true)
  }

  //TODO: review the query for effectiveness (DISTINCT detected)
  def getPackagesWithAttempts = getAll("_packages", packageStorage.extractor)

  //TODO: review the query for effectiveness (DISTINCT detected)
  def getPackagesWithUserAttempts(userID: Int) = getAll("_packages", packageStorage.extractor, "userID" -> userID)

  //TODO: review the query for effectiveness (DISTINCT detected)
  def getUsersWithAttempts = getAll("_users", userStorage.extractor)

  //TODO: review the query for effectiveness (DISTINCT detected)
  def getUsersWithAttemptsInPackage(packageID: Int) = getAll("_users", userStorage.extractor, "packageID" -> packageID)

  def checkIfComplete(userID: Int, packageID: Int)={
    val attempt = getAll("userID" -> userID, "packageID" -> packageID, "isComplete" -> true)
    !attempt.isEmpty
  }
  def extract(row: Row) = Attempt(
    row.integer("id").get,
    userStorage.getByID(row.integer("userID").get).getOrElse(throw new Exception("User not found!")),
    row.integer("packageID").get,
    row.string("organizationID").get,
    row.bit("isComplete").get)

}