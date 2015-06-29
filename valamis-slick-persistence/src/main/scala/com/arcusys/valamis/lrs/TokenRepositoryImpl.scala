package com.arcusys.valamis.lrs

import javax.inject.Inject

import com.arcusys.valamis.lrsEndpoint.model.LrsToken
import com.arcusys.valamis.lrsEndpoint.storage.LrsTokenStorage
import scala.slick.driver.JdbcProfile
import scala.slick.jdbc.JdbcBackend

class TokenRepositoryImpl @Inject() (val db:     JdbcBackend#DatabaseDef,
                                     val driver: JdbcProfile)
  extends LrsTokenStorage
  with TokenTableComponent {

  import driver.simple._

  def get(token: String): Option[LrsToken] = {
    db.withSession { implicit s =>
      tokens.filter(t => t.token === token).firstOption
    }
  }

  def set(token: LrsToken): Unit = {
    db.withSession { implicit s =>
      tokens.insert(token)
    }
  }

  def delete(token: String): Unit = {
    db.withSession { implicit s =>
      tokens.filter(t => t.token === token).delete
    }
  }

  override def renew(): Unit = {
    db.withSession { implicit s =>
      tokens.delete
    }
  }

}
