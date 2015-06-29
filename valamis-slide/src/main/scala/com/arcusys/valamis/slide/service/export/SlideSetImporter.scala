package com.arcusys.valamis.slide.service.export

import java.io.{ File, InputStream }
import com.arcusys.valamis.export.ImportProcessor
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.questionbank.model.{ Question, Answer }
import com.arcusys.valamis.questionbank.service.QuestionService
import com.arcusys.valamis.slide.model._
import com.arcusys.valamis.slide.service.{ SlideServiceContract, SlideElementServiceContract, SlideSetServiceContract }
import com.arcusys.valamis.util.FileSystemUtil
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

trait SlideSetImporterContract {
  def importItems(stream: InputStream, scopeId: Int): Unit
}

class SlideSetImporter(implicit val bindingModule: BindingModule)
  extends Injectable
  with SlideSetExportUtils
  with ImportProcessor[ExportFormat]
  with SlideSetImporterContract {

  private lazy val slideSetService = inject[SlideSetServiceContract]
  private val slideService = inject[SlideServiceContract]
  private val slideElementService = inject[SlideElementServiceContract]
  protected val fileService = inject[FileService]
  protected val questionService = inject[QuestionService]

  private def addSlides(
    slides: List[SlideModel],
    oldSlideSet: SlideSetModel,
    createdSlideSet: SlideSetModel,
    slideSetVersion: Option[String],
    slidesMapper: scala.collection.mutable.Map[Long, Long],
    localPath: String,
    questions: List[Question[Answer]]): Unit = {

    def addSlide(
      prevSlideModel: SlideModel,
      title: String,
      bgColor: Option[String],
      bgImage: Option[String],
      leftSlideId: Option[Long],
      topSlideId: Option[Long]) = {

      val createdSlide = slideService.create(
        SlideModel(
          title = title,
          bgColor = bgColor,
          bgImage = bgImage,
          leftSlideId = leftSlideId,
          topSlideId = topSlideId,
          slideSetId = createdSlideSet.id.get)
      )
      slidesMapper += (prevSlideModel.id.get -> createdSlide.id.get)
      bgImage.flatMap(getFromPath).map { tuple =>
        val displayMode = getDisplayMode(bgImage.get)
        val url = addSlideBgImageToFileService(
          createdSlide.id.get,
          slideSetVersion,
          getFileName(tuple),
          localPath + File.separator + getPath(tuple, slideSetVersion)) + ' ' + displayMode
        slideService.update(
          SlideModel(
            createdSlide.id,
            title,
            bgColor,
            Some(url),
            leftSlideId,
            topSlideId,
            List(),
            createdSlideSet.id.get,
            createdSlide.statementVerb,
            createdSlide.statementObject,
            createdSlide.statementCategoryId)
        )
      }

      prevSlideModel.slideElements.foreach { slideElement =>
        slideElement.slideEntityType match {
          case SlideEntityType.Image | SlideEntityType.Pdf | SlideEntityType.Video =>
            val createdSlideElement =
              createSlideElement(
                slideElement,
                slideElement.content,
                createdSlide.id.get)
            getFromPath(slideElement.content).map { tuple =>
              addSlideEntityImageToFileService
            }
            getFromPath(slideElement.content).map { tuple =>
              val url = addSlideEntityImageToFileService(
                createdSlideElement.id.get,
                slideSetVersion,
                getFileName(tuple),
                localPath + File.separator + getPath(tuple, slideSetVersion))
              slideElementService.update(
                SlideElementModel(
                  createdSlideElement.id,
                  slideElement.top,
                  slideElement.left,
                  slideElement.width,
                  slideElement.height,
                  slideElement.zIndex,
                  url,
                  slideElement.slideEntityType,
                  createdSlide.id.get,
                  slideElement.correctLinkedSlideId,
                  slideElement.incorrectLinkedSlideId)
              )
            }
          case SlideEntityType.Question =>
            val createdQuestion =
              questionService
                .createQuestion(questions.find(_.id == slideElement.content.toInt)
                .getOrElse(throw new IllegalStateException("No question with required id")))
            questionService.moveQuestionToCourse(
              createdQuestion.id,
              createdSlideSet.courseId.map(id => id.toInt),
              true)
            questionService.decodeQuestion(createdQuestion)
            createSlideElement(
              slideElement,
              createdQuestion.id.toString,
              createdSlide.id.get)
          case _ =>
            createSlideElement(
              slideElement,
              slideElement.content,
              createdSlide.id.get)
        }
      }
    }
    val firstSlide =
      slides
        .find(slide =>(!slide.topSlideId.isDefined) && (!slide.leftSlideId.isDefined))
        .getOrElse(throw new IllegalStateException("There should exist a slide without left&top slides"))

    val slide = addSlide(
      firstSlide,
      firstSlide.title,
      firstSlide.bgColor,
      firstSlide.bgImage,
      firstSlide.leftSlideId,
      firstSlide.topSlideId)

    slides.find(_.leftSlideId == firstSlide.id).map(addSlidesHelper)
    slides.find(_.topSlideId == firstSlide.id).map(addSlidesHelper)

    def addSlidesHelper(slide: SlideModel): Unit = {
      addSlide(slide, slide.title, slide.bgColor, slide.bgImage,
        slide.leftSlideId.flatMap(oldLeftSlideId => slidesMapper.get(oldLeftSlideId)),
        slide.topSlideId.flatMap(oldTopSlideId => slidesMapper.get(oldTopSlideId)))

      slides.find(_.leftSlideId == slide.id).map(addSlidesHelper)
      slides.find(_.topSlideId == slide.id).map(addSlidesHelper)
    }
  }

  private def createSlideElement(slideElement: SlideElementModel, content: String, slideId: Long): SlideElementModel = {
    slideElementService.create(
      SlideElementModel(
        None,
        slideElement.top,
        slideElement.left,
        slideElement.width,
        slideElement.height,
        slideElement.zIndex,
        content,
        slideElement.slideEntityType,
        slideId,
        slideElement.correctLinkedSlideId,
        slideElement.incorrectLinkedSlideId)
    )
  }

  override protected def importItems(items: List[ExportFormat], courseId: Long, tempDirectory: File, userId: Long): Unit = {
    require(items.length == 1)
    val item = items.head

    val slideSet = item.slideSet
    val questions = item.questions.map(QuestionExternalFormat.importQuestion)
    val version = item.version

    val createdSlideSet = slideSetService.create(
      SlideSetModel(
        None,
        slideSet.title,
        slideSet.description,
        Some(courseId),
        slideSet.logo, List())
    )
    slideSet.logo.map { logoString =>
      val folderPrefix = version match {
        case Some(v) => "resources"
        case _       => "images"
      }
      val path =
        tempDirectory.getPath +
          File.separator +
          folderPrefix +
          File.separator +
          slideSetLogoDir(slideSet.id.get, version) +
          File.separator +
          logoString
      addSlideLogoToFileService(createdSlideSet.id.get, version, logoString, path)
    }

    addSlides(
      slideSet.slides,
      slideSet,
      createdSlideSet,
      version,
      scala.collection.mutable.Map[Long, Long](),
      tempDirectory.getPath,
      questions)
  }

  override def importItems(stream: InputStream, scopeId: Int): Unit =
    importItems(FileSystemUtil.streamToTempFile(stream, "Import", ".zip"), scopeId)
}