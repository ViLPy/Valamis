package com.arcusys.learn.scorm.tracking.model.certificating

import org.joda.time.DateTime

/**
 * Created by guestAdmin on 22.04.14.
 */
object PeriodType extends Enumeration {
  type PeriodType = Value

  val UNLIMITED, YEAR, MONTH, WEEKS, DAYS = Value

  def parse(value: String) = value.toLowerCase() match {
    case "unlimited" => UNLIMITED
    case "year"      => YEAR
    case "month"     => MONTH
    case "weeks"     => WEEKS
    case "days"      => DAYS
    case _           => UNLIMITED
  }

  def apply(value: String) = parse(value)

  def apply(value: Option[String]) = value match {
    case Some(v) => parse(v)
    case None    => UNLIMITED
  }

  def getEndDate(periodType: PeriodType, value: Option[Int], startDate: DateTime) = periodType match {
    case PeriodType.DAYS      => startDate.plusDays(value.getOrElse(0))
    case PeriodType.WEEKS     => startDate.plusWeeks(value.getOrElse(0))
    case PeriodType.MONTH     => startDate.plusWeeks(value.getOrElse(0))
    case PeriodType.YEAR      => startDate.plusYears(value.getOrElse(0))
    case PeriodType.UNLIMITED => startDate.plusYears(99999)
  }

  def getEndDate(periodType: Option[PeriodType], value: Option[Int], startDate: DateTime) = periodType.getOrElse(PeriodType.UNLIMITED) match {
    case PeriodType.DAYS      => startDate.plusDays(value.getOrElse(0))
    case PeriodType.WEEKS     => startDate.plusWeeks(value.getOrElse(0))
    case PeriodType.MONTH     => startDate.plusWeeks(value.getOrElse(0))
    case PeriodType.YEAR      => startDate.plusYears(value.getOrElse(0))
    case PeriodType.UNLIMITED => startDate.plusYears(99999)
  }
}
