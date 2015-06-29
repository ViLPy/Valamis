package com.arcusys.learn.view.extensions

import java.io.FileNotFoundException

import com.arcusys.learn.service.util.MustacheSupport
import org.scalatra.ScalatraFilter

/**
 * Created by mminin on 27.05.15.
 */
trait BaseView
  extends ScalatraFilter
  with MustacheSupport
  with i18nSupport
  with ConfigurableView
  with TemplateCoupler {

  protected def getTranslation(view: String, language: String): Map[String, String] = {
    try {
      getTranslation("/i18n/" + view + "_" + language)
    } catch {
      case e: FileNotFoundException => getTranslation("/i18n/" + view + "_en")
      case _: Throwable             => Map[String, String]()
    }
  }
}
