package com.arcusys.scorm.portlet
import javax.portlet._

class AdminView extends GenericPortlet
{
  override def doView(request: RenderRequest, response: RenderResponse) =
  {    
    val out = response.getWriter
    out.println(scala.io.Source.fromFile(getPortletContext.getRealPath("scorm_admin.html")).mkString)
  }
}