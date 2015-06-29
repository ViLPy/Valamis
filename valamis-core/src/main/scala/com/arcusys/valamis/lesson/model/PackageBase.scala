package com.arcusys.valamis.lesson.model

import org.joda.time.DateTime

trait PackageBase {
  def id: Long
  def title: String
  def assetRefId: Option[Long]
  def courseID: Option[Int]
  def summary: Option[String]
  def logo: Option[String]
  def beginDate: Option[DateTime]
  def endDate: Option[DateTime]
}
