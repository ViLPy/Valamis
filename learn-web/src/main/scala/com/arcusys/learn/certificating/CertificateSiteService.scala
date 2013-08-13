package com.arcusys.learn.certificating

import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.scorm.tracking.model.certificating.{CertificateSite, Certificate}
import com.liferay.portal.service.GroupLocalServiceUtil

/**
 * User: Yulia.Glushonkova
 * Date: 14.06.13
 */
class LiferaySite(
                   val id: Int,
                   val certificateID: Int,
                   val siteID: Long,
                   val url: String,
                   val title: String
                   )

class CertificateSiteService (configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._



  val jsonModel = new JsonModelBuilder[com.arcusys.learn.certificating.LiferaySite](site =>{
   val liferayGroup = GroupLocalServiceUtil.getGroup(site.siteID)

    Map("id" -> site.id,
      "certificateID" -> site.certificateID,
      "siteID" -> site.siteID,
      "url" -> site.url,
      "title" -> site.title,
      "description" -> (if (liferayGroup != null) liferayGroup.getDescription.replace("\n", " ") ))
  })

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  get("/:certificateID") {
    val certificateID = parameter("certificateID").intRequired
    jsonModel(certificateSiteStorage.getByCertificate(certificateID).map(site => {
      val group = GroupLocalServiceUtil.getGroup(site.siteID)
      new LiferaySite(site.id, certificateID, group.getGroupId, group.getFriendlyURL, group.getName)}))
  }

  post("/addSite/:certificateID"){
    val certificateID = parameter("certificateID").intRequired
    val siteID = parameter("siteID").intRequired
    val id = certificateSiteStorage.createAndGetID(new CertificateSite(0, certificateID, siteID, 0))
    id
  }

  post("/delete/:id"){
    val id = parameter("id").intRequired
    certificateSiteStorage.delete(id)
  }

  post("/move/:id"){
    val siteIDs = parameter("siteIDs").required
    val id = parameter("id").intRequired

    var index = 1;
    siteIDs.split(',').foreach(siteID => {
        certificateSiteStorage.move(id, siteID.split('_').last.toInt, index)
        index = index + 1
      })

  }
}
