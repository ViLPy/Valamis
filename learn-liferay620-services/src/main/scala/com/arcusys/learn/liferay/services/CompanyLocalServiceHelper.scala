package com.arcusys.learn.liferay.services

import com.liferay.portal.model.Company
import com.liferay.portal.service.CompanyLocalServiceUtil

object CompanyLocalServiceHelper {
  def getCompanies: java.util.List[Company] = CompanyLocalServiceUtil.getCompanies
}
