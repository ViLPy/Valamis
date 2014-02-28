package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.tincan.model.{Agent, State}
import java.util.{Date, UUID}
import com.arcusys.learn.tincan.storage.StateStorage
import com.arcusys.learn.storage.impl.{EntityStorageExt, EntityStorage}

trait StateEntityStorage extends StateStorage with EntityStorage[State] with EntityStorageExt[State] {
  def get(activityId: String, stateId: String, agent: Agent, registration: Option[UUID]): Option[State] = {
    getOne("activityId" -> activityId, "stateId" -> stateId, "agent" -> agent, "registration" -> registration)
  }

  def getIds(activityId: String, agent: Agent, registration: Option[UUID], since: Option[Date]): Seq[String] = {
    getAll("activityId" -> activityId, "agent" -> agent, "registration" -> registration, "since" -> since).map(_.stateId)
  }

  def delete(activityId: String, stateId: String, agent: Agent, registration: Option[UUID]): Unit = {
    delete("activityId" -> activityId, "stateId" -> stateId, "agent" -> agent, "registration" -> registration)
  }

  def delete(activityId: String, agent: Agent, registration: Option[UUID]): Unit = {
    delete("activityId" -> activityId, "agent" -> agent, "registration" -> registration)
  }
}