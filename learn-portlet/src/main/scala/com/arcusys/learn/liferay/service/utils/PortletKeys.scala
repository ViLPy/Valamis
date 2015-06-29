package com.arcusys.learn.liferay.service.utils

import com.arcusys.learn.liferay.constants.PortletConstantsHelper

object PortletKeys {
  final val SCORM_PACKAGE: String = "SCORMApplication_WAR_learnportlet"
  final val SCORM_PACKAGE_ADMIN: String = "PackageManager_WAR_learnportlet"
  final val SCORM_PACKAGE_DEFAULT_INSTANCE: String = PortletKeys.SCORM_PACKAGE + PortletConstantsHelper.INSTANCE_SEPARATOR + "0000"
}
