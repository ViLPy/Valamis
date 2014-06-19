package com.arcusys.learn.facades

import com.arcusys.learn.models._
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.storage.impl.liferay.LFStorageFactory
import com.arcusys.learn.quiz.model._
import com.arcusys.scorm.generator.file.QuizPackageGenerator
import com.arcusys.learn.liferay.service.asset.AssetHelper
import com.arcusys.scorm.generator.file.html.QuestionViewGenerator
import com.arcusys.scorm.deployer.PackageProcessor
import com.arcusys.learn.quiz.model.PlainTextQuizQuestion
import com.arcusys.learn.quiz.model.QuizQuestionCategory
import com.arcusys.learn.models.QuizCategoryResponse
import com.arcusys.learn.models.QuizQuestionPreviewRedirect
import com.arcusys.learn.quiz.model.Quiz
import com.arcusys.learn.models.QuizQuestionBankResponse
import com.arcusys.learn.quiz.model.ExternalQuizQuestion
import com.arcusys.learn.models.QuizQuestionPreviewContent
import scala.Some
import com.arcusys.learn.questionbank.model.PlainText
import com.arcusys.learn.models.QuizResponse
import com.arcusys.learn.models.QuizQuestionExternalResponse
import com.arcusys.learn.models.QuizQuestionRevealJSResponse
import com.arcusys.learn.quiz.model.QuestionBankQuizQuestion
import com.arcusys.learn.quiz.model.RevealJSQuizQuestion
import com.arcusys.learn.models.QuizQuestionPlainTextResponse
import com.arcusys.learn.models.response.CollectionResponse
import java.io.{ FileInputStream, InputStream }
import com.arcusys.scorm.util.FileSystemUtil

class QuizFacade(configuration: BindingModule) extends QuizFacadeContract with Injectable {
  def this() = this(Configuration)

  implicit val bindingModule = configuration

  lazy val quizStorage = LFStorageFactory.quizStorage
  lazy val categoryStorage = LFStorageFactory.quizQuestionCategoryStorage
  lazy val questionStorage = LFStorageFactory.quizQuestionStorage
  lazy val quizTreeStorage = LFStorageFactory.quizTreeStorage

  lazy val fileFacade = inject[FileFacadeContract]

  def getAll(filter: String, sortBy: String, sortDirectionAsc: Boolean, pageNumber: Int, pageSize: Int): CollectionResponse[QuizResponse] = {
    var quizzes = quizStorage.getAll

    if (filter != null && !filter.isEmpty) quizzes = quizzes.filter(_.title.contains(filter))

    val totalCount = quizzes.size

    quizzes = sortBy match {
      case "TITLE"        => quizzes.sortBy(_.title)
      case "CREATIONDATE" => quizzes.sortBy(_.id)
      case "DESCRIPTION"  => quizzes.sortBy(_.description)
      case _              => quizzes.sortBy(_.title)
    }

    if (!sortDirectionAsc) quizzes = quizzes.reverse

    quizzes = quizzes drop (pageNumber * pageSize - pageSize) take pageSize

    CollectionResponse(
      pageNumber,
      quizzes map toQuizResponse toSeq,
      totalCount
    )
  }

  private def toQuizResponse(q: Quiz): QuizResponse = QuizResponse(q.id, q.title, q.description, q.logo)

  private def toQuestionResponse(question: QuizQuestion) = {
    val quizTreeElement = quizTreeStorage.getByQuizAndElementID(question.quizID, "q_" + question.id)
    val arrangementIndex = quizTreeElement.map(_.arrangementIndex).getOrElse(1)
    question match {
      case q: QuestionBankQuizQuestion => QuizQuestionBankResponse(
        "q_" + q.id, q.quizID, q.categoryID, q.question.title, q.question, arrangementIndex // TODO: convert answer
      )
      case q: PlainTextQuizQuestion => QuizQuestionPlainTextResponse(
        "q_" + q.id, q.quizID, q.categoryID, q.title.getOrElse(""), q.text, arrangementIndex
      )
      case q: ExternalQuizQuestion => QuizQuestionExternalResponse(
        "q_" + q.id, q.quizID, q.categoryID, q.title.getOrElse(""), q.url, arrangementIndex
      )
      case q: RevealJSQuizQuestion => QuizQuestionRevealJSResponse(
        "q_" + q.id, q.quizID, q.categoryID, q.title.getOrElse(""), q.content, arrangementIndex
      )
    }
  }

  private def toCategoryResponse(c: QuizQuestionCategory, qs: Seq[QuizQuestion]) = {
    val quizTreeElement = quizTreeStorage.getByQuizAndElementID(c.quizID, "c_" + c.id)
    val arrangementIndex = quizTreeElement.map(_.arrangementIndex).getOrElse(1)
    QuizCategoryResponse(
      "c_" + c.id, c.quizID, c.title, arrangementIndex, qs.map(q => toQuestionResponse(q))
    )
  }

  private def idFromCategory(id: String) = id.replace("c_", "").toInt

  private def idFromQuestion(id: String) = id.replace("q_", "").toInt

  def create(title: String, description: String, logo: String, courseID: Int): QuizResponse = {
    val id = quizStorage.createAndGetID(Quiz(-1, title, description, "", "", Some(courseID), logo)) // TODO: store logo
    quizStorage.getByID(id).map(toQuizResponse).get
  }

  def delete(quizId: Int) {
    questionStorage.getByCategory(quizId, None).foreach(q => deleteQuestion(quizId, q.id))
    categoryStorage.getChildren(quizId, None).foreach(c => deleteCategory(quizId, c.id))
    quizTreeStorage.getByQuizID(quizId).foreach(e => quizTreeStorage.delete(e.id))
    quizStorage.delete(quizId)
  }

  def publish(quizId: Int, userID: Long, groupIDOption: Option[Long]): QuizPublishStatusResponse = {
    val quiz = quizStorage.getByID(quizId).get
    val hasQuestion = questionStorage.getCount(quizId) > 0
    if (!hasQuestion) return QuizPublishStatusResponse(status = false)

    val generator = new QuizPackageGenerator(quiz)
    val filename = generator.generateZip(quiz.courseID)
    val packageFileName = filename.substring(0, filename.length - 4)

    val packageProcessor = new PackageProcessor()
    val quizLogo = quiz.logo
    val quizID = quiz.id
    val packageID = packageProcessor.processPackageAndGetID(quiz.title, quiz.description, packageFileName, quiz.courseID, None)

    if (quizLogo.nonEmpty) {
      fileFacade.copyToFolder("quiz_logo_" + quizID, quizLogo, "package_logo_" + packageID)

      LFStorageFactory.packageStorage.setLogo(packageID, Option(quizLogo))
    }

    for (groupID <- groupIDOption) {
      val packageStorage = LFStorageFactory.packageStorage
      val assetHelper = new AssetHelper()

      val thePackage = packageStorage.getByID(packageID).getOrElse(throw new Exception("Can't find newly created package"))
      assetHelper.addPackage(userID, groupID, thePackage)
    }

    QuizPublishStatusResponse(status = true)
  }

  def download(quizID: Int, courseID: Long): InputStream = {
    val quiz = quizStorage.getByID(quizID).get
    val generator = new QuizPackageGenerator(quiz)
    val filename = generator.generateZip(Some(courseID.toInt))
    new FileInputStream(FileSystemUtil.getRealTmpDir + filename)
  }

  def update(quizId: Int, newTitle: String, newDescription: String, newLogo: String): Unit = {
    val quiz = quizStorage.getByID(quizId).get
      .copy(title = newTitle, description = newDescription, logo = newLogo)

    quizStorage.modify(quiz)
  }

  def clone(quizId: Int): Unit = {
    val quiz = quizStorage.getByID(quizId).get

    val newQuizId = quizStorage.createAndGetID(quiz.copy(title = quiz.title + " (copy)"))

    if (quiz.logo.nonEmpty)
      fileFacade.copyToFolder("quiz_logo_" + quizId, quiz.logo, "quiz_logo_" + newQuizId)

    def cloneContent(content: QuizContentResponse, categoryId: Option[String]): Unit = content match {
      case c: QuizCategoryResponse =>
        val newCategory = addCategory(newQuizId, c.title)
        c.children.foreach(cloneContent(_, Some(newCategory.id)))
      case q: QuizQuestionRevealJSResponse =>
        addQuestionRevealJS(newQuizId, categoryId, q.title, q.text)
      case q: QuizQuestionExternalResponse =>
        addQuestionExternal(newQuizId, categoryId, q.title, q.url)
      case q: QuizQuestionPlainTextResponse =>
        addQuestionPlainText(newQuizId, categoryId, q.title, q.text)
      case q: QuizQuestionBankResponse =>
        addQuestion(newQuizId, categoryId, q.question.id)
    }

    getContent(quizId).foreach(cloneContent(_, None))
  }

  def getContent(quizId: Int): Seq[QuizContentResponse] = {
    val rootCategories = categoryStorage.getChildren(quizId, None)
      .map(c => toCategoryResponse(c, questionStorage.getByCategory(quizId, Some(c.id))))

    val rootContent: Seq[QuizContentResponse] = rootCategories ++
      questionStorage.getByCategory(quizId, None).map(toQuestionResponse)

    //TODO: add not root categories
    rootContent.sortBy(_.arrangementIndex)
  }

  def getQuestionPreview(questionId: String): QuizQuestionPreview = {
    lazy val gen = new QuestionViewGenerator(isPreview = true)
    val context = ""
    questionStorage.getByID(idFromQuestion(questionId)) match {
      case Some(q: QuestionBankQuizQuestion) => QuizQuestionPreviewContent(
        gen.getHTMLByQuestionId(q.question, context)
      )
      case Some(q: PlainTextQuizQuestion) => QuizQuestionPreviewContent(
        gen.getHTMLByQuestionId(new PlainText(q.id, q.categoryID, q.title.getOrElse(""), q.text, q.categoryID), context)
      )
      case Some(q: RevealJSQuizQuestion) => QuizQuestionPreviewContent(
        gen.getHTMLForRevealPage(q.content)
      )
      case Some(q: ExternalQuizQuestion) => QuizQuestionPreviewRedirect(q.url)
    }
  }

  def addCategory(quizID: Int, title: String): QuizCategoryResponse = {
    val categoryId = categoryStorage.createAndGetID(QuizQuestionCategory(0, title, "", quizID, None))
    quizTreeStorage.createAndGetID(QuizTreeElement(0, quizID, "c_" + categoryId, true, None))
    categoryStorage.getByID(categoryId).map(toCategoryResponse(_, Seq())).get
  }

  def addQuestionPlainText(quizID: Int, categoryID: Option[String], title: String, text: String): QuizQuestionResponse = {
    val questionId = questionStorage.createPlainAndGetID(quizID, categoryID.map(idFromCategory), title, text)
    quizTreeStorage.createAndGetID(QuizTreeElement(0, quizID, "q_" + questionId, true, categoryID))
    questionStorage.getByID(questionId).map(toQuestionResponse).get
  }

  def addQuestionRevealJS(quizID: Int, categoryID: Option[String], title: String, text: String): QuizQuestionResponse = {
    val questionId = questionStorage.createRevealAndGetID(quizID, categoryID.map(idFromCategory), title, text)
    quizTreeStorage.createAndGetID(QuizTreeElement(0, quizID, "q_" + questionId, true, categoryID))
    questionStorage.getByID(questionId).map(toQuestionResponse).get
  }

  def addQuestionExternal(quizID: Int, categoryID: Option[String], title: String, url: String): QuizQuestionResponse = {
    val questionId = questionStorage.createExternalAndGetID(quizID, categoryID.map(idFromCategory), title, url)
    quizTreeStorage.createAndGetID(QuizTreeElement(0, quizID, "q_" + questionId, true, categoryID))
    questionStorage.getByID(questionId).map(toQuestionResponse).get
  }

  def addQuestion(quizID: Int, categoryID: Option[String], questionID: Int): QuizQuestionResponse = {
    val questionId = questionStorage.createFromQuestionBankAndGetID(quizID, categoryID.map(idFromCategory), questionID)
    quizTreeStorage.createAndGetID(QuizTreeElement(0, quizID, "q_" + questionId, true, categoryID))
    questionStorage.getByID(questionId).map(toQuestionResponse).get
  }

  def updateCategory(quizID: Int, categoryID: String, title: String): Unit =
    categoryStorage.modify(idFromCategory(categoryID), title, "")

  def updateQuestion(quizID: Int, id: String, title: String): Unit =
    questionStorage.modify(idFromQuestion(id), title)

  def updateQuestionPlainText(quizID: Int, questionID: String, title: String): Unit =
    questionStorage.modify(idFromQuestion(questionID), title)

  def updateQuestionRevealJS(quizID: Int, questionID: String, title: String, content: String): Unit =
    questionStorage.modifyRevealJS(idFromQuestion(questionID), title, content)

  def updateQuestionExternal(quizID: Int, questionID: String, title: String, url: String): Unit =
    questionStorage.modifyExternal(idFromQuestion(questionID), title, url)

  def deleteCategory(quizID: Int, categoryID: String): Unit = deleteCategory(quizID, idFromCategory(categoryID))

  def deleteCategory(quizID: Int, categoryID: Int) {
    questionStorage.getByCategory(quizID, Some(categoryID)).foreach(q => deleteQuestion(quizID, q.id))
    quizTreeStorage.getByQuizAndElementID(quizID, "c_" + categoryID).map(e => quizTreeStorage.delete(e.id))
    categoryStorage.delete(categoryID)
  }

  def deleteQuestion(quizID: Int, questionID: String): Unit = deleteQuestion(quizID, idFromQuestion(questionID))

  def deleteQuestion(quizID: Int, questionID: Int): Unit = {
    quizTreeStorage.getByQuizAndElementID(quizID, "q_" + questionID).map(e => quizTreeStorage.delete(e.id))
    questionStorage.delete(questionID)
  }

  def moveElement(quizID: Int, elementID: String, parentID: Option[String], index: Int) {
    // check if parent valid
    if (parentID.isDefined) {
      if (!parentID.get.startsWith("c_")) return // not category
      if (quizTreeStorage.getByQuizAndElementID(quizID, parentID.get).isEmpty) return // not persisted
    }

    quizTreeStorage.getByQuizAndElementID(quizID, elementID).foreach(entity => {
      if (elementID.startsWith("c_")) categoryStorage.updateParent(idFromCategory(elementID), parentID.map(idFromCategory))
      else if (elementID.startsWith("q_")) questionStorage.updateParent(idFromQuestion(elementID), parentID.map(idFromCategory))
      quizTreeStorage.move(entity.copy(parentID = parentID, arrangementIndex = index))
    })
  }
}
