package com.arcusys.learn.util

import com.arcusys.learn.util.mustache._

import javax.portlet.GenericPortlet
import javax.portlet.PortletContext
import javax.servlet.ServletContext

import org.scalatra.{ ScalatraServlet, ScalatraFilter, ScalatraBase }

trait MustacheSupport { self: ScalatraBase =>
  def mustache(viewModel: Any, templatePath: String, partialPaths: Map[String, String] = Map()): String = {
    val rootTemplate = mustacheTemplate(templatePath)
    val partialTemplates = partialPaths.map { case (key, path) => (key, mustacheTemplate(path)) }.toMap
    if (!isPortletContext) contentType = "text/html"
    rootTemplate.render(viewModel, partialTemplates)
  }

  def mustacheTemplate(templatePath: String) = {
    if (isPortletContext)
      templateForPorlet(templatePath, this.asInstanceOf[GenericPortlet].getPortletContext)
    else {
      val context = this match {
        case f: ScalatraFilter  => f.servletContext
        case s: ScalatraServlet => s.servletContext
      }
      templateForServlet(templatePath, context)
    }
  }

  private def isPortletContext = this.isInstanceOf[GenericPortlet] && this.asInstanceOf[GenericPortlet].getPortletConfig != null

  private def templateForPorlet(templatePath: String, context: PortletContext) = templateFromRealPath(context.getRealPath(templatePath))

  private def templateForServlet(templatePath: String, context: ServletContext) = templateFromRealPath(context.getRealPath(templatePath))

  private def templateFromRealPath(templateRealPath: String) = new Mustache(scala.io.Source.fromFile(templateRealPath).mkString)
}