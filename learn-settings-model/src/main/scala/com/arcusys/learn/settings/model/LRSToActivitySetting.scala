package com.arcusys.learn.settings.model

/**
 * Task is about integrating Learning Record Store into Liferay Activity Stream portlet.
 * When statements are generated to LRS, admin could choose which type of statements would be sent also to Liferay Activity Stream
 * This class is used to store filter settings for picking correct statements by activity ID or verb ID
 *
 * @param id - entity id
 * @param courseID - which course store setting
 * @param title - setting title
 * @param mappedActivity - TinCan Activity ID for filter
 * @param mappedVerb - TinCan Verb ID for filter
 */
case class LRSToActivitySetting(id: Int,
  courseID: Int,
  title: String,
  mappedActivity: Option[String],
  mappedVerb: Option[String])
