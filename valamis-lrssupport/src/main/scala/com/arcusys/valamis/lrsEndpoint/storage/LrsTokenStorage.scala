package com.arcusys.valamis.lrsEndpoint.storage

import com.arcusys.valamis.lrsEndpoint.model.LrsToken

trait LrsTokenStorage {
  def get(token: String): Option[LrsToken]
  def delete(token: String): Unit
  def set(token: LrsToken): Unit
  def renew()
}
