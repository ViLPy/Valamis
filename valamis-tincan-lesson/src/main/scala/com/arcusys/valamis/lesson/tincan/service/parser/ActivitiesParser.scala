package com.arcusys.valamis.lesson.tincan.service.parser

import com.arcusys.valamis.lesson.tincan.model.ManifestActivity
import com.arcusys.valamis.util.XMLImplicits

import scala.xml.Elem
import XMLImplicits._
class ActivitiesParser(root: Elem, title: String, summary: String) {
  def parse: Seq[ManifestActivity] = {
    if (!root.label.equals("tincan")) throw new TinCanParserException("Root element of manifest is not <tincan>")
    val activitiesElement = root childElem "activities" required element

    activitiesElement.children("activity").map(activityElement => ManifestActivity(
      -1,
      activityElement.attr("id").required(string),
      -1,
      activityElement.attr("type").required(string),
      activityElement.childElem("name").required(string),
      activityElement.childElem("description").required(string),
      activityElement.childElem("launch").optional(string),
      activityElement.childElem("resource").optional(string)
    )).toSeq
  }
}