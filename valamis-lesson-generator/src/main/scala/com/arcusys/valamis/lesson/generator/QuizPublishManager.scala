package com.arcusys.valamis.lesson.generator

import java.util.UUID
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.lesson.generator.scorm.ScormPackageGenerator
import com.arcusys.valamis.lesson.generator.tincan.TinCanPackageGeneratorProperties
import com.arcusys.valamis.lesson.generator.tincan.file.TinCanQuizPackageGenerator
import com.arcusys.valamis.lesson.scorm.storage.ScormPackagesStorage
import com.arcusys.valamis.lesson.service.{PackageService, PackageUploadManager}
import com.arcusys.valamis.lesson.tincan.storage.TincanPackageStorage
import com.arcusys.valamis.quiz.model.QuizInfo
import com.arcusys.valamis.quiz.service.QuizService
import com.arcusys.valamis.quiz.storage.QuizQuestionCategoryStorage
import com.arcusys.valamis.uri.model.ValamisURIType
import com.arcusys.valamis.uri.service.URIServiceContract
import com.arcusys.valamis.util.serialization.JsonHelper
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class QuizPublishManager(implicit val bindingModule: BindingModule) extends Injectable {

  private def categoryStorage = inject[QuizQuestionCategoryStorage]
  private def fileService = inject[FileService]
  private def scormPackageRepository = inject[ScormPackagesStorage]
  private def tincanPackageRepository = inject[TincanPackageStorage]
  private def quizService = inject[QuizService]
  private val packageService = inject[PackageService]

  lazy val uploadManager = new PackageUploadManager
  private val uriService = inject[URIServiceContract]

  def publishQuizAsTincan(quizId: Int, userId: Long, courseId: Long, properties: TinCanPackageGeneratorProperties) = {
    val quiz = quizService.getQuiz(quizId)

    if (quizService.getQuestionsCount(quizId) == 0) {
      throw new Exception("can`t publish empty quiz, quizId: " + quizId)
    }

    val uriContent = Option(JsonHelper.toJson(new QuizInfo(quiz)))
    val rootActivityId = uriService.getOrCreate(uriService.getLocalURL(), UUID.randomUUID.toString, ValamisURIType.Course, uriContent)
    val generator = new TinCanQuizPackageGenerator(quiz, rootActivityId.uri, properties)

    val packageZipFile = generator.generateZip(quiz.courseID)

    val quizLogo = quiz.logo
    val packageId = uploadManager.uploadTincanPackage(quiz.title, quiz.description, packageZipFile, courseId, userId)

    if (quizLogo.nonEmpty) {
      fileService.copyFile("quiz_logo_" + quizId, quizLogo, "package_logo_" + packageId, quizLogo)

      tincanPackageRepository.setLogo(packageId, Option(quizLogo))
    }

    packageZipFile.delete()
  }

  def publishQuizAsScorm(quizId: Int, userId: Long, courseId: Long) = {
    val quiz = quizService.getQuiz(quizId)

    if (quizService.getQuestionsCount(quizId) == 0) {
      throw new Exception("can`t publish empty quiz, quizId: " + quizId)
    }

    val generator = new ScormPackageGenerator(quiz)

    val packageZipFile = generator.generateZip(quiz.courseID)

    val quizLogo = quiz.logo
    val packageId = uploadManager.uploadScormPackage(quiz.title, quiz.description, packageZipFile, courseId, userId)

    if (quizLogo.nonEmpty) {
      fileService.copyFile("quiz_logo_" + quizId, quizLogo, "package_logo_" + packageId, quizLogo)

      scormPackageRepository.setLogo(packageId, Option(quizLogo))
    }

    packageZipFile.delete()
  }
}
