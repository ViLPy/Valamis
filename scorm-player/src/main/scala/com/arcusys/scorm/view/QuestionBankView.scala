package com.arcusys.scorm.view
import mustache.Mustache
import javax.portlet._
import org.scalatra.ScalatraFilter

class QuestionBankView extends GenericPortlet with ScalatraFilter {
  override def destroy {}
  
  override def doView(request: RenderRequest, response: RenderResponse) =
  {
    val out = response.getWriter
    val contextPath = request.getContextPath
    out.println(generateResponse(contextPath, getPortletContext.getRealPath("/scorm_questionbank.html"), true))
  }
  
  get("/QuestionBank") {
    contentType="text/html"
    val contextPath = servletContext.getContextPath
    generateResponse(contextPath, servletContext.getRealPath("scorm_questionbank.html"), false)
  }
  
  def generateResponse(contextPath: String, templateName: String, isPortlet: Boolean) = {
    val template = new Mustache(scala.io.Source.fromFile(templateName).mkString)
    val data = Map("contextPath"->contextPath) + (if (isPortlet) ("isPortlet"->true) else ("isServlet"->true))
    template.render(data)
  }
}