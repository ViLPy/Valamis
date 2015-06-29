package com.arcusys.learn.controllers.views

import com.arcusys.learn.ioc.Configuration
import com.escalatesoft.subcut.inject.Injectable

/**
 * Created with IntelliJ IDEA.
 * User: dkudinov
 * Date: 27.2.2013
 * Time: 15.00
 */
trait ConfigurableView extends Injectable {
  implicit val bindingModule = Configuration
}
