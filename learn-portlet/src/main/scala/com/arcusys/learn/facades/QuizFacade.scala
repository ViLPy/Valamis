package com.arcusys.learn.facades

import java.io.{ File, FileInputStream, InputStream }
import java.util.UUID
import com.arcusys.learn.exceptions.BadRequestException
import com.arcusys.learn.export.quiz.{ QuizExportProcessor, QuizImportProcessor }
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.models._
import com.arcusys.learn.models.request.PackagePublishType
import com.arcusys.learn.models.response.CollectionResponse
import com.arcusys.valamis.exception.EntityNotFoundException
import com.arcusys.valamis.lesson.generator.QuizPublishManager
import com.arcusys.valamis.lesson.generator.scorm.ScormPackageGenerator
import com.arcusys.valamis.lesson.generator.scorm.file.html.QuestionViewGenerator
import com.arcusys.valamis.lesson.generator.tincan.TinCanPackageGeneratorProperties
import com.arcusys.valamis.lesson.generator.tincan.file.TinCanQuizPackageGenerator
import com.arcusys.valamis.questionbank.model.{ DLVideo, PlainText }
import com.arcusys.valamis.quiz.model._
import com.arcusys.valamis.quiz.service.QuizService
import com.arcusys.valamis.slide.model.SlideSetModel
import com.arcusys.valamis.slide.service.SlideSetServiceContract
import com.arcusys.valamis.slide.service.export.SlideSetPublisherContract
import com.arcusys.valamis.uri.model.ValamisURIType
import com.arcusys.valamis.uri.service.URIServiceContract
import com.arcusys.valamis.utils.JsonSupport
import com.arcusys.valamis.utils.serialization.JsonHelper
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class QuizFacade(configuration: BindingModule) extends QuizFacadeContract with Injectable with JsonSupport {
  lazy val quizService = inject[QuizService]
  implicit val bindingModule = configuration

  def this() = this(Configuration)

  private val uriService = inject[URIServiceContract]
  private lazy val quizPublisher = new QuizPublishManager
  private lazy val slideSetService = inject[SlideSetServiceContract]
  private lazy val slideSetPublisher = inject[SlideSetPublisherContract]

  def getAll(courseID: Int, filter: String, sortBy: String, sortDirectionAsc: Boolean, pageNumber: Int, pageSize: Int): CollectionResponse[QuizResponse] = {

    val rangeResult = quizService.getQuizes(
      courseID,
      Option(filter),
      sortBy,
      sortDirectionAsc,
      pageNumber * pageSize - pageSize,
      pageSize
    )

    CollectionResponse(
      pageNumber,
      rangeResult.items map toQuizResponse,
      rangeResult.total
    )
  }

  private def toQuizResponse(q: Quiz): QuizResponse = {
    QuizResponse(q.id, q.title, q.description, q.logo, quizService.getQuestionsCount(q.id), q.maxDuration)
  }

  def create(title: String, description: String, logo: String, courseID: Int, maxDuration: Option[Int]): QuizResponse = {
    val quiz = quizService.createQuiz(title, description, logo, courseID, maxDuration)
    toQuizResponse(quiz)
  }

  def delete(quizId: Int) {
    quizService.deleteQuiz(quizId)
  }

  def publish(quizId: Int, userId: Long, courseId: Long, publishType: PackagePublishType.Value,
    theme: Option[String], randomOrdering: Boolean, questionsPerUser: Option[Int], scoreLimit: Option[Double]): QuizPublishStatusResponse = {

    publishType match {
      case PackagePublishType.Scorm =>
        quizPublisher.publishQuizAsScorm(quizId, userId, courseId)
      case PackagePublishType.TinCan =>
        val properties = new TinCanPackageGeneratorProperties(theme, randomOrdering, questionsPerUser, scoreLimit)
        quizPublisher.publishQuizAsTincan(quizId, userId, courseId, properties)
    }
    QuizPublishStatusResponse(status = true)
  }

  def download(quizID: Int, courseID: Long, publishType: PackagePublishType.Value, theme: Option[String], randomOrdering: Boolean, questionsPerUser: Option[Int], scoreLimit: Option[Double]): InputStream = {
    val quiz = quizService.getQuiz(quizID)

    val generator = publishType match {
      case PackagePublishType.Scorm => new ScormPackageGenerator(quiz)
      case PackagePublishType.TinCan =>
        val properties = new TinCanPackageGeneratorProperties(theme, randomOrdering, questionsPerUser, scoreLimit)
        val uriContent = Option(JsonHelper.toJson(new QuizInfo(quiz)))
        val rootActivityId = uriService.getOrCreate(uriService.getLocalURL(), UUID.randomUUID.toString, ValamisURIType.Course, uriContent)
        new TinCanQuizPackageGenerator(quiz, rootActivityId.uri, properties)
    }

    val zipFile = generator.generateZip(Some(courseID.toInt))
    new FileInputStream(zipFile)
  }

  def downloadExternal(quizID: Int, courseID: Long, publishType: PackagePublishType.Value, theme: Option[String], randomOrdering: Boolean, questionsPerUser: Option[Int], scoreLimit: Option[Double], portalURL: String): InputStream = {
    val quiz = quizService.getQuiz(quizID)
    val properties = new TinCanPackageGeneratorProperties(theme, randomOrdering, questionsPerUser, scoreLimit)
    val uriContent = Option(JsonHelper.toJson(new QuizInfo(quiz)))
    val rootActivityId = uriService.getOrCreate(uriService.getLocalURL(), UUID.randomUUID.toString, ValamisURIType.Course, uriContent)
    val generator = new TinCanQuizPackageGenerator(quiz, rootActivityId.uri, properties, Some(portalURL))

    val zipFile = generator.generateZip(Some(courseID.toInt))
    new FileInputStream(zipFile)
  }

  def update(quizId: Int, newTitle: String, newDescription: String, maxDuration: Option[Int]) = {
    quizService.updateQuiz(quizId, newTitle, newDescription, maxDuration)
  }

  def updateLogo(quizId: Int, newLogo: String) = {
    quizService.updateQuizLogo(quizId, newLogo)
  }

  def clone(quizId: Int): Unit = {
    quizService.cloneQuiz(quizId, " (copy)")
  }

  def convert(quizId: Int, courseId: Long): Unit = {
    val quiz = quizService.getQuiz(quizId)
    val createdSlideSet = slideSetService.create(
      SlideSetModel(
        None,
        quiz.title,
        quiz.description,
        Some(courseId),
        None,
        List())
    )
    slideSetPublisher.importFromQuiz(createdSlideSet.id.get, quizId)
  }

  def getContent(quizId: Int): Seq[QuizContentResponse] = {
    val rootCategories = quizService.getCategories(quizId, None)
      .map(c => toCategoryResponse(c, quizService.getQuestionsByCategory(quizId, Some(c.id))))

    val rootContent: Seq[QuizContentResponse] = rootCategories ++
      quizService.getQuestionsByCategory(quizId, None).map(toQuestionResponse)

    //TODO: add not root categories
    rootContent.sortBy(_.arrangementIndex)
  }

  private def toCategoryResponse(c: QuizQuestionCategory, qs: Seq[QuizQuestion]) = {
    val arrangementIndex = quizService.getCategoryIndex(c.quizID, c.id)
    QuizCategoryResponse(
      "c_" + c.id, c.quizID, c.title, arrangementIndex, qs.map(q => toQuestionResponse(q))
    )
  }

  def getQuestionPreview(quizID: Int, questionId: String): QuizQuestionPreview = {
    lazy val gen = new QuestionViewGenerator(isPreview = true)
    val context = ""
    quizService.getQuestionOption(idFromQuestion(questionId)) match {
      case Some(q: QuestionBankQuizQuestion) => QuizQuestionPreviewContent(
        gen.getHTMLByQuestionId(q.question, false, context)
      )
      case Some(q: PlainTextQuizQuestion) => QuizQuestionPreviewContent(
        gen.getHTMLByQuestionId(new PlainText(q.id, q.categoryID, q.title.getOrElse(""), q.text, q.categoryID), false, context)
      )
      case Some(q: RevealJSQuizQuestion) => QuizQuestionPreviewContent(
        gen.getHTMLForRevealPage(q.content)
      )
      case Some(q: PDFQuizQuestion) =>
        val url = "/learn-portlet/preview-resources/pdf/web/viewer.html?file=/learn-portlet/SCORMData/files/quizData" +
          quizID.toString + "/" + q.filename
        QuizQuestionPreviewRedirect(url)
      case Some(q: PPTXQuizQuestion) => QuizQuestionPreviewContent(
        gen.getHTMLForPPTXReview(q.quizID, q.file)
      )
      case Some(q: ExternalQuizQuestion) => QuizQuestionPreviewRedirect(q.url)

      case Some(q: DLVideoQuizQuestion) => QuizQuestionPreviewContent(
        gen.getHTMLByQuestionId(new DLVideo(q.id, q.categoryID, q.title.getOrElse(""), q.uuid, q.categoryID, q.uuid, q.groupId), false, context)
      )
      case _ => throw new Exception("unsupport question type")
    }
  }

  def addCategory(quizID: Int, title: String): QuizCategoryResponse = {
    val category = quizService.createCategory(quizID, title, "")
    toCategoryResponse(category, Seq())
  }

  def addQuestionPlainText(quizID: Int, categoryID: Option[String], title: String, text: String): QuizQuestionResponse = {
    val question = quizService.createQuestionPlainText(quizID, categoryID.map(idFromCategory), title, text)
    toQuestionResponse(question)
  }

  //TODO: WAT?
  def addQuestionRevealJS(quizID: Int, categoryID: Option[String], title: String, text: String): QuizQuestionResponse = {
    //questionStorage.modifyRevealJS(text.toInt, title)
    //questionStorage.getByID(text.toInt).map(toQuestionResponse).get
    null
  }

  def addQuestionPDF(quizID: Int, categoryID: Option[String], title: String, filename: String): QuizQuestionResponse = {
    val question = quizService.createQuestionPDF(quizID, categoryID.map(idFromCategory), title, filename)
    toQuestionResponse(question)
  }

  def addQuestionExternal(quizID: Int, categoryID: Option[String], title: String, url: String): QuizQuestionResponse = {
    val question = quizService.createQuestionExternal(quizID, categoryID.map(idFromCategory), title, url)
    toQuestionResponse(question)
  }

  def addQuestion(quizID: Int, categoryID: Option[String], bankQuestionID: Int): QuizQuestionResponse = {
    val question = quizService.createQuestionFromQuestionBank(quizID, categoryID.map(idFromCategory), bankQuestionID)
    toQuestionResponse(question)
  }

  private def toQuestionResponse(question: QuizQuestion) = {
    val arrangementIndex = quizService.getQuestionIndex(question.quizID, question.id)
    question match {
      case q: QuestionBankQuizQuestion => QuizQuestionBankResponse(
        "q_" + q.id, q.quizID, q.categoryID, q.question.title, q.question, q.autoShowAnswer, arrangementIndex, q.question.questionTypeCode // TODO: convert answer
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
      case q: PDFQuizQuestion => QuizQuestionPDFResponse(
        "q_" + q.id, q.quizID, q.categoryID, q.title.getOrElse(""), q.filename, arrangementIndex
      )
      case q: PPTXQuizQuestion => QuizQuestionPPTXResponse(
        "q_" + q.id, q.quizID, q.categoryID, q.title.getOrElse(""), arrangementIndex
      )
      case q: DLVideoQuizQuestion => QuizQuestionVideoDLResponse(
        "q_" + q.id, q.quizID, q.categoryID, q.title.getOrElse(""), q.uuid, arrangementIndex
      )
      case _ => throw new Exception("Unknown type of question")
    }
  }

  private def idFromCategory(id: String) = id.replace("c_", "").toInt

  def addVideo(quizID: Int, categoryID: Option[String], title: String, url: String, fromDL: Boolean, uuid: Option[String], groupId: Long): QuizQuestionResponse = {
    val question = if (fromDL) quizService.createQuestionDocumentLibrary(quizID, categoryID.map(idFromCategory), title, uuid.get, groupId.toInt)
    else {
      val r = """(?i)(?<=src=")(.+?)(?=")""".r
      val iframeURL = r.findAllIn(url).toSeq
      if (iframeURL.isEmpty) {
        quizService.createQuestionPlainText(quizID, categoryID.map(idFromCategory), title, url)
      } else {
        quizService.createQuestionExternal(quizID, categoryID.map(idFromCategory), title, iframeURL.head)
      }
    }

    toQuestionResponse(question)
  }

  def updateCategory(quizID: Int, categoryID: String, title: String): Unit =
    quizService.updateCategory(idFromCategory(categoryID), title, "")

  def updateQuestion(quizID: Int, id: String, title: String, autoShowAnswer: Boolean): Unit =
    quizService.updateQuestionFromQuestionBank(idFromQuestion(id), title, autoShowAnswer)

  def updateQuestionPlainText(quizID: Int, questionID: String, title: String): Unit =
    quizService.updateQuestionPlainText(idFromQuestion(questionID), title)

  private def idFromQuestion(id: String) = id.replace("q_", "").toInt

  def updateQuestionRevealJS(quizID: Int, questionID: String, title: String): Unit =
    quizService.updateQuestionRevealJS(idFromQuestion(questionID), title)

  def updateQuestionPDF(quizID: Int, questionID: String, title: String): Unit =
    quizService.updateQuestionRevealJS(idFromQuestion(questionID), title) //FIXME: misspell?

  def updateQuestionPPTX(questionID: String, title: String): Unit =
    quizService.updateQuestionPPTX(idFromQuestion(questionID), title)

  def updateQuestionExternal(quizID: Int, questionID: String, title: String, url: String): Unit =
    quizService.updateQuestionExternal(idFromQuestion(questionID), title, url)

  def deleteCategory(quizID: Int, categoryID: String): Unit =
    quizService.deleteCategory(quizID, idFromCategory(categoryID))

  def deleteQuestion(quizID: Int, questionID: String): Unit =
    quizService.deleteQuestion(quizID, idFromQuestion(questionID))

  def moveElement(quizId: Int, elementID: String, parentID: Option[String], index: Int) {
    // check if parent valid
    if (parentID.isDefined && !parentID.get.startsWith("c_")) return // not category
    if (parentID.isDefined && elementID.startsWith("c_") && parentID.get.startsWith("c_")) return

    if (elementID.startsWith("c_")) quizService.moveCategory(quizId, idFromCategory(elementID), parentID.map(idFromCategory), index)
    if (elementID.startsWith("q_")) quizService.moveQuestion(quizId, idFromQuestion(elementID), parentID.map(idFromCategory), index)

    //TODO: checkme
    /*quizTreeStorage.getByQuizAndElementID(quizID, elementID).foreach(entity => {
      if (elementID.startsWith("c_")) categoryStorage.updateParent(idFromCategory(elementID), parentID.map(idFromCategory))
      else if (elementID.startsWith("q_")) questionStorage.updateParent(idFromQuestion(elementID), parentID.map(idFromCategory))
      quizTreeStorage.move(entity.copy(parentID = parentID, arrangementIndex = index), entity.arrangementIndex)
    })*/
  }

  override def exportAllLessonsBase(courseID: Int): InputStream = {
    val quizzes = quizService.getQuizes(courseID)
    if (quizzes.isEmpty)
      throw new EntityNotFoundException("No lessons to export")
    new QuizExportProcessor().exportItems(quizzes)
  }

  override def exportLessons(quizIds: Seq[Int]): InputStream = {
    val quizzes = quizIds.map(quizId => {
      quizService.getQuizOption(quizId).getOrElse(throw new BadRequestException(s"Lesson with id:${quizId} not found"))
    })
    if (quizzes.isEmpty)
      throw new EntityNotFoundException("No lessons to export")
    new QuizExportProcessor().exportItems(quizzes)
  }

  override def importLessons(file: File, courseID: Int): Unit = {
    new QuizImportProcessor().importItems(file, courseID)
  }

}
