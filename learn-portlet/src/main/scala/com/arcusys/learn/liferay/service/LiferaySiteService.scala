package com.arcusys.learn.liferay.service

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.constants.QueryUtilHelper
import com.arcusys.learn.liferay.services.GroupLocalServiceHelper
import com.arcusys.learn.liferay.LiferayClasses.LGroup

class LiferaySiteService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  val jsonModel = new JsonModelBuilder[LGroup](site =>
    Map(
      "siteID" -> site.getGroupId,
      "title" -> site.getDescriptiveName,
      "url" -> site.getFriendlyURL,
      "description" -> site.getDescription.replace("\n", " ")
  ))

  get("/") {
    val companyId = parameter("companyID").longRequired
    jsonModel(getSites(companyId))
  }

  private def getSites(companyId: Long) = {
    GroupLocalServiceHelper.getCompanyGroups(companyId, QueryUtilHelper.ALL_POS,  QueryUtilHelper.ALL_POS).toArray.filter(x => {
      val site = x.asInstanceOf[LGroup]
      val url = site.getFriendlyURL
      site.isSite && site.isActive &&
      //remove control panel
        url != "/control_panel"
    }).map(i => i.asInstanceOf[LGroup])
  }
}
