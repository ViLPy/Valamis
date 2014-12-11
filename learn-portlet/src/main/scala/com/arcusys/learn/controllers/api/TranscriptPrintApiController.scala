package com.arcusys.learn.controllers.api

import com.arcusys.learn.facades.TranscriptPrintFacadeContract
import com.arcusys.learn.models.request.{ PrintRequest, PrintActionType }
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration

class TranscriptPrintApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)

  val printFacade = inject[TranscriptPrintFacadeContract]

  before() {
    response.setHeader("Pragma", "no-cache")
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
    response.setHeader("Content-Disposition", "attachment; filename=\"transcript.pdf\"")
    response.setContentType("application/pdf")
    response.setCharacterEncoding("UTF-8")
  }

  get("/print(/)")(action {
    val printRequest = PrintRequest(this)
    printRequest.actionType match {
      case PrintActionType.PRINT_TRANSCRIPT => {
        val companyID = printRequest.companyId
        val userID = printRequest.userId

        val templatesPath = servletContext.getRealPath("WEB-INF/fop")

        val out = printFacade.printTranscript(companyID, userID, templatesPath)

        response.setContentLength(out.size())
        response.getOutputStream.write(out.toByteArray)
        response.getOutputStream.flush()
        response.getOutputStream.close()
        out.close()
      }
      case _ => new UnsupportedOperationException(s"Action ${printRequest.actionType} is not supported")
    }
  })
}
