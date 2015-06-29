package com.arcusys.learn.models

case class CategoryRequest (
  id: Option[Long] = None,
  title: String,
  order: Option[Long]
)