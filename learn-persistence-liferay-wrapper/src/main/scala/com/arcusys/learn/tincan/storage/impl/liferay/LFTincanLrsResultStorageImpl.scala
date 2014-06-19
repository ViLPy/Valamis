package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.tincan.model.Result
import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsResultLocalServiceUtil
import com.arcusys.util.JsonSerializer

trait LFTincanLrsResultStorageImpl extends KeyedEntityStorage[Result] {
  def mapper(entity: LFTincanLrsResult): Result = {
    Result(
      Option(entity.getScore).map(JsonSerializer.deserializeScore),
      if (entity.getSuccess == null) None else Option(entity.getSuccess),
      if (entity.getCompletion == null) None else Option(entity.getCompletion),
      Option(entity.getResponse),
      if (entity.getDuration == null) None else Option(entity.getDuration),
      JsonSerializer.deserializeExtensions(entity.getExtension)
    )
  }

  def renew() = {
    LFTincanLrsResultLocalServiceUtil.removeAll()
  }

  def createAndGetID(entity: Result, parameters: (String, Any)*): Int = {
    val lfEntity = LFTincanLrsResultLocalServiceUtil.createLFTincanLrsResult()

    entity.score.foreach(score => lfEntity.setScore(JsonSerializer.serializeScore(score)))
    entity.success.foreach(flag => lfEntity.setSuccess(flag))
    entity.completion.foreach(flag => lfEntity.setCompletion(flag))
    entity.response.foreach(lfEntity.setResponse)
    entity.duration.foreach(duration => lfEntity.setDuration(duration))
    lfEntity.setExtension(JsonSerializer.serializeExtensions(entity.extensions))

    LFTincanLrsResultLocalServiceUtil.addLFTincanLrsResult(lfEntity).getId.toInt
  }

  def getByID(id: Int, parameters: (String, Any)*): Option[Result] = {
    Option(LFTincanLrsResultLocalServiceUtil.getLFTincanLrsResult(id)).map(mapper)
  }

  def delete(parameters: (String, Any)*): Unit = parameters match {
    case Seq(("id", id: Int)) => {
      Option(LFTincanLrsResultLocalServiceUtil.getLFTincanLrsResult(id))
        .map(LFTincanLrsResultLocalServiceUtil.deleteLFTincanLrsResult)
    }
  }

  def getOne(parameters: (String, Any)*): Option[Result] = throw new UnsupportedOperationException()

  def getAll(parameters: (String, Any)*): Seq[Result] = throw new UnsupportedOperationException()

  def create(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def create(entity: Result, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(entity: Result, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def execute(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[Result] = throw new UnsupportedOperationException()

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[Result] = throw new UnsupportedOperationException()

  def modify(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException()
}
