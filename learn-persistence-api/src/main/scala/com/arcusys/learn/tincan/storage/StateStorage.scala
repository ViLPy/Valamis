package com.arcusys.learn.tincan.storage

import com.arcusys.learn.tincan.model.{ State, Agent }

import org.joda.time.DateTime
import java.util.UUID

trait StateStorage {
  def get(activityId: String, stateId: String, agent: Agent, registration: Option[UUID]): Option[State]
  def getIds(activityId: String, agent: Agent, registration: Option[UUID], since: Option[DateTime]): Seq[String]
  def create(state: State)
  def modify(state: State)
  def delete(activityId: String, stateId: String, agent: Agent, registration: Option[UUID])
  def delete(activityId: String, agent: Agent, registration: Option[UUID])

  def renew()
}
