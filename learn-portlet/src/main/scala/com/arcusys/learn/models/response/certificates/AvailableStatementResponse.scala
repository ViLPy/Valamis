package com.arcusys.learn.models.response.certificates

case class AvailableStatementResponse(
  verb: String,
  verbName: Map[String, String],
  obj: String,
  objName: Map[String, String])
