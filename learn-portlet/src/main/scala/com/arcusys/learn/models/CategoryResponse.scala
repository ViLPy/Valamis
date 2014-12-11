package com.arcusys.learn.models

/**
 * Created by Iliya Tryapitsin on 10.04.2014.
 */
case class CategoryResponse(id: Int,
  title: String,
  description: String,
  parentId: Int,
  categoryType: String = "folder",
  childrenAmount: Int = 0,
  arrangementIndex: Int = 0)