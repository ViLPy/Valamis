package com.arcusys.learn.scorm.tracking.states.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageBaseImpl
import com.arcusys.learn.scorm.tracking.states.storage.ObjectiveStateStorage
import com.arcusys.learn.scorm.tracking.model.ActivityState
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.manifest.storage.impl.orbroker.ActivitiesStorageImpl
import com.arcusys.learn.scorm.tracking.states.storage.impl.{ActivityStateCreator, ActivityStateFieldsMapper, ActivityStateEntityStorage}
import com.arcusys.learn.scorm.manifest.storage.ActivitiesStorage

class ActivityStateStorageImpl extends KeyedEntityStorageBaseImpl[ActivityState]("ActivityState", "id") with ActivityStateEntityStorage with ActivityStateExtractor with ActivityStateCreator {
  val activitiesStorage = new ActivitiesStorageImpl
  val objectiveStateStorage = new ObjectiveStateStorageImpl
}

trait ActivityStateExtractor extends RowExtractor[ActivityState] {
  def activitiesStorage: ActivitiesStorage

  def objectiveStateStorage: ObjectiveStateStorage

  def extract(row: Row) = {
    val mapper = new ActivityStateFieldsMapper {
      def packageID: Int = row.integer("packageID").get

      def activityID: String = row.string("activityID").get

      def id: Int = row.integer("id").get

      def active: Boolean = row.bit("active").get

      def suspended: Boolean = row.bit("suspended").get

      def attemptCompleted: Option[Boolean] = row.bit("attemptCompleted")

      def attemptCompletionAmount: Option[BigDecimal] = row.decimal("attemptCompletionAmount").map(BigDecimal(_))

      def attemptAbsoluteDuration: BigDecimal = BigDecimal(row.decimal("attemptAbsoluteDuration").get)

      def attemptExperiencedDuration: BigDecimal = BigDecimal(row.decimal("attemptExperiencedDuration").get)

      def activityAbsoluteDuration: BigDecimal = BigDecimal(row.decimal("activityAbsoluteDuration").get)

      def activityExperiencedDuration: BigDecimal = BigDecimal(row.decimal("activityExperiencedDuration").get)

      def attemptCount: Int = row.integer("attemptCount").get
    }
    createActivityState(mapper)

  }

  def createActivityState(mapper: ActivityStateFieldsMapper): ActivityState
}
