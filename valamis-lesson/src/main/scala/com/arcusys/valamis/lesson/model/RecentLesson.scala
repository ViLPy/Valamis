package com.arcusys.valamis.lesson.model
/**
 * Created by eboystova on 29.05.15.
 */
import org.joda.time.DateTime

case class RecentLesson(
   val packageTitle : String,
   val throughDate: DateTime,
   val courseTitle: String,
   val courseUrl: String)

