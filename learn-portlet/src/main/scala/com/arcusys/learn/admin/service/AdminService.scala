package com.arcusys.learn.admin.service

import java.io._
import java.util.Properties
import com.arcusys.scorm.util.PropertyUtil
import com.arcusys.scorm.util.FileSystemUtil
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.{DemoService, ServletBase}
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.settings.model.SettingType
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.liferay.portlet.social.model.SocialActivity
import com.arcusys.learn.tincan.model._
import com.arcusys.learn.tincan.model.UserBasicAuthorization
import com.arcusys.learn.tincan.model.LrsEndpointSettings
import com.arcusys.learn.service.util.TemplateUpgradeProcess

class AdminService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  post("/UpdateSettings") {
    /*requireAdmin()

    val serverName = parameter("ServerName").required
    val dbName = parameter("DBName").required
    val login = parameter("Login") withDefault ""
    val passwd = parameter("Password") withDefault ""
    val dbManagementSystem = parameter("dbManagementSystem") withDefault "h2"

    val properties = new Properties
    properties.setProperty("server", serverName)
    properties.setProperty("database", dbName)
    properties.setProperty("login", login)
    properties.setProperty("password", passwd)
    properties.setProperty("dbManagementSystem", dbManagementSystem)
    PropertyUtil.store("db", properties)
    BrokerFactory.init(PropertyUtil.load("db"))*/
  }

  post("/demo/templates") {
    requireAdmin()
    val templates = new TemplateUpgradeProcess
    templates.doUpgrade()
  }

  post("/TincanLrsSettings") {
    requireAdmin()

    parameter("isExternalLrs").option match {
      case Some("on") => {
        val endpoint = parameter("endpoint").required.trim
        val endpointFixed = if (endpoint.endsWith("/")) endpoint else endpoint + "/"
        //    parameter("authType").required match {
        //      case "Basic" =>
        if (parameter("commonCredentials").option.exists(_ == "on"))
          storageFactory.tincanLrsEndpointStorage.set(Some(LrsEndpointSettings(
            endpointFixed,
            CommonBasicAuthorization(parameter("loginName").required, parameter("password").required)
          )))
        else
          storageFactory.tincanLrsEndpointStorage.set(Some(LrsEndpointSettings(
            endpointFixed,
            UserBasicAuthorization
          )))
        //      case "OAuth" =>
        //        storageFactory.tincanLrsEndpointStorage.set(LrsEndpointSettings(
        //          parameter("endpoint").required,
        //          OAuthAuthorization(parameter("loginName").required, parameter("password").required)
        //        ))
        //    }
      }
      case _ => storageFactory.tincanLrsEndpointStorage.set(None)
    }
  }

  get("/GetSettings") {
    /*requireAdmin()

    val properties = PropertyUtil.load("db")
    json(Map("server" -> properties.getProperty("server", ""),
      "database" -> properties.getProperty("database", ""),
      "login" -> properties.getProperty("login", ""),
      "password" -> properties.getProperty("password", ""),
      "dbManagementSystem" -> properties.getProperty("dbManagementSystem", "h2")))*/
  }

  post("/RenewDatabase") {
    requireAdmin()

    contentType = "text/plain"
    storageFactory.renewWholeStorage()
    SocialActivityLocalServiceUtil.getActivities(classOf[Certificate].getName, 0, Int.MaxValue).toArray.foreach(i => {
      SocialActivityLocalServiceUtil.deleteActivity(i.asInstanceOf[SocialActivity].getActivityId)
    })
    if (emptyDir(new File(FileSystemUtil.getRealPath("/SCORMData/tmp"))))
      "yep"
    else
      throw new Exception("Can't remove all files!")
  }

  post("/UpdateIssuerSettings") {
    requireAdmin()

    storageFactory.settingStorage.modify(SettingType.IssuerName, parameter("issuerName").required)
    storageFactory.settingStorage.modify(SettingType.IssuerOrganization, parameter("issuerOrganization").required)
    storageFactory.settingStorage.modify(SettingType.IssuerURL, parameter("issuerUrl").required)
  }

  //-----
  private def emptyDir(dir: File): Boolean = {
    if (dir.isDirectory)
      for (item <- dir.list())
        if (!deleteDir(new File(dir, item))) return false
    true
  }

  private def deleteDir(dir: File): Boolean = {
    if (dir.isDirectory)
      for (item <- dir.list())
        if (!deleteDir(new File(dir, item))) return false
    dir.delete
  }
}
