package com.arcusys.learn.test.tincan

import java.io.PrintWriter
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.tincan.storage.{ ActivityProfileStorage, TincanActivityStorage }
import com.arcusys.learn.tincan.lrs.activityprofile.ActivityProfileLRS

class ActivityProfileTests(writer: PrintWriter, storageFactory: StorageFactoryContract) {

  private val activityProfileLrs = new ActivityProfileLRS {
    val activityStorage: TincanActivityStorage = storageFactory.tincanLrsActivityStorage
    val activityProfileStorage: ActivityProfileStorage = storageFactory.tincanLrsActivityProfileStorage
  }

  def renew() {
    storageFactory.tincanLrsActivityStorage.renew()
    storageFactory.tincanLrsActivityProfileStorage.renew()
    storageFactory.tincanLrsDocumentStorage.renew()
  }

  def createAndReadTest() {
    renew()
    val profileId = "zdxfaf"
    val activityId = "adfsgsdfg"
    val document = Document("the content", JSONContent)

    activityProfileLrs.addActivityDocument(activityId, profileId, document)
    val actualDocument = activityProfileLrs.getActivityDocument(activityId, profileId)

    if (document != actualDocument.getOrElse(throw new IllegalArgumentException("Document not found"))) {
      throw new Exception("Different document")
    }
    writer.write("activity profile document, createAndRead SUCCESS <br>")
  }
}
