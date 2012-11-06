package com.arcusys.learn.storage

import com.arcusys.learn.scorm.manifest.storage._
import com.arcusys.learn.scorm.tracking.storage._
import com.arcusys.learn.quiz.storage._
import com.arcusys.learn.questionbank.storage._
import com.arcusys.learn.scorm.tracking.states.storage.{ActivityStateStorage, ActivityStateTreeStorage}
import com.arcusys.learn.filestorage.storage.FileStorage

trait StorageFactoryContract
{
  def packageStorage: PackagesStorage
  def activityStorage: ActivitiesStorage
  //def organizationStorage: OrganizationsStorage
  def resourceStorage: ResourcesStorage
  def questionCategoryStorage: QuestionCategoryStorage
  def questionStorage: QuestionStorage
  def quizStorage: QuizStorage
  def quizQuestionCategoryStorage: QuizQuestionCategoryStorage
  def quizQuestionStorage: QuizQuestionStorage
  def attemptStorage: AttemptStorage
  def dataModelStorage: DataModelStorage
  def userStorage: UserStorage
  def activityStateTreeStorage: ActivityStateTreeStorage
  def activityStateStorage: ActivityStateStorage
  def fileStorage: FileStorage
  def renewWholeStorage()

  def dbType:String
}
