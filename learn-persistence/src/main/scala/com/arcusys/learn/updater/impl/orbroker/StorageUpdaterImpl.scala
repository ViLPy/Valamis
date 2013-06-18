package com.arcusys.learn.updater.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.BrokerFactory._
import org.orbroker.Token
import com.arcusys.learn.updater.StorageUpdater

class StorageUpdaterImpl extends StorageUpdater {
  val tablePath = "Updater"

  def updateTo1_2() {
    execute("_1_2")
  }

  private def prepareParameters(parameters: Seq[(String, Any)]) = for {
    (key, value) <- parameters
    if (value != None)
  } yield key -> (value match {
      case Some(v) => v
      case _ => value
    })

  private def execute(action: String, parameters: (String, Any)*) {
    broker.transactional() {
      session =>
        session.execute(Token(Symbol(tablePath + action)), prepareParameters(parameters): _*)
        session.commit()
    }
  }
}
