package com.arcusys.valamis.quiz.storage

import com.arcusys.valamis.quiz.model.QuizQuestion

trait QuizQuestionStorage {
  def getCount(quizID: Int): Int
  def getByID(id: Int): Option[QuizQuestion]
  def getByCategory(quizID: Int, categoryID: Option[Int]): Seq[QuizQuestion]
  def createFromQuestionBankAndGetID(quizID: Int, categoryID: Option[Int], questionID: Int): Int
  def createExternalAndGetID(quizID: Int, categoryID: Option[Int], title: String, url: String): Int
  def createRevealAndGetID(quizID: Int, categoryID: Option[Int], title: String, content: String): Int
  def createPDFAndGetID(quizID: Int, categoryID: Option[Int], title: String, filename: String): Int
  def createPPTXAndGetID(quizID: Int, categoryID: Option[Int], title: String, filename: String): Int
  def createPlainAndGetID(quizID: Int, categoryID: Option[Int], title: String, text: String): Int
  def createDLAndGetID(quizID: Int, categoryID: Option[Int], title: String, uuid: String, groupId: Int): Int
  def modifyExternal(id: Int, title: String, url: String)
  def modifyRevealJS(id: Int, title: String)
  def modifyTitle(id: Int, title: String)
  def modify(id: Int, title: String, autoShowAnswer: Boolean)
  def delete(id: Int)
  def updateParent(id: Int, parentID: Option[Int])
  def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterTarget: Boolean): QuizQuestion
  def getAll: Seq[QuizQuestion]
  def renew()
}
