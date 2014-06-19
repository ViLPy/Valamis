package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.tincan.model.{ Group, Context }
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext
import com.arcusys.learn.tincan.storage.{ ContextActivitiesStorage, ActorStorage }
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextLocalServiceUtil
import com.arcusys.util.JsonSerializer

trait LFTincanLrsContextStorageImpl extends KeyedEntityStorage[Context] {
  def actorStorage: ActorStorage

  def contextActivitiesStorage: ContextActivitiesStorage

  def mapper(entity: LFTincanLrsContext): Context = {
    val group = Option(entity.getTeamID).map(id => {
      actorStorage.getByID(id)
        .find(_.isInstanceOf[Group])
        .map(_.asInstanceOf[Group])
    }).getOrElse(None)

    val contextActivities = Option(entity.getContextActivitiesID).map(id => contextActivitiesStorage.getByID(id)).flatMap(o => o)

    Context(
      Option(entity.getRegistration).map(JsonSerializer.deserializeUUID),
      Option(entity.getInstructorID).map(id => actorStorage.getByID(id)).getOrElse(None),
      group,
      contextActivities,
      Option(entity.getRevision),
      Option(entity.getPlatform),
      Option(entity.getLanguage),
      Option(entity.getStatement).map(JsonSerializer.deserializeStatementReference),
      JsonSerializer.deserializeExtensions(entity.getExtensions)
    )
  }

  def renew() = {
    LFTincanLrsContextLocalServiceUtil.removeAll()
  }

  def createAndGetID(entity: Context, parameters: (String, Any)*): Int = {
    val lfEntity = LFTincanLrsContextLocalServiceUtil.createLFTincanLrsContext()

    entity.registration.foreach(reg => lfEntity.setRegistration(JsonSerializer.serializeUUID(reg)))
    entity.instructor.foreach(i => lfEntity.setInstructorID(actorStorage.createAndGetID(i)))
    entity.team.foreach(t => lfEntity.setTeamID(actorStorage.createAndGetID(t)))

    if (entity.contextActivities.isDefined) {
      val contextActID = entity.contextActivities.get.id.getOrElse(contextActivitiesStorage.createAndGetID(entity.contextActivities.get))
      lfEntity.setContextActivitiesID(contextActID)
    }
    entity.revision.foreach(lfEntity.setRevision)
    entity.platform.foreach(lfEntity.setPlatform)
    entity.language.foreach(lfEntity.setLanguage)
    entity.statement.foreach(statement => lfEntity.setStatement(JsonSerializer.serializeStatementReference(statement)))
    lfEntity.setExtensions(JsonSerializer.serializeExtensions(entity.extensions))

    LFTincanLrsContextLocalServiceUtil.addLFTincanLrsContext(lfEntity).getId.toInt
  }

  def getByID(id: Int, parameters: (String, Any)*): Option[Context] = {
    Option(LFTincanLrsContextLocalServiceUtil.getLFTincanLrsContext(id)).map(mapper)
  }

  def delete(parameters: (String, Any)*): Unit = parameters match {
    case Seq(("id", id: Int)) => {
      Option(LFTincanLrsContextLocalServiceUtil.getLFTincanLrsContext(id))
        .foreach(LFTincanLrsContextLocalServiceUtil.deleteLFTincanLrsContext)
    }
  }

  def getOne(parameters: (String, Any)*): Option[Context] = throw new UnsupportedOperationException()

  def getAll(parameters: (String, Any)*): Seq[Context] = throw new UnsupportedOperationException()

  def create(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def create(entity: Context, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def modify(entity: Context, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def execute(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[Context] = throw new UnsupportedOperationException()

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[Context] = throw new UnsupportedOperationException()

  def modify(sqlKey: String, parameters: (String, Any)*): Unit = throw new UnsupportedOperationException()

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException()
}
