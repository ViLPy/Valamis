package com.arcusys.learn.liferay.services

import com.liferay.portal.model.ResourceAction
import com.liferay.portal.service.ResourceActionLocalServiceUtil

object ResourceActionLocalServiceHelper {

  def getResourceAction(name: String, action: String): ResourceAction = {
    ResourceActionLocalServiceUtil.getResourceAction(name, action)
  }

}
