package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.scorm.tracking.model.ActivityStateNode
import com.arcusys.learn.persistence.liferay.model.LFActivityStateNode
import com.arcusys.learn.scorm.tracking.states.storage.impl.ActivityStateNodeFieldsMapper
import com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalServiceUtil
import scala.collection.JavaConverters._

trait LFActivityStateNodeStorageImpl extends KeyedEntityStorage[ActivityStateNode] {
  protected def doRenew() { LFActivityStateNodeLocalServiceUtil.removeAll() }

  def extract(entity: LFActivityStateNode) = {
    val mapper = new ActivityStateNodeFieldsMapper {
      def id: Int = entity.getId.toInt

      def treeID: Int = entity.getTreeID

      def availableChildrenIDs: String = entity.getAvailableChildrenIDs
    }
    createActivityStateNode(mapper)
  }

  def createActivityStateNode(mapper: ActivityStateNodeFieldsMapper): ActivityStateNode

  def createAndGetID(entity: ActivityStateNode, parameters: (String, Any)*): Int = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

    val newEntity = LFActivityStateNodeLocalServiceUtil.createLFActivityStateNode()
    parameters.foreach {
      param =>
        param match {
          case ("treeID", value: Int) => newEntity.setTreeID(value)
          case ("parentID", value: Option[Int]) => {
            newEntity.setParentID(value)
          }
          case ("availableChildrenIDs", value: String) => newEntity.setAvailableChildrenIDs(value)
          case _                                       => {}
        }
    }
    LFActivityStateNodeLocalServiceUtil.addLFActivityStateNode(newEntity).getId.toInt
  }

  def getAll(parameters: (String, Any)*): Seq[ActivityStateNode] = parameters match {
    case Seq(("treeID", value: Int)) => {
      LFActivityStateNodeLocalServiceUtil.findByTreeID(value).asScala.sortBy(_.getId).map(extract)
    }
    case Seq(("treeID", treeID: Int), ("parentID", parentID: Int)) => {
      LFActivityStateNodeLocalServiceUtil.findByTreeIDAndParentID(treeID, parentID).asScala.sortBy(_.getId).map(extract)
    }
    case _ => Nil
  }

  def delete(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Must be implemented")
  }

  // unsupported

  def getOne(parameters: (String, Any)*): Option[ActivityStateNode] = throw new UnsupportedOperationException("Not implemented")

  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def create(entity: ActivityStateNode, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def modify(parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def modify(entity: ActivityStateNode, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def getByID(id: Int, parameters: (String, Any)*): Option[ActivityStateNode] = throw new UnsupportedOperationException("Not implemented")

  def createAndGetID(parameters: (String, Any)*): Int = throw new UnsupportedOperationException("Not implemented")

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException("Not implemented")
  }

  def getAll(sqlKey: String, parameters: (String, Any)*): Seq[ActivityStateNode] = throw new UnsupportedOperationException("Not implemented")

  def getOne(sqlKey: String, parameters: (String, Any)*): Option[ActivityStateNode] = throw new UnsupportedOperationException("Not implemented")

  def modify(sqlKey: String, parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
}
