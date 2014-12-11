package com.arcusys.learn.controllers.auth

import org.scalatra.ScalatraBase
import org.scalatra.auth.strategy.BasicAuthStrategy

/**
 * Created by igorborisov on 31.10.14.
 */
abstract class LiferayBasicAuthStrategy[T <: AnyRef](protected override val app: ScalatraBase, realm: String) extends BasicAuthStrategy[T](app, realm) {

}
