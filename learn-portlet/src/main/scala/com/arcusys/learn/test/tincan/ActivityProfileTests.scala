package com.arcusys.learn.test.tincan

import java.io.PrintWriter

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.tincan.lrs.activityprofile.ActivityProfileLRS
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.tincan.storage.{ ActivityProfileStorage, DocumentStorage, TincanActivityStorage }
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class ActivityProfileTests(writer: PrintWriter) extends Injectable {
  override implicit def bindingModule: BindingModule = Configuration
  private val activityProfileLrs = new ActivityProfileLRS {
    val activityStorage: TincanActivityStorage = inject[TincanActivityStorage]
    val activityProfileStorage: ActivityProfileStorage = inject[ActivityProfileStorage]
  }

  private val tincanLrsDocumentStorage = inject[DocumentStorage]

  def renew() {
    activityProfileLrs.activityStorage.renew()
    activityProfileLrs.activityProfileStorage.renew()
    tincanLrsDocumentStorage.renew()
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
