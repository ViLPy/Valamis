package com.arcusys.scorm.portlet
import javax.portlet._

class QuestionBankView extends GenericPortlet
{
  override def doView(request: RenderRequest, response: RenderResponse) =
  {    
    val out = response.getWriter
    out.println(scala.io.Source.fromFile(getPortletContext.getRealPath("scorm_questionbank.html")).mkString)
    out.println("<input type='hidden' id='SCORMContextPath' value ="+request.getContextPath+">");
  }
}