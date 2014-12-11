package com.arcusys.learn.bl.services.quiz

import com.arcusys.learn.bl.services.lesson.PackageUploadManager
import com.arcusys.learn.bl.services.{ QuizServiceContract, FileServiceContract }
import com.arcusys.learn.quiz.model.Quiz
import com.arcusys.learn.quiz.storage.QuizQuestionCategoryStorage
import com.arcusys.learn.scorm.manifest.storage.ScormPackagesStorage
import com.arcusys.learn.tincan.manifest.storage.TincanPackageStorage
import com.arcusys.scorm.generator.file.ScormPackageGenerator
import com.arcusys.tincan.generator.file.TinCanQuizPackageGenerator
import com.escalatesoft.subcut.inject.Injectable

trait QuizPublishManager extends QuizServiceContract with Injectable {

  protected def categoryStorage: QuizQuestionCategoryStorage
  protected def fileService: FileServiceContract
  protected def scormPackageRepository: ScormPackagesStorage
  protected def tincanPackageRepository: TincanPackageStorage

  def getQuiz(quizId: Int): Quiz
  def getQuestionsCount(quizId: Int): Int

  lazy val uploadManager = new PackageUploadManager

  def publishQuizAsTincan(quizId: Int, theme: Option[String], randomOrdering: Boolean, questionsPerUser: Option[Int]) = {
    val quiz = getQuiz(quizId)

    if (getQuestionsCount(quizId) == 0) {
      throw new Exception("can`t publish empty quiz, quizId: " + quizId)
    }

    val generator = new TinCanQuizPackageGenerator(quiz, theme)

    val filename = generator.generateZip(quiz.courseID, randomOrdering, questionsPerUser)
    val packageFileName = filename.substring(0, filename.length - 4)

    val quizLogo = quiz.logo
    val packageId = uploadManager.uploadTincanPackage(quiz.title, quiz.description, packageFileName, quiz.courseID)

    if (quizLogo.nonEmpty) {
      fileService.copyFile("quiz_logo_" + quizId, quizLogo, "package_logo_" + packageId, quizLogo)

      tincanPackageRepository.setLogo(packageId, Option(quizLogo))
    }
  }

  def publishQuizAsScorm(quizId: Int, userId: Long, groupIdOption: Option[Long], randomOrdering: Boolean, questionsPerUser: Option[Int]) = {
    val quiz = getQuiz(quizId)

    if (getQuestionsCount(quizId) == 0) {
      throw new Exception("can`t publish empty quiz, quizId: " + quizId)
    }

    val generator = new ScormPackageGenerator(quiz)

    val filename = generator.generateZip(quiz.courseID, randomOrdering, questionsPerUser)
    val packageFileName = filename.substring(0, filename.length - 4)

    val quizLogo = quiz.logo
    val packageId = uploadManager.uploadScormPackage(quiz.title, quiz.description, packageFileName, quiz.courseID, userId, groupIdOption.getOrElse(-1))

    if (quizLogo.nonEmpty) {
      fileService.copyFile("quiz_logo_" + quizId, quizLogo, "package_logo_" + packageId, quizLogo)

      scormPackageRepository.setLogo(packageId, Option(quizLogo))
    }
  }
}
