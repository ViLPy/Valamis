package com.arcusys.learn.scorm.tracking.storage.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageBaseImpl
import com.arcusys.learn.scorm.tracking.model._
import com.arcusys.learn.scorm.manifest.storage.impl.orbroker.PackagesStorageImpl
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.tracking.storage.impl.{AttemptCreator, AttemptFieldsMapper, AttemptEntityStorage}

class AttemptStorageImpl extends KeyedEntityStorageBaseImpl[Attempt]("Attempt", "id") with AttemptEntityStorage with AttemptExtractor with AttemptCreator {
  val userStorage = new UserStorageImpl
  val packageStorage = new PackagesStorageImpl

}

trait AttemptExtractor extends RowExtractor[Attempt] {
  def extract(row: Row) = {
    val mapper = new AttemptFieldsMapper() {
      def id: Int = row.integer("id").get

      def userID: Int = row.integer("userID").get

      def packageID: Int = row.integer("packageID").get

      def organizationID: String = row.string("organizationID").get

      def isComplete: Boolean = row.bit("isComplete").get
    }
    createAttempt(mapper)
  }

  def createAttempt(mapper: AttemptFieldsMapper): Attempt
}