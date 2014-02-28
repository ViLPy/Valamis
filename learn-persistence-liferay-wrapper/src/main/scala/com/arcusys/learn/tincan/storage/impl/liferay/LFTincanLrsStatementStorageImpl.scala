package com.arcusys.learn.tincan.storage.impl.liferay

import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement
import com.arcusys.learn.util.JsonSerializer
import com.arcusys.learn.tincan.storage._
import com.arcusys.learn.tincan.model.Statement
import com.arcusys.learn.tincan.model.Group
import com.arcusys.learn.tincan.model.Agent
import com.arcusys.learn.tincan.model.Verb
import scala.collection.JavaConverters._
import java.util.UUID
import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException
import org.joda.time.DateTime

trait LFTincanLrsStatementStorageImpl extends EntityStorage[Statement] {
  def actorStorage: ActorStorage//LFActorStorageImpl

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
      case act: Activity => tincanActivityStorage.createAndGetID(act)
      case agent: Agent => actorStorage.createAndGetID(agent)
      case group: Group => actorStorage.createAndGetID(group)
      case subs: SubStatement => tincanSubStatementStorage.createAndGetID(subs)
      case ref: StatementReference => tincanStatementRefStorage.createAndGetID(ref)
      case _ => throw new IllegalArgumentException("Unknown type of object " + obj + " with type " + obj.objectType)
    }
  }

  def mapper(entity: LFTincanLrsStatement): Statement = {
    val statementObj: Option[StatementObject] = StatementObjectType.withName(entity.getObjType) match {
      case StatementObjectType.Activity => tincanActivityStorage.getById(entity.getObjID)
      case StatementObjectType.Agent => actorStorage.getByID(entity.getObjID).map(_.asInstanceOf[Agent])
      case StatementObjectType.Group => actorStorage.getByID(entity.getObjID).map(_.asInstanceOf[Group])
      case StatementObjectType.SubStatement => tincanSubStatementStorage.getByID(entity.getObjID)
      case StatementObjectType.StatementReference => tincanStatementRefStorage.getByID(entity.getObjID)
      case _ => None
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
    var result = LFTincanLrsStatementLocalServiceUtil.getLFTincanLrsStatements(-1, -1).asScala.map(mapper)

    def isVoided(s: Statement) = {
      result.filter(st => st.verb.id == "http://adlnet.gov/expapi/verbs/voided"
        && st.obj.objectType == "StatementRef")
        .map(s => s.obj.asInstanceOf[StatementReference].id)
        .find(_ == s.id).isDefined
    }

    for (statementId <- parameters.find(_._1.equalsIgnoreCase("voidedStatementId"))) {
      result = result.filter(s => isVoided(s) && s.id.toString.equalsIgnoreCase(statementId._2.toString))
      return result
    }

    result = result.filter(s => !isVoided(s))

    for (statementId <- parameters.find(_._1.equalsIgnoreCase("statementId"))) {
      result = result.filter(s => s.id.toString.equalsIgnoreCase(statementId._2.toString))
      return result
    }

    var related_activities: Boolean = false
    var related_agents: Boolean = false

    for (ra <- parameters.find(_._1.equalsIgnoreCase("related_activities"))) {
      related_activities = ra._2.asInstanceOf[Boolean]
    }

    for (ra <- parameters.find(_._1.equalsIgnoreCase("related_agents"))) {
      related_agents = ra._2.asInstanceOf[Boolean]
    }

    for (activityId <- parameters.find(_._1.equalsIgnoreCase("activity"))) {
      result = result.filter(s => {
        var res = s.obj.objectType == StatementObjectType.Activity.toString && s.obj.asInstanceOf[Activity].id == activityId._2
        if (related_activities && s.obj.objectType == StatementObjectType.SubStatement.toString) {
          val subobj = s.obj.asInstanceOf[SubStatement].obj
          res |= subobj.objectType == StatementObjectType.Activity.toString && subobj.asInstanceOf[Activity].id == activityId._2
        }
        res
      })
      //      val activityIDInt = tincanActivityStorage.getById(activityId._2.toString()).map(_.storedId).flatten.headOption
      //      if (activityIDInt.isDefined) {
      //        result = result.filter(s => s.obj.objectType == StatementObjectType.Activity.toString && s.obj.storedId == activityIDInt)
      //      }
    }

    for (agent <- parameters.find(_._1.equalsIgnoreCase("agent"))) {
      agent._2 match {
        case agent: Agent => result = result.filter(s => {
          var res = s.actor.isInstanceOf[Agent] && s.actor.asInstanceOf[Agent].FilterCompareExact(agent)
          if (related_agents) {
            res |= s.obj.objectType.equalsIgnoreCase("Agent") && s.obj.asInstanceOf[Agent].FilterCompareExact(agent)
            res |= s.authority.isDefined && s.authority.get.objectType.equalsIgnoreCase("Agent") && s.authority.get.asInstanceOf[Agent].FilterCompareExact(agent)
            if (s.context.isDefined && s.context.get.instructor.isDefined) {
              val instructor = s.context.get.instructor.get
              res |= instructor.objectType.equalsIgnoreCase("Agent") && instructor.asInstanceOf[Agent].FilterCompareExact(agent)
            }
            if (s.context.isDefined && s.context.get.team.isDefined) {
              val team = s.context.get.team.get
              for (member <- team.member)
                res |= member.isInstanceOf[Agent] && member.asInstanceOf[Agent].FilterCompareExact(agent)
            }
          }
          res
        })
        case _ => Nil
      }
    }

    for (verb <- parameters.find(_._1 == "verb")) yield
      verb._2 match {
        //case v: Verb => result = result.filter(_.verb.id == v.id)
        //case (key: String, id: String) => result = result.filter(_.verb.id == id)
        case id: String => result = result.filter(s => s.verb.id == id)
        case _ => Nil
      }


    for (since <- parameters.find(_._1.equalsIgnoreCase("since"))) {
      result = result.filter(r => r.timestamp.isDefined && r.timestamp.get.after(new DateTime(since._2).toDate))
    }
    for (until <- parameters.find(_._1.equalsIgnoreCase("until"))) {
      result = result.filter(r => r.timestamp.isDefined && r.timestamp.get.before(new DateTime(until._2).toDate) || r.timestamp.equals(new DateTime(until._2).toDate))
    }


    for (reg <- parameters.find(_._1.equalsIgnoreCase("registration"))) {
      result = result.filter(r => r.context.isDefined && r.context.get.registration.isDefined && r.context.get.registration.get.equals(reg._2))
    }




    // not involve to get data
    //    for (ra <- parameters.find(_._1.equalsIgnoreCase("format"))) {
    //      //result = result.filter(r => r.context.isDefined && r.context.get.registration.get.equals(reg._2))
    //    }
    //
    //    for (ra <- parameters.find(_._1.equalsIgnoreCase("attachments"))) {
    //      result = result.filter(r => r.context.isDefined && r.context.get.registration.get.equals(reg._2))
    //    }

    for (ra <- parameters.find(_._1.equalsIgnoreCase("ascending"))) {
      if (ra._2.asInstanceOf[Boolean])
        result = result.sortBy(r => r.stored)
    }

    for (ra <- parameters.find(_._1.equalsIgnoreCase("limit"))) {
      val limit = ra._2.asInstanceOf[Int]
      if (limit > 0)
        result = result.take(limit)
    }

    result
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
}
