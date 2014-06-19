package com.arcusys.learn.view

import javax.portlet.GenericPortlet
import javax.portlet.PortletContext
import javax.servlet.ServletContext
import org.scalatra._
import java.io.FileInputStream

trait TemplateCoupler {
  self: ScalatraBase =>
  def getTemplate(path: String): String = {
    if (isPortletContext) templateForPortlet(path, this.asInstanceOf[GenericPortlet].getPortletContext)
    else {
      val context = this match {
        case f: ScalatraFilter  => f.servletContext
        case s: ScalatraServlet => s.servletContext
      }
      templateForServlet(path, context)
    }
  }

  private def isPortletContext = this.isInstanceOf[GenericPortlet] && this.asInstanceOf[GenericPortlet].getPortletConfig != null

  private def templateForPortlet(templatePath: String, context: PortletContext) = templateFromRealPath(context.getRealPath(templatePath))

  private def templateForServlet(templatePath: String, context: ServletContext) = templateFromRealPath(context.getRealPath(templatePath))

  private def templateFromRealPath(templateRealPath: String) = {
    val resourceStream = new FileInputStream(templateRealPath)
    val template = scala.io.Source.fromInputStream(resourceStream).mkString
    resourceStream.close()
    template
  }
}