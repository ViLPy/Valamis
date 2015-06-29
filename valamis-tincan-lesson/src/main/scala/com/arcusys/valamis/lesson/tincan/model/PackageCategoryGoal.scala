package com.arcusys.valamis.lesson.tincan.model

case class PackageCategoryGoal(
    packageId: Long,
    name: String,
    category: String,
    count: Int,
    id: Option[Long] = None)
