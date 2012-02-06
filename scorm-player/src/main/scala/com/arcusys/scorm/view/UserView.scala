package com.arcusys.scorm.view
import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import org.scalatra.ScalatraFilter

class UserView extends GenericPortlet with ScalatraFilter with MustacheSupport {
  override def destroy {}
  
  override def doView(request: RenderRequest, response: RenderResponse) =
  {
    val out = response.getWriter
    val path = request.getContextPath
    out.println(generateResponse(path, "index.html", true, request.isUserInRole("administrator")))
  }
  
  override def doEdit(request: RenderRequest, response: RenderResponse) =
  {    
    val out = response.getWriter
    val path = request.getContextPath
    out.println(generateResponse(path, "scorm_admin.html", true, request.isUserInRole("administrator")))
  }
  
  get("/view") {
    val path = servletContext.getContextPath
    generateResponse(path, "index.html", false, true)
  }
  
  get("/ScormAdmin") {
    val path = servletContext.getContextPath
    generateResponse(path, "scorm_admin.html", false, true)
  }
  
  def generateResponse(contextPath: String, templateName: String, isPortlet: Boolean, isAdmin: Boolean) = {
    val data = Map("contextPath"->contextPath, "isAdmin"->isAdmin, "isPortlet"->isPortlet)
    mustache(data, templateName)
  }
}