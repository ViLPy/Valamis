package com.arcusys.learn.facades

import java.io.ByteArrayOutputStream

import com.arcusys.valamis.lrs.api.StatementApi

trait TranscriptPrintFacadeContract {
  def printTranscript(statementApi: StatementApi, companyID: Int, userID: Int, templatesPath: String): ByteArrayOutputStream
}