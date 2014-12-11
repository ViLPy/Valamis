package com.arcusys.learn.tincan.lrs

import com.arcusys.learn.tincan.lrs.activityprofile._
import com.arcusys.learn.tincan.model.{ Activity, ActivityProfile, _ }
import com.arcusys.learn.tincan.storage.{ ActivityProfileStorage, TincanActivityStorage }
import org.joda.time.DateTime
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import sun.reflect.generics.reflectiveObjects.NotImplementedException

@RunWith(classOf[JUnitRunner])
class ActivityProfileLRSSpec extends Specification {
  sequential

  private val service = new ActivityProfileLRS {
    val activityStorage: TincanActivityStorage = InMemoryActivityStorage
    val activityProfileStorage: ActivityProfileStorage = InMemoryActivityProfileStorage
  }

  "Activity Profile LRS Specification".title

  "The 'getCompleteActivity' method" should {

    "return the activity by specified id" in {
      val result = service.getCompleteActivity("activityId-666")
      result must beSome
      result.get.id mustEqual "activityId-666"
      result.get.objectType mustEqual "Activity"
      result.get.name must beNone
      result.get.description must beNone
      result.get.theType must beNone
      result.get.moreInfo must beNone
      result.get.interactionType must beNone
      result.get.correctResponsesPattern must have size 0
      result.get.choices must have size 0
      result.get.scale must have size 0
      result.get.source must have size 0
      result.get.target must have size 0
      result.get.steps must have size 0
      result.get.extensions must beNone
    }

    "return nothing if the activity for given id doesn't exist" in {
      val result = service.getCompleteActivity("activityId-111")
      result must beNone
    }

    "throw 'ActivityProfileArgumentException' if given activity id is a null " in {
      service.getCompleteActivity(null) must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given activity id is an empty str!g " in {
      service.getCompleteActivity("") must throwA[ActivityProfileLRSArgumentException]
    }

  }

  "The 'getActivityDocumentIds' method" should {

    "return ids of those profiles that have been stored or updated since specified timestamp" in {
      val since = System.currentTimeMillis() - 14000l
      val result = service.getActivityDocumentIds("activityId-666", Some(new DateTime(since)))
      result must have size 1
      result.contains("profileId-888")
    }

    "throw 'ActivityProfileArgumentException' if activity id is null" in {
      service.getActivityDocumentIds(null, None) must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if activity id is an empty string" in {
      service.getActivityDocumentIds("", None) must throwA[ActivityProfileLRSArgumentException]
    }

  }

  "The 'getActivityDocument' method" should {

    "return the document by given activity id and profile id" in {
      val result = service.getActivityDocument("activityId-999", "profileId-666")
      result must beSome
      result.get.id mustEqual "documentId-111"
      new String(result.get.contents.toArray) mustEqual "{x: 12\ny: 13}"
    }

    "return nothing if the document doesn't exist for specific activity and profile" in {
      val result = service.getActivityDocument("activityId-111", "profileId-222")
      result must beNone
    }

    "throw 'ActivityProfileArgumentException' if given activity id is null" in {
      service.getActivityDocument(null, "profileId-111") must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given activity id is an empty string" in {
      service.getActivityDocument("", "profileId-111") must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given profile id is a null" in {
      service.getActivityDocument("activityId-111", null) must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given profile id is an empty string" in {
      service.getActivityDocument("activityId-111", "") must throwA[ActivityProfileLRSArgumentException]
    }

  }

  "The 'addActivityDocument' method" should {
    val document = Document("documentId-222", new DateTime(), "", OtherContent)

    "add new activity document" in {
      val newDocument = Document("documentId-222", new DateTime(), new String(Array[Byte](2)), OtherContent)
      service.addActivityDocument("activityId-333", "profileId-222", newDocument)
      InMemoryActivityProfileStorage.all.
        find(p => p.activityId == "activityId-333" && p.profileId == "profileId-222") must beSome
    }

    "throw [ActivityProfileLRSAlreadyExistsException] if one already exist for given activity and profile" in {
      val newDocument = Document("documentId-222", new DateTime(), new String(Array[Byte](1)), OtherContent)
      service.
        addActivityDocument("activityId-999", "profileId-666", newDocument) must throwA[ActivityProfileLRSAlreadyExistsException]
    }

    "throw 'ActivityProfileArgumentException' if given activity id is null" in {
      service.addActivityDocument(null, "profileId-111", document) must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given activity id is an empty string" in {
      service.addActivityDocument("", "profileId-111", document) must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given profile id is a null" in {
      service.addActivityDocument("activityId-111", null, document) must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given profile id is an empty string" in {
      service.addActivityDocument("activityId-111", "", document) must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given document is null" in {
      service.addActivityDocument("activityId-111", "profileId-222", null) must throwA[ActivityProfileLRSArgumentException]
    }

  }

  "The 'modifyActivityDocument' method" should {
    val document = Document("documentId-222", new DateTime(), new String(Array[Byte](9)), OtherContent)

    // "merge given document with the existing one" in pending

    "modify existing document content if both the existing document and the given one have binary content type" in {
      service.modifyActivityDocument("activityId-666", "profileId-666",
        Document("documentId-111", new DateTime(), "testing", OtherContent))
      val updated = InMemoryActivityProfileStorage.all.find(p => p.activityId == "activityId-666" && p.profileId == "profileId-666")
      updated must beSome
      updated.get.document.contents === "testing"
    }

    "throw 'ActivityProfileContentModificationException' if given document content's type is not json" in {
      InMemoryActivityProfileStorage.reset()
      service.modifyActivityDocument("activityId-999", "profileId-666", document) must
        throwA[ActivityProfileLRSContentModificationException]

    }

    "throw 'ActivityProfileContentModificationException' if its content's type is not json" in {
      InMemoryActivityProfileStorage.reset()
      service.modifyActivityDocument("activityId-666", "profileId-666", document.copy(cType = JSONContent)) must
        throwA[ActivityProfileLRSContentModificationException]
    }

    "throw 'ActivityProfileLRSNotExistsException' if given document doesn't even exist" in {
      service.modifyActivityDocument("activityId-111", "profileId-111", document) must throwA[ActivityProfileLRSNotExistsException]

    }

    "throw 'ActivityProfileArgumentException' if given activity id is null" in {
      service.modifyActivityDocument(null, "profileId-111", document) must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given activity id is an empty string" in {
      service.modifyActivityDocument("", "profileId-111", document) must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given profile id is a null" in {
      service.modifyActivityDocument("activityId-111", null, document) must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given profile id is an empty string" in {
      service.modifyActivityDocument("activityId-111", "", document) must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given document is null" in {
      service.modifyActivityDocument("activityId-111", "profileId-222", null) must throwA[ActivityProfileLRSArgumentException]
    }

  }

  "The 'deleteActivityDocument' method" should {

    "remove specified document by activity id and profile id" in {
      val document = Document("documentId-222", new DateTime(), "", OtherContent)
      service.addActivityDocument("activityId-1000", "profileId-0001", document)
      InMemoryActivityProfileStorage.all.
        find(p => p.activityId == "activityId-1000" && p.profileId == "profileId-0001") must beSome

      service.deleteActivityDocument("activityId-1000", "profileId-0001")

      InMemoryActivityProfileStorage.all.
        find(p => p.activityId == "activityId-1000" && p.profileId == "profileId-0001") must beNone
    }

    "not do any removing action if specified document doesn't even exist" in {
      service.deleteActivityDocument("activityId-444", "profileId-111")
      InMemoryActivityProfileStorage.all.find(p =>
        p.activityId == "activityId-444" &&
          p.profileId == "profileId-111") must beNone
    }

    "throw 'ActivityProfileArgumentException' if given activity id is null" in {
      service.deleteActivityDocument(null, "profileId-111") must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given activity id is an empty string" in {
      service.deleteActivityDocument("", "profileId-111") must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given profile id is a null" in {
      service.deleteActivityDocument("activityId-111", null) must throwA[ActivityProfileLRSArgumentException]
    }

    "throw 'ActivityProfileArgumentException' if given profile id is an empty string" in {
      service.deleteActivityDocument("activityId-111", "") must throwA[ActivityProfileLRSArgumentException]
    }

  }

}

object InMemoryActivityStorage extends TincanActivityStorage {
  private val activities = Seq(
    Activity(
      "Activity", "activityId-666",
      None, None, None, None, None,
      Set(), Seq(), Seq(), Seq(), Seq(), Seq(), None
    )
  )

  def getById(id: String): Option[Activity] = activities.find(_.id == id)

  def create(activity: Activity): Unit = throw new NotImplementedException

  def delete(id: String): Unit = throw new NotImplementedException

  def getById(id: Int): Option[Activity] = throw new NotImplementedException

  def delete(id: Int): Unit = throw new NotImplementedException

  def renew(): Unit = throw new NotImplementedException

  def createAndGetID(activity: Activity): Int = throw new NotImplementedException

  override def getByName(name: String): Seq[Activity] = ???
}

object InMemoryActivityProfileStorage extends ActivityProfileStorage {
  private val currentTime = System.currentTimeMillis()

  private val defaults = List(
    ActivityProfile(
      "activityId-999",
      "profileId-666",
      Document("documentId-111", new DateTime(currentTime - 20000l), "{x: 12\ny: 13}", JSONContent)),
    ActivityProfile(
      "activityId-666",
      "profileId-666",
      Document("documentId-111", new DateTime(currentTime - 15000l), "", OtherContent)),
    ActivityProfile(
      "activityId-666",
      "profileId-888",
      Document("documentId-111", new DateTime(currentTime - 10000l), "", OtherContent))
  )

  @volatile
  private[this] var documents = defaults
  private[this] val lock = new AnyRef

  def get(activityId: String, profileId: String): Option[ActivityProfile] =
    all.find(d => d.activityId == activityId && d.profileId == profileId)

  def getIds(activityId: String, since: Option[DateTime]): Seq[String] =
    all.filter(p => p.activityId == activityId &&
      (!since.isDefined || p.document.updated.getMillis >= since.get.getMillis)).map(_.profileId)

  def create(entity: ActivityProfile): Unit = lock.synchronized {
    documents = entity :: documents
  }

  def all = documents

  def delete(activityId: String, profileId: String): Unit = lock.synchronized {
    documents = all.filter(d => d.activityId != activityId && d.profileId != profileId)
  }

  def modify(entity: ActivityProfile): Unit = lock.synchronized {
    val filtered = all.filter(p => p.activityId != entity.activityId && p.profileId != entity.profileId)
    documents = entity :: filtered
  }

  def reset() = lock.synchronized {
    documents = defaults
  }

  def renew(): Unit = throw new NotImplementedException
}