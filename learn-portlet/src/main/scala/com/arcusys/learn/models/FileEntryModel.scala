package com.arcusys.learn.models

case class FileEntryModel(
  id: Long,
  title: String,
  version: String,
  mimeType: String,
  groupID: Long,
  uuid: String)
