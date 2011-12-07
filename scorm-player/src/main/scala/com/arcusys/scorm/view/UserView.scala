package com.arcusys.scorm.view
import mustache.Mustache
import javax.portlet._
import org.scalatra.ScalatraFilter

class UserView extends GenericPortlet with ScalatraFilter {
  override def destroy {}
  
  override def doView(request: RenderRequest, response: RenderResponse) =
  {
    val out = response.getWriter
    val path = request.getContextPath
    out.println(generateResponse(path, getPortletContext.getRealPath("/index.html"), true))
  }
  
  override def doEdit(request: RenderRequest, response: RenderResponse) =
  {    
    val out = response.getWriter
    val path = request.getContextPath
    out.println(generateResponse(path, getPortletContext.getRealPath("/scorm_admin.html"), true))
  }
  
  get("/") {
    val path = servletContext.getContextPath
    generateResponse(path, servletContext.getRealPath("index.html"), false)
  }
  
  get("/ScormAdmin") {
    val path = servletContext.getContextPath
    generateResponse(path, "/scorm_admin.html", false)
  }
  
  def generateResponse(contextPath: String, templateName: String, isPortlet: Boolean) = {
    val template = new Mustache(scala.io.Source.fromFile(templateName).mkString)
    template.render(Map("contextPath"->contextPath) + (if (isPortlet) ("isPortlet"->true) else ("isServlet"->true)) )
  }
}