package com.arcusys.valamis.slide.service.export

import java.io.FileInputStream
import com.arcusys.valamis.export.ExportProcessor
import com.arcusys.valamis.file.service.FileService
import com.arcusys.valamis.questionbank.service.QuestionService
import com.arcusys.valamis.slide.model.SlideSetModel
import com.arcusys.valamis.util.ZipBuilder
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

trait SlideSetExporterContract {
  def exportItems(items: Seq[SlideSetModel]): FileInputStream
}

class SlideSetExporter(implicit val bindingModule: BindingModule)
  extends Injectable
  with SlideSetExportUtils
  with ExportProcessor[SlideSetModel, ExportFormat]
  with SlideSetExporterContract {

    protected val fileService = inject[FileService]
    protected val questionService = inject[QuestionService]

    protected def exportItemsImpl(zip: ZipBuilder, slideSets: Seq[SlideSetModel]) = {
      require(slideSets.length == 1)

      val slideSet = slideSets.head

      val questions = getRequiredQuestions(slideSet.slides).map(QuestionExternalFormat.exportQuestion)
      val images = getRequiredFiles(slideSet.slides)
      val logo = slideSet.logo.map(logo => slideSetLogoDir(slideSet.id.get, slidesVersion) -> logo).map(getPathAndInputStream)

      omitFileDuplicates(if (logo.isEmpty) images else logo.get :: images) foreach {
        case (path, inputStream) =>
          zip.addFile(inputStream, path)
      }

      Seq(ExportFormat(slidesVersion, questions, slideSet))
    }
}