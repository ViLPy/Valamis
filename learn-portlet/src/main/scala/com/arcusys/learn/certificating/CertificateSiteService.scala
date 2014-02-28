package com.arcusys.learn.certificating

import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.scorm.tracking.model.certificating.CertificateSite
import com.arcusys.learn.liferay.services.GroupLocalServiceHelper
import com.arcusys.learn.liferay.LiferayClasses.LNoSuchGroupException

/**
 * User: Yulia.Glushonkova
 * Date: 14.06.13
 */
class LiferaySite(
                   val id: Int,
                   val certificateID: Int,
                   val siteID: Long,
                   val url: String,
                   val title: String,
                   val description: String
                   )

class CertificateSiteService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._


  val jsonModel = new JsonModelBuilder[com.arcusys.learn.certificating.LiferaySite](site => {
    Map("id" -> site.id,
      "certificateID" -> site.certificateID,
      "siteID" -> site.siteID,
      "url" -> site.url,
      "title" -> site.title,
      "description" -> site.description.replace("\n", " "))
  })

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  get("/:certificateID") {
    requireTeacherPermissions()
    val certificateID = parameter("certificateID").intRequired

    jsonModel(certificateSiteStorage.getByCertificate(certificateID).map(site => {
      val item =
        try {
          val group = GroupLocalServiceHelper.getGroup(site.siteID)
          new LiferaySite(site.id, certificateID, group.getGroupId, group.getFriendlyURL, group.getDescriptiveName, group.getDescription)
        }
        catch {
          case e: LNoSuchGroupException => {
            System.out.println("Liferay site " + site.siteID + " not found")
            null
          }
        }
      item
    })
      .filter(item => item != null))
  }

  post("/addSite/:certificateID") {
    requireTeacherPermissions()

    val certificateID = parameter("certificateID").intRequired
    val siteID = parameter("siteID").intRequired
    val id = certificateSiteStorage.createAndGetID(new CertificateSite(0, certificateID, siteID, 0))
    id
  }

  post("/delete/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    certificateSiteStorage.delete(id)
  }

  post("/move/:id") {
    requireTeacherPermissions()

    val siteIDs = parameter("siteIDs").required
    val id = parameter("id").intRequired

    var index = 1
    siteIDs.split(',').foreach(siteID => {
      certificateSiteStorage.move(id, siteID.split('_').last.toInt, index)
      index = index + 1
    })

  }
}
