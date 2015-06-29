package com.arcusys.valamis.lesson.scorm.model.manifest

import com.arcusys.valamis.util.CollectionExtensions._

/**Base class for child activity set */
abstract sealed class ChildActivitySet

/**All children*/
case object ChildActivitySetAll extends ChildActivitySet

/**At least one child*/
case object ChildActivitySetAny extends ChildActivitySet

/**Exactly 0 children*/
case object ChildActivitySetNone extends ChildActivitySet

/**At least 'count' children*/
case class ChildActivitySetAtLeastCount(count: Int) extends ChildActivitySet {
  require(count >= 0)
}

/**At least 'percent' % of children*/
case class ChildActivitySetAtLeastPercent(percent: BigDecimal) extends ChildActivitySet {
  require(percent between (0, 1))
}

/**Factory methods for child activity sets*/
object ChildActivitySet {
  /**All children*/
  def all = ChildActivitySetAll

  /**At least one child*/
  def any = ChildActivitySetAny

  /**Exactly 0 children*/
  def none = ChildActivitySetNone

  /**At least 'count' children*/
  def atLeastCount(count: Int) = ChildActivitySetAtLeastCount(count)

  /**At least 'percent' % of children*/
  def atLeastPercent(percent: BigDecimal) = ChildActivitySetAtLeastPercent(percent)

  /**Get the child activity set by name and optional parameters*/
  def parse(name: String, count: Option[Int] = None, percent: Option[BigDecimal] = None) = {
    name match {
      case "all"            => all
      case "any"            => any
      case "none"           => none
      case "atLeastCount"   => atLeastCount(count.get)
      case "atLeastPercent" => atLeastPercent(percent.get)
    }
  }
}
