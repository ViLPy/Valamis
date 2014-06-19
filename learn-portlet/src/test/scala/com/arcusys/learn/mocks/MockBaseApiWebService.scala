package com.arcusys.learn.mocks

import com.arcusys.learn.controllers.api.BaseApiController

trait MockBaseApiWebService extends BaseApiController {
  override def getTranslation = {
    Map[String, String]()
  }
}
