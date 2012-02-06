package com.arcusys.scorm.view
import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import org.scalatra.ScalatraFilter

class QuestionBankView extends GenericPortlet with ScalatraFilter with MustacheSupport {
  override def destroy {}
  
  override def doView(request: RenderRequest, response: RenderResponse) =
  {
    val out = response.getWriter
    val contextPath = request.getContextPath
    out.println(generateResponse(contextPath, "scorm_questionbank.html", true))
  }
  
  before() {
    contentType="text/html"
  }
  
  get("/QuestionBank") {
    val contextPath = servletContext.getContextPath
    generateResponse(contextPath, "scorm_questionbank.html", false)
  }
  
  def generateResponse(contextPath: String, templateName: String, isPortlet: Boolean) = {
    val data = Map("contextPath"->contextPath, "isPortlet"->isPortlet)
    mustache(data, templateName)
  }
}