package com.arcusys.learn.facades

import java.io.ByteArrayOutputStream

abstract trait TranscriptPrintFacadeContract {
  def printTranscript(companyID: Int, userID: Int, templatesPath: String): ByteArrayOutputStream
}