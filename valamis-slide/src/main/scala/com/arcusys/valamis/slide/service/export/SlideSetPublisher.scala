package com.arcusys.valamis.slide.service.export

import java.io.{ ByteArrayInputStream, File, FileInputStream, InputStream }
import com.arcusys.learn.liferay.services.FileEntryServiceHelper
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.lesson.generator.tincan.file.TinCanRevealJSPackageGeneratorContract
import com.arcusys.valamis.lesson.generator.tincan.file.html.TinCanQuestionViewGenerator
import com.arcusys.valamis.questionbank.model.{Answer, Question}
import com.arcusys.valamis.questionbank.service.QuestionService
import com.arcusys.valamis.quiz.model._
import com.arcusys.valamis.quiz.service.QuizService
import com.arcusys.valamis.slide.model.{SlideElementModel, SlideSetModel, SlideModel, SlideEntityType}
import com.arcusys.valamis.slide.service.{SlideElementServiceContract, SlideSetServiceContract, SlideServiceContract}
import com.arcusys.valamis.uri.model.ValamisURIType
import com.arcusys.valamis.uri.service.URIServiceContract
import com.arcusys.valamis.util.mustache.Mustache
import com.arcusys.valamis.util.JsonSupport._
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

trait SlideSetPublisherContract {
  def composeTinCanPackage(slideSetId: Long, learnPortletPath: String, title: String, description: String): File
  def importFromQuiz(id: Long, quizId: Int)
}

class SlideSetPublisher(implicit val bindingModule: BindingModule)
  extends Injectable
  with SlideSetExportUtils
  with SlideSetPublisherContract {

  private val tinCanRevealJSPackageGenerator = inject[TinCanRevealJSPackageGeneratorContract]
  private lazy val slideService = inject[SlideServiceContract]
  private lazy val slideSetService = inject[SlideSetServiceContract]
  private lazy val slideElementService = inject[SlideElementServiceContract]
  protected lazy val questionService = inject[QuestionService]
  protected lazy val fileService = inject[FileService]
  private val tincanQuestionViewGenerator = new TinCanQuestionViewGenerator(isPreview = false)
  private lazy val uriService = inject[URIServiceContract]
  private lazy val quizService = inject[QuizService]

  private def getResourceInputStream(name: String) = Thread.currentThread.getContextClassLoader.getResourceAsStream(name)

  private lazy val indexTemplate = new Mustache(scala.io.Source.fromInputStream(getResourceInputStream("tincan/revealjs.html")).mkString)

  private val vendorJSFileNames =
    "jquery.min.js" ::
      "reveal.min.js" ::
      "jquery-ui-1.10.4.custom.min.js" ::
      "jquery.ui.widget.js" ::
      "lodash.min.js" ::
      "backbone-min.js" ::
      "backbone.marionette_new.min.js" ::
      "backbone.service.js" ::
      "mustache.min.js" ::
      Nil

  private val slideSetJSFileNames =
    "Urls.js" ::
      "valamis-slides-editor/helper.js" ::
      "valamis-slides-editor/loadTemplates.js" ::
      "valamis-slides-editor/slideService.js" ::
      "valamis-slides-editor/slideElementService.js" ::
      "question-manager/models/AnswerModel.js" ::
      "question-manager/models/QuestionModel.js" ::
      "valamis-slides-editor/TinCanPackageRenderer.js" ::
      "valamis-slides-editor/TinCanPackageGenericItem.js" ::
      Nil

  private val commonJSFileNames =
    "base.js" ::
      Nil

  private val slideSetCSSFileNames =
    "reveal.min.css" ::
      "video-js.min.css" ::
      "katex.min.css" ::
      "valamis.css" ::
      "valamis_slides.css" ::
      "theme/valamis_slides.css" ::
      Nil

  override def composeTinCanPackage(slideSetId: Long, learnPortletPath: String, title: String, description: String): File = {
    val slides = slideService.getBySlideSetId(slideSetId).map { slide =>
      val statementVerbWithName = slide.statementVerb
        .flatMap(uriService.getById(_, ValamisURIType.Verb))
        .map(x => x.uri + "/" + x.content) match {
          case None => slide.statementVerb
          case Some(value) => Some(value + value.substring(value.lastIndexOf("/") + 1))
        }
      val statementCategoryWithName = slide.statementCategoryId
        .flatMap(uriService.getById(_, ValamisURIType.Category))
        .map(x => x.uri + "/" + x.content)

      SlideModel(slide.id,
        slide.title,
        slide.bgColor,
        slide.bgImage,
        slide.leftSlideId,
        slide.topSlideId,
        slide.slideElements,
        slide.slideSetId,
        statementVerbWithName,
        slide.statementObject,
        statementCategoryWithName)
    }

    val slideTypes = slides.map(_.slideElements).flatMap(x => x.map(_.slideEntityType)).distinct

    val additionalJSFileNames = slideTypes.collect {
      case SlideEntityType.Video => "video.js"
      case SlideEntityType.Math => "katex.min.js"
    }

    val fontFiles = filesFromDirectory(List(learnPortletPath + "fonts/"), None, true)
    val previewResourceFiles = if (slideTypes contains SlideEntityType.Pdf) filesFromDirectory(List(learnPortletPath + "preview-resources/pdf/"), None, true) else Nil
    val questions = getRequiredQuestions(slides)
    val slidesQuestions = slides.flatMap { slide =>
      slide.slideElements.filter { e => e.slideEntityType == "question" }
    }

    val URI = {
      val uriContent = Option(Map("title" -> title, "description" -> description).toJson.get)
      uriService.createLocal(ValamisURIType.Course, uriContent)
    }

    val index = new ByteArrayInputStream(indexTemplate.render(
      Map(
        "title" -> title,
        "slidesJson" -> slides.toJson.get,
        "isSlideJsonAvailable" -> true,
        "includeVendorFiles" -> (additionalJSFileNames ::: vendorJSFileNames).map(fileName => "js/" + fileName),
        "includeCommonFiles" -> commonJSFileNames.map(fileName => "js/" + fileName),
        "includeFiles" -> slideSetJSFileNames.map(fileName => "js/" + fileName),
        "includeCSS" -> slideSetCSSFileNames.map(fileName => "css/" + fileName),
        "includeFonts" -> fontFiles.map(file => "fonts/" + file._1.replace(learnPortletPath, "")),
        "rootActivityId" -> URI.uri,
        "scoreLimit" -> 0.7
      ) ++ getQuestionsMap(questions, slidesQuestions)
    ).getBytes)

    val filesToAdd: List[(String, InputStream)] =
      ("index.html" -> index) ::
      getRequiredFiles(slides) :::
      (additionalJSFileNames ::: vendorJSFileNames).map(fileName => "js/" + fileName -> new FileInputStream(learnPortletPath + "js2.0/vendor/" + fileName)) :::
      commonJSFileNames.map(fileName => "js/" + fileName -> getResourceInputStream("common/" + fileName)) :::
      previewResourceFiles.map(file => file._1.replaceAll(learnPortletPath, "") -> file._2) :::
      slideSetJSFileNames.map(fileName => "js/" + fileName -> new FileInputStream(learnPortletPath + "js2.0/" + fileName)) :::
      fontFiles.map(file => file._1.replaceAll(learnPortletPath, "") -> file._2) :::
      slideSetCSSFileNames.map(fileName => "css/" + fileName -> new FileInputStream(learnPortletPath + "css2.0/" + fileName))

    tinCanRevealJSPackageGenerator.composePackage(omitFileDuplicates(filesToAdd), URI.uri, title, description)
  }

  private def getQuestionsMap(questions: List[Question[Answer]], slidesQuestions: List[SlideElementModel]): Map[String, Any] = {
    Map(
      "questionsJson" -> getQuestionsJSON(questions, slidesQuestions),
      "questionScripts" -> getQuestionScripts(questions, slidesQuestions),
      "questionMarkupTemplates" -> getQuestionMarkupTemplates(questions, slidesQuestions)
    )
  }

  private def getQuestionsJSON(questions: List[Question[Answer]], slidesQuestions: List[SlideElementModel]): String = {
    questions.map(question =>
      tincanQuestionViewGenerator.getViewModelFromQuestion(
        question,
        getQuestionAutoShowAnswer(slidesQuestions, question.id)
      ) + ("questionType" -> question.questionTypeCode)
    ).toJson.get
  }

  private def getQuestionScripts(questions: List[Question[Answer]], slidesQuestions: List[SlideElementModel]) = {
    questions.map(question => {
      val scriptRegex = "(?s)(<script.*>.*</script>)".r
      scriptRegex.findFirstMatchIn(tincanQuestionViewGenerator.getHTMLByQuestionId(
        question,
        getQuestionAutoShowAnswer(slidesQuestions, question.id))
      ).map(_.group(1))
        .getOrElse("")
    })
  }

  private def getQuestionMarkupTemplates(questions: List[Question[Answer]], slidesQuestions: List[SlideElementModel]) = {
    questions.map(question => {
      val questionTypeString = question.questionTypeCode match {
        case 0 => "ChoiceQuestion"
        case 1 => "ShortAnswerQuestion"
        case 2 => "NumericQuestion"
        case 3 => "PositioningQuestion"
        case 4 => "MatchingQuestion"
        case 5 => "EssayQuestion"
        case 6 => "EmbeddedAnswerQuestion"
        case 7 => "CategorizationQuestion"
        case 8 => "PlainText"
        case 9 => "PurePlainText"
        case _ => ""
      }
      val sectionRegex = "(?s)(<section.*>.*</section>)".r
      val questionMarkup = sectionRegex
        .findFirstMatchIn(tincanQuestionViewGenerator.getHTMLByQuestionId(question, getQuestionAutoShowAnswer(slidesQuestions, question.id)))
        .map(_.group(1))
        .getOrElse("")
        .replaceAll("<(/)*section.*>", "")
      "<script type='text/html' id='" + questionTypeString + "Template" + question.id + "'>" + questionMarkup + "</script>"
    })
  }

  def getQuestionAutoShowAnswer(slideQuestions: List[SlideElementModel], questionId: Int): Boolean = {
    slideQuestions
      .filter { slideQuestion => Integer.parseInt(slideQuestion.content) == questionId}
      .head
      .notifyCorrectAnswer
      .getOrElse(false)
  }

  private def filesFromDirectory(dirPaths: List[String], dirName: Option[String] = None, isRecursive: Boolean = false): List[(String, FileInputStream)] = {
    var fileList: List[(String, FileInputStream)] = Nil
    dirPaths.map { dirPath =>
      val fileName = new File(dirPath).getName
      fileList = listFilesForFolder(dirName.getOrElse(fileName), new File(dirPath), isRecursive) ++ fileList
    }
    fileList
  }

  private def listFilesForFolder(prefix: String, folder: File, isRecursive: Boolean): List[(String, FileInputStream)] = {
    var fileList: List[(String, FileInputStream)] = Nil
    folder.listFiles.foreach { fileEntry =>
      if (isRecursive) {
        if(fileEntry.isDirectory)
          fileList = listFilesForFolder(prefix + "/" + fileEntry.getName, fileEntry, isRecursive) ++ fileList
        else fileList = ((prefix + "/" + fileEntry.getName) -> new FileInputStream(fileEntry)) :: fileList
      } else if (!fileEntry.isDirectory) fileList = ((prefix + fileEntry.getName) -> new FileInputStream(fileEntry)) :: fileList
    }
    fileList
  }

  private def addSlide(
    questions: List[QuizQuestion],
    previousSlide: Option[SlideModel],
    previousSlideId: Option[Long],
    previousSlideType: String,
    slideSetId: Long): Unit = {

    if(questions.nonEmpty) {
      val question = questions.head
      val createdSlide = slideService.create(
        SlideModel(
          leftSlideId = previousSlideId,
          slideSetId = slideSetId)
      )

      question match {
        case q@(_: QuestionBankQuizQuestion |
                _: PlainTextQuizQuestion |
                _: RevealJSQuizQuestion |
                _: ExternalQuizQuestion |
                _: PDFQuizQuestion |
                _: DLVideoQuizQuestion) =>
          slideService.update(
            SlideModel(
              createdSlide.id,
              leftSlideId = previousSlide.flatMap(_.id),
              topSlideId = None,
              slideSetId = slideSetId
            )
          )
          addNormalSlideElement(q, createdSlide.id.get)
          addSlide(questions diff List(question), Some(createdSlide), createdSlide.id, previousSlideType = "normal", slideSetId)
        case q: PPTXQuizQuestion =>
          fileService.copyFile(
            "quizData" + q.quizID.toString,
            q.file,
            "slide_" + createdSlide.id.get,
            q.file,
            false
          )
          val url = "url(\"/delegate/files/images?folderId=slide_" + createdSlide.id.get + "&file=" + q.file + "\") contain"

          previousSlideType match {
            case "normal" =>
              slideService.update(
                SlideModel(
                  createdSlide.id,
                  bgImage = Some(url),
                  leftSlideId = previousSlideId,
                  topSlideId = None,
                  slideSetId = slideSetId
                )
              )
              addSlide(questions diff List(question), Some(createdSlide), createdSlide.id, previousSlideType = "pptx", slideSetId)
            case "pptx" =>
              slideService.update(
                SlideModel(
                  createdSlide.id,
                  bgImage = Some(url),
                  leftSlideId = None,
                  topSlideId = previousSlideId,
                  slideSetId = slideSetId
                )
              )
              addSlide(questions diff List(question), previousSlide, createdSlide.id, previousSlideType = "pptx", slideSetId)
          }
        case _ => throw new Exception("unsupported question type")
      }
    }
  }

  private def addNormalSlideElement(question: QuizQuestion, slideId: Long) = {
    question match {
      case q: QuestionBankQuizQuestion  =>
        addSlideElement("800", "auto", q.question.id.toString, "question", slideId)
      case q: PlainTextQuizQuestion =>
        addSlideElement("800", "auto", q.text, "text", slideId)
      case q: PlainRevealJSQuizQuestion =>
        addSlideElement("800", "auto", q.content, "text", slideId)
      case q: RevealJSQuizQuestion =>
        addSlideElement("800", "auto", q.content, "text", slideId)
      case q: ExternalQuizQuestion      =>
        if (q.url.contains("youtube.com/embed/"))
          addSlideElement("640", "360", q.url, "video", slideId)
        else
          addSlideElement("800", "600", q.url, "iframe", slideId)
      case q: PDFQuizQuestion           =>
        fileService.copyFile(
          "quizData" + q.quizID.toString,
          q.filename,
          "quizData" + slideId,
          q.filename,
          false
        )
        val url = "/learn-portlet/preview-resources/pdf/web/viewer.html?file=/learn-portlet/SCORMData/files/quizData" +
          slideId + "/" + q.filename

        addSlideElement("800", "600", url, "pdf", slideId)
      case q: DLVideoQuizQuestion       =>
        val fileEntry = FileEntryServiceHelper.getFileEntry(q.uuid, q.groupId.get)
        val groupId = fileEntry.getGroupId
        val filename = fileEntry.getTitle
        val fileExtension = fileEntry.getExtension
        val folderId = fileEntry.getFolderId
        val url = "/documents/" + groupId + "/" + folderId + "/" + filename + "/" +
          q.uuid + "?groupId=" + q.groupId.get + "&ext=" + fileExtension

        addSlideElement("640", "360", url, "video", slideId)
      case _                            =>
    }
  }

  private def addSlideElement(width: String, height: String, content: String, slideElementType: String, slideId: Long) = {
    slideElementService.create(
      SlideElementModel(
        width = width,
        height = height,
        content = content,
        slideEntityType = slideElementType,
        slideId = slideId
      )
    )
  }

  override def importFromQuiz(id: Long, quizId: Int) = {
    var questions = quizService.getQuestionsByCategory(quizId, None)
    val categories = quizService.getCategories(quizId, None).map(category =>
      questions = quizService.getQuestionsByCategory(quizId, Some(category.id)) ++ questions
    )
    val slideSet = slideSetService.getById(id).get
    val quiz = quizService.getQuiz(quizId)
    if(!quiz.logo.isEmpty) {
      fileService.copyFile(
        "quiz_logo_" + quizId,
        quiz.logo,
        "slideset_logo_" + id,
        quiz.logo,
        false
      )
    }
    slideSetService.update(
      SlideSetModel(
        Some(id),
        slideSet.title,
        slideSet.description,
        slideSet.courseId,
        Some(quiz.logo),
        List())
    )
    addSlide(questions.toList, None, None, previousSlideType = "normal", slideSet.id.get)
  }
}
