package com.arcusys.valamis.slide.service

import java.io.InputStream

import com.arcusys.valamis.lesson.service.PackageUploadManager
import com.arcusys.valamis.lesson.tincan.model.PackageCategoryGoal
import com.arcusys.valamis.lesson.tincan.storage.PackageCategoryGoalStorage
import com.arcusys.valamis.slide.model.{SlideSetModel, SlideModel, SlideSetEntity}
import com.arcusys.valamis.slide.service.export._
import com.arcusys.valamis.slide.storage.SlideSetRepositoryContract
import com.arcusys.valamis.uri.model.ValamisURIType
import com.arcusys.valamis.uri.service.URIServiceContract
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }
import SlideModelConverters._

class SlideSetService(implicit val bindingModule: BindingModule)
  extends Injectable
  with SlideSetServiceContract {

    private val slideSetRepository = inject[SlideSetRepositoryContract]
    private val slideSetPublisher = inject[SlideSetPublisherContract]
    private val slideSetImporter = inject[SlideSetImporterContract]
    private val slideSetExporter = inject[SlideSetExporterContract]
    private val slideService = inject[SlideServiceContract]
    private val packageUploadService = new PackageUploadManager()
    private val uriService = inject[URIServiceContract]
    private lazy val packageGoalStorage = inject[PackageCategoryGoalStorage]


    private implicit def convertToModel(from: SlideSetEntity) = slideSetModelConversion(from, slideService.getBySlideSetId(from.id))
    private implicit def convertToModelList(from: List[SlideSetEntity]) = from.map(convertToModel) //TODO: Option & List => Monad? One function instead of two?
    private implicit def convertToModelOption(from: Option[SlideSetEntity]) = from.map(convertToModel) //TODO: Option & List => Monad? One function instead of two?

    override def getById(id: Long) = slideSetRepository.getById(id)

    override def getSlideSets(titleFilter: String, sortTitleAsc: Boolean, page: Int, itemsOnPage: Int, courseId: Option[Long]) =
      slideSetRepository.getSlideSets(titleFilter, sortTitleAsc, page, itemsOnPage, courseId)

    override def getSlideSetsCount(titleFilter: String, courseId: Option[Long]) =
      slideSetRepository.getSlideSetsCount(titleFilter, courseId)

    override def delete(id: Long) = slideSetRepository.delete(id)

    override def publishSlideSet(id: Long, userId: Long, learnPortletPath: String, courseId: Long) : Unit = {
      val slideSet = getById(id).getOrElse(throw new IllegalStateException(s"There is no slideSet with id=$id"))

      val packageFile = slideSetPublisher.composeTinCanPackage(id, learnPortletPath, slideSet.title, slideSet.description)

      val categories = for (
        slide <- slideService.getBySlideSetId(id);
        statementCategoryId <- slide.statementCategoryId;
        uri <-  uriService.getById(statementCategoryId, ValamisURIType.Category)
      ) yield uri

      val (packageId, _) = packageUploadService.uploadPackage(
        slideSet.title,
        slideSet.description,
        slideSet.logo.map { (s"slideset_logo_${slideSet.id.get}", _) },
        courseId,
        userId,
        packageFile
      )

      val packageGoals = categories
        .groupBy(identity).toSeq
        .map(c => PackageCategoryGoal(
          packageId = packageId,
          name = c._1.content,
          category = c._1.uri,
          count = c._2.size
        ))

      packageGoalStorage.add(packageGoals)

      packageFile.delete()
    }

    override def exportSlideSet(id: Long) = {
      val slideSet = getById(id).getOrElse(throw new IllegalStateException(s"No slideSet exist with id $id"))

      slideSetExporter.exportItems(Seq(slideSet))
    }

    override def importSlideSet(stream: InputStream, scopeId: Int) =
      slideSetImporter.importItems(stream, scopeId)

    override def update(slideSetModel: SlideSetModel) =
      slideSetRepository.update(slideSetModel)

    override def create(slideSetModel: SlideSetModel) =
      slideSetRepository.create(slideSetModel)

    override def createWithDefaultSlide(slideSetModel: SlideSetModel) = {
      val slideSet = slideSetRepository.create(slideSetModel)
      slideService.create(
        SlideModel(
          title = "Page 1",
          slideSetId = slideSet.id)
      ) //Presentation should have a slide by default.
      slideSet
    }
}