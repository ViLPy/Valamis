package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 17.03.14.
 */
object UploadContentType extends Enumeration {
  type UploadContentType = Value

  val ICON = Value("icon")
  val REVEALJS = Value("reveal")
  val PDF = Value("pdf")
  val PPTX = Value("pptx")
  val BASE64_ICON = Value("base64-icon")
  val PACKAGE = Value("scorm-package")
  val DOC_LIBRARY = Value("document-library")
  val IMPORT_LESSON = Value("import-lesson")
  val IMPORT_QUESTION = Value("import-question")
  val IMPORT_CERTIFICATE = Value("import-certificate")
  val IMPORT_PACKAGE = Value("import-package")
}