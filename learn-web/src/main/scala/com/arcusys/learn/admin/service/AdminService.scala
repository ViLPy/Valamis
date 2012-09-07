package com.arcusys.learn.admin.service

import java.io._
import java.util.Properties
import com.arcusys.scorm.util.PropertyUtil
import com.arcusys.learn.storage.impl.orbroker.BrokerFactory
import com.arcusys.scorm.util.FileSystemUtil
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration

class AdminService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)
  post("/UpdateSettings") {
    val serverName = parameter("ServerName").required
    val dbName = parameter("DBName").required
    val login = parameter("Login") withDefault ""
    val passwd = parameter("Password") withDefault ""

    val properties = new Properties
    properties.setProperty("server", serverName)
    properties.setProperty("database", dbName)
    properties.setProperty("login", login)
    properties.setProperty("password", passwd)
    PropertyUtil.store("db", properties)
    BrokerFactory.init(PropertyUtil.load("db"))
  }

  get("/GetSettings") {
    val properties = PropertyUtil.load("db")
    json(Map("server" -> properties.getProperty("server", ""),
      "database" -> properties.getProperty("database", ""),
      "login" -> properties.getProperty("login", ""),
      "password" -> properties.getProperty("password", "")))
  }

  post("/RenewDatabase") {
    contentType = "text/plain"
    storageFactory.renewWholeStorage()
    if (emptyDir(new File(FileSystemUtil.getRealPath("/SCORMData/data"))))
      "yep"
    else
      throw new Exception("Can't remove all files!")
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
