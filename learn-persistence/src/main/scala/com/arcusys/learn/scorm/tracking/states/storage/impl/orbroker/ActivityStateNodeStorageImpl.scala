package com.arcusys.learn.scorm.tracking.states.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageBaseImpl
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.tracking.model.ActivityStateNode
import com.arcusys.learn.scorm.tracking.states.storage.impl.{ActivityStateNodeCreator, ActivityStateNodeFieldsMapper, ActivityStateNodeEntityStorage}

class ActivityStateNodeStorageImpl extends KeyedEntityStorageBaseImpl[ActivityStateNode]("ActivityStateNode", "id") with ActivityStateNodeEntityStorage with ActivityStateNodeExtractor with ActivityStateNodeCreator {
  val activityStateStorage = new ActivityStateStorageImpl
}

trait ActivityStateNodeExtractor extends RowExtractor[ActivityStateNode] {
  def extract(row: Row) = {
    val mapper = new ActivityStateNodeFieldsMapper {
      def treeID: Int = row.integer("treeID").get

      def availableChildrenIDs: String = row.string("availableChildrenIDs").get

      def id: Int = row.integer("id").get
    }

    createActivityStateNode(mapper)
  }

  def createActivityStateNode(mapper: ActivityStateNodeFieldsMapper): ActivityStateNode
}
