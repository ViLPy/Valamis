package com.arcusys.learn.admin.service

import javax.servlet.{ServletRequest, ServletResponse, GenericServlet}
import org.scala_tools.subcut.inject.Injectable
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.ioc.Configuration
import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}


class BadgeImageService extends HttpServlet with Injectable {
  implicit val bindingModule = Configuration
  val storageFactory = inject[StorageFactoryContract]

  override def doGet(request: HttpServletRequest, response: HttpServletResponse) {
    val directory = request.getParameter("directory")
    val fileName = request.getParameter("fileName")
    response.setCharacterEncoding(null)
    response.setContentType("image/png")
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
    response.getOutputStream.write(storageFactory.fileStorage.getFile("files/" + directory + "/" + fileName).get.content.get)
  }
}