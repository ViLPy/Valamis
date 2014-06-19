package com.arcusys.learn.scorm.manifest.parser

import scala.xml.Elem

class ElemValue

class StringValue

class IntValue

class BigDecimalValue

class Attribute(elem: Option[Elem], namespace: Option[String], name: String) {
  private val qualifiedName = namespace match {
    case None     => name.trim
    case Some(ns) => "{" + ns + "}" + name
  }

  private def attr = elem.get \ ("@" + qualifiedName)

  def required(string: StringValue): String =
    if (elem.isEmpty) throw new SCORMParserException("Parent element does not exist for attribute '" + name + "'")
    else if (attr.length == 0) throw new SCORMParserException("<" + elem.get.label + "> element does not contain '" + name + "' attribute")
    else attr.text

  def requiredEnum[T <: Enumeration](enumeration: T): T#Value = enumeration.withName(required(XMLImplicits.string)).asInstanceOf[T#Value]

  def optional(string: StringValue): Option[String] = if (elem.isEmpty || attr.length == 0) None else Some(attr.text)

  def optional(int: IntValue): Option[Int] = if (elem.isEmpty || attr.length == 0) None else Some(attr.text.toInt)

  def optional(bigDecimal: BigDecimalValue): Option[BigDecimal] = if (elem.isEmpty || attr.length == 0) None else Some(BigDecimal(attr.text))

  def withDefault(default: String): String = if (elem.isEmpty || attr.length == 0) default else attr.text

  def withDefault(default: Boolean): Boolean = if (elem.isEmpty || attr.length == 0) default else attr.text.toBoolean

  def withDefault(default: Int): Int = if (elem.isEmpty || attr.length == 0) default else attr.text.toInt

  def withDefault(default: BigDecimal): BigDecimal = if (elem.isEmpty || attr.length == 0) default else BigDecimal(attr.text)

  def withDefault[T <: Enumeration](enumeration: T, default: T#Value): T#Value = if (elem.isEmpty || attr.length == 0) default else enumeration.withName(attr.text).asInstanceOf[T#Value]
}

class Child(elem: Elem, namespace: Option[String], name: String) {
  def required(ignore: ElemValue): Elem =
    optional(ignore).getOrElse(throw new SCORMParserException("<" + elem.label + "> element does not contain <" + name + "> element"))

  def required(ignore: StringValue): String = required(XMLImplicits.element).text.trim

  def withDefault(default: BigDecimal) = optional(XMLImplicits.bigDecimal).getOrElse(default)

  def withDefault(default: String) = optional(XMLImplicits.string).getOrElse(default)

  def optionalEnum[T <: Enumeration](enumeration: T): Option[T#Value] = optional(XMLImplicits.string) map (enumeration.withName(_).asInstanceOf[T#Value])

  def optional(ignore: StringValue): Option[String] = optional(XMLImplicits.element) map (_.text.trim)

  def optional(ignore: BigDecimalValue): Option[BigDecimal] = optional(XMLImplicits.string) map (BigDecimal(_))

  def optional(ignore: IntValue): Option[Int] = optional(XMLImplicits.int) map (_.toInt)

  def optional[T](transform: Elem => T): Option[T] = optional(XMLImplicits.element) map transform

  def optional(ignore: ElemValue): Option[Elem] = {
    val allChildElements = elem \ name
    val childElements = namespace match {
      case None     => allChildElements
      case Some(ns) => allChildElements.filter(n => n.prefix == ns)
    }
    //if (childElements.length == 0) throw new SCORMParserException("<" + parentElementName + "> element does not contain <" + name + "> element")
    if (childElements.size > 1) throw new SCORMParserException("<" + elem.label + "> element contains more than one <" + name + "> element")
    childElements.headOption map (_.asInstanceOf[Elem])
  }
}

object XMLImplicits {
  val string = new StringValue
  val int = new IntValue
  val bigDecimal = new BigDecimalValue
  val element = new ElemValue

  implicit def pimpElem(elem: Elem) = new {
    def attr(name: String) = new Attribute(Some(elem), None, name)

    def attr(namespace: String, name: String) = new Attribute(Some(elem), Some(namespace), name)

    def childElem(name: String) = new Child(elem, None, name)

    def childElem(namespace: String, name: String) = new Child(elem, Some(namespace), name)

    def children(name: String) = (elem \ name).toSeq.map(_.asInstanceOf[Elem])

    def children(name: (String, String)) = (elem \ name._2).filter(n => n.prefix == name._1).toSeq.map(_.asInstanceOf[Elem])
  }

  implicit def pimpElemOption(elem: Option[Elem]) = new {
    def attr(name: String) = new Attribute(elem, None, name)

    def attr(namespace: String, name: String) = new Attribute(elem, Some(namespace), name)

    def children(name: String) = elem match {
      case None    => Nil
      case Some(e) => (e \ name).toSeq.map(_.asInstanceOf[Elem])
    }

    def children(name: (String, String)) = elem match {
      case None    => Nil
      case Some(e) => (e \ name._2).filter(n => n.prefix == name._1).toSeq.map(_.asInstanceOf[Elem])
    }
  }
}
