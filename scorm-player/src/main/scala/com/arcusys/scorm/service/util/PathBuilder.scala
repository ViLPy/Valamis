/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.arcusys.scorm.service.util

import java.util.Properties

object PathBuilder
{
  // get real path to .class file
  val sourceLocation = getClass.getProtectionDomain.getCodeSource.getLocation.getPath
  // extract path to SCORM packages data directory
  lazy val outputRealDir = sourceLocation.substring(0, sourceLocation.lastIndexOf("/WEB-INF")) + "/SCORMData/"
  lazy val outputWebDir = {
    val properties = new Properties
    val resourceStream = Thread.currentThread.getContextClassLoader.getResourceAsStream("resources.properties")
    properties.load(resourceStream)
    properties.getProperty("outputWebDir","")
  }


  def buildRealPath(packageID: Int, resourceHref: String, manifestBase: String = "", resourceBase: String = ""):String =
  {
    (outputRealDir + "data/" + 
     packageID.toString + "/" + 
     (if (!manifestBase.isEmpty) {manifestBase + "/"} else "") + 
     (if (!resourceBase.isEmpty) {resourceBase + "/"} else "") + 
     resourceHref)
  }
  
  def buildURL(packageID: Int, resourceHref: String, manifestBase: String, resourceBase: String):String =
  {
    (outputWebDir + "data/" + 
     packageID.toString + "/" + 
     (if (!manifestBase.isEmpty) {manifestBase + "/"} else "") + 
     (if (!resourceBase.isEmpty) {resourceBase + "/"} else "") + 
     resourceHref)
  }
}