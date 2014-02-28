package com.arcusys.learn.view.tincan

import javax.portlet.{RenderResponse, RenderRequest}
import com.arcusys.learn.service.util.SessionHandlerContract
import com.arcusys.learn.view.BaseCurriculum
import com.arcusys.scorm.lms.ClientApiStoreManagerContract
import com.arcusys.scala.json.Json

//
// Created by iliya.tryapitsin on 14.02.14.
//
class ClientApiView extends BaseCurriculum {
  override def destroy() {}

  val clientApiStoreManager = inject[ClientApiStoreManagerContract]
  implicit val sessionHandler = inject[SessionHandlerContract]

  override def doView(request: RenderRequest, response: RenderResponse){
    val clients = clientApiStoreManager.getAll()

    super.renderAdminView(
      request,
      response,
      "client_api.html",
      Map("clients" -> Json.toJson(clients)))
  }
}
