package com.arcusys.learn.scorm.tracking.states.storage.impl.orbroker

import com.arcusys.learn.scorm.tracking.model.{ActivityStateTree, ActivityStateNode}
import com.arcusys.learn.scorm.tracking.states.storage.ActivityStateTreeStorage
import com.arcusys.learn.storage.impl.orbroker.{KeyedEntityStorageBaseImpl, KeyedEntityStorageImpl}
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.tracking.states.storage.impl.{ActivityStateTreeCreator, ActivityStateTreeFieldsMapper, ActivityStateTreeEntityStorage}

class ActivityStateTreeStorageImpl extends KeyedEntityStorageBaseImpl[ActivityStateTree]("ActivityStateTree", "id") with ActivityStateTreeEntityStorage with ActivityStateTreeExtractor with ActivityStateTreeCreator {
  val activityStateStorage = new ActivityStateStorageImpl
  val activityStateNodeStorage = new ActivityStateNodeStorageImpl
  val globalObjectiveStorage = new GlobalObjectiveStorageImpl
}

trait ActivityStateTreeExtractor extends RowExtractor[ActivityStateTree] {
  def extract(row: Row) = {
    val mapper = new ActivityStateTreeFieldsMapper {
      def currentActivityID: Option[String] = row.string("currentActivityID")

      def suspendedActivityID: Option[String] = row.string("suspendedActivityID")

      def id: Int = row.integer("id").get
    }

    createActivityStateTree(mapper)
  }

  def createActivityStateTree(mapper: ActivityStateTreeFieldsMapper): ActivityStateTree
}
