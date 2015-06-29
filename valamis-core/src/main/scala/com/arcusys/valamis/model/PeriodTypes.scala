package com.arcusys.valamis.model

import org.joda.time.DateTime

object PeriodTypes extends Enumeration {
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

  def getEndDate(periodType: PeriodType, value: Option[Int], startDate: DateTime): DateTime =
    getEndDate(periodType, value.getOrElse(0), startDate)

  def getEndDate(periodType: Option[PeriodType], value: Option[Int], startDate: DateTime): DateTime =
    getEndDate(periodType.getOrElse(PeriodTypes.UNLIMITED), value.getOrElse(0), startDate)

  def getEndDate(periodType: PeriodType, value: Int, startDate: DateTime): DateTime = periodType match {
    case PeriodTypes.DAYS      => startDate.plusDays(value)
    case PeriodTypes.WEEKS     => startDate.plusWeeks(value)
    case PeriodTypes.MONTH     => startDate.plusWeeks(value)
    case PeriodTypes.YEAR      => startDate.plusYears(value)
    case PeriodTypes.UNLIMITED => startDate.plusYears(99999)
  }

  def getEndDateOption(periodType: PeriodType, value: Int, startDate: DateTime): Option[DateTime] = periodType match {
    case PeriodTypes.UNLIMITED => None
    case _ => Some(getEndDate(periodType, value, startDate))
  }
}
