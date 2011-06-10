package com.arcusys.scorm.portlet
import javax.portlet._

class UserView extends GenericPortlet
{
  override def doView(request: RenderRequest, response: RenderResponse) =
  {    
    val out = response.getWriter
    out.println(scala.io.Source.fromFile(getPortletContext.getRealPath("index.html")).mkString)
    out.println("<input type='hidden' id='SCORMUserID' value ="+request.getRemoteUser()+">");
  }
  
  override def doEdit(request: RenderRequest, response: RenderResponse) =
  {    
    val out = response.getWriter
    out.println(scala.io.Source.fromFile(getPortletContext.getRealPath("scorm_admin.html")).mkString)
    out.println("<input type='hidden' id='SCORMUserID' value ="+request.getRemoteUser()+">");
  }
}