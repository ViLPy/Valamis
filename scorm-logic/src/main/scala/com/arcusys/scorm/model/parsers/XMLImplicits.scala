package com.arcusys.scorm.model.parsers

import scala.xml.Elem

object XMLImplicits {
  implicit def pimp(elem:Elem) = new {
    def %!(name: String) = {
      val attr = elem \ ("@"+name)
      if (attr.length == 0) throw new SCORMParserException("<" + elem.label + "> element does not contain `" + name + "` attribute")
      attr.text
    }

    def %!(name: (String, String)) = {
      val attr = elem \ ("@{"+name._1+"}"+name._2)
      if (attr.length == 0) throw new SCORMParserException("<" + elem.label + "> element does not contain `" + name._2 + "` attribute")
      attr.text
    }

    def %?(name: String) = {
      val attr = elem \ ("@"+name)
      if (attr.length == 0) None else Some(attr.text)
    }

    def %?(name: (String, String)) = {
      val attr = elem \ ("@{"+name._1+"}"+name._2)
      if (attr.length == 0) None else Some(attr.text)
    }

    def \!(name: String) = {
      val parentElementName = elem.label
      val childElements =elem \ name
      if (childElements.length == 0) throw new SCORMParserException("<" + parentElementName + "> element does not contain <" + name + "> element")
      if (childElements.size > 1) throw new SCORMParserException("<" + parentElementName + "> element contains more than one <" + name + "> element")
      childElements.head.asInstanceOf[Elem]
    }

    def \!(name: (String, String)) = {
      val parentElementName = elem.label
      val childElements =(elem \ name._2).filter(n=>n.prefix==name._1)
      if (childElements.length == 0) throw new SCORMParserException("<" + parentElementName + "> element does not contain <" + name + "> element")
      if (childElements.size > 1) throw new SCORMParserException("<" + parentElementName + "> element contains more than one <" + name + "> element")
      childElements.head.asInstanceOf[Elem]
    }

    def \?(name: String) = {
      val parentElementName = elem.label
      val childElements =elem \ name
      if (childElements.size > 1) throw new SCORMParserException("<" + parentElementName + "> element contains more than one <" + name + "> element")
      if (childElements.length == 0) None else Some(childElements.head.asInstanceOf[Elem])
    }

    def \?(name: (String, String)) = {
      val parentElementName = elem.label      
      val childElements =(elem \ name._2).filter(n=>n.prefix==name._1)
      if (childElements.size > 1) throw new SCORMParserException("<" + parentElementName + "> element contains more than one <" + name + "> element")
      if (childElements.length == 0) None else Some(childElements.head.asInstanceOf[Elem])
    }

    def \!!(name: String) = {
      val parentElementName = elem.label
      val childElements =elem \ name
      if (childElements.length == 0) throw new SCORMParserException("<" + parentElementName + "> element does not contain <" + name + "> element")
      childElements.toSeq.map(_.asInstanceOf[Elem])
    }

    def \!!(name: (String, String)) = {
      val parentElementName = elem.label
      val childElements =(elem \ name._2).filter(n=>n.prefix==name._1)
      if (childElements.length == 0) throw new SCORMParserException("<" + parentElementName + "> element does not contain <" + name + "> element")
      childElements.toSeq.map(_.asInstanceOf[Elem])
    }

    def \(name: (String, String)) = {
      val parentElementName = elem.label
      val childElements =(elem \ name._2).filter(n=>n.prefix==name._1)
      childElements.toSeq.map(_.asInstanceOf[Elem])
    }

   /* def \!(name: (String,String)) = {
      val parentElementName = elem.label
      val childElements =elem \ name
      if (childElements.length == 0) throw new SCORMParserException("<" + parentElementName + "> element does not contain <" + name + "> element")
      if (childElements.size > 1) throw new SCORMParserException("<" + parentElementName + "> element contains more than one <" + name + "> element")
      childElements.head.asInstanceOf[Elem]
    }*/
  }
}
