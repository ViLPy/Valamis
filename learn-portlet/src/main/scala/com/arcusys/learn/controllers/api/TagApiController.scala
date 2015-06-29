package com.arcusys.learn.controllers.api

import com.arcusys.learn.facades.TagFacadeContract
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.permission.PermissionUtil
import com.arcusys.learn.web.ServletBase
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.models.request.TagRequest
import PermissionUtil._

/**
 * Created by Yuriy Gatilin on 26.01.15.
 */
class TagApiController(configuration: BindingModule) extends BaseApiController(configuration) with ServletBase {
  def this() = this(Configuration)

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  options() {
    response.setHeader("Access-Control-Allow-Methods", "HEAD,GET,POST,PUT,DELETE")
    response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length,Authorization,If-Match,If-None-Match,X-Experience-API-Version,X-Experience-API-Consistent-Through")
    response.setHeader("Access-Control-Expose-Headers", "ETag,Last-Modified,Cache-Control,Content-Type,Content-Length,WWW-Authenticate,X-Experience-API-Version,X-Experience-API-Consistent-Through")
  }

  private val tagFacade = inject[TagFacadeContract]

  //List Action
  get("/tags(/)")(jsonAction {
    val tagRequest = TagRequest(this)
    val companyId = getCompanyId.toInt
    tagFacade.getAll(companyId)
  })
  //
  //  //Assign Action
  //  post("/tags/:tagId(/)")(jsonAction {
  //
  //  })
  //
  //  //Unassign Action
  //  delete("/tags/:tagId(/)")(jsonAction {
  //
  //  })

}
