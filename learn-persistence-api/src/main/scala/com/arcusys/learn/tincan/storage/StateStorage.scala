package com.arcusys.learn.tincan.storage

import java.util.{Date, UUID}

import com.arcusys.learn.tincan.model.{State, Agent}


trait StateStorage {
  def get(activityId: String, stateId: String, agent: Agent, registration: Option[UUID]): Option[State]
  def getIds(activityId:String, agent: Agent, registration: Option[UUID], since: Date): Seq[String]
  def create(state: State)
  def modify(state: State)
  def delete(activityId: String, stateId: String, agent: Agent, registration: Option[UUID])
  def delete(activityId: String, agent: Agent, registration: Option[UUID])

  def renew()
}
