package com.arcusys.learn.models.request

/**
 * Created by Iliya Tryapitsin on 17.03.14.
 */
object UploadContentType extends Enumeration {
  type UploadContentType = Value

  val Icon = Value("icon")
  val RevealJs = Value("reveal")
  val Pdf = Value("pdf")
  val Pptx = Value("pptx")
  val Base64Icon = Value("base64-icon")
  val Package = Value("scorm-package")
  val DocLibrary = Value("document-library")
  val ImportLesson = Value("import-lesson")
  val ImportQuestion = Value("import-question")
  val ImportCertificate = Value("import-certificate")
  val ImportPackage = Value("import-package")
  val ImportSlideSet = Value("import-slide-set")
}