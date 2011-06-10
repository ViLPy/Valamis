package com.arcusys.scorm.service

import java.io._
import java.util.Properties
import javax.ws.rs._
import javax.ws.rs.core._
import com.arcusys.scorm.service.StorageFactory._
import com.arcusys.scorm.service.JSON._
import com.arcusys.scorm.storage.impl.orbroker.BrokerFactory

@Path("/Administering")
class AdminService
{
  @POST
  @Path("/UpdateDBInfo")
  def updateDBInfo(@FormParam("ServerName") serverName:String,
                   @FormParam("DBName") dbName:String,
                   @FormParam("Login") login:String,
                   @FormParam("Password") passwd:String) = 
  {
    val properties = new Properties
    properties.setProperty("server", serverName)
    properties.setProperty("database", dbName)
    properties.setProperty("login", login)
    properties.setProperty("password", passwd)
    PropertyUtil.store("db",properties)
    BrokerFactory.refresh
  }
  
  @GET
  @Path("/GetDBInfo")
  def getDBInfo = 
  {
    val properties = PropertyUtil.load("db")
    val infoPack = toJSON(Map("server" -> properties.getProperty("server", ""),
                              "database" -> properties.getProperty("database", ""),
                              "login" -> properties.getProperty("login", ""),
                              "password" -> properties.getProperty("password", "")))
    infoPack
  }
  
  @GET
  @Path("/RenewDatabase")
  def renewAll = 
  {
    getPackageStorage.renewTotally
    if (emptyDir(new File(PathBuilder.outputRealDir + "/data")))
      Response.ok("yep").build
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
