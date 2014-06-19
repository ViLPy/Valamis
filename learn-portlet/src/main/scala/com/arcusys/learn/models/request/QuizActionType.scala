package com.arcusys.learn.models.request

object QuizActionType extends Enumeration {
  val GetAll = Value("GETALL")
  val GetContent = Value("GETCONTENT")

  val Add = Value("ADD")
  val Publish = Value("PUBLISH")
  val Download = Value("DOWNLOAD")
  val Delete = Value("DELETE")
  val Update = Value("UPDATE")
  val Clone = Value("CLONE")

  val AddCategory = Value("ADDCATEGORY")
  val AddQuestion = Value("ADDQUESTION")
  val AddQuestions = Value("ADDQUESTIONS")
  val AddQuestionExternal = Value("ADDQUESTIONEXTERNALRESOURCE")
  val AddQuestionPlainText = Value("ADDQUESTIONPLAINTEXT")
  val AddQuestionRevealJS = Value("ADDQUESTIONREVEALJS")

  val DeleteQuestion = Value("DELETEQUESTION")
  val DeleteCategory = Value("DELETECATEGORY")

  val UpdateCategory = Value("UPDATECATEGORY")
  val UpdateQuestion = Value("UPDATEQUESTION")
  val UpdateQuestionPlainText = Value("UPDATEQUESTIONPLAINTEXT")
  val UpdateQuestionRevealJS = Value("UPDATEQUESTIONREVEALJS")
  val UpdateQuestionExternal = Value("UPDATEQUESTIONEXTERNALRESOURCE")

  val MoveElement = Value("MOVEELEMENT")

  val QuestionPreview = Value("GETQUESTIONPREVIEW")

  type QuizActionType = Value
}
