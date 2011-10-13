package com.arcusys.scorm.storage.impl.orbroker

import com.arcusys.scorm.model.quiz._
import com.arcusys.scorm.storage._
import org.orbroker.Row
import org.orbroker.RowExtractor

import com.arcusys.scorm.storage.impl.orbroker.BrokerFactory._
import org.orbroker.Token
import org.orbroker.conv._

class QuestionCategoryStorageImpl extends QuestionCategoryStorage with GenericEntityStorageImpl[QuestionCategory]
{
  def tablePath = "QuestionCategory"
  def extractor = Extractor
  def idParam = "id"

  def getChildren(parentID: Option[Int]) = {
        broker.readOnly() { session => session.selectAll(Token(Symbol(tablePath), Extractor),
                                                         "parentID"->parentID.getOrElse(-1)) }
  }
  
  object Extractor extends RowExtractor[QuestionCategory]
  {
    def extract(row: Row) = {
      QuestionCategory(
        row.integer("id").get,
        row.string("title").get, 
        row.string("description").get,
        row.integer("parentID"))
    }
  }
}
