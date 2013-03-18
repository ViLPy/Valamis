package com.arcusys.learn.scorm.manifest.service

import com.arcusys.learn.scorm.manifest.model._
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration

class OrganizationsService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  val jsonModel = new JsonModelBuilder[Organization](organization => Map("id" -> organization.id, "title" -> organization.title))

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  get("/package/:packageID") {
    val packageID = parameter("packageID").intRequired
    jsonModel(activityStorage getAllOrganizations packageID)
  }
}