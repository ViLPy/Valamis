package com.arcusys.learn.view

import scala.collection.JavaConversions._
import javax.portlet.GenericPortlet
import javax.portlet.PortletContext
import javax.servlet.ServletContext
import org.scalatra._
import java.util.Properties
import java.io.{FileInputStream, InputStreamReader}

trait i18nSupport {
  self: ScalatraKernel =>
  def getTranslation(path: String): Map[String, String] = {
    val properties = if (isPortletContext) propertiesForPortlet(path, this.asInstanceOf[GenericPortlet].getPortletContext)
    else {
      val context = this match {
        case f: ScalatraFilter => f.servletContext
        case s: ScalatraServlet => s.servletContext
      }
      propertiesForServlet(path, context)
    }
    mapAsScalaMap(properties.asInstanceOf[java.util.Map[String, String]]).toMap
  }

  private def isPortletContext = this.isInstanceOf[GenericPortlet] && this.asInstanceOf[GenericPortlet].getPortletConfig != null

  private def propertiesForPortlet(templatePath: String, context: PortletContext) = propertiesFromRealPath(context.getRealPath(templatePath))

  private def propertiesForServlet(templatePath: String, context: ServletContext) = propertiesFromRealPath(context.getRealPath(templatePath))

  private def propertiesFromRealPath(templateRealPath: String) = {
    val properties = new Properties
    val resourceStream = new InputStreamReader(new FileInputStream(templateRealPath + ".properties"), "UTF-8")
    properties.load(resourceStream)
    resourceStream.close()
    properties
  }
}