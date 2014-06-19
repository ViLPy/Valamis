package com.arcusys.learn.liferay.services

import com.liferay.portal.service.ResourceLocalServiceUtil

object ResourceLocalServiceHelper {
  def addResources(companyId: Long,
    groupId: Long,
    userId: Long,
    name: String,
    primKey: String,
    portletActions: Boolean,
    addGroupPermissions: Boolean,
    addGuestPermissions: Boolean) {
    ResourceLocalServiceUtil.addResources(companyId, groupId, userId, name, primKey, portletActions, addGroupPermissions, addGuestPermissions)
  }
}
