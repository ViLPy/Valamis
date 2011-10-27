package com.arcusys.scorm.service

import java.io._
import java.util.Properties
import com.arcusys.scorm.service.StorageFactory._
import com.arcusys.scorm.util.JSON._
import com.arcusys.scorm.util.PropertyUtil
import com.arcusys.scorm.storage.impl.orbroker.BrokerFactory
import org.scalatra.ScalatraServlet
import com.arcusys.scorm.service.util.PathBuilder

class AdminService extends ScalatraServlet
{
  post("/UpdateDBInfo") {
    val serverName = params.getOrElse("ServerName", halt(405, "Server is not specified"))
    val dbName = params.getOrElse("DBName", halt(405, "DB is not specified"))
    val login = params.getOrElse("Login", "")
    val passwd = params.getOrElse("Password", "")
      
    val properties = new Properties
    properties.setProperty("server", serverName)
    properties.setProperty("database", dbName)
    properties.setProperty("login", login)
    properties.setProperty("password", passwd)
    PropertyUtil.store("db",properties)
    BrokerFactory.refresh
  }
  
  get("/GetDBInfo") {
    val properties = PropertyUtil.load("db")
    toJSON(Map("server" -> properties.getProperty("server", ""),
               "database" -> properties.getProperty("database", ""),
               "login" -> properties.getProperty("login", ""),
               "password" -> properties.getProperty("password", "")))
  }
  
  post("/RenewDatabase") {
    contentType = "text/plain"
    getPackageStorage.renewTotally
    if (emptyDir(new File(PathBuilder.outputRealDir + "/data")))
      "yep"
    else
      throw new Exception("Can't remove all files!")
  }
  
//-----
  private def emptyDir(dir:File): Boolean = {
    if (dir.isDirectory)
      for (item<-dir.list()) 
        if (!deleteDir(new File(dir, item))) return false
    true
  }
  
  private def deleteDir(dir:File):Boolean = {
    if (dir.isDirectory)
      for (item<-dir.list()) 
        if (!deleteDir(new File(dir, item))) return false
    dir.delete
  }
}
