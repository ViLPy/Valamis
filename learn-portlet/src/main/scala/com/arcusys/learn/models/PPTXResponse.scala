package com.arcusys.learn.models

//I don't know why do we need whole stuff from FileResponse,
//but some client-side code might need it, so I copied it.
case class PPTXResponse(id: Int,
  contentType: String,
  name: String,
  url: String,
  slides: Seq[PPTXSlideResponse])

case class PPTXSlideResponse(title: String,
  id: String,
  lessonId: Int,
  categoryId: Option[String])