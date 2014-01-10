package com.arcusys.learn.tincan.model

import java.util.UUID

case class State(
  activityId: String,
  stateId: String,
  agent: Agent,
  registration: Option[UUID],
  content: Document,
  id: Option[Int] = None)