package com.arcusys.learn.models.request

object QuizActionType extends Enumeration {
  val GetAll = Value("GETALL")
  val GetContent = Value("GETCONTENT")

  val Add = Value("ADD")
  val Publish = Value("PUBLISH")
  val Delete = Value("DELETE")
  val Update = Value("UPDATE")
  val UpdateLogo = Value("UPDATELOGO")
  val Clone = Value("CLONE")
  val Convert = Value("CONVERT")

  val AddCategory = Value("ADDCATEGORY")
  val AddQuestion = Value("ADDQUESTION")
  val AddQuestions = Value("ADDQUESTIONS")
  val AddQuestionExternal = Value("ADDQUESTIONEXTERNALRESOURCE")
  val AddQuestionPlainText = Value("ADDQUESTIONPLAINTEXT")
  val AddQuestionRevealJS = Value("ADDQUESTIONREVEALJS")
  val AddQuestionPDF = Value("ADDQUESTIONPDF")
  val AddVideo = Value("ADDQUESTIONVIDEO")

  val DeleteQuestion = Value("DELETEQUESTION")
  val DeleteCategory = Value("DELETECATEGORY")

  val UpdateCategory = Value("UPDATECATEGORY")
  val UpdateQuestion = Value("UPDATEQUESTION")
  val UpdateQuestionPlainText = Value("UPDATEQUESTIONPLAINTEXT")
  val UpdateQuestionRevealJS = Value("UPDATEQUESTIONREVEALJS")
  val UpdateQuestionPDF = Value("UPDATEQUESTIONPDF")
  val UpdateQuestionPPTX = Value("UPDATEQUESTIONPPTX")
  val UpdateQuestionExternal = Value("UPDATEQUESTIONEXTERNALRESOURCE")
  val UpdateQuestionDLVideo = Value("UPDATEQUESTIONVIDEODL")

  val MoveElement = Value("MOVEELEMENT")

  val QuestionPreview = Value("GETQUESTIONPREVIEW")

  val Import = Value("IMPORT")

  type QuizActionType = Value
}
