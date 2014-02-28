package com.arcusys.learn.liferay.services

import com.liferay.portal.model.Organization
import com.liferay.portal.service.{ServiceContext, OrganizationLocalServiceUtil}

object OrganizationLocalServiceHelper {
  def getOrganizations(start: Int, end: Int): java.util.List[Organization] =
    OrganizationLocalServiceUtil.getOrganizations(start, end)

  def getOrganization(organizationId: Long): Organization = OrganizationLocalServiceUtil.getOrganization(organizationId)

  def deleteOrganization(organization: Organization) = OrganizationLocalServiceUtil.deleteOrganization(organization)

  def addOrganization(userId: Long,
                      parentOrganizationId: Long,
                      name: String,
                      orgType: String,
                      recursable: Boolean,
                      regionId: Long,
                      countryId: Long,
                      statusId: Int,
                      comments: String,
                      site: Boolean,
                      serviceContext: ServiceContext) =
    OrganizationLocalServiceUtil.addOrganization(userId, parentOrganizationId, name, orgType, recursable, regionId,
      countryId, statusId, comments, site, serviceContext)
}
