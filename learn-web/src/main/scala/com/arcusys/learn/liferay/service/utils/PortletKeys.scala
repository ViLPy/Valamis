package com.arcusys.learn.liferay.service.utils

import com.liferay.portal.model.PortletConstants

object PortletKeys {
  final val SCORM_PACKAGE: String = "SCORMApplication_WAR_learnweb"
  final val SCORM_PACKAGE_ADMIN: String = "SCORMApplicationAdmin_WAR_learnweb"
  final val SCORM_PACKAGE_DEFAULT_INSTANCE: String = PortletKeys.SCORM_PACKAGE + PortletConstants.INSTANCE_SEPARATOR + "0000"
}
