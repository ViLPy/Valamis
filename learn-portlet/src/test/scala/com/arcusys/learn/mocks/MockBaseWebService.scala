package com.arcusys.learn.mocks

import com.arcusys.learn.achievements.BaseWebService

trait MockBaseWebService extends BaseWebService{
  override def getTranslation = {
    Map[String, String]()
  }
}
