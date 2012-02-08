package com.arcusys.scorm.storage.quiz.impl.orbroker

import com.arcusys.scorm.model.quiz._
import com.arcusys.scorm.storage.quiz._
import com.arcusys.scorm.storage.impl.orbroker.GenericEntityStorageImpl
import com.arcusys.scorm.storage.impl.orbroker.IntExtractor
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
  
  def move(entity: QuestionCategory, isMoveToEnd: Boolean, isMoveAfterTarget: Boolean, targetID: Int) = {
    defParams += ("e"->entity, "targetId"->targetID, "moveToEnd"->isMoveToEnd, "moveAfter"->isMoveAfterTarget)
    if (entity.parentID != None) defParams += "hasParentID"->true
    
    broker.transactional() { session =>
      session.execute(Token(Symbol(tablePath + "_move"), IntExtractor), defParams:_*)
      session.commit
    }
    defParams.clear
    getByID(entity.id).getOrElse(throw new Exception("Some errors occured while move"))
  }
  
  object Extractor extends RowExtractor[QuestionCategory]
  {
    def extract(row: Row) = {
      QuestionCategory(
        row.integer("id").get,
        row.string("title").get, 
        row.string("description").get,
        row.integer("parentID")
      )
    }
  }
}
