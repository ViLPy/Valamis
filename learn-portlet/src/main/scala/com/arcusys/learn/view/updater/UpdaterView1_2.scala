package com.arcusys.learn.view.updater

import com.arcusys.scala.scalatra.mustache.MustacheSupport
import javax.portlet._
import org.scalatra.ScalatraFilter
import com.arcusys.learn.storage.impl.orbroker.StorageFactory
import java.io.File
import com.arcusys.learn.scorm.manifest.model.ScopeType
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.learn.storage.DBType

class UpdaterView1_2 extends GenericPortlet with ScalatraFilter with MustacheSupport {
  override def destroy() {}

  val fileStorage = StorageFactory.fileStorage
  val storageUpdater = StorageFactory.storageUpdater

  override def doView(request: RenderRequest, response: RenderResponse) {
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val scopeID = themeDisplay.getScopeGroupId

    val data = Map("contextPath" -> request.getContextPath,
      "isAdmin" -> request.isUserInRole("administrator"),
      "actionURL" -> response.createResourceURL(),
      "scopeID" -> scopeID)
    response.getWriter.println(mustache(data, "updater12.html"))
  }

  override def serveResource(request: ResourceRequest, response: ResourceResponse) {
    if (StorageFactory.dbType == DBType.Postgres) {
      System.out.println("Updating to version 1.2.1")
      storageUpdater.updateTo1_2()
      val packages = StorageFactory.packageStorage.getAll
      val packageScopeStorage = StorageFactory.packageScopeRuleStorage
      packages.foreach(pkg => {
        if (packageScopeStorage.get(pkg.id).isEmpty) packageScopeStorage.create(pkg.id, ScopeType.Site, Some(request.getParameter("scopeID")), visibility = false, isDefault = false)
      })

      val dataDir = new File(getPortletContext.getRealPath("SCORMData"))
      dataDir.listFiles().foreach(f => if (f.isDirectory
        && (f.getName.equalsIgnoreCase("data")
        || f.getName.equalsIgnoreCase("images")
        || f.getName.equalsIgnoreCase("thumb")
        || f.getName.equalsIgnoreCase("files"))) {
        recursiveListFiles(f).foreach(file => {
          if (!file.isDirectory) {
            val filename = file.getCanonicalPath.replaceFirst(dataDir.getCanonicalPath + "/", "")
            val source = scala.io.Source.fromFile(file)(scala.io.Codec.ISO8859)
            val content = source.map(_.toByte).toArray
            source.close()
            fileStorage.store(filename, content)
          }
        })
      })
    }
  }

  private def recursiveListFiles(f: File): Array[File] = {
    val these = f.listFiles
    these ++ these.filter(_.isDirectory).flatMap(recursiveListFiles)
  }
}