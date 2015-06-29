package com.arcusys.learn.models.storyTree

import com.arcusys.valamis.lesson.tincan.model.{PackageCategoryGoal, TincanManifest}

/**
 * Created by mminin on 18.06.15.
 */
case class PackageResponse(id: Long,
                           title: String,
                           description:Option[String],
                           topics: Seq[PackageCategoryGoal]) {
}

object PackageResponse {
  def apply(data: (TincanManifest, Seq[PackageCategoryGoal])) : PackageResponse = {
    val (lesson, topics) = data
    PackageResponse(lesson.id, lesson.title, lesson.summary, topics)
  }
}