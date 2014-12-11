package com.arcusys.learn.bl.services

import com.arcusys.learn.bl.services.quiz._
import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.quiz.storage._
import com.arcusys.learn.scorm.manifest.storage.ScormPackagesStorage
import com.arcusys.learn.tincan.manifest.storage.TincanPackageStorage
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }

//TODO remove treeEntity id prefixes from this layer
//TODO move question/category index from quizTreeEntity to question/category
//     hide quizTreeEntity inrepository layer
class QuizService(configuration: BindingModule) extends Injectable with QuizServiceContract
    with QuizManager with QuizQuestionManager with QuizCategoryManager with QuizPublishManager {
  def this() = this(DomainConfiguration)

  implicit val bindingModule = configuration

  protected def fileService = inject[FileServiceContract]

  protected def quizStorage = inject[QuizStorage]
  protected def categoryStorage = inject[QuizQuestionCategoryStorage]
  protected def questionStorage = inject[QuizQuestionStorage]
  protected def quizTreeStorage = inject[QuizTreeStorage]

  protected def scormPackageRepository = inject[ScormPackagesStorage]
  protected def tincanPackageRepository = inject[TincanPackageStorage]

}
