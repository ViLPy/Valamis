package com.arcusys.learn.quiz.storage.impl

import com.arcusys.learn.quiz.storage.QuizStorage
import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}
import com.arcusys.learn.quiz.model.Quiz

/**
 * User: dkudinov
 * Date: 15.3.2013
 */
trait QuizEntityStorage extends QuizStorage with KeyedEntityStorageExt[Quiz] with EntityStorageExt[Quiz] {

  def getByCourseID(courseID: Option[Int]) =
    getAll("courseID" -> courseID.getOrElse(-1))
}
