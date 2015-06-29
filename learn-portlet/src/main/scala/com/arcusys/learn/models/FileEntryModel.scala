package com.arcusys.learn.models

case class FileEntryModel(
  id: Long,
  title: String,
  folderId: Long,
  version: String,
  mimeType: String,
  groupID: Long,
  uuid: String)
