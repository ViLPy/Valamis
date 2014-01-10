package com.arcusys.learn.tincan.storage.impl

import com.arcusys.learn.tincan.storage.AgentProfileStorage
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.tincan.model.{Agent, AgentProfile}
import java.util.Date

trait AgentProfileEntityStorage extends AgentProfileStorage with KeyedEntityStorage[AgentProfile] {
  def get(profileId: String, agent: Agent): Option[AgentProfile] = getOne("profileId" -> profileId, "agent" -> agent)

  def getIds(agent: Agent, since: Date): Seq[String] = getAll("agent" -> agent, "since" -> since).map(_.profileId)

  def create(entity: AgentProfile) {
    create(entity, Nil: _*)
  }

  def modify(entity: AgentProfile) {
    modify(entity, Nil: _*)
  }

  def delete(profileId: String, agent: Agent) {
    delete("profileId" -> profileId, "agent" -> agent)
  }
}
