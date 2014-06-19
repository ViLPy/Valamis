package com.arcusys.learn.tincan.storage.impl.liferay

import java.util
import java.util.{ Date, UUID }

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException
import com.arcusys.learn.persistence.liferay.model._
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalServiceUtil
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.tincan.storage._
import com.arcusys.util.JsonSerializer
import com.liferay.portal.kernel.dao.orm._

trait LFTincanLrsStatementStorageImpl extends EntityStorage[Statement] {
  def actorStorage: ActorStorage //LFActorStorageImpl

  def tincanActivityStorage: TincanActivityStorage

  def resultStorage: TincanResultStorage

  def tincanStatementRefStorage: StatementRefStorage

  def tincanSubStatementStorage: SubStatementStorage

  def contextStorage: ContextStorage

  def attachmentStorage: AttachmentStorage

  def renew() = {
    LFTincanLrsStatementLocalServiceUtil.removeAll()
  }

  private def createStatementObjectAndGetID(obj: StatementObject): Int = {
    obj match {
      case act: Activity           => tincanActivityStorage.createAndGetID(act)
      case agent: Agent            => actorStorage.createAndGetID(agent)
      case group: Group            => actorStorage.createAndGetID(group)
      case subs: SubStatement      => tincanSubStatementStorage.createAndGetID(subs)
      case ref: StatementReference => tincanStatementRefStorage.createAndGetID(ref)
      case _                       => throw new IllegalArgumentException("Unknown type of object " + obj + " with type " + obj.objectType)
    }
  }

  def mapper(entity: LFTincanLrsStatement): Statement = {
    val statementObj: Option[StatementObject] = StatementObjectType.withName(entity.getObjType) match {
      case StatementObjectType.Activity           => tincanActivityStorage.getById(entity.getObjID)
      case StatementObjectType.Agent              => actorStorage.getByID(entity.getObjID).map(_.asInstanceOf[Agent])
      case StatementObjectType.Group              => actorStorage.getByID(entity.getObjID).map(_.asInstanceOf[Group])
      case StatementObjectType.SubStatement       => tincanSubStatementStorage.getByID(entity.getObjID)
      case StatementObjectType.StatementReference => tincanStatementRefStorage.getByID(entity.getObjID)
      case _                                      => None
    }

    Statement(
      JsonSerializer.deserializeUUID(entity.getTincanID),
      actorStorage.getByID(entity.getActorID).getOrElse(throw new IllegalArgumentException()),
      Verb(entity.getVerbID, JsonSerializer.deserializeLanguageMap(entity.getVerbDisplay)),
      statementObj.getOrElse(throw new IllegalArgumentException()),
      Option(entity.getResultID).map(id => resultStorage.getByID(id)).getOrElse(None),
      Option(entity.getContextID).map(id => contextStorage.getByID(id)).getOrElse(None),
      Option(entity.getTimestamp),
      Option(entity.getStored),
      Option(entity.getAuthorityID).map(id => actorStorage.getByID(id)).getOrElse(None),
      Option(entity.getVersion),
      attachmentStorage.getByParent(entity.getId.toInt)
    )
  }

  def getAll(parameters: (String, Any)*): Seq[Statement] = {

    val statementId = parameters.find(_._1.equalsIgnoreCase("statementId")).map(_._2.toString)
    val voidedStatementId = parameters.find(_._1.equalsIgnoreCase("voidedStatementId")).map(_._2.toString)
    val related_activities = parameters.find(_._1.equalsIgnoreCase("related_activities")).map(_._2.asInstanceOf[Boolean])
    val related_agents = parameters.find(_._1.equalsIgnoreCase("related_agents")).map(_._2.asInstanceOf[Boolean])
    val verbId = parameters.find(_._1.equalsIgnoreCase("verb")).map(_._2.toString)
    val activityId = parameters.find(_._1.equalsIgnoreCase("activity"))
      .map(a => a._2.toString) // match {
    //        case activity: String => {
    //          val act = tincanActivityStorage.getById(activity)
    //          if (act.isDefined)
    //            act.get.storedId.get
    //          else
    //            -1
    //        }
    //        case _ => -1
    //      })
    val agentId = parameters.find(_._1.equalsIgnoreCase("agent"))
      .map(a => a._2 match {
        case agent: Agent => {
          val actor = actorStorage.getByIFI(agent.objectType, agent.mbox, agent.mbox_sha1sum, agent.openid, agent.account)
          if (actor.isDefined)
            actor.get.getStoredId.get
          else
            -1
        }
        case _ => -1
      })
    val since = parameters.find(_._1.equalsIgnoreCase("since")).map(_._2.asInstanceOf[Date])
    val until = parameters.find(_._1.equalsIgnoreCase("until")).map(_._2.asInstanceOf[Date])

    val registration = parameters.find(_._1.equalsIgnoreCase("registration")).map(r => r._2 match {
      case uuid: UUID => JsonSerializer.serializeUUID(uuid)
      case _          => null
    })
    val ascending = parameters.find(_._1.equalsIgnoreCase("ascending")).map(_._2.asInstanceOf[Boolean])
    val limit = parameters.find(_._1.equalsIgnoreCase("limit")).map(_._2.asInstanceOf[Int])

    val result = findBy(
      if (statementId.isDefined) "\"" + statementId.get + "\"" else null, //did it because in db field filed value as "uuid" (in quotes)
      if (voidedStatementId.isDefined) "\"" + voidedStatementId.get + "\"" else null,
      if (agentId.isDefined) agentId.get else null,
      verbId.getOrElse(null),
      if (activityId.isDefined) activityId.get else null,
      registration.getOrElse(null),
      since.getOrElse(null),
      until.getOrElse(null),
      if (related_activities.isDefined) related_activities.get else false,
      if (related_agents.isDefined) related_agents.get else false,
      if (ascending.isDefined) ascending.get else false,
      if (limit.isDefined) limit.get else 0
    )
    val res = result.toArray().map(st => mapper(st.asInstanceOf[LFTincanLrsStatement])).toSeq

    //val res = for (st <- result.toArray()) yield mapper(st.asInstanceOf[LFTincanLrsStatement])
    res
  }

  def create(entity: Statement, parameters: (String, Any)*): Unit = {
    val lfEntity = LFTincanLrsStatementLocalServiceUtil.createLFTincanLrsStatement()

    lfEntity.setTincanID(JsonSerializer.serializeUUID(entity.id))

    lfEntity.setActorID(actorStorage.createAndGetID(entity.actor))

    lfEntity.setVerbID(entity.verb.id)
    lfEntity.setVerbDisplay(JsonSerializer.serializeLanguageMap(entity.verb.display))
    lfEntity.setObjType(entity.obj.objectType)
    lfEntity.setObjID(createStatementObjectAndGetID(entity.obj))

    entity.result.foreach(r => lfEntity.setResultID(resultStorage.createAndGetID(r)))
    entity.context.foreach(c => lfEntity.setContextID(contextStorage.createAndGetID(c)))

    entity.stored.foreach(lfEntity.setStored)
    entity.timestamp.foreach(lfEntity.setTimestamp)

    entity.authority.foreach(a => lfEntity.setAuthorityID(actorStorage.createAndGetID(a)))
    entity.version.foreach(lfEntity.setVersion)

    entity.attachments.foreach(attachmentStorage.create(_, lfEntity.getId.toInt))

    LFTincanLrsStatementLocalServiceUtil.addLFTincanLrsStatement(lfEntity)
  }

  def getOne(parameters: (String, Any)*): Option[Statement] = parameters match {
    case Seq(("uuid", uuid: UUID)) => {
      try {
        Option(LFTincanLrsStatementLocalServiceUtil.findByTincanID(JsonSerializer.serializeUUID(uuid))).map(mapper)
      } catch {
        case e: NoSuchLFTincanLrsStatementException => None
      }
    }
    case _ => None
  }

  def create(parameters: (String, Any)*): Unit = ()

  def delete(parameters: (String, Any)*): Unit = ()

  def modify(parameters: (String, Any)*): Unit = ()

  def modify(entity: Statement, parameters: (String, Any)*): Unit = ()

  def execute(sqlKey: String, parameters: (String, Any)*): Unit = ()

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[Statement] = null

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[Statement] = null

  def modify(sqlKey: String, parameters: (String, Any)*): Unit = ()

  private def findBy(statementID: String,
    voidedStatementID: String,
    actorID: Integer,
    verbID: String,
    activity: String,
    registration: String,
    since: Date,
    until: Date,
    related_activities: Boolean,
    related_agents: Boolean,
    ascending: Boolean,
    limit: Integer): util.List[_] = {
    val childQuery: DynamicQuery = DynamicQueryFactoryUtil.forClass(classOf[LFTincanLrsStatement], "voidedStatement")
      .setProjection(ProjectionFactoryUtil.property("voidedStatement.objID"))
      .add(PropertyFactoryUtil.forName("voidedStatement.verbID").like("http://adlnet.gov/expapi/verbs/voided"))
      .add(PropertyFactoryUtil.forName("voidedStatement.objType").like("StatementRef"))
    val strefQuery: DynamicQuery = DynamicQueryFactoryUtil.forClass(classOf[LFTincanLrsStatementRef], "statementRef")
      .setProjection(ProjectionFactoryUtil.property("statementRef.uuid"))
      .add(PropertyFactoryUtil.forName("statementRef.id").in(childQuery))
    if (voidedStatementID != null) {
      val voidedQuery: DynamicQuery = DynamicQueryFactoryUtil.forClass(classOf[LFTincanLrsStatement], "statement")
        .add(PropertyFactoryUtil.forName("statement.tincanID").in(strefQuery))
        .add(PropertyFactoryUtil.forName("statement.tincanID").like(voidedStatementID))
      val requestList: util.List[_] = LFTincanLrsStatementLocalServiceUtil.dynamicQuery(voidedQuery)
      return requestList
    }
    if (statementID != null) {
      val statementQuery: DynamicQuery = DynamicQueryFactoryUtil.forClass(classOf[LFTincanLrsStatement], "statement")
        .add(PropertyFactoryUtil.forName("statement.tincanID").notIn(strefQuery))
        .add(PropertyFactoryUtil.forName("statement.tincanID").like(statementID))
      val requestList: util.List[_] = LFTincanLrsStatementLocalServiceUtil.dynamicQuery(statementQuery)
      return requestList
    }
    val statementQuery: DynamicQuery = DynamicQueryFactoryUtil.forClass(classOf[LFTincanLrsStatement], "statement")
      .add(PropertyFactoryUtil.forName("statement.tincanID").notIn(strefQuery))
    if (actorID != null) {
      val disjunction: Disjunction = RestrictionsFactoryUtil.disjunction
      val criterion: Criterion = RestrictionsFactoryUtil.eq("statement.actorID", actorID)
      disjunction.add(criterion)
      if (related_agents) {
        val objcriterion: Criterion = RestrictionsFactoryUtil.or(
          RestrictionsFactoryUtil.eq("statement.objType", "Agent"), RestrictionsFactoryUtil.eq("statement.objType", "Group"))
        disjunction.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("statement.objID", actorID), objcriterion))
        disjunction.add(RestrictionsFactoryUtil.eq("statement.authorityID", actorID))
        val substmQuery: DynamicQuery = DynamicQueryFactoryUtil.forClass(classOf[LFTincanLrsSubStatement], "subStatement")
          .setProjection(ProjectionFactoryUtil.property("subStatement.id"))
          .add(PropertyFactoryUtil.forName("subStatement.actorID").like(actorID))
        disjunction.add(
          RestrictionsFactoryUtil.conjunction.add(PropertyFactoryUtil.forName("statement.objID").in(substmQuery))
            .add(PropertyFactoryUtil.forName("statement.objType").like("SubStatement"))
        )
        val contextQuery: DynamicQuery = DynamicQueryFactoryUtil.forClass(classOf[LFTincanLrsContext], "context")
          .setProjection(ProjectionFactoryUtil.property("context.id"))
        val subcriterion: Criterion = RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("context.instructorID", actorID),
          RestrictionsFactoryUtil.eq("context.teamID", actorID))
        contextQuery.add(subcriterion)
        disjunction.add(PropertyFactoryUtil.forName("statement.contextID").in(contextQuery))
      }
      statementQuery.add(disjunction)
    }
    if (verbID != null) statementQuery.add(PropertyFactoryUtil.forName("statement.verbID").like(verbID))
    if (activity != null) {
      val disjunction: Disjunction = RestrictionsFactoryUtil.disjunction
      val activityQuery: DynamicQuery = DynamicQueryFactoryUtil.forClass(classOf[LFTincanActivity], "activity")
        .setProjection(ProjectionFactoryUtil.property("activity.id"))
        .add(PropertyFactoryUtil.forName("activity.tincanID").like(activity))
      disjunction.add(
        RestrictionsFactoryUtil.conjunction.add(PropertyFactoryUtil.forName("statement.objID").in(activityQuery))
          .add(PropertyFactoryUtil.forName("statement.objType").like("Activity"))
      )

      if (related_activities) {
        val substmQuery: DynamicQuery = DynamicQueryFactoryUtil.forClass(classOf[LFTincanLrsSubStatement], "subStatement")
          .setProjection(ProjectionFactoryUtil.property("subStatement.id"))
          .add(PropertyFactoryUtil.forName("subStatement.objType").like("Activity"))
          .add(PropertyFactoryUtil.forName("subStatement.objID").in(activityQuery))
        disjunction.add(
          RestrictionsFactoryUtil.conjunction.add(PropertyFactoryUtil.forName("statement.objID").in(substmQuery))
            .add(PropertyFactoryUtil.forName("statement.objType").like("SubStatement"))
        )
        val contextActivitiesQuery: DynamicQuery = DynamicQueryFactoryUtil.forClass(classOf[LFTincanCtxActivities], "contextActivities")
          .setProjection(ProjectionFactoryUtil.property("contextActivities.id"))
        val ctxActDisjunction: Disjunction = RestrictionsFactoryUtil.disjunction
        ctxActDisjunction.add(PropertyFactoryUtil.forName("contextActivities.parent").like("%\"" + activity + "\"%"))
        ctxActDisjunction.add(PropertyFactoryUtil.forName("contextActivities.grouping").like("%\"" + activity + "\"%"))
        ctxActDisjunction.add(PropertyFactoryUtil.forName("contextActivities.category").like("%\"" + activity + "\"%"))
        ctxActDisjunction.add(PropertyFactoryUtil.forName("contextActivities.other").like("%\"" + activity + "\"%"))
        contextActivitiesQuery.add(ctxActDisjunction)
        val contextQuery: DynamicQuery = DynamicQueryFactoryUtil.forClass(classOf[LFTincanLrsContext], "context")
          .setProjection(ProjectionFactoryUtil.property("context.id"))
          .add(PropertyFactoryUtil.forName("context.contextActivitiesID").in(contextActivitiesQuery))
        disjunction.add(PropertyFactoryUtil.forName("statement.contextID").in(contextQuery))
      }
      statementQuery.add(disjunction)

    }
    if (registration != null) {
      val contextQuery: DynamicQuery = DynamicQueryFactoryUtil.forClass(classOf[LFTincanLrsContext], "context")
        .setProjection(ProjectionFactoryUtil.property("context.id"))
        .add(PropertyFactoryUtil.forName("context.registration").like(registration))
      statementQuery.add(PropertyFactoryUtil.forName("statement.contextID").in(contextQuery))
    }
    if (since != null) statementQuery.add(PropertyFactoryUtil.forName("statement.timestamp").ge(since))
    if (until != null) statementQuery.add(PropertyFactoryUtil.forName("statement.timestamp").le(until))

    if (ascending)
      statementQuery.addOrder(OrderFactoryUtil.asc("statement.stored"))
    else
      statementQuery.addOrder(OrderFactoryUtil.desc("statement.stored"))

    if (limit != null && limit != 0) {
      statementQuery.setLimit(0, limit)
    }
    val requestList = LFTincanLrsStatementLocalServiceUtil.dynamicQuery(statementQuery)
    return requestList
  }
}
