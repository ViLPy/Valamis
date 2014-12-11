package com.arcusys.learn.controllers.api.tincan

import com.arcusys.learn.controllers.api.BaseApiController
import com.arcusys.learn.facades.tincan.TincanTestFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.tincan.api.utils.TincanMethodOverride
import com.escalatesoft.subcut.inject.BindingModule

// http://example.com/xAPI/about
class TincanAboutApiController(configuration: BindingModule) extends BaseApiController(configuration) with TincanMethodOverride {
  def this() = this(Configuration)

  private lazy val tincanTestFacade = inject[TincanTestFacadeContract]

  after() {
    response.addHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.addHeader("Expires", "-1")
    response.addHeader("Access-Control-Allow-Origin", "*")
  }

  options() {
    response.setHeader("Access-Control-Allow-Methods", "HEAD,GET,POST,PUT,DELETE")
    response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length,Authorization,If-Match,If-None-Match,X-Experience-API-Version,X-Experience-API-Consistent-Through")
    response.setHeader("Access-Control-Expose-Headers", "ETag,Last-Modified,Cache-Control,Content-Type,Content-Length,WWW-Authenticate,X-Experience-API-Version,X-Experience-API-Consistent-Through")
  }

  get("/about(/)") {
    val res = """{
                |  "extensions" : {
                |    "http://id.tincanapi.com/extension/powered-by" : {
                |      "name" : "Valamis Tin Can Engine",
                |      "homePage" : "http://www.valamislearning.com/",
                |      "version" : "2.2.0"
                |    }
                |  },
                |  "version" : [ "1.0.1" ]
                |}""".stripMargin
    halt(200, res, reason = "OK")
  }

  //  initRotes()
  //
  //  get("/init") {
  //    initRotes()
  //  }

  private def initRotes() {

    get("/test") {
      tincanTestFacade.runTests(response.getWriter)
    }
  }
}