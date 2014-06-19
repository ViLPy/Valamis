package com.arcusys.learn.tincan.storage.impl.liferay.mapper

import com.arcusys.learn.persistence.liferay.model.LFTincanActor
import com.arcusys.learn.persistence.liferay.service.LFTincanActorLocalServiceUtil
import com.arcusys.learn.tincan.model.{ Actor, Agent, Group }
import com.arcusys.util.JsonSerializer._

import scala.collection.JavaConverters._

object ActorMapper {
  def mapToAgent(entity: LFTincanActor) = Agent(
    entity.getObjectType,
    Option(entity.getName),
    Option(entity.getMbox),
    Option(entity.getMbox_sha1sum),
    Option(entity.getOpenid),
    Option(entity.getAccount).map(deserializeAccount),
    Option(entity.getId.toInt)
  )

  def map(entity: LFTincanActor): Actor = {
    entity.getObjectType.toLowerCase match {
      case "agent" => mapToAgent(entity)
      case "group" => {
        Group(
          entity.getObjectType,
          Option(entity.getName),
          Option(LFTincanActorLocalServiceUtil.findByMemberOf(entity.getTincanID).asScala
            .filter(_.getObjectType.equalsIgnoreCase("agent"))
            .map(e => mapToAgent(e))),
          Option(entity.getMbox),
          Option(entity.getMbox_sha1sum),
          Option(entity.getOpenid),
          Option(entity.getAccount).map(deserializeAccount),
          Option(entity.getId.toInt)
        )
      }
      //      case "person" => {
      //        Person(
      //          deserializeStringSeq(entity.getName),
      //          deserializeStringSeq(entity.getMbox),
      //          deserializeStringSeq(entity.getMbox_sha1sum),
      //          deserializeStringSeq(entity.getOpenid),
      //          deserializeAccounts(entity.getAccount)
      //        )
      //      }
      case objType => throw new UnsupportedOperationException("Unknown type " + objType + " in DB")
    }
  }
}
