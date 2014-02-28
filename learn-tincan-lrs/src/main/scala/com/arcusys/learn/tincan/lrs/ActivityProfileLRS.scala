package com.arcusys.learn.tincan.lrs

package activityprofile {

  import java.util.Date

  import com.arcusys.learn.tincan.storage.{TincanActivityStorage, ActivityProfileStorage}
  import com.arcusys.learn.tincan.model.{ActivityProfile, Activity, Document, JSONContent, OtherContent}
  import com.arcusys.learn.tincan.lrs.utils.JsonCombiner


  trait ActivityProfileLRS {
    val activityStorage: TincanActivityStorage
    val activityProfileStorage: ActivityProfileStorage

    implicit val argumentProfileException = ActivityProfileLRSArgumentException("")

    def getCompleteActivity(activityId: String): Option[Activity] = {
      require(
        activityId != null && !activityId.isEmpty,
        "Incorrect arguments were passed in the 'ActivityProfileLRS.getCompleteActivity' method")
      activityStorage.getById(activityId)
    }

    def getActivityDocument(activityId: String, profileId: String): Option[Document] = {
      checkArguments(activityId, profileId, "Incorrect parameters were passed to ActivityProfileLRS.getActivityDocument")
      activityProfileStorage.get(activityId, profileId).map(_.document)
    }

    def getActivityDocumentIds(activityId: String, since: Option[Date]): Seq[String] = {
      require(activityId != null && !activityId.isEmpty,
        "Incorrect parameters were passed into 'ActivityProfileLRS.getActivityDocumentIds'")
      activityProfileStorage.getIds(activityId, since)
    }

    def addActivityDocument(activityId: String, profileId: String, document: Document) {
      require(document != null, "Incorrect document object was passed to ActivityProfileLRS.addActivityDocument")
      checkArguments(activityId, profileId, "Incorrect parameters were passed to ActivityProfileLRS.addActivityDocument")

      val stored = activityProfileStorage.get(activityId, profileId)
      stored match {
        case Some(_) =>
          throw ActivityProfileLRSAlreadyExistsException("The document with activity {%s} and profile {%s} already exists".
            format(activityId, profileId))
        case None =>
          activityProfileStorage.create(ActivityProfile(activityId, profileId, document))
      }
    }

    def modifyActivityDocument(activityId: String, profileId: String, document: Document) {
      require(document != null, "Incorrect document object was passed to ActivityProfileLRS.modifyActivityDocument")
      checkArguments(activityId, profileId, "Incorrect parameters were passed to ActivityProfileLRS.modifyActivityDocument")

      val stored = activityProfileStorage.get(activityId, profileId)
      stored match {
        case None =>
          throw ActivityProfileLRSNotExistsException("There is no document with activity {%s} and profile {%s}".
            format(activityId, profileId))

        case Some(s) if s.document.cType == JSONContent && document.cType == JSONContent =>
          val newContent = try {
            JsonCombiner.combine(s.document.contents, document.contents)
          }
          catch {
            case exception: Throwable =>
              throw ActivityProfileLRSContentModificationException("Json Content type of given document can`t be compared with content type of existing document", exception)
          }
          activityProfileStorage.modify(ActivityProfile(activityId, profileId, document.copy(contents = newContent)))

        case Some(s) if s.document.cType == OtherContent && document.cType == OtherContent =>
          activityProfileStorage.modify(ActivityProfile(activityId, profileId, document))

        case _ =>
          throw new ActivityProfileLRSContentModificationException("Content type of given document doesn't match with content type of existing document")
      }
    }

    def deleteActivityDocument(activityId: String, profileId: String) {
      checkArguments(activityId, profileId, "Incorrect parameters were passed to ActivityProfileLRS.deleteActivityDocument")
       activityProfileStorage.delete(activityId, profileId)
    }

    private def checkArguments(activityId: String, profileId: String, message: String = "") = {
      require(activityId != null && !activityId.isEmpty && profileId != null && !profileId.isEmpty, message)
    }

    private def require(predicate: Boolean, message: String = "") {
      if (!predicate) throw ActivityProfileLRSArgumentException(message)
    }

  }

}

case class ActivityProfileLRSArgumentException(message: String) extends Exception(message)

case class ActivityProfileLRSException(message: String) extends Exception(message)

case class ActivityProfileLRSAlreadyExistsException(message: String) extends Exception(message)

case class ActivityProfileLRSNotExistsException(message: String) extends Exception(message)

case class ActivityProfileLRSContentModificationException(message: String, cause: Throwable) extends Exception(message) {
  def this(message: String) = this(message, null)
}
