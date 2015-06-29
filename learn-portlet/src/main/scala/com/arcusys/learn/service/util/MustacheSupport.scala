package com.arcusys.learn.service.util

import javax.portlet.{ GenericPortlet, PortletContext }
import javax.servlet.ServletContext
import com.arcusys.valamis.util.mustache.Mustache
import org.scalatra.{ ScalatraBase, ScalatraFilter, ScalatraServlet }

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