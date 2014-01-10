package com.arcusys.tincan.manifest.parser

import scala.xml.Elem
import com.arcusys.learn.scorm.manifest.parser.XMLImplicits
import XMLImplicits._
import com.arcusys.learn.tincan.manifest.model.ManifestActivity

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