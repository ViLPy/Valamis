package com.arcusys.learn.scorm.manifest.model

object ResourceUrl {

  //TODO: doesn't consider external links
  def apply(base: Option[String], resourcesBase: Option[String], resourceBase: Option[String], href: String, parameters: Option[String]) = {
    val resourceUrl = base.getOrElse("") + resourcesBase.getOrElse("") + resourceBase.getOrElse("") + href
    var strippedParameters = parameters.getOrElse("")
    while (strippedParameters.startsWith("?") || strippedParameters.startsWith("&")) strippedParameters = strippedParameters.substring(1)
    if (strippedParameters.isEmpty) resourceUrl
    else if (strippedParameters.startsWith("#")) {
      if (resourceUrl.contains("#")) resourceUrl else resourceUrl + strippedParameters
    } else {
      if (resourceUrl.contains("?")) resourceUrl + "&" + strippedParameters else resourceUrl + "?" + strippedParameters
    }
  }
}
