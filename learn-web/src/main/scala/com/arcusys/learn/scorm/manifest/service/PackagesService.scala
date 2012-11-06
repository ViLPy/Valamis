package com.arcusys.learn.scorm.manifest.service

import com.arcusys.learn.scorm.manifest.model._
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.util.Extensions._
import com.arcusys.learn.liferay.service.asset.AssetHelper

class PackagesService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  val jsonModel = new JsonModelBuilder[Manifest](manifest =>
    Map("id" -> manifest.id,
      "title" -> manifest.title,
      "summary" -> manifest.summary,
      "visibility" -> manifest.visibility,
      "version" -> manifest.version)
  )

  get("/") {
    val userID = try {
      request.getHeader("scormUserID").toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests

    val jsonPackedModel = new JsonModelBuilder[Manifest](manifest => {
      val attempt = attemptStorage.getActive(userID, manifest.id)
      Map("id" -> manifest.id,
        "title" -> manifest.title,
        "summary" -> manifest.summary,
        "visibility" -> manifest.visibility,
        "version" -> manifest.version,
        "suspendedID" -> (if (attempt.isDefined) activityStateTreeStorage.get(attempt.get.id).map(_.suspendedActivity.map(_.item.activity.id)) else None),
        "attempted" -> attempt.isDefined)
    })

    jsonPackedModel(packageStorage.getOnlyVisible)
  }

  get("/all") {
    jsonModel(packageStorage.getAll)
  }

  get("/Sorted") {
    val sidx = parameter("sidx") withDefault ""
    val sord = parameter("sord") withDefault "asc"
    json(buildJSONResponse(sidx, sord, packageStorage.getAll))
  }

  post("/UpdateVisibility") {
    val id = parameter("id").intRequired
    val visibility = parameter("visibility").booleanRequired
    val updateAll = params.getOrElse("all", false).toString.toBoolean
    if (updateAll) for (manifest <- packageStorage.getAll) packageStorage.setVisibility(manifest.id, visibility)
    else packageStorage.setVisibility(id, visibility)
  }

  post("/UpdateTitle") {
    val id = parameter("id").intRequired
    val title = parameter("title").required
    val summary = parameter("summary").required
    val visibility = parameter("visibility").booleanRequired
    val operation = parameter("oper").required

    if (operation == "del") packageStorage.delete(id)
    else {
      packageStorage.setDescriptions(id, title, summary)
      packageStorage.setVisibility(id, visibility)
      json(Map("message" -> "", "id" -> id))
    }
  }

  post("/update/:id") {
    val id = parameter("id").intRequired
    val title = parameter("title").required
    val summary = parameter("summary").required
    val visibility = parameter("visibility").booleanRequired

    packageStorage.setDescriptions(id, title, summary)
    packageStorage.setVisibility(id, visibility)
    jsonModel(packageStorage.getByID(id))
  }

  post("/delete") {
    val id = parameter("id").intRequired
    val pkg = packageStorage.getByID(id)
    if (pkg.isDefined) {
      if (pkg.get.assetRefID.isDefined) AssetHelper.deletePackage(pkg.get.assetRefID.get)
      packageStorage.delete(id)
    }
  }

  private def buildJSONResponse(sidx: String, sord: String, sequence: Seq[Manifest]) = {
    // sorting
    val newSeq = sidx match {
      case "title" => sequence.sortWith((e1, e2) =>
        (if (sord.equals("asc")) e1.title.toLowerCase < e2.title.toLowerCase
        else e1.title.toLowerCase > e2.title.toLowerCase))
      // or by id
      case _ => sequence.sortWith((e1, e2) =>
        (if (sord.equals("asc")) e1.id < e2.id
        else e1.id > e2.id))
    }
    // create data structure for jqGrid
    Map("total" -> 1,
      "page" -> 0,
      "records" -> newSeq.size,
      "rows" -> newSeq.map(pack => Map("id" -> pack.id,
        "cell" -> List(pack.id, pack.title, pack.summary.getOrElse(""), pack.visibility))))
  }

}
