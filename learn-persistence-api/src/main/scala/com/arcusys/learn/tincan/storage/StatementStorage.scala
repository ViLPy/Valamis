package com.arcusys.learn.tincan.storage

import java.util.UUID

import com.arcusys.learn.tincan.model.Statement

trait StatementStorage {
  def getByUUID(id: UUID): Option[Statement]
  def get(parameters: (String, Any)*): Seq[Statement]
  def create(entity: Statement): UUID
  def renew()
}
